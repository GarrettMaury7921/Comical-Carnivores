package com.garrettmartin.comicalcarnivores.entity.client;

import com.garrettmartin.comicalcarnivores.ComicalCarnivores;
import com.garrettmartin.comicalcarnivores.entity.custom.GoblinEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

public class GoblinModel extends GeoModel<GoblinEntity> {
    @Override
    public ResourceLocation getModelResource(GoblinEntity animatable) {
        return new ResourceLocation(ComicalCarnivores.MOD_ID, "geo/goblin.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(GoblinEntity animatable) {
        return new ResourceLocation(ComicalCarnivores.MOD_ID, "textures/entity/goblin.png");
    }

    @Override
    public ResourceLocation getAnimationResource(GoblinEntity animatable) {
        return new ResourceLocation(ComicalCarnivores.MOD_ID, "animations/goblin.animation.json");
    }

    @Override
    public void setCustomAnimations(GoblinEntity animatable, long instanceId, AnimationState<GoblinEntity> animationState) {
        CoreGeoBone head = getAnimationProcessor().getBone("head");

        if (head != null) {
            EntityModelData entityData = animationState.getData(DataTickets.ENTITY_MODEL_DATA);

            head.setRotX(entityData.headPitch() * Mth.DEG_TO_RAD);
            head.setRotY(entityData.netHeadYaw() * Mth.DEG_TO_RAD);
        }

    }


}
