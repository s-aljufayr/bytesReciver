package org.example;

public class Main {
    public static void main(String[] args) {
        try {
            UDPConnection udpConnection = new UDPConnection("127.0.0.1", 8000);
            while (true) {
                System.out.println("Server is listening");
                byte[] receivedData = udpConnection.receiveData();
                MyModel receivedModel = Parser.parseBytesToModel(receivedData);
                System.out.println("Data received: " + receivedModel);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}