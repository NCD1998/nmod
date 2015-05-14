package com.ncd1998.nmod.Blocks;
 
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.ncd1998.nmod.nmod;


public class LightningBlock extends NBlock 
{
	private final String name = "LightningBlock";
	public LightningBlock()
	{
		super(Material.fire);
		GameRegistry.registerBlock(this, name);
		setUnlocalizedName(nmod.MODID + "_" + name);
		setHardness(0F);
		setResistance(0F);
		this.setLightLevel(15F);
		this.setTickRandomly(true);
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.75F, 1.0F);
	}
	public String getName()
	{
		return name;
	}
	@Override
	public boolean isOpaqueCube()
    {
        return true;
    }
	@Override
    public boolean isFullCube()
    {
        return true;
    }
	@Override
	public int quantityDropped(Random random)
    {
        return 0;
    }
	@Override
	public boolean isCollidable()
    {
        return true;
    }
	@Override
	@SideOnly(Side.CLIENT)
    public EnumWorldBlockLayer getBlockLayer()
    {
        return EnumWorldBlockLayer.CUTOUT;
    }
	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
		//Do lightning thing
		if(worldIn.isRemote){
			worldIn.spawnParticle(EnumParticleTypes.FLAME, pos.getX(), pos.getY(), pos.getZ(), 0, 0, 0);
		}
		//Check to see if it should exist
		if(worldIn.getWorldTime() < 13000){
			worldIn.setBlockToAir(pos);
			if(worldIn.isRemote){
				nmod.Proxy.genererateBurst(pos, worldIn, EnumParticleTypes.CRIT_MAGIC);
			}
		}
		if(rand.nextInt(2) == 0){
			int temp = rand.nextInt(5);
			if(temp == 0){
				if(worldIn.getBlockState(pos.up()).equals(Blocks.air)){
					worldIn.setBlockState(pos.up(), this.getDefaultState());
					worldIn.setBlockToAir(pos);
				}else{
					temp++;
				}
			}else if(temp == 1){
				if(worldIn.getBlockState(pos.north()).equals(Blocks.air)){
					worldIn.setBlockState(pos.north(), this.getDefaultState());
					worldIn.setBlockToAir(pos);
				}else{
					temp++;
				}
			}else if(temp == 2){
				if(worldIn.getBlockState(pos.east()).equals(Blocks.air)){
					worldIn.setBlockState(pos.east(), this.getDefaultState());
					worldIn.setBlockToAir(pos);
				}else{
					temp++;
				}
				
			}else if(temp == 3){
				if(worldIn.getBlockState(pos.south()).equals(Blocks.air)){
					worldIn.setBlockState(pos.south(), this.getDefaultState());
					worldIn.setBlockToAir(pos);
				}else{
					temp++;
				}
			}else if(temp == 4){
				if(worldIn.getBlockState(pos.west()).equals(Blocks.air)){
					worldIn.setBlockState(pos.west(), this.getDefaultState());
					worldIn.setBlockToAir(pos);
				}else{
					temp++;
				}
				
			}else if(temp == 5){
				if(worldIn.getBlockState(pos.down()).equals(Blocks.air)){
					worldIn.setBlockState(pos.down(), this.getDefaultState());
					worldIn.setBlockToAir(pos);
				}else{
					temp++;
				}
			}else{
				worldIn.setBlockToAir(pos);
				nmod.Proxy.genererateBurst(pos, worldIn, EnumParticleTypes.CRIT_MAGIC);
			}
		}
		if(rand.nextInt(10) == 0){
			worldIn.setBlockToAir(pos);
		}
	}
	@Override
	public void onEntityCollidedWithBlock(World worldIn, BlockPos pos, Entity entityIn) {
		
		nmod.Proxy.genererateBurst(pos, worldIn, EnumParticleTypes.CRIT_MAGIC);
		entityIn.attackEntityFrom(DamageSource.lightningBolt, 10);
		worldIn.setBlockToAir(pos);
	}
}