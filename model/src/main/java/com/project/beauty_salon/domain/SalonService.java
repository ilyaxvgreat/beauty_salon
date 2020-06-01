package com.project.beauty_salon.domain;

import java.util.Objects;

public class SalonService {
    private Long id;
    private String serviceName;
    private Integer price;
    private Integer duration;

    public SalonService(Long id, String serviceName, Integer price, Integer duration) {
        this.id = id;
        this.serviceName = serviceName;
        this.price = price;
        this.duration = duration;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SalonService that = (SalonService) o;
        return serviceName.equals(that.serviceName) &&
                price.equals(that.price) &&
                duration.equals(that.duration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serviceName, price, duration);
    }
}
