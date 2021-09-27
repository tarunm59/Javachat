import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.Map;

public class STServer
{
     static class Utility
    {
      private  LinkedHashMap<String,Integer> map = new LinkedHashMap<>();

        public LinkedHashMap<String, Integer> getMap()
        {
            return map;
        }
    }
    static class Service extends Thread
    {
        Socket a;
        public Service(Socket a)
        {
            this.a =a;
        }
        public void run()
        {
            try{
                System.out.println("Connected");
                InputStream clread = a.getInputStream();
                OutputStream wrcl = a.getOutputStream();
                System.out.println("Strremsers");
                BufferedReader reader = new BufferedReader(new InputStreamReader(clread));
                PrintWriter writer = new PrintWriter(new OutputStreamWriter(wrcl));
                String name = reader.readLine();

                System.out.println(name + "sdfd");
                Utility obj = new Utility();
                Map a1= obj.getMap();
                a1.put(name,4);
                writer.println("The " +name+"was added");
                writer.flush();

                a.close();
            }
            catch(IOException e)
            {
                System.out.println(e.getStackTrace());
            }

        }
    }
    public static void main(String[] args) throws IOException {
        ServerSocket sock1 = new ServerSocket(9999);
        System.out.println("listning");
        int count = 0;
        while(true)
        {
            count++;
            Socket client = sock1.accept();
            System.out.println("Start");
            new Service(client).start();
        }

    }
}
