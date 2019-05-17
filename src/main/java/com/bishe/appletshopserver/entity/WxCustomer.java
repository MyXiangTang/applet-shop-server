package com.bishe.appletshopserver.entity;


public class WxCustomer {

  private long id;
  private String name;
  private String phone;
  private String openId;
  private String address;
  private String remark;
  private java.sql.Timestamp creationdate;
  private java.sql.Timestamp modifieddate;
  private int page ;
  private int pageSize;

  public int getPage() {
    return page;
  }

  public void setPage(int page) {
    this.page = page;
  }

  public int getPageSize() {
    return pageSize;
  }

  public void setPageSize(int pageSize) {
    this.pageSize = pageSize;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }


  public String getOpenId() {
    return openId;
  }

  public void setOpenId(String openId) {
    this.openId = openId;
  }


  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }


  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }


  public java.sql.Timestamp getCreationdate() {
    return creationdate;
  }

  public void setCreationdate(java.sql.Timestamp creationdate) {
    this.creationdate = creationdate;
  }


  public java.sql.Timestamp getModifieddate() {
    return modifieddate;
  }

  public void setModifieddate(java.sql.Timestamp modifieddate) {
    this.modifieddate = modifieddate;
  }

  @Override
  public String toString() {
    return "WxCustomer{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", phone='" + phone + '\'' +
            ", openId='" + openId + '\'' +
            ", address='" + address + '\'' +
            ", remark='" + remark + '\'' +
            ", creationdate=" + creationdate +
            ", modifieddate=" + modifieddate +
            ", page=" + page +
            ", pageSize=" + pageSize +
            '}';
  }
}
