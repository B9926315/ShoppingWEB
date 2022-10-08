package com.BYX.pojo;

/**
 * Author   Bai YanXu
 * Date    2022-10-05 - 15:10
 */
public class DataDisplay {
    private Integer status;
    private String name;
    private Integer priceMin;
    private Integer priceMax;
    private Integer numberMin;
    private Integer numberMax;

    @Override
    public String toString() {
        return "DataDisplay{" +
                "status=" + status +
                ", name='" + name + '\'' +
                ", priceMin=" + priceMin +
                ", priceMax=" + priceMax +
                ", numberMin=" + numberMin +
                ", numberMax=" + numberMax +
                '}';
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPriceMin() {
        return priceMin;
    }

    public void setPriceMin(Integer priceMin) {
        this.priceMin = priceMin;
    }

    public Integer getPriceMax() {
        return priceMax;
    }

    public void setPriceMax(Integer priceMax) {
        this.priceMax = priceMax;
    }

    public Integer getNumberMin() {
        return numberMin;
    }

    public void setNumberMin(Integer numberMin) {
        this.numberMin = numberMin;
    }

    public Integer getNumberMax() {
        return numberMax;
    }

    public void setNumberMax(Integer numberMax) {
        this.numberMax = numberMax;
    }
}
