package io.github.cs.productGo.controller;

import io.github.cs.productGo.model.Produto;
import io.github.cs.productGo.repository.ProdutoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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

    @PutMapping("{id}")
    public void atualizar(@PathVariable("id") String id,
                          @RequestBody Produto produto){
        produto.setId(id);
        produtoRepository.save(produto);
        System.out.println("Produto Atualizado");
    }

    @GetMapping
    public List<Produto> buscar(@RequestParam("name") String name){
        return produtoRepository.findByName(name);
    }
    //exemplo:     public List<Produto> buscar(@RequestParam("name") String name, @RequestParam("preco") double preco){
}
