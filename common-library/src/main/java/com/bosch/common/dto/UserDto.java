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
public class UserDto {
    @JsonProperty("user_id")
    private String id;
    @JsonProperty("user_first_name")
    private String firstName;
    @JsonProperty("user_last_name")
    private String lastName;
    @JsonProperty("user_email")
    private String email;
    @JsonProperty("user_created_at")
    private Date createdAt;
    @JsonProperty("user_updated_at")
    private Date updatedAt;
    @JsonProperty("user_is_delete")
    private boolean isDelete;
    @JsonProperty("user_orders")
    private List<OrderDto> orders;
}
