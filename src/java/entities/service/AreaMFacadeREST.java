/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.service;

import entities.AreaM;
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
@Path("entities.aream")
public class AreaMFacadeREST extends AbstractFacade<AreaM> {

    @PersistenceContext(unitName = "RestNeptisPU")
    private EntityManager em;

    public AreaMFacadeREST() {
        super(AreaM.class);
    }
    
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public Response create(AreaM entity, @Context UriInfo uriInfo) {
        Query q = em.createNamedQuery("AreaM.findByNameAndMuseum")
                .setParameter ("name", entity.getName())
                .setParameter("museum", entity.getMuseum().getId());
        AreaM a;
        try {
            a = (AreaM) q.getSingleResult();
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
    public void edit(@PathParam("id") Long id, AreaM entity) {
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
    public AreaM find(@PathParam("id") Long id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<AreaM> findAll() {
        return super.findAll();
    }

    
    @GET
    @Path("{name},{museum}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<AreaM> findByNameAndMuseum(@PathParam("name") String name, @PathParam("museum") Long museum) {
        List<AreaM> l = null;
        Query q = em.createNamedQuery("AreaM.findByNameAndMuseum").setParameter ("name", name);
        q.setParameter("museum", museum);
        l = q.getResultList();
        return l;
    }


 @GET
    @Path("museumId={museumId}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<AreaM> findByMuseum(@PathParam("museumId") Long museumId) {
        List<AreaM> l = null;
        Query q = em.createNamedQuery("AreaM.findByMuseum").setParameter ("museumId", museumId);
        l = q.getResultList();
        return l;
    }

    
    
    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<AreaM> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
