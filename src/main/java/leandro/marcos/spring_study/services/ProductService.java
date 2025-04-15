package leandro.marcos.spring_study.services;

import leandro.marcos.spring_study.dtos.ProductDTO;
import leandro.marcos.spring_study.entities.Category;
import leandro.marcos.spring_study.entities.Product;
import leandro.marcos.spring_study.repository.ProductRepository;
import leandro.marcos.spring_study.services.exceptions.ResourceNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.print.Pageable;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Transactional(readOnly = true)
    public Page<ProductDTO> findAll(Pageable pageable){
        Page<Product> list = productRepository.findAll(pageable);

        return list.map(product -> new ProductDTO(product));
    }

    @Transactional(readOnly = true)
    public ProductDTO findById(Long id){
        Optional<Product> obj = productRepository.findById(id);

        Product product = obj.orElseThrow(() -> new ResourceNotFound("Product not found " + id));

        return new ProductDTO(product, product.getCategories());
    }

    @Transactional
    public ProductDTO insert(ProductDTO dto){
        Product entity = new Product();
        copyDtoToEntity(dto, entity);
        entity = productRepository.save(entity);

        return new ProductDTO(entity);
    }

    @Transactional
    public static ProductDTO update(Long id, ProductDTO dto){
        Product entity = new Product();

        copyDtoToEntity(dto, entity);
        entity = productRepository.save(entity);

        return new ProductDTO(entity);
    }

    @Transactional
    public static delete update(Long id){
        Optional<Product> obj = productRepository.findById(id);

        return new ProductDTO(obj);
    }

    private void copyDtoToEntity(ProductDTO dto, Product entity){
        entity.setName(dto.getName());
        entity.setDescription((dto.getDescription()));
        entity.setPrice(dto.getPrice());
        entity.setImageUrl(dto.getImageUrl());

        dto.getCategories().forEach(c -> entity.getCategories().add(new Category(c)));
    }
}
