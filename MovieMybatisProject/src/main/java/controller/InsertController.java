package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import dto.MovieDTO;
import service.MovieService;

public class InsertController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		//title, open_date, audience_count, director
		String title = request.getParameter("title");
		String openDate = request.getParameter("open_date");
		int audienceCount = Integer.parseInt(request.getParameter("audience_count"));
		String director = request.getParameter("director");
		
		int result = MovieService.getInstance().insertMovie(
				new MovieDTO(0, title, openDate, audienceCount, director));
		
		if(result == 0) throw new Exception();
		//데이터 등록이 성공하면 전체 영화 데이터를 json으로 전송
		//데이터 등록이 실패하면 데이터 등록에 실패 하였습니다. 에러 메세지 처리
		
		List<MovieDTO> list = MovieService.getInstance().selectAllMovie();
		JSONArray arr = new JSONArray(list);
//		System.out.println(arr);
		response.getWriter().write(arr.toString());
		} catch (NumberFormatException e) {
			// 숫자인데 문자열 들어온 경우
			response.setStatus(1001);
			response.getWriter().write("누적 관객수는 숫자로 입력하세요");
		} catch (Exception e) {
			response.setStatus(1002);
			response.getWriter().write("데이터 등록에 실패 하였습니다.");
		}
	}

}
