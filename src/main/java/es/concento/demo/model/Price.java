package es.concento.demo.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString
@Table(name = "PRICES") 
public class Price implements Serializable {

    @GeneratedValue(strategy=GenerationType.AUTO)
    @Id
    private long id;

    @Column(name="BRAND_ID", nullable=false)
    private long brandId;

    @Column(name="START_DATE", nullable=false)
    private long startDate;

    @Column(name="END_DATE", nullable=false)
    private long endDate;

    @Column(name="PRODUCT_ID", nullable=false)
    private long productId;

    @Column(name="PRIORITY", nullable=false)
    private long priority;

    @Column(name="PRICE", nullable=false)
    private double price;

    @Column(name="CURR", nullable=false)
    private String curr;

}
