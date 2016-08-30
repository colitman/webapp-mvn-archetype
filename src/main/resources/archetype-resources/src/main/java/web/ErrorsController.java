#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
/**
 * This software is licensed under the terms of the MIT license.
 * Copyright (C) 2016 Dmytro Romenskyi
 */
package ${package}.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path="/errors", method=RequestMethod.GET)
public class ErrorsController {

	@RequestMapping(path="/{error}")
	public ModelAndView getImport(@PathVariable String error, ModelAndView mv) {
		mv.setViewName("errors/" + error);
		
		return mv;
	}
}
