package top.methane39.AyachiNene.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.common.Mod;
import org.jetbrains.annotations.Nullable;
import top.methane39.AyachiNene.AyachiNene;
import top.methane39.AyachiNene.block.ModBlock;
import top.methane39.AyachiNene.util.ModTag;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,  @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, AyachiNene.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(ModTag.Blocks.DETONATOR_VALUABLES)
                .add(ModBlock.DETONATOR_BLOCK.get(),ModBlock.DETONATOR_ORE.get());

        this.tag(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlock.DETONATOR_ORE.get());

        this.tag(Tags.Blocks.NEEDS_NETHERITE_TOOL)
                .add(ModBlock.DETONATOR_BLOCK.get());

        this.tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlock.DETONATOR_BLOCK.get(),ModBlock.DETONATOR_ORE.get());
    }
}
