package id.ac.ub.filkom.contoh.control;

import java.time.LocalDate;

public record Bukti(
    String idTransaksi,
    String namaAnggota,
    String judulBuku,
    LocalDate tanggalPinjam,
    String status
) {}