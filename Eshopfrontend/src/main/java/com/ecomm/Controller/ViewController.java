package com.ecomm.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
public class ViewController
{
	@RequestMapping(value = "/login", method = RequestMethod.GET)

public String loginPage()
{
	return "login";
}
@RequestMapping(value= "/RegForm", method = RequestMethod.GET)

public String regPage()
{
	return "RegForm";
}
@RequestMapping(value="/")
public String indexPage()
{
	return "index";
}
@RequestMapping(value="/Home")
public String HomePage()
{
	return "Home";
}

}
