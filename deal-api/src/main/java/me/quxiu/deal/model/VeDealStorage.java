package me.quxiu.deal.model;

public class VeDealStorage {
    private Integer id;

    private Integer dealId;

    private Short storageId;

    private Integer attrId;

    private Integer num;

    private Integer cartNum;

    private Integer orderNum;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getDealId() {
        return dealId;
    }

    public void setDealId(Integer dealId) {
        this.dealId = dealId;
    }

    public Short getStorageId() {
        return storageId;
    }

    public void setStorageId(Short storageId) {
        this.storageId = storageId;
    }

    public Integer getAttrId() {
        return attrId;
    }

    public void setAttrId(Integer attrId) {
        this.attrId = attrId;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getCartNum() {
        return cartNum;
    }

    public void setCartNum(Integer cartNum) {
        this.cartNum = cartNum;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }
}