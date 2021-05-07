package dao;
import connection.*;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.sql.*;
import java.util.ArrayList;

import java.util.List;

import javax.swing.JOptionPane;


public class AbstractDao<T> {

	
	private final Class<T> type;
	public AbstractDao()
	{
		this.type = (Class<T>)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
		
		
		
		
	}
	
   private int	takeMaximId()
	{
		Connection con=ConnectionFactory.singleinstance.getConnection();
		int newid=-1;
		
	
		StringBuilder queryid=new StringBuilder();
		queryid.append("Select max(id) from ");
		queryid.append(type.getSimpleName()+";");
		
		try {
			Statement idStatement=con.createStatement();
			ResultSet rs=idStatement.executeQuery(queryid.toString());
					if(rs.next())
					{
						newid=rs.getInt(1)+1;
						
					}
		
			ConnectionFactory.singleinstance.close(idStatement);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return newid;
		
	}
	
   
   
   
 
   
   
	
	public int insert(T obj)
	{
		
		 QueryGenerator queryGenerator=new QueryGenerator();
		 Connection con=ConnectionFactory.singleinstance.getConnection();
	     int newid=takeMaximId();
	     StringBuilder query=new StringBuilder();
	     query.append(queryGenerator.generateInsert1(obj));
	     query.append(queryGenerator.generateInsert2(obj,newid));
	  
		System.out.println(query.toString());
		
		try {
			Statement insertStatement=con.createStatement();
			insertStatement.executeUpdate(query.toString());
		
			ConnectionFactory.singleinstance.close(insertStatement);
			
			
		} catch (SQLException e) {
			 JOptionPane.showMessageDialog(null, "Eroare la inserare in baza de date");
			e.printStackTrace();
		}
		return newid;
	}
	

	
	
	public void deletebyId(int id)
	{
		String deleteString="DELETE FROM ";
		 deleteString+=type.getSimpleName();
		 deleteString+=" where id="+String.valueOf(id)+";";
		
		
		
		Statement statement;
		try {
			statement = ConnectionFactory.singleinstance.getConnection().createStatement();
			statement.executeUpdate(deleteString);
			ConnectionFactory.singleinstance.close(statement);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	

	
	public void updatebyId(T obj,int id)
	{
		StringBuilder sb=new StringBuilder();
		sb.append("UPDATE ");
		
		sb.append(obj.getClass().getSimpleName()+" ");
		 QueryGenerator queryGenerator=new QueryGenerator();
		sb.append("SET ");
		sb.append( queryGenerator.updateFieldsName(obj));
			
	    sb.replace(sb.length()-1, sb.length(), " ");
		sb.append("Where id= ");
		sb.append(id);
		sb.append(";");
		
		System.out.println(sb.toString());
		
		Statement statement;
		try {
			statement = ConnectionFactory.singleinstance.getConnection().createStatement();
			statement.executeUpdate(sb.toString());
			ConnectionFactory.singleinstance.close(statement);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	private List<T> createObjects(ResultSet resultSet)
	{	try {
		List<T> lista=new ArrayList<T>();
		while(resultSet.next())
		{
			@SuppressWarnings("deprecation")
			T newObject=type.newInstance();
			for(Field field: type.getDeclaredFields())
			{
				Object value=resultSet.getObject(field.getName());
				PropertyDescriptor propertyDescriptor=new PropertyDescriptor(field.getName(),type);
				Method method=propertyDescriptor.getWriteMethod();
				method.invoke(newObject, value);
				
			}
			lista.add(newObject);
		}
			
			
			return lista;
		} catch (InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IntrospectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	
	}
	
	public T findById(int id)
	{
		QueryGenerator queryGenerator=new QueryGenerator();
		String findByIdString=queryGenerator.createSelectQuery(type,"*","id" );
		Statement statement;
		try {
			
			PreparedStatement prepstate = ConnectionFactory.singleinstance.getConnection().prepareStatement(findByIdString);
			prepstate.setInt(1, id);
			
			ResultSet rs=prepstate .executeQuery();
			
			List<T> lista=createObjects(rs);
			ConnectionFactory.singleinstance.close(prepstate );
			if(lista.size()>0)
			return lista.get(0);
			else
			return null;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			return null;
		
		}
		
		
	}
	
	public int findIdByName(String name)
	{	QueryGenerator queryGenerator=new QueryGenerator();
		String findByIdString=queryGenerator.createSelectQuery(type,"id","name" );
		Statement statement;
		try {
			PreparedStatement prepstate = ConnectionFactory.singleinstance.getConnection().prepareStatement(findByIdString);
			prepstate.setString(1, name);
			
			
			ResultSet rs=prepstate .executeQuery();
			
			if(rs.next())
			{
				return rs.getInt(1);
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return -1;
		
		
	}
	public List<T> findAll()
	{
		Statement statement;
		try {
			statement = ConnectionFactory.singleinstance.getConnection().createStatement();
			ResultSet rs=statement.executeQuery("SELECT * FROM "+type.getSimpleName());
			List<T> lista=createObjects(rs);
			ConnectionFactory.singleinstance.close(statement);
			return lista;
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
	}
	
}
