package joni.logistic.Project.Manegment.Logistic.Controllers;

import joni.logistic.Project.Manegment.Logistic.Models.Driver;
import joni.logistic.Project.Manegment.Logistic.Models.DriverHistory;
import joni.logistic.Project.Manegment.Logistic.Models.DriverOrder;
import joni.logistic.Project.Manegment.Logistic.Services.DriverHistoryService;
import joni.logistic.Project.Manegment.Logistic.Services.DriverOrderService;
import joni.logistic.Project.Manegment.Logistic.Services.DriverService;
import joni.logistic.Project.Manegment.Logistic.Util.GetClientID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/carsearch")
public class CarSearchController {
    private DriverOrderService driverOrderService;
    private DriverHistoryService driverHistoryService;
    private GetClientID getClientID ;
    private DriverService driverService;
    @Autowired
    public CarSearchController(DriverOrderService driverOrderService, DriverHistoryService driverHistoryService, GetClientID getClientID, DriverService driverService) {
        this.driverOrderService = driverOrderService;
        this.driverHistoryService = driverHistoryService;
        this.getClientID = getClientID;
        this.driverService = driverService;
    }

    @GetMapping()
    public String carSearch(@ModelAttribute("driverOrder") DriverOrder driverOrder){
        return "driver/search_order";
    }


    @PostMapping("/do_order")
    public String DoSearch(@ModelAttribute("driverOrder") DriverOrder driverOrder,
                           Model model,
                           @ModelAttribute("history")DriverHistory history){
        history.setaPointAndBPoint(driverOrder.getPoingA() + " -> " + driverOrder.getPoingA());
        history.setClientNama(getClientID.getClientName());
        history.setOrderId(driverOrder.getId());

        driverHistoryService.addHistory(history);

        model.addAttribute("orders", driverOrderService.getOrderByObject(driverOrder));
        model.addAttribute("clientName", getClientID.getClientName());
        return "driver/do_order_with_list";
    }
    @GetMapping("/order/{id}")
    public String TakeOrder(@PathVariable("id") int id,
                            Model model){
        model.addAttribute("order", driverOrderService.getOrderById(id));

        return "driver/order_page";
    }

    @GetMapping("/do_order/{id}")
    public String AddOrder(@PathVariable("id") int id){

        driverService.addOrder(new Driver(id,getClientID.getClientName()));
        return "redirect:/carsearch";
    }

}
