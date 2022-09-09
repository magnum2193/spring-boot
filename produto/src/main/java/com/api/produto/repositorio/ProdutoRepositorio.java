package com.api.produto.repositorio;

import com.api.produto.modelo.ProdutoModelo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProdutoRepositorio extends CrudRepository<ProdutoModelo, Integer> {

    //  Listar todos os produtos
    List<ProdutoModelo> findAll();

    //  Pesquisar por codigo
    ProdutoModelo findByCodigo(int codigo);

    //  Remover produto
    void delete(ProdutoModelo produto);

    //  Cadastrar/Alterar produto (mesmo metodo)
    <ProdMod extends ProdutoModelo> ProdMod save(ProdMod produto);
}
