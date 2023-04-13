package me.dio.academia.digital.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data //anotacao do lombok - dependencia inserida no projeto que abstrai os métodos
//get, set, equals e rashCode - com isso não é preciso escrevê-los
@NoArgsConstructor //cria um construtor vazio necessário ao hibernate
@AllArgsConstructor //cria um construtor com todos os atributos
@Entity //anotação para fazer a persistencia do BD. Ela é que diz para o Banco que esta classe "Aluno" é uma tabela dele
@Table(name = "tb_matriculas") //define o nome que sera dado a tabela no Banco de Dados academia
public class Matricula {

  @Id //O @Entity pede uma chave primária para resolvermos isso usamos a notacao @Id no atributo id
  @GeneratedValue(strategy = GenerationType.IDENTITY) //estratégia de geracao da chave primaria @Id
  private Long id;

  @OneToOne(cascade = CascadeType.ALL)//relacionando matricula com aluno - "relação um pra um" - uma matricula só tem um aluno e um aluno só tem uma matricula.
            // (cascade = CascadeType.ALL): se eu excluir a matrícula, eu excluo o aluno.
  @JoinColumn(name = "aluno_id") //coluna que vai conter a chave estrangeira
  private Aluno aluno;

  private LocalDateTime dataDaMatricula = LocalDateTime.now();
}
