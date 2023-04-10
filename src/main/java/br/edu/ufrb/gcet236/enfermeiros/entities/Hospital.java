package br.edu.ufrb.gcet236.enfermeiros.entities;

import java.util.ArrayList;

public class Hospital {
    private ArrayList<Pessoa> colaboradores = new ArrayList<Pessoa>();
    
    //retorna a lista de colaboradores cadastrados no hospital.
    public ArrayList<Pessoa> getColaboradores() {
        return this.colaboradores;
    }
    
    //adiciona um objeto do tipo Pessoa à lista de colaboradores cadastrados no hospital.
    public void cadastrarColaboradores(Pessoa colaborador) {
        this.colaboradores.add(colaborador);
    }
    
    //busca na lista de colaboradores por nome, ignorando o caso, e retorna uma lista de objetos do tipo Pessoa que possuem o nome informado.
    public ArrayList<Pessoa> buscarPorNome(String nome) {
        ArrayList<Pessoa> resultados = new ArrayList<Pessoa>();
        for (Pessoa colaborador : this.colaboradores) {
            if (nome.equalsIgnoreCase(colaborador.getNome())) {
                resultados.add(colaborador);
            }
        }
        return resultados;
    }
    
    // busca na lista de colaboradores por CPF, ignorando o caso, e retorna uma lista de objetos do tipo Pessoa que possuem o CPF informado.
    public ArrayList<Pessoa> buscarPorCPF(String cpf) {
        ArrayList<Pessoa> resultados = new ArrayList<Pessoa>();
        for (Pessoa colaborador : this.colaboradores) {
            if (cpf.equalsIgnoreCase(colaborador.getCpf())) {
                resultados.add(colaborador);
            }
        }
        return resultados;
    }
    
    //busca na lista de colaboradores por RG, ignorando o caso, e retorna uma lista de objetos do tipo Pessoa que possuem o RG informado
    public ArrayList<Pessoa> buscarPorRG(String rg) {
        ArrayList<Pessoa> resultados = new ArrayList<Pessoa>();
        for (Pessoa colaborador : this.colaboradores) {
            if (rg.equalsIgnoreCase(colaborador.getRg())) {
                resultados.add(colaborador);
            }
        }
        return resultados;
    }
    
    //busca na lista de colaboradores por lotação, ignorando o caso, e retorna uma lista de objetos do tipo Pessoa que possuem a lotação informada. 
    public ArrayList<Pessoa> buscarPorLotação(String lotação) {
        ArrayList<Pessoa> resultados = new ArrayList<Pessoa>();
        for (Pessoa colaborador : this.colaboradores) {
            if (colaborador instanceof Enfermeiro) {
                Enfermeiro enfermeiro = (Enfermeiro) colaborador;
                String lotacaoDoColaborador = enfermeiro.getLotação();
                if (lotação.equalsIgnoreCase(lotacaoDoColaborador)){
                    resultados.add(colaborador);
                }
            }
        }
        return resultados;
    }
}
