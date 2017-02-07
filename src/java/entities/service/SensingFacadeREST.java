/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.service;

import entities.Sensing;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
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
@Path("entities.sensing")
public class SensingFacadeREST extends AbstractFacade<Sensing> {

    @PersistenceContext(unitName = "RestNeptisPU")
    private EntityManager em;

    public SensingFacadeREST() {
        super(Sensing.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Sensing entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Long id, Sensing entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        super.remove(super.find(id));
    }

    
    
    //mio
    @GET
    @Path("/tcoda/cityId={cityId}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Sensing> findAttractioncByCityId(@PathParam("cityId") long cityId){
    
    DateFormat dataFormat = new SimpleDateFormat("yyyy-MM-dd");
    Calendar calendar = Calendar.getInstance(); //now
    calendar.add(Calendar.DAY_OF_YEAR,-7);
    String s = dataFormat.format(calendar.getTime());
    Timestamp tt = Timestamp.valueOf(s+" 00:00:0.1");
    //System.out.println(s);
    
    Query q = em.createQuery("SELECT s FROM Sensing s JOIN Tcoda c JOIN AttractionC a WHERE (s.data  >= '"+tt+"' AND s.tcoda.id = c.id AND c.attractionC.id = a.id AND a.city.id = :cityId)");
    q.setParameter("cityId", cityId); 
    List<Sensing> results = (List<Sensing>) q.getResultList();
     return results;
    }

    //mio
    @GET
    @Path("/tvisita/cityId={cityId}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Sensing> findVisitaByCityId(@PathParam("cityId") long cityId){
        
    DateFormat dataFormat = new SimpleDateFormat("yyyy-MM-dd");
    Calendar calendar = Calendar.getInstance(); //now
    calendar.add(Calendar.DAY_OF_YEAR,-7);
    String s = dataFormat.format(calendar.getTime());
    Timestamp tt = Timestamp.valueOf(s+" 00:00:0.1");
    //System.out.println(s);  
    
    Query q = em.createQuery("SELECT s FROM Sensing s JOIN Tvisita v JOIN AttractionC a WHERE (s.data  >= '"+tt+"' AND s.tvisita.id = v.id AND v.attractionC.id = a.id AND a.city.id = :cityId)");
    q.setParameter("cityId", cityId); 
    List<Sensing> results = (List<Sensing>) q.getResultList();
     return results;
    }
    
    
     //mio
    @GET
    @Path("/tcoda/museum/attrId={attrId}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Sensing> findQueueByAttractionId(@PathParam("attrId") long attrId){
    
    DateFormat dataFormat = new SimpleDateFormat("yyyy-MM-dd");
    Calendar calendar = Calendar.getInstance(); //now
    calendar.add(Calendar.DAY_OF_YEAR,-7);
    String s = dataFormat.format(calendar.getTime());
    Timestamp tt = Timestamp.valueOf(s+" 00:00:0.1");
    //System.out.println(s);
    
    Query q = em.createQuery("SELECT s FROM Sensing s WHERE s.data IN (SELECT MAX(s.data) FROM Sensing s,Tcoda t,AreaM a WHERE s.tcoda.id = t.id AND t.areaM.id=a.id and a.id=:attrId)");
    q.setParameter("attrId", attrId); 
    List<Sensing> results = (List<Sensing>) q.getResultList();
     return results;
    }

    
    //mio
    @GET
    @Path("/tvisita/museum/attrId={attrId}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Sensing> findVisitaByMuseumId(@PathParam("attrId") long attrId){
    
        /*
    DateFormat dataFormat = new SimpleDateFormat("yyyy-MM-dd");
    Calendar calendar = Calendar.getInstance(); //now
    calendar.add(Calendar.DAY_OF_YEAR,-7);
    String s = dataFormat.format(calendar.getTime());
    Timestamp tt = Timestamp.valueOf(s+" 00:00:0.1");
    //System.out.println(s);  
*/
    
       
   Query q = em.createQuery("SELECT s FROM Sensing s WHERE s.data IN (SELECT MAX(s.data) FROM Sensing s,Tvisita t,AttractionM a WHERE s.tvisita.id = t.id AND t.attractionM.id=a.id and a.id=:attrId)");
   q.setParameter("attrId", attrId); 
   List<Sensing> results = (List<Sensing>) q.getResultList();
    return results;
    }
    
    
    
    
     @GET
   @Path("/tmoveAT/city/cityId={cityId}")
   @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
   public List<Sensing> findTmoveAtByCityId(@PathParam("cityId") long cityId){
   
   // DateFormat dataFormat = new SimpleDateFormat("yyyy-MM-dd");
    //Calendar calendar = Calendar.getInstance(); //now
    //calendar.add(Calendar.DAY_OF_YEAR,-1);
    //String s = dataFormat.format(calendar.getTime());
    //Timestamp tt = Timestamp.valueOf(s+" 00:00:0.1");
    //System.out.println(s);  
       
   Query q = em.createQuery("SELECT s FROM Sensing s JOIN Tmoveat c JOIN AttractionC a WHERE (s.data IN(SELECT MAX(s.data) FROM Sensing S) AND s.tmoveat.id = c.id AND c.attractionC1.id = a.id AND a.city.id = :cityId) ");
   q.setParameter("cityId", cityId); 
   List<Sensing> results = (List<Sensing>) q.getResultList();
    return results;
   }
    
    
   
   
   @GET
  @Path("/tmoveAA/city/cityId={cityId}")
  @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
  public List<Sensing> findTmoveAaByCityId(@PathParam("cityId") long cityId){
 
      
    DateFormat dataFormat = new SimpleDateFormat("yyyy-MM-dd");
    Calendar calendar = Calendar.getInstance(); //now
    calendar.add(Calendar.DAY_OF_YEAR,-30);
    String s = dataFormat.format(calendar.getTime());
    Timestamp tt = Timestamp.valueOf(s+" 00:00:0.1");
    //System.out.println(s);  
      
  Query q = em.createQuery("SELECT s FROM Sensing s JOIN Tmoveaa c JOIN AttractionC a WHERE (s.data  >= '"+tt+"' AND s.tmoveaa.id = c.id AND c.attractionC.id = a.id AND a.city.id = :cityId)");
  q.setParameter("cityId", cityId); 
  List<Sensing> results = (List<Sensing>) q.getResultList();
   return results;
  }
   
   
    
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Sensing find(@PathParam("id") Long id) {
        return super.find(id);
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Sensing> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Sensing> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
