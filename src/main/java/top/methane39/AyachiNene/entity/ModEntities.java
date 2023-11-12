package top.methane39.AyachiNene.entity;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import top.methane39.AyachiNene.AyachiNene;
import top.methane39.AyachiNene.entity.custom.Nene;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, AyachiNene.MODID);

    public static final RegistryObject<EntityType<Nene>> NENE =
            ENTITY_TYPES.register("nene",() ->EntityType.Builder.of(Nene::new, MobCategory.CREATURE)
                    .sized(0.8f,2.0f).build("nene"));
    public static void register(IEventBus eventBus){
        ENTITY_TYPES.register(eventBus);
    }
}
