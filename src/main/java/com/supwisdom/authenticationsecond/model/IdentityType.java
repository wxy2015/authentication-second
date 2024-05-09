package com.supwisdom.authenticationsecond.model;




public class IdentityType{

  private static final long serialVersionUID = -2071071188572763529L;
  
  private String code;

  private String name;
  
  private IdentityType parentIdentityType;
  
  private Boolean enable = true;
  
  private Long sort;

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

  public IdentityType getParentIdentityType() {
    return parentIdentityType;
  }

  public void setParentIdentityType(IdentityType parentIdentityType) {
    this.parentIdentityType = parentIdentityType;
  }

  public Boolean getEnable() {
    return enable;
  }

  public void setEnable(Boolean enable) {
    this.enable = enable;
  }

  public Long getSort() {
    return sort;
  }

  public void setSort(Long sort) {
    this.sort = sort;
  }

  @Override
  public String toString() {
    return "IdentityType{" +
            "code='" + code + '\'' +
            ", name='" + name + '\'' +
            ", parentIdentityType=" + parentIdentityType +
            ", enable=" + enable +
            ", sort=" + sort +
            '}';
  }
}
