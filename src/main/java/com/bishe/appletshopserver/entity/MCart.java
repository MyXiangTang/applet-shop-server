package com.bishe.appletshopserver.entity;


public class MCart {

  private long id;
  private long wxCustomerId;
  private long mProductId;
  private long qty;
  private double amt;
  private String remark;
  private java.sql.Timestamp creationdate;
  private java.sql.Timestamp modifieddate;
  private int page ;
  private int pageSize;
  private String wxCustomerName;
  private String productName;

  public long getmProductId() {
    return mProductId;
  }

  public void setmProductId(long mProductId) {
    this.mProductId = mProductId;
  }

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


  public long getWxCustomerId() {
    return wxCustomerId;
  }

  public void setWxCustomerId(long wxCustomerId) {
    this.wxCustomerId = wxCustomerId;
  }


  public long getMProductId() {
    return mProductId;
  }

  public void setMProductId(long mProductId) {
    this.mProductId = mProductId;
  }


  public long getQty() {
    return qty;
  }

  public void setQty(long qty) {
    this.qty = qty;
  }


  public double getAmt() {
    return amt;
  }

  public void setAmt(double amt) {
    this.amt = amt;
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

  public String getWxCustomerName() {
    return wxCustomerName;
  }

  public void setWxCustomerName(String wxCustomerName) {
    this.wxCustomerName = wxCustomerName;
  }

  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  @Override
  public String toString() {
    return "MCart{" +
            "id=" + id +
            ", wxCustomerId=" + wxCustomerId +
            ", mProductId=" + mProductId +
            ", qty=" + qty +
            ", amt=" + amt +
            ", remark='" + remark + '\'' +
            ", creationdate=" + creationdate +
            ", modifieddate=" + modifieddate +
            ", page=" + page +
            ", pageSize=" + pageSize +
            ", wxCustomerName='" + wxCustomerName + '\'' +
            ", productNmae='" + productName + '\'' +
            '}';
  }
}
