package io.github.lucasduete.dac;

import io.github.lucasduete.dac.dao.PessoaDao;
import io.github.lucasduete.dac.entities.Pessoa;

public class Loader {

    public static void main(String[] args) {

        //  Criando 3 objetos do tipo Pessoa
        Pessoa lucas = new Pessoa("11122233344", "Lucas", "lucas@gmail.com");
        Pessoa may = new Pessoa("55566677788", "Mayara", "may@gmail.com");
        Pessoa temp = new Pessoa("99900011122", "Temporário", "temp@gmail.com");

        //  Instanciando uma PessoaDao utilizando Construtor Default
        PessoaDao dao = new PessoaDao();

        // Persistindo as 3 Pessoas
        System.out.printf("\n" + dao.salvar(lucas));
        System.out.printf("\n" + dao.salvar(may));
        System.out.printf("\n" + dao.salvar(temp));

        //  Buscando uma Pessoa em Específico
        System.out.printf("\n\n" + dao.buscar("11122233344"));

        //  Atualizando uma Pessoa
        lucas.setNome("Lucas Duete");
        System.out.printf("\n" + dao.atualizar(lucas));

        //  Removendo uma Pessoa
        System.out.printf("\n" + dao.remover(temp));

        System.out.printf("\n\n");

        //  Listando todas as Pessoas Persistidas
        dao.listar().forEach(System.out::println);

    }
}
