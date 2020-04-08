package meber_mall.pojo;

public class Order {
		public Integer id;
		public Integer user_id;
		public String orderdate;
		public Double amount;
		
		public Integer getId() {
			return id;
		}
		public Integer getUser_id() {
			return user_id;
		}
		public String getOrderdate() {
			return orderdate;
		}
		public Double getAmount() {
			return amount;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public void setUser_id(Integer user_id) {
			this.user_id = user_id;
		}
		public void setOrderdate(String orderdate) {
			this.orderdate = orderdate;
		}
		public void setAmount(Double amount) {
			this.amount = amount;
		}
		
}
