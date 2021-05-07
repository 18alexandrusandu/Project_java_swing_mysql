package start;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import com.itextpdf.kernel.pdf.*;
import com.itextpdf.layout.*;

import bll.ButtonsController;
import bll.TablePopulator;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JFrame;

import  java.sql.Connection;
import java.text.SimpleDateFormat;

import connection.ConnectionFactory;
import dao.*;
import modele.*;
import presentation.ClientInterface;
public class Start {
	

	
	

	public static void main(String[] args) {
		
         ConnectionFactory.singleinstance.createConnection();
         JFrame jF=new JFrame();
         presentation.Menu mI=new presentation.Menu();
         ButtonsController buttonsController=new ButtonsController();
         buttonsController.menuButtons(jF, mI);
         jF.setContentPane(mI);
         jF.setBounds(0, 0, 500, 300);
         
	     jF.setVisible(true);
	
	}
	
	

}
