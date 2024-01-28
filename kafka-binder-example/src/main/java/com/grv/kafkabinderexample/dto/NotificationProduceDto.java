package com.grv.kafkabinderexample.dto;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NotificationProduceDto {

    String eventName;

    String eventValue;
}
