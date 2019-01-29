import java.util.*;

public class Receivers {

    private String receivers[];

    public String[] setTop10receivers(List<SourceDataClass> data) {


        Map<String, Integer> receivers = new HashMap<>();

        for (SourceDataClass aData : data) {
            receivers.put(aData.getDestinationAddress(), 1);
        }

        for (SourceDataClass aData : data) {
            for (Map.Entry<String, Integer> entry : receivers.entrySet()) {
                if (aData.getDestinationAddress().equals(entry.getKey()))
                    receivers.put(aData.getDestinationAddress(), entry.getValue() + 1);
            }
        }

        receivers = sortByValue((HashMap<String, Integer>) receivers);

        int i = 0;

        this.receivers = new String[10];

        for (Map.Entry<String, Integer> entry : receivers.entrySet()) {


            if (i < this.receivers.length) {
                this.receivers[i] = entry.getKey();
                i++;
            } else break;
        }


        return this.receivers;
    }

    public static Map<String, Integer> sortByValue(HashMap<String, Integer> hashMap) {

        List<Map.Entry<String, Integer>> list = new LinkedList<>(hashMap.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }

        });

        HashMap<String, Integer> temp = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> tempMap : list) {

            temp.put(tempMap.getKey(), tempMap.getValue());
        }

        return temp;


    }

    public String[] getReceivers() {
        return receivers;
    }
}
