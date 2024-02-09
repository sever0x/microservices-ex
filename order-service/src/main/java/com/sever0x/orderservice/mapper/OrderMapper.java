package com.sever0x.orderservice.mapper;

import com.sever0x.orderservice.dto.OrderLineItemsDto;
import com.sever0x.orderservice.model.OrderLineItems;
import org.mapstruct.Mapper;

import static org.mapstruct.ReportingPolicy.IGNORE;

@Mapper(componentModel = "spring", unmappedTargetPolicy = IGNORE)
public interface OrderMapper {

    OrderLineItems orderLineItemsDtoToOrderLineItemsEntity(OrderLineItemsDto orderLineItemsDto);
}
