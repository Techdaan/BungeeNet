package com.techsdev.bungeenet.window;

import net.md_5.bungee.api.connection.ProxiedPlayer;

import java.util.*;

/**
 * Manages the currently opened windows, as well as being a gateway to
 */
public class WindowManager {

    /**
     * The instance of the WindowManager
     */
    public static final WindowManager instance = new WindowManager();

    /**
     * A list of all opened windows
     *
     * Because of the low quantity of available window IDs several windows may share the same ID. Because of this, each
     *  Window has a list of viewers.
     */
    private HashMap<Byte, List<Window>> windows = new HashMap<>();

    /**
     * The current window ID
     */
    private byte currentID = 101;

    /**
     * Retrieves the ID of the next window
     * @return The ID of the window that should be opened
     */
    public byte getNextWindow() {
        currentID += 1;
        if(currentID > 125)
            currentID = 101;

        return currentID;
    }

    /**
     * Sets the opened window of a player, this way event listeners can use interface-related events
     * @param id The UUID of the player
     * @param window The window to open
     */
    public void setOpenWindow(UUID id, Window window) {
        Byte windowId = (byte) window.getId();
        if(windows.containsKey(windowId)) {
            for (Window potentialDupe : windows.get(windowId)) {
                if(potentialDupe.equals(window)) {
                    potentialDupe.getViewers().add(id);
                    return;
                }
            }

            window.getViewers().add(id);
            windows.get(windowId).add(window);
        } else {
            List<Window> windowList = new ArrayList<>();
            window.getViewers().add(id);
            windowList.add(window);

            windows.put((byte) window.getId(), windowList);
        }
    }

    /**
     * Attempts to retrieve the currently opened window for the provided user
     * @param player The player whose inventory to check
     * @return An optional which may contain the opened window. If the optional is empty the player may have a window open, but it is not be registered in BungeeCord
     */
    public Optional<Window> getOpenWindow(ProxiedPlayer player) {
        for (Byte idToTest : windows.keySet()) {
            Optional<Window> windowOptional = getOpenWindow(player, idToTest);
            if(windowOptional.isPresent())
                return windowOptional;
        }

        return Optional.empty();
    }

    /**
     * Attempts to retrieve the currently opened window for the provided user by looking up the open windows by window ID
     * @param player The player whose opened window to retrieve
     * @param id The ID of te window
     * @return An optional which may contain the opened window. If the optional is empty the player may have a window open, but it is not be registered in BungeeCord
     */
    public Optional<Window> getOpenWindow(ProxiedPlayer player, int id) {
        if(!windows.containsKey((byte) id)) {
            return Optional.empty();
        }

        for (Window window : windows.get((byte) id)) {
            if(window.getViewers().contains(player.getUniqueId()))
                return Optional.of(window);
        }

        return Optional.empty();
    }

    private WindowManager () {}

    /**
     * Closes the window of the player if he has a window open
     * @param uuid The player whose window to close
     */
    public void closeWindow(UUID uuid) {
        windows.values().forEach(list ->
            list.forEach(window -> {
                if (window.getViewers().contains(uuid))
                    window.getViewers().remove(uuid);
            })
        );
    }
}
