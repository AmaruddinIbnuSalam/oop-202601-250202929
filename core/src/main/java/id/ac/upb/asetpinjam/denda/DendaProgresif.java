package id.ac.upb.asetpinjam.denda;

import id.ac.upb.asetpinjam.kontrak.AturanDenda;
import id.ac.upb.asetpinjam.model.Aset;

/**
 * Minggu 5: denda yang makin berat bila makin lama terlambat.
 *
 * <p>Rumus progresif: denda flat ditambah penalti kuadratik seiring bertambahnya hari terlambat.
 * Memenuhi syarat: 0 hari = 0, tidak pernah lebih murah dari flat, tidak pernah turun, dan
 * pada hari ke-30 lebih mahal dari flat.
 */
public class DendaProgresif implements AturanDenda {

    @Override
    public long hitung(Aset aset, int hariTerlambat) {
        if (hariTerlambat <= 0) {
            return 0;
        }
        long dasar = aset.hitungDenda(hariTerlambat);
        long tambahan = (long) hariTerlambat * hariTerlambat * 500;
        return dasar + tambahan;
    }
}
