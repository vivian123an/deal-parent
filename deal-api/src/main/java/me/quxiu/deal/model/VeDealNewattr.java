package me.quxiu.deal.model;

import java.math.BigDecimal;

public class VeDealNewattr {
	
    private int id;

    private int dealId;

    private String dealSize;

    private BigDecimal dealPrice;

    private String barcode;

    private String materialCode;

    private BigDecimal dealPhonePrice;

    private BigDecimal dealOriginPrice;

    private BigDecimal costPrice;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDealId() {
        return dealId;
    }

    public void setDealId(int dealId) {
        this.dealId = dealId;
    }

    public String getDealSize() {
        return dealSize;
    }

    public void setDealSize(String dealSize) {
        this.dealSize = dealSize == null ? null : dealSize.trim();
    }

    public BigDecimal getDealPrice() {
        return dealPrice;
    }

    public void setDealPrice(BigDecimal dealPrice) {
        this.dealPrice = dealPrice;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode == null ? null : barcode.trim();
    }

    public String getMaterialCode() {
        return materialCode;
    }

    public void setMaterialCode(String materialCode) {
        this.materialCode = materialCode == null ? null : materialCode.trim();
    }

    public BigDecimal getDealPhonePrice() {
        return dealPhonePrice;
    }

    public void setDealPhonePrice(BigDecimal dealPhonePrice) {
        this.dealPhonePrice = dealPhonePrice;
    }

    public BigDecimal getDealOriginPrice() {
        return dealOriginPrice;
    }

    public void setDealOriginPrice(BigDecimal dealOriginPrice) {
        this.dealOriginPrice = dealOriginPrice;
    }

    public BigDecimal getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(BigDecimal costPrice) {
        this.costPrice = costPrice;
    }
}