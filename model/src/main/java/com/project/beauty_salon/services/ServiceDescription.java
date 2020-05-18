package com.project.beauty_salon.services;

public class ServiceDescription {
    private String serviceName;
    private Integer price;
    private Integer duration;

    public ServiceDescription(String serviceName, Integer price, Integer duration) {
        this.serviceName = serviceName;
        this.price = price;
        this.duration = duration;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }
}
