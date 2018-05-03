package com.alexandru.esdbloodpressure.controllers;

import com.alexandru.esdbloodpressure.models.Notification;
import com.alexandru.esdbloodpressure.models.User;
import com.alexandru.esdbloodpressure.repositories.UserRepository;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Alexandru Constantin <aconstantin@wincom-consulting.com>
 */
@Controller
@RequestMapping("/admin")
@Transactional
public class AdminController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/admin-page")
    public String adminPage(Model model) {
        return "admin/admin-page";
    }

    @RequestMapping("/getAllUsers")
    public @ResponseBody
    List<User> getAllUsers(Model model) {
        List<User> result = userRepository.findAll();
        if (result == null) {
            return new ArrayList<>();
        }
        for (User user : result) {
            Hibernate.initialize(user.getAuthorities());
        }
        return result;
        //return userRepository.findAll();
    }

    @RequestMapping(value = "/deleteUser")
    public String deleteUser(@RequestParam("username") String username,
            Model model,
            RedirectAttributes redirectAttributes) {
        if (username == null || username.isEmpty()) {
            redirectAttributes.addFlashAttribute("notification", new Notification("danger", "Please type in the username for the user to be deleted"));
            return "redirect:admin-page";
        }
        User user = userRepository.findByUsername(username);
        if (user == null) {
            redirectAttributes.addFlashAttribute("notification", new Notification("danger", "User could not be found"));
            return "redirect:admin-page";
        }
        //make delete return 0 or 1 then split
        userRepository.delete(user);
        return "redirect:admin-page";
    }

}
