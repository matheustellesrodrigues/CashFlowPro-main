package br.com.fiap.cashflowpro.model;

import java.util.Random;

// os valores de record n podem ser mudados o objeto categoria durante a passagem de uma passem pra outra ninguem pode mudar categoria
public record Categoria(Long id, String nome, String icone) {
//o record n tem metodos set
    public Categoria(Long id, String nome, String icone){
        //o abs pega só o numero absoluto ignorando o sinal
        var key = (id!= null) ? id : Math.abs(new Random().nextLong() );// se já tem id, n é preciso passar um aleatorio pois pega o que já tem
        this.id = key; //esses comportamento do id é o que difere do record
        this.nome = nome;
        this.icone = icone; 


    }
}
//isso é equivalente a todo o codigo que tinha os getters e setters
