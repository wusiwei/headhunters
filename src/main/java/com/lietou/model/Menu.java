package com.lietou.model;

public class Menu {
    private Long id;

    private String path;

    private String vueName;

    private String menuName;

    private String component;

    private String meta;

    private String redirect;

    private String comonentType;

    private Boolean hidden;

    private Integer sortIndex;

    private Boolean hideChildrenFlag;

    private Long parentId;

    private Boolean menuFlag;

    private String showVueName;

    private String menuShowPath;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }

    public String getVueName() {
        return vueName;
    }

    public void setVueName(String vueName) {
        this.vueName = vueName == null ? null : vueName.trim();
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName == null ? null : menuName.trim();
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component == null ? null : component.trim();
    }

    public String getMeta() {
        return meta;
    }

    public void setMeta(String meta) {
        this.meta = meta == null ? null : meta.trim();
    }

    public String getRedirect() {
        return redirect;
    }

    public void setRedirect(String redirect) {
        this.redirect = redirect == null ? null : redirect.trim();
    }

    public String getComonentType() {
        return comonentType;
    }

    public void setComonentType(String comonentType) {
        this.comonentType = comonentType == null ? null : comonentType.trim();
    }

    public Boolean getHidden() {
        return hidden;
    }

    public void setHidden(Boolean hidden) {
        this.hidden = hidden;
    }

    public Integer getSortIndex() {
        return sortIndex;
    }

    public void setSortIndex(Integer sortIndex) {
        this.sortIndex = sortIndex;
    }

    public Boolean getHideChildrenFlag() {
        return hideChildrenFlag;
    }

    public void setHideChildrenFlag(Boolean hideChildrenFlag) {
        this.hideChildrenFlag = hideChildrenFlag;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Boolean getMenuFlag() {
        return menuFlag;
    }

    public void setMenuFlag(Boolean menuFlag) {
        this.menuFlag = menuFlag;
    }

    public String getShowVueName() {
        return showVueName;
    }

    public void setShowVueName(String showVueName) {
        this.showVueName = showVueName == null ? null : showVueName.trim();
    }

    public String getMenuShowPath() {
        return menuShowPath;
    }

    public void setMenuShowPath(String menuShowPath) {
        this.menuShowPath = menuShowPath == null ? null : menuShowPath.trim();
    }
}