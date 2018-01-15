package com.techsdev.bungeenet.pipeline;

import com.techsdev.bungeenet.channel.BungeecordConnection;
import com.techsdev.bungeenet.event.PacketEvent;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToMessageEncoder;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.Connection;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.protocol.DefinedPacket;

import java.util.List;

/**
 * Handles packets in the encoder pipeline to redirect all packets to the event handlers
 */
public class BungeePacketsEncoder extends MessageToMessageEncoder<DefinedPacket> {

    /**
     * The player associated with the decoder
     */
    private ProxiedPlayer player;

    /**
     * Whether the player is connected to a server
     */
    private boolean connectedToServer;

    public BungeePacketsEncoder(ProxiedPlayer player, boolean connectedToServer) {
        this.player = player;
        this.connectedToServer = connectedToServer;
    }

    @Override
    protected void encode(ChannelHandlerContext ctx, DefinedPacket packet, List<Object> out) throws Exception {
        Connection receiver = connectedToServer ? player.getServer() : player;
        PacketEvent evt = new PacketEvent(packet, player, new BungeecordConnection(ctx), receiver);

        ProxyServer.getInstance().getPluginManager().callEvent(evt);
        if (!evt.isCancelled()) {
            out.add(packet);
        }
    }

}
