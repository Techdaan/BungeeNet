package com.techsdev.bungeenet.packets.protocol.game.client;

import com.techsdev.bungeenet.item.ItemStack;
import com.techsdev.bungeenet.packets.Packet;
import com.techsdev.bungeenet.util.BufferUtils;
import com.techsdev.bungeenet.window.Window;
import io.netty.buffer.ByteBuf;
import lombok.Getter;
import lombok.Setter;

/**
 * Updates the contents of a single slot in a window
 *
 * @see <a href="http://wiki.vg/Protocol#Set_Slot">http://wiki.vg/Protocol#Set_Slot</a>
 */
public class SetWindowSlotPacket extends Packet {

    /**
     * The window whose slot to update
     */
    @Getter @Setter private Window window;

    /**
     * The window ID
     */
    @Getter @Setter private byte windowID;

    /**
     * The slot of the inventory to update
     */
    @Getter @Setter private short slot;

    /**
     * The new contents of the slot
     */
    @Getter @Setter private ItemStack newContents;

    public SetWindowSlotPacket() {}

    public SetWindowSlotPacket(Window window, short slot, ItemStack newContents) {
        this.window = window;
        this.slot = slot;
        this.newContents = newContents;
    }

    public SetWindowSlotPacket(byte window, short slot, ItemStack newContents) {
        this.windowID = window;
        this.slot = slot;
        this.newContents = newContents;
    }

    @Override
    public void read(ByteBuf buf) {
        //TODO Properly implement
        windowID = buf.readByte();
        buf.readShort();
        BufferUtils.readItemStack(buf);
    }

    @Override
    public void write(ByteBuf buf) {
        buf.writeByte(window == null ? windowID : window.getId());
        buf.writeShort(slot);
        BufferUtils.writeItemStack(buf, newContents);
    }

}
