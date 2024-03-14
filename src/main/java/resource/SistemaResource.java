package resource;

import entity.Sistema;
import entity.Usuario;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import repository.SistemaRepository;
import repository.UsuarioRepository;

import java.util.List;
import java.util.Objects;
import java.util.Set;

@RestController
@RequestMapping(value = "/sistema")
public class SistemaResource {

    @Autowired
    private SistemaRepository repo;

    @Autowired
    private UsuarioRepository userRepo;

    @GetMapping
    public List<Sistema> findAll() {
        return repo.findAll();
    }

    @GetMapping(value = "/{id}")
    public Sistema findById(@PathVariable Long id) {
        return repo.findById(id).orElseThrow();
    }

    @Transactional
    @PostMapping
    public Sistema save(@RequestBody Sistema sistema) {
        return repo.save(sistema);
    }

    @GetMapping(value = "/{id}/responsaveis")
    public Set<Usuario> findResponsaveis(@PathVariable Long id) {
        Sistema sistema = repo.findById(id).orElseThrow();
        return sistema.getResponsaveis();
    }

    @Transactional
    @PostMapping(value = "/{id}/responsaveis")
    public Sistema addResponsavel(@PathVariable Long id, @RequestBody Usuario user) {
        Sistema sistema = repo.findById(id).orElseThrow();

        if (Objects.nonNull(user.getId())) {
            Usuario usuario = userRepo.findById(user.getId()).orElseThrow();
            sistema.getResponsaveis().add(usuario);
            return sistema;
        }
        sistema.getResponsaveis().add(user);
        return sistema;
    }
}
