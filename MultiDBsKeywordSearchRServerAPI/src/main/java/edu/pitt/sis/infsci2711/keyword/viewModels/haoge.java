package edu.pitt.sis.infsci2711.keyword.viewModels;

public class haoge {

	private String tableName;
	private String colName;
	private String databaseName;
	
	public haoge(String tn, String cn, String dn){
		this.tableName = tn;
		this.colName = cn;
		this.databaseName = dn;
	}
	
	public String getTableName(){
		return this.tableName;
	}
	
	public String getColName(){
		return this.colName;
	}
	
	public String getDatabaseName(){
		return this.databaseName;
	}
	
}
