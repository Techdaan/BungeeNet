package com.techsdev.bungeenet.window;

import lombok.Getter;

/**
 * The type of the window
 *
 * @see <a href="http://wiki.vg/Inventory">http://wiki.vg/Inventory</a>
 */
public enum WindowType {

    /**
     * Fallback for unknown types; also used for Ender chests. Behaves the same as minecraft:chest
     */
    CONTAINER("minecraft:container", true),

    CHEST("minecraft:chest", true),

    CRAFTING_TABLE("minecraft:crafting_table", false),

    FURNACE("minecraft:furnace", true),

    DISPENSER("minecraft:dispenser", true),

    ENCHANTING_TABLE("minecraft:enchanting_table", false),

    BREWING_STAND("minecraft:brewing_stand", true),

    VILLAGER("minecraft:villager", false),

    BEACON("minecraft:beacon", true),

    ANVIL("minecraft:anvil", false),

    HOPPER("minecraft:hopper", true),

    DROPPER("minecraft:dropper", true),

    SHULKER_BOX("minecraft:shulker_box", true),

    ENTITY_HORSE("EntityHorse", true),
    ;

    /**
     * The type of the window
     */
    @Getter private final String type;

    /**
     * Whether if the window is a storage type, meaning items should not drop on the floor when closing the interface <b>in a normal Minecraft server!</b>. Bungeecord does not offer this capability
     */
    @Getter private final boolean isStorage;
    WindowType(String type) {
        this(type, false);
    }

    WindowType(String type, boolean isStorage) {
        this.type = type;
        this.isStorage = isStorage;
    }

    public static WindowType of(String type) {
        for (WindowType windowType : values()) {
            if(windowType.getType().equalsIgnoreCase(type))
                return windowType;
        }

        throw new IllegalArgumentException("Window type "+type+" not found.");
    }

}
