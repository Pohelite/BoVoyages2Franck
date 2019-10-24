package org.antislashn.web.front.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class ControllerFactory {
	private Controller defaultController;
	private Map<String, Controller> controllers = new HashMap<String, Controller>();
	private static final Logger LOG = Logger.getLogger(ControllerFactory.class.getName());
	
	public void setConfigurationFile(String confFile) {
		init(confFile);
	}
	
	public Controller getController(String cde) {
		Controller controller = controllers.get(cde);
		if(controller == null) {
			controller = defaultController;
		}
		return controller;
	}
	
	private void init(String fileName) {
		try {
			Document document = XMLHelper.getDocument(fileName);
			String defaultActionName = document.getElementsByTagName("default-action").item(0).getTextContent().trim();
			defaultController = Class.forName(defaultActionName).asSubclass(Controller.class).getDeclaredConstructor().newInstance();
			LOG.info(">>> default Controller "+defaultController);
			NodeList nodeList=  document.getElementsByTagName("action");
			for(int i=0 ; i< nodeList.getLength() ; i++){
				Element element = (Element) nodeList.item(i); 
				String name = element.getElementsByTagName("name").item(0).getTextContent().trim();
				String className = element.getElementsByTagName("class").item(0).getTextContent().trim();
				Controller controller = Class.forName(className).asSubclass(Controller.class).getDeclaredConstructor().newInstance();
				controllers.put(name, controller);
				LOG.info(">>> add Controller "+name + " => " + controller);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
