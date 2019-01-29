import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.time.Second;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.ui.ApplicationFrame;

import java.util.List;

public class Chart extends ApplicationFrame {


    public Chart(String title) {
        super(title);


        DataSelector dataSelector = new DataSelector();
        List<SourceDataClass> data = dataSelector.selectData();

        Receivers receivers = new Receivers();
        receivers.setTop10receivers(dataSelector.allData);
        String topReceiver = receivers.getReceivers()[0];

        Transmitters transmitters = new Transmitters();
        transmitters.setTop10transmitters(dataSelector.allData);
        String topTransmitter = transmitters.getTransmitters()[0];

        final TimeSeries seriesReceiver = new TimeSeries("topReceiver: " + topReceiver);
        final TimeSeries seriesTransmitter = new TimeSeries("topTransmitter: " + topTransmitter);


        for (SourceDataClass sourceDataClass : data) {
            if (sourceDataClass.getDestinationAddress().equals(topReceiver)) {
                seriesReceiver.addOrUpdate(new Second(sourceDataClass.getDate()), sourceDataClass.getBytesIn());

            }
            if (sourceDataClass.getSourceAddress().equals(topTransmitter)) {
                seriesTransmitter.addOrUpdate(new Second(sourceDataClass.getDate()), sourceDataClass.getBytesOut());

            }

        }


        final TimeSeriesCollection xydata = new TimeSeriesCollection();
        xydata.addSeries(seriesReceiver);
        xydata.addSeries(seriesTransmitter);

        final JFreeChart chart = ChartFactory.createTimeSeriesChart(
                "bytes",
                "time",
                "bytes",
                xydata,
                true,
                true,
                false
        );


        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(1200, 374));
        setContentPane(chartPanel);
    }
}
