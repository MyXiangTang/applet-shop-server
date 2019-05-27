package com.bishe.appletshopserver.entity;


import java.sql.Timestamp;
import java.util.List;

public class MSale {

    private long id;
    private String docno;
    private String billdate;
    private String wxCustomerId;
    private String wxCustomerName;
    private String totQty;
    private String totAmt;
    private String status;
    private String remark;
    private String mProductId;
    private java.sql.Timestamp creationdate;
    private java.sql.Timestamp modifieddate;
    private int page;
    private int pageSize;
    private List<MSaleitem> details;

    public String getmProductId() {
        return mProductId;
    }

    public void setmProductId(String mProductId) {
        this.mProductId = mProductId;
    }

    public String getWxCustomerName() {
        return wxCustomerName;
    }

    public void setWxCustomerName(String wxCustomerName) {
        this.wxCustomerName = wxCustomerName;
    }

    public List<MSaleitem> getDetails() {
        return details;
    }

    public void setDetails(List<MSaleitem> details) {
        this.details = details;
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

    public String getBilldate() {
        return billdate;
    }

    public void setBilldate(String billdate) {
        this.billdate = billdate;
    }

    public String getWxCustomerId() {
        return wxCustomerId;
    }

    public void setWxCustomerId(String wxCustomerId) {
        this.wxCustomerId = wxCustomerId;
    }

    public String getTotQty() {
        return totQty;
    }

    public void setTotQty(String totQty) {
        this.totQty = totQty;
    }

    public String getTotAmt() {
        return totAmt;
    }

    public void setTotAmt(String totAmt) {
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

    @Override
    public String toString() {
        return "MSale{" +
                "id=" + id +
                ", docno='" + docno + '\'' +
                ", billdate='" + billdate + '\'' +
                ", wxCustomerId='" + wxCustomerId + '\'' +
                ", wxCustomerName='" + wxCustomerName + '\'' +
                ", totQty='" + totQty + '\'' +
                ", totAmt='" + totAmt + '\'' +
                ", status='" + status + '\'' +
                ", remark='" + remark + '\'' +
                ", mProductId='" + mProductId + '\'' +
                ", creationdate=" + creationdate +
                ", modifieddate=" + modifieddate +
                ", page=" + page +
                ", pageSize=" + pageSize +
                ", details=" + details +
                '}';
    }
}
