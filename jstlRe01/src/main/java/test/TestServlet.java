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
		// 1. MemberDTO 클래스의 객체를 하나 생성해서 세션에 객체를 담는다.
		// 2. 세션에 msg를 담는다. 값은 알아서 입력
		// 3. list를 하나 생성하여 dto 클래스의 인스턴스 3개를 생성해서 list에 담는다.
		// 4. request에 list를 담는다, request에 age를 키로 값을 하나 더 담는다.
		// 5. forward로 jstl_el.jsp페이지로 넘어간다.
		MemberDTO dto = new MemberDTO("1021","1234","김철수",21,"남",24510,"Gold");
		HttpSession session = request.getSession();
		session.setAttribute("dto", dto);
		session.setAttribute("msg","hello world message");
		
		ArrayList<MemberDTO> list = new ArrayList<>();
		list.add(new MemberDTO("1052","1234","안영희",24,"여",34152,"Platinum"));
		list.add(new MemberDTO("1232","1234","영선희",21,"여",11562,"Silver"));
		list.add(new MemberDTO("1652","1234","김상주",27,"남",24152,"Gold"));
		
		request.setAttribute("list", list);
		request.setAttribute("age", 32);
		request.getRequestDispatcher("jstl_el.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
