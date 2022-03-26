package combat.java.entity;

import combat.java.core.entity.AbstractEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class)
public class Announcement extends AbstractEntity {

    @NotBlank
    private String identificacao;

    @NotBlank
    private String arquivo;

    @NotBlank
    private String script_html;

    private boolean status = false;


}
