package com.eldermoraes.travelorder;

public class Hotel {

    private Long id;
    private Long travelOrderId;
    private Integer nights;
    
    public Hotel() {
    }
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getTravelOrderId() {
        return travelOrderId;
    }
    public void setTravelOrderId(Long travelOrderId) {
        this.travelOrderId = travelOrderId;
    }
    public Integer getNights() {
        return nights;
    }
    public void setNights(Integer nights) {
        this.nights = nights;
    }

}
