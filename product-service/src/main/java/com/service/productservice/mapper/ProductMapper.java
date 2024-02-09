package com.service.productservice.mapper;

import com.service.productservice.dto.request.ProductRequest;
import com.service.productservice.dto.response.ProductResponse;
import com.service.productservice.model.Product;
import org.mapstruct.Mapper;

import static org.mapstruct.ReportingPolicy.IGNORE;

@Mapper(componentModel = "spring", unmappedTargetPolicy = IGNORE)
public interface ProductMapper {

    Product productRequestToProduct(ProductRequest productRequest);

    ProductResponse productToProductResponse(Product product);
}
