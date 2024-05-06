package es.concento.demo.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@Table(name = "prices") 
public class Price implements Serializable {

    @Id
    private long id;

    @Column(name="brand_id", nullable=false)
    private long brandId;

    @Column(name="start_date", nullable=false)
    private long startDate;

    @Column(name="end_date", nullable=false)
    private long endDate;

    @Column(name="price_list", nullable=false)
    private long priceList;

    @Column(name="product_id", nullable=false)
    private long productId;

    @Column(name="priority", nullable=false)
    private long priority;

    @Column(name="price", nullable=false)
    private double price;

    @Column(name="currency", nullable=false)
    private String curr;

}
