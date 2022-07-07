package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.MemberDAO;
import dto.MemberDTO;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register2.do")
public class RegisterServlet_src extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet_src() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDTO dto = null;
		
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String gender = request.getParameter("gender");
		String address = request.getParameter("address"); 
		dto = new MemberDTO(id,pass,name,age,gender,address);
		
		int result = 0;
		
		result = MemberDAO.getInstance().insertMemberDTO(dto);
		
		//ajax로 json을 만들어서 주는것 > set charter encoding utf-8만 해줘도 된다.
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		if(result == 1) {
			//회원 정보 등록을 성공했을 때 경고창으로 회원정보 등록을 알려준 후에 main.jsp로 이동  
			//location.href='main.jsp'는 sendRedirect와 같다.
			out.write("<script>alert('회원정보 추가 완료');location.href='main.jsp';</script>");
		}else {
			//회원 정보 등록을 실패 했을 때 경고창으로 회원정보 실패를 알려준 후 이전페이지로 이동
			//php나 다른 언어에서도 js 언어를 이용해 페이지 이동, sendRedirect 방식임. 같다.
			out.write("<script>alert('회원정보 추가 실패');history.back();</script>");
		}
		//나중에는 이 부분이 controller로 들어감.
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		doGet(request, response);
	}

}
