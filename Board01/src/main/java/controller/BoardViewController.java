package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.BoardDTO;
import service.BoardService;
import view.ModelAndView;

public class BoardViewController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int bno = Integer.parseInt(request.getParameter("bno"));
		
		BoardDTO dto = BoardService.getInstance().selectBoard(bno);
		
		request.setAttribute("board_dto", dto);
		//forward 방식은 url에 데이터를 남겨둔다.
		return new ModelAndView("board_view.jsp",false);
	}

}
