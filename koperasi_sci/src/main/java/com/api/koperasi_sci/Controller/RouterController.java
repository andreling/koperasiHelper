package com.api.koperasi_sci.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RouterController {

    @GetMapping("/")
    public String home() {
        return "index";
    }

}
