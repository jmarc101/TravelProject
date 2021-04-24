public class TransitHubAirport extends TransitHub {

    public TransitHubAirport(String hubID, String town) {
        super(hubID, town);
    }

    @Override
    public void toStrings() {
        System.out.println("Airport");
        System.out.print("|ID : " + getHubID());
        System.out.print("|Town : " + getTown());
    }
}