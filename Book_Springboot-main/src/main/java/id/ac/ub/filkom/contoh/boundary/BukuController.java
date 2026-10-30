package id.ac.ub.filkom.contoh.boundary;

import id.ac.ub.filkom.contoh.entity.Buku;
import id.ac.ub.filkom.contoh.entity.BukuRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BukuController {

    private final BukuRepository bukuRepository;

    public BukuController(BukuRepository bukuRepository) {
        this.bukuRepository = bukuRepository;
    }

    @GetMapping({"/", "/buku"})
    public String daftarBuku(Model model) {
        model.addAttribute("daftarBuku", bukuRepository.findAll());
        return "buku";
    }

    @GetMapping("/buku/tambah")
    public String formTambahBuku(Model model) {
        model.addAttribute("buku", new Buku("", "", 0));
        return "tambah-buku";
    }

    @PostMapping({"/buku", "/buku/tambah"})
    public String simpanBuku(@RequestParam String idBuku,
                             @RequestParam String judul,
                             @RequestParam int stok) {
        bukuRepository.save(new Buku(idBuku, judul, stok));
        return "redirect:/buku";
    }
}