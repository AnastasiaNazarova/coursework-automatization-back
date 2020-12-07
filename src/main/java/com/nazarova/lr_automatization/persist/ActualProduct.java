package com.nazarova.lr_automatization.persist;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Data
@Entity
@Table(name = "actual_products_view")
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor
public class ActualProduct {

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName_product() {
        return name_product;
    }

    public void setName_product(String name_product) {
        this.name_product = name_product;
    }

    public float getPrice_one() {
        return price_one;
    }

    public void setPrice_one(float price_one) {
        this.price_one = price_one;
    }

    public float getRevenue() {
        return revenue;
    }

    public void setRevenue(float revenue) {
        this.revenue = revenue;
    }

    public float getProfit() {
        return profit;
    }

    public void setProfit(float profit) {
        this.profit = profit;
    }

    @Id
    private Long id;

    @Column()
    private String name_product;

    @Column()
    private float price_one;

    @Column()
    private float revenue;

    @Column()
    private float profit;

}
