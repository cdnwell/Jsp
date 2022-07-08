package test01;

public class SplitTest {

	public static void main(String[] args) {
		String str = "login.do";
		String[] splitStr = str.split("\\.");
		
		for(int i = 0;i<splitStr.length;i++) {
			System.out.println(splitStr[i]);
		}
	}

}
