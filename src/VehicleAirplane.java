import java.util.ArrayList;

public class VehicleAirplane extends Vehicle {
    public VehicleAirplane(String vehicleID, ArrayList<Section> sections) {
        super(vehicleID, sections);
    }

    public void toStrings(){
        System.out.println("Airplane - ID:" + getVehicleID() + "|Max Capacity: " + getMaxCapacity());
    }
}