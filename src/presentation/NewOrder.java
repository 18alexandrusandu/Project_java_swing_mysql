package presentation;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class NewOrder extends JPanel{
	private JTextField clientField;
	private JTextField produsField;
	private JTextField quantityField;
	private JButton subButton;
	public NewOrder() {
		setLayout(null);
		
		subButton = new JButton("Submit");
		subButton.setBounds(324, 29, 89, 23);
		add(subButton);
		
		clientField = new JTextField();
		clientField.setBounds(10, 29, 89, 23);
		add(clientField);
		clientField.setColumns(10);
		
		produsField = new JTextField();
		produsField.setBounds(109, 30, 86, 20);
		add(produsField);
		produsField.setColumns(10);
		
		quantityField = new JTextField();
		quantityField.setBounds(213, 30, 86, 20);
		add(quantityField);
		quantityField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("idClient");
		lblNewLabel.setBounds(27, 4, 72, 14);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("idProdus");
		lblNewLabel_1.setBounds(121, 4, 74, 14);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("quantity");
		lblNewLabel_2.setBounds(228, 5, 71, 14);
		add(lblNewLabel_2);
	}
	public JTextField getClientField() {
		return clientField;
	}
	public void setClientField(JTextField clientField) {
		this.clientField = clientField;
	}
	public JTextField getProdusField() {
		return produsField;
	}
	public void setProdusField(JTextField produsField) {
		this.produsField = produsField;
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

}
