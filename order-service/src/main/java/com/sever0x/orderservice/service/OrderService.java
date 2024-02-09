package com.sever0x.orderservice.service;

import com.sever0x.orderservice.dto.request.OrderRequest;
import com.sever0x.orderservice.mapper.OrderMapper;
import com.sever0x.orderservice.model.Order;
import com.sever0x.orderservice.model.OrderLineItems;
import com.sever0x.orderservice.repo.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {

    private final OrderMapper orderMapper;

    private final OrderRepository orderRepository;

    public void placeOrder(OrderRequest orderRequest) {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());

        List<OrderLineItems> orderLineItems = orderRequest.getOrderLineItemsDtoList()
                .stream()
                .map(orderMapper::orderLineItemsDtoToOrderLineItemsEntity)
                .toList();

        order.setOrderLineItemsList(orderLineItems);

        orderRepository.save(order);
    }
}
