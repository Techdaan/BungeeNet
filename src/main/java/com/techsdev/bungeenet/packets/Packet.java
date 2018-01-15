package com.techsdev.bungeenet.packets;

import io.netty.buffer.ByteBuf;
import net.md_5.bungee.protocol.AbstractPacketHandler;
import net.md_5.bungee.protocol.DefinedPacket;

/**
 * A packet in the network
 */
public abstract class Packet extends DefinedPacket {

    @Override
    public abstract void read(ByteBuf buf);

    @Override
    public abstract void write(ByteBuf buf);

    @Override
    public void handle(AbstractPacketHandler handler) throws Exception {

    }

    @Override
    public boolean equals(Object obj) {
        return false;
    }

    @Override
    public int hashCode() {
        return 0;
    }

    @Override
    public String toString() {
        return null;
    }
}
