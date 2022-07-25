package servlet;

import java.io.File;

public class FileDTO {
	private String path;
	private String fileName;
	private String type;
	
	public FileDTO(File file) {
		this.path = file.getAbsolutePath();	//현재 파일 경로가 나옴, 파일명만 제외하고
		this.fileName = file.getName();
		//파일 확장자를 뽑기 위한 구문
		switch(fileName.substring(fileName.lastIndexOf(".")+1).toLowerCase()) {
		case "png":
		case "bmp":
		case "gif":
		case "jpg":
			this.type="image";
			break;
		default:
			this.type="normal";
		}
		//간단하게 이미지만 구분함. 동영상 체크는 mp4만 하면됨 mp4가 아니면 웹에서 실행불가능하기 떄문이다.
		//모든 스트리밍은 mp4로 제공
	}

	/**
	 * @return the path
	 */
	public String getPath() {
		return path;
	}

	/**
	 * @param path the path to set
	 */
	public void setPath(String path) {
		this.path = path;
	}

	/**
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * @param fileName the fileName to set
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "FileDTO [path=" + path + ", fileName=" + fileName + ", type=" + type + "]";
	}

	public FileDTO() {
	}
	
}
