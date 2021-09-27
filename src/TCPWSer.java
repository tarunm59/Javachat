import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPWSer
{
    public static void main(String[] args) throws IOException {
        ServerSocket sock = new ServerSocket(9000);
        while(true)
        {
            System.out.println("Waiting");
            Socket sock2 = sock.accept();
            TCPW serverwin = new TCPW("sERVER WINDOW",sock2);
            
            serverwin.setVisible(true);
        }
    }
}
