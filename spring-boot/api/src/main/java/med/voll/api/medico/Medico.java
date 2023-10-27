package med.voll.api.medico;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.voll.api.endereco.Endereco;

// Anotações referentes ao JPA e bando de dados, vamos usar a classe no cadastro de médicos
@Table(name = "medicos")
@Entity(name = "Medico")

// Anotações referentes ao Lombok, uma biblioteca que gera os métodos básicos do Java
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String crm;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded
    private Endereco endereco;

    public Medico (DadosCadastroMedico dados){
        this.nome = dados.nome();
        this.email = dados.email();
        this.crm = dados.crm();
        this.endereco = new Endereco(dados.endereco());
        this.especialidade = dados.especialidade();
    }

}
