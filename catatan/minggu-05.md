# Catatan Minggu 5: Abstraction

## Yang saya kerjakan

Saya mengubah kelas `Aset` menjadi abstract dan mengisi method `bisaDipinjam()` agar mengembalikan `true` hanya jika status `TERSEDIA` dan kondisi bukan `RUSAK_BERAT`. Kemudian saya buat `hitungDenda(int)` menjadi abstract agar tiap subclass (`Ruang`, `Laptop`, `AlatLab`) tetap menentukan multiplier-nya sendiri. Setelah itu saya mengimplementasikan interface `AturanDenda` di `DendaFlat` (memanggil `aset.hitungDenda(hari)`) dan `DendaProgresif` (denda flat ditambah penalti kuadratik). Terakhir saya menjalankan tes minggu 1 sampai 5 dan seluruhnya lolos.

## Keputusan desain

`bisaDipinjam()` saya tulis sebagai satu baris return: `status == StatusAset.TERSEDIA && kondisi != Kondisi.RUSAK_BERAT`, karena aturannya sederhana dan tidak perlu percabangan panjang.

Untuk `DendaProgresif`, saya gunakan rumus `aset.hitungDenda(hari) + hari * hari * 500`. Rumus ini memenuhi semua syarat tes: 0 hari = 0, nilainya selalu lebih besar atau sama dengan flat karena ditambah nilai non-negatif, tidak pernah turun saat hari bertambah karena kedua komponennya monotonik naik, dan pada hari ke-30 pasti lebih mahal dari flat. Detail asumsi rumusnya sudah saya catat di `docs/asumsi.md`.

Saya menjaga `hitungDendaDasar(hari, multiplier)` tetap satu tempat di `Aset` agar tarif dan validasi hari negatif tidak ditulis ulang di tiap subclass.

## Kendala

Awalnya saya ragu apakah `hitungDenda` di `Aset` boleh jadi abstract padahal sudah ada implementasi bawaan. Setelah saya coba, ternyata subclass `Ruang`, `Laptop`, dan `AlatLab` sudah semua override method itu, jadi membuatnya abstract tidak memecah apa pun dan tes minggu 2 tetap lolos karena `TestSupport.aset(...)` otomatis memakai `Ruang`.

Bagian yang perlu berpikir lebih lama adalah memastikan `DendaProgresif` tidak pernah lebih murah dari flat untuk semua hari 1 sampai 30. Setelah saya hitung secara manual untuk beberapa kasus, penalti kuadratik memang selalu membuat nilainya di atas flat, jadi saya yakin rumusnya aman.

## Penggunaan AI

- Alat yang dipakai: OpenCode (agen AI).
- Bagian yang dibantu AI: mengubah `Aset` menjadi abstract, mengisi `bisaDipinjam()`, serta implementasi `DendaFlat` dan `DendaProgresif`, dan menyusun catatan ini.
- Prompt utama: "".
- Yang saya ubah atau tolak dari saran AI, dan alasannya: saya pertahankan rumus progresif sebagai flat ditambah penalti kuadratik (`hari * hari * 500`) agar selalu lebih mahal dari flat dan monotonik naik, bukan rumus lain yang justru mungkin turun atau lebih murah dari flat di hari tertentu.
- Satu hal yang saya pahami lebih baik sekarang: abstract class bisa tetap punya method konkret (seperti `hitungDendaDasar`) yang dipakai bersama oleh semua subclass, sementara method abstract paksa tiap subclass mengisi sendiri perilaku yang berbeda-beda.
