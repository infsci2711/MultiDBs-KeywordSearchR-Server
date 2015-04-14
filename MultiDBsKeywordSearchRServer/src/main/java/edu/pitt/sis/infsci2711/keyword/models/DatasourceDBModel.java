package edu.pitt.sis.infsci2711.keyword.models;

import java.util.List;

public class DatasourceDBModel {
	private int id;
	
	private List<TableDBModel> tables;
	
	public DatasourceDBModel(){
		
	}
	
	
	public DatasourceDBModel(int id, List<TableDBModel> tables) {
		this.setId(id);
		this.setTables(tables);
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}



	public List<TableDBModel> getTables() {
		return tables;
	}

	public void setTables(List<TableDBModel> tables) {
		this.tables = tables;
	}
}
