package com.mrv.intern.invoicematch.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ReportController {

	

	/**
	  * New page 
	  * @return page
	  * @author Phuoc Nguyen
	  * 
	  */
	@Controller
	public class RootController {
	    @RequestMapping(value = "/report", method = RequestMethod.GET)
	    public String root() {
	        return "report";
	    }
	}

}
