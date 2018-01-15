package com.techsdev.bungeenet.util;

import io.netty.channel.Channel;
import net.md_5.bungee.UserConnection;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.connection.InitialHandler;
import net.md_5.bungee.netty.ChannelWrapper;

import java.lang.reflect.Field;

/**
 * Utilities for player-related operations
 */
public class PlayerUtils {

    /**
     * The field which contains the player's channel
     */
    private static Field playerChannelField = null;

    /**
     * The field of an InitialHandler
     */
    private static Field initialHandlerChannelField = null;

    /**
     * Retrieves the channel of a player
     * @param player The player whose channel to obtain
     * @return The chanmnel of the player
     */
    public static Channel getPlayerChannel(ProxiedPlayer player) throws ReflectiveOperationException {
        if (playerChannelField == null) {
            playerChannelField = UserConnection.class.getDeclaredField("ch");
            playerChannelField.setAccessible(true);
        }

        return ((ChannelWrapper) playerChannelField.get(player)).getHandle();
    }

    /**
     * Retrieves the current channel of an InitialHandler
     * @param handler The handler to get the channel from
     * @return The channel handler
     * @throws ReflectiveOperationException error beep boop reflection
     */
    public static Channel getInitialHandlerChannel(InitialHandler handler) throws ReflectiveOperationException {
        if(initialHandlerChannelField == null) {
            initialHandlerChannelField = InitialHandler.class.getDeclaredField("ch");
            initialHandlerChannelField.setAccessible(true);
        }

        return ((ChannelWrapper) initialHandlerChannelField.get(handler)).getHandle();
    }

}
