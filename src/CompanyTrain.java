import java.util.ArrayList;

public class CompanyTrain extends Company {
    int routeID = 1;
    ArrayList<Vehicle> vehicles = new ArrayList<>();
    int vehicleID = 1;

    public CompanyTrain(String companyID, String name, String headquarterAddress, double farePrice) {
        super(companyID, name, headquarterAddress, farePrice);

        createVehicle();
    }


    @Override
    public Vehicle getVehicle(int index) {
        return vehicles.get(index);
    }

    @Override
    public void toStrings() {
        System.out.println("Train Company");
        System.out.print("|ID : " + getCompanyID());
        System.out.print("|Name : " +getName());
        System.out.print("|Address : " + getHeadquarterAddress());
        System.out.print("|FarePrice : " + getFarePrice());
    }

    public String useRouteID() {
        String route = getCompanyID() + "00" + routeID++;
        return route;
    }

    public String getRouteID() {
        String route = getCompanyID() + "00" + routeID;
        return route;
    }

    public void getVehiclesStrings(){
        for (Vehicle v : vehicles){
            v.toStrings();
        }
    }
    public void createVehicle(){
        Class firstClass = new ClassFirst(50);
        Class premium = new ClassPremium(100);
        Class economy = new ClassEconomy(200);

        Section firstSection1 = new SectionTrain(firstClass, getFarePrice());
        Section premiumSection1 = new SectionTrain(premium, getFarePrice());
        Section firstSection2 = new SectionTrain(firstClass, getFarePrice());
        Section premiumSection2 = new SectionTrain(premium, getFarePrice());
        Section eco2 = new SectionTrain(economy, getFarePrice());
        Section firstSection3 = new SectionTrain(firstClass, getFarePrice());
        Section premiumSection3 = new SectionTrain(premium, getFarePrice());
        Section eco3 = new SectionTrain(economy, getFarePrice());

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



        vehicles.add(new VehicleTrain(String.valueOf(vehicleID++), sects1));
        vehicles.add(new VehicleTrain(String.valueOf(vehicleID++), sects2));
        vehicles.add(new VehicleTrain(String.valueOf(vehicleID++), sects3));
    }
}