package com.techsdev.bungeenet.item;

import java.util.HashMap;
import java.util.Objects;
import java.util.Optional;

/**
 * A list of all current Item Types
 */
public class ItemTypes {

    /**
     * A registry of all items sorted by ID
     */
    private static final HashMap<IdRegistry, ItemType> registryByID = new HashMap<>();

    /**
     * A registry of all items sorted by identifier
     */
    private static final HashMap<StringIdRegistry, ItemType> registryByIdentifier = new HashMap<>();

    /**
     * Retrieves an ItemType from the registry by ID
     * @param id The ID of the ItemType to retrieve
     * @param durability The durability of the ItemType to retrieve
     * @return An optional that may contain the ItemType
     */
    public static Optional<ItemType> fromId(short id, short durability) {
        return Optional.ofNullable(registryByID.get(new IdRegistry(id, durability)));
    }

    /**
     * Retrieves an ItemType from the registry by identifier
     * @param identifier The identifier of the ItemType to retrieve
     * @return An optional that may contain the ItemType
     */
    public static Optional<ItemType> fromIdentifier(String identifier) {
        return Optional.ofNullable(registryByIdentifier.get(identifier));
    }

    /**
     * Registers a new ItemType in the registry
     * @param type The type to register
     */
    public static void register(ItemType type) {
        if(registryByID.containsKey(new IdRegistry(type.getId(), type.isDegradable() ? 0 : type.getDurability())))
            throw new IllegalArgumentException("An ItemType with ID " + type.getId() + " has already been registered");
        if(registryByIdentifier.containsKey(new StringIdRegistry(type.getIdentifier(), type.isDegradable() ? 0 : type.getDurability())))
            throw new IllegalArgumentException("An ItemType with identifier " + type.getIdentifier() + " has already been registered");

        registryByID.put(new IdRegistry(type.getId(), type.isDegradable() ? 0 : type.getDurability()), type); // Degradable items should not get a specific mapping
        registryByIdentifier.put(new StringIdRegistry(type.getIdentifier(), type.isDegradable() ? 0 : type.getDurability()), type);
    }

    public static final ItemType AIR = new ItemType(-1, "minecraft:air");

