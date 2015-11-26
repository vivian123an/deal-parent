package me.quxiu.deal.model;

public class VeDealColor {
    private Integer id;

    private Integer mid;

    private String name;

    private String color;

    private Integer sort;

    private String relid;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color == null ? null : color.trim();
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getRelid() {
        return relid;
    }

    public void setRelid(String relid) {
        this.relid = relid == null ? null : relid.trim();
    }
}