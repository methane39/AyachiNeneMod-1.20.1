package top.methane39.AyachiNene.sound;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraftforge.common.util.ForgeSoundType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import top.methane39.AyachiNene.AyachiNene;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, AyachiNene.MODID);

//    public static final ForgeSoundType NENE_SOUNDS = new ForgeSoundType(1f,1f,
//            ModSounds.NENE_DEAD,ModSounds.GREETING,ModSounds.ONANI);


    private static RegistryObject<SoundEvent> registerSoundEvents(String name){
        return SOUND_EVENTS.register(name, ()-> SoundEvent.createVariableRangeEvent(new ResourceLocation(AyachiNene.MODID,name)));
    }
    public static final RegistryObject<SoundEvent> ONANI = registerSoundEvents("onani");

    public static final RegistryObject<SoundEvent> GREETING = registerSoundEvents("ciallo");
    public static final RegistryObject<SoundEvent> NENE_DEAD = registerSoundEvents("nene_dead");
    public static void register(IEventBus eventBus){
        SOUND_EVENTS.register(eventBus);
    }
}
