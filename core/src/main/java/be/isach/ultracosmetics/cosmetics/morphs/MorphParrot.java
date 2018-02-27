package be.isach.ultracosmetics.cosmetics.morphs;

import be.isach.ultracosmetics.UltraCosmetics;
import be.isach.ultracosmetics.cosmetics.type.MorphType;
import be.isach.ultracosmetics.player.UltraPlayer;

/**
 * Represents an instance of a parrot morph summoned by a player.
 *
 * @author RadBuilder
 * @since 07-03-2017
 */
public class MorphParrot extends Morph {
	public MorphParrot(UltraPlayer owner, UltraCosmetics ultraCosmetics) {
		super(owner, MorphType.valueOf("parrot"), ultraCosmetics);
	}

	@Override
	protected void onEquip() {
		super.onEquip();
		//getPlayer().setAllowFlight(true);
	}

	@Override
	public void onUpdate() {
	}

	/*@EventHandler
	public void onPlayerToggleFlight(PlayerToggleFlightEvent event) {
		if (event.getPlayer() == getPlayer()
		    && event.getPlayer().getGameMode() != GameMode.CREATIVE
		    && !event.getPlayer().isFlying()) {
			Vector v = event.getPlayer().getLocation().getDirection();
			v.setY(0.75);
			MathUtils.applyVelocity(getPlayer(), v);
			event.getPlayer().setFlying(false);
			event.setCancelled(true);
			event.getPlayer().playSound(event.getPlayer().getLocation(), Sound.ENTITY_PARROT_FLY, 0.4f, 1.0f);
		}
	}*/

	@Override
	public void onClear() {
		/*if (getPlayer().getGameMode() != GameMode.CREATIVE) {
			getPlayer().setAllowFlight(false);
		}*/
	}
}