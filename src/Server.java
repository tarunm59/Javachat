import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Server
{
    public static void main(String[] args) throws IOException
    {
        ServerSocket serverSocket  = new ServerSocket(9999);
        Socket sock = serverSocket.accept();
        InputStream reader = sock.getInputStream();
        OutputStream writetoclient = sock.getOutputStream();
        byte buff[] = new byte[1024];
        reader.read(buff);
        System.out.println("This is the message fromthe client" + buff);
        writetoclient.write("Hello from server".getBytes(StandardCharsets.UTF_8));
        sock.close();
        serverSocket.close();
    }




}
