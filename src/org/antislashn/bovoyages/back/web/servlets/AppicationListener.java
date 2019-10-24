package org.antislashn.bovoyages.back.web.servlets;

import java.util.logging.Logger;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.antislashn.bovoyages.back.Constantes;
import org.antislashn.bovoyages.back.services.DestinationsService;

/**
 * Application Lifecycle Listener implementation class AppicationListener
 *
 */
@WebListener
public class AppicationListener implements ServletContextListener {
	private static final Logger LOG = Logger.getLogger(Constantes.TAG_LOG);
	
	public void contextInitialized(ServletContextEvent sce)  {
		LOG.info(">>> Initialisation de ServletContext");
		ServletContext ctx = sce.getServletContext();
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(Constantes.UNIT_NAME);
		ctx.setAttribute(Constantes.EMF, emf);
		LOG.info(">>> Initialisation de ServletContext : ajout de l'EntityManagerFactory");
		DestinationsService service = new DestinationsService(emf);
		ctx.setAttribute(Constantes.DESTINATIONS_SERVICE, service);
		LOG.info(">>> Initialisation de ServletContext : ajout de DestinationsService");
	}

    public void contextDestroyed(ServletContextEvent sce)  {
    	LOG.info(">>> Destruction de ServletContext");
    	ServletContext ctx = sce.getServletContext();
    	EntityManagerFactory emf = (EntityManagerFactory) ctx.getAttribute(Constantes.EMF);
    	emf.close();
    	LOG.info(">>> Destruction de ServletContext : arrêt de l'EntityManagerFactory");
    }

	
}
