package mx.com.cinepolis.schedule.rest;

import mx.com.cinepolis.scheduler.commons.to.CatalogsTO;
import mx.com.cinepolis.scheduler.commons.to.GitHubUserTO;
import mx.com.cinepolis.scheduler.commons.to.LoginTO;
import mx.com.cinepolis.scheduler.commons.to.UserTO;
import mx.com.cinepolis.scheduler.facade.CatalogFacadeEJB;
import mx.com.cinepolis.scheduler.facade.GitHubFacadeEJB;

import java.util.List;

import javax.ejb.EJB;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;


/**
 * @author jrodriguez
 */
@Path("/catalog")
public class CatalogRest {

    @EJB
    private CatalogFacadeEJB catalogFacadeEJB;
    @EJB
    private GitHubFacadeEJB gitHubFacadeEJB;

    @GET
    @Produces("application/json")
    @Path("/user")
    public Response getSimpleCatalog()
    {
        UserTO userTO = catalogFacadeEJB.getSimpleUser();
        return Response.ok().entity(userTO).build();
    }
    
    
    @GET
    @Produces("application/json")
    @Path("/country")
    //country?pais=Mexico
    public Response getEstados(@Context UriInfo ui) {
    	
    	MultivaluedMap<String, String> queryParams=ui.getQueryParameters();
    	String pais=queryParams.getFirst("pais");
    	
    	List<CatalogsTO> catalogsTOList=catalogFacadeEJB.getEstadosList(pais);
    	
    	GenericEntity<List<CatalogsTO>> entity =new GenericEntity<List<CatalogsTO>>(catalogsTOList){};
    	
    	return Response.ok().entity(entity).build();
    }
    
    @GET
    @Produces("application/json")
    @Path("/login")
    public Response getLoginSucces(@Context UriInfo ui)
    {
    	MultivaluedMap<String, String> queryParams=ui.getQueryParameters();
    	String usuario=queryParams.getFirst("usuario");
    	String password=queryParams.getFirst("password");
        LoginTO loginTO = gitHubFacadeEJB.getLogTrue(usuario, password);
        return Response.ok().entity(loginTO).build();
    }
    
    @GET
    @Produces("application/json")
    @Path("/users/{login}")
    public Response getGitHubUser(@PathParam("login")String login)
    {
        GitHubUserTO gitHubUserTO = gitHubFacadeEJB.getGitUser(login);
        return Response.ok().entity(gitHubUserTO).build();
    }
    
    @POST
    @Produces("application/json")
    @Path("/users")
    public Response postGitHub(GitHubUserTO gitHubUserTO) {
    	GitHubUserTO gtuserTO=gitHubFacadeEJB.postGt(gitHubUserTO);
    	return Response.ok().entity(gtuserTO).build();
    }

    /*
    @GET
    @Produces("application/json")
    @Path("/country/{pais}")
    public Response getEstados(@PathParam("pais") String pais) {
    	List<CatalogsTO> catalogsTOList=catalogFacadeEJB.getEstadosList(pais);
    	
    	GenericEntity<List<CatalogsTO>> entity =new GenericEntity<List<CatalogsTO>>(catalogsTOList){};
    	
    	return Response.ok().entity(entity).build();
    }*/

}

