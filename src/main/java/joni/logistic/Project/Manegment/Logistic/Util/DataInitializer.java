package joni.logistic.Project.Manegment.Logistic.Util;

import joni.logistic.Project.Manegment.Logistic.Models.CargoSearch;
import joni.logistic.Project.Manegment.Logistic.Models.DriverOrder;
import joni.logistic.Project.Manegment.Logistic.Services.CargoSearchService;
import joni.logistic.Project.Manegment.Logistic.Services.DriverOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final DriverOrderService driverOrderService;
    private final CargoSearchService cargoSearchService;
    @Autowired
    public DataInitializer(DriverOrderService driverOrderRepository, CargoSearchService cargoSearchService) {
        this.driverOrderService = driverOrderRepository;
        this.cargoSearchService = cargoSearchService;
    }



    @Override
    public void run(String... args) {

        DriverOrder order1 = new DriverOrder();
        order1.setWeightInTon(10);
        order1.setVolume(20);
        order1.setPoingA("Алматы");
        order1.setPointB("Нур-Султан");
        order1.setCargoType("Продукты питания");
        order1.setDate("2024-12-10");
        order1.setBodyType("Тентованный");
        order1.setPaymentType("С предоплатой");
        order1.setCost(120000);

        DriverOrder order2 = new DriverOrder();
        order2.setWeightInTon(15);
        order2.setVolume(25);
        order2.setPoingA("Шымкент");
        order2.setPointB("Караганда");
        order2.setCargoType("Стройматериалы");
        order2.setDate("2024-12-15");
        order2.setBodyType("Рефрижератор");
        order2.setPaymentType("Оплата наличными");
        order2.setCost(150000);


        driverOrderService.addOrder(order1);
        driverOrderService.addOrder(order2);

        CargoSearch cargoSearch1 = new CargoSearch(10, 20, "Алматы", "Караганда", "2024-12-15", "Рефрижератор", "Оплата наличными");
        CargoSearch cargoSearch2 = new CargoSearch(10, 50, "Шымкент", "Кызылорда", "2024-12-15", "Рефрижератор", "Оплата наличными");
        CargoSearch cargoSearch3 = new CargoSearch(15, 20, "Павлодар", "Петровал", "2024-12-15", "Рефрижератор", "Оплата наличными");
        CargoSearch cargoSearch4 = new CargoSearch(25, 70, "Алматы", "Орал", "2024-12-15", "Рефрижератор", "Оплата наличными");
        CargoSearch cargoSearch5 = new CargoSearch(10, 10, "Караганда", "Алматы", "2024-12-15", "Рефрижератор", "Оплата наличными");
        CargoSearch cargoSearch6 = new CargoSearch(15, 20, "Алматы", "Нур-Султан", "2024-12-15", "Рефрижератор", "Оплата наличными");
        CargoSearch cargoSearch7 = new CargoSearch(20, 30, "Нур-Слтан", "Караганда", "2024-12-15", "Рефрижератор", "Оплата наличными");
        CargoSearch cargoSearch8 = new CargoSearch(10, 20, "Алматы", "Семей", "2024-12-15", "Рефрижератор", "Оплата наличными");

        cargoSearchService.saveOrder(cargoSearch1);
        cargoSearchService.saveOrder(cargoSearch2);
        cargoSearchService.saveOrder(cargoSearch3);
        cargoSearchService.saveOrder(cargoSearch4);
        cargoSearchService.saveOrder(cargoSearch5);
        cargoSearchService.saveOrder(cargoSearch6);
        cargoSearchService.saveOrder(cargoSearch7);
        cargoSearchService.saveOrder(cargoSearch8);



        System.out.println("Данные успешно инициализированы!");
    }
}