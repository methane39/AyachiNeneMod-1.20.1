package top.methane39.AyachiNene.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import top.methane39.AyachiNene.AyachiNene;
import top.methane39.AyachiNene.entity.custom.Nene;

public class NeneRenderer extends MobRenderer<Nene,NeneModel<Nene>> {

    public NeneRenderer(EntityRendererProvider.Context pContext) {
        super(pContext,new NeneModel<>(pContext.bakeLayer(ModModelLayers.NENE_LAYER)), 0.2f);
    }

    @Override
    public ResourceLocation getTextureLocation(Nene pEntity) {
        return new ResourceLocation(AyachiNene.MODID,"textures/entity/nene.png");
    }

    @Override
    public void render(Nene pEntity, float pEntityYaw, float pPartialTicks, PoseStack pMatrixStack, MultiBufferSource pBuffer, int pPackedLight) {
        if(pEntity.isBaby()){
            pMatrixStack.scale(0.5f,0.5f,0.5f);
        }

        super.render(pEntity, pEntityYaw, pPartialTicks, pMatrixStack, pBuffer, pPackedLight);
    }
}
