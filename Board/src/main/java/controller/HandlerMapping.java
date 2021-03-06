package controller;

public class HandlerMapping {
	private static HandlerMapping instance = new HandlerMapping();
	
	private HandlerMapping() { }

	public static HandlerMapping getInstance() {
		if(instance == null)
			instance = new HandlerMapping();
		
		return instance;
	}
	
	public Controller createController(String command) {
		Controller controller = null;
		
		switch(command) {
		case "login.do":
			controller = new LoginController();
			break;
		case "main.do":
			controller = new MainController();
			break;
		}
		
		return controller;
	}
	
}
