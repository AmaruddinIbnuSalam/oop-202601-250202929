# CCatatan Minggu 01: Paradigma Pemrograman dan Setup

## Yang saya kerjakan
(2-5 kalimat dengan bahasa Anda sendiri)
saya menyiapkan JDK21 dan maven lalu saya mengisi Todo pada ketiga class:
yaitu HelloProsedural, HelloOOP, dan HelloFungsional,Ketiganya menghasilkan sapaan yang sama, yaitu memuat "Aset-Pinjam", nama, dan NIM. Saya juga mengisi mahasiswa.properties dengan nama dan NIM saya. Hasil akhirnya, Minggu01Test lolos dengan 5 tes, 0 gagal, tetapi ada satu pada bagian demo 1.0-SNAPSHOT masih FAILURE saya belum menemukan dimana letak keliruan nya.
## Keputusan desain
Format sapaan yang saya pilih: Hello Aset-Pinjam, saya <nama> (<nim>). Format ini dipakai persis sama di ketiga gaya karena tes ketigaGayaMenghasilkanIsiSama membandingkan isi ketiganya.
Prosedural: satu fungsi statis sapa(nama, nim) yang hanya memakai String, tanpa objek buatan sendiri.
OOP: field nama dan nim saya buat private final supaya datanya terbungkus dan tidak bisa diubah setelah objek dibuat. Perilakunya ada di method sapa().
Fungsional: pembuatSapaan(nim) mengembalikan lambda Function<String, String> yang menerima nama. NIM ditangkap dari parameter luar, jadi tidak ada state yang berubah.

## Kendala
kendala yang saya alami adalah saat setup JDK dan maven  dan demo 1.0-SNAPSHOT masih FAILURE.

## Penggunaan AI
- Alat yang dipakai: Alat yang dipakai: Claude (Anthropic)
- Bagian yang dibantu AI:Bagian yang dibantu AI: perbaikan isi HelloProsedural.sapa(), HelloOOP (field dan sapa()), HelloFungsional.pembuatSapaan(), serta pemecahan masalah setup JDK, Maven, dan PowerShell.
- Prompt utama: 
  1. "itu file nya yang harus di edit saya bingung nanti itu jadinya itu seperti apa jika di test"
  2. "mvn : The term 'mvn' is not recognized ..." (error setup Maven)
  3. Hasil output `uji.ps1` yang gagal, saya tempel agar dianalisis.
"mvn : The term 'mvn' is not recognized ..." (error setup Maven)
Hasil output uji.ps1 yang gagal, saya tempel agar dianalisis.
- Yang saya ubah atau tolak dari saran AI, dan alasannya:
Yang saya ubah atau tolak dari saran AI, dan alasannya: 
saran memasang Maven lewat winget install Apache.Maven tidak berhasil (paket tidak ditemukan), jadi saya pakai unduhan binary manual. Saya juga menjalankan ulang tes sendiri dan memeriksa hasilnya, bukan hanya menyalin kode.
- Satu hal yang saya pahami lebih baik sekarang:
tiga paradigma bisa menyelesaikan masalah yang sama dengan cara berbeda. Prosedural memakai fungsi dan data primitif, OOP membungkus data dan perilaku dalam class, dan fungsional memperlakukan fungsi sebagai nilai (lambda) tanpa state yang berubah. Saya juga paham bahwa pesan `expected` vs `but was` pada tes membantu menemukan class mana yang formatnya masih beda.
