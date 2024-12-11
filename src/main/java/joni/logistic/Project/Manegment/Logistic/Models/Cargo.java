package joni.logistic.Project.Manegment.Logistic.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "cargo")
public class Cargo {
    public Cargo(int orderId, String driverName) {
        this.orderId = orderId;
        this.driverName = driverName;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "order_id")
    private int orderId;
    @Column(name = "driver_name")
    private String driverName;

    public Cargo() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }
}
