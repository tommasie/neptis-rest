/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.service;

import entities.City;
import java.net.URI;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author tesi
 */
@Stateless
@Path("entities.city")
public class CityFacadeREST extends AbstractFacade<City> {

    @PersistenceContext(unitName = "RestNeptisPU")
    private EntityManager em;

    public CityFacadeREST() {
        super(City.class);
    }

    @POST
    //@Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public Response create(City entity, @Context UriInfo uriInfo) {
        Query q = em.createNamedQuery("City.findByNameAndRegion")
                .setParameter ("name", entity.getName())
                .setParameter("region", entity.getRegion());
        City c;
        try {
            c = (City)q.getSingleResult();
        } catch (NoResultException e) {
            c = null;
        }
        
        URI location;
        if(c != null) {
            location = URI.create(uriInfo.getAbsolutePath().toString() + '/' + c.getId());
            return Response.created(location).build();
        }
        super.create(entity);
        em.flush();
        location = URI.create(uriInfo.getAbsolutePath().toString() + '/' + entity.getId());
        return Response.created(location).build();
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Long id, City entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public City find(@PathParam("id") Long id) {
        return super.find(id);
    }
    
    
    @GET
    @Path("{name},{region}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<City> findByNameAndRegion(@PathParam("name") String name, @PathParam("region") String region) {
        List<City> l = null;
        Query q = em.createNamedQuery("City.findByNameAndRegion").setParameter ("name", name);
        q.setParameter("region", region);
        l = q.getResultList();
        
        return l;
    }


    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<City> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<City> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
