package com.techsdev.bungeenet.item;

import lombok.Getter;

/**
 * Represents an item type
 */
public class ItemType {

    /**
     * The ID of the item
     */
    @Getter private final short id;

    /**
     * The full identifier of the item, this includes the namespace
     */
    @Getter private final String identifier;

    /**
     * If the item is degradable or not
     */
    @Getter private final boolean degradable;

    /**
     * The durability of the ItemType (Not the actual item!!!)
     */
    @Getter private final short durability;

    /**
     * Creates a new ItemType which can not degrade
     * @param id The numberical ID of the item
     * @param identifier The string identifier of the type
     */
    public ItemType(int id, String identifier) {
        this.id = (short) id;
        this.identifier = identifier;
        this.degradable = false;
        this.durability = 0;

        ItemTypes.register(this);
    }

    /**
     * Creates a new ItemType where the durability matters (Eg. Diorite)
     * @param id The numberical ID of the item
     * @param identifier The string identifier of the type
     * @param degradable Whether the item can degrade or not
     * @param durability The durability of the item
     */
    public ItemType(int id, String identifier, boolean degradable, int durability) {
        this.id = (short) id;
        this.identifier = identifier;
        this.degradable = degradable;
        this.durability = (short) durability;

        ItemTypes.register(this);
    }

}
