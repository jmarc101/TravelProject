import java.util.ArrayList;

public class CompanyAir extends Company {

    int routeID = 1;
    int vehicleID = 1;
    ArrayList<Vehicle> vehicles = new ArrayList<>();

    public CompanyAir(String companyID, String name, String headquarterAddress, double farePrice) {

        super(companyID, name, headquarterAddress, farePrice);
        createVehicle();

    }

    @Override
    public Vehicle getVehicle(int index) {
       return vehicles.get(index);
    }

    @Override
    public void toStrings() {
        System.out.println("Air Company" + "|ID : " + getCompanyID() + "|Name : " +
                getName() + "|Address : " + getHeadquarterAddress() + "|FarePrice : " + getFarePrice());
    }

    public String useRouteID() {

        return getCompanyID() + "00" + routeID++;
    }

    public void getVehiclesStrings(){
        for (Vehicle v : vehicles){
            v.toStrings();
        }
    }

    public String getRouteID() {

        return getCompanyID() + "00" + routeID;
    }

    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }

    public void createVehicle(){

        Class firstClass = new ClassFirst(50);
        Class premium = new ClassPremium(100);
        Class economy = new ClassEconomy(200);

        Section firstSection1 = new SectionPlane(firstClass, getFarePrice());
        Section premiumSection1 = new SectionPlane(premium, getFarePrice());
        Section firstSection2 = new SectionPlane(firstClass, getFarePrice());
        Section premiumSection2 = new SectionPlane(premium, getFarePrice());
        Section eco2 = new SectionPlane(economy, getFarePrice());
        Section firstSection3 = new SectionPlane(firstClass, getFarePrice());
        Section premiumSection3 = new SectionPlane(premium, getFarePrice());
        Section eco3 = new SectionPlane(economy, getFarePrice());

        ArrayList<Section> sects1 = new ArrayList<>();
        ArrayList<Section> sects2 = new ArrayList<>();
        ArrayList<Section> sects3 = new ArrayList<>();
        sects1.add(firstSection1);
        sects1.add(premiumSection1);
        sects2.add(firstSection2);
        sects2.add(premiumSection2);
        sects2.add(eco2);
        sects3.add(firstSection3);
        sects3.add(premiumSection3);
        sects3.add(eco3);

        vehicles.add(new VehicleAirplane(String.valueOf(vehicleID++), sects1));
        vehicles.add(new VehicleAirplane(String.valueOf(vehicleID++), sects2));
        vehicles.add(new VehicleAirplane(String.valueOf(vehicleID++), sects3));
    }

}