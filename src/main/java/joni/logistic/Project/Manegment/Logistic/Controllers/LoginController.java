package joni.logistic.Project.Manegment.Logistic.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping("/logout")
    public String logout(){
        return "";
    }
}
