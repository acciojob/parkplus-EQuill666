package com.driver.model;

import javax.persistence.*;

@Entity
public class Payment {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(columnDefinition = "TINYINT(1)")
    private Boolean paymentDone;

    @Enumerated(EnumType.STRING)
    private PaymentMode paymentMode;

    public Payment(){
        this.paymentDone = false;
    }
    public Payment(Boolean paymentDone, PaymentMode paymentMode) {
        this.paymentDone = paymentDone;
        this.paymentMode = paymentMode;
    }

    @OneToOne
    @JoinColumn
    private Reservation reservation;

    //GetterSetter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Boolean getPaymentDone() {
        return paymentDone;
    }

    public void setPaymentDone(Boolean paymentDone) {
        this.paymentDone = paymentDone;
    }

    public PaymentMode getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(PaymentMode paymentMode) {
        this.paymentMode = paymentMode;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }
}
