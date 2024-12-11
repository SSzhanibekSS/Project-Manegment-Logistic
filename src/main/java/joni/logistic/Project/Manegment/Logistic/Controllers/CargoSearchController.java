package joni.logistic.Project.Manegment.Logistic.Controllers;

import joni.logistic.Project.Manegment.Logistic.Models.Cargo;
import joni.logistic.Project.Manegment.Logistic.Models.CargoHIstory;
import joni.logistic.Project.Manegment.Logistic.Models.CargoSearch;
import joni.logistic.Project.Manegment.Logistic.Services.CargoHistroyService;
import joni.logistic.Project.Manegment.Logistic.Services.CargoSearchService;
import joni.logistic.Project.Manegment.Logistic.Services.CargoService;
import joni.logistic.Project.Manegment.Logistic.Util.GetClientID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cargosearch")
public class CargoSearchController {

    private GetClientID clientID;
    private CargoSearchService cargoSearchService;
    private CargoService cargoService;
    private CargoHistroyService cargoHistroyService;

    @Autowired
    public CargoSearchController(GetClientID clientID, CargoSearchService cargoSearchService, CargoService cargoService, CargoHistroyService cargoHistroyService) {
        this.clientID = clientID;
        this.cargoSearchService = cargoSearchService;
        this.cargoService = cargoService;
        this.cargoHistroyService = cargoHistroyService;
    }

    @GetMapping()
    public String carSearchPage(@ModelAttribute("cargo") CargoSearch cargoSearch) {

        String str = cargoSearch.getPoingA() + " -> " + cargoSearch.getPointB();
        cargoHistroyService.saveHistory(new CargoHIstory(clientID.getClientName(), str, cargoSearch.getId()));
        return "cargo/cargo";
    }

    @PostMapping("/cargo")
    public String cargoSearchWithTabe(@ModelAttribute("cargo") CargoSearch cargoSearch,
                                      Model model){

        model.addAttribute("ClientName", clientID.getClientName());
        model.addAttribute("orders",cargoSearchService.findCargoByObject(cargoSearch));

        String str = cargoSearch.getPoingA() + " -> " + cargoSearch.getPointB();
        cargoHistroyService.saveHistory(new CargoHIstory(clientID.getClientName(), str, cargoSearch.getId()));


        return "cargo/cargo_with_list";
    }
    @GetMapping("/order/{id}")
    public String openOrder(@PathVariable("id") int id,
                            Model model){

        model.addAttribute("order", cargoSearchService.getCargoById(id));

        return "cargo/cargo_page";
    }
    @GetMapping("/do_order/{id}")
    public String do_order(@ModelAttribute("order") CargoSearch cargoSearch,
                           @PathVariable("id") int id){
        cargoService.SaveCargoOrder(new Cargo(id, clientID.getClientName()));

        return "redirect:/cargosearch";
    }


}
