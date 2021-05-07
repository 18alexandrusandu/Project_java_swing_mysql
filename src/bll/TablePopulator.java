package bll;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class TablePopulator {
	
	static public void populate(JTable jT,List<Object> objList)
	{  
		ArrayList<String> colums=new ArrayList<String>();
		
		for(Field field: objList.get(0).getClass().getDeclaredFields())
		{
			field.setAccessible(true);
			colums.add(field.getName());

		}
		
		String S[]=new String[colums.size()];	
		
		int i=0;
		int j=0;
		for(String colum:colums)
		{
			S[i]=colum;
			i++;

		}
		
		DefaultTableModel tm= new DefaultTableModel(null,S);
		i=0;
		for(Object obj:objList)
		{
			ArrayList<Object> values=new ArrayList<Object>();
			
			for(Field field: obj.getClass().getDeclaredFields())
			{   field.setAccessible(true);
				try {
					Object value=field.get(obj);
					values.add(value);
				} catch (IllegalArgumentException | IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				

			}
			
			Object O[]=new Object[values.size()];	
			i=0;
			for(Object value:values)
			{
				O[i]=value;
				i++;

			}
			
			
				tm.insertRow(j,O);
			j++;
		
		}
		
		
     	 jT.setModel(tm);
		
	}
	
	
	

}
