package com.willfp.ecoskills.proxy.v1_19_R3

import com.willfp.eco.core.packet.PacketEvent
import com.willfp.ecoskills.actionbar.ActionBarCompatibilityProxy
import net.minecraft.network.protocol.game.ClientboundSetActionBarTextPacket
import com.willfp.ecoskills.actionbar.pausePersistentActionBar
import net.minecraft.network.protocol.game.ClientboundSystemChatPacket

class ActionBarCompatibility : ActionBarCompatibilityProxy {
    override fun onSend(event: PacketEvent) {
        val player = event.player

        when (val packet = event.packet.handle) {
            is ClientboundSetActionBarTextPacket -> player.pausePersistentActionBar()
            is ClientboundSystemChatPacket -> if (packet.c()) player.pausePersistentActionBar()
        }
    }
}
