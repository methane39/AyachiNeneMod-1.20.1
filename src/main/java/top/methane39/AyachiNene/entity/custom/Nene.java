package top.methane39.AyachiNene.entity.custom;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import top.methane39.AyachiNene.item.ModItem;
import top.methane39.AyachiNene.sound.ModSounds;


public class Nene extends Animal {

    public Nene(EntityType<? extends Animal> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
    }
    public final AnimationState walkAnimationState = new AnimationState();
    public final AnimationState onaniAnimationState = new AnimationState();

    @Override
    public void tick() {
        super.tick();

        if(this.level().isClientSide){

        }
    }


    private void setupAnimationStates(){

    }

    @Override
    protected void updateWalkAnimation(float pPartialTick) {
        float f;
        if(this.getPose() == Pose.STANDING){
            f= Math.min(pPartialTick*6F,1f);
        }else{
            f = 0f;
        }

        this.walkAnimation.update(f,0.2f);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0,new FloatGoal(this));

        this.goalSelector.addGoal(0,new BreedGoal(this,1.2D));

        this.goalSelector.addGoal(1,new TemptGoal(this,1.2D, Ingredient.of(ModItem.DETONATOR.get()),true));
        this.goalSelector.addGoal(1,new TemptGoal(this,1.2D, Ingredient.of(ModItem.RAMEN.get()),false));
        this.goalSelector.addGoal(2,new LookAtPlayerGoal(this, Player.class,3f));
        this.goalSelector.addGoal(3,new RandomLookAroundGoal(this));
    }

    public static AttributeSupplier.Builder createAttribute(){
        return Animal.createLivingAttributes()
                .add(Attributes.MAX_HEALTH,10D)
                .add(Attributes.FOLLOW_RANGE,24D)
                .add(Attributes.MOVEMENT_SPEED,0.2D)
                .add(Attributes.ARMOR_TOUGHNESS,0.1f);
    }
    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel pLevel, AgeableMob pOtherParent) {
        return null;
    }

    @Override
    public boolean isFood(ItemStack pStack) {
        return pStack.is(ModItem.RAMEN.get());
    }

    @Override
    public void kill() {
        super.kill();
    }


    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return ModSounds.NENE_DEAD.get();
    }



    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return ModSounds.GREETING.get();
    }
}
