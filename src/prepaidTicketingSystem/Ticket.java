package prepaidTicketingSystem;

public class Ticket extends Passenger{
	int discount;
	double fare;
	Passenger passenger;
	
	public Ticket(int id, String fullName, int age, int originZone, int destinationZone, int numberOfDays) {
		super(id, fullName, age, originZone, destinationZone, numberOfDays);
		this.discount = 0;
		this.fare = 0;
	}
	
	public int calculateDiscount() {
		if ((age > 0 && age <= 10) || age >= 50) {
			discount = 40;
		}
		else if (numberOfDays >= 7 && numberOfDays < 60) {
			discount += 10;
		}
		else if (numberOfDays >= 60) {
			discount += 40;
		}
		else {
			
		}
		return discount;
	}
	
	public double calculateFare(int originZone, int destinationZone) {
		double newDiscount = calculateDiscount();
		if ((originZone == 1 && destinationZone == 2) || (originZone == 2 && destinationZone == 1)) {
			fare += ConstantDataManager.zone2tozone1;
		}
		else if ((originZone == 1 && destinationZone == 3) || (originZone == 3 && destinationZone == 1)) {
			fare += ConstantDataManager.zone3tozone1;
		}
		else if ((originZone == 2 && destinationZone == 3) || (originZone == 3 && destinationZone == 2)) {
			fare += ConstantDataManager.zone2tozone3;
		}
		
		fare = fare * numberOfDays;
		
		if (discount > 0) {
			fare = (((100-newDiscount)/100)*fare);
		}
		
		return fare;
		
	}
	
	public String generateTicket() {
		return "New Wave Prepaid Ticket Dispensing Machine\nFull Name: " + this.getFullName() + "\nAge: " + this.getAge() + "\nOrigin Zone: Zone " + this.getOriginZone() + "\nDestination Zone: Zone " + this.getDestinationZone() + "\nNumber of Days: " + this.getNumberOfDays() + "\n******Ticket******\nPassenger Name: " + this.getFullName() + "\nTicket valid for " + this.getNumberOfDays() + " Day(s) \nTotal amount paid (UGX): " + this.calculateFare(this.getOriginZone(), this.getDestinationZone()) + "\nDiscount received: " + this.calculateDiscount() + "%\nThank you for travelling with us!";
	}
	
}
