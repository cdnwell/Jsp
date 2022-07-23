package dto;

public class BoardCommentDTO {
	private int cno;
	private int bno;
	private String content;
	private String writer;
	private String cdate;
	private int clike;
	private int chate;
	
	public BoardCommentDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public BoardCommentDTO(int cno, int bno, String content, String writer, String cdate, int clike, int chate) {
		super();
		this.cno = cno;
		this.bno = bno;
		this.content = content;
		this.writer = writer;
		this.cdate = cdate;
		this.clike = clike;
		this.chate = chate;
	}
	
	public BoardCommentDTO(int bno, String content, String writer) {
		super();
		this.bno = bno;
		this.content = content;
		this.writer = writer;
	}
	
	public int getCno() {
		return cno;
	}
	public void setCno(int cno) {
		this.cno = cno;
	}
	public int getBno() {
		return bno;
	}
	public void setBno(int bno) {
		this.bno = bno;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getCdate() {
		return cdate;
	}
	public void setCdate(String cdate) {
		this.cdate = cdate;
	}
	public int getClike() {
		return clike;
	}
	public void setClike(int clike) {
		this.clike = clike;
	}
	public int getChate() {
		return chate;
	}
	public void setChate(int chate) {
		this.chate = chate;
	}
	
	@Override
	public String toString() {
		return "BoardCommentDTO [cno=" + cno + ", bno=" + bno + ", content=" + content + ", writer=" + writer
				+ ", cdate=" + cdate + ", clike=" + clike + ", chate=" + chate + "]";
	}
	
}
