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
@Table(name = "tb_avaliacoes") //define o nome que sera dado a tabela no Banco de Dados academia
public class AvaliacaoFisica {

  @Id //O @Entity pede uma chave primária para resolvermos isso usamos a notacao @Id no atributo id
  @GeneratedValue(strategy = GenerationType.IDENTITY) //estratégia de geracao da chave primaria @Id
  private Long id;


  @ManyToOne(cascade = CascadeType.ALL) //@ManyToOne: define o relacionamento com aluno e entre as tabelas no Banco de dados. É a relação "vários para um" - ou seja -  várias avaliações físicas terão apenas um aluno
        //Argumento (cascade = CascadeType.ALL) significa que todas as alterações feitas nesta tabela também causarão alterações na tabela do aluno (efeito cascata)
  @JoinColumn(name = "aluno_id") //significa que a coluna de chave estrangeira estará dentro da tabela de Avaliação física. Estamos relacionando a atividade física ao Id do aluno
  private Aluno aluno;

  private LocalDateTime dataDaAvaliacao = LocalDateTime.now();

  @Column(name = "peso_atual") //alteramos o nome da coluna no BD para peso_atual
  private double peso;

  @Column(name = "altura_atual") //alteramos o nome da coluna no BD para altura_atual
  private double altura;

}
