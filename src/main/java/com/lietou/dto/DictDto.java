package com.lietou.dto;

import java.util.List;

public class DictDto {
	private Long id;

    private String code;

    private String label;

    private String remark;

    private Long parentId;

    private Integer dIndex;

    private String classify;
    
    private List<DictDto> children;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

	public Integer getdIndex() {
		return dIndex;
	}

	public void setdIndex(Integer dIndex) {
		this.dIndex = dIndex;
	}

	public String getClassify() {
		return classify;
	}

	public void setClassify(String classify) {
		this.classify = classify;
	}

	public List<DictDto> getChildren() {
		return children;
	}

	public void setChildren(List<DictDto> children) {
		this.children = children;
	}
    
}
