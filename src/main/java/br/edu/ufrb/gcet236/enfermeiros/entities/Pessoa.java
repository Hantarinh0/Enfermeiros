package br.edu.ufrb.gcet236.enfermeiros.entities;

public class Pessoa {
    private String rg;
    private String cpf;
    private String nome;
    private String telefone;

    // Método para obter o RG
    public String getRg() {
        return this.rg;
    }

    // Método para definir o RG
    public void setRg(String rg) {
        this.rg = rg;
    }

    // Método para obter o CPF
    public String getCpf() {
        return this.cpf;
    }

    // Método para definir o CPF
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    // Método para obter o nome
    public String getNome() {
        return this.nome;
    }

    // Método para definir o nome
    public void setNome(String nome) {
        this.nome = nome;
    }

    // Método para obter o telefone
    public String getTelefone() {
        return this.telefone;
    }

    // Método para definir o telefone
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
