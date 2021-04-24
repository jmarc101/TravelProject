import java.time.LocalDate;
import java.util.Date;

public class UserClient extends User {

	private String passportNumber;
	private String passportExpiration;

	public UserClient(String userName, String password, String firstName, String lastName, String email,
					  String address, String phone, String dateOfBirth, String passportNumber, String passportExpiration) {
		super(userName, password, firstName, lastName, email, address, phone, dateOfBirth);
		this.passportNumber = passportNumber;
		this.passportExpiration = passportExpiration;
	}


	public String getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}

	public String getPassportExpiration() {
		return passportExpiration;
	}

	public void setPassportExpiration(String passportExpiration) {
		this.passportExpiration = passportExpiration;
	}


}