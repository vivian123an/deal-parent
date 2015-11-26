package me.quxiu.deal.model;

import java.math.BigDecimal;

public class VeGoodsSku {
    private Integer id;

    private Integer goodsId;

    private String color;

    private Integer colorId;

    private String size;

    private Integer sizeId;

    private Integer num;

    private Integer saleNum;

    private String materialCode;

    private Integer attrId;

    private BigDecimal dealPrice;

    private BigDecimal dealPhonePrice;

    private BigDecimal dealOriginPrice;

    private String barcode;

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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color == null ? null : color.trim();
    }

    public Integer getColorId() {
        return colorId;
    }

    public void setColorId(Integer colorId) {
        this.colorId = colorId;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size == null ? null : size.trim();
    }

    public Integer getSizeId() {
        return sizeId;
    }

    public void setSizeId(Integer sizeId) {
        this.sizeId = sizeId;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getSaleNum() {
        return saleNum;
    }

    public void setSaleNum(Integer saleNum) {
        this.saleNum = saleNum;
    }

    public String getMaterialCode() {
        return materialCode;
    }

    public void setMaterialCode(String materialCode) {
        this.materialCode = materialCode == null ? null : materialCode.trim();
    }

    public Integer getAttrId() {
        return attrId;
    }

    public void setAttrId(Integer attrId) {
        this.attrId = attrId;
    }

    public BigDecimal getDealPrice() {
        return dealPrice;
    }

    public void setDealPrice(BigDecimal dealPrice) {
        this.dealPrice = dealPrice;
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

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode == null ? null : barcode.trim();
    }
}