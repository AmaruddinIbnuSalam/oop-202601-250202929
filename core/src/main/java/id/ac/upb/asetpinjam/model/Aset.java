package id.ac.upb.asetpinjam.model;

import java.util.Objects;

import id.ac.upb.asetpinjam.config.Varian;
import id.ac.upb.asetpinjam.kontrak.DapatDipinjam;

/**
 * Aset yang dapat dipinjam.
 *
 * <p>Minggu 2: lengkapi field, konstruktor, getter/setter, dan validasi (encapsulation).
 * Minggu 3: tambahkan getJenis() di tiap subclass.
 * Minggu 4: hitungDenda() dioverride di tiap subclass.
 * Minggu 5: isi bisaDipinjam() dan ubah menjadi class abstrak
 * (TestSupport.aset(...) di folder test menyesuaikan sendiri, lihat docs/minggu-05.md).
 */
public abstract class Aset implements DapatDipinjam {
    private final String kode;
    private String nama;
    private StatusAset status;
    private Kondisi kondisi;


    // TODO minggu 2: field private: kode, nama, status (default TERSEDIA), kondisi (default BAIK).

    /** TODO minggu 2: kode dan nama tidak boleh null atau kosong (IllegalArgumentException). */
    public Aset(String kode, String nama) {
        this.kode= validasiTeks(kode, "kode");
        this.nama= validasiTeks(nama, "nama");
        this.status=StatusAset.TERSEDIA;
        this.kondisi=Kondisi.BAIK;
    }

    public String getKode() {
        return kode;
    }

    public String getNama() {
        return nama;
    }

    public StatusAset getStatus() {
        return status;
    }

    public Kondisi getKondisi() {
        return kondisi;
    }

    /** TODO minggu 2: nama baru tidak boleh kosong. */
    public void setNama(String nama) {
        this.nama= validasiTeks(nama, "nama");
    }

    /** TODO minggu 2: status tidak boleh null. */
    public void setStatus(StatusAset status) {
        if (status == null){
            throw new IllegalArgumentException("Status tidak boleh null");
        }
        this.status=status;
    }

    /** TODO minggu 2: kondisi tidak boleh null. */
    public void setKondisi(Kondisi kondisi) {
        if (kondisi == null){
            throw new IllegalArgumentException("Kondisi tidak boleh null");
        }
        this.kondisi=kondisi;
    }
    /** Dipakai juga oleh subclass agar aturan teks tetap satu sumber. */
    protected static String validasiTeks(String nilai, String label) {
        if (nilai == null || nilai.trim().isEmpty()) {
            throw new IllegalArgumentException(label + " tidak boleh null atau kosong");
        }
        return nilai.trim();
    }
    /** True hanya jika status TERSEDIA dan kondisi bukan RUSAK_BERAT. */
    @Override
    public boolean bisaDipinjam() {
        return status == StatusAset.TERSEDIA && kondisi != Kondisi.RUSAK_BERAT;
    }

    /** TODO minggu 3: dioverride tiap subclass agar mengembalikan jenis yang benar. */
    public JenisAset getJenis() {
        throw new UnsupportedOperationException("TODO minggu 3");
    }

    /** Denda keterlambatan. Subclass meng-override dengan multiplier jenisnya masing-masing. */
    public abstract long hitungDenda(int hariTerlambat);

    /** Perhitungan bersama: validasi hari, tarif varian, dan multiplier jenis. */
    protected static long hitungDendaDasar(int hariTerlambat, int multiplier) {
        if (hariTerlambat < 0) {
            throw new IllegalArgumentException("hari terlambat tidak boleh negatif");
        }
        return (long) hariTerlambat * multiplier * Varian.aktif().dendaPerHari;
    }
}
