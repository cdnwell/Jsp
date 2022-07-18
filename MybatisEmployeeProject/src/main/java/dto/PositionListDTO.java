package dto;

public class PositionListDTO {
	private int pno;
	private String name;
	
	public PositionListDTO() {
		super();
	}
	
	public PositionListDTO(int pno, String name) {
		super();
		this.pno = pno;
		this.name = name;
	}
	public int getPno() {
		return pno;
	}
	public void setPno(int pno) {
		this.pno = pno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() {
		return "PositionListDTO [pno=" + pno + ", name=" + name + "]";
	}
	
}
