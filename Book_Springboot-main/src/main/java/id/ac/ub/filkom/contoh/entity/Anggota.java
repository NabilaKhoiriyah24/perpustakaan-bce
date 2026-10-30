package id.ac.ub.filkom.contoh.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "anggota")
public class Anggota {

    @Id
    @Column(name = "id_anggota", length = 10)
    private String idAnggota;

    @Column(name = "nama", length = 100)
    private String nama;

    @Column(name = "batas_pinjam")
    private int batasPinjam;

    protected Anggota() {}

    public Anggota(String idAnggota, String nama, int batasPinjam) {
        this.idAnggota = idAnggota;
        this.nama = nama;
        this.batasPinjam = batasPinjam;
    }

    public boolean cekBatasPinjam() {
        return this.batasPinjam > 0;
    }

    public void catatPinjaman() {
        this.batasPinjam--;
    }

    public String getIdAnggota() { return idAnggota; }
    public String getNama() { return nama; }
    public int getBatasPinjam() { return batasPinjam; }
}