
import java.net.*;
import java.io.*;
public class Client {
    public static final int PORT = 8080;
    public static void main(String[] args)throws IOException {
        String server = null;
        InetAddress addr =  InetAddress.getByName(server);
        System.out.println("addr = " + addr);
        Socket socket = new Socket(addr, PORT);
        try {
            System.out.println("socket = " + socket);
            BufferedReader in =
                    new BufferedReader(
                            new InputStreamReader(socket.getInputStream()));
            BufferedReader sin =  new BufferedReader(
                    new InputStreamReader(System.in));

            PrintWriter out =   new PrintWriter(
                    new BufferedWriter(  new OutputStreamWriter(
                            socket.getOutputStream())),true);
            for(int i = 0; i <1 ; i ++) {
                System.out.print("Message " + i + ":");
                String s = sin.readLine();
                if(s.length()==0) break;
                out.println(i + ": " +s);
                String str = in.readLine();
                System.out.println(str);
            }
            out.println("END");
        }
        finally {
            System.out.println("closing...");
            socket.close();
        }
    }
}
