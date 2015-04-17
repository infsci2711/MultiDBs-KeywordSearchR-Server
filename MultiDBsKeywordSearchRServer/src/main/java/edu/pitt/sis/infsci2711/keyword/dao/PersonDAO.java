package edu.pitt.sis.infsci2711.keyword.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import edu.pitt.sis.infsci2711.keyword.models.*;
import edu.pitt.sis.infsci2711.keyword.utils.JdbcUtil;

public class PersonDAO {

	public static List<PersonDBModel> findAll() throws SQLException, Exception {
		
		
		try (Connection connection = JdbcUtil.getConnection()) {
		
			/*
			String sql1 = "SHOW TABLES";
			try (Statement statement = connection.createStatement()){
				
				ResultSet tableSet = statement.executeQuery(sql1);
				while (tableSet.next()) {
					if(tableSet.getString(1) != "Index"){
						
						sql1 = "SELECT * FROM" + tableSet.getString(1);
						try (Statement statement1 = connection.createStatement()){
							
							ResultSet contentSet = statement1.executeQuery(sql1);
							while (contentSet.next()) {
								
								sql1 = "SHOW COLUMNS FROM" + tableSet.getString(1);
								try (Statement statement2 = connection.createStatement()){
									
									ResultSet columnSet = statement2.executeQuery(sql1);
									while (columnSet.next()) {
										int i=1;
										String sql = "INSERT INTO `Index` (dbTerm, databaseName, tableName) VALUES ('"+ contentSet.getString(i++) +"', 'infsci2711_tutorial', '"+ columnSet.getString(1) +"')";
										try (Statement statement3 = connection.createStatement()){
											
											int res = statement3.executeUpdate(sql);
											//Statement.RETURN_GENERATED_KEYS
											//ResultSet rs = statement3.getGeneratedKeys();
										
										
									}
									
									
								}
								
							}
							
						}
					}
				}
				
				
			}
		}*/
			
			
			String sql = "SELECT * FROM `Index`";
			try (Statement statement4 = connection.createStatement()){
				
				ResultSet resultSet = statement4.executeQuery(sql);
				
				List<PersonDBModel> result = new ArrayList<PersonDBModel>();
				
				while (resultSet.next()) {
					result.add(new PersonDBModel(resultSet.getInt("termId"), resultSet.getString("dbTerm"), resultSet.getString("databaseName"), resultSet.getString("tableName"), resultSet.getString("columnName")));					 
				}
				
				return result;
			}
		}
		
	}
	

	
	public static List<PersonDBModel> findById(final String dbTerm) throws SQLException, Exception {
		
		try (Connection connection = JdbcUtil.getConnection()) {
			String[] splited = dbTerm.split("\\s+");
			String sql = "SELECT * FROM `Index` WHERE dbTerm like '%" + splited[0] + "%' OR columnName like '%" + splited[0] + "%' OR tableName like '%" + splited[0] +"%'";
			for(int j=1;j<splited.length;j++)
			{
				sql += "OR dbTerm like'%" + splited[j] + "%'";
				sql += "OR columnName like'%" + splited[j] + "%'";
				sql += "OR tableName like'%" + splited[j] + "%'";
			}
			try (Statement statement = connection.createStatement()){
				
				ResultSet resultSet = statement.executeQuery(sql);
				List<PersonDBModel> result = new ArrayList<PersonDBModel>();
				
				while (resultSet.next()) {
					result.add(new PersonDBModel(resultSet.getInt("termId"), resultSet.getString("dbTerm"), resultSet.getString("databaseName"), resultSet.getString("tableName"), resultSet.getString("columnName")));					 
				}
				
				return result;
			}
		}
		
	}
	
	public static void buildIndex(final int did, final String table, final String column, final List<String[]> rows)throws SQLException, Exception {
		try (Connection connection = JdbcUtil.getConnection()) {
			try (Statement statement = connection.createStatement()){
				int size=rows.size();
				for(int i=0;i<size;i++){
					String[] value=rows.get(i);
					
				String sql = "INSERT INTO `Index` (dbTerm, databaseName, tableName, columnName) VALUES ('"+ value[0] +"', '"+did+"', '"+ table +"','"+column+"')";
				
				statement.executeUpdate(sql);
				}
			}
						

			}
		
	}
	
	public static boolean save(final DatasourceDBModel dbsource) throws SQLException, Exception {
		
		try (Connection connection = JdbcUtil.getConnection()) {
			boolean isInsert = true;
			int did = dbsource.getId();
			try (Statement statementj = connection.createStatement()){
				String sqlj = "SELECT * FROM Datasource WHERE did = " + did ;
				//System.out.println(did);
				ResultSet isInsertset = statementj.executeQuery(sqlj);
				ResultSetMetaData rsmd = isInsertset.getMetaData();
				//int columnsNumber = rsmd.getColumnCount();
				//System.out.println(isInsertset.getFetchSize());
				if(isInsertset.next())
				{
					isInsert = false;
					//System.out.println("WRONG");
				}else
				{
					String sql = "INSERT INTO Datasource (did) VALUES (" + did + ")";
					try (Statement statement = connection.createStatement()){
						statement.executeUpdate(sql);
					}
				}
			}
			
			return isInsert;
			
			/*
				String sql1 = "SHOW TABLES";
				try (Statement statement = connection.createStatement()){
					int res = 0;
					int i = 0;
					ResultSet tableSet = statement.executeQuery(sql1);
					while (tableSet.next()) {
						if(i!=0){
							
							String sql2 = "SELECT * FROM " + tableSet.getString(1);
							try (Statement statement1 = connection.createStatement()){
								
								ResultSet contentSet = statement1.executeQuery(sql2);
								while (contentSet.next()) {
									int j = 0;
									String sql3 = "SHOW COLUMNS FROM " + tableSet.getString(1);
									try (Statement statement2 = connection.createStatement()){
										ResultSet columnSet = statement2.executeQuery(sql3);
										while (columnSet.next()) {
									j++;
									try (Statement statement3 = connection.createStatement()){
										
									String sql = "INSERT INTO `Index` (dbTerm, databaseName, tableName, columnName) VALUES ('"+ contentSet.getString(j) +"', 'infsci2711_tutorial', '"+ tableSet.getString(1) +"','"+columnSet.getString(1)+"')";
									//try (Statement statement3 = connection.createStatement()){
									//i++;
									
									statement3.executeUpdate(sql);
										//Statement.RETURN_GENERATED_KEYS
										//ResultSet rs = statement3.getGeneratedKeys();
									}
									}
									}
								}
							}
						} i++;
					}
					return i;
				}*/
		}
	}
	
}
