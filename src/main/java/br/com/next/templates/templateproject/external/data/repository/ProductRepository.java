package br.com.next.templates.templateproject.external.data.repository;

import br.com.next.templates.templateproject.external.data.entity.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel, Long> {
}
