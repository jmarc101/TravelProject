public class TransitHubPort extends TransitHub {
    public TransitHubPort(String hubID, String town) {
        super(hubID, town);
    }

    @Override
    public void toStrings() {
        System.out.println("Naval Port|ID : " + getHubID()+"|Town : " + getTown());

    }
}