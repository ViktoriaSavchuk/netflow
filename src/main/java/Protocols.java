import java.util.*;

public class Protocols {

    private int[] protocols;

    public Protocols() {
    }


    public int[] setTop3protocols(List<SourceDataClass> data) {


        Map<Integer, Integer> protocols = new HashMap<>();

        for (SourceDataClass aData : data) {
            protocols.put(aData.getProtocolNumber(), 1);
        }

        for (SourceDataClass aData : data) {
            for (Map.Entry<Integer, Integer> entry : protocols.entrySet()) {
                if (aData.getProtocolNumber() == entry.getKey())
                    protocols.put(aData.getProtocolNumber(), entry.getValue() + 1);

            }
        }

        protocols = sortByValue((HashMap<Integer, Integer>) protocols);

        //System.out.println(protocols);
        int i = 0;

        this.protocols = new int[3];

        for (Map.Entry<Integer, Integer> entry : protocols.entrySet()) {


            if (i < this.protocols.length) {
                this.protocols[i] = entry.getKey();
                i++;
            } else break;
        }


        return this.protocols;
    }


    public static Map<Integer, Integer> sortByValue(HashMap<Integer, Integer> hashMap) {

        List<Map.Entry<Integer, Integer>> list = new LinkedList<>(hashMap.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }

        });

        HashMap<Integer, Integer> temp = new LinkedHashMap<>();
        for (Map.Entry<Integer, Integer> tempMap : list) {

            temp.put(tempMap.getKey(), tempMap.getValue());
        }

        return temp;


    }

    @Override
    public String toString() {
        return "Protocols{" +
                "top3=" + Arrays.toString(protocols) +
                '}';
    }

    public int[] getProtocols() {
        return protocols;
    }
}
