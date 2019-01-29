import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Transmitters {

    private String transmitters[];

    public String[] setTop10transmitters(List<SourceDataClass> data) {


        Map<String, Integer> transmitters = new HashMap<>();

        for (SourceDataClass aData : data) {
            transmitters.put(aData.getSourceAddress(), 1);
        }

        for (SourceDataClass aData : data) {
            for (Map.Entry<String, Integer> entry : transmitters.entrySet()) {
                if (aData.getSourceAddress().equals(entry.getKey()))
                    transmitters.put(aData.getSourceAddress(), entry.getValue() + 1);

            }
        }

        transmitters = Receivers.sortByValue((HashMap<String, Integer>) transmitters);

        int i = 0;

        this.transmitters = new String[10];

        for (Map.Entry<String, Integer> entry : transmitters.entrySet()) {


            if (i < this.transmitters.length) {
                this.transmitters[i] = entry.getKey();
                i++;
            } else break;
        }


        return this.transmitters;
    }

    public String[] getTransmitters() {
        return transmitters;
    }
}
