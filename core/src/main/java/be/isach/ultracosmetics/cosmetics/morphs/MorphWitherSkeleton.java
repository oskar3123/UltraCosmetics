package be.isach.ultracosmetics.cosmetics.morphs;

import be.isach.ultracosmetics.UltraCosmetics;
import be.isach.ultracosmetics.cosmetics.type.MorphType;
import be.isach.ultracosmetics.player.UltraPlayer;

/**
 * @author iSach
 * @since 10-18-2015
 */
public class MorphWitherSkeleton extends Morph {
	boolean inCooldown;

	public MorphWitherSkeleton(UltraPlayer owner, UltraCosmetics ultraCosmetics) {
		super(owner, MorphType.valueOf("witherskeleton"), ultraCosmetics);
	}

	@Override
	public void onUpdate() {
	}

	/*@EventHandler(priority = EventPriority.HIGHEST)
	public void onSneak(PlayerToggleSneakEvent event) {
		if (event.getPlayer() == getPlayer() && !inCooldown) {
			inCooldown = true;
			Bukkit.getScheduler().runTaskLaterAsynchronously(getUltraCosmetics(), () -> inCooldown = false, 200);
			for (Entity ent : getPlayer().getNearbyEntities(3, 3, 3)) {
				if (ent instanceof Player || ent instanceof Creature)
					MathUtils.applyVelocity(ent, ent.getLocation().toVector().subtract(getPlayer().getLocation().toVector()).setY(1));
			}
			final List<Entity> items = new ArrayList<>();
			for (int i = 0; i < 20; i++) {
				Item bone = getPlayer().getWorld().dropItem(getPlayer().getLocation().add(Math.random() * 5.0D - 2.5D, Math.random() * 3.0D, Math.random() * 5.0D - 2.5D), ItemFactory.create(Material.BONE, (byte) 0, UltraCosmeticsData.get().getItemNoPickupString()));
				bone.setVelocity(MathUtils.getRandomVector());
				bone.setMetadata("UNPICKABLEUP", new FixedMetadataValue(getUltraCosmetics(), ""));
				items.add(bone);
			}
			Bukkit.getScheduler().runTaskLaterAsynchronously(getUltraCosmetics(), () -> {
				for (Entity bone : items)
					bone.remove();
				items.clear();
			}, 50);
			SoundUtil.playSound(getPlayer(), Sounds.SKELETON_HURT, 0.4f, (float) Math.random() + 1f);
		}
	}*/

	@Override
	protected void onClear() {
	}
}
