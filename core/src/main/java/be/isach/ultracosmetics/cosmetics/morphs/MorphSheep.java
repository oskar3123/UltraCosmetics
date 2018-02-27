package be.isach.ultracosmetics.cosmetics.morphs;

import be.isach.ultracosmetics.UltraCosmetics;
import be.isach.ultracosmetics.cosmetics.type.MorphType;
import be.isach.ultracosmetics.player.UltraPlayer;

import java.util.Random;

/**
 * Represents an instance of a sheep morph summoned by a player.
 *
 * @author RadBuilder
 * @since 07-03-2017
 */
public class MorphSheep extends Morph {
	private long coolDown = 0;
	private Random r = new Random();
	private int count = 0;

	public MorphSheep(UltraPlayer owner, UltraCosmetics ultraCosmetics) {
		super(owner, MorphType.valueOf("sheep"), ultraCosmetics);
	}

	/*@EventHandler
	public void onLeftClick(PlayerInteractEvent event) {
		if ((event.getAction() == Action.LEFT_CLICK_AIR
				|| event.getAction() == Action.LEFT_CLICK_BLOCK) && event.getPlayer() == getPlayer()) {
			if (coolDown > System.currentTimeMillis()) return;
			event.setCancelled(true);
			SoundUtil.playSound(event.getPlayer().getLocation(), Sounds.SHEEP_IDLE, 1.0F, 1.0F);
			SheepWatcher sheepWatcher = (SheepWatcher) getDisguise().getWatcher();
			count = 0;
			Bukkit.getScheduler().runTaskTimer(getUltraCosmetics(), () -> {
				if (count > 9) {
					cancel();
					return;
				}
				sheepWatcher.setColor(DyeColor.values()[r.nextInt(DyeColor.values().length)]);
				count++;
			}, 0, 2);
			coolDown = System.currentTimeMillis() + 3000;
		}
	}*/

	@Override
	public void onUpdate() {
	}

	@Override
	protected void onClear() {
	}
}
