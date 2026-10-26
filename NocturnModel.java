package com.nocturne.client.model;

import com.nocturne.NocturneMod;
import com.nocturne.entity.NocturnEntity;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.core.animation.AnimationState;

public class NocturnModel extends GeoModel<NocturnEntity> {
    @Override
    public void setCustomAnimations(NocturnEntity entity, long instanceId, AnimationState<NocturnEntity> animationState) {
        super.setCustomAnimations(entity, instanceId, animationState);
        float power = (float) entity.getNightPower();
        // Day: compact cobblestone. Dusk: the block contracts while the guardian grows out of it.
        getBone("stone_block").ifPresent(bone -> {
            float blockScale = Math.max(0.001F, 1.0F - power * 0.92F);
            bone.setScaleX(blockScale);
            bone.setScaleY(blockScale);
            bone.setScaleZ(blockScale);
            bone.setHidden(power > 0.98F);
        });
        float bodyScale = Math.max(0.001F, 0.12F + power * 0.88F);
        for (String name : new String[] {"body", "head", "left_arm", "right_arm", "left_leg", "right_leg", "back_spikes"}) {
            getBone(name).ifPresent(bone -> {
                bone.setScaleX(bodyScale);
                bone.setScaleY(bodyScale);
                bone.setScaleZ(bodyScale);
                bone.setHidden(power < 0.08F);
            });
        }
    }

    @Override public ResourceLocation getModelResource(NocturnEntity animatable) { return new ResourceLocation(NocturneMod.MOD_ID, "geo/nocturn.geo.json"); }
    @Override public ResourceLocation getTextureResource(NocturnEntity animatable) { return new ResourceLocation(NocturneMod.MOD_ID, "textures/entity/nocturn.png"); }
    @Override public ResourceLocation getAnimationResource(NocturnEntity animatable) { return new ResourceLocation(NocturneMod.MOD_ID, "animations/nocturn.animation.json"); }
}
