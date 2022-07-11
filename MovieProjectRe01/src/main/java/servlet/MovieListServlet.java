package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import dao.MovieDAO;
import dto.MovieDTO;
import vo.PaggingVO;

/**
 * Servlet implementation class MovieListServlet
 */
@WebServlet("/list.do")
public class MovieListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MovieListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pageNo = 1;
		if(request.getParameter("pageNo") != null)
			pageNo = Integer.parseInt(request.getParameter("pageNo"));
		
		String kind = request.getParameter("kind");
		String search = request.getParameter("search");
		
		ArrayList<MovieDTO> list = MovieDAO.getInstance().selectMovieList(pageNo,kind,search);
		int count = MovieDAO.getInstance().selectCount();
		
		PaggingVO pagging = new PaggingVO(count, pageNo, 7, 4);
		request.setAttribute("pagging", pagging);
		JSONArray array = new JSONArray(list);
		response.getWriter().write(array.toString());
		
		request.getRequestDispatcher("movie_list_ajax.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
