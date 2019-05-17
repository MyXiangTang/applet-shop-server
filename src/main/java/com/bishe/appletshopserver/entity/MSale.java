package com.bishe.appletshopserver.entity;


public class MSale {

  private long id;
  private String docno;
  private long billdate;
  private long wxCustomerId;
  private long totQty;
  private double totAmt;
  private String status;
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


  public String getDocno() {
    return docno;
  }

  public void setDocno(String docno) {
    this.docno = docno;
  }


  public long getBilldate() {
    return billdate;
  }

  public void setBilldate(long billdate) {
    this.billdate = billdate;
  }


  public long getWxCustomerId() {
    return wxCustomerId;
  }

  public void setWxCustomerId(long wxCustomerId) {
    this.wxCustomerId = wxCustomerId;
  }


  public long getTotQty() {
    return totQty;
  }

  public void setTotQty(long totQty) {
    this.totQty = totQty;
  }


  public double getTotAmt() {
    return totAmt;
  }

  public void setTotAmt(double totAmt) {
    this.totAmt = totAmt;
  }


  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
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
    return "MSale{" +
            "id=" + id +
            ", docno='" + docno + '\'' +
            ", billdate=" + billdate +
            ", wxCustomerId=" + wxCustomerId +
            ", totQty=" + totQty +
            ", totAmt=" + totAmt +
            ", status='" + status + '\'' +
            ", remark='" + remark + '\'' +
            ", creationdate=" + creationdate +
            ", modifieddate=" + modifieddate +
            ", page=" + page +
            ", pageSize=" + pageSize +
            '}';
  }
}
