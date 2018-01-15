package com.techsdev.bungeenet.window.impl;

import com.techsdev.bungeenet.item.ItemStack;
import com.techsdev.bungeenet.packets.protocol.game.client.OpenWindowPacket;
import com.techsdev.bungeenet.packets.protocol.game.client.SetWindowContentsPacket;
import com.techsdev.bungeenet.window.Window;
import com.techsdev.bungeenet.window.WindowManager;
import com.techsdev.bungeenet.window.WindowType;
import lombok.Getter;
import net.md_5.bungee.api.connection.ProxiedPlayer;

/**
 * A window which behaves as if it was a chest
 */
public class ChestWindow extends Window {

    /**
     * The contents of the chest
     */
    @Getter private ItemStack[] contents;

    public ChestWindow(int size) {
        super(WindowType.CHEST);

        if(size % 9 != 0 || size < 9 || size > 54)
            throw new IllegalArgumentException("The size of a chest must be between 9 and 54 slots, and be divisible by 9");

        this.slots = size;
        this.contents = new ItemStack[size];
    }

    @Override
    public void set(int slot, ItemStack item) {
        if(slot < 0 || slot >= getSlots())
            throw new IndexOutOfBoundsException("Slot "+slot+" is out of bounds (Bounds: 0-"+(getSlots()-1)+")");

        contents[slot] = item;
    }

    /**
     * Sets an item in the chest at the provided locations
     * @param x The X coordinate in the chest (0-8)
     * @param y The Y coordinate in the chest (0-rows)
     * @param item The item to set at the provided slot
     */
    public void set(int x, int y, ItemStack item) {
        set(x+(y*9), item);
    }

    @Override
    public ItemStack get(int slot) {
        if(slot == -999)
            return ItemStack.EMPTY();

        if(slot < 0 || slot >= getSlots())
            throw new IndexOutOfBoundsException("Slot "+slot+" is out of bounds (Bounds: 0-"+(getSlots()-1)+")");

        if(contents[slot] == null)
            return ItemStack.EMPTY();
        return contents[slot];
    }

    @Override
    public ItemStack[] getContents() {
        return contents;
    }

    @Override
    public void open(ProxiedPlayer player) {
        //TODO Event handlers
        OpenWindowPacket openWindowPacket = new OpenWindowPacket(this);
        SetWindowContentsPacket setWindowContentsPacket = new SetWindowContentsPacket(this);

        WindowManager.instance.setOpenWindow(player.getUniqueId(), this);

        player.unsafe().sendPacket(openWindowPacket);
        player.unsafe().sendPacket(setWindowContentsPacket);
    }
}
