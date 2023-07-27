package prepaidTicketingSystem;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Main {
	
	public static void main(String[] args) {

//		components
		JFrame frame;
		JPanel panel;
		JLabel title;
		JLabel userNameLabel;
		JLabel passwordLabel;
		JLabel ageLabel;
		JLabel originZoneLabel;
		JLabel destinationZoneLabel;
		JLabel numberOfDaysLabel;
		JTextField fullNameTextField;
		JTextField ageTextField;
		JTextField numberOfDaysTextField;
		JRadioButton originZoneRadioButton1;
		JRadioButton originZoneRadioButton2;
		JRadioButton originZoneRadioButton3;
		JRadioButton destinationZoneRadioButton1;
		JRadioButton destinationZoneRadioButton2;
		JRadioButton destinationZoneRadioButton3;
		ButtonGroup originZoneRadioButtonGroup;
		ButtonGroup destinationZoneRadioButtonGroup;
		JButton generateTicketButton;
		JTextArea ticket;
		ActionListener submit;
//		components
		
//		component instantiation
		frame = new JFrame("Ticket Issuing System");
		panel = new JPanel();
		title = new JLabel();
		ageLabel = new JLabel();
		userNameLabel = new JLabel();
		passwordLabel = new JLabel();
		numberOfDaysLabel = new JLabel("Number of Days: ");
		ticket = new JTextArea();
		numberOfDaysTextField = new JTextField();
		fullNameTextField = new JTextField();
		ageTextField = new JTextField();
		originZoneLabel = new JLabel("Origin Zone");
		destinationZoneLabel = new JLabel("Destination Zone");
		originZoneRadioButtonGroup = new ButtonGroup();
		originZoneRadioButton1 = new JRadioButton("ZONE 1");
		originZoneRadioButton2 = new JRadioButton("ZONE 2");
		originZoneRadioButton3 = new JRadioButton("ZONE 3");
		destinationZoneRadioButtonGroup = new ButtonGroup();
		destinationZoneRadioButton1 = new JRadioButton("ZONE 1");
		destinationZoneRadioButton2 = new JRadioButton("ZONE 2");
		destinationZoneRadioButton3 = new JRadioButton("ZONE 3");
		generateTicketButton = new JButton("Generate Ticket");
//		component instantiation
		
//		Logic
		submit = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Random rand = new Random();
				int id = rand.nextInt(100000);
				String fullName = fullNameTextField.getText();
				String ageString = ageTextField.getText();
				int age = Integer.parseInt(ageString);
				
				String originZoneString = originZoneRadioButtonGroup.getSelection().getActionCommand();
				int originZone = Integer.parseInt(originZoneString);
				
				String destinationZoneString = destinationZoneRadioButtonGroup.getSelection().getActionCommand();
				int destinationZone = Integer.parseInt(destinationZoneString);
				
				String numberOfDaysString = numberOfDaysTextField.getText();
				int numberOfDays = Integer.parseInt(numberOfDaysString);
				
				
				
				Passenger one = new Passenger(id, fullName, age, originZone, destinationZone, numberOfDays);
				System.out.println(one);
				Ticket oneTicket = new Ticket(id, fullName, age, originZone, destinationZone, numberOfDays);
				System.out.println(oneTicket.generateTicket());
				ticket.setLineWrap(true);
				ticket.setWrapStyleWord(true);
				ticket.setText(oneTicket.generateTicket());
				ticket.setBounds(10,320,400,200);
				panel.add(ticket);
			}
			
		};
		
//		logic	
		
//		frame configuration
		frame.setSize(500,600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.add(panel);
//		frame configuration
		
//		panel configuration
		panel.setLayout(null);
//		panel configuration
		
//		components
		
//		labels
		
//		title
		title.setText("Ticket Issuing System");
		title.setBounds(10,20,150,25);
//		title
		
//		user name label
		userNameLabel.setText("Full Name: ");
		userNameLabel.setBounds(10,50,80,25);
//		user name label
		
//		age label
		ageLabel.setText("Age: ");
		ageLabel.setBounds(10,80,80,25);
//		age label
		
//		origin zone
		originZoneLabel.setBounds(10,110,100,25);
//		origin zone
		
//		destination zone label
		destinationZoneLabel.setBounds(10,190,100,25);
//		destination zone label
		
//		number of days label
		numberOfDaysLabel.setBounds(10,250,100,25);
//		number of days label
		
//		labels
		
//		text fields
		
//		full name
		fullNameTextField.setBounds(100,50,80,25);
//		full name
		
//		age
		ageTextField.setBounds(100,80,80,25);
//		age
		
//		number of days text field
		numberOfDaysTextField.setBounds(120,250,80,25);
//		number of days text field
		
//		text fields

//		button group
		
//		origin zone
		originZoneRadioButtonGroup.add(originZoneRadioButton1);
		originZoneRadioButtonGroup.add(originZoneRadioButton2);
		originZoneRadioButtonGroup.add(originZoneRadioButton3);
//		origin zone
		
//		destination zone
		destinationZoneRadioButtonGroup.add(destinationZoneRadioButton1);
		destinationZoneRadioButtonGroup.add(destinationZoneRadioButton2);
		destinationZoneRadioButtonGroup.add(destinationZoneRadioButton3);
//		destination zone
		
//		button group
		
//		radio buttons
		originZoneRadioButton1.setActionCommand("1");
		originZoneRadioButton2.setActionCommand("2");
		originZoneRadioButton3.setActionCommand("3");
		destinationZoneRadioButton1.setActionCommand("1");
		destinationZoneRadioButton2.setActionCommand("2");
		destinationZoneRadioButton3.setActionCommand("3");
		originZoneRadioButton1.setBounds(10,140,100,25);
		originZoneRadioButton2.setBounds(110,140,100,25);
		originZoneRadioButton3.setBounds(210,140,100,25);
		destinationZoneRadioButton1.setBounds(10,210,100,25);
		destinationZoneRadioButton2.setBounds(110,210,100,25);
		destinationZoneRadioButton3.setBounds(210,210,100,25);
//		radio buttons
		
//		generate ticket button
		generateTicketButton.setBounds(50,280,150,35);
		generateTicketButton.addActionListener(submit);
//		generate ticket button
		
//		add to panel
		panel.add(title);
		panel.add(fullNameTextField);
		panel.add(userNameLabel);
		panel.add(ageTextField);
		panel.add(ageLabel);
		panel.add(originZoneRadioButton1);
		panel.add(originZoneRadioButton2);
		panel.add(originZoneRadioButton3);
		panel.add(destinationZoneRadioButton1);
		panel.add(destinationZoneRadioButton2);
		panel.add(destinationZoneRadioButton3);
		panel.add(originZoneLabel);
		panel.add(destinationZoneLabel);
		panel.add(numberOfDaysLabel);
		panel.add(numberOfDaysTextField);
		panel.add(generateTicketButton);
//		add to panel
		
	}

}
