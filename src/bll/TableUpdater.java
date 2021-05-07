package bll;
import modele.*;
import connection.ConnectionFactory;
import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.awt.*;
import dao.*;
import presentation.*;
public class TableUpdater {
	
	static void  updateClienti(ClientInterface cI)
	{
	         
	         Connection con=ConnectionFactory.singleinstance.getConnection();
	         ClientDao cd=new ClientDao();
	         List<Client> clients= cd.findAll();
	         List<Object> objects=new ArrayList<Object> ();
	         for(Client client: clients)
	         {
	        	 objects.add(client);
	        	 
	        	 
	         }
	         
		    	TablePopulator.populate(cI.getTable(), objects);
		    
	}
	
	static void updateOrders(OrderInterface oI)
	{
	         
	         Connection con=ConnectionFactory.singleinstance.getConnection();
	         OrderDao od=new OrderDao();
	         List<Orders> orders= od.findAll();
	         List<Object> objects=new ArrayList<Object> ();
	         for(Orders order: orders)
	         {
	        	 objects.add(order);
	        	 
	        	 
	         }
	         
		    	TablePopulator.populate(oI.getTable(), objects);
		    
	}
	
	static void updateProducts(ProductInterface pI)
	{
	         
	         Connection con=ConnectionFactory.singleinstance.getConnection();
	         ProductDao pd=new ProductDao();
	         List<Produs> products= pd.findAll();
	         List<Object> objects=new ArrayList<Object> ();
	         for(Produs product: products)
	         {
	        	 objects.add(product);
	        	 
	        	 
	         }
	         
		    	TablePopulator.populate(pI.getTable(), objects);
		    
	}
	
	
	
	
	
	

}
