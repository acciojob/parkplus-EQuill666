package com.driver.model;
import javax.persistence.*;
import java.util.*;

@Entity
public class Spot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    private SpotType spotType;

    @Column(columnDefinition = "TINYINT(1)")
    private Boolean occupied;

    @ManyToOne
    @JoinColumn
    private ParkingLot parkingLot;

    @OneToMany(mappedBy = "parkSpot", cascade = CascadeType.ALL)
    private List<Reservation> reservationList=new ArrayList<>();

    private int pricePerHour;

    public Spot(Boolean available) {
        this.occupied = false;
    }

    public Spot(SpotType spotType, int pricePerHour) {
        this.spotType = spotType;
        this.pricePerHour = pricePerHour;
        this.occupied=false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public SpotType getSpotType() {
        return spotType;
    }

    public void setSpotType(SpotType spotType) {
        this.spotType = spotType;
    }

    public Boolean getOccupied() {
        return occupied;
    }

    public void setOccupied(Boolean available) {
        this.occupied = available;
    }

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public void setParkingLot(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public List<Reservation> getReservationList() {
        return reservationList;
    }

    public void setReservationList(List<Reservation> reservationList) {
        this.reservationList = reservationList;
    }

    public int getPricePerHour() {
        return pricePerHour;
    }

    public void setPricePerHour(int pricePerHour) {
        this.pricePerHour = pricePerHour;
    }

    public Spot() {
        this.occupied=false;
    }
}
