import java.util.Date;

public class SourceDataClass {


    private Date date;
    private long bytesIn;
    private long bytesOut;
    private int packetsIn;
    private int packetsOut;
    private String applicationName;
    private String destinationAddress;
    private int protocolNumber;
    private String sourceAddress;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public long getBytesIn() {
        return bytesIn;
    }

    public void setBytesIn(long bytesIn) {
        this.bytesIn = bytesIn;
    }

    public long getBytesOut() {
        return bytesOut;
    }

    public void setBytesOut(long bytesOut) {
        this.bytesOut = bytesOut;
    }

    public int getPacketsIn() {
        return packetsIn;
    }

    public void setPacketsIn(int packetsIn) {
        this.packetsIn = packetsIn;
    }

    public int getPacketsOut() {
        return packetsOut;
    }

    public void setPacketsOut(int packetsOut) {
        this.packetsOut = packetsOut;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public String getDestinationAddress() {
        return destinationAddress;
    }

    public void setDestinationAddress(String destinationAddress) {
        this.destinationAddress = destinationAddress;
    }

    public int getProtocolNumber() {
        return protocolNumber;
    }

    public void setProtocolNumber(int protocolNumber) {
        this.protocolNumber = protocolNumber;
    }

    public String getSourceAddress() {
        return sourceAddress;
    }

    public void setSourceAddress(String sourceAddress) {
        this.sourceAddress = sourceAddress;
    }


    public SourceDataClass(Date date, long bytesIn, long bytesOut, int packetsIn, int packetsOut, String applicationName, String destinationAddress, int protocolNumber, String sourceAddress) {
        this.date = date;
        this.bytesIn = bytesIn;
        this.bytesOut = bytesOut;
        this.packetsIn = packetsIn;
        this.packetsOut = packetsOut;
        this.applicationName = applicationName;
        this.destinationAddress = destinationAddress;
        this.protocolNumber = protocolNumber;
        this.sourceAddress = sourceAddress;
    }

    public SourceDataClass() {
    }


    @Override
    public String toString() {
        return "SourceDataClass{" +
                "date=" + date +
                ", bytesIn=" + bytesIn +
                ", bytesOut=" + bytesOut +
                ", packetsIn=" + packetsIn +
                ", packetsOut=" + packetsOut +
                ", applicationName='" + applicationName + '\'' +
                ", destinationAddress='" + destinationAddress + '\'' +
                ", protocolNumber=" + protocolNumber +
                ", sourceAddress='" + sourceAddress + '\'' +
                '}';
    }
}
