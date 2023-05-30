package com.bosch.order.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "order_collection")
public class OrderEntity {
    private String id;
    private String userId;
    private String productId;
    private String addressId;
    private Date createdAt;
    private Date updatedAt;
    private boolean isDelete;

}
