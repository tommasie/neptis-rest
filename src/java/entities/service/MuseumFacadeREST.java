/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.service;

import entities.Museum;
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
@Path("entities.museum")
public class MuseumFacadeREST extends AbstractFacade<Museum> {

    @PersistenceContext(unitName = "RestNeptisPU")
    private EntityManager em;

    public MuseumFacadeREST() {
        super(Museum.class);
    }
    
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public Response create(Museum entity, @Context UriInfo uriInfo) {
        Query q = em.createNamedQuery("Museum.findByNameAndCity")
                .setParameter ("name", entity.getName())
                .setParameter("city", entity.getCity().getId());
        Museum m;
        try {
            m = (Museum) q.getSingleResult();
        } catch(NoResultException e) {
            m = null;
        }
        
        URI location;
        if(m != null) {
            location = URI.create(uriInfo.getAbsolutePath().toString() + '/' + m.getId());
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
    public void edit(@PathParam("id") Long id, Museum entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{name},{city}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Museum> findByNameAndCity(@PathParam("name") String name, @PathParam("city") Long city) {
        List<Museum> l = null;
        Query q = em.createNamedQuery("Museum.findByNameAndCity").setParameter ("name", name);
        q.setParameter("city", city);
        l = q.getResultList();
        
        return l;
    }

    
    
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Museum find(@PathParam("id") Long id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Museum> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Museum> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