    public static final ItemType STONE = new ItemType(1, "minecraft:stone");
    public static final ItemType GRANITE = new ItemType(1, "minecraft:stone", false, 1);
    public static final ItemType POLISHED_GRANITE = new ItemType(1, "minecraft:stone", false, 2);
    public static final ItemType DIORITE = new ItemType(1, "minecraft:stone", false, 3);
    public static final ItemType POLISHED_DIORITE = new ItemType(1, "minecraft:stone", false, 4);
    public static final ItemType ANDESITE = new ItemType(1, "minecraft:stone", false, 5);
    public static final ItemType POLISHED_ANDESITE = new ItemType(1, "minecraft:stone", false, 6);
    public static final ItemType GRASS = new ItemType(2, "minecraft:grass");
    public static final ItemType DIRT = new ItemType(3, "minecraft:dirt");
    public static final ItemType COARSE_DIRT = new ItemType(3, "minecraft:dirt", false, 1);
    public static final ItemType PODZOL = new ItemType(3, "minecraft:dirt", false, 2);
    public static final ItemType COBBLESTONE = new ItemType(4, "minecraft:cobblestone");
    public static final ItemType OAK_WOOD_PLANK = new ItemType(5, "minecraft:planks");
    public static final ItemType SPRUCE_WOOD_PLANK = new ItemType(5, "minecraft:planks", false, 1);
    public static final ItemType BIRCH_WOOD_PLANK = new ItemType(5, "minecraft:planks", false, 2);
    public static final ItemType JUNGLE_WOOD_PLANK = new ItemType(5, "minecraft:planks", false, 3);
    public static final ItemType ACACIA_WOOD_PLANK = new ItemType(5, "minecraft:planks", false, 4);
    public static final ItemType DARK_OAK_WOOD_PLANK = new ItemType(5, "minecraft:planks", false, 5);
    public static final ItemType OAK_SAPLING = new ItemType(6, "minecraft:sapling");
    public static final ItemType SPRUCE_SAPLING = new ItemType(6, "minecraft:sapling", false, 1);
    public static final ItemType BIRCH_SAPLING = new ItemType(6, "minecraft:sapling", false, 2);
    public static final ItemType JUNGLE_SAPLING = new ItemType(6, "minecraft:sapling", false, 3);
    public static final ItemType ACACIA_SAPLING = new ItemType(6, "minecraft:sapling", false, 4);
    public static final ItemType DARK_OAK_SAPLING = new ItemType(6, "minecraft:sapling", false, 5);
    public static final ItemType BEDROCK = new ItemType(7, "minecraft:bedrock");
    public static final ItemType FLOWING_WATER = new ItemType(8, "minecraft:flowing_water");
    public static final ItemType STILL_WATER = new ItemType(9, "minecraft:water");
    public static final ItemType FLOWING_LAVA = new ItemType(10, "minecraft:flowing_lava");
    public static final ItemType STILL_LAVA = new ItemType(11, "minecraft:lava");
    public static final ItemType SAND = new ItemType(12, "minecraft:sand");
    public static final ItemType RED_SAND = new ItemType(12, "minecraft:sand", false, 1);
    public static final ItemType GRAVEL = new ItemType(13, "minecraft:gravel");
    public static final ItemType GOLD_ORE = new ItemType(14, "minecraft:gold_ore");
    public static final ItemType IRON_ORE = new ItemType(15, "minecraft:iron_ore");
    public static final ItemType COAL_ORE = new ItemType(16, "minecraft:coal_ore");
    public static final ItemType OAK_WOOD = new ItemType(17, "minecraft:log");
    public static final ItemType SPRUCE_WOOD = new ItemType(17, "minecraft:log", false, 1);
    public static final ItemType BIRCH_WOOD = new ItemType(17, "minecraft:log", false, 2);
    public static final ItemType JUNGLE_WOOD = new ItemType(17, "minecraft:log", false, 3);
    public static final ItemType OAK_LEAVES = new ItemType(18, "minecraft:leaves");
    public static final ItemType SPRUCE_LEAVES = new ItemType(18, "minecraft:leaves", false, 1);
    public static final ItemType BIRCH_LEAVES = new ItemType(18, "minecraft:leaves", false, 2);
    public static final ItemType JUNGLE_LEAVES = new ItemType(18, "minecraft:leaves", false, 3);
    public static final ItemType SPONGE = new ItemType(19, "minecraft:sponge");
    public static final ItemType WET_SPONGE = new ItemType(19, "minecraft:sponge", false, 1);
    public static final ItemType GLASS = new ItemType(20, "minecraft:glass");
    public static final ItemType LAPIS_LAZULI_ORE = new ItemType(21, "minecraft:lapis_ore");
    public static final ItemType LAPIS_LAZULI_BLOCK = new ItemType(22, "minecraft:lapis_block");
    public static final ItemType DISPENSER = new ItemType(23, "minecraft:dispenser");
    public static final ItemType SANDSTONE = new ItemType(24, "minecraft:sandstone");
    public static final ItemType CHISELED_SANDSTONE = new ItemType(24, "minecraft:sandstone", false, 1);
    public static final ItemType SMOOTH_SANDSTONE = new ItemType(24, "minecraft:sandstone", false, 2);
    public static final ItemType NOTE_BLOCK = new ItemType(25, "minecraft:noteblock");
    public static final ItemType POWERED_RAIL = new ItemType(27, "minecraft:golden_rail");
    public static final ItemType DETECTOR_RAIL = new ItemType(28, "minecraft:detector_rail");
    public static final ItemType STICKY_PISTON = new ItemType(29, "minecraft:sticky_piston");
    public static final ItemType COBWEB = new ItemType(30, "minecraft:web");
    public static final ItemType DEAD_SHRUB = new ItemType(31, "minecraft:tallgrass");
    public static final ItemType TALL_GRASS = new ItemType(31, "minecraft:tallgrass", false, 1);
    public static final ItemType FERN = new ItemType(31, "minecraft:tallgrass", false, 2);
    public static final ItemType DEAD_BUSH = new ItemType(32, "minecraft:deadbush");
    public static final ItemType PISTON = new ItemType(33, "minecraft:piston");
    public static final ItemType PISTON_HEAD = new ItemType(34, "minecraft:piston_head");
    public static final ItemType WHITE_WOOL = new ItemType(35, "minecraft:wool");
    public static final ItemType ORANGE_WOOL = new ItemType(35, "minecraft:wool", false, 1);
    public static final ItemType MAGENTA_WOOL = new ItemType(35, "minecraft:wool", false, 2);
    public static final ItemType LIGHT_BLUE_WOOL = new ItemType(35, "minecraft:wool", false, 3);
    public static final ItemType YELLOW_WOOL = new ItemType(35, "minecraft:wool", false, 4);
    public static final ItemType LIME_WOOL = new ItemType(35, "minecraft:wool", false, 5);
    public static final ItemType PINK_WOOL = new ItemType(35, "minecraft:wool", false, 6);
    public static final ItemType GRAY_WOOL = new ItemType(35, "minecraft:wool", false, 7);
    public static final ItemType LIGHT_GRAY_WOOL = new ItemType(35, "minecraft:wool", false, 8);
    public static final ItemType CYAN_WOOL = new ItemType(35, "minecraft:wool", false, 9);
    public static final ItemType PURPLE_WOOL = new ItemType(35, "minecraft:wool", false, 10);
    public static final ItemType BLUE_WOOL = new ItemType(35, "minecraft:wool", false, 11);
    public static final ItemType BROWN_WOOL = new ItemType(35, "minecraft:wool", false, 12);
    public static final ItemType GREEN_WOOL = new ItemType(35, "minecraft:wool", false, 13);
    public static final ItemType RED_WOOL = new ItemType(35, "minecraft:wool", false, 14);
    public static final ItemType BLACK_WOOL = new ItemType(35, "minecraft:wool", false, 15);
    public static final ItemType DANDELION = new ItemType(37, "minecraft:yellow_flower");
    public static final ItemType POPPY = new ItemType(38, "minecraft:red_flower");
    public static final ItemType BLUE_ORCHID = new ItemType(38, "minecraft:red_flower", false, 1);
    public static final ItemType ALLIUM = new ItemType(38, "minecraft:red_flower", false, 2);
    public static final ItemType AZURE_BLUET = new ItemType(38, "minecraft:red_flower", false, 3);
    public static final ItemType RED_TULIP = new ItemType(38, "minecraft:red_flower", false, 4);
    public static final ItemType ORANGE_TULIP = new ItemType(38, "minecraft:red_flower", false, 5);
    public static final ItemType WHITE_TULIP = new ItemType(38, "minecraft:red_flower", false, 6);
    public static final ItemType PINK_TULIP = new ItemType(38, "minecraft:red_flower", false, 7);
    public static final ItemType OXEYE_DAISY = new ItemType(38, "minecraft:red_flower", false, 8);
    public static final ItemType BROWN_MUSHROOM = new ItemType(39, "minecraft:brown_mushroom");
    public static final ItemType RED_MUSHROOM = new ItemType(40, "minecraft:red_mushroom");
    public static final ItemType GOLD_BLOCK = new ItemType(41, "minecraft:gold_block");
    public static final ItemType IRON_BLOCK = new ItemType(42, "minecraft:iron_block");
    public static final ItemType DOUBLE_STONE_SLAB = new ItemType(43, "minecraft:double_stone_slab");
    public static final ItemType DOUBLE_SANDSTONE_SLAB = new ItemType(43, "minecraft:double_stone_slab", false, 1);
    public static final ItemType DOUBLE_WOODEN_SLAB = new ItemType(43, "minecraft:double_stone_slab", false, 2);
    public static final ItemType DOUBLE_COBBLESTONE_SLAB = new ItemType(43, "minecraft:double_stone_slab", false, 3);
    public static final ItemType DOUBLE_BRICK_SLAB = new ItemType(43, "minecraft:double_stone_slab", false, 4);
    public static final ItemType DOUBLE_STONE_BRICK_SLAB = new ItemType(43, "minecraft:double_stone_slab", false, 5);
    public static final ItemType DOUBLE_NETHER_BRICK_SLAB = new ItemType(43, "minecraft:double_stone_slab", false, 6);
    public static final ItemType DOUBLE_QUARTZ_SLAB = new ItemType(43, "minecraft:double_stone_slab", false, 7);
    public static final ItemType STONE_SLAB = new ItemType(44, "minecraft:stone_slab");
    public static final ItemType SANDSTONE_SLAB = new ItemType(44, "minecraft:stone_slab", false, 1);
    public static final ItemType WOODEN_SLAB = new ItemType(44, "minecraft:stone_slab", false, 2);
    public static final ItemType COBBLESTONE_SLAB = new ItemType(44, "minecraft:stone_slab", false, 3);
    public static final ItemType BRICK_SLAB = new ItemType(44, "minecraft:stone_slab", false, 4);
    public static final ItemType STONE_BRICK_SLAB = new ItemType(44, "minecraft:stone_slab", false, 5);
    public static final ItemType NETHER_BRICK_SLAB = new ItemType(44, "minecraft:stone_slab", false, 6);
    public static final ItemType QUARTZ_SLAB = new ItemType(44, "minecraft:stone_slab", false, 7);
    public static final ItemType BRICKS = new ItemType(45, "minecraft:brick_block");
    public static final ItemType TNT = new ItemType(46, "minecraft:tnt");
    public static final ItemType BOOKSHELF = new ItemType(47, "minecraft:bookshelf");
    public static final ItemType MOSS_STONE = new ItemType(48, "minecraft:mossy_cobblestone");
    public static final ItemType OBSIDIAN = new ItemType(49, "minecraft:obsidian");
    public static final ItemType TORCH = new ItemType(50, "minecraft:torch");
    public static final ItemType FIRE = new ItemType(51, "minecraft:fire");
    public static final ItemType MONSTER_SPAWNER = new ItemType(52, "minecraft:mob_spawner");
    public static final ItemType OAK_WOOD_STAIRS = new ItemType(53, "minecraft:oak_stairs");
    public static final ItemType CHEST = new ItemType(54, "minecraft:chest");
    public static final ItemType REDSTONE_WIRE = new ItemType(55, "minecraft:redstone_wire");
    public static final ItemType DIAMOND_ORE = new ItemType(56, "minecraft:diamond_ore");
    public static final ItemType DIAMOND_BLOCK = new ItemType(57, "minecraft:diamond_block");
    public static final ItemType CRAFTING_TABLE = new ItemType(58, "minecraft:crafting_table");
    public static final ItemType FARMLAND = new ItemType(60, "minecraft:farmland");
    public static final ItemType FURNACE = new ItemType(61, "minecraft:furnace");
    public static final ItemType BURNING_FURNACE = new ItemType(62, "minecraft:lit_furnace");
    public static final ItemType STANDING_SIGN_BLOCK = new ItemType(63, "minecraft:standing_sign");
    public static final ItemType LADDER = new ItemType(65, "minecraft:ladder");
    public static final ItemType RAIL = new ItemType(66, "minecraft:rail");
    public static final ItemType COBBLESTONE_STAIRS = new ItemType(67, "minecraft:stone_stairs");
    public static final ItemType WALL_MOUNTED_SIGN_BLOCK = new ItemType(68, "minecraft:wall_sign");
    public static final ItemType LEVER = new ItemType(69, "minecraft:lever");
    public static final ItemType STONE_PRESSURE_PLATE = new ItemType(70, "minecraft:stone_pressure_plate");
    public static final ItemType WOODEN_PRESSURE_PLATE = new ItemType(72, "minecraft:wooden_pressure_plate");
    public static final ItemType REDSTONE_ORE = new ItemType(73, "minecraft:redstone_ore");
    public static final ItemType GLOWING_REDSTONE_ORE = new ItemType(74, "minecraft:lit_redstone_ore");
    public static final ItemType REDSTONE_TORCH_OFF = new ItemType(75, "minecraft:unlit_redstone_torch");
    public static final ItemType REDSTONE_TORCH_ON = new ItemType(76, "minecraft:redstone_torch");
    public static final ItemType STONE_BUTTON = new ItemType(77, "minecraft:stone_button");
    public static final ItemType SNOW = new ItemType(78, "minecraft:snow_layer");
    public static final ItemType ICE = new ItemType(79, "minecraft:ice");
    public static final ItemType SNOW_BLOCK = new ItemType(80, "minecraft:snow");
    public static final ItemType CACTUS = new ItemType(81, "minecraft:cactus");
    public static final ItemType CLAY = new ItemType(82, "minecraft:clay");
    public static final ItemType JUKEBOX = new ItemType(84, "minecraft:jukebox");
    public static final ItemType OAK_FENCE = new ItemType(85, "minecraft:fence");
    public static final ItemType PUMPKIN = new ItemType(86, "minecraft:pumpkin");
    public static final ItemType NETHERRACK = new ItemType(87, "minecraft:netherrack");
    public static final ItemType SOUL_SAND = new ItemType(88, "minecraft:soul_sand");
    public static final ItemType GLOWSTONE = new ItemType(89, "minecraft:glowstone");
    public static final ItemType NETHER_PORTAL = new ItemType(90, "minecraft:portal");
    public static final ItemType JACK_O_LANTERN = new ItemType(91, "minecraft:lit_pumpkin");
    public static final ItemType REDSTONE_REPEATER_BLOCK_OFF = new ItemType(93, "minecraft:unpowered_repeater");
    public static final ItemType REDSTONE_REPEATER_BLOCK_ON = new ItemType(94, "minecraft:powered_repeater");
    public static final ItemType WHITE_STAINED_GLASS = new ItemType(95, "minecraft:stained_glass");
    public static final ItemType ORANGE_STAINED_GLASS = new ItemType(95, "minecraft:stained_glass", false, 1);
    public static final ItemType MAGENTA_STAINED_GLASS = new ItemType(95, "minecraft:stained_glass", false, 2);
    public static final ItemType LIGHT_BLUE_STAINED_GLASS = new ItemType(95, "minecraft:stained_glass", false, 3);
    public static final ItemType YELLOW_STAINED_GLASS = new ItemType(95, "minecraft:stained_glass", false, 4);
    public static final ItemType LIME_STAINED_GLASS = new ItemType(95, "minecraft:stained_glass", false, 5);
    public static final ItemType PINK_STAINED_GLASS = new ItemType(95, "minecraft:stained_glass", false, 6);
    public static final ItemType GRAY_STAINED_GLASS = new ItemType(95, "minecraft:stained_glass", false, 7);
    public static final ItemType LIGHT_GRAY_STAINED_GLASS = new ItemType(95, "minecraft:stained_glass", false, 8);
    public static final ItemType CYAN_STAINED_GLASS = new ItemType(95, "minecraft:stained_glass", false, 9);
    public static final ItemType PURPLE_STAINED_GLASS = new ItemType(95, "minecraft:stained_glass", false, 10);
    public static final ItemType BLUE_STAINED_GLASS = new ItemType(95, "minecraft:stained_glass", false, 11);
    public static final ItemType BROWN_STAINED_GLASS = new ItemType(95, "minecraft:stained_glass", false, 12);
    public static final ItemType GREEN_STAINED_GLASS = new ItemType(95, "minecraft:stained_glass", false, 13);
    public static final ItemType RED_STAINED_GLASS = new ItemType(95, "minecraft:stained_glass", false, 14);
    public static final ItemType BLACK_STAINED_GLASS = new ItemType(95, "minecraft:stained_glass", false, 15);
    public static final ItemType WOODEN_TRAPDOOR = new ItemType(96, "minecraft:trapdoor");
    public static final ItemType STONE_MONSTER_EGG = new ItemType(97, "minecraft:monster_egg");
    public static final ItemType COBBLESTONE_MONSTER_EGG = new ItemType(97, "minecraft:monster_egg", false, 1);
    public static final ItemType STONE_BRICK_MONSTER_EGG = new ItemType(97, "minecraft:monster_egg", false, 2);
    public static final ItemType MOSSY_STONE_BRICK_MONSTER_EGG = new ItemType(97, "minecraft:monster_egg", false, 3);
    public static final ItemType CRACKED_STONE_BRICK_MONSTER_EGG = new ItemType(97, "minecraft:monster_egg", false, 4);
    public static final ItemType CHISELED_STONE_BRICK_MONSTER_EGG = new ItemType(97, "minecraft:monster_egg", false, 5);
    public static final ItemType STONE_BRICKS = new ItemType(98, "minecraft:stonebrick");
    public static final ItemType MOSSY_STONE_BRICKS = new ItemType(98, "minecraft:stonebrick", false, 1);
    public static final ItemType CRACKED_STONE_BRICKS = new ItemType(98, "minecraft:stonebrick", false, 2);
    public static final ItemType CHISELED_STONE_BRICKS = new ItemType(98, "minecraft:stonebrick", false, 3);
    public static final ItemType BROWN_MUSHROOM_BLOCK = new ItemType(99, "minecraft:brown_mushroom_block");
    public static final ItemType RED_MUSHROOM_BLOCK = new ItemType(100, "minecraft:red_mushroom_block");
    public static final ItemType IRON_BARS = new ItemType(101, "minecraft:iron_bars");
    public static final ItemType GLASS_PANE = new ItemType(102, "minecraft:glass_pane");
    public static final ItemType MELON_BLOCK = new ItemType(103, "minecraft:melon_block");
    public static final ItemType PUMPKIN_STEM = new ItemType(104, "minecraft:pumpkin_stem");
    public static final ItemType MELON_STEM = new ItemType(105, "minecraft:melon_stem");
    public static final ItemType VINES = new ItemType(106, "minecraft:vine");
    public static final ItemType OAK_FENCE_GATE = new ItemType(107, "minecraft:fence_gate");
    public static final ItemType BRICK_STAIRS = new ItemType(108, "minecraft:brick_stairs");
    public static final ItemType STONE_BRICK_STAIRS = new ItemType(109, "minecraft:stone_brick_stairs");
    public static final ItemType MYCELIUM = new ItemType(110, "minecraft:mycelium");
    public static final ItemType LILY_PAD = new ItemType(111, "minecraft:waterlily");
    public static final ItemType NETHER_BRICK_BLOCK = new ItemType(112, "minecraft:nether_brick");
    public static final ItemType NETHER_BRICK_FENCE = new ItemType(113, "minecraft:nether_brick_fence");
    public static final ItemType NETHER_BRICK_STAIRS = new ItemType(114, "minecraft:nether_brick_stairs");
    public static final ItemType ENCHANTMENT_TABLE = new ItemType(116, "minecraft:enchanting_table");
    public static final ItemType END_PORTAL = new ItemType(119, "minecraft:end_portal");
    public static final ItemType END_PORTAL_FRAME = new ItemType(120, "minecraft:end_portal_frame");
    public static final ItemType END_STONE = new ItemType(121, "minecraft:end_stone");
    public static final ItemType DRAGON_EGG = new ItemType(122, "minecraft:dragon_egg");
    public static final ItemType REDSTONE_LAMP_INACTIVE = new ItemType(123, "minecraft:redstone_lamp");
    public static final ItemType REDSTONE_LAMP_ACTIVE = new ItemType(124, "minecraft:lit_redstone_lamp");
    public static final ItemType DOUBLE_OAK_WOOD_SLAB = new ItemType(125, "minecraft:double_wooden_slab");
    public static final ItemType DOUBLE_SPRUCE_WOOD_SLAB = new ItemType(125, "minecraft:double_wooden_slab", false, 1);
    public static final ItemType DOUBLE_BIRCH_WOOD_SLAB = new ItemType(125, "minecraft:double_wooden_slab", false, 2);
    public static final ItemType DOUBLE_JUNGLE_WOOD_SLAB = new ItemType(125, "minecraft:double_wooden_slab", false, 3);
    public static final ItemType DOUBLE_ACACIA_WOOD_SLAB = new ItemType(125, "minecraft:double_wooden_slab", false, 4);
    public static final ItemType DOUBLE_DARK_OAK_WOOD_SLAB = new ItemType(125, "minecraft:double_wooden_slab", false, 5);
    public static final ItemType OAK_WOOD_SLAB = new ItemType(126, "minecraft:wooden_slab");
    public static final ItemType SPRUCE_WOOD_SLAB = new ItemType(126, "minecraft:wooden_slab", false, 1);
    public static final ItemType BIRCH_WOOD_SLAB = new ItemType(126, "minecraft:wooden_slab", false, 2);
    public static final ItemType JUNGLE_WOOD_SLAB = new ItemType(126, "minecraft:wooden_slab", false, 3);
    public static final ItemType ACACIA_WOOD_SLAB = new ItemType(126, "minecraft:wooden_slab", false, 4);
    public static final ItemType DARK_OAK_WOOD_SLAB = new ItemType(126, "minecraft:wooden_slab", false, 5);
    public static final ItemType COCOA = new ItemType(127, "minecraft:cocoa");
    public static final ItemType SANDSTONE_STAIRS = new ItemType(128, "minecraft:sandstone_stairs");
    public static final ItemType EMERALD_ORE = new ItemType(129, "minecraft:emerald_ore");
    public static final ItemType ENDER_CHEST = new ItemType(130, "minecraft:ender_chest");
    public static final ItemType TRIPWIRE_HOOK = new ItemType(131, "minecraft:tripwire_hook");
    public static final ItemType EMERALD_BLOCK = new ItemType(133, "minecraft:emerald_block");
    public static final ItemType SPRUCE_WOOD_STAIRS = new ItemType(134, "minecraft:spruce_stairs");
    public static final ItemType BIRCH_WOOD_STAIRS = new ItemType(135, "minecraft:birch_stairs");
    public static final ItemType JUNGLE_WOOD_STAIRS = new ItemType(136, "minecraft:jungle_stairs");
    public static final ItemType COMMAND_BLOCK = new ItemType(137, "minecraft:command_block");
    public static final ItemType BEACON = new ItemType(138, "minecraft:beacon");
    public static final ItemType COBBLESTONE_WALL = new ItemType(139, "minecraft:cobblestone_wall");
    public static final ItemType MOSSY_COBBLESTONE_WALL = new ItemType(139, "minecraft:cobblestone_wall", false, 1);
    public static final ItemType CARROTS = new ItemType(141, "minecraft:carrots");
    public static final ItemType POTATOES = new ItemType(142, "minecraft:potatoes");
    public static final ItemType WOODEN_BUTTON = new ItemType(143, "minecraft:wooden_button");
    public static final ItemType ANVIL = new ItemType(145, "minecraft:anvil");
    public static final ItemType TRAPPED_CHEST = new ItemType(146, "minecraft:trapped_chest");
    public static final ItemType WEIGHTED_PRESSURE_PLATE_LIGHT = new ItemType(147, "minecraft:light_weighted_pressure_plate");
    public static final ItemType WEIGHTED_PRESSURE_PLATE_HEAVY = new ItemType(148, "minecraft:heavy_weighted_pressure_plate");
    public static final ItemType REDSTONE_COMPARATOR_INACTIVE = new ItemType(149, "minecraft:unpowered_comparator");
    public static final ItemType REDSTONE_COMPARATOR_ACTIVE = new ItemType(150, "minecraft:powered_comparator");
    public static final ItemType DAYLIGHT_SENSOR = new ItemType(151, "minecraft:daylight_detector");
    public static final ItemType REDSTONE_BLOCK = new ItemType(152, "minecraft:redstone_block");
    public static final ItemType NETHER_QUARTZ_ORE = new ItemType(153, "minecraft:quartz_ore");
    public static final ItemType HOPPER = new ItemType(154, "minecraft:hopper");
    public static final ItemType QUARTZ_BLOCK = new ItemType(155, "minecraft:quartz_block");
    public static final ItemType CHISELED_QUARTZ_BLOCK = new ItemType(155, "minecraft:quartz_block", false, 1);
    public static final ItemType PILLAR_QUARTZ_BLOCK = new ItemType(155, "minecraft:quartz_block", false, 2);
    public static final ItemType QUARTZ_STAIRS = new ItemType(156, "minecraft:quartz_stairs");
    public static final ItemType ACTIVATOR_RAIL = new ItemType(157, "minecraft:activator_rail");
    public static final ItemType DROPPER = new ItemType(158, "minecraft:dropper");
    public static final ItemType WHITE_HARDENED_CLAY = new ItemType(159, "minecraft:stained_hardened_clay");
    public static final ItemType ORANGE_HARDENED_CLAY = new ItemType(159, "minecraft:stained_hardened_clay", false, 1);
    public static final ItemType MAGENTA_HARDENED_CLAY = new ItemType(159, "minecraft:stained_hardened_clay", false, 2);
    public static final ItemType LIGHT_BLUE_HARDENED_CLAY = new ItemType(159, "minecraft:stained_hardened_clay", false, 3);
    public static final ItemType YELLOW_HARDENED_CLAY = new ItemType(159, "minecraft:stained_hardened_clay", false, 4);
    public static final ItemType LIME_HARDENED_CLAY = new ItemType(159, "minecraft:stained_hardened_clay", false, 5);
    public static final ItemType PINK_HARDENED_CLAY = new ItemType(159, "minecraft:stained_hardened_clay", false, 6);
    public static final ItemType GRAY_HARDENED_CLAY = new ItemType(159, "minecraft:stained_hardened_clay", false, 7);
    public static final ItemType LIGHT_GRAY_HARDENED_CLAY = new ItemType(159, "minecraft:stained_hardened_clay", false, 8);
    public static final ItemType CYAN_HARDENED_CLAY = new ItemType(159, "minecraft:stained_hardened_clay", false, 9);
    public static final ItemType PURPLE_HARDENED_CLAY = new ItemType(159, "minecraft:stained_hardened_clay", false, 10);
    public static final ItemType BLUE_HARDENED_CLAY = new ItemType(159, "minecraft:stained_hardened_clay", false, 11);
    public static final ItemType BROWN_HARDENED_CLAY = new ItemType(159, "minecraft:stained_hardened_clay", false, 12);
    public static final ItemType GREEN_HARDENED_CLAY = new ItemType(159, "minecraft:stained_hardened_clay", false, 13);
    public static final ItemType RED_HARDENED_CLAY = new ItemType(159, "minecraft:stained_hardened_clay", false, 14);
    public static final ItemType BLACK_HARDENED_CLAY = new ItemType(159, "minecraft:stained_hardened_clay", false, 15);
    public static final ItemType WHITE_STAINED_GLASS_PANE = new ItemType(160, "minecraft:stained_glass_pane");
    public static final ItemType ORANGE_STAINED_GLASS_PANE = new ItemType(160, "minecraft:stained_glass_pane", false, 1);
    public static final ItemType MAGENTA_STAINED_GLASS_PANE = new ItemType(160, "minecraft:stained_glass_pane", false, 2);
    public static final ItemType LIGHT_BLUE_STAINED_GLASS_PANE = new ItemType(160, "minecraft:stained_glass_pane", false, 3);
    public static final ItemType YELLOW_STAINED_GLASS_PANE = new ItemType(160, "minecraft:stained_glass_pane", false, 4);
    public static final ItemType LIME_STAINED_GLASS_PANE = new ItemType(160, "minecraft:stained_glass_pane", false, 5);
    public static final ItemType PINK_STAINED_GLASS_PANE = new ItemType(160, "minecraft:stained_glass_pane", false, 6);
    public static final ItemType GRAY_STAINED_GLASS_PANE = new ItemType(160, "minecraft:stained_glass_pane", false, 7);
    public static final ItemType LIGHT_GRAY_STAINED_GLASS_PANE = new ItemType(160, "minecraft:stained_glass_pane", false, 8);
    public static final ItemType CYAN_STAINED_GLASS_PANE = new ItemType(160, "minecraft:stained_glass_pane", false, 9);
    public static final ItemType PURPLE_STAINED_GLASS_PANE = new ItemType(160, "minecraft:stained_glass_pane", false, 10);
    public static final ItemType BLUE_STAINED_GLASS_PANE = new ItemType(160, "minecraft:stained_glass_pane", false, 11);
    public static final ItemType BROWN_STAINED_GLASS_PANE = new ItemType(160, "minecraft:stained_glass_pane", false, 12);
    public static final ItemType GREEN_STAINED_GLASS_PANE = new ItemType(160, "minecraft:stained_glass_pane", false, 13);
    public static final ItemType RED_STAINED_GLASS_PANE = new ItemType(160, "minecraft:stained_glass_pane", false, 14);
    public static final ItemType BLACK_STAINED_GLASS_PANE = new ItemType(160, "minecraft:stained_glass_pane", false, 15);
    public static final ItemType ACACIA_LEAVES = new ItemType(161, "minecraft:leaves2");
    public static final ItemType DARK_OAK_LEAVES = new ItemType(161, "minecraft:leaves2", false, 1);
    public static final ItemType ACACIA_WOOD = new ItemType(162, "minecraft:log2");
    public static final ItemType DARK_OAK_WOOD = new ItemType(162, "minecraft:log2", false, 1);
    public static final ItemType ACACIA_WOOD_STAIRS = new ItemType(163, "minecraft:acacia_stairs");
    public static final ItemType DARK_OAK_WOOD_STAIRS = new ItemType(164, "minecraft:dark_oak_stairs");
    public static final ItemType SLIME_BLOCK = new ItemType(165, "minecraft:slime");
    public static final ItemType BARRIER = new ItemType(166, "minecraft:barrier");
    public static final ItemType IRON_TRAPDOOR = new ItemType(167, "minecraft:iron_trapdoor");
    public static final ItemType PRISMARINE = new ItemType(168, "minecraft:prismarine");
    public static final ItemType PRISMARINE_BRICKS = new ItemType(168, "minecraft:prismarine", false, 1);
    public static final ItemType DARK_PRISMARINE = new ItemType(168, "minecraft:prismarine", false, 2);
    public static final ItemType SEA_LANTERN = new ItemType(169, "minecraft:sea_lantern");
    public static final ItemType HAY_BALE = new ItemType(170, "minecraft:hay_block");
    public static final ItemType WHITE_CARPET = new ItemType(171, "minecraft:carpet");
    public static final ItemType ORANGE_CARPET = new ItemType(171, "minecraft:carpet", false, 1);
    public static final ItemType MAGENTA_CARPET = new ItemType(171, "minecraft:carpet", false, 2);
    public static final ItemType LIGHT_BLUE_CARPET = new ItemType(171, "minecraft:carpet", false, 3);
    public static final ItemType YELLOW_CARPET = new ItemType(171, "minecraft:carpet", false, 4);
    public static final ItemType LIME_CARPET = new ItemType(171, "minecraft:carpet", false, 5);
    public static final ItemType PINK_CARPET = new ItemType(171, "minecraft:carpet", false, 6);
    public static final ItemType GRAY_CARPET = new ItemType(171, "minecraft:carpet", false, 7);
    public static final ItemType LIGHT_GRAY_CARPET = new ItemType(171, "minecraft:carpet", false, 8);
    public static final ItemType CYAN_CARPET = new ItemType(171, "minecraft:carpet", false, 9);
    public static final ItemType PURPLE_CARPET = new ItemType(171, "minecraft:carpet", false, 10);
    public static final ItemType BLUE_CARPET = new ItemType(171, "minecraft:carpet", false, 11);
    public static final ItemType BROWN_CARPET = new ItemType(171, "minecraft:carpet", false, 12);
    public static final ItemType GREEN_CARPET = new ItemType(171, "minecraft:carpet", false, 13);
    public static final ItemType RED_CARPET = new ItemType(171, "minecraft:carpet", false, 14);
    public static final ItemType BLACK_CARPET = new ItemType(171, "minecraft:carpet", false, 15);
    public static final ItemType HARDENED_CLAY = new ItemType(172, "minecraft:hardened_clay");
    public static final ItemType BLOCK_OF_COAL = new ItemType(173, "minecraft:coal_block");
    public static final ItemType PACKED_ICE = new ItemType(174, "minecraft:packed_ice");
    public static final ItemType SUNFLOWER = new ItemType(175, "minecraft:double_plant");
    public static final ItemType LILAC = new ItemType(175, "minecraft:double_plant", false, 1);
    public static final ItemType DOUBLE_TALLGRASS = new ItemType(175, "minecraft:double_plant", false, 2);
    public static final ItemType LARGE_FERN = new ItemType(175, "minecraft:double_plant", false, 3);
    public static final ItemType ROSE_BUSH = new ItemType(175, "minecraft:double_plant", false, 4);
    public static final ItemType PEONY = new ItemType(175, "minecraft:double_plant", false, 5);
    public static final ItemType FREE_STANDING_BANNER = new ItemType(176, "minecraft:standing_banner");
    public static final ItemType WALL_MOUNTED_BANNER = new ItemType(177, "minecraft:wall_banner");
    public static final ItemType INVERTED_DAYLIGHT_SENSOR = new ItemType(178, "minecraft:daylight_detector_inverted");
    public static final ItemType RED_SANDSTONE = new ItemType(179, "minecraft:red_sandstone");
    public static final ItemType CHISELED_RED_SANDSTONE = new ItemType(179, "minecraft:red_sandstone", false, 1);
    public static final ItemType SMOOTH_RED_SANDSTONE = new ItemType(179, "minecraft:red_sandstone", false, 2);
    public static final ItemType RED_SANDSTONE_STAIRS = new ItemType(180, "minecraft:red_sandstone_stairs");
    public static final ItemType DOUBLE_RED_SANDSTONE_SLAB = new ItemType(181, "minecraft:double_stone_slab2");
    public static final ItemType RED_SANDSTONE_SLAB = new ItemType(182, "minecraft:stone_slab2");
    public static final ItemType SPRUCE_FENCE_GATE = new ItemType(183, "minecraft:spruce_fence_gate");
    public static final ItemType BIRCH_FENCE_GATE = new ItemType(184, "minecraft:birch_fence_gate");
    public static final ItemType JUNGLE_FENCE_GATE = new ItemType(185, "minecraft:jungle_fence_gate");
    public static final ItemType DARK_OAK_FENCE_GATE = new ItemType(186, "minecraft:dark_oak_fence_gate");
    public static final ItemType ACACIA_FENCE_GATE = new ItemType(187, "minecraft:acacia_fence_gate");
    public static final ItemType SPRUCE_FENCE = new ItemType(188, "minecraft:spruce_fence");
    public static final ItemType BIRCH_FENCE = new ItemType(189, "minecraft:birch_fence");
    public static final ItemType JUNGLE_FENCE = new ItemType(190, "minecraft:jungle_fence");
    public static final ItemType DARK_OAK_FENCE = new ItemType(191, "minecraft:dark_oak_fence");
    public static final ItemType ACACIA_FENCE = new ItemType(192, "minecraft:acacia_fence");
    public static final ItemType END_ROD = new ItemType(198, "minecraft:end_rod");
    public static final ItemType CHORUS_PLANT = new ItemType(199, "minecraft:chorus_plant");
    public static final ItemType CHORUS_FLOWER = new ItemType(200, "minecraft:chorus_flower");
    public static final ItemType PURPUR_BLOCK = new ItemType(201, "minecraft:purpur_block");
    public static final ItemType PURPUR_PILLAR = new ItemType(202, "minecraft:purpur_pillar");
    public static final ItemType PURPUR_STAIRS = new ItemType(203, "minecraft:purpur_stairs");
    public static final ItemType PURPUR_DOUBLE_SLAB = new ItemType(204, "minecraft:purpur_double_slab");
    public static final ItemType PURPUR_SLAB = new ItemType(205, "minecraft:purpur_slab");
    public static final ItemType END_STONE_BRICKS = new ItemType(206, "minecraft:end_bricks");
    public static final ItemType BEETROOT_BLOCK = new ItemType(207, "minecraft:beetroots");
    public static final ItemType GRASS_PATH = new ItemType(208, "minecraft:grass_path");
    public static final ItemType END_GATEWAY = new ItemType(209, "minecraft:end_gateway");
    public static final ItemType REPEATING_COMMAND_BLOCK = new ItemType(210, "minecraft:repeating_command_block");
    public static final ItemType CHAIN_COMMAND_BLOCK = new ItemType(211, "minecraft:chain_command_block");
    public static final ItemType FROSTED_ICE = new ItemType(212, "minecraft:frosted_ice");
    public static final ItemType MAGMA_BLOCK = new ItemType(213, "minecraft:magma");
    public static final ItemType NETHER_WART_BLOCK = new ItemType(214, "minecraft:nether_wart_block");
    public static final ItemType RED_NETHER_BRICK = new ItemType(215, "minecraft:red_nether_brick");
    public static final ItemType BONE_BLOCK = new ItemType(216, "minecraft:bone_block");
    public static final ItemType STRUCTURE_VOID = new ItemType(217, "minecraft:structure_void");
    public static final ItemType OBSERVER = new ItemType(218, "minecraft:observer");
    public static final ItemType WHITE_SHULKER_BOX = new ItemType(219, "minecraft:white_shulker_box");
    public static final ItemType ORANGE_SHULKER_BOX = new ItemType(220, "minecraft:orange_shulker_box");
    public static final ItemType MAGENTA_SHULKER_BOX = new ItemType(221, "minecraft:magenta_shulker_box");
    public static final ItemType LIGHT_BLUE_SHULKER_BOX = new ItemType(222, "minecraft:light_blue_shulker_box");
    public static final ItemType YELLOW_SHULKER_BOX = new ItemType(223, "minecraft:yellow_shulker_box");
    public static final ItemType LIME_SHULKER_BOX = new ItemType(224, "minecraft:lime_shulker_box");
    public static final ItemType PINK_SHULKER_BOX = new ItemType(225, "minecraft:pink_shulker_box");
    public static final ItemType GRAY_SHULKER_BOX = new ItemType(226, "minecraft:gray_shulker_box");
    public static final ItemType LIGHT_GRAY_SHULKER_BOX = new ItemType(227, "minecraft:silver_shulker_box");
    public static final ItemType CYAN_SHULKER_BOX = new ItemType(228, "minecraft:cyan_shulker_box");
    public static final ItemType PURPLE_SHULKER_BOX = new ItemType(229, "minecraft:purple_shulker_box");
    public static final ItemType BLUE_SHULKER_BOX = new ItemType(230, "minecraft:blue_shulker_box");
    public static final ItemType BROWN_SHULKER_BOX = new ItemType(231, "minecraft:brown_shulker_box");
    public static final ItemType GREEN_SHULKER_BOX = new ItemType(232, "minecraft:green_shulker_box");
    public static final ItemType RED_SHULKER_BOX = new ItemType(233, "minecraft:red_shulker_box");
    public static final ItemType BLACK_SHULKER_BOX = new ItemType(234, "minecraft:black_shulker_box");
    public static final ItemType WHITE_GLAZED_TERRACOTTA = new ItemType(235, "minecraft:white_glazed_terracotta");
    public static final ItemType ORANGE_GLAZED_TERRACOTTA = new ItemType(236, "minecraft:orange_glazed_terracotta");
    public static final ItemType MAGENTA_GLAZED_TERRACOTTA = new ItemType(237, "minecraft:magenta_glazed_terracotta");
    public static final ItemType LIGHT_BLUE_GLAZED_TERRACOTTA = new ItemType(238, "minecraft:light_blue_glazed_terracotta");
    public static final ItemType YELLOW_GLAZED_TERRACOTTA = new ItemType(239, "minecraft:yellow_glazed_terracotta");
    public static final ItemType LIME_GLAZED_TERRACOTTA = new ItemType(240, "minecraft:lime_glazed_terracotta");
    public static final ItemType PINK_GLAZED_TERRACOTTA = new ItemType(241, "minecraft:pink_glazed_terracotta");
    public static final ItemType GRAY_GLAZED_TERRACOTTA = new ItemType(242, "minecraft:gray_glazed_terracotta");
    public static final ItemType LIGHT_GRAY_GLAZED_TERRACOTTA = new ItemType(243, "minecraft:light_gray_glazed_terracotta");
    public static final ItemType CYAN_GLAZED_TERRACOTTA = new ItemType(244, "minecraft:cyan_glazed_terracotta");
    public static final ItemType PURPLE_GLAZED_TERRACOTTA = new ItemType(245, "minecraft:purple_glazed_terracotta");
    public static final ItemType BLUE_GLAZED_TERRACOTTA = new ItemType(246, "minecraft:blue_glazed_terracotta");
    public static final ItemType BROWN_GLAZED_TERRACOTTA = new ItemType(247, "minecraft:brown_glazed_terracotta");
    public static final ItemType GREEN_GLAZED_TERRACOTTA = new ItemType(248, "minecraft:green_glazed_terracotta");
    public static final ItemType RED_GLAZED_TERRACOTTA = new ItemType(249, "minecraft:red_glazed_terracotta");
    public static final ItemType BLACK_GLAZED_TERRACOTTA = new ItemType(250, "minecraft:black_glazed_terracotta");
    public static final ItemType WHITE_CONCRETE = new ItemType(251, "minecraft:concrete");
    public static final ItemType ORANGE_CONCRETE = new ItemType(251, "minecraft:concrete", false, 1);
    public static final ItemType MAGENTA_CONCRETE = new ItemType(251, "minecraft:concrete", false, 2);
    public static final ItemType LIGHT_BLUE_CONCRETE = new ItemType(251, "minecraft:concrete", false, 3);
    public static final ItemType YELLOW_CONCRETE = new ItemType(251, "minecraft:concrete", false, 4);
    public static final ItemType LIME_CONCRETE = new ItemType(251, "minecraft:concrete", false, 5);
    public static final ItemType PINK_CONCRETE = new ItemType(251, "minecraft:concrete", false, 6);
    public static final ItemType GRAY_CONCRETE = new ItemType(251, "minecraft:concrete", false, 7);
    public static final ItemType LIGHT_GRAY_CONCRETE = new ItemType(251, "minecraft:concrete", false, 8);
    public static final ItemType CYAN_CONCRETE = new ItemType(251, "minecraft:concrete", false, 9);
    public static final ItemType PURPLE_CONCRETE = new ItemType(251, "minecraft:concrete", false, 10);
    public static final ItemType BLUE_CONCRETE = new ItemType(251, "minecraft:concrete", false, 11);
    public static final ItemType BROWN_CONCRETE = new ItemType(251, "minecraft:concrete", false, 12);
    public static final ItemType GREEN_CONCRETE = new ItemType(251, "minecraft:concrete", false, 13);
    public static final ItemType RED_CONCRETE = new ItemType(251, "minecraft:concrete", false, 14);
    public static final ItemType BLACK_CONCRETE = new ItemType(251, "minecraft:concrete", false, 15);
    public static final ItemType WHITE_CONCRETE_POWDER = new ItemType(252, "minecraft:concrete_powder");
    public static final ItemType ORANGE_CONCRETE_POWDER = new ItemType(252, "minecraft:concrete_powder", false, 1);
    public static final ItemType MAGENTA_CONCRETE_POWDER = new ItemType(252, "minecraft:concrete_powder", false, 2);
    public static final ItemType LIGHT_BLUE_CONCRETE_POWDER = new ItemType(252, "minecraft:concrete_powder", false, 3);
    public static final ItemType YELLOW_CONCRETE_POWDER = new ItemType(252, "minecraft:concrete_powder", false, 4);
    public static final ItemType LIME_CONCRETE_POWDER = new ItemType(252, "minecraft:concrete_powder", false, 5);
    public static final ItemType PINK_CONCRETE_POWDER = new ItemType(252, "minecraft:concrete_powder", false, 6);
    public static final ItemType GRAY_CONCRETE_POWDER = new ItemType(252, "minecraft:concrete_powder", false, 7);
    public static final ItemType LIGHT_GRAY_CONCRETE_POWDER = new ItemType(252, "minecraft:concrete_powder", false, 8);
    public static final ItemType CYAN_CONCRETE_POWDER = new ItemType(252, "minecraft:concrete_powder", false, 9);
    public static final ItemType PURPLE_CONCRETE_POWDER = new ItemType(252, "minecraft:concrete_powder", false, 10);
    public static final ItemType BLUE_CONCRETE_POWDER = new ItemType(252, "minecraft:concrete_powder", false, 11);
    public static final ItemType BROWN_CONCRETE_POWDER = new ItemType(252, "minecraft:concrete_powder", false, 12);
    public static final ItemType GREEN_CONCRETE_POWDER = new ItemType(252, "minecraft:concrete_powder", false, 13);
    public static final ItemType RED_CONCRETE_POWDER = new ItemType(252, "minecraft:concrete_powder", false, 14);
    public static final ItemType BLACK_CONCRETE_POWDER = new ItemType(252, "minecraft:concrete_powder", false, 15);
    public static final ItemType STRUCTURE_BLOCK = new ItemType(255, "minecraft:structure_block");
    public static final ItemType IRON_SHOVEL = new ItemType(256, "minecraft:iron_shovel");
    public static final ItemType IRON_PICKAXE = new ItemType(257, "minecraft:iron_pickaxe");
    public static final ItemType IRON_AXE = new ItemType(258, "minecraft:iron_axe");
    public static final ItemType FLINT_AND_STEEL = new ItemType(259, "minecraft:flint_and_steel");
    public static final ItemType APPLE = new ItemType(260, "minecraft:apple");
    public static final ItemType BOW = new ItemType(261, "minecraft:bow");
    public static final ItemType ARROW = new ItemType(262, "minecraft:arrow");
    public static final ItemType COAL = new ItemType(263, "minecraft:coal");
    public static final ItemType CHARCOAL = new ItemType(263, "minecraft:coal", false, 1);
    public static final ItemType DIAMOND = new ItemType(264, "minecraft:diamond");
    public static final ItemType IRON_INGOT = new ItemType(265, "minecraft:iron_ingot");
    public static final ItemType GOLD_INGOT = new ItemType(266, "minecraft:gold_ingot");
    public static final ItemType IRON_SWORD = new ItemType(267, "minecraft:iron_sword");
    public static final ItemType WOODEN_SWORD = new ItemType(268, "minecraft:wooden_sword");
    public static final ItemType WOODEN_SHOVEL = new ItemType(269, "minecraft:wooden_shovel");
    public static final ItemType WOODEN_PICKAXE = new ItemType(270, "minecraft:wooden_pickaxe");
    public static final ItemType WOODEN_AXE = new ItemType(271, "minecraft:wooden_axe");
    public static final ItemType STONE_SWORD = new ItemType(272, "minecraft:stone_sword");
    public static final ItemType STONE_SHOVEL = new ItemType(273, "minecraft:stone_shovel");
    public static final ItemType STONE_PICKAXE = new ItemType(274, "minecraft:stone_pickaxe");
    public static final ItemType STONE_AXE = new ItemType(275, "minecraft:stone_axe");
    public static final ItemType DIAMOND_SWORD = new ItemType(276, "minecraft:diamond_sword");
    public static final ItemType DIAMOND_SHOVEL = new ItemType(277, "minecraft:diamond_shovel");
    public static final ItemType DIAMOND_PICKAXE = new ItemType(278, "minecraft:diamond_pickaxe");
    public static final ItemType DIAMOND_AXE = new ItemType(279, "minecraft:diamond_axe");
    public static final ItemType STICK = new ItemType(280, "minecraft:stick");
    public static final ItemType BOWL = new ItemType(281, "minecraft:bowl");
    public static final ItemType MUSHROOM_STEW = new ItemType(282, "minecraft:mushroom_stew");
    public static final ItemType GOLDEN_SWORD = new ItemType(283, "minecraft:golden_sword");
    public static final ItemType GOLDEN_SHOVEL = new ItemType(284, "minecraft:golden_shovel");
    public static final ItemType GOLDEN_PICKAXE = new ItemType(285, "minecraft:golden_pickaxe");
    public static final ItemType GOLDEN_AXE = new ItemType(286, "minecraft:golden_axe");
    public static final ItemType STRING = new ItemType(287, "minecraft:string");
    public static final ItemType FEATHER = new ItemType(288, "minecraft:feather");
    public static final ItemType GUNPOWDER = new ItemType(289, "minecraft:gunpowder");
    public static final ItemType WOODEN_HOE = new ItemType(290, "minecraft:wooden_hoe");
    public static final ItemType STONE_HOE = new ItemType(291, "minecraft:stone_hoe");
    public static final ItemType IRON_HOE = new ItemType(292, "minecraft:iron_hoe");
    public static final ItemType DIAMOND_HOE = new ItemType(293, "minecraft:diamond_hoe");
    public static final ItemType GOLDEN_HOE = new ItemType(294, "minecraft:golden_hoe");
    public static final ItemType WHEAT_SEEDS = new ItemType(295, "minecraft:wheat_seeds");
    public static final ItemType WHEAT = new ItemType(296, "minecraft:wheat");
    public static final ItemType BREAD = new ItemType(297, "minecraft:bread");
    public static final ItemType LEATHER_HELMET = new ItemType(298, "minecraft:leather_helmet");
    public static final ItemType LEATHER_TUNIC = new ItemType(299, "minecraft:leather_chestplate");
    public static final ItemType LEATHER_PANTS = new ItemType(300, "minecraft:leather_leggings");
    public static final ItemType LEATHER_BOOTS = new ItemType(301, "minecraft:leather_boots");
    public static final ItemType CHAINMAIL_HELMET = new ItemType(302, "minecraft:chainmail_helmet");
    public static final ItemType CHAINMAIL_CHESTPLATE = new ItemType(303, "minecraft:chainmail_chestplate");
    public static final ItemType CHAINMAIL_LEGGINGS = new ItemType(304, "minecraft:chainmail_leggings");
    public static final ItemType CHAINMAIL_BOOTS = new ItemType(305, "minecraft:chainmail_boots");
    public static final ItemType IRON_HELMET = new ItemType(306, "minecraft:iron_helmet");
    public static final ItemType IRON_CHESTPLATE = new ItemType(307, "minecraft:iron_chestplate");
    public static final ItemType IRON_LEGGINGS = new ItemType(308, "minecraft:iron_leggings");
    public static final ItemType IRON_BOOTS = new ItemType(309, "minecraft:iron_boots");
    public static final ItemType DIAMOND_HELMET = new ItemType(310, "minecraft:diamond_helmet");
    public static final ItemType DIAMOND_CHESTPLATE = new ItemType(311, "minecraft:diamond_chestplate");
    public static final ItemType DIAMOND_LEGGINGS = new ItemType(312, "minecraft:diamond_leggings");
    public static final ItemType DIAMOND_BOOTS = new ItemType(313, "minecraft:diamond_boots");
    public static final ItemType GOLDEN_HELMET = new ItemType(314, "minecraft:golden_helmet");
    public static final ItemType GOLDEN_CHESTPLATE = new ItemType(315, "minecraft:golden_chestplate");
    public static final ItemType GOLDEN_LEGGINGS = new ItemType(316, "minecraft:golden_leggings");
    public static final ItemType GOLDEN_BOOTS = new ItemType(317, "minecraft:golden_boots");
    public static final ItemType FLINT = new ItemType(318, "minecraft:flint");
    public static final ItemType RAW_PORKCHOP = new ItemType(319, "minecraft:porkchop");
    public static final ItemType COOKED_PORKCHOP = new ItemType(320, "minecraft:cooked_porkchop");
    public static final ItemType PAINTING = new ItemType(321, "minecraft:painting");
    public static final ItemType GOLDEN_APPLE = new ItemType(322, "minecraft:golden_apple");
    public static final ItemType ENCHANTED_GOLDEN_APPLE = new ItemType(322, "minecraft:golden_apple", false, 1);
    public static final ItemType SIGN = new ItemType(323, "minecraft:sign");
    public static final ItemType OAK_DOOR = new ItemType(324, "minecraft:wooden_door");
    public static final ItemType BUCKET = new ItemType(325, "minecraft:bucket");
    public static final ItemType WATER_BUCKET = new ItemType(326, "minecraft:water_bucket");
    public static final ItemType LAVA_BUCKET = new ItemType(327, "minecraft:lava_bucket");
    public static final ItemType MINECART = new ItemType(328, "minecraft:minecart");
    public static final ItemType SADDLE = new ItemType(329, "minecraft:saddle");
    public static final ItemType IRON_DOOR = new ItemType(330, "minecraft:iron_door");
    public static final ItemType REDSTONE = new ItemType(331, "minecraft:redstone");
    public static final ItemType SNOWBALL = new ItemType(332, "minecraft:snowball");
    public static final ItemType OAK_BOAT = new ItemType(333, "minecraft:boat");
    public static final ItemType LEATHER = new ItemType(334, "minecraft:leather");
    public static final ItemType MILK_BUCKET = new ItemType(335, "minecraft:milk_bucket");
    public static final ItemType BRICK = new ItemType(336, "minecraft:brick");
    public static final ItemType CLAY_BALL = new ItemType(337, "minecraft:clay_ball");
    public static final ItemType SUGAR_CANES = new ItemType(338, "minecraft:reeds");
    public static final ItemType PAPER = new ItemType(339, "minecraft:paper");
    public static final ItemType BOOK = new ItemType(340, "minecraft:book");
    public static final ItemType SLIMEBALL = new ItemType(341, "minecraft:slime_ball");
    public static final ItemType MINECART_WITH_CHEST = new ItemType(342, "minecraft:chest_minecart");
    public static final ItemType MINECART_WITH_FURNACE = new ItemType(343, "minecraft:furnace_minecart");
    public static final ItemType EGG = new ItemType(344, "minecraft:egg");
    public static final ItemType COMPASS = new ItemType(345, "minecraft:compass");
    public static final ItemType FISHING_ROD = new ItemType(346, "minecraft:fishing_rod");
    public static final ItemType CLOCK = new ItemType(347, "minecraft:clock");
    public static final ItemType GLOWSTONE_DUST = new ItemType(348, "minecraft:glowstone_dust");
    public static final ItemType RAW_FISH = new ItemType(349, "minecraft:fish");
    public static final ItemType RAW_SALMON = new ItemType(349, "minecraft:fish", false, 1);
    public static final ItemType CLOWNFISH = new ItemType(349, "minecraft:fish", false, 2);
    public static final ItemType PUFFERFISH = new ItemType(349, "minecraft:fish", false, 3);
    public static final ItemType COOKED_FISH = new ItemType(350, "minecraft:cooked_fish");
    public static final ItemType COOKED_SALMON = new ItemType(350, "minecraft:cooked_fish", false, 1);
    public static final ItemType INK_SACK = new ItemType(351, "minecraft:dye");
    public static final ItemType ROSE_RED = new ItemType(351, "minecraft:dye", false, 1);
    public static final ItemType CACTUS_GREEN = new ItemType(351, "minecraft:dye", false, 2);
    public static final ItemType COCO_BEANS = new ItemType(351, "minecraft:dye", false, 3);
    public static final ItemType LAPIS_LAZULI = new ItemType(351, "minecraft:dye", false, 4);
    public static final ItemType PURPLE_DYE = new ItemType(351, "minecraft:dye", false, 5);
    public static final ItemType CYAN_DYE = new ItemType(351, "minecraft:dye", false, 6);
    public static final ItemType LIGHT_GRAY_DYE = new ItemType(351, "minecraft:dye", false, 7);
    public static final ItemType GRAY_DYE = new ItemType(351, "minecraft:dye", false, 8);
    public static final ItemType PINK_DYE = new ItemType(351, "minecraft:dye", false, 9);
    public static final ItemType LIME_DYE = new ItemType(351, "minecraft:dye", false, 10);
    public static final ItemType DANDELION_YELLOW = new ItemType(351, "minecraft:dye", false, 11);
    public static final ItemType LIGHT_BLUE_DYE = new ItemType(351, "minecraft:dye", false, 12);
    public static final ItemType MAGENTA_DYE = new ItemType(351, "minecraft:dye", false, 13);
    public static final ItemType ORANGE_DYE = new ItemType(351, "minecraft:dye", false, 14);
    public static final ItemType BONE_MEAL = new ItemType(351, "minecraft:dye", false, 15);
    public static final ItemType BONE = new ItemType(352, "minecraft:bone");
    public static final ItemType SUGAR = new ItemType(353, "minecraft:sugar");
    public static final ItemType CAKE = new ItemType(354, "minecraft:cake");
    public static final ItemType BED = new ItemType(355, "minecraft:bed");
    public static final ItemType REDSTONE_REPEATER = new ItemType(356, "minecraft:repeater");
    public static final ItemType COOKIE = new ItemType(357, "minecraft:cookie");
    public static final ItemType MAP = new ItemType(358, "minecraft:filled_map");
    public static final ItemType SHEARS = new ItemType(359, "minecraft:shears");
    public static final ItemType MELON = new ItemType(360, "minecraft:melon");
    public static final ItemType PUMPKIN_SEEDS = new ItemType(361, "minecraft:pumpkin_seeds");
    public static final ItemType MELON_SEEDS = new ItemType(362, "minecraft:melon_seeds");
    public static final ItemType RAW_BEEF = new ItemType(363, "minecraft:beef");
    public static final ItemType STEAK = new ItemType(364, "minecraft:cooked_beef");
    public static final ItemType RAW_CHICKEN = new ItemType(365, "minecraft:chicken");
    public static final ItemType COOKED_CHICKEN = new ItemType(366, "minecraft:cooked_chicken");
    public static final ItemType ROTTEN_FLESH = new ItemType(367, "minecraft:rotten_flesh");
    public static final ItemType ENDER_PEARL = new ItemType(368, "minecraft:ender_pearl");
    public static final ItemType BLAZE_ROD = new ItemType(369, "minecraft:blaze_rod");
    public static final ItemType GHAST_TEAR = new ItemType(370, "minecraft:ghast_tear");
    public static final ItemType GOLD_NUGGET = new ItemType(371, "minecraft:gold_nugget");
    public static final ItemType NETHER_WART = new ItemType(372, "minecraft:nether_wart");
    public static final ItemType POTION = new ItemType(373, "minecraft:potion");
    public static final ItemType GLASS_BOTTLE = new ItemType(374, "minecraft:glass_bottle");
    public static final ItemType SPIDER_EYE = new ItemType(375, "minecraft:spider_eye");
    public static final ItemType FERMENTED_SPIDER_EYE = new ItemType(376, "minecraft:fermented_spider_eye");
    public static final ItemType BLAZE_POWDER = new ItemType(377, "minecraft:blaze_powder");
    public static final ItemType MAGMA_CREAM = new ItemType(378, "minecraft:magma_cream");
    public static final ItemType BREWING_STAND = new ItemType(379, "minecraft:brewing_stand");
    public static final ItemType CAULDRON = new ItemType(380, "minecraft:cauldron");
    public static final ItemType EYE_OF_ENDER = new ItemType(381, "minecraft:ender_eye");
    public static final ItemType GLISTERING_MELON = new ItemType(382, "minecraft:speckled_melon");
    public static final ItemType SPAWN_ELDER_GUARDIAN = new ItemType(383, "minecraft:spawn_egg", false, 4);
    public static final ItemType SPAWN_WITHER_SKELETON = new ItemType(383, "minecraft:spawn_egg", false, 5);
    public static final ItemType SPAWN_STRAY = new ItemType(383, "minecraft:spawn_egg", false, 6);
    public static final ItemType SPAWN_HUSK = new ItemType(383, "minecraft:spawn_egg", false, 23);
    public static final ItemType SPAWN_ZOMBIE_VILLAGER = new ItemType(383, "minecraft:spawn_egg", false, 27);
    public static final ItemType SPAWN_SKELETON_HORSE = new ItemType(383, "minecraft:spawn_egg", false, 28);
    public static final ItemType SPAWN_ZOMBIE_HORSE = new ItemType(383, "minecraft:spawn_egg", false, 29);
    public static final ItemType SPAWN_DONKEY = new ItemType(383, "minecraft:spawn_egg", false, 31);
    public static final ItemType SPAWN_MULE = new ItemType(383, "minecraft:spawn_egg", false, 32);
    public static final ItemType SPAWN_EVOKER = new ItemType(383, "minecraft:spawn_egg", false, 34);
    public static final ItemType SPAWN_VEX = new ItemType(383, "minecraft:spawn_egg", false, 35);
    public static final ItemType SPAWN_VINDICATOR = new ItemType(383, "minecraft:spawn_egg", false, 36);
    public static final ItemType SPAWN_CREEPER = new ItemType(383, "minecraft:spawn_egg", false, 50);
    public static final ItemType SPAWN_SKELETON = new ItemType(383, "minecraft:spawn_egg", false, 51);
    public static final ItemType SPAWN_SPIDER = new ItemType(383, "minecraft:spawn_egg", false, 52);
    public static final ItemType SPAWN_ZOMBIE = new ItemType(383, "minecraft:spawn_egg", false, 54);
    public static final ItemType SPAWN_SLIME = new ItemType(383, "minecraft:spawn_egg", false, 55);
    public static final ItemType SPAWN_GHAST = new ItemType(383, "minecraft:spawn_egg", false, 56);
    public static final ItemType SPAWN_ZOMBIE_PIGMAN = new ItemType(383, "minecraft:spawn_egg", false, 57);
    public static final ItemType SPAWN_ENDERMAN = new ItemType(383, "minecraft:spawn_egg", false, 58);
    public static final ItemType SPAWN_CAVE_SPIDER = new ItemType(383, "minecraft:spawn_egg", false, 59);
    public static final ItemType SPAWN_SILVERFISH = new ItemType(383, "minecraft:spawn_egg", false, 60);
    public static final ItemType SPAWN_BLAZE = new ItemType(383, "minecraft:spawn_egg", false, 61);
    public static final ItemType SPAWN_MAGMA_CUBE = new ItemType(383, "minecraft:spawn_egg", false, 62);
    public static final ItemType SPAWN_BAT = new ItemType(383, "minecraft:spawn_egg", false, 65);
    public static final ItemType SPAWN_WITCH = new ItemType(383, "minecraft:spawn_egg", false, 66);
    public static final ItemType SPAWN_ENDERMITE = new ItemType(383, "minecraft:spawn_egg", false, 67);
    public static final ItemType SPAWN_GUARDIAN = new ItemType(383, "minecraft:spawn_egg", false, 68);
    public static final ItemType SPAWN_SHULKER = new ItemType(383, "minecraft:spawn_egg", false, 69);
    public static final ItemType SPAWN_PIG = new ItemType(383, "minecraft:spawn_egg", false, 90);
    public static final ItemType SPAWN_SHEEP = new ItemType(383, "minecraft:spawn_egg", false, 91);
    public static final ItemType SPAWN_COW = new ItemType(383, "minecraft:spawn_egg", false, 92);
    public static final ItemType SPAWN_CHICKEN = new ItemType(383, "minecraft:spawn_egg", false, 93);
    public static final ItemType SPAWN_SQUID = new ItemType(383, "minecraft:spawn_egg", false, 94);
    public static final ItemType SPAWN_WOLF = new ItemType(383, "minecraft:spawn_egg", false, 95);
    public static final ItemType SPAWN_MOOSHROOM = new ItemType(383, "minecraft:spawn_egg", false, 96);
    public static final ItemType SPAWN_OCELOT = new ItemType(383, "minecraft:spawn_egg", false, 98);
    public static final ItemType SPAWN_HORSE = new ItemType(383, "minecraft:spawn_egg", false, 100);
    public static final ItemType SPAWN_RABBIT = new ItemType(383, "minecraft:spawn_egg", false, 101);
    public static final ItemType SPAWN_POLAR_BEAR = new ItemType(383, "minecraft:spawn_egg", false, 102);
    public static final ItemType SPAWN_LLAMA = new ItemType(383, "minecraft:spawn_egg", false, 103);
    public static final ItemType SPAWN_VILLAGER = new ItemType(383, "minecraft:spawn_egg", false, 120);
    public static final ItemType BOTTLE_O_ENCHANTING = new ItemType(384, "minecraft:experience_bottle");
    public static final ItemType FIRE_CHARGE = new ItemType(385, "minecraft:fire_charge");
    public static final ItemType BOOK_AND_QUILL = new ItemType(386, "minecraft:writable_book");
    public static final ItemType WRITTEN_BOOK = new ItemType(387, "minecraft:written_book");
    public static final ItemType EMERALD = new ItemType(388, "minecraft:emerald");
    public static final ItemType ITEM_FRAME = new ItemType(389, "minecraft:item_frame");
    public static final ItemType FLOWER_POT = new ItemType(390, "minecraft:flower_pot");
    public static final ItemType CARROT = new ItemType(391, "minecraft:carrot");
    public static final ItemType POTATO = new ItemType(392, "minecraft:potato");
    public static final ItemType BAKED_POTATO = new ItemType(393, "minecraft:baked_potato");
    public static final ItemType POISONOUS_POTATO = new ItemType(394, "minecraft:poisonous_potato");
    public static final ItemType EMPTY_MAP = new ItemType(395, "minecraft:map");
    public static final ItemType GOLDEN_CARROT = new ItemType(396, "minecraft:golden_carrot");
    public static final ItemType MOB_HEAD_SKELETON = new ItemType(397, "minecraft:skull");
    public static final ItemType MOB_HEAD_WITHER_SKELETON = new ItemType(397, "minecraft:skull", false, 1);
    public static final ItemType MOB_HEAD_ZOMBIE = new ItemType(397, "minecraft:skull", false, 2);
    public static final ItemType MOB_HEAD_HUMAN = new ItemType(397, "minecraft:skull", false, 3);
    public static final ItemType MOB_HEAD_CREEPER = new ItemType(397, "minecraft:skull", false, 4);
    public static final ItemType MOB_HEAD_DRAGON = new ItemType(397, "minecraft:skull", false, 5);
    public static final ItemType CARROT_ON_A_STICK = new ItemType(398, "minecraft:carrot_on_a_stick");
    public static final ItemType NETHER_STAR = new ItemType(399, "minecraft:nether_star");
    public static final ItemType PUMPKIN_PIE = new ItemType(400, "minecraft:pumpkin_pie");
    public static final ItemType FIREWORK_ROCKET = new ItemType(401, "minecraft:fireworks");
    public static final ItemType FIREWORK_STAR = new ItemType(402, "minecraft:firework_charge");
    public static final ItemType ENCHANTED_BOOK = new ItemType(403, "minecraft:enchanted_book");
    public static final ItemType REDSTONE_COMPARATOR = new ItemType(404, "minecraft:comparator");
    public static final ItemType NETHER_BRICK = new ItemType(405, "minecraft:netherbrick");
    public static final ItemType NETHER_QUARTZ = new ItemType(406, "minecraft:quartz");
    public static final ItemType MINECART_WITH_TNT = new ItemType(407, "minecraft:tnt_minecart");
    public static final ItemType MINECART_WITH_HOPPER = new ItemType(408, "minecraft:hopper_minecart");
    public static final ItemType PRISMARINE_SHARD = new ItemType(409, "minecraft:prismarine_shard");
    public static final ItemType PRISMARINE_CRYSTALS = new ItemType(410, "minecraft:prismarine_crystals");
    public static final ItemType RAW_RABBIT = new ItemType(411, "minecraft:rabbit");
    public static final ItemType COOKED_RABBIT = new ItemType(412, "minecraft:cooked_rabbit");
    public static final ItemType RABBIT_STEW = new ItemType(413, "minecraft:rabbit_stew");
    public static final ItemType RABBITS_FOOT = new ItemType(414, "minecraft:rabbit_foot");
    public static final ItemType RABBIT_HIDE = new ItemType(415, "minecraft:rabbit_hide");
    public static final ItemType ARMOR_STAND = new ItemType(416, "minecraft:armor_stand");
    public static final ItemType IRON_HORSE_ARMOR = new ItemType(417, "minecraft:iron_horse_armor");
    public static final ItemType GOLDEN_HORSE_ARMOR = new ItemType(418, "minecraft:golden_horse_armor");
    public static final ItemType DIAMOND_HORSE_ARMOR = new ItemType(419, "minecraft:diamond_horse_armor");
    public static final ItemType LEAD = new ItemType(420, "minecraft:lead");
    public static final ItemType NAME_TAG = new ItemType(421, "minecraft:name_tag");
    public static final ItemType MINECART_WITH_COMMAND_BLOCK = new ItemType(422, "minecraft:command_block_minecart");
    public static final ItemType RAW_MUTTON = new ItemType(423, "minecraft:mutton");
    public static final ItemType COOKED_MUTTON = new ItemType(424, "minecraft:cooked_mutton");
    public static final ItemType BANNER = new ItemType(425, "minecraft:banner");
    public static final ItemType SPRUCE_DOOR = new ItemType(427, "minecraft:spruce_door");
    public static final ItemType BIRCH_DOOR = new ItemType(428, "minecraft:birch_door");
    public static final ItemType JUNGLE_DOOR = new ItemType(429, "minecraft:jungle_door");
    public static final ItemType ACACIA_DOOR = new ItemType(430, "minecraft:acacia_door");
    public static final ItemType DARK_OAK_DOOR = new ItemType(431, "minecraft:dark_oak_door");
    public static final ItemType CHORUS_FRUIT = new ItemType(432, "minecraft:chorus_fruit");
    public static final ItemType POPPED_CHORUS_FRUIT = new ItemType(433, "minecraft:popped_chorus_fruit");
    public static final ItemType BEETROOT = new ItemType(434, "minecraft:beetroot");
    public static final ItemType BEETROOT_SEEDS = new ItemType(435, "minecraft:beetroot_seeds");
    public static final ItemType BEETROOT_SOUP = new ItemType(436, "minecraft:beetroot_soup");
    public static final ItemType DRAGONS_BREATH = new ItemType(437, "minecraft:dragon_breath");
    public static final ItemType SPLASH_POTION = new ItemType(438, "minecraft:splash_potion");
    public static final ItemType SPECTRAL_ARROW = new ItemType(439, "minecraft:spectral_arrow");
    public static final ItemType TIPPED_ARROW = new ItemType(440, "minecraft:tipped_arrow");
    public static final ItemType LINGERING_POTION = new ItemType(441, "minecraft:lingering_potion");
    public static final ItemType SHIELD = new ItemType(442, "minecraft:shield");
    public static final ItemType ELYTRA = new ItemType(443, "minecraft:elytra");
    public static final ItemType SPRUCE_BOAT = new ItemType(444, "minecraft:spruce_boat");
    public static final ItemType BIRCH_BOAT = new ItemType(445, "minecraft:birch_boat");
    public static final ItemType JUNGLE_BOAT = new ItemType(446, "minecraft:jungle_boat");
    public static final ItemType ACACIA_BOAT = new ItemType(447, "minecraft:acacia_boat");
    public static final ItemType DARK_OAK_BOAT = new ItemType(448, "minecraft:dark_oak_boat");
    public static final ItemType TOTEM_OF_UNDYING = new ItemType(449, "minecraft:totem_of_undying");
    public static final ItemType SHULKER_SHELL = new ItemType(450, "minecraft:shulker_shell");
    public static final ItemType IRON_NUGGET = new ItemType(452, "minecraft:iron_nugget");
    public static final ItemType NR_13_DISC = new ItemType(2256, "minecraft:record_13");
    public static final ItemType CAT_DISC = new ItemType(2257, "minecraft:record_cat");
    public static final ItemType BLOCKS_DISC = new ItemType(2258, "minecraft:record_blocks");
    public static final ItemType CHIRP_DISC = new ItemType(2259, "minecraft:record_chirp");
    public static final ItemType FAR_DISC = new ItemType(2260, "minecraft:record_far");
    public static final ItemType MALL_DISC = new ItemType(2261, "minecraft:record_mall");
    public static final ItemType MELLOHI_DISC = new ItemType(2262, "minecraft:record_mellohi");
    public static final ItemType STAL_DISC = new ItemType(2263, "minecraft:record_stal");
    public static final ItemType STRAD_DISC = new ItemType(2264, "minecraft:record_strad");
    public static final ItemType WARD_DISC = new ItemType(2265, "minecraft:record_ward");
    public static final ItemType NR_11_DISC = new ItemType(2266, "minecraft:record_11");
    public static final ItemType WAIT_DISC = new ItemType(2267, "minecraft:record_wait");

    /**
     * A registry object for item ID + durability-mapping
     */
    private static class IdRegistry {

        /**
         * The item ID
         */
        private final short id;

        /**
         * The item's durability (0 = default)
         */
        private final short durability;

        public IdRegistry(int id, int durability) {
            this.id = (short) id;
            this.durability = (short) durability;
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, durability);
        }

        @Override
        public boolean equals(Object obj) {
            if(!(obj instanceof IdRegistry))
                return false;
            IdRegistry other = ((IdRegistry) obj);
            return other.id == id && other.durability == durability;
        }
    }
    /**
     * A registry object for item ID + durability-mapping
     */
    private static class StringIdRegistry {

        /**
         * The item ID
         */
        private final String id;

        /**
         * The item's durability (0 = default)
         */
        private final short durability;

        public StringIdRegistry(String id, int durability) {
            this.id = id;
            this.durability = (short) durability;
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, durability);
        }

        @Override
        public boolean equals(Object obj) {
            if(!(obj instanceof StringIdRegistry))
                return false;
            StringIdRegistry other = ((StringIdRegistry) obj);
            return other.id.equals(id) && other.durability == durability;
        }
    }
}
