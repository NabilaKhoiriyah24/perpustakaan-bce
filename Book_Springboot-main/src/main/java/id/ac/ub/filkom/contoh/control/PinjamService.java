package id.ac.ub.filkom.contoh.control;

import id.ac.ub.filkom.contoh.entity.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class PinjamService {

    private final AnggotaRepository anggotaRepo;
    private final BukuRepository bukuRepo;
    private final TransaksiPinjamRepository transaksiRepo;

    public PinjamService(AnggotaRepository anggotaRepo,
                         BukuRepository bukuRepo,
                         TransaksiPinjamRepository transaksiRepo) {
        this.anggotaRepo = anggotaRepo;
        this.bukuRepo = bukuRepo;
        this.transaksiRepo = transaksiRepo;
    }

    public List<Buku> daftarBuku() {
        return bukuRepo.findAll();
    }

    @Transactional
    public Bukti pinjamBuku(String idAnggota, String idBuku) {
        Anggota anggota = anggotaRepo.findById(idAnggota)
                .orElseThrow(() -> new PinjamGagalException("Anggota tidak ditemukan", false));

        Buku buku = bukuRepo.findById(idBuku)
                .orElseThrow(() -> new PinjamGagalException("Buku tidak ditemukan", false));

        if (!anggota.cekBatasPinjam()) {
            throw new PinjamGagalException("Batas pinjam anggota sudah tercapai", false);
        }

        if (!buku.cekStok()) {
            throw new PinjamGagalException("Stok buku habis", true);
        }

        TransaksiPinjam transaksi = TransaksiPinjam.buat(anggota, buku);
        buku.kurangiStok();
        anggota.catatPinjaman();

        transaksiRepo.save(transaksi);
        bukuRepo.save(buku);
        anggotaRepo.save(anggota);

        return new Bukti(
                transaksi.getIdTransaksi(),
                anggota.getNama(),
                buku.getJudul(),
                transaksi.getTanggalPinjam(),
                transaksi.getStatus()
        );
    }
}