public class TransitHubPort extends TransitHub {
    public TransitHubPort(String hubID, String town) {
        super(hubID, town);
    }

    @Override
    public void toStrings() {
        System.out.println("Naval Port");
        System.out.print("|ID : " + getHubID());
        System.out.print("|Town : " + getTown());
    }
}