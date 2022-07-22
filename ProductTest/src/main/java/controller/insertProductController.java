package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import dto.ProductDTO;
import exception.MinusException;
import service.ProductService;

public class insertProductController implements Controller {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
		String product_no = request.getParameter("product_no");
		String product_name = request.getParameter("product_name");
		String maker = request.getParameter("maker");
		int price = Integer.parseInt(request.getParameter("price"));
		int ea = Integer.parseInt(request.getParameter("ea"));
		
		ProductDTO dto = new ProductDTO(product_no, product_name, price, ea, maker);
		
		if(ea < 0 || price < 0) throw new MinusException();
		
		int result = ProductService.getInstance().insertProduct(dto);
		
		if(result == 0) throw new Exception();
		
		List<ProductDTO> list = ProductService.getInstance().selectAllProduct();
		JSONArray arr = new JSONArray(list);
		response.getWriter().write(arr.toString());
		
		} catch (NumberFormatException e) {
			response.setStatus(1001);
			response.getWriter().write("금액과 재고는 숫자로 입력하세요");
		} catch (MinusException e) {
			response.setStatus(1002);
			response.getWriter().write("금액과 재고는 양수만 입력하세요");
		} catch (Exception e) {
			response.setStatus(1003);
			response.getWriter().write("입력한 데이터 오류");
		}
	}

}
