package edu.pitt.sis.infsci2711.keyword.viewModels;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement

public class Index {

	private int id;
	private String dbTerm;
	private String databaseName;
	private String tableName;
	private String columnName;
	
	public Index() {
		
	}
	
	public Index(final String dbTerm, final String databaseName, final String tableName, final String columnName) {
		this.setTerm(dbTerm);
		this.setDatabaseName(databaseName);
		this.setTableName(tableName);
		this.setColumnName(columnName);
	}
	
	public Index(final int id, final String dbTerm, final String databaseName, final String tableName, final String columnName) {
		this.setId(id);
		this.setTerm(dbTerm);
		this.setDatabaseName(databaseName);
		this.setTableName(tableName);
		this.setColumnName(columnName);
	}

	public int getId() {
		return id;
	}

	public void setId(final int id) {
		this.id = id;
	}
	
	public String getTerm() {
		return dbTerm;
	}
	
	public String getDatabaseName() {
		return databaseName;
	}
	
	public String getTableName() {
		return tableName;
	}
	
	public String getColumnName() {
		return columnName;
	}
	
	public void setTerm(final String dbTerm) {
		this.dbTerm = dbTerm;
	}

	public void setTableName(final String tableName) {
		this.tableName = tableName;
	}
	
	public void setDatabaseName(final String databaseName) {
		this.databaseName = databaseName;
	}
	
	public void setColumnName(final String columnName) {
		this.columnName = columnName;
	}
}
