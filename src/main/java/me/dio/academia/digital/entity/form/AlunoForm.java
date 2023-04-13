package me.dio.academia.digital.entity.form;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlunoForm {

  @NotBlank(message = "Preencha o campo corretamente") //notacao que só pode ser usada quando estivermos trabalhando com String. Ela diz que o campo não pode ser vazio
  @Size(min = 3, max =50, message = "'${validatedValue}' precisa estar entre {min} e {max} caracteres.") //Padrão ELExpression
  private String nome;

  @NotEmpty(message = "Preencha o campo corretamente.")//não permite CPF vazio
  @CPF(message = "'${validatedValue}' é inválido!") //validar CPF.
  private String cpf;


  @NotEmpty(message = "Preencha o campo corretamente.")
  @Size(min = 3, max =50, message = "'${validatedValue}' precisa estar entre {min} e {max} caracteres.")
  private String bairro;


  @NotNull(message = "Prencha o campo corretamente.")//data não pode ser nula
  @Past(message = "Data '${validatedValue}' é inválida.")//data tem que ser do passado
  private LocalDate dataDeNascimento;
}
