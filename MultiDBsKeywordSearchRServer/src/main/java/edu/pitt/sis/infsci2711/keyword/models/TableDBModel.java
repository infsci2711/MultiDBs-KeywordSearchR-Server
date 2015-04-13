package edu.pitt.sis.infsci2711.keyword.models;
// Borrowed from Metastore project

import java.util.List;

public class TableDBModel {
	private String tableName;
	private List<ColumnDBModel> columns;
	
	public TableDBModel() {
		
	}
	
	public TableDBModel(String tableName) {
		this.setTableName(tableName);
	}
	
	public TableDBModel(String tableName, List<ColumnDBModel> columns) {
		this.setTableName(tableName);
		this.setColumns(columns);
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public List<ColumnDBModel> getColumns() {
		return columns;
	}

	public void setColumns(List<ColumnDBModel> columns) {
		this.columns = columns;
	}
}
