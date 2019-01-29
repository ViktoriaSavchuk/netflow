import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataSelector {

    public List<SourceDataClass> allData = new ArrayList<SourceDataClass>();


    public List<SourceDataClass> selectData() {

        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss a");

        try {

            BufferedReader bufferedReader = new BufferedReader(new FileReader("2018-11-20-17-17.csv"));

            String line = " ";
            String[] elem;

            bufferedReader.readLine();

            while ((line = bufferedReader.readLine()) != null) {


                SourceDataClass data = new SourceDataClass();
                elem = line.split(",");
                elem[0] = parser(elem[0]);

                if (!elem[5].isEmpty() && !elem[7].isEmpty()) {

                    data.setDate(format.parse(elem[0]));
                    data.setBytesIn(Long.valueOf(elem[1]));
                    data.setBytesOut(Long.valueOf(elem[2]));
                    data.setPacketsIn(Integer.valueOf(elem[3]));
                    data.setPacketsOut(Integer.valueOf(elem[4]));
                    data.setApplicationName(elem[5]);
                    data.setDestinationAddress(elem[6]);
                    data.setProtocolNumber(Integer.valueOf(elem[7]));
                    data.setSourceAddress(elem[8]);

                    allData.add(data);
                }
            }
        } catch (FileNotFoundException ignored) {
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return this.allData;
    }

    public String parser(String string) {

        Matcher matcher = Pattern.compile(".*(\\..*) .*").matcher(string);
        while (matcher.find()) {
            string = string.replace(matcher.group(1), "");
        }


        return string;
    }


    @Override
    public String toString() {
        return "DataSelector{" +
                "allData=" + allData +
                '}';
    }
}
