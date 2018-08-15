package io.github.lucasduete.dac.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Pessoa implements Serializable {

    @Id
    @Column(length = 11)
    private String cpf;

    @Column(length = 50, nullable = false)
    private String nome;

    @Column(length = 50, nullable = false, unique = true)
    private String email;


    public Pessoa() {

    }

    public Pessoa(String cpf, String nome, String email) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pessoa pessoa = (Pessoa) o;

        if (cpf != null ? !cpf.equals(pessoa.cpf) : pessoa.cpf != null) return false;
        if (nome != null ? !nome.equals(pessoa.nome) : pessoa.nome != null) return false;
        return email != null ? email.equals(pessoa.email) : pessoa.email == null;
    }

    @Override
    public int hashCode() {

        int result = cpf != null ? cpf.hashCode() : 0;
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {

        final StringBuilder sb = new StringBuilder("Pessoa{");
        sb.append("cpf='").append(cpf).append('\'');
        sb.append(", nome='").append(nome).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
