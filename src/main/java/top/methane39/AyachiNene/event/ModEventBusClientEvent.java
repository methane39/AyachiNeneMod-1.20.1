package top.methane39.AyachiNene.event;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import top.methane39.AyachiNene.AyachiNene;
import top.methane39.AyachiNene.entity.client.ModModelLayers;
import top.methane39.AyachiNene.entity.client.NeneModel;

@Mod.EventBusSubscriber(modid = AyachiNene.MODID,bus = Mod.EventBusSubscriber.Bus.MOD,value = Dist.CLIENT)
public class ModEventBusClientEvent {
    @SubscribeEvent
    public static void registerLayer(EntityRenderersEvent.RegisterLayerDefinitions event){
        event.registerLayerDefinition(ModModelLayers.NENE_LAYER, NeneModel::createBodyLayer);

    }
}
