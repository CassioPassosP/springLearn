package io.github.cs.productGo.repository;

import io.github.cs.productGo.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto,String> {


}
