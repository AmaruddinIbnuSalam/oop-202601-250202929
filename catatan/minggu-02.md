# Minggu 2: Struktur OOP: Class, Object, Encapsulation


## Yang saya kerjakan
Melengkapi class `Aset` di `Aset.java`dan menambahkan validasi agar nama dan kode tidak boleh null atau kosong lalu menjalankan test minggu 2 

## Keputusan desain
Membuat seluruh atribut dibuat private agar perubahan data hanya dapat dilakukan  melalui setter yang memuat validasi dengan prinsip **encapsulation**


## Kendala
Pada percobaan awal, tes `setStatusDanKondisiMemvalidasi` gagal sementara lima tes lain lolos. Saya memeriksa method `setStatus` dan `setKondisi`, memperbaikinya sehingga menolak nilai `null` dengan `IllegalArgumentException`, lalu menjalankan ulang hingga seluruh tes lolos 

## Penggunaan AI

- Alat yang dipakai: Claude (Anthropic)
- Bagian yang dibantu AI: saya di bantu pada pengoreksian kode yang salah pada percobaan awal dan saya dijelaskan juga secara  fungsi dari kode tersebut
- Prompt utama:
  1. "Bantu saya koreksi kesalahan " (disertai isi code error pada terminal).
  2. "Coba jelaskan ke saya kenapa code di awal mengalami error ".
- Yang saya ubah atau tolak dari saran AI, dan alasannya:
saran yang saya tolak adalah untuk mengganti seluruh code yang salah, tapi saya tetap mencari kesalah codenya

