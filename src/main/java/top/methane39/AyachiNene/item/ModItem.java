package top.methane39.AyachiNene.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import top.methane39.AyachiNene.AyachiNene;
import top.methane39.AyachiNene.item.custom.ExplodeAbleItem;
import top.methane39.AyachiNene.item.custom.FuelItem;

public class ModItem {
    public static final DeferredRegister<Item> MOD_ITEM =
            DeferredRegister.create(ForgeRegistries.ITEMS, AyachiNene.MODID);

    public static final RegistryObject<Item> DETONATOR_COMPONENT = MOD_ITEM.register("detonator_component",
            () ->new Item(new Item.Properties()));

    public static final RegistryObject<Item> DETONATOR = MOD_ITEM.register("detonator",
            () ->new ExplodeAbleItem(new Item.Properties(),16.0));

    public static final RegistryObject<Item> RAMEN = MOD_ITEM.register("ramen",
            () ->new Item(new Item.Properties().food(ModFood.RAMEN)));

    public static final RegistryObject<Item> KOKORO_KAKERA = MOD_ITEM.register("kokoro_kakera",
            () ->new FuelItem(new Item.Properties(),1200));

    public static void register(IEventBus eventBus){
        MOD_ITEM.register(eventBus);
    }
}
