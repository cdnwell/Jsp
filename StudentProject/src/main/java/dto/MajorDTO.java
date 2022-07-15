package dto;

public class MajorDTO {
	private int mno;
	private String mname;
	
	public MajorDTO(int mno, String mname) {
		super();
		this.mno = mno;
		this.mname = mname;
	}
	
	public int getMno() {
		return mno;
	}
	public void setMno(int mno) {
		this.mno = mno;
	}
	public String getMname() {
		return mname;
	}
	public void setMname(String mname) {
		this.mname = mname;
	}
	
	@Override
	public String toString() {
		return "MajorDTO [mno=" + mno + ", mname=" + mname + "]";
	}
	
}
