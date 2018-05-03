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
@RequestMapping("/session")
public class SessionController {

    @RequestMapping("/new-session")
    public String newSession(Model model, Principal principal) {
        return "new-session";
    }
}
