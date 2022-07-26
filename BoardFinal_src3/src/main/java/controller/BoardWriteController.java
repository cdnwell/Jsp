package controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import dto.FileDTO;
import service.BoardService;
import view.ModelAndView;

public class BoardWriteController implements Controller {

	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String writer = null;
		String title = null;
		String content = null;

		
		
		String encoding = "utf-8";
		File userRoot = new File(request.getSession().getServletContext().getRealPath("/")
				+"/upload");
		if(!userRoot.exists())
			userRoot.mkdirs();
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setRepository(userRoot);//업로드될 폴더 설정
		factory.setSizeThreshold(1024*1024);//버퍼 메모리
		
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		try {
			List<FileItem> list = upload.parseRequest(request);
			ArrayList<FileDTO> fList = new ArrayList<FileDTO>();
			int bno = BoardService.getInstance().selectBoardNo();
			
			for(FileItem item : list) {
				if(item.isFormField()) {
					switch(item.getFieldName()) {
					case "title":
						title = item.getString(encoding);
						break;
					case "content":
						content = item.getString(encoding);
						break;
					case "writer":
						writer = item.getString(encoding);
						break;
					}
					
				} else {
					//파일을 쓰는 부분
					if(item.getSize() > 0) {
						int idx = item.getName().lastIndexOf("\\");
						if(idx == -1)
							idx = item.getName().lastIndexOf("/");
						
						String fileName = item.getName().substring(idx + 1);
						//*핵심 uploadFile*
						File uploadFile = new File(userRoot + "\\" + fileName);
						if(!uploadFile.getParentFile().exists())
							uploadFile.getParentFile().mkdirs();
						fList.add(new FileDTO(uploadFile, 0, fList.size()));
						//fList.size() 아무것도 없으면 0, 하나 있으면 1, 두 개 들어가면 2...
						//생성자 만들면 해결
					}
				}
				
			}
			
		
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new ModelAndView("main.do", true);
	}

}
