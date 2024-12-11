package joni.logistic.Project.Manegment.Logistic.Controllers;

import joni.logistic.Project.Manegment.Logistic.Services.CargoHistroyService;
import joni.logistic.Project.Manegment.Logistic.Services.DriverHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/history")
public class HistoryController {
    private DriverHistoryService historyService;
    private CargoHistroyService cargoHistroyService;
    @Autowired
    public HistoryController(DriverHistoryService historyService, CargoHistroyService cargoHistroyService) {
        this.historyService = historyService;
        this.cargoHistroyService = cargoHistroyService;
    }

    @GetMapping("/driver/{name}")
    public String driverHistoryPage(@PathVariable("name") String name,
                                    Model model) {
        model.addAttribute("history", historyService.getHistoryForClient(name));
        return "history/driver_order";
    }

    @GetMapping("/client/{name}")
    public String clientHistoryPage(@PathVariable("name") String name,
                                    Model model) {
        model.addAttribute("history",cargoHistroyService.getCargoListByClientName(name));

        return "history/client_order";
    }
}
