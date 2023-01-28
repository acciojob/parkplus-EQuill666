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

    private int hourlyCharge;

    public Spot(Boolean available) {
        this.occupied = false;
    }

    public Spot(SpotType spotType, int hourlyCharge) {
        this.spotType = spotType;
        this.hourlyCharge = hourlyCharge;
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

    public Boolean getAvailable() {
        return occupied;
    }

    public void setAvailable(Boolean available) {
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

    public int getHourlyCharge() {
        return hourlyCharge;
    }

    public void setHourlyCharge(int hourlyCharge) {
        this.hourlyCharge = hourlyCharge;
    }

    public Spot() {
    }
}
