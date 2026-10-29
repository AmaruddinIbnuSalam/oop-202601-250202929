# Catatan Minggu 3: Inheritance

## Yang saya kerjakan
Melengkapi tiga subclass `Aset`, yaitu `Ruang`, `Laptop`, dan `AlatLab`, dengan field khusus, konstruktor yang memanggil `super`, getter, serta override `getJenis()`. Saya juga menjaga validasi milik `Aset` tetap berlaku dan menambahkan validasi khusus tiap subclass. Setelah itu saya menjalankan tes minggu 1 sampai 3 dan memastikan seluruh tes lolos.

## Keputusan desain
Field yang saya letakkan di induk `Aset` adalah `kode`, `nama`, `status`, dan `kondisi` karena keempatnya dimiliki oleh semua jenis aset. Field khusus saya letakkan di subclass: `kapasitas` di `Ruang`, `spesifikasi` dan `nomorInventaris` di `Laptop`, serta `laboratorium` dan `tingkatRisiko` di `AlatLab`. Dengan begitu induk tidak menyimpan field yang hanya bermakna untuk satu jenis aset dan tidak ada field bernilai kosong yang tidak terpakai.

Agar kode validasi teks tidak diduplikasi, helper `validasiTeks` di `Aset` saya ubah dari `private` menjadi `protected static`. Subclass tetap memakai aturan yang sama, sehingga pesan dan perilaku validasi konsisten.

Satu contoh di sistem ini di mana inheritance kurang tepat dibanding komposisi adalah perhitungan denda. Jika `hitungDenda()` di-override di tiap subclass `Aset`, aturan denda terikat permanen pada jenis aset. Padahal tarif dan aturan denda bisa berubah atau berbeda per kebijakan, sehingga akan lebih fleksibel bila `Peminjaman`/`LayananDenda` menyimpan objek `AturanDenda` (komposisi/Strategy) yang bisa diganti tanpa mengubah class aset. Inheritance tetap cocok untuk relasi "Ruang adalah Aset", tetapi kurang cocok untuk perilaku yang dapat berubah-ubah seperti aturan denda.

## Kendala
Pada percobaan pertama, tes gagal dijalankan karena folder `target` masih berisi class hasil kompilasi JDK 25, sedangkan Maven di komputer saya memakai JDK 21. Saya mengatasinya dengan menjalankan `mvn clean test` agar seluruh class dikompilasi ulang, lalu tes minggu 1 sampai 3 berhasil lolos (19 tes).

## Penggunaan AI
- Alat yang dipakai: ChatGPT 
- Bagian yang dibantu AI: implementasi `Ruang`, `Laptop`, `AlatLab`, perubahan helper `validasiTeks` di `Aset`, dan penyusunan catatan ini.
- Prompt utama: "bantu jelaskan pengubahan helper validasiTesk yang di ubah menjadi protected".
- Yang saya ubah atau tolak dari saran AI, dan alasannya: saya menolak menduplikasi validasi teks di setiap subclass, saya memilih mengubah helper `validasiTeks` di `Aset` menjadi `protected` agar aturan validasi tetap satu sumber dan kode induk benar-benar dipakai ulang.
- Satu hal yang saya pahami lebih baik sekarang: field yang bersifat umum harus berada di induk, sedangkan field yang hanya dimiliki jenis tertentu harus berada di subclass; inheritance sebaiknya dipakai untuk relasi "is-a" yang stabil, bukan untuk perilaku yang sering berubah.
