package edu.pitt.sis.infsci2711.keyword.business;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import edu.pitt.sis.infsci2711.keyword.dao.PersonDAO;
import edu.pitt.sis.infsci2711.keyword.models.*;

public class PersonService {
	final Logger logger = LogManager.getLogger(PersonService.class.getName());
	
	public List<PersonDBModel> getAll() throws SQLException, Exception {
		List<PersonDBModel> result = PersonDAO.findAll();
		
		return result;
	}
	
	public List<PersonDBModel> findById(final String dbTerm) throws SQLException, Exception {
		List<PersonDBModel> result = PersonDAO.findById(dbTerm);
		
		return result;
	}
	
	public List<querydidtab> add(final DatasourceDBModel datasource) throws SQLException, Exception {
		
		List<querydidtab> sqlSet = new ArrayList<querydidtab>();
		boolean isInsert = PersonDAO.save(datasource);
		String tempsql;
		if(!isInsert) //save did
		{
			logger.info("Didn't insert");
			
		}else
		{
			int didSQL = datasource.getId();
			List<TableDBModel> tablist = new ArrayList<TableDBModel>();
			tablist = datasource.getTables();
			
			for(TableDBModel tab : tablist) {
				String tabSQL = tab.getTableName();
				List<ColumnDBModel> collist = new ArrayList<ColumnDBModel>();
				collist = tab.getColumns();
				for(ColumnDBModel col : collist) {
					String colSQL = col.getColumnName();
					tempsql = "SELECT DISTINCT " + colSQL + " FROM " + didSQL + "." + tabSQL;
					//System.out.println(tempsql);
					sqlSet.add(new querydidtab(tempsql,didSQL,tabSQL));
				}
			}
		}
		return sqlSet;
	}
	
	public void addIndex(final int did, final String table, final String column, final List<String[]> rows) throws SQLException, Exception {
		PersonDAO.buildIndex(did, table, column, rows);
		
	}
}
