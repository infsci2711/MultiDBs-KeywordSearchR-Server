package edu.pitt.sis.infsci2711.keyword.viewModels;

import java.util.List;

import edu.pitt.sis.infsci2711.datasource.viewModels.*;

public class DatasourceModel {
	
	private DatasourceIdsViewModel datasourceInfo;
	private List<TableViewModel> tableSet;
	
	public DatasourceModel() {
		
	}
	
	public DatasourceModel(DatasourceIdsViewModel datasourceInfo, List<TableViewModel> tableSet) {
		this.setDatasource(datasourceInfo);
		this.setTables(tableSet);
	}

	public int getId() {
		return datasourceInfo.getId();
	}

	public void setId(final int id) {
		datasourceInfo.setId(id);
	}
	
	public List<TableViewModel> getTables() {
		return tableSet;
	}
	
	public void setTables(List<TableViewModel> tableSet) {
		this.tableSet = tableSet;
	}
	
	public DatasourceIdsViewModel getDatasource() {
		return datasourceInfo;
	}
	
	public void setDatasource(DatasourceIdsViewModel datasourceInfo) {
		this.datasourceInfo = datasourceInfo;
	}

}
