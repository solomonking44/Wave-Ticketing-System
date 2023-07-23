package prepaidTicketingSystem;

public class Passenger {

	int id;
	String fullName;
	int age;
	int originZone;
	int destinationZone;
	int numberOfDays;
	
	public Passenger(int id, String fullName, int age, int originZone, int destinationZone, int numberOfDays) {
		this.id = id;
		this.fullName = fullName;
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
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
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
		return "Passenger [id=" + id + ", fullName=" + fullName + ", age=" + age + ", originZone=" + originZone
				+ ", destinationZone=" + destinationZone + ", numberOfDays=" + numberOfDays + "]";
	}

	
}
