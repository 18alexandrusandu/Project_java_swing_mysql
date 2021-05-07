package dao;
import java.io.IOException;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import connection.ConnectionFactory;
import modele.Client;
import modele.Orders;
import modele.Produs;
public class OrderDao extends AbstractDao<Orders>{
	
     void makeBill(Orders order)
	{
	PDDocument document = new PDDocument();
	PDPage page = new PDPage();
	document.addPage(page);
	
     Connection con = ConnectionFactory.singleinstance.getConnection();
     ClientDao cd=new ClientDao();
     ProductDao pd=new  ProductDao();
     String text1="Order nr:"+order.getId();
     
     Client newClient=cd.findById(order.getIdClient());
     Produs newProdus= pd.findById(order.getIdProdus());
     
     SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
     Date date = new Date(System.currentTimeMillis());
  
        String text5="La data:"+ formatter.format(date);
        
      String text2= "Client nr:"+order.getIdClient() +" with name:"+ newClient.getName();
      String text3= "Product nr:"+order.getIdProdus() +" with name:"+ newProdus.getName();
      String text6= "Quantity:"+order.getQuantity(); 
      String text4= "Price:"+ String.valueOf(newProdus.getPret()*order.getQuantity());
       
       
	try {   
	
	PDPageContentStream contentStream = new PDPageContentStream(document, page);
    contentStream.setFont(PDType1Font.COURIER, 12);	
	contentStream.beginText(); 
	contentStream.newLineAtOffset(25, 700);
    contentStream.setLeading(14.5f);  
    
	contentStream.showText(text1);
	contentStream.newLine();
	contentStream.showText(text5);
	contentStream.newLine();
	contentStream.showText(text2);
	contentStream.newLine();
	contentStream.showText(text3);
	contentStream.newLine();
	contentStream.showText(text6);
	contentStream.newLine();
	contentStream.showText(text4);
	contentStream.endText();
    contentStream.close();	
    
	String pdf="NewOrder"+order.getId();
	document.save(pdf+".pdf");
	
	

	document.close();	
	
	
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

		
	}
	
	public int insert(Orders obj)
	{
		
		obj.setId(super.insert(obj));
		makeBill(obj);
		return 0;
		
	}
	
	
	

}
