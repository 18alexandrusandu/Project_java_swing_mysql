package bll;

import java.lang.reflect.Field;

import javax.swing.JTable;
import javax.swing.table.TableModel;

public class TableToObject {
	
	static int findIndexFromRow(JTable jT,int row)
	{
		TableModel dm=jT.getModel();
		int j=-1;
		for(int i=0;i<dm.getColumnCount();i++)
		{
			
			if(dm.getColumnName(i).equals("id"))
			j=i;
			
		}
		if(j>-1)
		return (Integer)dm.getValueAt(row,j);
		
		return 0;
		
	}
	
	static  void BuildObjectFromRow(Object obj,JTable jT,int row)
	{
		TableModel dm=jT.getModel();
		int j=-1;
		for(int i=0;i<dm.getColumnCount();i++)
			for(Field field:obj.getClass().getDeclaredFields())
			
		{
			field.setAccessible(true);
			if(dm.getColumnName(i).equals(field.getName()))
			{
				try {
					field.set(obj,dm.getValueAt(row,i));
				} catch (IllegalArgumentException | IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		}
		
		
	}

}
