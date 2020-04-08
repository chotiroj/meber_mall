package meber_mall.pojo;

import org.springframework.web.multipart.MultipartFile;

public class Goods {
	public String getGspicture() {
		return gspicture;
	}
	public void setGspicture(String gspicture) {
		this.gspicture = gspicture;
	}

	private Integer id;
	private String gsname;
	private Integer goodstype_id;
	private String gsactive;
	private String activedetail;
	private Double gsprice;
	private Double gsrprice;
	private MultipartFile logoImage;
	private String gspicture;
	private Integer gsstore;
	private String typename;
	
	public Integer getGsstore() {
		return gsstore;
	}
	public void setGsstore(Integer gsstore) {
		this.gsstore = gsstore;
	}
	public Integer getId() {
		return id;
	}
	public String getGsname() {
		return gsname;
	}
	public Integer getGoodstype_id() {
		return goodstype_id;
	}
	public String getGsactive() {
		return gsactive;
	}
	public String getActivedetail() {
		return activedetail;
	}
	public Double getGsprice() {
		return gsprice;
	}
	public Double getGsrprice() {
		return gsrprice;
	}
	public MultipartFile getLogoImage() {
		return logoImage;
	}
	
	
	public String getTypename() {
		return typename;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public void setGsname(String gsname) {
		this.gsname = gsname;
	}
	public void setGoodstype_id(Integer goodstype_id) {
		this.goodstype_id = goodstype_id;
	}
	public void setGsactive(String gsactive) {
		this.gsactive = gsactive;
	}
	public void setActivedetail(String activedetail) {
		this.activedetail = activedetail;
	}
	public void setGsprice(Double gsprice) {
		this.gsprice = gsprice;
	}
	public void setGsrprice(Double gsrprice) {
		this.gsrprice = gsrprice;
	}
	public void setLogoImage(MultipartFile logoImage) {
		this.logoImage = logoImage;
	}
	
	public void setTypename(String typename) {
		this.typename = typename;
	}
	
	
}
