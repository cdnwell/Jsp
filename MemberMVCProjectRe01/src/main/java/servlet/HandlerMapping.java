package servlet;

import controller.Controller;

public class HandlerMapping {
	private static HandlerMapping instance = new HandlerMapping();
	
	private HandlerMapping() {  }
	
	public static HandlerMapping getInstance() {
		if(instance == null) instance = new HandlerMapping();
		
		return instance;
	}
	
	public Controller createController(String url) {
		Controller controller = null;
		
		switch(url) {
		case "login.do":
			controller = new LoginController();
			break;
			
		}
		
		return controller;
	}
	
}
