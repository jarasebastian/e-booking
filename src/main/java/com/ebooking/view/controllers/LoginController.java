/**
 * 
 */
package com.ebooking.view.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controller for custom login
 *
 * @author sebastianjara
 *
 */
@Controller
@RequestMapping("app")
public class LoginController {
	
	@GetMapping(value = {"/login", "/"})
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView();
		String errorMessage = "User non authorized.";
		mav.addObject("errorMsg", errorMessage);
		mav.setViewName("login");
		return mav;
	}
	
	@GetMapping(value = {"/home"})
	public ModelAndView home() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("home");
		return mav;
	}
}
