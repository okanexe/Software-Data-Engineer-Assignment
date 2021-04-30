package com.recommendation.restapi.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "productviews")
public class ProductView implements Comparable<ProductView>{

    @Column(name = "event")
    private String event;

    @Id
    @Column(name = "messageid")
    private String messageId;

    @Column(name = "userid")
    private String userId;
/*
    @Type(type = "jsonb")
    @Column(name = "properties", columnDefinition = "jsonb")
    private List<ProductId> properties;

    @Type(type = "jsonb")
    @Column(name = "context", columnDefinition = "jsonb")
    private List<Source> context;
*/

    @Column(name = "productid")
    private String productid;

    @Column(name = "source")
    private String source;


    @Column(name = "timestamp")
    private Date timestamp;

    @Override
    public int compareTo(ProductView view) {
    if (getTimestamp() == null || view.getTimestamp() == null) {
        return 0;
    }
    return getTimestamp().compareTo(view.getTimestamp());
    }

}
/*
@Data
@NoArgsConstructor
@AllArgsConstructor
class ProductId implements Serializable{
    private String productId;
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class Source implements Serializable{
    private String source;
}
*/