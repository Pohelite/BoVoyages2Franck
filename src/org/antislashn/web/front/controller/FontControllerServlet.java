package org.antislashn.web.front.controller;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(value={ "/FrontControllerServlet", "/FrontController" },
					loadOnStartup = 10,
					initParams = {@WebInitParam(name = "configFile", value = "controller-conf.xml") })
public class FontControllerServlet extends HttpServlet {
	private static final ControllerFactory CONTROLLER_FACTORY = new ControllerFactory();
	private static final Logger LOG = Logger.getLogger(FontControllerServlet.class.getName());
	
	@Override
	public void init() throws ServletException {
		String configFile = this.getInitParameter("configFile");
		try {
			String path = this.getServletContext().getResource("/WEB-INF/"+configFile).getPath();
			log(">>> configuration file : " + path);
			CONTROLLER_FACTORY.setConfigurationFile(path);
		} catch (MalformedURLException e) {
			new ServletException(e);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cde = request.getParameter("cde");
		if(cde==null || cde.isEmpty()) {
			cde="home";
		}
		LOG.info(">>> cde : "+cde);
		Controller controller = CONTROLLER_FACTORY.getController(cde);
		String jimmy = controller.compute(request, response);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/"+jimmy+".jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
