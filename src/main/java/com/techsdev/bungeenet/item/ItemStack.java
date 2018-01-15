package com.techsdev.bungeenet.item;

import com.flowpowered.nbt.CompoundMap;
import com.flowpowered.nbt.CompoundTag;
import com.flowpowered.nbt.ListTag;
import com.flowpowered.nbt.StringTag;
import com.sun.org.apache.xml.internal.serialize.TextSerializer;
import lombok.Getter;
import lombok.Setter;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.TextComponent;
import net.md_5.bungee.chat.ComponentSerializer;
import net.md_5.bungee.chat.TextComponentSerializer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Represents a stack of items
 */
public class ItemStack {

    /**
     * The type of the item
     */
    @Getter private final ItemType type;

    /**
     * The item's durability
     */
    @Getter private short durability;

    /**
     * The quantity of items in this stack
     */
    @Getter @Setter private int quantity = 1;

    /**
     * The additional NBT data on the item
     */
    @Getter @Setter private CompoundTag nbt = null;

    /**
     * A field to store extra data in, for example listeners, identifiers etc...
     */
    @Getter private final HashMap<String, Object> extraData = new HashMap<>();

    /**
     * Creates a new ItemStack with the provided ItemType
     * @param type The type of the item
     */
    public ItemStack(ItemType type) {
        this.type = type;

        this.durability = type.getDurability();
    }

    /**
     * Sets the durability of the item
     * @param durability The new durability
     * @throws UnsupportedOperationException When the item does not support durability
     */
    public void setDurability(short durability) {
        if(!type.isDegradable())
            throw new UnsupportedOperationException("This item does not support degradation");

        this.durability = durability;
    }

    /**
     * Checks if the ItemStack is empty (Essentially null)
     * @return True if it is empty, false if not
     */
    public boolean isEmpty() {
        return type.getId() == -1;
    }

    /**
     * Clones the ItemStack
     * @return A clone of the current ItemStack
     */
    public ItemStack clone() {
        ItemStack clone = new ItemStack(type);
        if(type.isDegradable())
            clone.setDurability(durability);
        clone.setQuantity(quantity);
        clone.setNbt(nbt.clone());

        return clone;
    }

    /**
     * Sets the display name of the item stack
     * @param display The display name of the item stack
     */
    public void setDisplayName(String display) {
        if(nbt == null) {
            nbt = new CompoundTag("tag", new CompoundMap());
        }

        if(nbt.getValue().get("display") == null) {
            nbt.getValue().put(new CompoundTag("display", new CompoundMap()));
        }
        CompoundMap displayTag = (CompoundMap) nbt.getValue().get("display").getValue();
        displayTag.put(new StringTag("Name", display));
    }

    /**
     * Sets the lore of the item stack
     * @param lore The lore of the item stack
     */
    public void setLore(List<String> lore) {
        if(nbt == null) {
            nbt = new CompoundTag("tag", new CompoundMap());
        }

        if(nbt.getValue().get("display") == null) {
            nbt.getValue().put(new CompoundTag("display", new CompoundMap()));
        }

        CompoundMap displayTag = (CompoundMap) nbt.getValue().get("display").getValue();
        List<StringTag> lores = new ArrayList<>();
        lore.forEach(line -> lores.add(new StringTag(null, line)));
        displayTag.put(new ListTag<>("Lore", StringTag.class, lores));
    }

    /**
     * @return An empty ItemStack - essentially a null
     */
    public static ItemStack EMPTY() {
        return new ItemStack(ItemTypes.AIR);
    }

}
