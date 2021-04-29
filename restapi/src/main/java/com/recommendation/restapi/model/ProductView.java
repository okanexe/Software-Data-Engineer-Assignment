package com.recommendation.restapi.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "productviews")
public class ProductView {

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

    @Column(name = "properties")
    private String properties;

    @Column(name = "context")
    private String context;


    @Column(name = "timestamp")
    private String timestamp;

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