package com.janloong.jingdg.domain;


import java.io.Serializable;

/**
 * @author Janloong
 * @create 2017-07-18 上午9:41
 **/
public class SystemCategory implements Serializable{
    private static final long serialVersionUID =1l;

    private String cid;
    private Long fid;
    private Long id;
    private Integer lev;
    private String name;
    private Integer order;
    private String featuresAll;

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public Long getFid() {
        return fid;
    }

    public void setFid(Long fid) {
        this.fid = fid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getLev() {
        return lev;
    }

    public void setLev(Integer lev) {
        this.lev = lev;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public String getFeaturesAll() {
        return featuresAll;
    }

    public void setFeaturesAll(String featuresAll) {
        this.featuresAll = featuresAll;
    }


    @Override
    public String toString() {
        return "SystemCategory{" +
                "cid='" + cid + '\'' +
                ", fid=" + fid +
                ", id=" + id +
                ", lev=" + lev +
                ", name='" + name + '\'' +
                ", order=" + order +
                ", featuresAll='" + featuresAll + '\'' +
                '}';
    }
}
