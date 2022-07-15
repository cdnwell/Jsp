package dto;

public class TeacherDTO {
	private String id;
	private String pass;
	private String name;
	private String position;
	private int status;
	
	public TeacherDTO(String id, String pass, String name, String position, int status) {
		super();
		this.id = id;
		this.pass = pass;
		this.name = name;
		this.position = position;
		this.status = status;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "TeacherDTO [id=" + id + ", pass=" + pass + ", name=" + name + ", position=" + position + ", status="
				+ status + "]";
	}
	
}
