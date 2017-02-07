/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.service;

import entities.AttractionM;
import java.util.Collection;
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
import javax.ws.rs.core.Response;

/**
 *
 * @author tesi
 */
@Stateless
@Path("entities.attractionm")
public class AttractionMFacadeREST extends AbstractFacade<AttractionM> {

    @PersistenceContext(unitName = "RestNeptisPU")
    private EntityManager em;

    public AttractionMFacadeREST() {
        super(AttractionM.class);
    }
    
    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public Response create(Collection<AttractionM> entities) {
        entities.forEach((entity) -> {
            super.create(entity);
        });
        return Response.status(Response.Status.CREATED).build();
    }
    
    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Long id, AttractionM entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        super.remove(super.find(id));
    }
    
    //mio
    @GET
    @Path("museumId={id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<AttractionM> findByMuseumId(@PathParam("id") Long id){
       List<AttractionM> attractionC = em.createNamedQuery("AttractionM.findByMuseumId").setParameter("id", id).getResultList(); 
       return attractionC;
    }

    
    @GET
    @Path("areaId={areaId}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<AttractionM> findByAreaId(@PathParam("areaId") Long areaId) {
        List<AttractionM> l = null;
        Query q = em.createNamedQuery("AttractionM.findByAreaId").setParameter ("areaId", areaId);
        l = q.getResultList();
        return l;
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public AttractionM find(@PathParam("id") Long id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<AttractionM> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<AttractionM> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
