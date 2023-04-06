package br.edu.ufrb.gcet236.enfermeiros.entities;

import java.util.ArrayList;

public class Hospital {
    private ArrayList<Pessoa> colaboradores = new ArrayList<Pessoa>();

    public ArrayList<Pessoa> getColaboradores() {
        return this.colaboradores;
    }

    public void cadastrarColaboradores(Pessoa colaborador) {
        this.colaboradores.add(colaborador);
    }

    public ArrayList<Pessoa> buscarPorNome(String nome) {
        // Todo Baseado nos Exercícios 5.3 de 14 Mar no ClassRoom
        ArrayList<Pessoa> resultados = new ArrayList<Pessoa>();
        for (Pessoa colaborador : this.colaboradores) {
            if (nome.equalsIgnoreCase(colaborador.getNome())) {
                resultados.add(colaborador);
            }
        }
        return resultados;
    }
    public ArrayList<Pessoa> buscarPorCPF(String cpf) {
        ArrayList<Pessoa> resultados = new ArrayList<Pessoa>();
        for (Pessoa colaborador : this.colaboradores) {
            if (cpf.equalsIgnoreCase(colaborador.getCpf())) {
                resultados.add(colaborador);
            }
        }
        return resultados;
    }
    public ArrayList<Pessoa> buscarPorRG(String rg) {
        // Todo Baseado nos Exercícios 5.3 de 14 Mar no ClassRoom
        ArrayList<Pessoa> resultados = new ArrayList<Pessoa>();
        for (Pessoa colaborador : this.colaboradores) {
            if (rg.equalsIgnoreCase(colaborador.getRg())) {
                resultados.add(colaborador);
            }
        }
        return resultados;
    }
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
