package com.willfp.ecoskills.effects

import com.willfp.eco.core.config.interfaces.Config
import com.willfp.ecoskills.EcoSkillsPlugin
import com.willfp.ecoskills.LevellableWithHolder
import com.willfp.ecoskills.util.LevelMap
import org.bukkit.OfflinePlayer

class Effect(
    id: String,
    config: Config,
    plugin: EcoSkillsPlugin
) : LevellableWithHolder(id, config, plugin)


internal val OfflinePlayer.effects: LevelMap<Effect>
    get() = LevelMap(this)
