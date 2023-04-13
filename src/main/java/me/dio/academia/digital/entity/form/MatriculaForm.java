package me.dio.academia.digital.entity.form;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MatriculaForm {


  @NotNull(message = "Preencha o campo corretamente.") //valor não pode ser nulo
  @Positive(message = "O Id do aluno precisa ser positivo.") //Valor só pode ser positivo
  private Long alunoId;

}
