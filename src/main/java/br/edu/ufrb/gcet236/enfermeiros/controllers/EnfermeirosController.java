package br.edu.ufrb.gcet236.enfermeiros.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

import org.springframework.http.HttpStatus;

import br.edu.ufrb.gcet236.enfermeiros.entities.Hospital;
import br.edu.ufrb.gcet236.enfermeiros.entities.Enfermeiro;
import br.edu.ufrb.gcet236.enfermeiros.entities.Pessoa;

@RestController
@RequestMapping("api")
public class EnfermeirosController {
    Hospital colaboradores = new Hospital();
    ArrayList<Enfermeiro> enfermeiros = new ArrayList<Enfermeiro>();
    
    //Essa função é um endpoint GET que retorna uma mensagem "Hello Enfermeiros!" como resposta.
    @GetMapping("/hello-world")
    public ResponseEntity<String> get() {
        return ResponseEntity.ok("Hello Enfermeiros!");
    }
    
    //Essa função é um endpoint GET que retorna a lista de enfermeiros cadastrados no hospital como resposta.
    @GetMapping("/listar_enfermeiros")
    public ResponseEntity<String> listarEnfermeiros() {
        return ResponseEntity.ok(colaboradores.getColaboradores().toString());
    }
    
    ///Essa função é um endpoint POST que permite cadastrar um novo enfermeiro no hospital. 
    //O enfermeiro é recebido no corpo da requisição como um objeto JSON e é adicionado à lista de colaboradores do hospital
    @PostMapping(value = "/cadastrar")
    public String cadastrarEnfermeiro(@RequestBody Enfermeiro entrada) {
        colaboradores.cadastrarColaboradores(entrada);
        
        return colaboradores.getColaboradores().toString();
    }
    
    //Essa função é um endpoint GET que permite buscar enfermeiros com base em parâmetros de busca, como nome, CPF, RG ou lotação. 
    //A busca é realizada chamando os respectivos métodos de busca do objeto colaboradores, que é uma instância da classe Hospital.
    //Os resultados são retornados como uma lista de objetos Enfermeiro em formato JSON.
    
    @GetMapping(value = "/busca")
    public ResponseEntity<ArrayList<Enfermeiro>> buscarEnfermeiro(@RequestParam String nome, String cpf, String rg, String lotação) {
        ArrayList<Pessoa> resultadosDaBusca = null;
        enfermeiros.clear();
        if (!nome.isEmpty()) {
            resultadosDaBusca = this.colaboradores.buscarPorNome(nome);
        } 
        else if (cpf != null) 
        {
            resultadosDaBusca = this.colaboradores.buscarPorCPF(cpf);
        }
        else if (rg != null) 
        {
            resultadosDaBusca = this.colaboradores.buscarPorRG(rg);
        }
        else if (lotação != null) 
        {
            resultadosDaBusca = this.colaboradores.buscarPorLotação(lotação);
        }
        
        if (resultadosDaBusca == null) 
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(enfermeiros);
                //"Nenhum enfermeiro encontrado, revise suas informações.");
        }

        for (var resultado : resultadosDaBusca) {
            if (resultado instanceof Enfermeiro)
            {
                enfermeiros.add((Enfermeiro) resultado);
            }
        }

        return ResponseEntity.ok(enfermeiros);
    }
    
    //Essa função é um endpoint GET que permite remover um enfermeiro com base em parâmetros de busca, como nome, CPF, RG ou lotação. 
    //A função chama o método buscarEnfermeiro para obter a lista de enfermeiros correspondentes aos parâmetros de busca e em seguida, 
    //remove o primeiro enfermeiro encontrado da lista de colaboradores do hospital.
    
    @GetMapping(value = "/remover")
    public ResponseEntity<String> removerFevereiro(@RequestParam String nome, String cpf, String rg, String lotação) {
        ArrayList<Pessoa> resultadosDaBusca = null;
        Enfermeiro enfermeiro = buscarEnfermeiro(nome, cpf, rg, lotação).getBody().get(0);

        for (var resultado : resultadosDaBusca) {
            if (resultado instanceof Enfermeiro)
            {
                enfermeiros.add((Enfermeiro) resultado);
            }
        }

        return ResponseEntity.ok(enfermeiros.toString());
    }
}
