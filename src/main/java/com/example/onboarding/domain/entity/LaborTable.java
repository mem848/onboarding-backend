package com.example.onboarding.domain.entity;

import com.google.gson.annotations.SerializedName;
import jakarta.persistence.*;

import java.util.Date;
import java.util.Currency;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

//this class sets up a  table in h2 database
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="labor")
public class LaborTable { //this is just one labor/row of table
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @SerializedName(value = "LaborID", alternate = "laborId")
    @Column(name="Id")
    public Integer Id;

    @Column(name="created_at")
    @CreationTimestamp
    public Date time_stamp;

    @Column(name="length")
    public double length;

    @Column(name="width")
    public double width;

    @Column(name="price_per_sqft")
    private double pricePerSqft;

    @Column(name="labor_cost")
    public double cost;
}
