package top.methane39.AyachiNene.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import top.methane39.AyachiNene.AyachiNene;
import top.methane39.AyachiNene.block.ModBlock;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, AyachiNene.MODID);

    public static final RegistryObject<CreativeModeTab> AYACHINENE_TAB = CREATIVE_MODE_TABS.register("ayachinene_tab",
            () -> CreativeModeTab.builder().icon(() ->new ItemStack(ModItem.DETONATOR.get()))
                    .title(Component.translatable("creativetab.ayachinene_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItem.DETONATOR_COMPONENT.get());
                        pOutput.accept(ModBlock.DETONATOR_BLOCK.get());
                        pOutput.accept(ModItem.RAMEN.get());
                        pOutput.accept(ModItem.KOKORO_KAKERA.get());
                        pOutput.accept(ModItem.NENE_SPAWN_EGG.get());

                        pOutput.accept(ModBlock.DETONATOR_ORE.get());
                        pOutput.accept(ModItem.DETONATOR.get());
                    })
                    .build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
