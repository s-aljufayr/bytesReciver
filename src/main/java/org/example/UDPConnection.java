package org.example;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPConnection {
    private DatagramSocket socket;
    private InetAddress address;
    private int port;

    public UDPConnection(String address, int port) throws Exception {
        this.address = InetAddress.getByName(address);
        this.port = port;
        socket = new DatagramSocket(port, this.address);
    }
    public byte[] receiveData() throws Exception {
        byte[] buffer = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
        socket.receive(packet);
        byte[] data = new byte[packet.getLength()];
        System.arraycopy(buffer, 0, data, 0, packet.getLength());
        return data;
    }
}
