# Catatan Minggu 4: Polymorphism

## Yang saya kerjakan
Saya mengisi `hitungDenda(int)` di `Aset` dan menimpanya di `Ruang`, `Laptop`, serta `AlatLab`. Tarif tetap diambil dari `Varian.aktif().dendaPerHari`, lalu dikali jumlah hari dan multiplier jenis (1x, 2x, 4x). Saya juga mengerjakan dua method `cari` di `KatalogAset`, yaitu `cari(kata)` dan `cari(kata, jenis)`. Setelah itu saya jalankan tes minggu 1 sampai 4 dan hasilnya 27 tes lolos.

## Keputusan desain
Pengecekan hari negatif dan pengambilan tarif saya taruh di satu method bantu, `hitungDendaDasar(hari, multiplier)`, di `Aset`. Tiap subclass tinggal memanggil method itu dengan multiplier masing-masing. Alasannya supaya aturan yang sama tidak ditulis ulang tiga kali dan kalau tarif berubah cukup di satu tempat.

Untuk pencarian, `cari(kata, jenis)` saya buat memanggil `cari(kata)` dulu, baru hasilnya disaring berdasarkan `getJenis()`. Jadi logika pencocokan nama tidak dobel. Saya pakai `toLowerCase(Locale.ROOT)` supaya pencarian tidak terpengaruh pengaturan bahasa komputer.

## Kendala
Awalnya saya bingung kenapa `cari("lab")` juga mengembalikan laptop, padahal yang saya cari alat lab. Ternyata nama laptop di data tes memang "Laptop LAB Komputer", jadi kata "lab" ada di namanya. Setelah saya cek ulang tesnya, hasil itu memang benar.

Bagian yang paling saya pikirkan adalah membedakan overloading dan overriding. Kalau overriding, method subclass punya nama dan parameter yang sama dengan induk, lalu yang dipanggil ditentukan dari objek aslinya saat program jalan. Kalau overloading, namanya sama tapi parameternya beda, dan yang dipilih saat kompilasi. Di tes, variabelnya bertipe `Aset` tetapi objeknya `Ruang`, `Laptop`, atau `AlatLab`, dan hasil dendanya berbeda. Itu yang membuat saya lebih paham dynamic binding.

## Penggunaan AI
- Alat yang dipakai: OpenCode (agen AI Big Pickle).
- Bagian yang dibantu AI: kerangka method `hitungDenda` dan kedua overload `cari`, serta penyusunan catatan ini.
- Prompt utama: "Kerjakan docs/minggu-04.md" lalu "Buat catatan minggu 4 dari template, tulis dengan gaya saya sendiri".
- Yang saya ubah atau tolak dari saran AI, dan alasannya: saya tidak memakai ide menaruh semua perhitungan denda dalam satu method di `Aset` dengan percabangan jenis. Saya pertahankan override di tiap subclass karena tujuan minggu ini latihan overriding dan dynamic binding.
- Satu hal yang saya pahami lebih baik sekarang: method yang dipanggil saat runtime mengikuti objek sebenarnya, bukan tipe variabel referensinya.
