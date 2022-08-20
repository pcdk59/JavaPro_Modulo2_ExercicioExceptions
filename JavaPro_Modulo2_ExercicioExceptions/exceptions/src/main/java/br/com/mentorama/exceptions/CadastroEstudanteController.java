package br.com.mentorama.exceptions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cadastro")

public class CadastroEstudanteController {

    @Autowired
    private EstudanteService estudanteService;

    //Listar todos:
    @GetMapping
    public ResponseEntity<List<EstudanteModel>> findAll(){
        return new ResponseEntity<>(estudanteService.findAll(), HttpStatus.OK);
    }
    @GetMapping("/{nome}")
    public ResponseEntity<List<EstudanteModel>>  ListByName(@PathVariable("nome") String nome) {
         return new ResponseEntity<>(estudanteService.listByName(nome),HttpStatus.OK);

    }
    @GetMapping("/{id}/")
    public ResponseEntity<EstudanteModel>  findById (@PathVariable("id") Integer id){
        return new ResponseEntity<>(estudanteService.findById(id),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Integer> post(@RequestBody EstudanteModel estudanteModel){
        Integer id = estudanteService.post(estudanteModel);
        return new ResponseEntity<>(id, HttpStatus.CREATED);
    }

    @ExceptionHandler({AlunoNaoExistenteException.class})
    public ResponseEntity<String> handle(final AlunoNaoExistenteException e){
        return new ResponseEntity<>("Aluno(a) inexistente.", HttpStatus.NOT_FOUND);
    }
}
