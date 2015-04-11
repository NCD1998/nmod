package com.ncd1998.nmod.World.Biomes.GlassTreeBiome;

import static net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.BIG_SHROOM;
import static net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.CACTUS;
import static net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.CLAY;
import static net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.DEAD_BUSH;
import static net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.FLOWERS;
import static net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.GRASS;
import static net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.LAKE_LAVA;
import static net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.LAKE_WATER;
import static net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.LILYPAD;
import static net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.PUMPKIN;
import static net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.REED;
import static net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.SAND;
import static net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.SAND_PASS2;
import static net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.SHROOM;
import static net.minecraftforge.event.terraingen.DecorateBiomeEvent.Decorate.EventType.TREE;

import java.util.Random;

import com.ncd1998.nmod.World.WorldGenMysticTree;

import net.minecraft.block.BlockFlower;
import net.minecraft.block.BlockStone;
import net.minecraft.block.material.Material;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeDecorator;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.gen.ChunkProviderSettings;
import net.minecraft.world.gen.GeneratorBushFeature;
import net.minecraft.world.gen.feature.WorldGenAbstractTree;
import net.minecraft.world.gen.feature.WorldGenBigMushroom;
import net.minecraft.world.gen.feature.WorldGenCactus;
import net.minecraft.world.gen.feature.WorldGenDeadBush;
import net.minecraft.world.gen.feature.WorldGenFlowers;
import net.minecraft.world.gen.feature.WorldGenLiquids;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraft.world.gen.feature.WorldGenPumpkin;
import net.minecraft.world.gen.feature.WorldGenReed;
import net.minecraft.world.gen.feature.WorldGenSand;
import net.minecraft.world.gen.feature.WorldGenWaterlily;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;
import net.minecraftforge.event.terraingen.TerrainGen;

