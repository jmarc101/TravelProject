import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Route extends TravelEntity implements IVisitable{


	private String routeID;
	private String startHubID;
	private String endHubID;
	private String dateDebut;
	private String dateFin;
	private Company company;
	private String duration;
	private Vehicle vehicle;



	public Route(String routeID, String startHubID, String endHubID, String dateDebut, String dateFin, Company company, Vehicle vehicle) {
		this.routeID = routeID;
		this.startHubID = startHubID;
		this.endHubID = endHubID;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.company = company;
		this.vehicle = vehicle;


	}


	@Override
	public void acceptVisitor(IVisitor v) {
		v.visit(this);
	}



	public String getRouteID() {
		return routeID;
	}

	public void setRouteID(String routeID) {
		this.routeID = routeID;
	}

	public String getStartHubID() {
		return startHubID;
	}

	public void setStartHubID(String startHubID) {
		this.startHubID = startHubID;
	}

	public String getEndHubID() {
		return endHubID;
	}

	public void setEndHubID(String endHubID) {
		this.endHubID = endHubID;
	}

	public String getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(String dateDebut) {
		this.dateDebut = dateDebut;
	}

	public String getDateFin() {
		return dateFin;
	}

	public void setDateFin(String dateFin) {
		this.dateFin = dateFin;
	}

	public Company getCompanyID() {
		return company;
	}

	public void setCompanyID(Company company) {
		this.company = company;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}
	
	public ArrayList<Seat> getSeats(){
		return this.vehicle.getSeats();
	}

}


