package entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "TB_2TDSPF_SISTEMA")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Sistema {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_SISTEMA")
    @SequenceGenerator(
            name = "SQ_SISTEMA",
            sequenceName = "SQ_SISTEMA",
            initialValue = 1,
            allocationSize = 1
    )

    @Column(name = "ID_SISTEMA")
    private Long id;

    @Column(name = "NM_SISTEMA")
    private String nome;

    @Column(name = "SIGLA_SISTEMA")
    private String sigla;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(
            name = "TB_2TDSPF_SISTEMA_USUARIO",
            joinColumns = {
                    @JoinColumn(
                            name = "SISTEMA",
                            referencedColumnName = "ID_SISTEMA",
                            foreignKey = @ForeignKey(name = "FK_SISTEMA_USUARIO")
                    )
            }, inverseJoinColumns = {
            @JoinColumn(
                    name = "USUARIO",
                    referencedColumnName = "ID_USUARIO",
                    foreignKey = @ForeignKey(name = "FK_USUARIO_SISTEMA")
            )
    }
    )
    private Set<Usuario> responsaveis = new LinkedHashSet<>();

}
