package prepaidTicketingSystem;

import javax.swing.ButtonGroup;
//import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
//import javax.swing.JScrollPane;
//import javax.swing.JTextArea;
import javax.swing.JTextField;
//import javax.swing.SwingUtilities;

import java.awt.BorderLayout;
//import java.awt.Component;
import java.awt.Dimension;
//import java.awt.FlowLayout;
import java.awt.GridLayout;
//import java.awt.KeyboardFocusManager;
//import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
//import java.awt.event.KeyListener;
import java.util.Random;

public class Main {
	private static JTextField focusedTextField;
	public static void main(String[] args) {
//		components
		JFrame frame;
		JPanel panel;
		JPanel keyboardPanel;
		JPanel originRadioButtons;
		JPanel destinationRadioButtons;
		JLabel title;
		JLabel fullNameLabel;
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
//		JOptionPane ticket;
		ActionListener submit;
//		components
		
//		component instantiation
		frame = new JFrame("Ticket Issuing System");
		panel = new JPanel(new GridLayout(0,3,300,300));
		keyboardPanel = new JPanel(new GridLayout(4, 10, 5, 10));
		originRadioButtons = new JPanel(new GridLayout(1,3));
		destinationRadioButtons = new JPanel(new GridLayout(1,3));
		title = new JLabel();
		ageLabel = new JLabel();
		fullNameLabel = new JLabel();
		numberOfDaysLabel = new JLabel("Number of Days: ");
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
				Random rand = new Random();
				Integer id = rand.nextInt(100000);
				try {
					String[] names = fullNameTextField.getText().split(" ");
					String firstName = names[0];
					String lastName = "";
					if (names.length > 1 && names.length < 3) {
						lastName = names[1];
					}
					else if (names.length > 2){
						JOptionPane.showMessageDialog(null, "Only two names are accepted!", "Error", JOptionPane.ERROR_MESSAGE);
					}
									
					String ageString = ageTextField.getText();
					String originZoneString = originZoneRadioButtonGroup.getSelection().getActionCommand();
					String destinationZoneString = destinationZoneRadioButtonGroup.getSelection().getActionCommand();
					String numberOfDaysString = numberOfDaysTextField.getText();
					
					if (firstName.isEmpty() || ageString.isEmpty() || originZoneString.isEmpty() || destinationZoneString.isEmpty() || numberOfDaysString.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Please fill in all fields", "Error", JOptionPane.ERROR_MESSAGE);
					}
					else if (originZoneString.equals(destinationZoneString)) {
						JOptionPane.showMessageDialog(null, "Your origin and destination zones can not be the same!", "Error", JOptionPane.ERROR_MESSAGE);
					}
					else {
						try{
							Integer age = Integer.parseInt(ageString);
							Integer originZone = Integer.parseInt(originZoneString);
							Integer destinationZone = Integer.parseInt(destinationZoneString);
							Integer numberOfDays = Integer.parseInt(numberOfDaysString);
							Passenger passenger = new Passenger(id, firstName, lastName, age, originZone, destinationZone, numberOfDays);
							Ticket passengerTicket = new Ticket(passenger);
//							System.out.println(passengerTicket.generateTicket());
							fullNameTextField.setText("");
							ageTextField.setText("");
							numberOfDaysTextField.setText("");
							JOptionPane.showMessageDialog(null, passengerTicket.generateTicket(), "Success", JOptionPane.INFORMATION_MESSAGE);
							fullNameTextField.setText("");
							ageTextField.setText("");
							numberOfDaysTextField.setText("");
						}
						catch(Exception exception) {
							JOptionPane.showMessageDialog(null, "Error: " + exception.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
						}
						
						
					}
				}catch (Exception except) {
					JOptionPane.showMessageDialog(null, "Please fill in all fields!", "Error", JOptionPane.ERROR_MESSAGE);
				}

			}
		};
//		logic	
		
//		frame configuration
		frame.setSize(900,600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		frame.add(keyboardPanel);
//		frame configuration
		
//		panel configuration
		panel.setLayout(new GridLayout(0,3,5,1));
		// Add the keyboardPanel to the frame first
		frame.add(keyboardPanel, BorderLayout.SOUTH);

		// Add the panel with other components to the frame
		frame.add(panel, BorderLayout.CENTER);
//		panel configuration
		
//		title
		title.setText("Ticket Issuing System");
//		title
		
//		user name label
		fullNameLabel.setText("Full Name: ");
//		user name label
		
//		age label
		ageLabel.setText("Age: ");
//		age label
		
//		labels

//		button group
		
//		origin zone
		originZoneRadioButtonGroup.add(originZoneRadioButton1);
		originZoneRadioButtonGroup.add(originZoneRadioButton2);
		originZoneRadioButtonGroup.add(originZoneRadioButton3);
		originRadioButtons.add(originZoneRadioButton1);
		originRadioButtons.add(originZoneRadioButton2);
		originRadioButtons.add(originZoneRadioButton3);
//		origin zone
		
//		destination zone
		destinationZoneRadioButtonGroup.add(destinationZoneRadioButton1);
		destinationZoneRadioButtonGroup.add(destinationZoneRadioButton2);
		destinationZoneRadioButtonGroup.add(destinationZoneRadioButton3);
		destinationRadioButtons.add(destinationZoneRadioButton1);
		destinationRadioButtons.add(destinationZoneRadioButton2);
		destinationRadioButtons.add(destinationZoneRadioButton3);
//		destination zone
		
//		button group
		
//		radio buttons
		originZoneRadioButton1.setActionCommand("1");
		originZoneRadioButton2.setActionCommand("2");
		originZoneRadioButton3.setActionCommand("3");
		destinationZoneRadioButton1.setActionCommand("1");
		destinationZoneRadioButton2.setActionCommand("2");
		destinationZoneRadioButton3.setActionCommand("3");
//		radio buttons
		
//		buttons
		
//		generate ticket button
		generateTicketButton.addActionListener(submit);
//		generate ticket button
		
//		buttons
		
//		add to panel
		panel.add(new JLabel());
		panel.add(title);
		panel.add(new JLabel());
		panel.add(new JLabel());
		panel.add(fullNameLabel);
		panel.add(new JLabel());
		panel.add(new JLabel());
		panel.add(fullNameTextField);
		panel.add(new JLabel());
		panel.add(new JLabel());
		panel.add(ageLabel);
		panel.add(new JLabel());
		panel.add(new JLabel());
		panel.add(ageTextField);
		panel.add(new JLabel());
		panel.add(new JLabel());
		panel.add(originZoneLabel);
		panel.add(new JLabel());
		panel.add(new JLabel());
		panel.add(originRadioButtons);
		panel.add(new JLabel());
		panel.add(new JLabel());
		panel.add(destinationZoneLabel);
		panel.add(new JLabel());
		panel.add(new JLabel());
		panel.add(destinationRadioButtons);
		panel.add(new JLabel());
		panel.add(new JLabel());
		panel.add(numberOfDaysLabel);
		panel.add(new JLabel());
		panel.add(new JLabel());
		panel.add(numberOfDaysTextField);
		panel.add(new JLabel());
		panel.add(new JLabel());
		panel.add(generateTicketButton);
		panel.add(new JLabel());
		panel.add(new JLabel());
//		add to panel
		
		
//		setting default focused text field to full name field
		focusedTextField = fullNameTextField;
		
//		focus listener for text fields
		FocusListener keyPress = new FocusListener() {
		    @Override
		    public void focusGained(FocusEvent e) {
//		    	System.out.println((JTextField) e.getComponent());
		        focusedTextField = (JTextField) e.getSource();
		    }

		    @Override
		    public void focusLost(FocusEvent e) {
//		    	nothing
		    }
		};
//		focus listener for text fields
		
		
//		adding focus listeners to text fields
		fullNameTextField.addFocusListener(keyPress);
		ageTextField.addFocusListener(keyPress);
		numberOfDaysTextField.addFocusListener(keyPress);
//		adding focus listeners to text fields


//		keyboard
		    String[] keys = {
		        "1", "2", "3", "4", "5", "6", "7", "8", "9", "0",
		        "Q", "W", "E", "R", "T", "Y", "U", "I", "O", "P",
		        "A", "S", "D", "F", "G", "H", "J", "K", "L", "ENTER",
		        "Z", "X", "C", "V", "B", "N", "M", "BACKSPACE", "SPACE"
		    };

		    for (String key : keys) {
		        JButton button = new JButton(key);
		        button.setMaximumSize(new Dimension(20,5));
		        
		        button.addActionListener(e -> {
		            String command = e.getActionCommand();
		                if (command.equals("BACKSPACE")) {
		                    if (focusedTextField.getText().length() > 0) {
		                        focusedTextField.setText(focusedTextField.getText().substring(0, focusedTextField.getText().length() - 1));
		                    }
		                } else if (command.equals("ENTER")) {
//		                    focusedTextField.setText(focusedTextField.getText() + "\n");
		                } else if (command.equals("SPACE")) {
		                    focusedTextField.setText(focusedTextField.getText() + " ");
		                } else {
		                    focusedTextField.setText(focusedTextField.getText() + "" + command);
		                }
		        });
		        keyboardPanel.add(button);
		    }
//		    keyboard
		    
//		    set the frame to visible
		    frame.setVisible(true);

		}
		
		
		
	}

//}
