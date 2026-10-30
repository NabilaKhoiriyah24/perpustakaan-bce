package id.ac.ub.filkom.contoh.boundary;

import id.ac.ub.filkom.contoh.control.Bukti;
import id.ac.ub.filkom.contoh.control.PinjamGagalException;
import id.ac.ub.filkom.contoh.control.PinjamService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/pinjam")
public class HalamanPinjamController {

    private final PinjamService pinjamService;

    public HalamanPinjamController(PinjamService pinjamService) {
        this.pinjamService = pinjamService;
    }

    @GetMapping
    public String tampilHalamanPinjam(@RequestParam(defaultValue = "A001") String idAnggota, Model model) {
        model.addAttribute("idAnggota", idAnggota);
        model.addAttribute("daftarBuku", pinjamService.daftarBuku());
        return "pinjam";
    }

    @PostMapping
    public String submitPinjam(@RequestParam(defaultValue = "A001") String idAnggota,
                               @RequestParam String idBuku,
                               Model model) {
        try {
            Bukti bukti = pinjamService.pinjamBuku(idAnggota, idBuku);
            model.addAttribute("bukti", bukti);
            return "bukti";
        } catch (PinjamGagalException e) {
            model.addAttribute("idAnggota", idAnggota);
            model.addAttribute("daftarBuku", pinjamService.daftarBuku());
            model.addAttribute("pesan", e.getMessage());
            model.addAttribute("bisaReservasi", e.isBisaReservasi());
            return "pinjam";
        }
    }
}