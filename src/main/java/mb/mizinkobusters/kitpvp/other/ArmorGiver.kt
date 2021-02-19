package mb.mizinkobusters.kitpvp.other

import amata1219.niflheimr.dsl.InventoryUI
import org.bukkit.event.EventPriority
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import amata1219.niflheimr.dsl.InventoryLayout
import amata1219.niflheimr.dsl.component.format.InventoryLines
import amata1219.niflheimr.dsl.component.slot.Slot
import org.bukkit.Material
import amata1219.niflheimr.event.InventoryUIClickEvent
import mb.mizinkobusters.kitpvp.other.ArmorGiver
import org.bukkit.enchantments.Enchantment
import mb.mizinkobusters.kitpvp.utils.KitPvPUtils
import org.bukkit.potion.PotionEffect
import org.bukkit.potion.PotionEffectType
import org.bukkit.inventory.meta.PotionMeta
import org.bukkit.potion.PotionData
import org.bukkit.potion.PotionType
import org.bukkit.inventory.meta.LeatherArmorMeta
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.event.player.PlayerRespawnEvent
import mb.mizinkobusters.kitpvp.utils.PlayerSalvationUtils
import org.bukkit.event.entity.EntityDamageByEntityEvent
import org.bukkit.entity.EntityType
import org.bukkit.entity.Arrow
import org.bukkit.Sound
import org.bukkit.event.player.PlayerItemConsumeEvent
import org.bukkit.event.entity.EntityDamageEvent
import org.bukkit.event.player.PlayerFishEvent
import org.bukkit.World
import org.bukkit.Bukkit
import org.bukkit.inventory.PlayerInventory
import org.bukkit.event.player.PlayerTeleportEvent
import org.bukkit.event.entity.ProjectileHitEvent
import org.bukkit.entity.Projectile
import java.io.File
import java.math.BigDecimal
import org.bukkit.configuration.file.FileConfiguration
import org.bukkit.configuration.file.YamlConfiguration
import org.bukkit.event.entity.EntityDamageEvent.DamageCause
import java.util.HashMap
import java.util.UUID
import org.bukkit.event.entity.PlayerDeathEvent
import org.bukkit.event.player.PlayerMoveEvent
import org.bukkit.block.BlockFace
import org.bukkit.plugin.java.JavaPlugin
import org.bukkit.event.player.PlayerToggleSneakEvent
import org.bukkit.metadata.FixedMetadataValue
import org.bukkit.scheduler.BukkitRunnable
import mb.mizinkobusters.kitpvp.gui.KitMenu
import mb.mizinkobusters.kitpvp.gui.KitPurchaseMenu
import mb.mizinkobusters.kitpvp.listener.PlayerDeathListener
import mb.mizinkobusters.kitpvp.listener.PlayerRespawnListener
import mb.mizinkobusters.kitpvp.listener.VoidWalkingListener
import mb.mizinkobusters.kitpvp.kit.Archer
import mb.mizinkobusters.kitpvp.kit.Astronaut
import mb.mizinkobusters.kitpvp.kit.Berserker
import mb.mizinkobusters.kitpvp.kit.Blizzard
import mb.mizinkobusters.kitpvp.kit.Boxer
import mb.mizinkobusters.kitpvp.kit.Comet
import mb.mizinkobusters.kitpvp.kit.Fighter
import mb.mizinkobusters.kitpvp.kit.Fisherman
import mb.mizinkobusters.kitpvp.kit.Flame
import mb.mizinkobusters.kitpvp.kit.HealthBoost
import mb.mizinkobusters.kitpvp.kit.PotionHandler
import mb.mizinkobusters.kitpvp.kit.Revive
import mb.mizinkobusters.kitpvp.kit.Sniper
import mb.mizinkobusters.kitpvp.kit.Standard
import mb.mizinkobusters.kitpvp.kit.Tank
import mb.mizinkobusters.kitpvp.kit.Thunder
import mb.mizinkobusters.kitpvp.other.ArrowsRemover
import mb.mizinkobusters.kitpvp.other.FieldSender
import mb.mizinkobusters.kitpvp.other.MatchResultAnnounce

class ArmorGiver(val player: Player, helmet: Material, chest: Material, leg: Material, boots: Material) {
    private val pi: PlayerInventory
    val helmet: Material
    val chest: Material
    val leg: Material
    val boots: Material
    fun equip() {
        // TODO エンチャントなどの対応
        pi.helmet = ItemStack(helmet)
        pi.chestplate = ItemStack(chest)
        pi.leggings = ItemStack(leg)
        pi.boots = ItemStack(boots)
    }

    init {
        pi = player.inventory
        this.helmet = helmet
        this.chest = chest
        this.leg = leg
        this.boots = boots
    }
}