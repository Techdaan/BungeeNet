package com.techsdev.bungeenet.packets.protocol.game.client;

import com.techsdev.bungeenet.item.ItemStack;
import com.techsdev.bungeenet.packets.Packet;
import com.techsdev.bungeenet.util.BufferUtils;
import com.techsdev.bungeenet.window.Window;
import io.netty.buffer.ByteBuf;
import lombok.Getter;
import lombok.Setter;

/**
 * Sets the contents of a window
 *
 * @see <a href="http://wiki.vg/Protocol#Window_Items">http://wiki.vg/Protocol#Window_Items</a>
 */
public class SetWindowContentsPacket extends Packet {

    /**
     * The window to send
     */
    @Getter @Setter private Window window;

    /**
     * The window ID
     */
    @Getter @Setter private byte windowID;

    public SetWindowContentsPacket() {}

    public SetWindowContentsPacket(Window window) {
        this.window = window;
    }

    @Override
    public void read(ByteBuf buf) {
        //TODO Properly implement
        windowID = (byte) buf.readUnsignedByte();
        short size = buf.readShort();
        for(int i=0; i<size; i++)
            BufferUtils.readItemStack(buf);
    }

    @Override
    public void write(ByteBuf buf) {
        buf.writeByte(window.getId());
        buf.writeShort(window.getSlots());
        for (ItemStack stack : window.getContents()) {
            BufferUtils.writeItemStack(buf, stack);
        }
    }

}
