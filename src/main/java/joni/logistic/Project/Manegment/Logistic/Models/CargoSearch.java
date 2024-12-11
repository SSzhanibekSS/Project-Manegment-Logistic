package joni.logistic.Project.Manegment.Logistic.Models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "cargo_search")
public class CargoSearch {
    public CargoSearch(int weightInTon, int volume, String poingA, String pointB, String date, String bodyType, String paymentType) {
        this.weightInTon = weightInTon;
        this.volume = volume;
        this.poingA = poingA;
        this.pointB = pointB;
        this.date = date;
        this.bodyType = bodyType;
        this.paymentType = paymentType;
    }

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
    @Column(name = "date")
    @NotEmpty
    private String date;
    @Column(name = "boty_type")
    @NotEmpty
    private String bodyType;
    @Column(name = "payment_type")
    @NotEmpty
    private String paymentType;


    public CargoSearch() {

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

    @Override
    public String toString() {
        return "CargoSearch{" +
                "id=" + id +
                ", weightInTon=" + weightInTon +
                ", volume=" + volume +
                ", poingA='" + poingA + '\'' +
                ", pointB='" + pointB + '\'' +
                ", date='" + date + '\'' +
                ", bodyType='" + bodyType + '\'' +
                ", paymentType='" + paymentType + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
