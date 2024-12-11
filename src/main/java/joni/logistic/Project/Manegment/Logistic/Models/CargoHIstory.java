package joni.logistic.Project.Manegment.Logistic.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "cargo_history")
public class CargoHIstory {
    public CargoHIstory(String clientNama, String aPointAndBPoint, int orderId) {
        this.clientNama = clientNama;
        this.aPointAndBPoint = aPointAndBPoint;
        this.orderId = orderId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "client_name")
    private String clientNama;
    @Column(name = "way")
    private String aPointAndBPoint;

    @Column(name = "order_id")
    private int orderId;

    public CargoHIstory() {

    }

    public String getClientNama() {
        return clientNama;
    }

    public void setClientNama(String clientNama) {
        this.clientNama = clientNama;
    }

    public String getaPointAndBPoint() {
        return aPointAndBPoint;
    }

    public void setaPointAndBPoint(String aPointAndBPoint) {
        this.aPointAndBPoint = aPointAndBPoint;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
}
