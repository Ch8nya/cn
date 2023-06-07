import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

public class sr_client {

    public static void main(String[] args) throws Exception{
        Socket s = new Socket("localhost" , 3333);
        DataInputStream din = new DataInputStream(s.getInputStream());
        DataOutputStream dout = new DataOutputStream(s.getOutputStream());
        int y = din.read();
        int[] arr = new int[y];
        for (int i = 0; i < y; i++) {
            arr[i] = din.read();
        }
        arr[4] = -1;
        int temp = 0;
        for (int i = 0; i < y; i++) {
            if (arr[i] == -1) {
                temp = i;
                System.out.println("Error at " + i + "received " + arr[i]);
            } else {
                System.out.println("Receiving frame " + arr[i]);
            }
        }

        dout.write(temp);
        arr[temp] = din.read();
        System.out.println("Resent frame/value: " + temp + ":" + arr[temp]);
        din.close();
        s.close();

    }
}