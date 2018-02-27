package be.isach.ultracosmetics.cosmetics.morphs;

import be.isach.ultracosmetics.UltraCosmetics;
import be.isach.ultracosmetics.cosmetics.type.MorphType;
import be.isach.ultracosmetics.player.UltraPlayer;
import org.bukkit.Location;
import org.bukkit.util.Vector;

/**
 * Represents an instance of a polar bear morph summoned by a player.
 *
 * @author RadBuilder
 * @since 07-03-2017
 */
public class MorphPolarBear extends Morph {
	private long coolDown = 0;
	private boolean active;
	private Location location;
	private Vector vector;

	public MorphPolarBear(UltraPlayer owner, UltraCosmetics ultraCosmetics) {
		super(owner, MorphType.valueOf("polarbear"), ultraCosmetics);
	}

	/*@EventHandler
	public void onLeftClick(PlayerInteractEvent event) {
		if ((event.getAction() == Action.LEFT_CLICK_AIR || event.getAction() == Action.LEFT_CLICK_BLOCK)
				&& event.getPlayer() == getPlayer()) {
			if (coolDown > System.currentTimeMillis()) return;
			event.setCancelled(true);
			coolDown = System.currentTimeMillis() + 15000;
			vector = getPlayer().getLocation().getDirection().normalize().multiply(0.3);
			vector.setY(0);
			location = getPlayer().getLocation().subtract(0, 1, 0).add(vector);
			active = true;
			Bukkit.getScheduler().runTaskLater(getUltraCosmetics(), () -> active = false, 40);
		}
	}*/

	@Override
	public void onUpdate() {
		/*if (active) {
			if (location.getBlock().getType() != Material.AIR && location.getBlock().getType().isSolid()) {
				location.add(0, 1, 0);
			}

			if (location.clone().subtract(0, 1, 0).getBlock().getType() == Material.AIR) {
				if (location.clone().getBlock().getTypeId() != 43 && location.clone().getBlock().getTypeId() != 44)
					location.add(0, -1, 0);
			}

			for (int i = 0; i < 3; i++) {
				UltraCosmeticsData.get().getVersionManager().getEntityUtil()
						.sendBlizzard(getPlayer(), location, false, vector);
			}

			location.add(vector);
		} else {
			location = null;
			vector = null;
		}*/
	}

	@Override
	protected void onClear() {
		/*active = false;
		if (getOwner() != null && getPlayer() != null) {
			UltraCosmeticsData.get().getVersionManager().getEntityUtil().clearBlizzard(getPlayer());
		}*/
	}
}
