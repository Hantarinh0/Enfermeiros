package br.edu.ufrb.gcet236.enfermeiros.entities;

public class Enfermeiro extends Pessoa {
    private String lotação;
    
    //retorna a lotação do enfermeiro.
    public String getLotação() {
        return this.lotação;
    }
    
    //define a lotação do enfermeiro.
    public void setLotação(String lotação) {
        this.lotação = lotação;
    }

    @Override
    public String toString() {

        // Retorna uma representação em formato JSON dos atributos lotação, rg, cpf, nome e telefone do enfermeiro.
        return "{" + " lotação='" + this.getLotação() + "'" + ", rg='" + this.getRg() + "'" + ", cpf='" + this.getCpf() + "'"
                + ", nome='" + this.getNome() + "'" + ", telefone='" + this.getTelefone() + "'" + "}";
    }
}
