package top.methane39.AyachiNene.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import top.methane39.AyachiNene.AyachiNene;

public class ModTag {
    public static class Blocks{
        public static final TagKey<Block> DETONATOR_VALUABLES =tag("detonator_valuables");

        private static TagKey<Block> tag(String name){
            return BlockTags.create(new ResourceLocation(AyachiNene.MODID,name));
        }
    }
}
