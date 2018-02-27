package be.isach.ultracosmetics.cosmetics.morphs;

import be.isach.ultracosmetics.UltraCosmetics;
import be.isach.ultracosmetics.cosmetics.type.MorphType;
import be.isach.ultracosmetics.player.UltraPlayer;
import be.isach.ultracosmetics.util.MathUtils;
import be.isach.ultracosmetics.util.SoundUtil;
import be.isach.ultracosmetics.util.Sounds;
import org.bukkit.GameMode;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerToggleFlightEvent;
import org.bukkit.util.Vector;

/**
 * Represents an instance of a bat morph summoned by a player.
 *
 * @author iSach
 * @since 08-26-2015
 */
public class MorphBat extends Morph {

    private long coolDown = 0;

	public MorphBat(UltraPlayer owner, UltraCosmetics ultraCosmetics) {
		super(owner, MorphType.valueOf("bat"), ultraCosmetics);
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
			SoundUtil.playSound(getPlayer(), Sounds.BAT_LOOP, 0.4f, 1.0f);
            coolDown = System.currentTimeMillis() + 500;
		}
	}

	@Override
	public void onClear() {
	}
}