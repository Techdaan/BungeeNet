package com.techsdev.bungeenet.listener;

import com.techsdev.bungeenet.event.InteractWindowEvent;
import com.techsdev.bungeenet.event.PacketEvent;
import com.techsdev.bungeenet.item.ItemStack;
import com.techsdev.bungeenet.packets.protocol.game.client.SetWindowSlotPacket;
import com.techsdev.bungeenet.packets.protocol.game.server.ClickWindowPacket;
import com.techsdev.bungeenet.packets.protocol.game.shared.CloseWindowPacket;
import com.techsdev.bungeenet.packets.protocol.game.shared.ConfirmTransactionPacket;
import com.techsdev.bungeenet.window.Window;
import com.techsdev.bungeenet.window.WindowManager;
import net.md_5.bungee.UserConnection;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.connection.LoginResult;
import net.md_5.bungee.event.EventHandler;
import net.md_5.bungee.protocol.packet.LoginRequest;

import java.util.Optional;

/**
 * Listener for packet related events to provide as much support to inventories as possible
 */
public class PacketEventListener implements Listener {

    @EventHandler
    public void onPacket(PacketEvent evt) {
        if(evt.getPacket() instanceof ClickWindowPacket) {
            ClickWindowPacket packet = ((ClickWindowPacket) evt.getPacket());
            Optional<Window> openWindow = WindowManager.instance.getOpenWindow(evt.getPlayer());//, packet.getWindowID());
            if(openWindow.isPresent()) {
                // Cancel event
                evt.setCancelled(true);

                Window window = openWindow.get();
                ConfirmTransactionPacket confirmPacket = new ConfirmTransactionPacket(window, window.getNextActionNumber(), false);
                SetWindowSlotPacket clearCursorPacket = new SetWindowSlotPacket((byte) -1, (short) -1, ItemStack.EMPTY());
                SetWindowSlotPacket resetWindowSlotPacket = new SetWindowSlotPacket(window, packet.getSlot(), window.get(packet.getSlot()));

                InteractWindowEvent event = new InteractWindowEvent(window, evt.getPlayer(), packet.getClickType(), packet.getSlot());
                ProxyServer.getInstance().getPluginManager().callEvent(event);

                evt.getPlayer().unsafe().sendPacket(confirmPacket);
                evt.getPlayer().unsafe().sendPacket(clearCursorPacket);
                evt.getPlayer().unsafe().sendPacket(resetWindowSlotPacket);
            }
        }

        if(evt.getPacket() instanceof ConfirmTransactionPacket) {
            if(evt.getSender() instanceof UserConnection && WindowManager.instance.getOpenWindow(evt.getPlayer()).isPresent()) {
                evt.setCancelled(true);
            }
        }

        if(evt.getPacket() instanceof CloseWindowPacket) {
            WindowManager.instance.closeWindow(evt.getPlayer().getUniqueId());
        }
    }

}
