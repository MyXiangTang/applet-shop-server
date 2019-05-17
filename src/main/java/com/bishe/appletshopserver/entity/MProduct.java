package com.bishe.appletshopserver.entity;


public class MProduct {

  private long id;
  private String code;
  private String name;
  private String longName;
  private long divisionId;
  private double pricelist;
  private String imgUrl;
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


  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public String getLongName() {
    return longName;
  }

  public void setLongName(String longName) {
    this.longName = longName;
  }


  public long getDivisionId() {
    return divisionId;
  }

  public void setDivisionId(long divisionId) {
    this.divisionId = divisionId;
  }


  public double getPricelist() {
    return pricelist;
  }

  public void setPricelist(double pricelist) {
    this.pricelist = pricelist;
  }


  public String getImgUrl() {
    return imgUrl;
  }

  public void setImgUrl(String imgUrl) {
    this.imgUrl = imgUrl;
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
    return "MProduct{" +
            "id=" + id +
            ", code='" + code + '\'' +
            ", name='" + name + '\'' +
            ", longName='" + longName + '\'' +
            ", divisionId=" + divisionId +
            ", pricelist=" + pricelist +
            ", imgUrl='" + imgUrl + '\'' +
            ", remark='" + remark + '\'' +
            ", creationdate=" + creationdate +
            ", modifieddate=" + modifieddate +
            ", page=" + page +
            ", pageSize=" + pageSize +
            '}';
  }
}
