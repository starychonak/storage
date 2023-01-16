package org.starychonak.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "view")
public class ViewController {

    @GetMapping("products")
    public String getProductsView() {
        return "products";
    }
}
