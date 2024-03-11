package entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedHashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "TB_2TDSPF_PERFIL")
public class Perfil {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PERFIL")
    @SequenceGenerator(
            name = "SQ_PERFIL",
            sequenceName = "SQ_PERFIL",
            initialValue = 1,
            allocationSize = 1
    )

    @Column(name = "ID_PERFIL")
    private Long id;

    @Column(name = "NM_PERFIL")
    private String nome;

    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(
            name = "TB_2TDSPF_PERFIL_PERMISSAO",
            joinColumns = {
                    @JoinColumn(
                            name = "PREFIL",
                            referencedColumnName = "ID_PERFIL",
                            foreignKey = @ForeignKey(name = "FK_PERFIL_PERMISSAO")
                    )
            }, inverseJoinColumns = {
            @JoinColumn(
                    name = "PERMISSAO",
                    referencedColumnName = "ID_PERFIL",
                    foreignKey = @ForeignKey(name = "FK_PERMISSAO_PERFIL")
            )
    }
    )


    private Set<Permissao> permissoes = new LinkedHashSet<>();

}
