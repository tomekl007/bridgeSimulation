/**
 * Created with IntelliJ IDEA.
 * User: Tomek
 * Date: 6/4/13
 * Time: 6:00 AM
 * To change this template use File | Settings | File Templates.
 */
public class MainClass {

    public static void main(String[] args) throws BadMacAddressException {
        Bridge bridge = new Bridge();
        Mac mac1 = new Mac();
        mac1.setAddress("11:22:33:44:55:66");
        Mac mac2 = new Mac();
        mac2.setAddress("66:55:44:33:22:11");
        bridge.addMacToPort(Port.ONE, mac1 );
        bridge.addMacToPort(Port.TWO, mac2 );

        Frame frame1 = new Frame(mac1,mac2);
        bridge.receiveFrame(Port.TWO,frame1);

        Mac notKnownMac = new Mac();
        notKnownMac.setAddress("23:23:24:24:12:12");
        Frame frame2 = new Frame(mac2,notKnownMac);
        bridge.receiveFrame(Port.TWO,frame2);


    }
}
