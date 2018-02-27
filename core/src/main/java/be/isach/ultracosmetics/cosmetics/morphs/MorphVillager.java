package be.isach.ultracosmetics.cosmetics.morphs;

import be.isach.ultracosmetics.UltraCosmetics;
import be.isach.ultracosmetics.UltraCosmeticsData;
import be.isach.ultracosmetics.cosmetics.type.MorphType;
import be.isach.ultracosmetics.player.UltraPlayer;
import be.isach.ultracosmetics.util.ItemFactory;
import be.isach.ultracosmetics.util.SoundUtil;
import be.isach.ultracosmetics.util.Sounds;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

/**
 * Represents an instance of a villager morph summoned by a player.
 *
 * @author RadBuilder
 * @since 07-03-2017
 */
public class MorphVillager extends Morph {
	private long coolDown = 0;

	public MorphVillager(UltraPlayer owner, UltraCosmetics ultraCosmetics) {
		super(owner, MorphType.valueOf("villager"), ultraCosmetics);
	}

	@EventHandler
	public void onLeftClick(PlayerInteractEvent event) {
		if ((event.getAction() == Action.LEFT_CLICK_AIR
				|| event.getAction() == Action.LEFT_CLICK_BLOCK) && event.getPlayer() == getPlayer()) {
			if (coolDown > System.currentTimeMillis()) return;
			event.setCancelled(true);
			SoundUtil.playSound(event.getPlayer(), Sounds.ORB_PICKUP);
			Item emerald = getPlayer().getWorld().dropItem(getPlayer().getEyeLocation(), ItemFactory.create(Material.EMERALD, (byte) 0x0, UltraCosmeticsData.get().getItemNoPickupString()));
			emerald.setPickupDelay(30000);
			emerald.setVelocity(getPlayer().getEyeLocation().getDirection().multiply(1.5));
			coolDown = System.currentTimeMillis() + 5000;
			Bukkit.getScheduler().runTaskLater(getUltraCosmetics(), emerald::remove, 80);
		}
	}

	@Override
	public void onUpdate() {
	}

	@Override
	protected void onClear() {
	}
}
