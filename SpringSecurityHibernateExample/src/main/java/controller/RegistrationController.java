package controller;

import dto.UserDto;
import model.User;
import service.SecurityService;
import service.UserService;
import validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
public class RegistrationController {
	 @Autowired
	    private UserService userService;

	    @Autowired
	    private SecurityService securityService;

	    @Autowired
	    private UserValidator userValidator;

	    @RequestMapping(value = "/registration", method = RequestMethod.GET)
	    public String registration(Model model) {
	        model.addAttribute("userForm", new UserDto());

	        return "registration";
	    }

	    @RequestMapping(value = "/registration", method = RequestMethod.POST)
	    public String registration(@ModelAttribute("userForm") UserDto userForm, BindingResult bindingResult, Model model) {
	        userValidator.validate(userForm, bindingResult);

	        if (bindingResult.hasErrors()) {
	            return "registration";
	        }
	        
	        User user = new User(userForm);
	        
	        userService.save(user);

	        securityService.autologin(userForm.getUsername(), userForm.getPasswordConfirm());

	        return "redirect:/welcome";
	    }

	    @RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
	    public String welcome(Model model) {
	        return "welcome";
	    }
}
