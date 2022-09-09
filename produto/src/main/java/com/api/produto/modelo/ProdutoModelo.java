package com.api.produto.modelo;

import javax.persistence.*;

@Entity
@Table(name = "produtos")
public class ProdutoModelo {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private int codigo;

    @Column(name = "nome")
    private String nome;

    @Column(name = "valor")
    private double valor;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
