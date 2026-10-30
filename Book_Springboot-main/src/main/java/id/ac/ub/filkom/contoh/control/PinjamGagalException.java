package id.ac.ub.filkom.contoh.control;

public class PinjamGagalException extends RuntimeException {
    private final boolean bisaReservasi;

    public PinjamGagalException(String message, boolean bisaReservasi) {
        super(message);
        this.bisaReservasi = bisaReservasi;
    }

    public boolean isBisaReservasi() {
        return bisaReservasi;
    }
}