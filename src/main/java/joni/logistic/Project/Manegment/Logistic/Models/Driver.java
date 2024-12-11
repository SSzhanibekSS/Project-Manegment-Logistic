package joni.logistic.Project.Manegment.Logistic.Models;

import jakarta.persistence.*;

@Entity
@Table(name = "drivers_order")
public class Driver {
    public Driver(int orderId, String driverName) {
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

    public Driver() {

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

    @Override
    public String toString() {
        return "Driver{" +
                "id=" + id +
                ", orderId=" + orderId +
                ", driverName='" + driverName + '\'' +
                '}';
    }
}
