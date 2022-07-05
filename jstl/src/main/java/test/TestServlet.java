package test;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.MemberDTO;

/**
 * Servlet implementation class TestServlet
 */
@WebServlet("/test.do")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//MemberDTO 객체 하나 생성 
		MemberDTO dto = new MemberDTO("1027","1234","이정수",20,"남",33200,"Gold");
		
		//session 생성
		//jsp에서 쓰던 session을 만듦
		HttpSession session = request.getSession();
		session.setAttribute("dto", dto);
		session.setAttribute("msg", "session message");
		
		//ArrayList<MemberDTO> 생성해서 3건 이상 리스트에 저장.
		ArrayList<MemberDTO> list = new ArrayList<>();
		list.add(new MemberDTO("1073","1234","김철수",21,"남",24150,"Gold"));
		list.add(new MemberDTO("1055","1234","나길동",24,"남",5150,"Silver"));
		list.add(new MemberDTO("1059","1234","임영희",24,"여",63150,"Platinum"));
		request.setAttribute("list", list);
		request.setAttribute("age", 20);
		request.getRequestDispatcher("jstl_el.jsp").forward(request, response);
		
		// 1. MemberDTO 클래스의 객체를 하나 생성해서 세션에 객체를 담는다.
		// 2. 세션에 msg를 담는다. 값은 알아서 입력
		// 3. list를 하나 생성하여 dto 클래스의 인스턴스 3개를 생성해서 list에 담는다.
		// 4. request에 list를 담는다, request에 age를 키로 값을 하나 더 담는다.
		// 5. forward로 jstl_el.jsp페이지로 넘어간다.
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
