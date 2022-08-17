package com.displate.javaenabling.springworkshop.restapi.app6swagger;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
class SwaggerController {

    @GetMapping("/swagger-ui")
    RedirectView swaggerRedirect() {
        return new RedirectView("/swagger-ui/index.html");
    }
}
