import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class tcp_server {

    public static void main(String[] args) throws Exception{
        ServerSocket ss = new ServerSocket(9999);
        Socket s = ss.accept();
        DataInputStream din = new DataInputStream(s.getInputStream());
        DataOutputStream dout = new DataOutputStream(s.getOutputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = "";
        while (str != "bye") {
            str = din.readUTF();
            System.out.println("Client: " + str);
            System.out.println("Server: ");
            str = br.readLine();
            dout.writeUTF(str);
        }
        din.close();
        s.close();
        ss.close();
    }
}