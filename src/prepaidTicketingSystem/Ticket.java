package prepaidTicketingSystem;

public class Ticket{
	int discount;
	double fare;
	Passenger passenger;
	
	public Ticket(Passenger passenger) {
		this.passenger = passenger;
		this.discount = 0;
		this.fare = 0;
	}
	
	public int calculateDiscount() {
		if ((passenger.getAge() > 0 && passenger.getAge() <= 10) || passenger.getAge() >= 50) {
			discount = 40;
		}
		else if (passenger.getNumberOfDays() >= 7 && passenger.getNumberOfDays() < 60) {
			discount += 10;
		}
		else if (passenger.getNumberOfDays() >= 60) {
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
		
		fare = fare * passenger.getNumberOfDays();
		
		if (discount > 0) {
			fare = (((100-newDiscount)/100)*fare);
		}
		
		return fare;
		
	}
	
	public String generateTicket() {
		return "New Wave Prepaid Ticket Dispensing Machine\nFull Name: " + passenger.getFullName() + "\nAge: " + passenger.getAge() + "\nOrigin Zone: Zone " + passenger.getOriginZone() + "\nDestination Zone: Zone " + passenger.getDestinationZone() + "\nNumber of Days: " + passenger.getNumberOfDays() + "\n******Ticket******\nPassenger Name: " + passenger.getFullName() + "\nTicket valid for " + passenger.getNumberOfDays() + " Day(s) \nTotal amount paid (UGX): " + this.calculateFare(passenger.getOriginZone(), passenger.getDestinationZone()) + "\nDiscount received: " + this.calculateDiscount() + "%\nThank you for travelling with us!";
	}
	
}
