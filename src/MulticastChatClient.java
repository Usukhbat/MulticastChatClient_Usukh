import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MulticastChatClient {
    public static void main(String[] args) throws Exception {
        int portnumber = 2000;
        if (args.length >= 1){
            portnumber = Integer.parseInt(args[0]);
        }
        MulticastSocket chatMulticastSocket = new MulticastSocket(portnumber);
        InetAddress group = InetAddress.getByName("225.4.5.6");
        chatMulticastSocket.joinGroup(group);
        String msg = "";
        System.out.println("Type a message for the answer: ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        msg = br.readLine();
        DatagramPacket data = new DatagramPacket(msg.getBytes(), 0, msg.length(), group, portnumber);
        chatMulticastSocket.send(data);
        chatMulticastSocket.close();
    }
}
