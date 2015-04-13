package edu.pitt.sis.infsci2711.keyword.models;
//Borrowed from Metastore project

public class DatasourceIdsDBModel {
	
	private int id;
	private String dbName;
	private String title;
	
	public DatasourceIdsDBModel() {
		
	}
	
	public DatasourceIdsDBModel(int id, String dbName, String title) {
		this.setId(id);
		this.setDbName(dbName);
		this.setTitle(title);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDbName() {
		return dbName;
	}
	public void setDbName(String dbName) {
		this.dbName = dbName;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
}
