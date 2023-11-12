package top.methane39.AyachiNene.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.EntityGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import org.jetbrains.annotations.Nullable;
import top.methane39.AyachiNene.entity.custom.Nene;
import top.methane39.AyachiNene.util.ModTag;


import java.util.ArrayList;
import java.util.List;


public class ExplodeAbleItem extends Item {
    double explodeDetectRange = 0.0;
    public ExplodeAbleItem(Properties properties,double explodeRange){
        super(properties);
        this.explodeDetectRange = explodeRange;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        InteractionResultHolder interactionResultHolder = new InteractionResultHolder(InteractionResult.SUCCESS, this);
        ItemStack itemstack = pPlayer.getItemInHand(pUsedHand);

        EntityGetter entityGetter = pLevel;
        AABB pAABB = pPlayer.getBoundingBox();
        ArrayList mobs = (ArrayList) entityGetter.getEntities(pPlayer, new AABB(pAABB.minX - explodeDetectRange, pAABB.minY - explodeDetectRange, pAABB.minZ - explodeDetectRange,
                pAABB.maxX + explodeDetectRange, pAABB.maxY + explodeDetectRange, pAABB.maxZ + explodeDetectRange));

        for (int i = 0; i < mobs.size(); i++) {
            if (mobs.get(i) instanceof Nene) {
                double explodeX,explodeY,explodeZ;
                explodeX = ((Nene) mobs.get(i)).getX();
                explodeY = ((Nene) mobs.get(i)).getY();
                explodeZ = ((Nene) mobs.get(i)).getZ();
                pLevel.explode((Entity) mobs.get(i),explodeX,explodeY,explodeZ,9f,Level.ExplosionInteraction.TNT).explode();
                ((Nene) mobs.get(i)).kill();
            }
        }
        return interactionResultHolder.success(itemstack);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {

        BlockPos positionClicked = pContext.getClickedPos();
        Player player = pContext.getPlayer();
        BlockState state = pContext.getLevel().getBlockState(positionClicked);
        if(isValuableBlock(state)){
            pContext.getLevel().explode(player,positionClicked.getX(),positionClicked.getY(),positionClicked.getZ(),7f, Level.ExplosionInteraction.TNT).explode();
        }

        return InteractionResult.SUCCESS;
    }

    @Override
    public void appendHoverText(ItemStack pStack, @Nullable Level pLevel, List<Component> pTooltipComponents, TooltipFlag pIsAdvanced) {
        pTooltipComponents.add(Component.translatable("tooltips.ayachinene.detonator.tooltip"));
        super.appendHoverText(pStack, pLevel, pTooltipComponents, pIsAdvanced);
    }

    public boolean isValuableBlock(BlockState blockState){
        return blockState.is(ModTag.Blocks.DETONATOR_VALUABLES);
    }
}
