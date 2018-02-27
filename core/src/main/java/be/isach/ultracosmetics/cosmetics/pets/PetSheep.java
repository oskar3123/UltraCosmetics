package be.isach.ultracosmetics.cosmetics.pets;

import be.isach.ultracosmetics.UltraCosmetics;
import be.isach.ultracosmetics.UltraCosmeticsData;
import be.isach.ultracosmetics.cosmetics.type.PetType;
import be.isach.ultracosmetics.player.UltraPlayer;
import be.isach.ultracosmetics.util.ItemFactory;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Sheep;
import org.bukkit.util.Vector;

import java.util.Random;

/**
 * Represents an instance of a sheep pet summoned by a player.
 *
 * @author iSach
 * @since 08-12-2015
 */
public class PetSheep extends Pet {
	
	Random r = new Random();
	
	public PetSheep(UltraPlayer owner, UltraCosmetics ultraCosmetics) {
		super(owner, ultraCosmetics, PetType.getByName("sheep"), ItemFactory.create(Material.WOOL, (byte) 0, UltraCosmeticsData.get().getItemNoPickupString()));
	}
	
	@Override
	public void onUpdate() {
		Sheep sheep = (Sheep) entity;
		Item drop = entity.getWorld().dropItem(sheep.getEyeLocation(), ItemFactory.create(Material.WOOL, (byte) r.nextInt(16), UltraCosmeticsData.get().getItemNoPickupString()));
		drop.setPickupDelay(30000);
		drop.setVelocity(new Vector(r.nextDouble() - 0.5, r.nextDouble() / 2.0 + 0.3, r.nextDouble() - 0.5).multiply(0.4));
		items.add(drop);
		Bukkit.getScheduler().runTaskLater(getUltraCosmetics(), () -> {
			drop.remove();
			items.remove(drop);
		}, 5);
	}
}
