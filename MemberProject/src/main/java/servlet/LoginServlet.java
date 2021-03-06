package servlet;

import java.io.IOException;
import java.io.PrintWriter;
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
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		
		MemberDTO dto = MemberDAO.getInstance().login(id, pass);
		
		if(dto == null) {
			//로그인이 안 되었을 때 - 자바스크립트로 경고창 출력 후 이전 페이지로 이동
			//response.getWriter()를 쓰면 무조건 response.setContentType을 설정해 주어야 한다.
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.write("<script>alert('로그인 실패 아이디와 비밀번호를 확인하세요');history.back();</script>");
			out.flush();
		} else {
			//세션 생성
			HttpSession session = request.getSession();
			//세션에 dto를 저장
			//setAttribute가 무조건 데이터 저장하는 것
			session.setAttribute("dto", dto);
			//페이지 이동 main.jsp로
			//forward -> 계속 login을 요청하기 때문에 로그인에는 적절하지 않다.
//			request.getRequestDispatcher("main.jsp").forward(request,response);
			
			//나이가 가장많은 인원 3명을 저장
			ArrayList<MemberDTO> list = MemberDAO.getInstance().selectTopAge3();
			//request에 저장하면 sendRedirect를 해서 다 날아감
			session.setAttribute("list", list);
			
			//2.send Redirect
			//로그아웃하거나 브라우저를 닫기 전까지 세션의 정보가 안사라진다.
			//페이지 이동 방식 1. forward(request) 2. sendRedirect(response)
			response.sendRedirect("main.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}
