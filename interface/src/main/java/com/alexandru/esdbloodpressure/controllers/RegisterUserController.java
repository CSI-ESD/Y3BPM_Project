package com.alexandru.esdbloodpressure.controllers;

import com.alexandru.esdbloodpressure.exceptions.EmailAlreadyExistsException;
import com.alexandru.esdbloodpressure.exceptions.UserAlreadyExistsException;
import com.alexandru.esdbloodpressure.models.Notification;
import com.alexandru.esdbloodpressure.models.UserDto;
import com.alexandru.esdbloodpressure.services.UserService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Alexandru Constantin <aconstantin@wincom-consulting.com>
 */
@Controller
@RequestMapping("/registerUser")
public class RegisterUserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String registerUser(@Valid @ModelAttribute("userDto") UserDto userDto,
            BindingResult bindingResult,
            Model model,
            RedirectAttributes redirectAttributes) throws UserAlreadyExistsException, EmailAlreadyExistsException {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userDto", bindingResult);
            redirectAttributes.addFlashAttribute("userDto", userDto);
            return "redirect:/login?register";
        } else {
            String username = userService.registerNewUserAccount(userDto);
            redirectAttributes.addFlashAttribute("notification", new Notification("success", "User <strong>" + username + "</strong> succesfully registered. You can now proceed to log in."));
            return "redirect:/login";
        }
    }

    //spring intercepts all requests before coming into the controller
    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        //trim white space from parameters
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }
}
