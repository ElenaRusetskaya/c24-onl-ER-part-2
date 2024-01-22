package by.teachmeskills.lesson40.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    @NotNull
    @NotBlank
    @Size(max = 10)
    private String name;

    @NotNull
    @NotBlank
    @Size(max = 10)
    private String password;

    @NotNull
    @NotBlank
    @Size(max = 10)
    private String email;
}
