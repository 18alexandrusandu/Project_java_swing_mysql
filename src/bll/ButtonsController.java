package bll;
import modele.*;


import connection.ConnectionFactory;
import javax.swing.*;
import javax.swing.table.TableModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Field;

import dao.*;
import presentation.*;
import validator.*
;
public class ButtonsController {
	
	public void clientButtons(JFrame jF,ClientInterface cI)
	{    ClientDao cd=new ClientDao();
	
		cI.getAddClientBtn().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e){  
				AddInterfaceButtonsController aibc=new AddInterfaceButtonsController ();
				JFrame frame2=new JFrame();
				NewClient ncI=new NewClient();
				aibc.newClientButtons( ncI,frame2,cI );
				frame2.setBounds(600,300,550,500);
				frame2.setContentPane(ncI);
				frame2.setVisible(true);
			
		       
		}});
		
		
		cI.getEditButton().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e){ 
				
				int row=cI.getTable().getSelectedRow();
				int index=TableToObject.findIndexFromRow(cI.getTable(),row);
				
				Client client=new Client();
				TableToObject.BuildObjectFromRow(client,cI.getTable(),row);
				cd.updatebyId(client, index);
				
				TableUpdater.updateClienti(cI);
		       
		}});
		cI.getDeleteBtn().addActionListener(new ActionListener() {
		
			
			public void actionPerformed(ActionEvent e){  
					
				int row=cI.getTable().getSelectedRow();
			
				int index=TableToObject.findIndexFromRow(cI.getTable(),row);
				cd.deletebyId(index);
				
				
				
				TableUpdater.updateClienti(cI);
		       
		}});
		cI.getRefreshBtn().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e){  
				
				
				TableUpdater.updateClienti(cI);
		       
		}});
		cI.getMenuBtn().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e){  
				presentation.Menu mI=new presentation.Menu();
				menuButtons(jF,mI);
				jF.setContentPane(mI);
				jF.setVisible(true);
		       
		}});
		
		
	}
	public void ordersButtons(JFrame jF,OrderInterface oI)
	{
		
		OrderDao od=new OrderDao();
		oI.getAddBtn().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e){  
			    AddInterfaceButtonsController aibc=new AddInterfaceButtonsController ();
				JFrame frame2=new JFrame();
				NewOrder noI=new NewOrder();
				aibc.newOrderButtons( noI,frame2,oI);
				frame2.setBounds(600,300,550,100);
				frame2.setContentPane(noI);
				frame2.setVisible(true);
				
		       
		}});
		oI.getEditBtn().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e){  
				int row=oI.getTable().getSelectedRow();
				int index=TableToObject.findIndexFromRow(oI.getTable(),row);
				Orders order=new Orders();
				TableToObject.BuildObjectFromRow(order,oI.getTable(),row);
				od.updatebyId(order, index);
				
				
				TableUpdater.updateOrders(oI);
		       
		}});
		oI.getDeleteBtn().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e){  
				
				int row=oI.getTable().getSelectedRow();
				int index=TableToObject.findIndexFromRow(oI.getTable(),row);
				od.deletebyId(index);
				
				TableUpdater.updateOrders(oI);
		       
		}});
		oI.getRefreshBtn().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e){  
				
				TableUpdater.updateOrders(oI);
		       
		}});
		oI.getMenuBtn().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e){  
				presentation.Menu mI=new presentation.Menu();
				menuButtons(jF,mI);
				jF.setContentPane(mI);
				jF.setVisible(true);
		       
		}});
	}

	public void produsButtons(JFrame jF,ProductInterface pI)
	{
		ProductDao pd=new ProductDao();
		pI.getAddButon().addActionListener(new ActionListener() {
			 AddInterfaceButtonsController aibc=new AddInterfaceButtonsController ();
			public void actionPerformed(ActionEvent e){  
				JFrame frame2=new JFrame();
				NewProdus npI=new NewProdus();
				aibc.newProductButtons(npI,frame2,pI);
				
				frame2.setBounds(600,300,550,100);
				frame2.setContentPane(npI);
				frame2.setVisible(true);
				
				
		       
		}});
		pI.getEditBtn().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e){ 
			
				int row=pI.getTable().getSelectedRow();
				int index=TableToObject.findIndexFromRow(pI.getTable(),row);
				Produs produs=new Produs();
				TableToObject.BuildObjectFromRow(produs,pI.getTable(),row);
				pd.updatebyId(produs, index);
				TableUpdater.updateProducts(pI);
		       
		}});
		pI.getDeleteBtn().addActionListener(new ActionListener() {
			
			
	
			public void actionPerformed(ActionEvent e){  
				int row=pI.getTable().getSelectedRow();
				int index=TableToObject.findIndexFromRow(pI.getTable(),row);
				pd.deletebyId(index);
				TableUpdater.updateProducts(pI);
		       
		}});
		pI.getRefreshButton().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e){  
				
				
				TableUpdater.updateProducts(pI);
		       
		}});
		pI.getMenuBtn().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e){  
				presentation.Menu mI=new presentation.Menu();
				menuButtons(jF,mI);
				jF.setContentPane(mI);
				jF.setVisible(true);
		       
		}});
		
	}
	
	public void menuButtons(JFrame jF,presentation.Menu mI)
	{
		mI.getClientButton().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e){  
				
				ClientInterface cI=new ClientInterface();
				
				clientButtons( jF,cI);
				TableUpdater.updateClienti(cI);
				jF.setBounds(0, 0, 500, 500);
				jF.setContentPane(cI);
				jF.setVisible(true);
		       
		}});
		
		mI.getOrdersButton().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e){  
				
		    OrderInterface oI=new OrderInterface();
			ordersButtons( jF,oI);
			TableUpdater.updateOrders(oI);
			jF.setBounds(0, 0, 500, 500);
			jF.setContentPane(oI);
			jF.setVisible(true);
		
		}});
		mI.getProductBtn().addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e){  
				
			    ProductInterface pI=new ProductInterface();
				produsButtons( jF,pI);
				TableUpdater.updateProducts(pI);
				jF.setBounds(0, 0, 500, 500);
				jF.setContentPane(pI);
				jF.setVisible(true);
				
		       
		}});
		
	}
	
	
	
	
	

}
