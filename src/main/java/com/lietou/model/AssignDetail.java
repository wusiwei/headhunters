package com.lietou.model;

import java.math.BigDecimal;

public class AssignDetail {
    private Long id;

    private Long assignId;

    private String assignType;

    private Integer performancePercent;

    private Integer assignPercent;

    private String createTime;

    private Long createrId;

    private BigDecimal performanceAmount;

    private BigDecimal assignAmount;

    private Long assignederId;

    private Boolean sendFlag;

    private String assignederName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAssignId() {
        return assignId;
    }

    public void setAssignId(Long assignId) {
        this.assignId = assignId;
    }

    public String getAssignType() {
        return assignType;
    }

    public void setAssignType(String assignType) {
        this.assignType = assignType == null ? null : assignType.trim();
    }

    public Integer getPerformancePercent() {
        return performancePercent;
    }

    public void setPerformancePercent(Integer performancePercent) {
        this.performancePercent = performancePercent;
    }

    public Integer getAssignPercent() {
        return assignPercent;
    }

    public void setAssignPercent(Integer assignPercent) {
        this.assignPercent = assignPercent;
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

    public BigDecimal getPerformanceAmount() {
        return performanceAmount;
    }

    public void setPerformanceAmount(BigDecimal performanceAmount) {
        this.performanceAmount = performanceAmount;
    }

    public BigDecimal getAssignAmount() {
        return assignAmount;
    }

    public void setAssignAmount(BigDecimal assignAmount) {
        this.assignAmount = assignAmount;
    }

    public Long getAssignederId() {
        return assignederId;
    }

    public void setAssignederId(Long assignederId) {
        this.assignederId = assignederId;
    }

    public Boolean getSendFlag() {
        return sendFlag;
    }

    public void setSendFlag(Boolean sendFlag) {
        this.sendFlag = sendFlag;
    }

    public String getAssignederName() {
        return assignederName;
    }

    public void setAssignederName(String assignederName) {
        this.assignederName = assignederName == null ? null : assignederName.trim();
    }
}