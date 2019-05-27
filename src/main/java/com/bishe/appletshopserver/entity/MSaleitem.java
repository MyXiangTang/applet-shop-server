package com.bishe.appletshopserver.entity;


import java.sql.Timestamp;

public class MSaleitem {

  private long id;
  private String mSaleId;
  private String mProductId;
  private String mProductName;
  private String qty;
  private String amt;
  private String remark;
  private java.sql.Timestamp creationdate;
  private java.sql.Timestamp modifieddate;

  public String getmProductName() {
    return mProductName;
  }

  public void setmProductName(String mProductName) {
    this.mProductName = mProductName;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getmSaleId() {
    return mSaleId;
  }

  public void setmSaleId(String mSaleId) {
    this.mSaleId = mSaleId;
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

  @Override
  public String toString() {
    return "MSaleitem{" +
            "id=" + id +
            ", mSaleId='" + mSaleId + '\'' +
            ", mProductId='" + mProductId + '\'' +
            ", mProductName='" + mProductName + '\'' +
            ", qty='" + qty + '\'' +
            ", amt='" + amt + '\'' +
            ", remark='" + remark + '\'' +
            ", creationdate=" + creationdate +
            ", modifieddate=" + modifieddate +
            '}';
  }
}
