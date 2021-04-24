public abstract class TransitHub extends TravelEntity {
	private String hubID;
	private String town;

	public TransitHub(String hubID, String town) {
		this.hubID = hubID;
		this.town = town;
	}


	public String getHubID() {
		return hubID;
	}

	public void setHubID(String hubID) {
		this.hubID = hubID;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public abstract void toStrings();



}