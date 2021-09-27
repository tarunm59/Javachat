import java.net.Socket;

public class TCPWClient
{
    public static void main(String[] args) throws Exception
    {
        Socket s = new Socket("localhost",9000);
        TCPW frame = new TCPW("client",s);
        frame.setVisible(true);
    }

}
