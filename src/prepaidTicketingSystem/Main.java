package prepaidTicketingSystem;

import java.util.Scanner;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		Random rand = new Random();
		int id = rand.nextInt(100000);
		String fullName;
		int age;
		int originZone;
		int destinationZone;
		int numberOfDays;
		
		Scanner input = new Scanner(System.in);
		
		System.out.println("New Wave Prepaid Ticket Dispensing Machine");
		System.out.print("Full Name: ");
		fullName = input.next();
		System.out.print("\nAge: ");
		age = input.nextInt();
		System.out.print("\nOrigin Zone: ");
		originZone = input.nextInt();
		System.out.print("\nDestination Zone: ");
		destinationZone = input.nextInt();
		System.out.print("\nNumber of Days: ");
		numberOfDays = input.nextInt();
		
		Passenger one = new Passenger(id, fullName, age, originZone, destinationZone, numberOfDays);
		System.out.println(one);
		Ticket oneTicket = new Ticket(id, fullName, age, originZone, destinationZone, numberOfDays);
		System.out.println(oneTicket.generateTicket());
	}

}
