package edu.pitt.sis.infsci2711.keyword.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import edu.pitt.sis.infsci2711.keyword.business.PersonService;
import edu.pitt.sis.infsci2711.keyword.models.*;
import edu.pitt.sis.infsci2711.keyword.viewModels.DatasourceModel;
import edu.pitt.sis.infsci2711.keyword.viewModels.Index;
import edu.pitt.sis.infsci2711.keyword.viewModels.haoge;
import edu.pitt.sis.infsci2711.keyword.viewModels.QueryResultViewModel;
import edu.pitt.sis.infsci2711.keyword.viewModels.QueryViewModel;
import edu.pitt.sis.infsci2711.keyword.viewModels.RowViewModel;
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
	
	//send query to PrestoDB 
			@PUT
		    @Produces(MediaType.APPLICATION_JSON)
			@Consumes(MediaType.APPLICATION_JSON)
			public void addIndex(String query,int db,String t) {	
				String q=query;
				int did=db;
				String table=t;
				PersonService personService = new PersonService();
				try {			  
					//PUT request to presto
					Client client= ClientBuilder.newClient();
					WebTarget target = client.target("http://54.174.80.167:7654/");
		            
					target = target.path("Query/");
		            QueryViewModel QueryViewModel=new QueryViewModel();
		            
		            QueryViewModel.setQuery(q);
		            //PUT Request from Jersey Client Example. pass QueryViewModel instance
		            Response response = target.request(MediaType.APPLICATION_JSON)
		             .put(Entity.entity(QueryViewModel, MediaType.APPLICATION_JSON),Response.class);
		           
		            System.out.println(response);
		            if(response.getStatus() == 200) {
		                   System.out.println("put request using Json is Success");
		            }
		            QueryResultViewModel qresult=response.readEntity(QueryResultViewModel.class);	
		            String[] columnNames=qresult.getSchema().getColumnNames();
		            RowViewModel[] r=qresult.getData();
		            List<String[]> rows=new ArrayList<String[]>();
		            int size=r.length;
		            for(int i=0;i<size;i++){
		            	rows.add(r[i].getRow());
		            }
		            
		            personService.addIndex(did,table,columnNames[0],rows);
		            
					
				} catch (Exception e) {
					//return Response.status(500).build();
				}
				
			}
	
	
	
	
	@PUT
    @Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addDatasource(final DatasourceModel datasource) {
		
		PersonService personService = new PersonService();
		
		try {
			//TEST
			List<ColumnViewModel> cvmlist = new ArrayList<ColumnViewModel>();
			cvmlist.add(new ColumnViewModel("city"));
			cvmlist.add(new ColumnViewModel("state"));
			List<TableViewModel> tvmlist = new ArrayList<TableViewModel>();
			tvmlist.add(new TableViewModel("address", cvmlist));
			DatasourceIdsViewModel didvm = new DatasourceIdsViewModel(8, "faculty", "faculty");
			DatasourceModel testdb = new DatasourceModel(didvm, tvmlist);
			
			//TEST
			DatasourceDBModel testdbmodel = convertVMToDB(testdb);
			List<querydidtab> sqlSet = new ArrayList<querydidtab>();
			sqlSet = personService.add(testdbmodel);
			//System.out.println(sqlSet.size());
			if(sqlSet.size()==0)
			{
				System.out.println("Datasource already exists");
				
			}else
			{
				for(querydidtab subsql : sqlSet)
				{
					System.out.println(subsql.getSqlCommand() +" "+ subsql.getDid() + " " + subsql.getTabName());
					addIndex(subsql.getSqlCommand(),subsql.getDid(),subsql.getTabName());
				}
			}
			//DatasourceModel datasourceInserted = convertDbToVM(datasourceDB);
			
			return Response.status(200).entity(testdbmodel).build();
		} catch (Exception e) {
			return Response.status(500).build();
		}
		
	}
	
	
	
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
