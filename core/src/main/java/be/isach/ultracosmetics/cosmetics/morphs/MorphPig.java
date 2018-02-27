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
 * Represents an instance of a pig morph summoned by a player.
 *
 * @author iSach
 * @since 08-27-2015
 */
public class MorphPig extends Morph {

	private long coolDown = 0L;

	public MorphPig(UltraPlayer owner, UltraCosmetics ultraCosmetics) {
		super(owner, MorphType.valueOf("pig"), ultraCosmetics);
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
			SoundUtil.playSound(event.getPlayer().getLocation(), Sounds.PIG_IDLE);
			coolDown = System.currentTimeMillis() + 500;
		}
	}

	@Override
	protected void onClear() {
	}
}
