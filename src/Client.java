import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Client
{
  public static void main(String[] args) throws IOException
  {
      Socket sock = new Socket("10.0.0.5",9999);
      InputStream readserver = sock.getInputStream();
      OutputStream writetoserver = sock.getOutputStream();
      writetoserver.write("hello to server".getBytes(StandardCharsets.UTF_8));
      byte[] reply = new byte[1024];
      readserver.read(reply);
      System.out.println("This is the server message"+new StringBuffer(String.valueOf(reply)));
      sock.close();
  }
}
