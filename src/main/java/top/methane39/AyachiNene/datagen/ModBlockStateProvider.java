package top.methane39.AyachiNene.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import top.methane39.AyachiNene.AyachiNene;
import top.methane39.AyachiNene.block.ModBlock;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, AyachiNene.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlock.DETONATOR_BLOCK);
        blockWithItem(ModBlock.DETONATOR_ORE);
    }
    private void blockWithItem(RegistryObject<Block> blockRegistryObject)   {
        simpleBlockWithItem(blockRegistryObject.get(),cubeAll(blockRegistryObject.get()));
    }
}
