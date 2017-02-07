/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.service;

import entities.AreaOam;
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
@Path("entities.areaoam")
public class AreaOamFacadeREST extends AbstractFacade<AreaOam> {

    @PersistenceContext(unitName = "RestNeptisPU")
    private EntityManager em;

    public AreaOamFacadeREST() {
        super(AreaOam.class);
    }

    /*@POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(AreaOam entity) {
        super.create(entity);
    }*/
    
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public Response create(AreaOam entity, @Context UriInfo uriInfo) {
        Query q = em.createNamedQuery("AreaOam.findByNameAndMuseum")
                .setParameter ("name", entity.getName())
                .setParameter("museum", entity.getOam().getId());
        AreaOam a;
        try {
            a = (AreaOam) q.getSingleResult();
        } catch(NoResultException e) {
            a = null;
        }
                
        URI location;
        if(a != null) {
            location = URI.create(uriInfo.getAbsolutePath().toString() + '/' + a.getId());
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
    public void edit(@PathParam("id") Long id, AreaOam entity) {
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
    public AreaOam find(@PathParam("id") Long id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<AreaOam> findAll() {
        return super.findAll();
    }
    
    
      @GET
    @Path("{name},{museum}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<AreaOam> findByNameAndMuseum(@PathParam("name") String name, @PathParam("museum") Long museum) {
        List<AreaOam> l = null;
        Query q = em.createNamedQuery("AreaOam.findByNameAndMuseum").setParameter ("name", name);
        q.setParameter("museum", museum);
        l = q.getResultList();
        return l;
    }

    @GET
    @Path("museumId={museumId}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<AreaOam> findByMuseum(@PathParam("museumId") Long museumId) {
        List<AreaOam> l = null;
        Query q = em.createNamedQuery("AreaOam.findByMuseum").setParameter ("museumId", museumId);
        l = q.getResultList();
        return l;
    }

    
    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<AreaOam> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
