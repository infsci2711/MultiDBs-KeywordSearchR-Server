package edu.pitt.sis.infsci2711.tutorial.models;

public class PersonDBModel {

	private int id;
	private String dbTerm;
	private String databaseName;
	private String tableName;
	
	public PersonDBModel() {
		
	}
	
	public PersonDBModel(final String dbTerm, final String databaseName, final String tableName) {
		this.setTerm(dbTerm);
		this.setDatabaseName(databaseName);
		this.setTableName(tableName);
	}
	
	public PersonDBModel(final int id, final String dbTerm, final String databaseName, final String tableName) {
		this.setId(id);
		this.setTerm(dbTerm);
		this.setDatabaseName(databaseName);
		this.setTableName(tableName);
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
	
	public void setTerm(final String dbTerm) {
		this.dbTerm = dbTerm;
	}

	public void setTableName(final String tableName) {
		this.tableName = tableName;
	}
	
	public void setDatabaseName(final String databaseName) {
		this.databaseName = databaseName;
	}
}
