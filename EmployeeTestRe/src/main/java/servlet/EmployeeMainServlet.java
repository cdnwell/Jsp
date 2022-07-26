package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import dao.EmployeeDAO;
import dto.EmployeeDTO;
import exception.NoDataException;

/**
 * Servlet implementation class DispatcherServlet
 */
@WebServlet("/search")
public class EmployeeMainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeMainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		response.setContentType("text/html;charset=utf-8");
		String search = request.getParameter("search");
		String content = request.getParameter("content");
		
		if(content.length() == 0 || content == null) throw new NoDataException();
		
		List<EmployeeDTO> list = null;
		switch(search) {
		case "eno":
			list = EmployeeDAO.getInstance().selectByEno(content);
			break;
		case "name":
			list = EmployeeDAO.getInstance().selectByName(content);
			break;
		case "position":
			int position = Integer.parseInt(content);
			list = EmployeeDAO.getInstance().selectByPosition(position);
			break;
		}
		
		if(list.isEmpty()) throw new Exception();
		
		JSONArray array = new JSONArray(list);
		response.getWriter().write(array.toString());
		
		} catch (NumberFormatException e) {
			response.setStatus(1001);
			response.getWriter().write("직급은 숫자로 입력하세요");
		} catch (NoDataException e) {
			response.setStatus(1002);
			response.getWriter().write("검색어를 입력하세요");
		} catch (Exception e) {
			response.setStatus(1003);
			response.getWriter().write("조회 결과가 없습니다.");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
