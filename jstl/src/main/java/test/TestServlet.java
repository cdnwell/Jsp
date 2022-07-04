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
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
