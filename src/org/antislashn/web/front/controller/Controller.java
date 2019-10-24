package org.antislashn.web.front.controller;

import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
	Logger LOG = Logger.getLogger(Controller.class.getName());
	String compute(HttpServletRequest request,HttpServletResponse response);
}
