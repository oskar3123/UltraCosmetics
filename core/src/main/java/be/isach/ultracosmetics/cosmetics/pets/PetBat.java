package be.isach.ultracosmetics.cosmetics.pets;

import be.isach.ultracosmetics.UltraCosmetics;
import be.isach.ultracosmetics.UltraCosmeticsData;
import be.isach.ultracosmetics.cosmetics.type.PetType;
import be.isach.ultracosmetics.player.UltraPlayer;
import be.isach.ultracosmetics.util.ItemFactory;
import org.bukkit.Material;

/**
 * Represents an instance of a bat pet summoned by a player.
 *
 * @author RadBuilder
 * @since 07-02-2017
 */
public class PetBat extends Pet {
	public PetBat(UltraPlayer owner, UltraCosmetics ultraCosmetics) {
		super(owner, ultraCosmetics, PetType.getByName("bat"), ItemFactory.create(Material.COAL, (byte) 0x0, UltraCosmeticsData.get().getItemNoPickupString()));
	}
}
