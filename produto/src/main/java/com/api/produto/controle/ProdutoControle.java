package com.api.produto.controle;

import com.api.produto.modelo.ProdutoModelo;
import com.api.produto.modelo.RespostaModelo;
import com.api.produto.repositorio.ProdutoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProdutoControle {

    //  AÇÕES, injeção de dependencia
    @Autowired
    private ProdutoRepositorio acoes;

    //  Listar produtos
    @RequestMapping(value = "/produtos", method = RequestMethod.GET)
    public @ResponseBody
    //  retornar no corpo da pagina alguma resposta
    List<ProdutoModelo> listar() {
        return acoes.findAll();
    }

    //  Cadastrar produtos
    @RequestMapping(value = "/produtos", method = RequestMethod.POST)
    public @ResponseBody
    ProdutoModelo cadastrar(@RequestBody ProdutoModelo produto) {
        return acoes.save(produto);
    }

    //  Filtrar produtos
    @RequestMapping(value = "/produtos/{codigo}", method = RequestMethod.GET)
    public @ResponseBody
    ProdutoModelo filtrar(@PathVariable Integer codigo) {
        return acoes.findByCodigo(codigo);
    }

    //  Alterar produtos
    @RequestMapping(value = "/produtos", method = RequestMethod.PUT)
    public @ResponseBody
    ProdutoModelo alterar(@RequestBody ProdutoModelo produto) {
        return acoes.save(produto);
    }

    //  Remover produtos
    @RequestMapping(value = "/produtos/{codigo}", method = RequestMethod.DELETE)
    public @ResponseBody
    //  Return RespostaModelo - Poderia ser: void, Integer, Double
    RespostaModelo remover(@PathVariable Integer codigo) {
        var resposta = new RespostaModelo();
        
        try {
            ProdutoModelo produto = filtrar(codigo);
            acoes.delete(produto);
            resposta.setMensagem("Produto removido com sucesso");
        } catch (Exception erro) {
            resposta.setMensagem("Falha ao remover: " + erro.getMessage());
        }
        return resposta;
    }
}
