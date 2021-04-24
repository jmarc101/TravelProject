import java.util.ArrayList;

public class VehicleTrain extends Vehicle {
    public VehicleTrain(String vehicleID, ArrayList<Section> sections) {
        super(vehicleID, sections);
    }

    public void toStrings(){
        System.out.println("Train - ID:" + getVehicleID() + "|Max Capacity: " + getMaxCapacity());
    }
}