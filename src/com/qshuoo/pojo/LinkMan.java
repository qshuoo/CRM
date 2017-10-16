package com.qshuoo.pojo;

public class LinkMan {
	private Long linkman_id;// 联系人编号(主键)
	private String linkman_name;// 联系人姓名
	private Long linkman_cust_id; // 客户id
	private String linkman_gender; // 联系人性别
	private String linkman_phone;// 联系人办公电话
	private String linkman_mobile;// 联系人手机
	private String linkman_email;// 联系人邮箱
	private String linkman_qq;// 联系人qq
	private String linkman_position; // 联系人职位
	private String linkman_memo; // 联系人备注
	
	private Customer customer;
	public LinkMan() {
		super();
	}
	public LinkMan(Long linkman_id, String linkman_name, Long linkman_cust_id, String linkman_gender,
			String linkman_phone, String linkman_mobile, String linkman_email, String linkman_qq,
			String linkman_position, String linkman_memo) {
		super();
		this.linkman_id = linkman_id;
		this.linkman_name = linkman_name;
		this.linkman_cust_id = linkman_cust_id;
		this.linkman_gender = linkman_gender;
		this.linkman_phone = linkman_phone;
		this.linkman_mobile = linkman_mobile;
		this.linkman_email = linkman_email;
		this.linkman_qq = linkman_qq;
		this.linkman_position = linkman_position;
		this.linkman_memo = linkman_memo;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Long getLinkman_id() {
		return linkman_id;
	}
	public void setLinkman_id(Long linkman_id) {
		this.linkman_id = linkman_id;
	}
	public String getLinkman_name() {
		return linkman_name;
	}
	public void setLinkman_name(String linkman_name) {
		this.linkman_name = linkman_name;
	}
	public Long getLinkman_cust_id() {
		return linkman_cust_id;
	}
	public void setLinkman_cust_id(Long linkman_cust_id) {
		this.linkman_cust_id = linkman_cust_id;
	}
	public String getLinkman_gender() {
		return linkman_gender;
	}
	public void setLinkman_gender(String linkman_gender) {
		this.linkman_gender = linkman_gender;
	}
	public String getLinkman_phone() {
		return linkman_phone;
	}
	public void setLinkman_phone(String linkman_phone) {
		this.linkman_phone = linkman_phone;
	}
	public String getLinkman_mobile() {
		return linkman_mobile;
	}
	public void setLinkman_mobile(String linkman_mobile) {
		this.linkman_mobile = linkman_mobile;
	}
	public String getLinkman_email() {
		return linkman_email;
	}
	public void setLinkman_email(String linkman_email) {
		this.linkman_email = linkman_email;
	}
	public String getLinkman_qq() {
		return linkman_qq;
	}
	public void setLinkman_qq(String linkman_qq) {
		this.linkman_qq = linkman_qq;
	}
	public String getLinkman_position() {
		return linkman_position;
	}
	public void setLinkman_position(String linkman_position) {
		this.linkman_position = linkman_position;
	}
	public String getLinkman_memo() {
		return linkman_memo;
	}
	public void setLinkman_memo(String linkman_memo) {
		this.linkman_memo = linkman_memo;
	}
	@Override
	public String toString() {
		return "LinkMan [linkman_id=" + linkman_id + ", linkman_name=" + linkman_name + ", linkman_cust_id="
				+ linkman_cust_id + ", linkman_gender=" + linkman_gender + ", linkman_phone=" + linkman_phone
				+ ", linkman_mobile=" + linkman_mobile + ", linkman_email=" + linkman_email + ", linkman_qq="
				+ linkman_qq + ", linkman_position=" + linkman_position + ", linkman_memo=" + linkman_memo
				+ ", customer=" + customer + "]";
	}

	
	
	
	

}
