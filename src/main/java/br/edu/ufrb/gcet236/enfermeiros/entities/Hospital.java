package br.edu.ufrb.gcet236.enfermeiros.entities;

import java.util.ArrayList;

public class Colaboradores {
    private ArrayList<Pessoa> colaboradores = new ArrayList<Pessoa>();

    public ArrayList<Pessoa> getColaboradores() {
        return this.colaboradores;
    }

    public void cadastrarColaboradores(Pessoa colaborador) {
        this.colaboradores.add(colaborador);
    }

    public void removerColaboradores(Pessoa colaborador) {
        this.colaboradores.remove(colaborador);
    }

    public ArrayList<Pessoa> buscarPorNome(String nome) {
        // Todo Baseado nos Exercícios 5.3 de 14 Mar no ClassRoom
        return null;
    }
    public ArrayList<Pessoa> buscarPorCPF(String cpf) {
        ArrayList<Pessoa> resultados = new ArrayList<Pessoa>();
        for (Pessoa colaborador : this.colaboradores) {
            String cpfDoColaborador = colaborador.getCpf();
            if (cpf.equalsIgnoreCase(cpfDoColaborador)) {
                resultados.add(colaborador);
            }
        }
        return resultados;
    }
    public ArrayList<Pessoa> buscarPorRG(String rg) {
        // Todo Baseado nos Exercícios 5.3 de 14 Mar no ClassRoom
        return null;
    }
    public ArrayList<Pessoa> buscarPorLotação(String lotação) {
        // Todo Baseado nos Exercícios 5.3 de 14 Mar no ClassRoom
        return null;
    }
}
