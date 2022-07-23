package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.BoardDTO;
import service.BoardService;
import view.ModelAndView;
import vo.PagingVO;

public class MainController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int pageNo = 1;
		
		if(request.getParameter("pageNo") != null)
			pageNo = Integer.parseInt(request.getParameter("pageNo"));
		
		List<BoardDTO> list = BoardService.getInstance().selectAllBoard(pageNo);
		
		int count = BoardService.getInstance().selectAllCount();
		
		PagingVO vo = new PagingVO(count, pageNo, 15, 3);
		
		request.setAttribute("list", list);
		request.setAttribute("paging", vo);
		
		ModelAndView view = new ModelAndView("main.jsp", false);
		
		return view;
	}

}
