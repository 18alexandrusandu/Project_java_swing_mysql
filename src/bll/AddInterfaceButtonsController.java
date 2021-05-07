package bll;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import dao.ClientDao;
import dao.OrderDao;
import dao.ProductDao;
import modele.Client;
import modele.Orders;
import modele.Produs;
import presentation.ClientInterface;
import presentation.NewClient;
import presentation.NewOrder;
import presentation.NewProdus;
import presentation.OrderInterface;
import presentation.ProductInterface;
import validator.OrderValidator;

public class AddInterfaceButtonsController {
	public void newClientButtons(NewClient ncI,JFrame jF,ClientInterface cI)
	{
		ClientDao cd=new ClientDao();
        ncI.getSubmitButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){  
				
			String name=ncI.getFirstNameField().getText();
				name+=" " + ncI.getLastNameField().getText();
						
			String adress=ncI.getAdressField().getText();
			String email=ncI.getEmailField().getText();
			Integer age=Integer.parseInt(ncI.getAgeField().getText());
				 Client newClient=new Client();
				 newClient.setAdress(adress);
				 newClient.setAge(age);
				 newClient.setEmail(email);
				 newClient.setName(name);
				 newClient.setId(cd.insert(newClient));
				 jF.setVisible(false);
				 TableUpdater.updateClienti(cI);
				 
		}});
		
	}
	public void newOrderButtons(NewOrder noI,JFrame jF,OrderInterface oI)
	{
		OrderDao od=new OrderDao();
		ProductDao pd=new ProductDao();
		
		  noI.getSubButton().addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e){  
					
					
					int idClient=Integer.parseInt(noI.getClientField().getText());
					int idProdus= Integer.parseInt(noI.getProdusField().getText());
					int quantity=Integer.parseInt(noI.getQuantityField().getText());
					 Orders newOrder=new Orders();
					 newOrder.setIdClient(idClient);
					 newOrder.setIdProdus(idProdus);
					 newOrder.setQuantity(quantity);
					 System.out.println(idClient + " " +idProdus + " "+ quantity );
					 
					 if(OrderValidator.validateOrder(newOrder))
					 {
						 od.insert(newOrder);
						 Produs produs=pd.findById(newOrder.getIdProdus());
						 int newquantity=produs.getQuantity()-newOrder.getQuantity();
						 produs.setQuantity(newquantity);
						 pd.updatebyId(produs, newOrder.getIdProdus());
						 
						 JOptionPane.showMessageDialog(null, "Order succeded!");
						 jF.setVisible(false);
						 
						 
					 }
					 else
					 {
						 JOptionPane.showMessageDialog(null, "Eroare: ordder failed check id's and quantity!");
						 jF.setVisible(false);
					 }
						 
						 
					 TableUpdater.updateOrders(oI);
				
			       
			}});
		
	}
	
	public void newProductButtons(NewProdus npI,JFrame jF,ProductInterface pI)
	{
		ProductDao pd=new ProductDao();
		  npI.getSubButton().addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e){  
			  int quantity=Integer.parseInt( npI.getQuantityField().getText());
			  String name=npI.getNameField().getText();
			  double price=Double.parseDouble(npI.getPriceField().getText());
			  Produs produs=new Produs();
			  produs.setName(name);
	          produs.setQuantity(quantity);
	          produs.setPret(price);
	          produs.setId(pd.insert(produs));
	          jF.setVisible(false);
	          TableUpdater.updateProducts(pI);
			       
			}});
		
	}
}
