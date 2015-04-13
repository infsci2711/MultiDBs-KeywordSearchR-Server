package edu.pitt.sis.infsci2711.keyword.business;

import java.sql.SQLException;
import java.util.List;


import edu.pitt.sis.infsci2711.keyword.dao.PersonDAO;
import edu.pitt.sis.infsci2711.keyword.models.*;

public class PersonService {

	public List<PersonDBModel> getAll() throws SQLException, Exception {
		List<PersonDBModel> result = PersonDAO.findAll();
		
		return result;
	}
	
	public List<PersonDBModel> findById(final String dbTerm) throws SQLException, Exception {
		List<PersonDBModel> result = PersonDAO.findById(dbTerm);
		
		return result;
	}
	
	public DatasourceDBModel add(final DatasourceDBModel datasource) throws SQLException, Exception {
		PersonDAO.save(datasource);
		return datasource;
	}
}
