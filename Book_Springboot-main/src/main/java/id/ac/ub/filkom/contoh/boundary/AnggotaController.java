package id.ac.ub.filkom.contoh.boundary;

import id.ac.ub.filkom.contoh.entity.AnggotaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/anggota")
public class AnggotaController {

    private final AnggotaRepository anggotaRepository;

    public AnggotaController(AnggotaRepository anggotaRepository) {
        this.anggotaRepository = anggotaRepository;
    }

    @GetMapping
    public String daftarAnggota(Model model) {
        model.addAttribute("daftarAnggota", anggotaRepository.findAll());
        return "anggota";
    }
}