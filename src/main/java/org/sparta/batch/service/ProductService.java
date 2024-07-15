package org.sparta.batch.service;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.sparta.batch.domain.entity.product.ProductEntity;
import org.sparta.batch.repository.ProductRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

}
