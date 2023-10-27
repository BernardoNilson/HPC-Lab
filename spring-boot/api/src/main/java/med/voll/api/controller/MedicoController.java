package med.voll.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.transaction.Transactional;
import med.voll.api.medico.DadosCadastroMedico;
import med.voll.api.medico.Medico;
import med.voll.api.medico.MedicoRepository;

@RestController // Serve para a Spring interpretar a class como Controller
@RequestMapping("/medico") // Mapeia a aba /medico para requisições do usuário
public class MedicoController {

    @Autowired // Spring Boot que instancia a interface - JPA
    private MedicoRepository repository;

    @Transactional // Transação ativa do banco de dados
    @PostMapping // Usa a anotação de mapeamento de request para filtrar os métodos POST
    public void cadastrar(@RequestBody DadosCadastroMedico dados){ // Oernite que o parâmetro venha na requisição
        repository.save(new Medico(dados));
    }
    
}
