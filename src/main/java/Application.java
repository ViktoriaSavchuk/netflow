import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {

    private String applications[];

    public String[] setTop10applications(List<SourceDataClass> data) {


        Map<String, Integer> applications = new HashMap<>();

        for (SourceDataClass aData : data) {
            applications.put(aData.getSourceAddress(), 1);
        }

        for (SourceDataClass aData : data) {
            for (Map.Entry<String, Integer> entry : applications.entrySet()) {
                if (aData.getSourceAddress().equals(entry.getKey()))
                    applications.put(aData.getSourceAddress(), entry.getValue() + 1);

            }
        }

        applications = Receivers.sortByValue((HashMap<String, Integer>) applications);

        int i = 0;

        this.applications = new String[10];

        for (Map.Entry<String, Integer> entry : applications.entrySet()) {


            if (i < this.applications.length) {
                this.applications[i] = entry.getKey();
                i++;
            } else break;
        }


        return this.applications;
    }


    public String[] getApplications() {
        return applications;
    }
}
