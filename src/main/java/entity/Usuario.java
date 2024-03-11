package entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TB_2TDSPF_USUARIO")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_USUARIO")
    @SequenceGenerator(
            name = "SQ_USUARIO",
            sequenceName = "SQ_USUARIO",
            initialValue = 1,
            allocationSize = 1
    )

    @Column(name = "ID_USUARIO")
    private Long id;

    @Column(name = "EMAIL_USUARIO")
    private String email;

    @Column(name = "PS_USUARIO")
    private String senha;

    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(
            name = "PESSOA",
            referencedColumnName = "ID_PESSOA",
            foreignKey = @ForeignKey(name = "FK_USUARIO_PESSOA")
    )
    private Pessoa pessoa;
}
