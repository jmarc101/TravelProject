public abstract class Company extends TravelEntity {

	private String companyID;
	private String name;
	private String headquarterAddress;
	private double farePrice;


	private int routeID;

	public Company(String companyID, String name, String headquarterAddress, double farePrice) {
		this.companyID = companyID;
		this.name = name;
		this.headquarterAddress = headquarterAddress;
		this.farePrice = farePrice;
		routeID = 0;
	}

	public int getRouteID() {
		return routeID;
	}

	public void augmentID(int routeID) {
		this.routeID++;
	}




	public String getCompanyID() {
		return companyID;
	}

	public void setCompanyID(String companyID) {
		this.companyID = companyID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHeadquarterAddress() {
		return headquarterAddress;
	}

	public void setHeadquarterAddress(String headquarterAddress) {
		this.headquarterAddress = headquarterAddress;
	}

	public void setFarePrice(double farePrice) {
		this.farePrice = farePrice;
	}

	public double getFarePrice() {
		return this.farePrice;
	}

	public abstract void toStrings();



}