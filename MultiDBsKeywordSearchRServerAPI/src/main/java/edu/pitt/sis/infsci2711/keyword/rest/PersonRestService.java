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
import edu.pitt.sis.infsci2711.keyword.models.PersonDBModel;
import edu.pitt.sis.infsci2711.keyword.viewModels.Index;
import edu.pitt.sis.infsci2711.keyword.viewModels.haoge;
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
	
	@PUT
    @Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addPerson(final Index person) {
		
		PersonService personService = new PersonService();
		
		try {
			PersonDBModel personsDB = personService.add(convertViewModelToDB(person));
		
			Index personInserted = convertDbToViewModel(personsDB);
			
			return Response.status(200).entity(personInserted).build();
		} catch (Exception e) {
			return Response.status(500).build();
		}
		
	}
	
	public Response generateSQL(final haoge db) {
		
		return Response.status(200).entity("").build();
		
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
