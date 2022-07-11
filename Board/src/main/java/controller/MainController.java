package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDAO;
import dto.BoardDTO;
import service.BoardService;
import view.ModelAndView;
import vo.PaggingVO;

public class MainController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int pageNo = 1;
		//페이지 번호가 있을때만 읽어옴
		if(request.getParameter("pageNo") != null)
			pageNo = Integer.parseInt(request.getParameter("pageNo"));
		
		//페이지에 해당하는 글 목록을 조회
		ArrayList<BoardDTO> list = BoardService.getInstance().selectBoardList(pageNo);
		int count = BoardService.getInstance().selectCount();
		PaggingVO pagging = new PaggingVO(count, pageNo, 15, 4);
		request.setAttribute("board_list", list);
		request.setAttribute("pagging", pagging);
		
		ModelAndView view = new ModelAndView("main.jsp", false);
		
		return view;
	}

}
