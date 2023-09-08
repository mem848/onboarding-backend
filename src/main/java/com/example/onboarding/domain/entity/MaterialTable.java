package com.example.onboarding.domain.entity;

import com.google.gson.annotations.SerializedName;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Material")
public class MaterialTable {
    @Id
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
    private double sqftPerGallon;

    @Column(name="gallons-required")
    public double gallons_required;
}
