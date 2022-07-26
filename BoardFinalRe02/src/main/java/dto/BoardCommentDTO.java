package dto;

public class BoardCommentDTO {
	private int cno;
	private int bno;
	private String content;
	private String writer;
	private String cdate;
	private int like;
	private int hate;
	
	public BoardCommentDTO() {
	}
	
	public BoardCommentDTO(int cno, int bno, String content, String writer, String cdate, int like, int hate) {
		super();
		this.cno = cno;
		this.bno = bno;
		this.content = content;
		this.writer = writer;
		this.cdate = cdate;
		this.like = like;
		this.hate = hate;
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
	public int getLike() {
		return like;
	}
	public void setLike(int like) {
		this.like = like;
	}
	public int getHate() {
		return hate;
	}
	public void setHate(int hate) {
		this.hate = hate;
	}
	
	@Override
	public String toString() {
		return "BoardCommentDTO [cno=" + cno + ", bno=" + bno + ", content=" + content + ", writer=" + writer
				+ ", cdate=" + cdate + ", like=" + like + ", hate=" + hate + "]";
	}
	
}
