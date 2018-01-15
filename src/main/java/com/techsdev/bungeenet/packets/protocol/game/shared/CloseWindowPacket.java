package com.techsdev.bungeenet.packets.protocol.game.shared;

import com.techsdev.bungeenet.packets.Packet;
import com.techsdev.bungeenet.window.Window;
import io.netty.buffer.ByteBuf;
import lombok.Getter;
import lombok.Setter;

/**
 * A packet involving the window closing
 * When sent from the server to the client, the client should close the window
 * When sent from the client to the server, the client informs the server of the window closing
 *
 * @see <a href="http://wiki.vg/Protocol#Close_Window_.28clientbound.29">Client-bound</a>
 * @see <a href="http://wiki.vg/Protocol#Close_Window_.28serverbound.29">Server-bound</a>
 */
public class CloseWindowPacket extends Packet {

    /**
     * The ID of the window
     * ID 0 is reserved for the player's inventory
     */
    @Getter @Setter private int windowID;

    public CloseWindowPacket() {}

    public CloseWindowPacket(Window window) {
        this.windowID = window.getId();
    }

    @Override
    public void read(ByteBuf buf) {
        windowID = buf.readUnsignedByte();
    }

    @Override
    public void write(ByteBuf buf) {
        buf.writeByte(windowID);
    }

}
