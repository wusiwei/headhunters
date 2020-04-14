package com.lietou.model;

public class CustomContactRecord {
    private Long id;

    private Long customContactId;

    private String contactRemark;

    private String nextTime;

    private Long createrId;

    private String createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomContactId() {
        return customContactId;
    }

    public void setCustomContactId(Long customContactId) {
        this.customContactId = customContactId;
    }

    public String getContactRemark() {
        return contactRemark;
    }

    public void setContactRemark(String contactRemark) {
        this.contactRemark = contactRemark == null ? null : contactRemark.trim();
    }

    public String getNextTime() {
        return nextTime;
    }

    public void setNextTime(String nextTime) {
        this.nextTime = nextTime == null ? null : nextTime.trim();
    }

    public Long getCreaterId() {
        return createrId;
    }

    public void setCreaterId(Long createrId) {
        this.createrId = createrId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }
}