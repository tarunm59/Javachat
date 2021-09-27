import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class UDPClient
{
    public static void main(String[] args) throws IOException {
        DatagramSocket cls = new DatagramSocket();
        byte [] data = ("Hello from client").getBytes(StandardCharsets.UTF_8);
        DatagramPacket packet = new DatagramPacket(data,data.length, InetAddress.getLocalHost(),8999);
        cls.send(packet);
        cls.close();
    }
}
