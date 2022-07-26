package vo;

public class PagingVO {
	private int count;
	private int currentPageNo;
	private int pageOfContentCount;
	private int pageGroupOfCount;
	
	public PagingVO(int count, int currentPageNo, int pageOfContentCount, int pageGroupOfCount) {
		super();
		this.count = count;
		this.currentPageNo = currentPageNo;
		this.pageOfContentCount = pageOfContentCount;
		this.pageGroupOfCount = pageGroupOfCount;
	}

	//현재 페이지 번호
	public int getCurrentPageNo() {
		return currentPageNo;
	}
	
	//전체 페이지 개수
	public int getTotalPage() {
		return count / pageOfContentCount + (count % pageOfContentCount == 0 ? 0 : 1);
	}
	
	//전체 페이지 그룹 개수
	public int getTotalPageGroup() {
		return getTotalPage() / pageGroupOfCount + (getTotalPage() % pageGroupOfCount == 0 ? 0 : 1);
	}
	
	//현재 페이지 그룹 번호
	public int getNowPageGroupNo() {
		return currentPageNo / pageGroupOfCount + (currentPageNo % pageGroupOfCount == 0 ? 0 : 1);
	}
	
	//현재 페이지 그룹 시작 페이지 번호
	public int getStartPageOfPageGroup() {
		return (getNowPageGroupNo()-1) * pageGroupOfCount + 1;
	}
	
	//현재 페이지 그룹 마지막 페이지 번호
	public int getEndPageOfPageGroup() {
		if(getNowPageGroupNo() * pageGroupOfCount > getTotalPage())
			return getTotalPage();
		return getNowPageGroupNo() * pageGroupOfCount;
	}
	
	//이전 페이지 그룹이 있냐?
	public boolean isPreviousPageGroup() {
		return getNowPageGroupNo() > 1;
	}
	
	//다음 페이지 그룹이 있냐?
	public boolean isNextPageGroup() {
		return getNowPageGroupNo() < getTotalPageGroup();
	}

	@Override
	public String toString() {
		return "PaginVO [count=" + count + ", currentPageNo=" + currentPageNo + ", pageOfContentCount="
				+ pageOfContentCount + ", pageGroupOfCount=" + pageGroupOfCount + ", getCurrentPageNo()="
				+ getCurrentPageNo() + ", getTotalPage()=" + getTotalPage() + ", getTotalPageGroup()="
				+ getTotalPageGroup() + ", getNowPageGroupNo()=" + getNowPageGroupNo() + ", getStartPageOfPageGroup()="
				+ getStartPageOfPageGroup() + ", getEndPageOfPageGroup()=" + getEndPageOfPageGroup()
				+ ", isPreviousPageGroup()=" + isPreviousPageGroup() + ", isNextPageGroup()=" + isNextPageGroup() + "]";
	}
	
}
