package me.quxiu.deal.model;

import java.math.BigDecimal;
import java.util.Date;

public class VeDeal {
	
    private Integer id;

    private String goodsSn;

    private String barcode;

    private String subName;

    private Integer cateId;

    private String icon;

    private Boolean buyStatus;

    private Date timeBegin;

    private Date timeEnd;

    private Integer minBought;

    private Integer maxBought;

    private Integer userMinBought;

    private Integer userMaxBought;

    private Double originPrice;

    private Double currentPrice;

    private Boolean isCoupon;

    private Boolean isDelivery;

    private Boolean isEffect;

    private Boolean isDelete;

    private Integer userCount;

    private Integer buyCount;

    private Boolean allowPromote;

    private Double returnMoney;

    private Integer returnScore;

    private Integer returnPoint;

    private String briefIndex;

    private Integer sort;

    private Integer dealGoodsType;

    private Integer successTime;

    private Double weight;

    private Integer weightId;

    private Boolean isReferral;

    private Boolean buyType;

    private Double discount;

    private Boolean freeDelivery;

    private Boolean definePayment;

    private Boolean isHot;

    private Boolean isNew;

    private Boolean isBest;

    private Boolean isLottery;

    private String uname;

    private Boolean forbidSms;

    private Boolean cartType;

    private Float avgPoint;

    private Integer createTime;

    private Integer updateTime;

    private Integer onlineTime;

    private Integer brandId;

    private Integer commentCount;

    private Integer collectCount;

    private Boolean levelLimit;

    private Boolean isEnsure;

    private Boolean isInsurance;

    private Boolean isReturns;

    private Boolean isPay;

    private Integer isIndexRecommend;

    private Boolean isIndexNew;

    private Boolean isIndexCrazy;

    private String cateId2;

    private String brandId2;

    private Integer divisionId;

    private Integer supplierId;

    private Integer adminDelId;

    private BigDecimal phonePrice;

    private Integer saleNum;

    private Boolean isBiaopin;

    private Integer dealBrand;

    private String goodParams;

    private String sellingPoint;

    private String matchIds;

    private Integer mobileSort;

    private Integer submitStatus;

    private Date submitTime;

    private Integer status;

    private Integer auditStatus;

    private String auditMsg;

    private Integer auditTimeBak;

    private Date auditTime;

    private Integer auditAdminId;

    private Boolean isSellerPost;

    private Date syncWmsDate;

    private Date syncEbsDate;

    private Date syncFlagDate;

    private Integer syncWmsCount;

    private Integer syncEbsCount;

    private Integer isSale;

    private Integer skuAuditStatus;

    private Integer skuAuditAdminId;
    
    private Integer copyFromDealId;

    private Date skuAuditTime;
    
    private String name;

    private String description;

    private String mDescription;

    private String brief;

    private String seoTitle;

    private String seoKeyword;

    private String seoDescription;

    private String nameMatch;

    private String nameMatchRow;

    private String cateMatch;

    private String cateMatchRow;

    private String tagMatch;

    private String tagMatchRow;

    private String searchTags;

    private String skuAuditMsg;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGoodsSn() {
        return goodsSn;
    }

