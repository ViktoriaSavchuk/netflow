import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.jfree.ui.RefineryUtilities;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MainClass {

    public static void main(String[] args) {

        DataSelector dataSelector = new DataSelector();


        dataSelector.selectData();


        Protocols protocols = new Protocols();
        Receivers receivers = new Receivers();
        Transmitters transmitters = new Transmitters();
        Application application = new Application();


        protocols.setTop3protocols(dataSelector.allData);
        receivers.setTop10receivers(dataSelector.allData);
        transmitters.setTop10transmitters(dataSelector.allData);
        application.setTop10applications(dataSelector.allData);


        Map<String, Object> dataResult = new HashMap<>();
        dataResult.put("top_3_protocols", protocols.getProtocols());
        dataResult.put("top_10_receivers", receivers.getReceivers());
        dataResult.put("top_10_transmitters", transmitters.getTransmitters());
        dataResult.put("top_10_used_applications", application.getApplications());


        ObjectMapper mapper = new ObjectMapper();


        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        File file = new File("data.json");
        try {
            mapper.writeValue(file, dataResult);


        } catch (IOException e) {
            e.printStackTrace();
        }


        Chart demo = new Chart("XY Series Demo");
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);

    }
}
