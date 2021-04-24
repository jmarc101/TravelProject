import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Route extends TravelEntity implements IVisitable, ISubject {


	private String routeID;
	private String startHubID;
	private String endHubID;
	private LocalDate dateDebut;
	private LocalDate dateFin;
	private Company company;
	private double price;
	private String duration;
	private Vehicle vehicle;


	public Route(String routeID, String startHubID, String endHubID, LocalDate dateDebut, LocalDate dateFin, Company company, Vehicle vehicle) {
		this.routeID = routeID;
		this.startHubID = startHubID;
		this.endHubID = endHubID;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.company = company;
		this.price = price;
		this.vehicle = vehicle;

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

	public LocalDate getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(LocalDate dateDebut) {
		this.dateDebut = dateDebut;
	}

	public LocalDate getDateFin() {
		return dateFin;
	}

	public void setDateFin(LocalDate dateFin) {
		this.dateFin = dateFin;
	}

	public Company getCompanyID() {
		return company;
	}

	public void setCompanyID(Company company) {
		this.company = company;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
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


	/**
	 * 
	 * @param o
	 */
	public void attach(IObserver o) {
		// TODO - implement Route.attach
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param o
	 */
	public void detach(IObserver o) {
		// TODO - implement Route.detach
		throw new UnsupportedOperationException();
	}

	public void notifyObs() {
		// TODO - implement Route.notify
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param seatID
	 */
	public boolean reserveSeat(String seatID) {
		// TODO - implement Route.reserveSeat
		throw new UnsupportedOperationException();
	}



	@Override
	public void acceptVisitor(IVisitor v) {

	}
}