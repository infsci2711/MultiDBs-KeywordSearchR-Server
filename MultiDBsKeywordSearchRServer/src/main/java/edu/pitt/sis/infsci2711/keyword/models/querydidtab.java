package edu.pitt.sis.infsci2711.keyword.models;

public class querydidtab {
	
	private String sqlCommand;
	private int did;
	private String tabName;
	
	public querydidtab(){
		
	}
	
	public querydidtab(String sqlcommand, int did, String tab){
		this.sqlCommand = sqlcommand;
		this.did = did;
		this.tabName = tab;
	}
	
	public String getSqlCommand(){
		return sqlCommand;
	}
	
	public void setSqlCommand(String sqlcommand){
		this.sqlCommand = sqlcommand;
	}
	
	public int getDid(){
		return did;
	}
	
	public void setTabName(String tabName){
		this.tabName = tabName;
	}
	
	public String getTabName(){
		return tabName;
	}
	
	public void setDid(int did){
		this.did = did;
	}
	
}