    public void setGoodsSn(String goodsSn) {
        this.goodsSn = goodsSn == null ? null : goodsSn.trim();
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode == null ? null : barcode.trim();
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

    public Boolean getBuyStatus() {
        return buyStatus;
    }

    public void setBuyStatus(Boolean buyStatus) {
        this.buyStatus = buyStatus;
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

    public Integer getMinBought() {
        return minBought;
    }

    public void setMinBought(Integer minBought) {
        this.minBought = minBought;
    }

    public Integer getMaxBought() {
        return maxBought;
    }

    public void setMaxBought(Integer maxBought) {
        this.maxBought = maxBought;
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

    public Boolean getIsCoupon() {
        return isCoupon;
    }

    public void setIsCoupon(Boolean isCoupon) {
        this.isCoupon = isCoupon;
    }

    public Boolean getIsDelivery() {
        return isDelivery;
    }

    public void setIsDelivery(Boolean isDelivery) {
        this.isDelivery = isDelivery;
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

    public Integer getUserCount() {
        return userCount;
    }

    public void setUserCount(Integer userCount) {
        this.userCount = userCount;
    }

    public Integer getBuyCount() {
        return buyCount;
    }

    public void setBuyCount(Integer buyCount) {
        this.buyCount = buyCount;
    }

    public Boolean getAllowPromote() {
        return allowPromote;
    }

    public void setAllowPromote(Boolean allowPromote) {
        this.allowPromote = allowPromote;
    }

    public Double getReturnMoney() {
        return returnMoney;
    }

    public void setReturnMoney(Double returnMoney) {
        this.returnMoney = returnMoney;
    }

    public Integer getReturnScore() {
        return returnScore;
    }

    public void setReturnScore(Integer returnScore) {
        this.returnScore = returnScore;
    }

    public Integer getReturnPoint() {
        return returnPoint;
    }

    public void setReturnPoint(Integer returnPoint) {
        this.returnPoint = returnPoint;
    }

    public String getBriefIndex() {
        return briefIndex;
    }

    public void setBriefIndex(String briefIndex) {
        this.briefIndex = briefIndex == null ? null : briefIndex.trim();
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getDealGoodsType() {
        return dealGoodsType;
    }

    public void setDealGoodsType(Integer dealGoodsType) {
        this.dealGoodsType = dealGoodsType;
    }

    public Integer getSuccessTime() {
        return successTime;
    }

    public void setSuccessTime(Integer successTime) {
        this.successTime = successTime;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Integer getWeightId() {
        return weightId;
    }

    public void setWeightId(Integer weightId) {
        this.weightId = weightId;
    }

    public Boolean getIsReferral() {
        return isReferral;
    }

    public void setIsReferral(Boolean isReferral) {
        this.isReferral = isReferral;
    }

    public Boolean getBuyType() {
        return buyType;
    }

    public void setBuyType(Boolean buyType) {
        this.buyType = buyType;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Boolean getFreeDelivery() {
        return freeDelivery;
    }

    public void setFreeDelivery(Boolean freeDelivery) {
        this.freeDelivery = freeDelivery;
    }

    public Boolean getDefinePayment() {
        return definePayment;
    }

    public void setDefinePayment(Boolean definePayment) {
        this.definePayment = definePayment;
    }

    public Boolean getIsHot() {
        return isHot;
    }

    public void setIsHot(Boolean isHot) {
        this.isHot = isHot;
    }

    public Boolean getIsNew() {
        return isNew;
    }

    public void setIsNew(Boolean isNew) {
        this.isNew = isNew;
    }

    public Boolean getIsBest() {
        return isBest;
    }

    public void setIsBest(Boolean isBest) {
        this.isBest = isBest;
    }

    public Boolean getIsLottery() {
        return isLottery;
    }

    public void setIsLottery(Boolean isLottery) {
        this.isLottery = isLottery;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname == null ? null : uname.trim();
    }

    public Boolean getForbidSms() {
        return forbidSms;
    }

    public void setForbidSms(Boolean forbidSms) {
        this.forbidSms = forbidSms;
    }

    public Boolean getCartType() {
        return cartType;
    }

    public void setCartType(Boolean cartType) {
        this.cartType = cartType;
    }

    public Float getAvgPoint() {
        return avgPoint;
    }

    public void setAvgPoint(Float avgPoint) {
        this.avgPoint = avgPoint;
    }

    public Integer getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }

    public Integer getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Integer updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getOnlineTime() {
        return onlineTime;
    }

    public void setOnlineTime(Integer onlineTime) {
        this.onlineTime = onlineTime;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    public Integer getCollectCount() {
        return collectCount;
    }

    public void setCollectCount(Integer collectCount) {
        this.collectCount = collectCount;
    }

    public Boolean getLevelLimit() {
        return levelLimit;
    }

    public void setLevelLimit(Boolean levelLimit) {
        this.levelLimit = levelLimit;
    }

    public Boolean getIsEnsure() {
        return isEnsure;
    }

    public void setIsEnsure(Boolean isEnsure) {
        this.isEnsure = isEnsure;
    }

    public Boolean getIsInsurance() {
        return isInsurance;
    }

    public void setIsInsurance(Boolean isInsurance) {
        this.isInsurance = isInsurance;
    }

    public Boolean getIsReturns() {
        return isReturns;
    }

    public void setIsReturns(Boolean isReturns) {
        this.isReturns = isReturns;
    }

    public Boolean getIsPay() {
        return isPay;
    }

    public void setIsPay(Boolean isPay) {
        this.isPay = isPay;
    }

    public Integer getIsIndexRecommend() {
        return isIndexRecommend;
    }

    public void setIsIndexRecommend(Integer isIndexRecommend) {
        this.isIndexRecommend = isIndexRecommend;
    }

    public Boolean getIsIndexNew() {
        return isIndexNew;
    }

    public void setIsIndexNew(Boolean isIndexNew) {
        this.isIndexNew = isIndexNew;
    }

    public Boolean getIsIndexCrazy() {
        return isIndexCrazy;
    }

    public void setIsIndexCrazy(Boolean isIndexCrazy) {
        this.isIndexCrazy = isIndexCrazy;
    }

    public String getCateId2() {
        return cateId2;
    }

    public void setCateId2(String cateId2) {
        this.cateId2 = cateId2 == null ? null : cateId2.trim();
    }

    public String getBrandId2() {
        return brandId2;
    }

    public void setBrandId2(String brandId2) {
        this.brandId2 = brandId2 == null ? null : brandId2.trim();
    }

    public Integer getDivisionId() {
        return divisionId;
    }

    public void setDivisionId(Integer divisionId) {
        this.divisionId = divisionId;
    }

    public Integer getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Integer supplierId) {
        this.supplierId = supplierId;
    }

    public Integer getAdminDelId() {
        return adminDelId;
    }

    public void setAdminDelId(Integer adminDelId) {
        this.adminDelId = adminDelId;
    }

    public BigDecimal getPhonePrice() {
        return phonePrice;
    }

    public void setPhonePrice(BigDecimal phonePrice) {
        this.phonePrice = phonePrice;
    }

    public Integer getSaleNum() {
        return saleNum;
    }

    public void setSaleNum(Integer saleNum) {
        this.saleNum = saleNum;
    }

    public Boolean getIsBiaopin() {
        return isBiaopin;
    }

    public void setIsBiaopin(Boolean isBiaopin) {
        this.isBiaopin = isBiaopin;
    }

    public Integer getDealBrand() {
        return dealBrand;
    }

    public void setDealBrand(Integer dealBrand) {
        this.dealBrand = dealBrand;
    }

    public String getGoodParams() {
        return goodParams;
    }

    public void setGoodParams(String goodParams) {
        this.goodParams = goodParams == null ? null : goodParams.trim();
    }

    public String getSellingPoint() {
        return sellingPoint;
    }

    public void setSellingPoint(String sellingPoint) {
        this.sellingPoint = sellingPoint == null ? null : sellingPoint.trim();
    }

    public String getMatchIds() {
        return matchIds;
    }

    public void setMatchIds(String matchIds) {
        this.matchIds = matchIds == null ? null : matchIds.trim();
    }

    public Integer getMobileSort() {
        return mobileSort;
    }

    public void setMobileSort(Integer mobileSort) {
        this.mobileSort = mobileSort;
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

    public Integer getAuditTimeBak() {
        return auditTimeBak;
    }

    public void setAuditTimeBak(Integer auditTimeBak) {
        this.auditTimeBak = auditTimeBak;
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

    public Boolean getIsSellerPost() {
        return isSellerPost;
    }

    public void setIsSellerPost(Boolean isSellerPost) {
        this.isSellerPost = isSellerPost;
    }

    public Date getSyncWmsDate() {
        return syncWmsDate;
    }

    public void setSyncWmsDate(Date syncWmsDate) {
        this.syncWmsDate = syncWmsDate;
    }

    public Date getSyncEbsDate() {
        return syncEbsDate;
    }

    public void setSyncEbsDate(Date syncEbsDate) {
        this.syncEbsDate = syncEbsDate;
    }

    public Date getSyncFlagDate() {
        return syncFlagDate;
    }

    public void setSyncFlagDate(Date syncFlagDate) {
        this.syncFlagDate = syncFlagDate;
    }

    public Integer getSyncWmsCount() {
        return syncWmsCount;
    }

    public void setSyncWmsCount(Integer syncWmsCount) {
        this.syncWmsCount = syncWmsCount;
    }

    public Integer getSyncEbsCount() {
        return syncEbsCount;
    }

    public void setSyncEbsCount(Integer syncEbsCount) {
        this.syncEbsCount = syncEbsCount;
    }

    public Integer getIsSale() {
        return isSale;
    }

    public void setIsSale(Integer isSale) {
        this.isSale = isSale;
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
    
	public Integer getCopyFromDealId() {
		return copyFromDealId;
	}

	public void setCopyFromDealId(Integer copyFromDealId) {
		this.copyFromDealId = copyFromDealId;
	}

	public Date getSkuAuditTime() {
        return skuAuditTime;
    }

    public void setSkuAuditTime(Date skuAuditTime) {
        this.skuAuditTime = skuAuditTime;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
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

    public String getBrief() {
        return brief;
    }

    public void setBrief(String brief) {
        this.brief = brief == null ? null : brief.trim();
    }

    public String getSeoTitle() {
        return seoTitle;
    }

    public void setSeoTitle(String seoTitle) {
        this.seoTitle = seoTitle == null ? null : seoTitle.trim();
    }

    public String getSeoKeyword() {
        return seoKeyword;
    }

    public void setSeoKeyword(String seoKeyword) {
        this.seoKeyword = seoKeyword == null ? null : seoKeyword.trim();
    }

    public String getSeoDescription() {
        return seoDescription;
    }

    public void setSeoDescription(String seoDescription) {
        this.seoDescription = seoDescription == null ? null : seoDescription.trim();
    }

    public String getNameMatch() {
        return nameMatch;
    }

    public void setNameMatch(String nameMatch) {
        this.nameMatch = nameMatch == null ? null : nameMatch.trim();
    }

    public String getNameMatchRow() {
        return nameMatchRow;
    }

    public void setNameMatchRow(String nameMatchRow) {
        this.nameMatchRow = nameMatchRow == null ? null : nameMatchRow.trim();
    }

    public String getCateMatch() {
        return cateMatch;
    }

    public void setCateMatch(String cateMatch) {
        this.cateMatch = cateMatch == null ? null : cateMatch.trim();
    }

    public String getCateMatchRow() {
        return cateMatchRow;
    }

    public void setCateMatchRow(String cateMatchRow) {
        this.cateMatchRow = cateMatchRow == null ? null : cateMatchRow.trim();
    }

    public String getTagMatch() {
        return tagMatch;
    }

    public void setTagMatch(String tagMatch) {
        this.tagMatch = tagMatch == null ? null : tagMatch.trim();
    }

    public String getTagMatchRow() {
        return tagMatchRow;
    }

    public void setTagMatchRow(String tagMatchRow) {
        this.tagMatchRow = tagMatchRow == null ? null : tagMatchRow.trim();
    }

    public String getSearchTags() {
        return searchTags;
    }

    public void setSearchTags(String searchTags) {
        this.searchTags = searchTags == null ? null : searchTags.trim();
    }

    public String getSkuAuditMsg() {
        return skuAuditMsg;
    }

    public void setSkuAuditMsg(String skuAuditMsg) {
        this.skuAuditMsg = skuAuditMsg == null ? null : skuAuditMsg.trim();
    }
}