package edu.pitt.sis.infsci2711.keyword.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import edu.pitt.sis.infsci2711.keyword.business.PersonService;
import edu.pitt.sis.infsci2711.keyword.models.*;
import edu.pitt.sis.infsci2711.keyword.viewModels.DatasourceModel;
import edu.pitt.sis.infsci2711.keyword.viewModels.Index;
import edu.pitt.sis.infsci2711.keyword.viewModels.haoge;
import edu.pitt.sis.infsci2711.datasource.viewModels.*;
@Path("Index/")

public class PersonRestService {

	@GET
    @Produces(MediaType.APPLICATION_JSON)
	public Response allPersons() {
		
		PersonService personService = new PersonService();
		
		List<PersonDBModel> personsDB;
		try {
			personsDB = personService.getAll();
		
			List<Index> persons = convertDbToViewModel(personsDB);
			
			GenericEntity<List<Index>> entity = new GenericEntity<List<Index>>(persons) {};
			
			return Response.status(200).entity(entity).build();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return Response.status(500).build();
		}
		
	}
	
	@Path("{dbTerm}")
	@GET
    @Produces(MediaType.APPLICATION_JSON)
	public Response personById(@PathParam("dbTerm") final String dbTerm) {
		
		PersonService personService = new PersonService();
		List<PersonDBModel> personsDB;
		
		try {
			personsDB = personService.findById(dbTerm);
			if (personsDB != null) {
				
			List<Index> persons = convertDbToViewModel(personsDB);
			GenericEntity<List<Index>> entity = new GenericEntity<List<Index>>(persons) {};
			return Response.status(200).entity(entity).build();
			
			}
			return Response.status(404).entity("Person not found").build();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return Response.status(500).build();
		}
		
	}
	/*
	@PUT
    @Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addDatasource(final DatasourceModel datasource) {
		
		PersonService personService = new PersonService();
		
		try {
			DatasourceDBModel datasourceDB = personService.add(convertVMToDB(datasource));
		
			DatasourceModel datasourceInserted = convertDbToVM(datasourceDB);
			
			return Response.status(200).entity(datasourceInserted).build();
		} catch (Exception e) {
			return Response.status(500).build();
		}
		
	}
	*/
	
	
	private DatasourceDBModel convertVMToDB(final DatasourceModel dbsource) {
		DatasourceIdsDBModel dbDBmodel = new DatasourceIdsDBModel(dbsource.getDatasource().getId(),dbsource.getDatasource().getDbName(),dbsource.getDatasource().getTitle());
		List<TableDBModel> tabDBmodel = tabVMToDB(dbsource.getTables());
		return new DatasourceDBModel(dbDBmodel, tabDBmodel);
	}

	private List<TableDBModel> tabVMToDB(final List<TableViewModel> tabs) {
		List<TableDBModel> result = new ArrayList<TableDBModel>();
		for(TableViewModel tab : tabs) {
			result.add(new TableDBModel(tab.getTableName(), colVMToDB(tab.getColumns())));
		}
		
		return result;
	}
	
	private List<ColumnDBModel> colVMToDB(final List<ColumnViewModel> cols) {
		List<ColumnDBModel> result = new ArrayList<ColumnDBModel>();
		for(ColumnViewModel col : cols) {
			result.add(new ColumnDBModel(col.getColumnName()));
		}
		
		return result;
	}
	
	/*
	private DatasourceDBModel convertDBToVM(final DatasourceModel dbsource) {
		DatasourceIdsDBModel dbDBmodel = new DatasourceIdsDBModel(dbsource.getDatasource().getId(),dbsource.getDatasource().getDbName(),dbsource.getDatasource().getTitle());
		List<TableDBModel> tabDBmodel = tabVMToDB(dbsource.getTables());
		return new DatasourceDBModel(dbDBmodel, tabDBmodel);
	}

	private List<TableDBModel> tabVMToDB(final List<TableViewModel> tabs) {
		List<TableDBModel> result = new ArrayList<TableDBModel>();
		for(TableViewModel tab : tabs) {
			result.add(new TableDBModel(tab.getTableName(), colVMToDB(tab.getColumns())));
		}
		
		return result;
	}
	
	private List<ColumnDBModel> colVMToDB(final List<ColumnViewModel> cols) {
		List<ColumnDBModel> result = new ArrayList<ColumnDBModel>();
		for(ColumnViewModel col : cols) {
			result.add(new ColumnDBModel(col.getColumnName()));
		}
		
		return result;
	}
	*/
	
	
	private Index convertDbToVM(final PersonDBModel personDB) {
		return new Index(personDB.getId(), personDB.getTerm(), personDB.getDatabaseName(), personDB.getTableName(), personDB.getColumnName());
	}
	
	

	private PersonDBModel convertViewModelToDB(final Index index) {
		return new PersonDBModel(index.getTerm(), index.getDatabaseName(), index.getTableName(), index.getColumnName());
	}

	private List<Index> convertDbToViewModel(final List<PersonDBModel> personsDB) {
		List<Index> result = new ArrayList<Index>();
		for(PersonDBModel personDB : personsDB) {
			result.add(convertDbToViewModel(personDB));
		}
		
		return result;
	}
	
	private Index convertDbToViewModel(final PersonDBModel personDB) {
		return new Index(personDB.getId(), personDB.getTerm(), personDB.getDatabaseName(), personDB.getTableName(), personDB.getColumnName());
	}
}
