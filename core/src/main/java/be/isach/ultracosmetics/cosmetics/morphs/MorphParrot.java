package be.isach.ultracosmetics.cosmetics.morphs;

import be.isach.ultracosmetics.UltraCosmetics;
import be.isach.ultracosmetics.cosmetics.type.MorphType;
import be.isach.ultracosmetics.player.UltraPlayer;
import be.isach.ultracosmetics.util.SoundUtil;
import be.isach.ultracosmetics.util.Sounds;
import org.bukkit.Sound;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

/**
 * Represents an instance of a parrot morph summoned by a player.
 *
 * @author RadBuilder
 * @since 07-03-2017
 */
public class MorphParrot extends Morph {
	private long coolDown = 0L;

	public MorphParrot(UltraPlayer owner, UltraCosmetics ultraCosmetics) {
		super(owner, MorphType.valueOf("parrot"), ultraCosmetics);
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
			event.getPlayer().playSound(getPlayer().getLocation(), Sound.ENTITY_PARROT_FLY, 0.4f, 1.0f);
			coolDown = System.currentTimeMillis() + 500;
		}
	}

	@Override
	public void onClear() {
	}
}