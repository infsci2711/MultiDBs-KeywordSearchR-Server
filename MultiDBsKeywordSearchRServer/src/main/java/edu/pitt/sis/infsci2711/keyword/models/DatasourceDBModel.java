package edu.pitt.sis.infsci2711.keyword.models;

import java.util.List;


public class DatasourceDBModel {
	
	private DatasourceIdsDBModel datasourceInfo;
	private List<TableDBModel> tableSet;
	
	public DatasourceDBModel() {
		
	}
	
	public DatasourceDBModel(DatasourceIdsDBModel datasourceInfo, List<TableDBModel> tableSet) {
		this.setDatasource(datasourceInfo);
		this.setTables(tableSet);
	}

	public int getId() {
		return datasourceInfo.getId();
	}

	public void setId(final int id) {
		datasourceInfo.setId(id);
	}
	
	public List<TableDBModel> getTables() {
		return tableSet;
	}
	
	public void setTables(List<TableDBModel> tableSet) {
		this.tableSet = tableSet;
	}
	
	public DatasourceIdsDBModel getDatasourceModel() {
		return datasourceInfo;
	}
	
	public void setDatasource(DatasourceIdsDBModel datasourceInfo) {
		this.datasourceInfo = datasourceInfo;
	}

}
