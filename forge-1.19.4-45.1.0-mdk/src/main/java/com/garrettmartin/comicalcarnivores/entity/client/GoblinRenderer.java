package com.garrettmartin.comicalcarnivores.entity.client;

import com.garrettmartin.comicalcarnivores.ComicalCarnivores;
import com.garrettmartin.comicalcarnivores.entity.custom.GoblinEntity;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class GoblinRenderer extends GeoEntityRenderer<GoblinEntity> {
    public GoblinRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new GoblinModel());
    }

    @Override
    public ResourceLocation getTextureLocation(GoblinEntity animatable) {
        return new ResourceLocation(ComicalCarnivores.MOD_ID, "textures/entity/goblin.png");
    }

    @Override
    public void render(GoblinEntity entity, float entityYaw, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {
        if(entity.isBaby()) {
            poseStack.scale(0.4f, 0.4f, 0.4f);
        }

        super.render(entity, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}
