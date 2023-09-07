package com.example.onboarding.domain.entity;

import com.google.gson.annotations.SerializedName;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

public class MaterialTable {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @SerializedName(value = "MaterialID", alternate = "materialId")
    @Column(name="Id")
    public Integer Id;

    @Column(name="created_at")
    @CreationTimestamp
    public Date time_stamp;

    @Column(name="length")
    public double length;

    @Column(name="width")
    public double width;

    @Column(name="sqft_per_gallon")
    private double sqft_per_gallon;

    @Column(name="labor_cost")
    public double cost;
}
