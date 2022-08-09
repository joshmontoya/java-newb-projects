package bankAccountUpdates;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.NumberFormat;
import java.util.ArrayList;

//Class creation extend JFrame for GUI, ActionListener for JButton and field enter functionality
//& ChangeListener for JSpinner
public class BankAccountGUI extends JFrame implements ActionListener {
	//Private Swing variable class declarations 
	private JLabel currBalLabel, depLabel, depConfLabel, withdLabel, withdConfLabel, newBalLabel;
	private JTextField newBalField, currBalField, depField, withdField;
	private JButton newBalButton;
	private JPanel entryPanel, newBalPanel;
	//Declare class variables
	private Double balance, deposit, withdrawal;
	private ArrayList<Double> deposits = new ArrayList<>();
	private ArrayList<Double> withdrawals = new ArrayList<>();
	
	//Object constructor for BankAccount GUI object
	BankAccountGUI() {
		setTitle("Montoya Bank Application");
		//Label assignment/configuration
		currBalLabel = new JLabel("Enter your current bank balance:");
		depLabel = new JLabel("Enter amount of deposit:");
		withdLabel = new JLabel("Enter amount of withdrawal:");
		newBalLabel = new JLabel("Your updated bank balance is:");
		depConfLabel = new JLabel();
		depConfLabel.setFont(new Font("Verdana", Font.PLAIN, 10));
		depConfLabel.setForeground(Color.blue);
		withdConfLabel = new JLabel();
		withdConfLabel.setFont(new Font("Verdana", Font.PLAIN, 10));
		withdConfLabel.setForeground(Color.blue);
		//Field assignment/configuration
		currBalField = new JTextField(10);
		currBalField.setEditable(true);
		depField = new JTextField(10);
		depField.setEditable(true);
		withdField = new JTextField(10);
		withdField.setEditable(true);
		newBalField = new JTextField(10);
		newBalField.setEditable(false);
		//Button assignment/configuration
		newBalButton = new JButton("View Updated Balance");
		
		//Configure Entry Panel
		entryPanel = new JPanel();
		entryPanel.setBounds(0, 0, 500, 200);
		entryPanel.setLayout(new GridBagLayout());
		GridBagConstraints g = new GridBagConstraints();
		//Current Balance Row
		g.weightx = 1;
		g.weighty = 1;
		g.gridx = 0;
		g.gridy = 0;
		g.insets = new Insets(10, 5, 10, 10);
		g.anchor = GridBagConstraints.FIRST_LINE_END;
		entryPanel.add(currBalLabel, g);
		g.gridx = 1;
		g.gridy = 0;
		g.insets = new Insets(8, 0, 0, 0);
		g.anchor = GridBagConstraints.FIRST_LINE_START;
		entryPanel.add(currBalField, g);
		//Deposit Rows
		g.gridx = 0;
		g.gridy = 1;
		g.insets = new Insets(10, 5, 10, 10);
		g.anchor = GridBagConstraints.FIRST_LINE_END;
		entryPanel.add(depLabel, g);
		g.gridx = 1;
		g.gridy = 1;
		g.insets = new Insets(8, 0, 0, 0);
		g.anchor = GridBagConstraints.FIRST_LINE_START;
		entryPanel.add(depField, g);
		g.gridx = 0;
		g.gridy = 2;
		g.insets = new Insets(0, 0, 0, 0);
		g.anchor = GridBagConstraints.LINE_END;
		entryPanel.add(depConfLabel, g);
		//Withdrawal Rows
		g.gridx = 0;
		g.gridy = 3;
		g.insets = new Insets(10, 5, 10, 10);
		g.anchor = GridBagConstraints.FIRST_LINE_END;
		entryPanel.add(withdLabel, g);
		g.gridx = 1;
		g.gridy = 3;
		g.insets = new Insets(8, 0, 0, 0);
		g.anchor = GridBagConstraints.FIRST_LINE_START;
		entryPanel.add(withdField, g);
		g.gridx = 0;
		g.gridy = 4;
		g.insets = new Insets(0, 0, 0, 0);
		g.anchor = GridBagConstraints.FIRST_LINE_END;
		entryPanel.add(withdConfLabel, g);
		//Button Row
		g.gridx = 0;
		g.gridy = 5;
		g.insets = new Insets(8, 3, 10, 10);
		g.anchor = GridBagConstraints.FIRST_LINE_END;
		entryPanel.add(newBalButton, g);	
		add(entryPanel);
		
		//Configure Updated Balance Panel
		newBalPanel = new JPanel();
		newBalPanel.setBackground(Color.green);
		newBalPanel.setBounds(0, 212, 500, 50);
		newBalPanel.setLayout(new GridBagLayout());
		g.weightx = 1;
		g.weighty = 1;
		g.gridx = 0;
		g.gridy = 0;
		g.insets = new Insets(10, 10, 10, 0);
		g.anchor = GridBagConstraints.LINE_END;
		newBalPanel.add(newBalLabel, g);
		g.gridx = 1;
		g.gridy = 0;
		g.insets = new Insets(8, 3, 10, 10);
		g.anchor = GridBagConstraints.LINE_START;
		newBalPanel.add(newBalField, g);
		add(newBalPanel);
		
		//ActionListener assignments/configurations
		currBalField.addActionListener(this);
		depField.addActionListener(this);
		withdField.addActionListener(this);
		newBalButton.addActionListener(this);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == newBalButton) {
			if(balance != null) {
				balance = balance + (addAmts(deposits) - addAmts(withdrawals)) ; //Calculate updated balance
				//Actions to perform on button click (outputting updated balance & clearing/resetting fields to new values)
				newBalField.setText(NumberFormat.getCurrencyInstance().format(balance));
				balance = null;
				deposits.clear();
				withdrawals.clear();
				depField.setText("");
				currBalField.setText("");
				withdField.setText("");
				depConfLabel.setText("");
				withdConfLabel.setText("");
				currBalField.setEditable(true);
			}else {
				JOptionPane.showMessageDialog(this, "You have not entered your current bank balance");
			}

		}else if(e.getSource() == currBalField) {
			try {
				balance = Double.parseDouble(currBalField.getText());
				currBalField.setText(NumberFormat.getCurrencyInstance().format(balance));
				currBalField.setEditable(false);
			}catch(NumberFormatException exp) {
				JOptionPane.showMessageDialog(this, "You must enter numeric value only");
			}
		}else if(e.getSource() == depField) {
			try {
				deposit = Double.parseDouble(depField.getText());
				deposits.add(deposit);
				depField.setText("");
				depConfLabel.setText("Your deposit of " + NumberFormat.getCurrencyInstance().format(deposit) + " has been registered");
			}catch(NumberFormatException exp) {
				JOptionPane.showMessageDialog(this, "You must enter numeric value only");
			}
		}else if(e.getSource() == withdField) {
			try {
				withdrawal = Double.parseDouble(withdField.getText());
				withdrawals.add(withdrawal);
				withdField.setText("");
				withdConfLabel.setText("Your withdrawal of " + NumberFormat.getCurrencyInstance().format(withdrawal) + " has been registered");
			}catch(NumberFormatException exp) {
				JOptionPane.showMessageDialog(this, "You must enter numeric value only");
			}
		}
		
		
	}
	
	public Double addAmts(ArrayList<Double> amts) {
		Double total = 0.0;
		for(Double x : amts) {
			total = total + x;
		}
		return total;
	}
	

	public static void main(String[] args) {
		BankAccountGUI appFrame = new BankAccountGUI(); //Create BankAccountGUI JFrame object to launch GUI
		
		//Set default configuration for frame
		appFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		appFrame.setLayout(null);
		appFrame.setSize(500, 300);
		appFrame.setResizable(false);
		appFrame.setVisible(true);

	}


}
