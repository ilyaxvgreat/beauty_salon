package com.project.beauty_salon.domain;

import java.util.Objects;


public class BeautySalon {
    private Long id;
    private String salonName;
    private String address;
    private Boolean hasGiftCertificate;
    private String genderType;
    private String workTime;
    private Integer workersQnt;

    public BeautySalon() {
    }

    public BeautySalon(Long id , String salonName,
                       String address,
                       Boolean hasGiftCertificate,
                       String genderType,
                       String workTime,
                       Integer workersQnt) {
        this.id = id;
        this.salonName = salonName;
        this.address = address;
        this.hasGiftCertificate = hasGiftCertificate;
        this.genderType = genderType;
        this.workTime = workTime;
        this.workersQnt = workersQnt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(final String address) {
        this.address = address;
    }

    public String getWorkTime() {
        return workTime;
    }

    public void setWorkTime(final String workTime) {
        this.workTime = workTime;
    }

    public String getSalonName() {
        return salonName;
    }

    public void setSalonName(final String salonName) {
        this.salonName = salonName;
    }

    public Boolean getHasGiftCertificate() {
        return hasGiftCertificate;
    }

    public void setHasGiftCertificate(final Boolean hasGiftCertificate) {
        this.hasGiftCertificate = hasGiftCertificate;
    }

    public String getGenderType() {
        return genderType;
    }

    public void setGenderType(String genderType) {
        this.genderType = genderType;
    }

    public Integer getWorkersQnt() {
        return workersQnt;
    }

    public void setWorkersQnt(Integer workersQnt) {
        this.workersQnt = workersQnt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BeautySalon that = (BeautySalon) o;
        return Objects.equals(salonName, that.salonName) &&
                Objects.equals(address, that.address) &&
                Objects.equals(hasGiftCertificate, that.hasGiftCertificate) &&
                Objects.equals(genderType, that.genderType) &&
                Objects.equals(workTime, that.workTime) &&
                Objects.equals(workersQnt, that.workersQnt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(salonName, address, hasGiftCertificate, genderType, workTime, workersQnt);
    }
}
