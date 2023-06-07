import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class gbn_server {
    public static void main(String[] args) throws Exception{
        ServerSocket ss = new ServerSocket(3333);
        Socket s = ss.accept();
        DataInputStream din = new DataInputStream(s.getInputStream());
        DataOutputStream dout = new DataOutputStream(s.getOutputStream());
        int[] arr = {10,20,30,40,50,60,70};
        int k = arr.length;
        dout.write(k);
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Sending frame " + arr[i]);
            dout.write(arr[i]);
        }

        int error = din.read();
        System.out.println("Error received at : " + error);
        for (int i = error; i < arr.length; i++) {
            System.out.println("Resending frame : " + arr[i]);
            dout.write(arr[i]);
        }
        din.close();
        s.close();
        ss.close();
    }
    
}
