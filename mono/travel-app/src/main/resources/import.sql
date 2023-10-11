create sequence travelorder_sequence start with 1 increment by 1;
INSERT INTO TravelOrder(id) VALUES (nextval('travelorder_sequence'));
INSERT INTO TravelOrder(id) VALUES (nextval('travelorder_sequence'));
INSERT INTO TravelOrder(id) VALUES (nextval('travelorder_sequence'));
INSERT INTO TravelOrder(id) VALUES (nextval('travelorder_sequence'));
INSERT INTO TravelOrder(id) VALUES (nextval('travelorder_sequence'));

create sequence flight_sequence start with 1 increment by 1;
INSERT INTO Flight(id,travelorderid,fromAirport,toAirport) VALUES (nextval('flight_sequence'),1,'GRU','MCO');
INSERT INTO Flight(id,travelorderid,fromAirport,toAirport) VALUES (nextval('flight_sequence'),2,'GRU','JFK');
INSERT INTO Flight(id,travelorderid,fromAirport,toAirport) VALUES (nextval('flight_sequence'),3,'GRU','ATL');
INSERT INTO Flight(id,travelorderid,fromAirport,toAirport) VALUES (nextval('flight_sequence'),4,'GRU','MEX');

create sequence hotel_sequence start with 1 increment by 1;
INSERT INTO Hotel(id,travelorderid,nights) VALUES (nextval('hotel_sequence'),1,5);
INSERT INTO Hotel(id,travelorderid,nights) VALUES (nextval('hotel_sequence'),2,2);
INSERT INTO Hotel(id,travelorderid,nights) VALUES (nextval('hotel_sequence'),3,3);
INSERT INTO Hotel(id,travelorderid,nights) VALUES (nextval('hotel_sequence'),4,10);
INSERT INTO Hotel(id,travelorderid,nights) VALUES (nextval('hotel_sequence'),5,30);