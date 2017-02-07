/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.service;

import entities.Tcoda;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
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
import javax.ws.rs.core.MediaType;

/**
 *
 * @author tesi
 */
@Stateless
@Path("entities.tcoda")
public class TcodaFacadeREST extends AbstractFacade<Tcoda> {

    @PersistenceContext(unitName = "RestNeptisPU")
    private EntityManager em;

    public TcodaFacadeREST() {
        super(Tcoda.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Tcoda entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Long id, Tcoda entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        super.remove(super.find(id));
    }

    
    
    
    @GET
    @Path("{attractionCid},{minutes}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Tcoda> findByAttractionAndMinute(@PathParam("attractionCid") Long attractionCid, @PathParam("minutes") Integer minutes) {
        List<Tcoda> l = null;
        Query q = em.createNamedQuery("Tcoda.findByAttractionAndMinute").setParameter ("attractionCid", 		attractionCid);
        q.setParameter("minutes", minutes);
        l = q.getResultList();
        
        return l;
    }
    
    
    
    @GET
@Path("/museum/{attractionMid},{minutes}")
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
public List<Tcoda> findByAttractionMandMinute(@PathParam("attractionMid") Long attractionMid, @PathParam("minutes") Integer minutes) {
        List<Tcoda> l = null;
        Query q = em.createNamedQuery("Tcoda.findByAttractionMandMinute").setParameter ("attractionMid", attractionMid);
        q.setParameter("minutes", minutes);
        l = q.getResultList();
        
        return l;
    }


@GET
@Path("/oam/{attractionOamid},{minutes}")
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
public List<Tcoda> findByAttractionOamAndMinute(@PathParam("attractionOamid") Long attractionOamid, @PathParam("minutes") Integer minutes) {
        List<Tcoda> l = null;
        Query q = em.createNamedQuery("Tcoda.findByAttractionOamAndMinute").setParameter ("attractionOamid", attractionOamid);
        q.setParameter("minutes", minutes);
        l = q.getResultList();
        
        return l;
    }
    
    
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Tcoda find(@PathParam("id") Long id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Tcoda> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Tcoda> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
