package id.ac.ub.filkom.contoh.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "transaksi_pinjam")
public class TransaksiPinjam {

    @Id
    @Column(name = "id_transaksi", length = 10)
    private String idTransaksi;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_anggota", nullable = false)
    private Anggota anggota;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_buku", nullable = false)
    private Buku buku;

    @Column(name = "tanggal_pinjam")
    private LocalDate tanggalPinjam;

    @Column(name = "status", length = 20)
    private String status;

    protected TransaksiPinjam() {}

    public static TransaksiPinjam buat(Anggota anggota, Buku buku) {
        TransaksiPinjam t = new TransaksiPinjam();
        t.idTransaksi = "T" + UUID.randomUUID().toString().substring(0, 5).toUpperCase();
        t.anggota = anggota;
        t.buku = buku;
        t.tanggalPinjam = LocalDate.now();
        t.status = "DIPINJAM";
        return t;
    }

    public String getIdTransaksi() { return idTransaksi; }
    public Anggota getAnggota() { return anggota; }
    public Buku getBuku() { return buku; }
    public LocalDate getTanggalPinjam() { return tanggalPinjam; }
    public String getStatus() { return status; }
}