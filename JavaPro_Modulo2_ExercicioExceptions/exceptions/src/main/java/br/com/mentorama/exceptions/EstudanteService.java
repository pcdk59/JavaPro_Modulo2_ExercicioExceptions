package br.com.mentorama.exceptions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class EstudanteService {



    @Autowired
    private CadastroRepository cadastroRepository;

    private EstudanteModel estudanteModel;

    public List<EstudanteModel> findAll() {

        return cadastroRepository.findAll();
    }

    public List<EstudanteModel> listByName(String nome) {

        boolean retorno;
        if (cadastroRepository.listByNome(nome).isEmpty()) {
            throw new AlunoNaoExistenteException("Aluno(a) inexistente: " + nome);
        }else{
            return cadastroRepository.listByNome(nome);
        }

    }

    public EstudanteModel findById (Integer id){

        if(cadastroRepository.findById(id) == null){
            throw new AlunoNaoExistenteException("O ID expecificado do(a) Aluno(a) não existe: "+id);
        }
        return cadastroRepository.findById(id);

    }

    public Integer post(EstudanteModel estudanteModel){
        if (estudanteModel.getId() == null){
            estudanteModel.setId(cadastroRepository.count()+1);
        }
        cadastroRepository.post(estudanteModel);
        return estudanteModel.getId();
    }
}
