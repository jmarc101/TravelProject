public class TransitHubTrainStation extends TransitHub {
    public TransitHubTrainStation(String hubID, String town) {
        super(hubID, town);
    }

    @Override
    public void toStrings() {
        System.out.println("Train Station|ID : " + getHubID()+"|Town : " + getTown());

    }
}