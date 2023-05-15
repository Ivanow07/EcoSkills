package com.willfp.ecoskills.libreforge

import com.willfp.eco.core.config.interfaces.Config
import com.willfp.ecoskills.api.event.PlayerSkillLevelUpEvent
import com.willfp.ecoskills.api.getSkillLevel
import com.willfp.ecoskills.skills.Skills
import com.willfp.libreforge.NoCompileData
import com.willfp.libreforge.arguments
import com.willfp.libreforge.conditions.Condition
import com.willfp.libreforge.updateEffects
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority

object ConditionHasSkillLevel : Condition<NoCompileData>("has_skill_level") {
    override val arguments = arguments {
        require("skill", "You must specify the skill!")
        require("level", "You must specify the skill level!")
    }

    override fun isMet(player: Player, config: Config, compileData: NoCompileData): Boolean {
        val skill = Skills.getByID(config.getString("skill").lowercase()) ?: return false

        return player.getSkillLevel(skill) >= config.getIntFromExpression("level", player)
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    fun handle(event: PlayerSkillLevelUpEvent) {
        event.player.updateEffects()
    }
}
