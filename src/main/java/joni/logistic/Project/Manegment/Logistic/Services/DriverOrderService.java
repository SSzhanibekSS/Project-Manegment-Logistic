package joni.logistic.Project.Manegment.Logistic.Services;

import joni.logistic.Project.Manegment.Logistic.Models.Driver;
import joni.logistic.Project.Manegment.Logistic.Models.DriverOrder;
import joni.logistic.Project.Manegment.Logistic.Repositories.DriverOrderRepository;
import joni.logistic.Project.Manegment.Logistic.Util.GetClientID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class DriverOrderService {
    private DriverService driverService;
    private DriverOrderRepository driverOrderRepository;
    private GetClientID clientID;

    @Autowired
    public DriverOrderService(DriverService driverService, DriverOrderRepository driverOrderRepository, GetClientID clientID) {
        this.driverService = driverService;
        this.driverOrderRepository = driverOrderRepository;
        this.clientID = clientID;
    }

    public List<DriverOrder> getOrderByObject(DriverOrder driverOrder) {
        int weight = driverOrder.getWeightInTon();
        int vlo = driverOrder.getVolume();

        String pA = driverOrder.getPoingA();
        String pB = driverOrder.getPointB();

        String cargo = driverOrder.getCargoType();
        String body = driverOrder.getBodyType();
        String payment = driverOrder.getPaymentType();

    return driverOrderRepository.findAllByWeightInTonAndVolumeAndBodyTypeAndCargoTypeAndPaymentTypeAndPointBAndPoingA(weight,vlo,body,cargo,payment,pB,pA);
    }
    @Transactional
    public void addOrder(DriverOrder order){
        driverOrderRepository.save(order);
    }
    public List<DriverOrder> getOrders(){
        return driverOrderRepository.findAll();
    }
    public DriverOrder getOrderById(int id ){
        return driverOrderRepository.findById(id).orElse(new DriverOrder());
    }

    public List<DriverOrder> getOrderForSpecificClient(){

        List<DriverOrder> driverOrders = new ArrayList<>();

        List<Driver> orderByName = driverService.getOrderByName(clientID.getClientName());

        for(Driver d: orderByName){
            driverOrders.add(getOrderById(d.getOrderId()));
        }
        return driverOrders;


    }

}
