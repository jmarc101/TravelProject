public class TransitHubTrainStation extends TransitHub {
    public TransitHubTrainStation(String hubID, String town) {
        super(hubID, town);
    }

    @Override
    public void toStrings() {
        System.out.println("Train Station");
        System.out.print("|ID : " + getHubID());
        System.out.print("|Town : " + getTown());
    }
}