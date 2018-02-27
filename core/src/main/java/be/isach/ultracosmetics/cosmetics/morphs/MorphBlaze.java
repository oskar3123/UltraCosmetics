package be.isach.ultracosmetics.cosmetics.morphs;

import be.isach.ultracosmetics.UltraCosmetics;
import be.isach.ultracosmetics.cosmetics.type.MorphType;
import be.isach.ultracosmetics.player.UltraPlayer;
import be.isach.ultracosmetics.util.SoundUtil;
import be.isach.ultracosmetics.util.Sounds;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

/**
 * Represents an instance of a blaze morph summoned by a player.
 *
 * @author iSach
 * @since 08-26-2015
 */
public class MorphBlaze extends Morph {

	private long coolDown = 0;

	public MorphBlaze(UltraPlayer owner, UltraCosmetics ultraCosmetics) {
		super(owner, MorphType.valueOf("blaze"), ultraCosmetics);
	}

	@Override
	public void onUpdate() {
	}

	@EventHandler
	public void onLeftClick(PlayerInteractEvent event) {
		if ((event.getAction() == Action.LEFT_CLICK_AIR
				|| event.getAction() == Action.LEFT_CLICK_BLOCK) && event.getPlayer() == getPlayer()) {
			if (coolDown > System.currentTimeMillis()) return;
			event.setCancelled(true);
			SoundUtil.playSound(getPlayer(), Sounds.FIZZ, 0.4f, 1.0f);
			coolDown = System.currentTimeMillis() + 500;
		}
	}

	@Override
	protected void onClear() {
	}
}
