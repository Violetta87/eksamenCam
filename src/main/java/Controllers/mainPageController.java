package Controllers;

import org.springframework.web.bind.annotation.PostMapping;

public class mainPageController {
    @PostMapping("/")
    public String mainpage(){
        return "mainPage";
    }
}
