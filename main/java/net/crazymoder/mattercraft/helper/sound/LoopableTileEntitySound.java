package net.crazymoder.mattercraft.helper.sound;

import net.crazymoder.mattercraft.interfaces.INoisyTileEntity;
import net.minecraft.client.audio.ITickableSound;
import net.minecraft.client.audio.PositionedSound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class LoopableTileEntitySound extends PositionedSound implements ITickableSound {
	protected boolean donePlaying = false;
	private TileEntity tileEntity;
	private INoisyTileEntity noisyTile;
	
	public LoopableTileEntitySound(ResourceLocation path, TileEntity tileEntity, float volume, float pitch) {
		super(path);
		this.repeat = true;
		this.tileEntity = tileEntity;
		this.noisyTile = (INoisyTileEntity) tileEntity;
		this.volume = volume;
		this.field_147663_c = pitch;
		this.xPosF = tileEntity.xCoord;
		this.yPosF = tileEntity.yCoord;
		this.zPosF = tileEntity.zCoord;
		this.field_147665_h = 0;
	}
	
	public LoopableTileEntitySound(String path, TileEntity tileEntity, float volume, float pitch) {
		this(new ResourceLocation(path), tileEntity, volume, pitch);
	}

	@Override
	public void update() {	
		if (this.tileEntity.isInvalid()) {
			this.donePlaying = true;
		}else{
			if(noisyTile.isplaying()){
				volume = noisyTile.getVolume();
			}else{
				volume = 0f;
			}
			this.field_147663_c = noisyTile.getPitch();
		}	
	}

	@Override
	public boolean isDonePlaying() {
		return this.donePlaying;
	}
}