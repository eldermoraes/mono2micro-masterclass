package com.eldermoraes.flight;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

@Entity
public class Flight extends PanacheEntity {
    
    public Long travelOrderId;
    public String fromAirport;
    public String toAirport;

    public static Flight findByTravelOrderId(Long travelOrderId){
        return find("travelOrderId", travelOrderId).firstResult();
    }
}
