package com.bishe.appletshopserver.entity;


import java.sql.Timestamp;

public class MCart {

  private long id;
  private String wxCustomerId;
  private String mProductId;
  private String qty;
  private String amt;
  private String remark;
  private java.sql.Timestamp creationdate;
  private java.sql.Timestamp modifieddate;
  private int page ;
  private int pageSize;
  private String wxCustomerName;
  private String productName;
  private String longName;
  private String imgUrl;
  private String pricelist;

  public String getLongName() {
    return longName;
  }

  public void setLongName(String longName) {
    this.longName = longName;
  }

  public String getImgUrl() {
    return imgUrl;
  }

  public void setImgUrl(String imgUrl) {
    this.imgUrl = imgUrl;
  }

  public String getPricelist() {
    return pricelist;
  }

  public void setPricelist(String pricelist) {
    this.pricelist = pricelist;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getWxCustomerId() {
    return wxCustomerId;
  }

  public void setWxCustomerId(String wxCustomerId) {
    this.wxCustomerId = wxCustomerId;
  }

  public String getmProductId() {
    return mProductId;
  }

  public void setmProductId(String mProductId) {
    this.mProductId = mProductId;
  }

  public String getQty() {
    return qty;
  }

  public void setQty(String qty) {
    this.qty = qty;
  }

  public String getAmt() {
    return amt;
  }

  public void setAmt(String amt) {
    this.amt = amt;
  }

  public String getRemark() {
    return remark;
  }

  public void setRemark(String remark) {
    this.remark = remark;
  }

  public Timestamp getCreationdate() {
    return creationdate;
  }

  public void setCreationdate(Timestamp creationdate) {
    this.creationdate = creationdate;
  }

  public Timestamp getModifieddate() {
    return modifieddate;
  }

  public void setModifieddate(Timestamp modifieddate) {
    this.modifieddate = modifieddate;
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
            ", wxCustomerId='" + wxCustomerId + '\'' +
            ", mProductId='" + mProductId + '\'' +
            ", qty='" + qty + '\'' +
            ", amt='" + amt + '\'' +
            ", remark='" + remark + '\'' +
            ", creationdate=" + creationdate +
            ", modifieddate=" + modifieddate +
            ", page=" + page +
            ", pageSize=" + pageSize +
            ", wxCustomerName='" + wxCustomerName + '\'' +
            ", productName='" + productName + '\'' +
            ", longName='" + longName + '\'' +
            ", imgUrl='" + imgUrl + '\'' +
            ", pricelist='" + pricelist + '\'' +
            '}';
  }
}
