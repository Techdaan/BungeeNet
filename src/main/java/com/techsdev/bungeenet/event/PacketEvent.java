package com.techsdev.bungeenet.event;

import lombok.Getter;
import net.md_5.bungee.api.connection.Connection;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Cancellable;
import net.md_5.bungee.api.plugin.Event;
import net.md_5.bungee.protocol.DefinedPacket;

/**
 * An event called when packets are sent or received
 */
public class PacketEvent extends Event implements Cancellable {

    /**
     * Whether if the event should be cancelled. This cancels passing the packet on to the receiver
     */
    private boolean cancelled = false;

    /**
     * The packet of the message
     */
    @Getter private final DefinedPacket packet;

    /**
     * The player related to the packet stream
     */
    @Getter private final ProxiedPlayer player;

    /**
     * The sender of the packet
     */
    @Getter private final Connection sender;

    /**
     * The receiver of the packet
     */
    @Getter private final Connection receiver;

    /**
     * Creates a new PacketEventListener
     * @param packet The packet that is included in the message
     * @param player The player related to the packet stream
     * @param sender The sender of the packet
     * @param receiver The receiver of the packet
     */
    public PacketEvent(DefinedPacket packet, ProxiedPlayer player, Connection sender, Connection receiver) {
        this.packet = packet;
        this.player = player;
        this.sender = sender;
        this.receiver = receiver;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancelled = cancel;
    }
}
