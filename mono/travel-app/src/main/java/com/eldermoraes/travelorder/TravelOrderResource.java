package com.eldermoraes.travelorder;

import java.util.List;
import java.util.stream.Collectors;

import com.eldermoraes.flight.Flight;
import com.eldermoraes.flight.FlightResource;
import com.eldermoraes.hotel.Hotel;
import com.eldermoraes.hotel.HotelResource;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("travelorder")
public class TravelOrderResource {
    
    @Inject
    FlightResource flightResource;

    @Inject
    HotelResource hotelResource;


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<TravelOrderDTO> orders(){
        return TravelOrder.<TravelOrder>listAll().stream()
            .map(
                order -> TravelOrderDTO.of(
                    order, 
                    flightResource.findByTravelOrderId(order.id), 
                    hotelResource.findByTravelOrderId(order.id) 
                )
            ).collect(Collectors.toList());
    }

    @GET
    @Path("findById")
    public TravelOrder findById(@QueryParam("id") long id){
        return TravelOrder.findById(id);
    }

    @Transactional
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public TravelOrder newTravelOrder(TravelOrderDTO orderDto){
        TravelOrder order = new TravelOrder();
        order.id = null;
        order.persist();

        Flight flight = new Flight();
        flight.fromAirport = orderDto.getFromAirport();
        flight.toAirport = orderDto.getToAirport();
        flight.travelOrderId = order.id;
        flightResource.newFlight(flight);

        Hotel hotel = new Hotel();
        hotel.nights = orderDto.getNights();
        hotel.travelOrderId = order.id;
        hotelResource.newHotel(hotel);

        return order;
    }
}
