package com.lietou.model;

public class CustomContact {
    private Long id;

    private Long customerId;

    private String importantDegree;

    private String name;

    private String uPosition;

    private String mobilePhone;

    private String email;

    private String phone;

    private String uQq;

    private String uWechat;

    private String sex;

    private String birthday;

    private String domicile;

    private String accountName;

    private String accountPassword;

    private String remark;

    private String dbOr;

    private Long createrId;

    private String createTime;

    private Long cId;

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

    public String getImportantDegree() {
        return importantDegree;
    }

    public void setImportantDegree(String importantDegree) {
        this.importantDegree = importantDegree == null ? null : importantDegree.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getuPosition() {
        return uPosition;
    }

    public void setuPosition(String uPosition) {
        this.uPosition = uPosition == null ? null : uPosition.trim();
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone == null ? null : mobilePhone.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getuQq() {
        return uQq;
    }

    public void setuQq(String uQq) {
        this.uQq = uQq == null ? null : uQq.trim();
    }

    public String getuWechat() {
        return uWechat;
    }

    public void setuWechat(String uWechat) {
        this.uWechat = uWechat == null ? null : uWechat.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday == null ? null : birthday.trim();
    }

    public String getDomicile() {
        return domicile;
    }

    public void setDomicile(String domicile) {
        this.domicile = domicile == null ? null : domicile.trim();
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName == null ? null : accountName.trim();
    }

    public String getAccountPassword() {
        return accountPassword;
    }

    public void setAccountPassword(String accountPassword) {
        this.accountPassword = accountPassword == null ? null : accountPassword.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getDbOr() {
        return dbOr;
    }

    public void setDbOr(String dbOr) {
        this.dbOr = dbOr == null ? null : dbOr.trim();
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

    public Long getcId() {
        return cId;
    }

    public void setcId(Long cId) {
        this.cId = cId;
    }
}