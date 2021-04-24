public class CompanyNaval extends Company {
    public CompanyNaval(String companyID, String name, String headquarterAddress, double farePrice) {
        super(companyID, name, headquarterAddress, farePrice);
    }

    @Override
    public void toStrings() {
        System.out.println("Naval Company");
        System.out.println("ID : " + getCompanyID());
        System.out.println("Name : " +getName());
        System.out.println("Address : " + getHeadquarterAddress());
        System.out.println("FarePrice : " + getFarePrice());
    }
}