import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class tcp_client {

    public static void main(String[] args) throws Exception {
        Socket s = new Socket("localhost", 3333);
        DataInputStream din = new DataInputStream(s.getInputStream());
        DataOutputStream dout = new DataOutputStream(s.getOutputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = "";
        while (str != "bye") {
            System.out.println("Client: ");
            str = br.readLine();
            dout.writeUTF(str);
            dout.flush();
            str = din.readUTF();
            System.out.println("server " + str);
        }
        s.close();
    }
}