package servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class FileUploadServlet
 */
@WebServlet("/upload.do2")
public class FileUploadServlet_src extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileUploadServlet_src() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//재배포를 하면 (작은 부분이라도 바뀌면) 파일이 다 날라감
		//파일이 날라가는 걸 예방하기 위해 서버에 저장
		request.setCharacterEncoding("utf-8");
		String encoding = "utf-8";
		
		//파일 업로드할 기본 폴더 c:\\fileUpload\\
		//재배포가 되더라도 파일을 수정할 수 없다.
		File userRoot = new File("c:\\fileUpload\\");
		//서버 내의 파일 경로에 업로드 하겠다 -> /upload
		
		//경로가 유효한지, 있으면 true
		//해당경로까지 폴더를 만들어줌
		if(!userRoot.exists())
			userRoot.mkdirs();
		
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setRepository(userRoot);		//업로드될 폴더 설정
		factory.setSizeThreshold(1024*1024);	//버퍼 메모리
		
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		try {
			//몇 개를 보내던 다 넘어감 >> parseRequest 덕분
			List<FileItem> list = upload.parseRequest(request);
			for(FileItem item : list) {
				//formfield = 파일 제외하고 직접 입력한 내용, text,textarea등 직접 입력하는 내용
				//formfield > 따로 처리하는 구문이 있어야 함
				if(item.isFormField()) {
					System.out.println(item.getFieldName() + "=" + item.getString(encoding));
					//게시판 내용 타이틀이나 등 읽어옴
					request.setAttribute(item.getFieldName(), item.getString(encoding));
				} else {
					System.out.println("매개변수명 : " + item.getFieldName());
					System.out.println("파일명 : " + item.getName());
					System.out.println("파일크기 : " + item.getSize());
					System.out.println("파일타입 : " + item.getContentType());
					//파일 태그가 여러 개일 수 있다. 파일 선택을 안하면 전송이 되긴하는데 빈 데이터로 전송됨
					//파일 사이즈로 체크하면 파일이 없는 경우를 알 수 있다.
					//0보다 큰 경우 파일이 있다는 걸 알 수 있음
					if(item.getSize() > 0) {
						//경로에 혹시라도 폴더가 들어가 있을 경우, 다 잘라내기 위해서 쓰는 부분
						int idx = item.getName().lastIndexOf("\\");
						//lastindexof에서 -1은 역슬러쉬가 없다는 것, 못찾았다는 의미 : -1
						if(idx == -1) {
							//상대경로를 잡는 경우 슬러쉬가 많이 온다.
							idx = item.getName().lastIndexOf("/");
							
							String fileName = item.getName().substring(idx + 1);
							//파일명해서 경로 잡음
							//절대 경로 > 이걸 쓰면 안되고 url 경로를 써야함
							File uploadFile = new File(userRoot + "\\" + fileName);
							//이걸 이용해서
							//파일쓰기가 되는 부분 write 아이템에서 이거 하나만 넣어주면 업로드됨
							//파일쓰기 까지 기능이 다 만들어져 있고 경로만 잘 설정해 주면 된다.
							
							//파일명을 반드시 사용자가 저장한 것으로 해야 되는지,
							//똑같은 파일명을 보내는 경우가 생김
							
							//사용자 이름으로 폴더 만들고 일련번호로 제목을 바꾸어서 올림
							//전체 경로 보낼 필요 없이 파일명만
							//파일명을 db에 저장하고 별칭을 받아서 파일 다운
							//게시판 만들려면 파일테이블 따로 만들어야
							item.write(uploadFile);
							request.setAttribute("file1", fileName);
						}
					}
				}
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("file_result.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
