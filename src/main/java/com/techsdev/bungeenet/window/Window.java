package com.techsdev.bungeenet.window;

import com.techsdev.bungeenet.item.ItemStack;
import com.techsdev.bungeenet.packets.protocol.game.client.SetWindowSlotPacket;
import lombok.Getter;
import lombok.Setter;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.api.connection.ProxiedPlayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * Represents a window that can be closed and opened
 */
public abstract class Window {

    /**
     * A list of all viewers of this inventory
     */
    @Getter protected final List<UUID> viewers = new ArrayList<>();

    /**
     * The type of the window
     */
    @Getter private final WindowType type;

    /**
     * The ID of the Window
     */
    @Getter private final int id;

    /**
     * The title of the window
     */
    @Getter @Setter protected TextComponent title;

    /**
     * The amount of slots in the window
     */
    @Getter protected int slots = 0;

    /**
     * The action number
     */
    protected short actionNumber = 0;

    /**
     * Opens the window for a specified player
     * @param player The player to open the window for
     */
    public abstract void open(ProxiedPlayer player);

    /**
     * Retrieves an item from the window at the specified slot
     * @param slot The slot number to get the item from
     * @return The item that was in the slot
     */
    public abstract ItemStack get(int slot);

    /**
     * Sets the item in a specified slot
     * @param slot The slot number to update
     * @param item The item that should be in the slot
     */
    public abstract void set(int slot, ItemStack item);

    /**
     * Sends a block update to the current viewers of the window
     * @param slot The slot to be updated
     */
    protected void sendUpdate(int slot) {
        SetWindowSlotPacket packet = new SetWindowSlotPacket(this, (short) slot, get(slot));

        viewers.forEach(uuid -> {
            ProxiedPlayer player = ProxyServer.getInstance().getPlayer(uuid);
            if(player != null)
                player.unsafe().sendPacket(packet);
        });
    }

    /**
     * @return The full contents of the inventory
     */
    public abstract ItemStack[] getContents();

    /**
     * @return The next action number which can be used to cancel events
     */
    public short getNextActionNumber() {
        actionNumber += 1;
        if(actionNumber > Short.MAX_VALUE-1)
            actionNumber = 1;

        return actionNumber;
    }

    public Window(WindowType type) {
        this.type = type;
        this.id = WindowManager.instance.getNextWindow();

        title = new TextComponent(type.getType());
    }

    private Window(WindowType type, int id) {
        this.type = type;
        this.id = id;

        title = new TextComponent(type.getType());
    }

    // TODO Remove (?) this method, replace with a builder that other windows must use too?
    public static Window of(byte id, WindowType type, String title, byte slots) {
        Window w = new Window(type, id) {
            @Override
            public WindowType getType() {
                return super.getType();
            }

            @Override
            public void open(ProxiedPlayer player) {}

            @Override
            public ItemStack get(int slot) {
                return null;
            }

            @Override
            public void set(int slot, ItemStack item) {

            }

            @Override
            public ItemStack[] getContents() {
                return new ItemStack[0];
            }
        };

        w.setTitle(new TextComponent(title));

        return w;
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, id, title, slots);
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Window))
            return false;

        Window other = ((Window) obj);
        if(other.getId() != getId())
            return false;
        if(other.getType() != getType())
            return false;
        if(other.getSlots() != getSlots())
            return false;

        return true;
    }
}
