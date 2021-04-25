import java.util.ArrayList;

public class CompanyNaval extends Company {

    int routeID = 1;
    int vehicleID = 1;
    ArrayList<Vehicle> vehicles = new ArrayList<>();

    public CompanyNaval(String companyID, String name, String headquarterAddress, double farePrice) {
        super(companyID, name, headquarterAddress, farePrice);

        createVehicle();
    }

    @Override
    public void toStrings() {
        System.out.println("Naval Company" + "|ID : " + getCompanyID() + "|Name : " +
                getName() + "|Address : " + getHeadquarterAddress() + "|FarePrice : " + getFarePrice());
    }

    public String useRouteID() {
        String route = getCompanyID() + "00" + routeID++;
        return route;
    }

    public void getVehiclesStrings(){
        for (Vehicle v : vehicles){
            v.toStrings();
        }
    }


    @Override
    public Vehicle getVehicle(int index) {
        return vehicles.get(index);
    }

    public String getRouteID() {
        String route = getCompanyID() + "00" + routeID;
        return route;
    }

    public void createVehicle(){
        Class familyCabin = new ClassFamilyCabin();
        Class interiorCabin = new ClassInteriorCabin();
        Class oceanViewCabin = new ClassOceanViewCabin();
        Class premiumCabin = new ClassFamilyPremiumCabin();

        Section boat11 = new SectionBoatCabin(familyCabin, getFarePrice());
        Section boat12 = new SectionPlane(interiorCabin, getFarePrice());
        Section boat13 = new SectionPlane(oceanViewCabin, getFarePrice());
        Section boat14 = new SectionPlane(premiumCabin, getFarePrice());
        Section boat21 = new SectionBoatCabin(familyCabin, getFarePrice());
        Section boat22 = new SectionPlane(interiorCabin, getFarePrice());
        Section boat23 = new SectionPlane(oceanViewCabin, getFarePrice());
        Section boat24 = new SectionPlane(premiumCabin, getFarePrice());
        Section boat31 = new SectionBoatCabin(familyCabin, getFarePrice());
        Section boat32 = new SectionPlane(interiorCabin, getFarePrice());
        Section boat33 = new SectionPlane(oceanViewCabin, getFarePrice());
        Section boat34 = new SectionPlane(premiumCabin, getFarePrice());


        ArrayList<Section> sects1 = new ArrayList<>();
        ArrayList<Section> sects2 = new ArrayList<>();
        ArrayList<Section> sects3 = new ArrayList<>();
        sects1.add(boat11);
        sects1.add(boat12);
        sects1.add(boat13);
        sects1.add(boat14);
        sects1.add(boat21);
        sects1.add(boat22);
        sects1.add(boat23);
        sects1.add(boat24);
        sects1.add(boat31);
        sects1.add(boat32);
        sects1.add(boat33);
        sects1.add(boat34);



        vehicles.add(new VehicleBoat(String.valueOf(vehicleID++), sects1));
        vehicles.add(new VehicleBoat(String.valueOf(vehicleID++), sects2));
        vehicles.add(new VehicleBoat(String.valueOf(vehicleID++), sects3));

    }
}