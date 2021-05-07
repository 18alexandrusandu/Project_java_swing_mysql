package presentation;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class NewClient extends JPanel{
	private JTextField firstNameField;
	private JTextField adressField;
	private JTextField emailField;
	private JTextField ageField;
	private JTextField lastNameField;
	private JButton submitButton;
	public NewClient() {
		setLayout(null);
		
		submitButton = new JButton("Submit");
		submitButton.setBounds(106, 274, 98, 23);
		add(submitButton);
		
		firstNameField = new JTextField();
		firstNameField.setBounds(106, 25, 160, 20);
		add(firstNameField);
		firstNameField.setColumns(10);
		
		adressField = new JTextField();
		adressField.setBounds(106, 111, 160, 20);
		add(adressField);
		adressField.setColumns(10);
		
		emailField = new JTextField();
		emailField.setBounds(106, 161, 160, 20);
		add(emailField);
		emailField.setColumns(10);
		
		ageField = new JTextField();
		ageField.setBounds(106, 204, 160, 20);
		add(ageField);
		ageField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Last Name");
		lblNewLabel.setBounds(10, 74, 74, 14);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Adress");
		lblNewLabel_1.setBounds(10, 114, 86, 14);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("email");
		lblNewLabel_2.setBounds(10, 161, 86, 20);
		add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("age");
		lblNewLabel_3.setBounds(10, 207, 74, 14);
		add(lblNewLabel_3);
		
		lastNameField = new JTextField();
		lastNameField.setBounds(106, 71, 160, 20);
		add(lastNameField);
		lastNameField.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("First Name");
		lblNewLabel_4.setBounds(10, 28, 86, 14);
		add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Introduce information for a new client");
		lblNewLabel_5.setBounds(294, 28, 188, 35);
		add(lblNewLabel_5);
	}
	public JTextField getFirstNameField() {
		return firstNameField;
	}
	public void setFirstNameField(JTextField firstNameField) {
		this.firstNameField = firstNameField;
	}
	public JTextField getAdressField() {
		return adressField;
	}
	public void setAdressField(JTextField adressField) {
		this.adressField = adressField;
	}
	public JTextField getEmailField() {
		return emailField;
	}
	public void setEmailField(JTextField emailField) {
		this.emailField = emailField;
	}
	public JTextField getAgeField() {
		return ageField;
	}
	public void setAgeField(JTextField ageField) {
		this.ageField = ageField;
	}
	public JTextField getLastNameField() {
		return lastNameField;
	}
	public void setLastNameField(JTextField lastNameField) {
		this.lastNameField = lastNameField;
	}
	public JButton getSubmitButton() {
		return submitButton;
	}
	public void setSubmitButton(JButton submitButton) {
		this.submitButton = submitButton;
	}
}
