package top.methane39.AyachiNene.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import top.methane39.AyachiNene.AyachiNene;
import top.methane39.AyachiNene.item.ModItem;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output,  ExistingFileHelper existingFileHelper) {
        super(output, AyachiNene.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItem.DETONATOR);
        simpleItem(ModItem.DETONATOR_COMPONENT);
        simpleItem(ModItem.KOKORO_KAKERA);
        simpleItem(ModItem.RAMEN);

        withExistingParent(ModItem.NENE_SPAWN_EGG.getId().getPath(),mcLoc("item/template_spawn_egg"));
    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item){
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(AyachiNene.MODID,"item/"+item.getId().getPath()));
    }
}
