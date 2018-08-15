package io.github.lucasduete.dac.dao;

import io.github.lucasduete.dac.entities.Pessoa;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;

public class PessoaDao {

    private final EntityManager entityManager;

    /**
     * Método construtor mais simples porém obriga todos os clientes a utilizarem uma Unidade
     * de Persistência pre-definida.
     */
    public PessoaDao() {
        this.entityManager = Persistence.createEntityManagerFactory("PU-Postgres").createEntityManager();
    }

    /**
     * Método construtor de PessoaDao mais genérico pois a Unidade de Persistência é definida
     * por quem instanciar este objeto.
     * @param persistenceUnitName Nome da Unidade de Persistência que será utiliada pela instância de
     *                            PessoaDao.
     */
    public PessoaDao(String persistenceUnitName) {
        this.entityManager = Persistence.createEntityManagerFactory(persistenceUnitName).createEntityManager();
    }

    public boolean salvar(Pessoa pessoa) {
        entityManager.getTransaction().begin();

        entityManager.persist(pessoa);

        entityManager.getTransaction().commit();

        return true;
    }

    public Pessoa buscar(String cpf) {
        //  Para realização da busca utilizando 'FIND' não foi necessário abrir uma
        //  transação
        return entityManager.find(Pessoa.class, cpf);
    }

    public boolean remover(Pessoa pessoa) {
        entityManager.getTransaction().begin();

        entityManager.remove(pessoa);

        entityManager.getTransaction().commit();

        return true;
    }

    public Pessoa atualizar(Pessoa pessoa) {
        entityManager.getTransaction().begin();

        //  Basta fazer o merge para sincronizar a entidade do escopo com o banco de dados
        //  o método 'MERGE' irá retornar a entidade persistida por isso retorna-se uma
        //  instancia neste método
        Pessoa tempPessoa = entityManager.merge(pessoa);

        entityManager.getTransaction().commit();

        return tempPessoa;
    }

    public List<Pessoa> listar() {
        List<Pessoa> pessoas;
        entityManager.getTransaction().begin();

        //  Nesta Query é necessário usar uma expressão, ao utilizar "SELECT * FROM Pessoa"
        //  é disparada uma exception, para solucauonar isto utilizar a expressão:
        //  "SELECT p FROM Pessoa p"
        pessoas = entityManager.createQuery("SELECT p FROM Pessoa p").getResultList();

        entityManager.getTransaction().commit();

        return pessoas;
    }

}
