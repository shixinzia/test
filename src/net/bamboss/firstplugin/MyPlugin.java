package net.bamboss.firstplugin;

import org.bukkit.Bukkit;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class MyPlugin extends JavaPlugin implements Listener {
        @Override
        public void onEnable() {
            getServer().getPluginManager().registerEvents(this, this);
        }

        @EventHandler
        public void onPlayerJoin(PlayerJoinEvent event) {
            Player player = event.getPlayer();
            if (player.hasPermission("bambossparticle.firework")) {
                // 如果玩家有 "bambossparticle.firework" 权限，则给玩家烟花火花效果
                player.spawnParticle(Particle.FIREWORKS_SPARK, player.getLocation(), 50, 0.5, 2, 0.5);
            } else {
                // 如果玩家没有 "bambossparticle.firework" 权限，则给玩家愤怒的村民效果
                player.spawnParticle(Particle.VILLAGER_ANGRY, player.getLocation(), 50, 0.5, 2, 0.5);
            }
        }
    }