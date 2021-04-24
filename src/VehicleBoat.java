import java.util.ArrayList;

public class VehicleBoat extends Vehicle {
    public VehicleBoat(String vehicleID, ArrayList<Section> sections) {
        super(vehicleID, sections);
    }

    public void toStrings(){
        System.out.println("Boat - ID:" + getVehicleID() + "|Max Capacity: " + getMaxCapacity());
    }
}