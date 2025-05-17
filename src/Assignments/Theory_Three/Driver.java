package Assignments.Theory_Three;

public class Driver {
    private final int driverID;
    private final String driverName;
    private final int driverArrivalTime;

    public Driver(int driverID, String driverName, int driverArrivalTime) {
        this.driverID = driverID;
        this.driverName = driverName;
        this.driverArrivalTime = driverArrivalTime;
    }

    public int getDriverID() {
        return driverID;
    }

    public String getDriverName() {
        return driverName;
    }

    public int getDriverArrivalTime() {
        return driverArrivalTime;
    }

    @Override
    public String toString() {
        return "Driver{" + "ID=" + driverID + ", Name='" + driverName + '\'' + ", ArrivalTime=" + driverArrivalTime + '}';
    }
}
