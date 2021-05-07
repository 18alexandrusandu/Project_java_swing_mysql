package presentation;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class NewProdus extends JPanel{
	private JTextField nameField;
	private JTextField quantityField;
	private JButton subButton;
	private JTextField priceField;
	
	public JTextField getPriceField() {
		return priceField;
	}

	public void setPriceField(JTextField priceField) {
		this.priceField = priceField;
	}

	public JTextField getNameField() {
		return nameField;
	}

	public void setNameField(JTextField nameField) {
		this.nameField = nameField;
	}

	public JTextField getQuantityField() {
		return quantityField;
	}

	public void setQuantityField(JTextField quantityField) {
		this.quantityField = quantityField;
	}

	public JButton getSubButton() {
		return subButton;
	}

	public void setSubButton(JButton subButton) {
		this.subButton = subButton;
	}

	public NewProdus() {
		setLayout(null);
		
	    subButton = new JButton("Submit");
		subButton.setBounds(334, 30, 89, 23);
		add(subButton);
		
		nameField = new JTextField();
		nameField.setBounds(10, 31, 86, 20);
		add(nameField);
		nameField.setColumns(10);
		
		quantityField = new JTextField();
		quantityField.setBounds(220, 31, 86, 20);
		add(quantityField);
		quantityField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setBounds(21, 11, 46, 14);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Initial quantity");
		lblNewLabel_1.setBounds(220, 6, 108, 14);
		add(lblNewLabel_1);
		
		priceField = new JTextField();
		priceField.setBounds(106, 31, 86, 20);
		add(priceField);
		priceField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Price per product");
		lblNewLabel_2.setBounds(106, 6, 86, 14);
		add(lblNewLabel_2);
	}

}