public class GTBiomeDecorator extends BiomeDecorator{
	public GTBiomeDecorator()
    {
        this.sandGen = new WorldGenSand(Blocks.sand, 7);
        this.gravelAsSandGen = new WorldGenSand(Blocks.gravel, 6);
        this.yellowFlowerGen = new WorldGenFlowers(Blocks.red_flower, BlockFlower.EnumFlowerType.ALLIUM);
        this.mushroomBrownGen = new GeneratorBushFeature(Blocks.brown_mushroom);
        this.mushroomRedGen = new GeneratorBushFeature(Blocks.red_mushroom);
        this.bigMushroomGen = new WorldGenBigMushroom();
        this.reedGen = new WorldGenReed();
        this.cactusGen = new WorldGenCactus();
        this.waterlilyGen = new WorldGenWaterlily();
        this.flowersPerChunk = 20;
        this.grassPerChunk = 64;
        this.sandPerChunk = 1;
        this.sandPerChunk2 = 3;
        this.clayPerChunk = 1;
        this.treesPerChunk = 100;
        this.generateLakes = true;
    }
	public void decorate(World worldIn, Random p_180292_2_, BiomeGenBase p_180292_3_, BlockPos p_180292_4_)
    {
        if (this.currentWorld != null)
        {
            throw new RuntimeException("Already decorating");
        }
        else
        {
            this.currentWorld = worldIn;
            String s = worldIn.getWorldInfo().getGeneratorOptions();

            if (s != null)
            {
                this.chunkProviderSettings = ChunkProviderSettings.Factory.func_177865_a(s).func_177864_b();
            }
            else
            {
                this.chunkProviderSettings = ChunkProviderSettings.Factory.func_177865_a("").func_177864_b();
            }

            this.randomGenerator = p_180292_2_;
            this.field_180294_c = p_180292_4_;
            this.dirtGen = new WorldGenMinable(Blocks.dirt.getDefaultState(), this.chunkProviderSettings.dirtSize);
            this.gravelGen = new WorldGenMinable(Blocks.gravel.getDefaultState(), this.chunkProviderSettings.gravelSize);
            this.graniteGen = new WorldGenMinable(Blocks.stone.getDefaultState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.GRANITE), this.chunkProviderSettings.graniteSize);
            this.dioriteGen = new WorldGenMinable(Blocks.stone.getDefaultState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.DIORITE), this.chunkProviderSettings.dioriteSize);
            this.andesiteGen = new WorldGenMinable(Blocks.stone.getDefaultState().withProperty(BlockStone.VARIANT, BlockStone.EnumType.ANDESITE), this.chunkProviderSettings.andesiteSize);
            this.coalGen = new WorldGenMinable(Blocks.coal_ore.getDefaultState(), this.chunkProviderSettings.coalSize);
            this.ironGen = new WorldGenMinable(Blocks.iron_ore.getDefaultState(), this.chunkProviderSettings.ironSize);
            this.goldGen = new WorldGenMinable(Blocks.gold_ore.getDefaultState(), this.chunkProviderSettings.goldSize);
            this.redstoneGen = new WorldGenMinable(Blocks.redstone_ore.getDefaultState(), this.chunkProviderSettings.redstoneSize);
            this.diamondGen = new WorldGenMinable(Blocks.diamond_ore.getDefaultState(), this.chunkProviderSettings.diamondSize);
            this.lapisGen = new WorldGenMinable(Blocks.lapis_ore.getDefaultState(), this.chunkProviderSettings.lapisSize);
            this.genDecorations(p_180292_3_);
            this.currentWorld = null;
            this.randomGenerator = null;
        }
    }

    protected void genDecorations(BiomeGenBase p_150513_1_)
    {
        MinecraftForge.EVENT_BUS.post(new DecorateBiomeEvent.Pre(currentWorld, randomGenerator, field_180294_c));
        this.generateOres();
        int i;
        int j;
        int k;

        boolean doGen = TerrainGen.decorate(currentWorld, randomGenerator, field_180294_c, SAND);
        for (i = 0; doGen && i < this.sandPerChunk2; ++i)
        {
            j = this.randomGenerator.nextInt(16) + 8;
            k = this.randomGenerator.nextInt(16) + 8;
            this.sandGen.generate(this.currentWorld, this.randomGenerator, this.currentWorld.getTopSolidOrLiquidBlock(this.field_180294_c.add(j, 0, k)));
        }

        doGen = TerrainGen.decorate(currentWorld, randomGenerator, field_180294_c, CLAY);
        for (i = 0; doGen && i < this.clayPerChunk; ++i)
        {
            j = this.randomGenerator.nextInt(16) + 8;
            k = this.randomGenerator.nextInt(16) + 8;
            this.clayGen.generate(this.currentWorld, this.randomGenerator, this.currentWorld.getTopSolidOrLiquidBlock(this.field_180294_c.add(j, 0, k)));
        }

        doGen = TerrainGen.decorate(currentWorld, randomGenerator, field_180294_c, SAND_PASS2);
        for (i = 0; doGen && i < this.sandPerChunk; ++i)
        {
            j = this.randomGenerator.nextInt(16) + 8;
            k = this.randomGenerator.nextInt(16) + 8;
            this.gravelAsSandGen.generate(this.currentWorld, this.randomGenerator, this.currentWorld.getTopSolidOrLiquidBlock(this.field_180294_c.add(j, 0, k)));
        }

        i = this.treesPerChunk;

        if (this.randomGenerator.nextInt(10) == 0)
        {
            ++i;
        }

        int l;
        BlockPos blockpos;

        doGen = TerrainGen.decorate(currentWorld, randomGenerator, field_180294_c, TREE);
        for (j = 0; doGen && j < i; ++j)
        {
            k = this.randomGenerator.nextInt(16) + 8;
            l = this.randomGenerator.nextInt(16) + 8;
     	   WorldGenMysticTree tree = new WorldGenMysticTree(false, 7, randomGenerator.nextInt(16), randomGenerator.nextInt(16), false, Blocks.stained_glass, Blocks.stained_glass);
            tree.func_175904_e();
            blockpos = this.currentWorld.getHorizon(this.field_180294_c.add(k, 0, l));

            if (tree.generate(this.currentWorld, this.randomGenerator, blockpos))
            {
                tree.func_180711_a(this.currentWorld, this.randomGenerator, blockpos);
            }
        }

        doGen = TerrainGen.decorate(currentWorld, randomGenerator, field_180294_c, BIG_SHROOM);
        for (j = 0; doGen && j < this.bigMushroomsPerChunk; ++j)
        {
            k = this.randomGenerator.nextInt(16) + 8;
            l = this.randomGenerator.nextInt(16) + 8;
            this.bigMushroomGen.generate(this.currentWorld, this.randomGenerator, this.currentWorld.getHorizon(this.field_180294_c.add(k, 0, l)));
        }

        int i1;

        doGen = TerrainGen.decorate(currentWorld, randomGenerator, field_180294_c, FLOWERS);
        for (j = 0; doGen && j < this.flowersPerChunk; ++j)
        {
            k = this.randomGenerator.nextInt(16) + 8;
            l = this.randomGenerator.nextInt(16) + 8;
            i1 = nextInt(this.currentWorld.getHorizon(this.field_180294_c.add(k, 0, l)).getY() + 32);
            blockpos = this.field_180294_c.add(k, i1, l);
            BlockFlower.EnumFlowerType enumflowertype = p_150513_1_.pickRandomFlower(this.randomGenerator, blockpos);
            BlockFlower blockflower = enumflowertype.getBlockType().getBlock();

            if (blockflower.getMaterial() != Material.air)
            {
                this.yellowFlowerGen.setGeneratedBlock(blockflower, enumflowertype);
                this.yellowFlowerGen.generate(this.currentWorld, this.randomGenerator, blockpos);
            }
        }

        doGen = TerrainGen.decorate(currentWorld, randomGenerator, field_180294_c, GRASS);
        for (j = 0; doGen && j < this.grassPerChunk; ++j)
        {
            k = this.randomGenerator.nextInt(16) + 8;
            l = this.randomGenerator.nextInt(16) + 8;
            i1 = nextInt(this.currentWorld.getHorizon(this.field_180294_c.add(k, 0, l)).getY() * 2);
            p_150513_1_.getRandomWorldGenForGrass(this.randomGenerator).generate(this.currentWorld, this.randomGenerator, this.field_180294_c.add(k, i1, l));
        }

        doGen = TerrainGen.decorate(currentWorld, randomGenerator, field_180294_c, DEAD_BUSH);
        for (j = 0; doGen && j < this.deadBushPerChunk; ++j)
        {
            k = this.randomGenerator.nextInt(16) + 8;
            l = this.randomGenerator.nextInt(16) + 8;
            i1 = nextInt(this.currentWorld.getHorizon(this.field_180294_c.add(k, 0, l)).getY() * 2);
            (new WorldGenDeadBush()).generate(this.currentWorld, this.randomGenerator, this.field_180294_c.add(k, i1, l));
        }

        j = 0;

        doGen = TerrainGen.decorate(currentWorld, randomGenerator, field_180294_c, LILYPAD);
        while (doGen && j < this.waterlilyPerChunk)
        {
            k = this.randomGenerator.nextInt(16) + 8;
            l = this.randomGenerator.nextInt(16) + 8;
            i1 = nextInt(this.currentWorld.getHorizon(this.field_180294_c.add(k, 0, l)).getY() * 2);
            blockpos = this.field_180294_c.add(k, i1, l);

            while (true)
            {
                if (blockpos.getY() > 0)
                {
                    BlockPos blockpos3 = blockpos.down();

                    if (this.currentWorld.isAirBlock(blockpos3))
                    {
                        blockpos = blockpos3;
                        continue;
                    }
                }

                this.waterlilyGen.generate(this.currentWorld, this.randomGenerator, blockpos);
                ++j;
                break;
            }
        }

        doGen = TerrainGen.decorate(currentWorld, randomGenerator, field_180294_c, SHROOM);
        for (j = 0; doGen && j < this.mushroomsPerChunk; ++j)
        {
            if (this.randomGenerator.nextInt(4) == 0)
            {
                k = this.randomGenerator.nextInt(16) + 8;
                l = this.randomGenerator.nextInt(16) + 8;
                BlockPos blockpos2 = this.currentWorld.getHorizon(this.field_180294_c.add(k, 0, l));
                this.mushroomBrownGen.generate(this.currentWorld, this.randomGenerator, blockpos2);
            }

            if (this.randomGenerator.nextInt(8) == 0)
            {
                k = this.randomGenerator.nextInt(16) + 8;
                l = this.randomGenerator.nextInt(16) + 8;
                i1 = nextInt(this.currentWorld.getHorizon(this.field_180294_c.add(k, 0, l)).getY() * 2);
                blockpos = this.field_180294_c.add(k, i1, l);
                this.mushroomRedGen.generate(this.currentWorld, this.randomGenerator, blockpos);
            }
        }

        if (doGen && this.randomGenerator.nextInt(4) == 0)
        {
            j = this.randomGenerator.nextInt(16) + 8;
            k = this.randomGenerator.nextInt(16) + 8;
            l = nextInt(this.currentWorld.getHorizon(this.field_180294_c.add(j, 0, k)).getY() * 2);
            this.mushroomBrownGen.generate(this.currentWorld, this.randomGenerator, this.field_180294_c.add(j, l, k));
        }

        if (doGen && this.randomGenerator.nextInt(8) == 0)
        {
            j = this.randomGenerator.nextInt(16) + 8;
            k = this.randomGenerator.nextInt(16) + 8;
            l = nextInt(this.currentWorld.getHorizon(this.field_180294_c.add(j, 0, k)).getY() * 2);
            this.mushroomRedGen.generate(this.currentWorld, this.randomGenerator, this.field_180294_c.add(j, l, k));
        }

        doGen = TerrainGen.decorate(currentWorld, randomGenerator, field_180294_c, REED);
        for (j = 0; doGen && j < this.reedsPerChunk; ++j)
        {
            k = this.randomGenerator.nextInt(16) + 8;
            l = this.randomGenerator.nextInt(16) + 8;
            i1 = nextInt(this.currentWorld.getHorizon(this.field_180294_c.add(k, 0, l)).getY() * 2);
            this.reedGen.generate(this.currentWorld, this.randomGenerator, this.field_180294_c.add(k, i1, l));
        }

        for (j = 0; doGen && j < 10; ++j)
        {
            k = this.randomGenerator.nextInt(16) + 8;
            l = this.randomGenerator.nextInt(16) + 8;
            i1 = nextInt(this.currentWorld.getHorizon(this.field_180294_c.add(k, 0, l)).getY() * 2);
            this.reedGen.generate(this.currentWorld, this.randomGenerator, this.field_180294_c.add(k, i1, l));
        }

        doGen = TerrainGen.decorate(currentWorld, randomGenerator, field_180294_c, PUMPKIN);
        if (doGen && this.randomGenerator.nextInt(32) == 0)
        {
            j = this.randomGenerator.nextInt(16) + 8;
            k = this.randomGenerator.nextInt(16) + 8;
            l = nextInt(this.currentWorld.getHorizon(this.field_180294_c.add(j, 0, k)).getY() * 2);
            (new WorldGenPumpkin()).generate(this.currentWorld, this.randomGenerator, this.field_180294_c.add(j, l, k));
        }

        doGen = TerrainGen.decorate(currentWorld, randomGenerator, field_180294_c, CACTUS);
        for (j = 0; doGen && j < this.cactiPerChunk; ++j)
        {
            k = this.randomGenerator.nextInt(16) + 8;
            l = this.randomGenerator.nextInt(16) + 8;
            i1 = nextInt(this.currentWorld.getHorizon(this.field_180294_c.add(k, 0, l)).getY() * 2);
            this.cactusGen.generate(this.currentWorld, this.randomGenerator, this.field_180294_c.add(k, i1, l));
        }

        if (this.generateLakes)
        {
            BlockPos blockpos1;

            doGen = TerrainGen.decorate(currentWorld, randomGenerator, field_180294_c, LAKE_WATER);
            for (j = 0; doGen && j < 50; ++j)
            {
                blockpos1 = this.field_180294_c.add(this.randomGenerator.nextInt(16) + 8, this.randomGenerator.nextInt(this.randomGenerator.nextInt(248) + 8), this.randomGenerator.nextInt(16) + 8);
                (new WorldGenLiquids(Blocks.flowing_water)).generate(this.currentWorld, this.randomGenerator, blockpos1);
            }

            doGen = TerrainGen.decorate(currentWorld, randomGenerator, field_180294_c, LAKE_LAVA);
            for (j = 0; doGen && j < 20; ++j)
            {
                blockpos1 = this.field_180294_c.add(this.randomGenerator.nextInt(16) + 8, this.randomGenerator.nextInt(this.randomGenerator.nextInt(this.randomGenerator.nextInt(240) + 8) + 8), this.randomGenerator.nextInt(16) + 8);
                (new WorldGenLiquids(Blocks.flowing_lava)).generate(this.currentWorld, this.randomGenerator, blockpos1);
            }
        }

        MinecraftForge.EVENT_BUS.post(new DecorateBiomeEvent.Post(currentWorld, randomGenerator, field_180294_c));
    }
    private int nextInt(int i) { //Safety wrapper to prevent exceptions.
        if (i <= 1)
            return 0;
        return this.randomGenerator.nextInt(i);
   }
}
