package dto;

public class ProductDTO {
	private String product_no;
	private String product_name;
	private int price;
	private int ea;
	private String maker;
	public ProductDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ProductDTO(String product_no, String product_name, int price, int ea, String maker) {
		super();
		this.product_no = product_no;
		this.product_name = product_name;
		this.price = price;
		this.ea = ea;
		this.maker = maker;
	}
	/**
	 * @return the product_no
	 */
	public String getProduct_no() {
		return product_no;
	}
	/**
	 * @param product_no the product_no to set
	 */
	public void setProduct_no(String product_no) {
		this.product_no = product_no;
	}
	/**
	 * @return the product_name
	 */
	public String getProduct_name() {
		return product_name;
	}
	/**
	 * @param product_name the product_name to set
	 */
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	/**
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(int price) {
		this.price = price;
	}
	/**
	 * @return the ea
	 */
	public int getEa() {
		return ea;
	}
	/**
	 * @param ea the ea to set
	 */
	public void setEa(int ea) {
		this.ea = ea;
	}
	/**
	 * @return the maker
	 */
	public String getMaker() {
		return maker;
	}
	/**
	 * @param maker the maker to set
	 */
	public void setMaker(String maker) {
		this.maker = maker;
	}
	@Override
	public String toString() {
		return "ProductDTO [product_no=" + product_no + ", product_name=" + product_name + ", price=" + price + ", ea="
				+ ea + ", maker=" + maker + "]";
	}
	
	
}
