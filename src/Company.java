import java.util.ArrayList;

public abstract class Company extends TravelEntity {

	private String companyID;
	private String name;
	private String headquarterAddress;
	private double farePrice;

	public Company(String companyID, String name, String headquarterAddress, double farePrice) {
		this.companyID = companyID;
		this.name = name;
		this.headquarterAddress = headquarterAddress;
		this.farePrice = farePrice;
	}


	public abstract Vehicle getVehicle(int index);

	public abstract void createVehicle();

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

	public abstract void getVehiclesStrings();

	public String useRouteID() {
		return null;
	}

	public String getRouteID() {
		return null;
	}



}