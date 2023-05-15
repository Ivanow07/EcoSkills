package com.willfp.ecoskills.proxy.v1_18_R2

import com.willfp.eco.core.packet.PacketEvent
import com.willfp.ecoskills.actionbar.ActionBarCompatibilityProxy
import com.willfp.ecoskills.actionbar.pausePersistentActionBar
import net.minecraft.network.chat.ChatMessageType
import net.minecraft.network.protocol.game.ClientboundSetActionBarTextPacket
import net.minecraft.network.protocol.game.PacketPlayOutChat

class ActionBarCompatibility : ActionBarCompatibilityProxy {
    override fun onSend(event: PacketEvent) {
        val player = event.player

        when (val packet = event.packet.handle) {
            is ClientboundSetActionBarTextPacket -> player.pausePersistentActionBar()
            is PacketPlayOutChat -> if (packet.c() == ChatMessageType.c) player.pausePersistentActionBar()
        }
    }
}
