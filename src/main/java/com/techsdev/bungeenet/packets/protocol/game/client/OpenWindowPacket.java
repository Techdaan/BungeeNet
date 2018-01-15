package com.techsdev.bungeenet.packets.protocol.game.client;

import com.techsdev.bungeenet.packets.Packet;
import com.techsdev.bungeenet.window.Window;
import com.techsdev.bungeenet.window.WindowType;
import io.netty.buffer.ByteBuf;
import lombok.Getter;
import lombok.Setter;
import net.md_5.bungee.chat.ComponentSerializer;
import net.md_5.bungee.protocol.DefinedPacket;

/**
 * A packet to tell the client to open a window
 *
 * @see <a href="http://wiki.vg/Protocol#Open_Window">http://wiki.vg/Protocol#Open_Window</a>
 */
public class OpenWindowPacket extends Packet {

    /**
     * The window to open
     */
    @Getter @Setter private Window window;

    public OpenWindowPacket() {}

    public OpenWindowPacket(Window window) {
        this.window = window;
    }

    @Override
    public void read(ByteBuf buf) {
        byte id = (byte) buf.readUnsignedByte();
        String type = DefinedPacket.readString(buf);
        String title = DefinedPacket.readString(buf);
        byte slots = (byte) buf.readUnsignedByte();

        window = Window.of(id, WindowType.of(type), title, slots);
    }

    @Override
    public void write(ByteBuf buf) {
        buf.writeByte(window.getId());
        DefinedPacket.writeString(window.getType().getType(), buf);
        DefinedPacket.writeString(ComponentSerializer.toString(window.getTitle()), buf);
        buf.writeByte(window.getType().isStorage() ? window.getSlots() : 0);
    }

}
