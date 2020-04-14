package com.lietou.vo;

import java.util.List;

import com.lietou.model.Dict;
import com.lietou.util.PageBaseModel;

public class DictVO extends PageBaseModel{
	private Long id;

    private String code;

    private String label;

    private String remark;

    private Long parentId;

    private Integer dIndex;

    private String classify;
    
    private List<Dict> childrenDictList;
    
    private Long[] ids;

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

	public List<Dict> getChildrenDictList() {
		return childrenDictList;
	}

	public void setChildrenDictList(List<Dict> childrenDictList) {
		this.childrenDictList = childrenDictList;
	}

	public Long[] getIds() {
		return ids;
	}

	public void setIds(Long[] ids) {
		this.ids = ids;
	}
}
