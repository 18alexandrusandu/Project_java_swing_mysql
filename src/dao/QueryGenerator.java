package dao;

import java.lang.reflect.Field;

public class QueryGenerator {
	
	 public String generateInsert1(Object obj)
	   {
		
		  StringBuilder query=new StringBuilder();
			
			query.append("insert into ");
			query.append(obj.getClass().getSimpleName()+"(");
			//
			for(Field field: obj.getClass().getDeclaredFields())
			{
				field.setAccessible(true);

				query.append(field.getName()+",");
				
			}
		    query.replace(query.length()-1,query.length() , " ");
		    query.append(")");
		   
		   return query.toString();
	   }
	   
	   
	 public String generateInsert2(Object obj,int newid)
	  {
		
		  StringBuilder query=new StringBuilder();
			query.append(" values(");
			
			for(Field field: obj.getClass().getDeclaredFields())
			{
				field.setAccessible(true);
				try {
					if(field.getType().equals(String.class))
				     query.append("'");
					if(!field.getName().equals("id"))
					query.append( field.get(obj).toString() );
					else
					query.append(String.valueOf(newid) );
					
					if(field.getType().equals(String.class))
					     query.append("'");
					
					query.append(",");
					
				} catch (IllegalArgumentException | IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				}
			
			query.replace(query.length()-1,query.length() , " ");
			query.append(");");
		   return query.toString();
	  }
	  
		public String createSelectQuery(Class obj,String fieldName1,String fieldName2 )
		{
			StringBuilder sb=new StringBuilder();
			sb.append("SELECT ");
			sb.append(fieldName1);
			sb.append(" FROM ");
			sb.append(obj.getSimpleName());
			sb.append(" WHERE " + fieldName2 +" = ?");
			
			
			return sb.toString();
			
		}
		public String updateFieldsName(Object obj)
		{
			StringBuilder sb=new StringBuilder();
			Field[] listOfFields=obj.getClass().getDeclaredFields();
			for(Field field : listOfFields)
				{
				
				field.setAccessible(true);
				sb.append( field.getName()+" = ");
				try {
					
					if(field.getType().equals(String.class))
							sb.append("'");
					
					sb.append(field.get(obj).toString());
					if(field.getType().equals(String.class))
							sb.append("'");
						
					sb.append(",");
				
				} catch (IllegalArgumentException | IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
				}
			return sb.toString();
		}
		
		
	

}
