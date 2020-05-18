package com.project.beauty_salon.domain;

public class BeautySalon {
    private String salonName;
    private String address;
    private Boolean hasGiftCertificate;
    private GenderType genderType;
    private String workTime;
    private Integer workersQnt;

    public BeautySalon() {
    }

    public BeautySalon(final String salonName, final String address, final Boolean hasGiftCertificate, final
    GenderType genderType, final String workTime, final Integer workersQnt) {
        this.salonName = salonName;
        this.address = address;
        this.hasGiftCertificate = hasGiftCertificate;
        this.genderType = genderType;
        this.workTime = workTime;
        this.workersQnt = workersQnt;
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

    public GenderType getGenderType() {
        return genderType;
    }

    public void setGenderType(GenderType genderType) {
        this.genderType = genderType;
    }

    public Integer getWorkersQnt() {
        return workersQnt;
    }

    public void setWorkersQnt(Integer workersQnt) {
        this.workersQnt = workersQnt;
    }
}
