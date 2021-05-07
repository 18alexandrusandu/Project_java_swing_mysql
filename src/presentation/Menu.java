package presentation;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu extends JPanel{
	
	JButton clientButton;
	JButton ordersButton;
	JButton productButton;
	
	
	public Menu() {
		setLayout(null);
		
		clientButton = new JButton("Clients");
		clientButton.setBounds(182, 45, 89, 23);
		add(clientButton);
		
	    ordersButton = new JButton("Orders");
		ordersButton.setBounds(182, 96, 89, 23);
		add(ordersButton);
		
	    productButton = new JButton("Products");
		productButton.setBounds(182, 151, 89, 23);
		add(productButton);
	}


	public JButton getClientButton() {
		return clientButton;
	}


	public void setClientButton(JButton clientButton) {
		clientButton = clientButton;
	}


	public JButton getOrdersButton() {
		return ordersButton;
	}


	public void setOrdersButton(JButton ordersButton) {
		ordersButton = ordersButton;
	}


	public JButton getProductBtn() {
		return productButton;
	}


	public void setProductBtn(JButton productBtn) {
		productButton = productBtn;
	}



}
