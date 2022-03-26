package combat.java.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import combat.java.core.entity.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class)
public class User extends AbstractEntity {

    @NotBlank
    private String username;

    @Email
    @NotBlank
    private String email;

    @CPF
    @NotBlank
    private String cpf;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotBlank
    private String password;

    private boolean status = false;

}
