package edu.pitt.sis.infsci2711.keyword.models;
//Borrowed from Metastore project

public class ColumnDBModel {
	private String columnName;
	
	public ColumnDBModel() {
		
	}
	
	public ColumnDBModel(String columnName) {
		this.setColumnName(columnName);
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
}
