package id.ac.ub.filkom.contoh.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "buku")
public class Buku {

    @Id
    @Column(name = "id_buku", length = 10)
    private String idBuku;

    @Column(name = "judul", length = 200)
    private String judul;

    @Column(name = "stok")
    private int stok;

    protected Buku() {}

    public Buku(String idBuku, String judul, int stok) {
        this.idBuku = idBuku;
        this.judul = judul;
        this.stok = stok;
    }

    public boolean cekStok() {
        return this.stok > 0;
    }

    public void kurangiStok() {
        this.stok--;
    }

    public String getIdBuku() { return idBuku; }
    public String getJudul() { return judul; }
    public int getStok() { return stok; }
}