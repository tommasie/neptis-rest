/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.service;

import entities.Oam;
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
@Path("entities.oam")
public class OamFacadeREST extends AbstractFacade<Oam> {

    @PersistenceContext(unitName = "RestNeptisPU")
    private EntityManager em;

    public OamFacadeREST() {
        super(Oam.class);
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public Response create(Oam entity, @Context UriInfo uriInfo) {
        Query q = em.createNamedQuery("Oam.findByNameAndCity")
                .setParameter ("name", entity.getName())
                .setParameter("city", entity.getCity().getId());
        Oam m;
        try {
            m = (Oam) q.getSingleResult();
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
    /*@POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Oam entity) {
        super.create(entity);
    }*/

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Long id, Oam entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{name},{cityId}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Oam> findByNameAndCity(@PathParam("name") String name, @PathParam("cityId") Long cityId) {
        List<Oam> l = null;
        Query q = em.createNamedQuery("Oam.findByNameAndCity").setParameter ("name", name);
        q.setParameter("cityId", cityId);
        l = q.getResultList();
        
        return l;
    }
    
    
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Oam find(@PathParam("id") Long id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Oam> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Oam> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
