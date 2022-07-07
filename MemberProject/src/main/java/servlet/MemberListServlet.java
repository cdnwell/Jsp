package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDAO;
import dto.MemberDTO;

/**
 * Servlet implementation class MemberListServlet
 */
@WebServlet("/memberList.do")
public class MemberListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
		ArrayList<MemberDTO> list = MemberDAO.getInstance().selectMemberList();
		
		//지속적인 상호작용 필요 > forward, 한번만 상호작용 > sendRedirect
		
		request.setAttribute("list", list);
		request.getRequestDispatcher("member_list.jsp").forward(request, response);
		
//		list = MemberDAO.getInstance().selectAllMember();
//		HttpSession session = request.getSession();
//		
//		session.setAttribute("members", list);
//		
//		response.sendRedirect("member_list.jsp");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request, response);
	}

}
