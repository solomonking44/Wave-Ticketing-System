package prepaidTicketingSystem;

public class Passenger {

	int id;
	String firstName;
	String lastName;
	int age;
	int originZone;
	int destinationZone;
	int numberOfDays;
	
	public Passenger(int id, String firstName, String lastName, int age, int originZone, int destinationZone, int numberOfDays) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.originZone = originZone;
		this.destinationZone = destinationZone;
		this.numberOfDays = numberOfDays;
	}
	
	public Passenger(int id, String firstName, int age, int originZone, int destinationZone, int numberOfDays) {
		this.id = id;
		this.firstName = firstName;
		this.age = age;
		this.originZone = originZone;
		this.destinationZone = destinationZone;
		this.numberOfDays = numberOfDays;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullName() {
		return firstName + " " + lastName;
	}

	public void setFullName(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getOriginZone() {
		return originZone;
	}

	public void setOriginZone(int originZone) {
		this.originZone = originZone;
	}

	public int getDestinationZone() {
		return destinationZone;
	}

	public void setDestinationZone(int destinationZone) {
		this.destinationZone = destinationZone;
	}

	public int getNumberOfDays() {
		return numberOfDays;
	}

	public void setNumberOfDays(int numberOfDays) {
		this.numberOfDays = numberOfDays;
	}

	@Override
	public String toString() {
		return "Passenger [id=" + id + ", fullName=" + firstName + " " + lastName + ", age=" + age + ", originZone=" + originZone
				+ ", destinationZone=" + destinationZone + ", numberOfDays=" + numberOfDays + "]";
	}

	
}
