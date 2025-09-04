package com.nt.vo;

import org.springframework.lang.NonNull;

public class ActorVO {
	
    private Integer aid;
    @NonNull
    private String aname;
    @NonNull
    private String addrs;
    @NonNull
    private String category;
    @NonNull
    private Float fee;
    
    public ActorVO() {}
    
    
	public ActorVO(Integer aid, String aname, String addrs, String category, Float fee) {
		super();
		this.aid = aid;
		this.aname = aname;
		this.addrs = addrs;
		this.category = category;
		this.fee = fee;
	}


	public Integer getAid() {
		return aid;
	}
	public void setAid(Integer aid) {
		this.aid = aid;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public String getAddrs() {
		return addrs;
	}
	public void setAddrs(String addrs) {
		this.addrs = addrs;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Float getFee() {
		return fee;
	}
	public void setFee(Float fee) {
		this.fee = fee;
	}
	
	@Override
	public String toString() {
		return "ActorVO [aid=" + aid + ", aname=" + aname + ", addrs=" + addrs + ", category=" + category + ", fee="
				+ fee + "]";
	}
    
}
