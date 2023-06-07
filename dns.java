import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class dns {
    public static void main(String[] args) {
        int choice = 1;
        while (choice != 0) {
            String HOST;
            Scanner ch = new Scanner(System.in);
            System.out.print(" 1 --> Enter THe host\n 2 --> Enter the IP address\n 3 --> Exit\nCHOICE : ");
            choice = ch.nextInt();
            Scanner inp = new Scanner(System.in);
            switch (choice) {
                case 1:
                    System.out.print(" Enter Host Name : ");
                    HOST = inp.nextLine();
                    try {
                        InetAddress address = InetAddress.getByName(HOST);
                        System.out.println("IP ADDRESS: " + address.getHostAddress());
                    } catch (UnknownHostException ex) {
                        System.out.print(" NOT Found " + HOST);
                    }
                    break;
                case 2:
                    System.out.print(" Enter Host IP ADDRESS : ");
                    HOST = inp.nextLine();
                    try {
                        InetAddress address = InetAddress.getByName(HOST);
                        System.out.println("Host Name : " + address.getHostName());
                    } catch (UnknownHostException ex) {
                        System.out.print(" NOT Found " + HOST);
                    }
                    break;
                case 3:
                    choice = 0;
                    break;
                default:
                    System.out.println("Invalid Choice, Try Again");
                    break;
            }
        }
    }
}