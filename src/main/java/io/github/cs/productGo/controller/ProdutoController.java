package io.github.cs.productGo.controller;

import io.github.cs.productGo.model.Produto;
import io.github.cs.productGo.repository.ProdutoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

//Recebe Requisicoes REST
//Classe gerenciada pelo spring
@RestController
//Aponta a URL base
@RequestMapping("produtos")
public class ProdutoController {

    private ProdutoRepository produtoRepository;

    public ProdutoController(ProdutoRepository produtoRepository){
        this.produtoRepository = produtoRepository;
    }

    @PostMapping
    public Produto salvar(@RequestBody Produto produto){
        System.out.println("Produto Recebido: " + produto);

        var id = UUID.randomUUID().toString();
        produto.setId(id);

        produtoRepository.save(produto);
        return produto;
    }

    @GetMapping("/{id}")
    public Produto obterPorId(@PathVariable("id") String id){
        return produtoRepository.findById(id).orElse(null);
    }

    @DeleteMapping("{id}")
    public void deletar(@PathVariable("id") String id){
        produtoRepository.deleteById(id);
        System.out.println("Produto Deletado");
    }
}
