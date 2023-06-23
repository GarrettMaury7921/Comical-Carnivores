package com.garrettmartin.comicalcarnivores.entity.custom;

import com.garrettmartin.comicalcarnivores.entity.ModEntities;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.GeoAnimatable;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.object.PlayState;


public class GoblinEntity extends Animal implements GeoEntity {

    // Attributes
    private final AnimatableInstanceCache cache = new SingletonAnimatableInstanceCache(this);

    public GoblinEntity(EntityType<? extends Animal> entityType, Level level) {
        super(entityType, level);
    }

    public static AttributeSupplier setAttributes() {
        return Animal.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 16D)
                .add(Attributes.ATTACK_DAMAGE, 3.0f)
                .add(Attributes.ATTACK_SPEED, 1.0f)
                .add(Attributes.MOVEMENT_SPEED, 0.4f).build();
    }

    @Override
    protected void registerGoals() {

        this.goalSelector.addGoal(1, new FloatGoal(this));
        /*  TY CHAT-GPT (AvoidEntityGoal)
            this: Refers to the instance of your custom mob.
            Player.class: The class of the entity to avoid, in this case, the player.
            8.0F: The maximum distance from the player at which the mob will start avoiding.
            1.2: The walking speed modifier when avoiding.
            1.6: The sprinting speed modifier when avoiding.
            (entity) -> entity instanceof Player && !entity.isSpectator(): The predicate that defines which entities to avoid. In this case, it avoids non-spectator players.
         */
        this.goalSelector.addGoal(2, new AvoidEntityGoal<>(this, Player.class, 12.0f, 1.05f, 1.5f, (entity) -> entity instanceof Player && !entity.isSpectator()));

        this.goalSelector.addGoal(3, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
    }
    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(new AnimationController<>(this, "controller", 0, this::predicate));
    }

    private <T extends GeoAnimatable> PlayState predicate(AnimationState<T> animationState) {
        if (animationState.isMoving()) {

            // Check if the mob is avoiding the player
            if (this.getNavigation().isDone() && this.getTarget() instanceof Player) {
                animationState.getController().setAnimation(RawAnimation.begin().then("animation.goblin.run", Animation.LoopType.LOOP));
            }

            else {
                animationState.getController().setAnimation(RawAnimation.begin().then("animation.goblin.walk", Animation.LoopType.LOOP));
            }

            return PlayState.CONTINUE;
        }

        animationState.getController().setAnimation(RawAnimation.begin().then("animation.goblin.idle", Animation.LoopType.LOOP));
        return PlayState.CONTINUE;
    }


    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel level, AgeableMob ageableMob) {
        return ModEntities.GOBLIN.get().create(level);
    }

}
