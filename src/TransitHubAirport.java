public class TransitHubAirport extends TransitHub {

    public TransitHubAirport(String hubID, String town) {
        super(hubID, town);
    }

    @Override
    public void toStrings() {
        System.out.println("Airport");
        System.out.println("ID : " + getHubID());
        System.out.printf("Town : " + getTown());
    }
}