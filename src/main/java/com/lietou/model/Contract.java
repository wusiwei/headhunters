package com.lietou.model;

public class Contract {
    private Long id;

    private Long customerId;

    private String startDate;

    private String endDate;

    private String invoiceTitle;

    private String feeStructure;

    private String probation;

    private String contractName;

    private String contractNumber;

    private Integer attachmentCount;

    private String createTime;

    private Long createrId;

    private String remindedOr;

    private String remindedType;

    private Long cId;

    private String remark;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate == null ? null : startDate.trim();
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate == null ? null : endDate.trim();
    }

    public String getInvoiceTitle() {
        return invoiceTitle;
    }

    public void setInvoiceTitle(String invoiceTitle) {
        this.invoiceTitle = invoiceTitle == null ? null : invoiceTitle.trim();
    }

    public String getFeeStructure() {
        return feeStructure;
    }

    public void setFeeStructure(String feeStructure) {
        this.feeStructure = feeStructure == null ? null : feeStructure.trim();
    }

    public String getProbation() {
        return probation;
    }

    public void setProbation(String probation) {
        this.probation = probation == null ? null : probation.trim();
    }

    public String getContractName() {
        return contractName;
    }

    public void setContractName(String contractName) {
        this.contractName = contractName == null ? null : contractName.trim();
    }

    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber == null ? null : contractNumber.trim();
    }

    public Integer getAttachmentCount() {
        return attachmentCount;
    }

    public void setAttachmentCount(Integer attachmentCount) {
        this.attachmentCount = attachmentCount;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    public Long getCreaterId() {
        return createrId;
    }

    public void setCreaterId(Long createrId) {
        this.createrId = createrId;
    }

    public String getRemindedOr() {
        return remindedOr;
    }

    public void setRemindedOr(String remindedOr) {
        this.remindedOr = remindedOr == null ? null : remindedOr.trim();
    }

    public String getRemindedType() {
        return remindedType;
    }

    public void setRemindedType(String remindedType) {
        this.remindedType = remindedType == null ? null : remindedType.trim();
    }

    public Long getcId() {
        return cId;
    }

    public void setcId(Long cId) {
        this.cId = cId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}