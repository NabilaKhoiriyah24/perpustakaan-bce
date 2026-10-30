package id.ac.ub.filkom.contoh.entity;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BukuRepository extends JpaRepository<Buku, String> {
}