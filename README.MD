# BungeeNet
BungeeNet is a powerful packet API which is compatible and tested with the latest versions of BungeeCord and Waterfall.
BungeeNet allows developers to implement unimplemented packets with ease, and has an implementation for inventories.

**Please be aware the BungeeNet is under development. While it works, features like the Inventory API may not work properly. Please make an issue if this is the case.**

## Usage
BungeeNet offers two major APIs as of now - the Window API as well as the Packet API. The current API only supports Minecraft 1.12.2, older versions may not work properly.

#### Packet API
Registering new packets is very easy, and can be done as following:
```
BungeeNet.registerPacket(Protocol.GAME.TO_CLIENT, Class<? extends Packet> packetClazz, ProtocolMapping... mappings);
```
The Protocol can be different and should be BungeeCord's protocol. The packet class should be the class which implements the packet class included in BungeeNet (`com.techsdev.packets.Packet`). The ProtocolMapping maps the packet ID to a Minecraft version.

A packet should have both the `read` and `write` methods implemented

#### Window API
The Window API is an unfinished implementation of the Minecraft. You can find more information on the different windows by browsing to the following link: [Inventory on Wiki.vg](http://wiki.vg/Inventory)

More in-depth exampled on how to use the Window API will follow soon.