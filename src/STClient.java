import java.io.*;
import java.net.Socket;

public class STClient
{
    public static void main(String[] args) throws IOException
    {
        Socket sock = new Socket("10.0.0.5",9999);
        BufferedReader reader = new BufferedReader(new InputStreamReader(sock
                .getInputStream()));
        PrintWriter writer = new PrintWriter(new OutputStreamWriter(sock
                .getOutputStream()));
        writer.println("clientmessage");
        writer.flush();
        String res = reader.readLine();
        System.out.println(res);
        sock.close();
    }



}
