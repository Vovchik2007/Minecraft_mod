package com.nocturne.client.render;

import com.nocturne.client.model.NocturnModel;
import com.nocturne.entity.NocturnEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class NocturnRenderer extends GeoEntityRenderer<NocturnEntity> {
    public NocturnRenderer(EntityRendererProvider.Context context) { super(context, new NocturnModel()); this.shadowRadius = 0.8F; }
}
