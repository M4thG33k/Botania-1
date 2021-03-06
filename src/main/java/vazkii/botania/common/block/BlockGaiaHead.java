/**
 * This class was created by <Vazkii>. It's distributed as
 * part of the Botania Mod. Get the Source Code in github:
 * https://github.com/Vazkii/Botania
 * 
 * Botania is Open Source and distributed under the
 * Botania License: http://botaniamod.net/license.php
 * 
 * File Created @ [Sep 23, 2015, 11:44:35 PM (GMT)]
 */
package vazkii.botania.common.block;

import net.minecraft.block.BlockSkull;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntitySkull;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import vazkii.botania.common.block.tile.TileGaiaHead;
import vazkii.botania.common.item.ModItems;
import vazkii.botania.common.lib.LibBlockNames;
import vazkii.botania.common.lib.LibMisc;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BlockGaiaHead extends BlockSkull {

	public BlockGaiaHead() {
		GameRegistry.register(this, new ResourceLocation(LibMisc.MOD_ID, LibBlockNames.GAIA_HEAD));
		setUnlocalizedName(LibBlockNames.GAIA_HEAD);
		setHardness(1.0F);
	}

	@Nonnull
	@Override
	public ItemStack getPickBlock(@Nonnull IBlockState state, RayTraceResult target, @Nonnull World world, @Nonnull BlockPos pos, EntityPlayer player) {
		return new ItemStack(ModItems.gaiaHead);
	}

    @Nonnull
	@Override
    public List<ItemStack> getDrops(@Nonnull IBlockAccess world, @Nonnull BlockPos pos, IBlockState state, int fortune) {
        ArrayList<ItemStack> ret = new ArrayList<>();
        
        if(!state.getValue(NODROP)) {
            ItemStack itemstack = new ItemStack(ModItems.gaiaHead, 1);
            TileEntitySkull tileentityskull = (TileEntitySkull)world.getTileEntity(pos);

            if(tileentityskull == null) 
            	return ret;

            ret.add(itemstack);
        }
        return ret;
    }
	
	@Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return ModItems.gaiaHead;
    }

	@Override
	public int damageDropped(IBlockState state) {
		return 0;
	}

	@Nonnull
	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileGaiaHead();
	}
}
