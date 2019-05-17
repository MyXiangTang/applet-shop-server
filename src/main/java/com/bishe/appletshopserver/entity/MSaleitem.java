package com.bishe.appletshopserver.entity;


public class MSaleitem {

  private long id;
  private long mSaleId;
  private long mProductId;
  private long qty;
  private double amt;
  private String remark;
  private java.sql.Timestamp creationdate;
  private java.sql.Timestamp modifieddate;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getMSaleId() {
    return mSaleId;
  }

  public void setMSaleId(long mSaleId) {
    this.mSaleId = mSaleId;
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

}
