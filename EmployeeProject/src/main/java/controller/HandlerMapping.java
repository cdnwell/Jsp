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
		case "employee_list.do":
			controller = new EmployeeListController();
			break;
		case "logout.do":
			controller = new LogoutController();
			break;
		case "register.do":
			controller = new RegisterController();
			break;
		case "delete.do":
			controller = new DeleteController();
			break;
		case "update.do":
			controller = new UpdateController();
			break;
		}
		
		return controller;
	}
	
}
