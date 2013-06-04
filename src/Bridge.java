import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: Tomek
 * Date: 6/4/13
 * Time: 5:53 AM
 * To change this template use File | Settings | File Templates.
 */
public class Bridge  {
    private Map<Port, Mac> ports = new HashMap<Port, Mac>();

    public void addMacToPort(Port port, Mac mac){
         ports.put(port,mac);
    }

    public void receiveFrame(Port arrivingPort, Frame frame){
        //find out which port is destination port
        Port destPort = null;
        Set<Map.Entry<Port,Mac>> entries = ports.entrySet();

        for(Map.Entry<Port,Mac> entry : entries){
            if(entry.getValue().equals(frame.src))
                destPort = entry.getKey();
        }
       if( findDestMac(frame.dest) ){

            System.out.println("portem docelowym jest : " + destPort);

           if(destPort.equals(arrivingPort)){
               System.out.println("port docelowy jest taki sam jak port," +
                       " z którego przyszła ramka, mostek nic nie robi");
               return;
           }else{
               System.out.println("  port docelowy jest inny niż źródłowy, most przekazuje ramkę dalej, do portu docelowego – na zewnątrz.");

           }


       }else{

           floodNetwork(frame, destPort);
       }

    }

    private void floodNetwork(Frame frame, Port arrivingPort) {
        System.out.println("nie znalazl" +
                " adresu docelowego w FDB," +
                " zalewa (ang. flood) sieć," +
                " przekazując pakiet danych " +
                "na wszystkie porty z wyjątkiem źródłowego : " + arrivingPort);
        //sending to all ports
        Set<Map.Entry<Port,Mac>> entries = ports.entrySet();

        for(Map.Entry<Port,Mac> entry : entries){
            if(!entry.getKey().equals(arrivingPort))
            System.out.println("wysylam ramke na port : " + entry.getKey());

        }
    }

    private boolean findDestMac(Mac src) {
        System.out.println("poszukuje adresu docelowego ramki" +
                " w swojej tablicy forwardingu. ");
        if(ports.containsValue(src))
            return true;
        else
            return false;


    }


}
