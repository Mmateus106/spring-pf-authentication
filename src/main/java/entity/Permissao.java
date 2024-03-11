package entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TB_2TDSPF_PERMISSAO")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Permissao {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PERMISSAO")
    @SequenceGenerator(
            name = "SQ_PERMISSAO",
            sequenceName = "SQ_PERMISSAO",
            initialValue = 1,
            allocationSize = 1
    )

    @Column(name = "ID_PERMISSAO")
    private Long id;

    @Column(name = "EMAIL_PERMISSAO")
    private String nome;

    @Column(name = "SIGLA_SISTEMA")
    private String sigla;

    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(
            name = "SISTEMA",
            referencedColumnName = "ID_SISTEMA",
            foreignKey = @ForeignKey(name = "FK_SISTEMA_PERMISSAO")
    )
    private Sistema sistema;
}
