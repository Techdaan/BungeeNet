package com.techsdev.bungeenet.util;

import net.md_5.bungee.protocol.Protocol;

import java.lang.reflect.Array;
import java.lang.reflect.Method;

/**
 * Mapping for the Protocol - this is an equilivant to the class that BungeeCord uses for its own Protocol mapping
 */
public class ProtocolMapping {

    /**
     * The protocol version
     * @see <a href="wiki.vg/Protocol_version_numbers">wiki.vg/Protocol_version_numbers</a>
     */
    private final int protocolVersion;

    /**
     * The packet ID
     * @see <a href="http://wiki.vg/Protocol">http://wiki.vg/Protocol</a>
     */
    private final int packetID;

    /**
     * Creates a new protocol mapping which can be used to register a packet
     * @param protocolVersion The protocol version the packet
     * @param packetID The ID of the packet
     */
    public ProtocolMapping(int protocolVersion, int packetID) {
        this.protocolVersion = protocolVersion;
        this.packetID = packetID;
    }

    /**
     * @return The protocol version
     */
    public int getProtocolVersion() {
        return protocolVersion;
    }

    /**
     * @return The packet ID
     */
    public int getPacketID() {
        return packetID;
    }

    /**
     * Creates an equilivant of this class which can be used with the Bungeecord Protocol
     * @return The Bungeecord equilivant of this mapping
     */
    public Object toBungeecordMapping() throws ReflectiveOperationException {
        Method mapMethod = Protocol.class.getDeclaredMethod("map", int.class, int.class);
        mapMethod.setAccessible(true);
        return mapMethod.invoke(null, protocolVersion, packetID);
    }

    /**
     * Convers a list of ProtocolMappings to Bungeecord's protocol mapping
     * @param mappings The list of maps to convert
     * @return A BungeeCord compatible list of mappings
     */
    public static Object[] toBungeecordMappingList(ProtocolMapping... mappings) throws ReflectiveOperationException {
        Object[] bungeecordMappings = (Object[]) Array.newInstance(Class.forName("net.md_5.bungee.protocol.Protocol$ProtocolMapping"), mappings.length);
        for(int i=0; i<mappings.length; i++)
            bungeecordMappings[i] = mappings[i].toBungeecordMapping();
        return bungeecordMappings;
    }

}
