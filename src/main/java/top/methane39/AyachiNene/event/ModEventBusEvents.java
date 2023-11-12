package top.methane39.AyachiNene.event;

import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import top.methane39.AyachiNene.AyachiNene;
import top.methane39.AyachiNene.entity.ModEntities;
import top.methane39.AyachiNene.entity.custom.Nene;

@Mod.EventBusSubscriber(modid = AyachiNene.MODID,bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event){
        event.put(ModEntities.NENE.get(), Nene.createAttribute().build());
    }
}
