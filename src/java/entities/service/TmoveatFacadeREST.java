/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.service;

import entities.Tmoveat;
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
@Path("entities.tmoveat")
public class TmoveatFacadeREST extends AbstractFacade<Tmoveat> {

    @PersistenceContext(unitName = "RestNeptisPU")
    private EntityManager em;

    public TmoveatFacadeREST() {
        super(Tmoveat.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Tmoveat entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Long id, Tmoveat entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        super.remove(super.find(id));
    }
    
    
    @GET
    @Path("{srcId},{destId},{minutes}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Tmoveat> findByAttractionAndMinute(@PathParam("srcId") Long srcId,@PathParam("destId") Long destId, @PathParam("minutes") Integer minutes) {
        List<Tmoveat> l = null;
        Query q = em.createNamedQuery("Tmoveat.findByAttractionAndMinute").setParameter ("srcId",srcId);
        q.setParameter("destId",destId);
        q.setParameter("minutes", minutes);
        l = q.getResultList();
        
        return l;
    }
    
    @GET
    @Path("/museum/{srcId},{destId},{minutes}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Tmoveat> findByAttractionMandMinute(@PathParam("srcId") Long srcId,@PathParam("destId") Long destId, @PathParam("minutes") Integer minutes) {
        List<Tmoveat> l = null;
        Query q = em.createNamedQuery("Tmoveat.findByAttractionMandMinute").setParameter ("srcId", srcId);
        q.setParameter("destId",destId);
        q.setParameter("minutes", minutes);
        l = q.getResultList();
        
        return l;
    }
    
    @GET
    @Path("/oam/{srcId},{destId},{minutes}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Tmoveat> findByAttractionOamAndMinute(@PathParam("srcId") Long srcId, @PathParam("destId") Long destId, @PathParam("minutes") Integer minutes) {
        List<Tmoveat> l = null;
        Query q = em.createNamedQuery("Tmoveat.findByAttractionOamAndMinute").setParameter ("srcId", srcId);
        q.setParameter("destId",destId);
        q.setParameter("minutes", minutes);
        l = q.getResultList();
        
        return l;
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Tmoveat find(@PathParam("id") Long id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Tmoveat> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Tmoveat> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
