/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.service;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author tesi
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(entities.service.AdminFacadeREST.class);
        resources.add(entities.service.AreaMFacadeREST.class);
        resources.add(entities.service.AreaOamFacadeREST.class);
        resources.add(entities.service.AttractionCFacadeREST.class);
        resources.add(entities.service.AttractionMFacadeREST.class);
        resources.add(entities.service.AttractionOamFacadeREST.class);
        resources.add(entities.service.CityFacadeREST.class);
        resources.add(entities.service.MuseumFacadeREST.class);
        resources.add(entities.service.OamFacadeREST.class);
        resources.add(entities.service.SensingFacadeREST.class);
        resources.add(entities.service.TcodaFacadeREST.class);
        resources.add(entities.service.TmoveaaFacadeREST.class);
        resources.add(entities.service.TmovearFacadeREST.class);
        resources.add(entities.service.TmoveatFacadeREST.class);
        resources.add(entities.service.TvisitaFacadeREST.class);
        resources.add(entities.service.UsersFacadeREST.class);
    }
    
}
