package br.com.mentorama.exceptions;

import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository

public class CadastroRepository {

    private final List<EstudanteModel> cadastros;

    public CadastroRepository () {

        this.cadastros = new ArrayList<>();

        EstudanteModel aluno1 = new EstudanteModel(01 , "André", 19);
        EstudanteModel aluno2 = new EstudanteModel(02 , "Bruna", 18);
        EstudanteModel aluno3 = new EstudanteModel(03 , "Carlos",21);
        EstudanteModel aluno4 = new EstudanteModel(04 , "Bruna", 21);
        EstudanteModel aluno5 = new EstudanteModel(05 , "Diana", 21);

        cadastros.add(aluno1);
        cadastros.add(aluno2);
        cadastros.add(aluno3);
        cadastros.add(aluno4);
        cadastros.add(aluno5);
    }

   public List<EstudanteModel> findAll(){
        return cadastros;
   }

   //1.2) Filtrar por nome:
    public List<EstudanteModel> listByNome (String nome){
        return cadastros.stream()
                .filter(cad-> cad.getNome().contains(nome))
                .collect(Collectors.toList());
    }
    //1.3) Filtrar por nome:
    public List<EstudanteModel> listByIdade (Integer idade){
        return cadastros.stream()
                .filter(cad-> cad.getNome().equals(idade))
                .collect(Collectors.toList());
    }
    // 2) Buscar aluno por Id:
    public EstudanteModel findById (Integer id){
        return cadastros.stream()
                .filter(cad-> cad.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
    public void post(EstudanteModel estudanteModel){
        this.cadastros.add(estudanteModel);
    }
    public Integer count(){
        return cadastros.size();
    }

}
