package me.quxiu.deal.model;

import java.math.BigDecimal;
import java.util.Date;

public class VeDealSnapshot {
    private Integer id;

    private Integer goodsId;

    private String subName;

    private Integer cateId;

    private String icon;

    private String briefIndex;

    private Date timeBegin;

    private Date timeEnd;

    private Integer userMinBought;

    private Integer userMaxBought;

    private Double originPrice;

    private Double currentPrice;

    private BigDecimal phonePrice;

    private Integer dealBrand;

    private Boolean isEffect;

    private Boolean isDelete;

    private Integer updateTime;

    private Integer allowPromote;

    private Integer brandId;

    private Short divisionId;

    private Integer supplierId;

    private Integer isSellerPost;

    private Integer submitStatus;

    private Date submitTime;

    private Integer status;

    private Integer auditStatus;

    private String auditMsg;

    private Date auditTime;

    private Integer auditAdminId;

    private Integer skuAuditStatus;

    private Integer skuAuditAdminId;

    private Date skuAuditTime;
    
    private String name;

    private String brief;

    private String description;

    private String mDescription;

    private String skuAuditMsg;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief == null ? null : brief.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getmDescription() {
        return mDescription;
    }

    public void setmDescription(String mDescription) {
        this.mDescription = mDescription == null ? null : mDescription.trim();
    }

    public String getSkuAuditMsg() {
        return skuAuditMsg;
    }

    public void setSkuAuditMsg(String skuAuditMsg) {
        this.skuAuditMsg = skuAuditMsg == null ? null : skuAuditMsg.trim();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName == null ? null : subName.trim();
    }

    public Integer getCateId() {
        return cateId;
    }

    public void setCateId(Integer cateId) {
        this.cateId = cateId;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon == null ? null : icon.trim();
    }

    public String getBriefIndex() {
        return briefIndex;
    }

    public void setBriefIndex(String briefIndex) {
        this.briefIndex = briefIndex == null ? null : briefIndex.trim();
    }

    public Date getTimeBegin() {
        return timeBegin;
    }

    public void setTimeBegin(Date timeBegin) {
        this.timeBegin = timeBegin;
    }

    public Date getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(Date timeEnd) {
        this.timeEnd = timeEnd;
    }

    public Integer getUserMinBought() {
        return userMinBought;
    }

    public void setUserMinBought(Integer userMinBought) {
        this.userMinBought = userMinBought;
    }

    public Integer getUserMaxBought() {
        return userMaxBought;
    }

    public void setUserMaxBought(Integer userMaxBought) {
        this.userMaxBought = userMaxBought;
    }

    public Double getOriginPrice() {
        return originPrice;
    }

    public void setOriginPrice(Double originPrice) {
        this.originPrice = originPrice;
    }

    public Double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(Double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public BigDecimal getPhonePrice() {
        return phonePrice;
    }

    public void setPhonePrice(BigDecimal phonePrice) {
        this.phonePrice = phonePrice;
    }

    public Integer getDealBrand() {
        return dealBrand;
    }

    public void setDealBrand(Integer dealBrand) {
        this.dealBrand = dealBrand;
    }

    public Boolean getIsEffect() {
        return isEffect;
    }

    public void setIsEffect(Boolean isEffect) {
        this.isEffect = isEffect;
    }

    public Boolean getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Boolean isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Integer updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getAllowPromote() {
        return allowPromote;
    }

    public void setAllowPromote(Integer allowPromote) {
        this.allowPromote = allowPromote;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public Short getDivisionId() {
        return divisionId;
    }

    public void setDivisionId(Short divisionId) {
        this.divisionId = divisionId;
    }

    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    public Integer getIsSellerPost() {
        return isSellerPost;
    }

    public void setIsSellerPost(Integer isSellerPost) {
        this.isSellerPost = isSellerPost;
    }

    public Integer getSubmitStatus() {
        return submitStatus;
    }

    public void setSubmitStatus(Integer submitStatus) {
        this.submitStatus = submitStatus;
    }

    public Date getSubmitTime() {
        return submitTime;
    }

    public void setSubmitTime(Date submitTime) {
        this.submitTime = submitTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getAuditStatus() {
        return auditStatus;
    }

    public void setAuditStatus(Integer auditStatus) {
        this.auditStatus = auditStatus;
    }

    public String getAuditMsg() {
        return auditMsg;
    }

    public void setAuditMsg(String auditMsg) {
        this.auditMsg = auditMsg == null ? null : auditMsg.trim();
    }

    public Date getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }

    public Integer getAuditAdminId() {
        return auditAdminId;
    }

    public void setAuditAdminId(Integer auditAdminId) {
        this.auditAdminId = auditAdminId;
    }

    public Integer getSkuAuditStatus() {
        return skuAuditStatus;
    }

    public void setSkuAuditStatus(Integer skuAuditStatus) {
        this.skuAuditStatus = skuAuditStatus;
    }

    public Integer getSkuAuditAdminId() {
        return skuAuditAdminId;
    }

    public void setSkuAuditAdminId(Integer skuAuditAdminId) {
        this.skuAuditAdminId = skuAuditAdminId;
    }

    public Date getSkuAuditTime() {
        return skuAuditTime;
    }

    public void setSkuAuditTime(Date skuAuditTime) {
        this.skuAuditTime = skuAuditTime;
    }
}