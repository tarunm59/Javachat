import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPServer
{
    public static void main(String[] args) throws IOException {
        DatagramSocket sers = new DatagramSocket(8999);
        DatagramPacket serp = new DatagramPacket(new byte[1000],1000);
        sers.receive(serp);
        System.out.println(new String(serp.getData()));
        System.out.println(new String(String.valueOf(serp.getAddress())));
        System.out.println(new String(String.valueOf(serp.getPort())));
    }
}
