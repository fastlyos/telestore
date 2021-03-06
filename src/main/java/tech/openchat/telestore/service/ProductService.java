package tech.openchat.telestore.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import tech.openchat.telestore.entity.Product;
import tech.openchat.telestore.repository.ProductRepository;

import javax.persistence.EntityNotFoundException;

/**
 * @author vgorin
 * file created on 2020-03-30 15:15
 */

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public Product getProduct(long id) {
        return productRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public Page<Product> listAllProducts(Pageable pageable) {
        return productRepository.findAll(pageable);
    }
}
