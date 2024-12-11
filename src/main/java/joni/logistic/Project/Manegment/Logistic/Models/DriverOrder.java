package joni.logistic.Project.Manegment.Logistic.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table
public class DriverOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "weightInTon")
    private int weightInTon;
    @Column(name = "volume")
    private int volume;
    @Column(name = "poing_a")
    @NotEmpty
    private String poingA;
    @Column(name = "poing_b")
    @NotEmpty
    private String pointB;

    @Column(name = "cargo_type")
    @NotEmpty
    private String cargoType;
    @Column(name = "date")
    @NotEmpty
    private String date;
    @Column(name = "boty_type")
    @NotEmpty
    private String bodyType;
    @Column(name = "payment_type")
    @NotEmpty
    private String paymentType;
    @Column(name = "cost")
    private int cost;

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getWeightInTon() {
        return weightInTon;
    }

    public void setWeightInTon(int weightInTon) {
        this.weightInTon = weightInTon;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public String getPoingA() {
        return poingA;
    }

    public void setPoingA(String poingA) {
        this.poingA = poingA;
    }

    public String getPointB() {
        return pointB;
    }

    public void setPointB(String pointB) {
        this.pointB = pointB;
    }

    public String getCargoType() {
        return cargoType;
    }

    public void setCargoType(String cargoType) {
        this.cargoType = cargoType;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getBodyType() {
        return bodyType;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "DriverOrder{" +
                "id=" + id +
                ", weightInTon=" + weightInTon +
                ", volume=" + volume +
                ", poingA='" + poingA + '\'' +
                ", pointB='" + pointB + '\'' +
                ", cargoType='" + cargoType + '\'' +
                ", date='" + date + '\'' +
                ", bodyType='" + bodyType + '\'' +
                ", paymentType='" + paymentType + '\'' +
                '}';
    }
}
