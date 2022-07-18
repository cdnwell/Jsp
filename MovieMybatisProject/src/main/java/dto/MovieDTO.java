package dto;

public class MovieDTO {
	private int bno;
	private String title;
	private String openDate;
	private int audienceCount;
	private String director;
	
	public MovieDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public MovieDTO(int bno, String title, String openDate, int audienceCount, String director) {
		super();
		this.bno = bno;
		this.title = title;
		this.openDate = openDate;
		this.audienceCount = audienceCount;
		this.director = director;
	}

	/**
	 * @return the bno
	 */
	public int getBno() {
		return bno;
	}
	/**
	 * @param bno the bno to set
	 */
	public void setBno(int bno) {
		this.bno = bno;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the openDate
	 */
	public String getOpenDate() {
		return openDate;
	}
	/**
	 * @param openDate the openDate to set
	 */
	public void setOpenDate(String openDate) {
		this.openDate = openDate;
	}
	/**
	 * @return the audienceCount
	 */
	public int getAudienceCount() {
		return audienceCount;
	}
	/**
	 * @param audienceCount the audienceCount to set
	 */
	public void setAudienceCount(int audienceCount) {
		this.audienceCount = audienceCount;
	}
	/**
	 * @return the director
	 */
	public String getDirector() {
		return director;
	}
	/**
	 * @param director the director to set
	 */
	public void setDirector(String director) {
		this.director = director;
	}

	@Override
	public String toString() {
		return "MovieDTO [bno=" + bno + ", title=" + title + ", openDate=" + openDate + ", audienceCount="
				+ audienceCount + ", director=" + director + "]";
	}
	
}
