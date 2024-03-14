package resource;

import entity.Perfil;
import entity.Permissao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import jakarta.transaction.Transactional;
import repository.PerfilRepository;
import repository.PermissaoRepository;

import java.util.List;
import java.util.Objects;
import java.util.Set;

@RestController
@RequestMapping(value = "/perfil")
public class PerfilResource {

    @Autowired
    private PerfilRepository repo;

    @Autowired
    private PermissaoRepository PermRepo;

    @GetMapping
    public List<Perfil> findAll() {
        return repo.findAll();
    }

    @PostMapping
    public Perfil save(@RequestBody Perfil perfil) {
        return repo.save(perfil);
    }

    @GetMapping(value = "/{id}")
    public Perfil findById(@PathVariable Long id) {
        return repo.findById(id).orElseThrow();
    }

    @GetMapping(value = "/{id}/permissoes")
    public Set<Permissao> findPermissoes(@PathVariable Long id){
        Perfil perfil = repo.findById(id).orElseThrow();

        return perfil.getPermissoes();
    }

    @Transactional
    @PostMapping(value = "/{id}/permissoes")
    public Perfil addPermissao(@PathVariable Long id, @RequestBody Permissao perm){
        Perfil perfil = repo.findById(id).orElseThrow();

        if(Objects.nonNull(perm.getId())){
            Permissao permissao = PermRepo.findById(perm.getId()).orElseThrow();
            perfil.getPermissoes().add(permissao);
            return perfil;
        }

        perfil.getPermissoes().add(perm);

        return perfil;
    }
}