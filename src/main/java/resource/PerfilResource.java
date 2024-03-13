package resource;

import entity.Perfil;
import entity.Permissao;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import repository.PerfilRepository;

import java.util.List;

@RestController
@RequestMapping(value = "/perfil")
public class PerfilResource {

    @Autowired
    private PerfilRepository repo;

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

//    @GetMapping(value = "/{id}/permissoes")
//    }

////    @Transactional
////    @PostMapping(value = "/{id}/permissoes")
//
//    }
}