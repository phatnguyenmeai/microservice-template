package com.bosch.common.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDto {
    @JsonProperty("order_id")
    private String id;
    @JsonProperty("order_user_id")
    private String userId;
    @JsonProperty("order_product_id")
    private String productId;
    @JsonProperty("order_address_id")
    private String addressId;
    @JsonProperty("order_created_at")
    private Date createdAt;
    @JsonProperty("order_updated_at")
    private Date updatedAt;
    @JsonProperty("order_is_delete")
    private boolean isDelete;
    private List<OrderDto> orders;
}
