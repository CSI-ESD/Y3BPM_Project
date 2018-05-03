package com.alexandru.esdbloodpressure.controllers;

import java.security.Principal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Alexandru Constantin <aconstantin@wincom-consulting.com>
 */
@Controller
@RequestMapping("/")
public class MainController {

    @RequestMapping("")
    public String index(Model model, Principal principal) {
        return "index";
    }

    @RequestMapping("/access-denied")
    public String accessDenied(Model model, Principal principal) {
        return "access-denied";
    }
}
