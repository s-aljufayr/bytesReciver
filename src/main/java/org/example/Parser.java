package org.example;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.DoubleBuffer;
import java.nio.charset.StandardCharsets;

public class Parser {
    public static MyModel parseBytesToModel(byte[] data) {
        ByteBuffer buffer = ByteBuffer.wrap(data);

        buffer.order(ByteOrder.BIG_ENDIAN);
        int num = buffer.getInt();

        byte[] doubleBytes = new byte[8];
        for(int i = 0; i < doubleBytes.length; i++){
            doubleBytes[i] = buffer.get();
        }
        double num2 = bytesToDouble(doubleBytes);

        int nameLength = data.length - 13; //int (4 bytes), double (8 bytes), and boolean (1 byte)
        byte[] nameBytes = new byte[nameLength];
        for(int i = 0; i < nameBytes.length; i++){
            nameBytes[i] = buffer.get();
        }
        String name = new String(nameBytes, StandardCharsets.UTF_8);

        boolean status = byteToBoolean(buffer.get());

        return new MyModel(num, num2, name, status);
    }
    public static boolean byteToBoolean(byte b) {
        return b != 0;
    }
    private static double bytesToDouble(byte[] bytes) {
        ByteBuffer buffer = ByteBuffer.wrap(bytes);
        buffer.order(ByteOrder.BIG_ENDIAN);
        return buffer.getDouble();
    }
}
