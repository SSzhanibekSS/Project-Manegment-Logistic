package joni.logistic.Project.Manegment.Logistic.Controllers;

import joni.logistic.Project.Manegment.Logistic.Services.CargoHistroyService;
import joni.logistic.Project.Manegment.Logistic.Services.CargoSearchService;
import joni.logistic.Project.Manegment.Logistic.Services.DriverOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/myorders")
public class MyOrderController {
    private DriverOrderService driverOrderService;
    private CargoHistroyService cargoHistroyService;
    private CargoSearchService cargoSearchService;
    @Autowired
    public MyOrderController(DriverOrderService driverOrderService, CargoHistroyService cargoHistroyService, CargoSearchService cargoSearchService) {
        this.driverOrderService = driverOrderService;
        this.cargoHistroyService = cargoHistroyService;
        this.cargoSearchService = cargoSearchService;
    }

    @GetMapping("/driver")
    public String myorder(Model model){

        model.addAttribute("orders",driverOrderService.getOrderForSpecificClient());

        return "myorders/driver_orders";
    }
    @GetMapping("/driver/{id}")
    public String mySpecificOrder(@PathVariable("id") int id,
                                  Model model){
        model.addAttribute("order", driverOrderService.getOrderById(id));
        return "driver_myorder_pagr";
    }

    @GetMapping("/client")
    public String getClientOrders(Model model){

        model.addAttribute("orders", cargoSearchService.getCargosForSpecificClient() );
        return "/myorders/client_order";
    }
    @GetMapping("/client/{id}")
    public String getSecificOrderById(@PathVariable("id") int id,
                                      Model model){
        model.addAttribute("order", cargoSearchService.getCargoById(id));

        return "/myorders/cargo_myorder_page";
    }
}
