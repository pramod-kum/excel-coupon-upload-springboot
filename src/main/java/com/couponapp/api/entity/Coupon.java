package com.couponapp.api.entity;

import jakarta.persistence.*;
@Entity
@Table(name = "COUPON")
public class Coupon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String category;
    private String categoryValue;
    private String couponCode;
    private Integer validityInDays;
    private String discountType;
    private Double discountValue;
    private String discountOn;
    private String discountOnSelectedItems;
    private String issueDateFrom;
    private String issueDateTill;
    private String issuedOnSpentOf;
    private Double issuedOnMinimumSpent;
    private String applicableOnSpentOf;
    private String applicableOnGender;
    private String applicableOnCustomerCategory;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategoryValue() {
        return categoryValue;
    }

    public void setCategoryValue(String categoryValue) {
        this.categoryValue = categoryValue;
    }

    public String getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }

    public Integer getValidityInDays() {
        return validityInDays;
    }

    public void setValidityInDays(Integer validityInDays) {
        this.validityInDays = validityInDays;
    }

    public String getDiscountType() {
        return discountType;
    }

    public void setDiscountType(String discountType) {
        this.discountType = discountType;
    }

    public Double getDiscountValue() {
        return discountValue;
    }

    public void setDiscountValue(Double discountValue) {
        this.discountValue = discountValue;
    }

    public String getDiscountOn() {
        return discountOn;
    }

    public void setDiscountOn(String discountOn) {
        this.discountOn = discountOn;
    }

    public String getDiscountOnSelectedItems() {
        return discountOnSelectedItems;
    }

    public void setDiscountOnSelectedItems(String discountOnSelectedItems) {
        this.discountOnSelectedItems = discountOnSelectedItems;
    }

    public String getIssueDateFrom() {
        return issueDateFrom;
    }

    public void setIssueDateFrom(String issueDateFrom) {
        this.issueDateFrom = issueDateFrom;
    }

    public String getIssueDateTill() {
        return issueDateTill;
    }

    public void setIssueDateTill(String issueDateTill) {
        this.issueDateTill = issueDateTill;
    }

    public String getIssuedOnSpentOf() {
        return issuedOnSpentOf;
    }

    public void setIssuedOnSpentOf(String issuedOnSpentOf) {
        this.issuedOnSpentOf = issuedOnSpentOf;
    }

    public Double getIssuedOnMinimumSpent() {
        return issuedOnMinimumSpent;
    }

    public void setIssuedOnMinimumSpent(Double issuedOnMinimumSpent) {
        this.issuedOnMinimumSpent = issuedOnMinimumSpent;
    }

    public String getApplicableOnSpentOf() {
        return applicableOnSpentOf;
    }

    public void setApplicableOnSpentOf(String applicableOnSpentOf) {
        this.applicableOnSpentOf = applicableOnSpentOf;
    }

    public String getApplicableOnGender() {
        return applicableOnGender;
    }

    public void setApplicableOnGender(String applicableOnGender) {
        this.applicableOnGender = applicableOnGender;
    }

    public String getApplicableOnCustomerCategory() {
        return applicableOnCustomerCategory;
    }

    public void setApplicableOnCustomerCategory(String applicableOnCustomerCategory) {
        this.applicableOnCustomerCategory = applicableOnCustomerCategory;
    }
}