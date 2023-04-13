package me.dio.academia.digital.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data //anotacao do lombok - dependencia inserida no projeto que abstrai os métodos
      //get, set, equals e rashCode - com isso não é preciso escrevê-los
@NoArgsConstructor //cria um construtor vazio necessário ao hibernate
@AllArgsConstructor //cria um construtor com todos os atributos
@Entity //anotação para fazer a persistencia do BD. Ela é que diz para o Banco que esta classe "Aluno" é uma tabela dele
@Table(name = "tb_alunos") //define o nome que sera dado a tabela no Banco de Dados academia
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) // esta notação é necessária por causa desta outra notação (@OneToMany(mappedBy = "aluno", fetch = FetchType.LAZY))
public class Aluno {

  @Id //O @Entity pede uma chave primária para resolvermos isso usamos a notacao @Id no atributo id
  @GeneratedValue(strategy = GenerationType.IDENTITY) //estratégia de geracao da chave primaria @Id
  private Long id;


  //se eu não usar @Column e der outro nome, a coluna será criada no BD com o mesmo nome do atributo
  private String nome;

  @Column(unique = true) //atributos da coluna no BD, neste caso, o nome sera o mesmo (cpf) mas o campo será do tipo único no
  private String cpf;

  private String bairro;

  private LocalDate dataDeNascimento;


  @OneToMany(mappedBy = "aluno", fetch = FetchType.LAZY) // define o relacionamento com a AtividadeFisica e entre as tabelas no Banco de dados. É a relação "Um para vários" - ou seja - um aluno terá várias avaliações físicas
            //mappedBy = "aluno", fetch = FetchType.LAZY - carregamento de informações será feita apenas quando solicitado
  @JsonIgnore //tratamento para possiveis exceptions Json de geração de dados (por exemplo, laço infinito)
  private List<AvaliacaoFisica> avaliacoes = new ArrayList<>();

}
