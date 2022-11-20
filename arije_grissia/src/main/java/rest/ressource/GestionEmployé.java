package rest.ressource;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import rest.entity.Employe;
import javax.ws.rs.core.Response.Status;


@Path("employes")
@Api
public class GestionEmployé {
	public static  List<Employe> employes=new ArrayList<Employe>();//njibou biha liste 
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)//donné todkhol json
	@Produces(MediaType.TEXT_PLAIN)//tokhrej test
	@ApiOperation(value= "ajout d'un employe")
	public Response ajouterEmploye (Employe employe){
	
	//public String ajouterEmploye(Employe employe) {
		 if(employes.add(employe))
	 return Response.status(Status.CREATED).entity("ADD with success").build();
		return Response.status(Status.NOT_FOUND).entity("ECHEC").build();
	  /*
	   return "ADD Success";
		 return "Echec";*/
		 // status 200 ok par défaut 
	}
	
	@ApiOperation(value= "récupération de la liste des employés")
	@GET
	@Produces("application/json")
	public  Response  displayEmployeesList() {
		
		if(employes.size()!=0)
			return Response.status(Status.FOUND).entity(employes).build();
		else
			return Response.status(Status.NO_CONTENT).build();
					
	}
	@ApiOperation(value= "modification d'un employe")	
	@PUT
	//@Consumes("application/xml")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	//@Produces("text/plain")
	public Response updateEmploye(Employe e) {
		int index= this.getIndexByCin(e.getCin());
		if (index!=-1) {
			employes.set(index, e);
			return Response.status(Status.OK).entity("update successful").build();
			
		}
		return Response.status(Status.NOT_FOUND).entity("update unsuccessful").build();
	
	}
	public int getIndexByCin(int cin) {
		for(Employe emp: employes) {
			if (emp.getCin()==cin)
				return employes.indexOf(emp);
		}
		return -1;
	}

	

}
