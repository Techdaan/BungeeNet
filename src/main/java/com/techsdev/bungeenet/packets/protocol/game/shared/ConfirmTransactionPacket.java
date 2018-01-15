package com.techsdev.bungeenet.packets.protocol.game.shared;

import com.techsdev.bungeenet.packets.Packet;
import com.techsdev.bungeenet.window.Window;
import io.netty.buffer.ByteBuf;
import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

/**
 * A packet to confirm a transaction in a Window
 *
 * @see <a href="http://wiki.vg/Protocol#Confirm_Transaction_.28clientbound.29">Client-bound</a>
 * @see <a href="http://wiki.vg/Protocol#Confirm_Transaction_.28serverbound.29">Server-bound</a>
 */
public class ConfirmTransactionPacket extends Packet {

    /**
     * The window - this may be null if the window is not registered in this BungeeCord instance
     */
    @Getter @Setter private Optional<Window> window = Optional.empty();

    /**
     * The window ID
     */
    @Getter @Setter private byte windowID;

    /**
     * The action number of the transaction
     */
    @Getter @Setter private short actionNumber;

    /**
     * Whether if the action was accepted or not
     */
    @Getter @Setter private boolean accepted;

    public ConfirmTransactionPacket() {}

    public ConfirmTransactionPacket(Window window, short actionNumber, boolean accepted) {
        this.windowID = (byte) window.getId();
        this.actionNumber = actionNumber;
        this.accepted = accepted;
    }

    @Override
    public void read(ByteBuf buf) {
        this.windowID = buf.readByte();
        this.actionNumber = buf.readShort();
        this.accepted = buf.readBoolean();

        //TODO "Insert" Window optional
    }

    @Override
    public void write(ByteBuf buf) {
        buf.writeByte(window.isPresent() ? window.get().getId() : windowID);
        buf.writeShort(actionNumber);
        buf.writeBoolean(accepted);
    }
}
