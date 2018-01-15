package com.techsdev.bungeenet.util;

import com.flowpowered.nbt.CompoundTag;
import com.flowpowered.nbt.stream.NBTInputStream;
import com.flowpowered.nbt.stream.NBTOutputStream;
import com.techsdev.bungeenet.BungeeNet;
import com.techsdev.bungeenet.item.ItemStack;
import com.techsdev.bungeenet.item.ItemType;
import com.techsdev.bungeenet.item.ItemTypes;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufInputStream;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Optional;

/**
 * Utilities related to writing and reading additional data types to and from ByteBufs
 */
public class BufferUtils {

    /**
     * Writes a CompoundTag to a ByteBuf
     * @param buf The buffer to write the data to
     * @param tag The compound tag to write to the buffer
     */
    public static void writeNbt(ByteBuf buf, CompoundTag tag) {
        if(tag == null) {
            buf.writeByte(0);
            return;
        }

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            NBTOutputStream outputStream = new NBTOutputStream(baos, false);
            outputStream.writeTag(tag);
        } catch(IOException e) {
            e.printStackTrace();
            return;
        }

        buf.writeBytes(baos.toByteArray());
    }

    /**
     * Writes an ItemStack to a ByteBuf
     * @param buf The buffer to write the data to
     * @param stack The item stack to write to the buffer
     */
    public static void writeItemStack(ByteBuf buf, ItemStack stack) {
        if(stack == null || stack.isEmpty()) {
            buf.writeShort(-1);
            return;
        }

        buf.writeShort(stack.getType().getId());
        buf.writeByte(stack.getQuantity());
        buf.writeShort(stack.getDurability());
        writeNbt(buf, stack.getNbt());
    }

    /**
     * Reads an ItemStack from a ByteBuf
     * @param buf The buffer to read the ItemStack from
     * @return The ItemStack that was encoded in the buffer
     */
    public static ItemStack readItemStack(ByteBuf buf) {
        short id = buf.readShort();
        if(id == -1)
            return ItemStack.EMPTY();

        int count = buf.readUnsignedByte();
        short durability = buf.readShort();
        CompoundTag tag = BufferUtils.readNbt(buf);

        Optional<ItemType> typeOptional = ItemTypes.fromId(id, durability);
        if(!typeOptional.isPresent()) {
            BungeeNet.logger.warning("There's no type registry for ID:"+id+", durability:"+durability+" - Returning EMPTY ItemStack");
            return ItemStack.EMPTY();
        }

        ItemStack stack = new ItemStack(typeOptional.get());
        stack.setQuantity(count);
        if(stack.getType().isDegradable())
            stack.setDurability(durability);
        stack.setNbt(tag);

        return stack;
    }

    /**
     * Reads a NBT Tag from a buffer
     * @param buf The buffer to read from
     * @return The NBT Tag, or null if there was none
     */
    public static CompoundTag readNbt(ByteBuf buf) {
        int index = buf.readerIndex();
        if(buf.readByte() == 0)
            return null;

        buf.readerIndex(index);
        try {
            NBTInputStream nbtInputStream = new NBTInputStream(new ByteBufInputStream(buf), false);
            return (CompoundTag) nbtInputStream.readTag();
        } catch(IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
