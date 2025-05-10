# AppBankKasir
1. Kelas Rekening
Kelas ini mewakili akun bank. Setiap rekening memiliki ID, jenis rekening (seperti Tabungan atau Giro), dan saldo.

Rekening(int id, String jenis, double saldo): Konstruktor untuk membuat rekening dengan ID, jenis, dan saldo awal yang diberikan.

getId(): Mengembalikan ID rekening.

getJenis(): Mengembalikan jenis rekening (Tabungan/Giro).

getSaldo(): Mengembalikan saldo rekening.

setor(double jumlah): Menambah saldo rekening dengan jumlah yang disetorkan.

tarik(double jumlah): Mengurangi saldo rekening dengan jumlah yang ditarik.

hitungBunga(): Menghitung bunga rekening berdasarkan jenis rekening (biasanya dipakai oleh rekening Tabungan).

2. Kelas RekeningOperations
Kelas ini berfungsi untuk mengelola operasi yang terkait dengan rekening, seperti menambah rekening, memperbarui saldo, dan mendapatkan rekening berdasarkan ID.

tambahRekening(String jenis, double saldo): Menambah rekening baru berdasarkan jenis (Tabungan/Giro) dan saldo awal.

getSemuaRekening(): Mengambil daftar semua rekening yang ada.

getRekeningById(int id): Mencari rekening berdasarkan ID.

updateSaldo(int id, double saldo): Memperbarui saldo rekening dengan ID tertentu.

3. Kelas Transaksi
Kelas ini mewakili transaksi yang dilakukan pada rekening, seperti setor atau tarik tunai. Setiap transaksi memiliki ID rekening, jenis transaksi (setor/tarik), jumlah uang yang terlibat, dan tanggal transaksi.

Transaksi(int rekeningId, String tipe, double jumlah, Date tanggal): Konstruktor untuk membuat transaksi dengan ID rekening, tipe transaksi (setor/tarik), jumlah uang, dan tanggal transaksi.

getRekeningId(): Mengembalikan ID rekening yang terlibat dalam transaksi.

getTipe(): Mengembalikan jenis transaksi (setor/tarik).

getJumlah(): Mengembalikan jumlah uang yang terlibat dalam transaksi.

getTanggal(): Mengembalikan tanggal transaksi.

4. Kelas TransaksiOperations
Kelas ini mengelola operasi terkait transaksi, seperti setor tunai, tarik tunai, dan menyimpan riwayat transaksi ke database.

setorTunai(int rekeningId, double jumlah): Menambah saldo rekening dengan jumlah yang disetor dan mencatat transaksi tersebut.

tarikTunai(int rekeningId, double jumlah): Menarik uang dari rekening, dengan pengecekan saldo terlebih dahulu, lalu mencatat transaksi tarik tunai.

simpanTransaksi(int rekeningId, String tipe, double jumlah): Menyimpan transaksi (setor/tarik) ke database.

tampilkanTransaksi(int rekeningId): Menampilkan riwayat transaksi berdasarkan ID rekening, dengan urutan dari yang terbaru.

5. Kelas Main
Kelas ini adalah tempat utama aplikasi berjalan, di mana pengguna bisa memilih berbagai menu untuk mengelola rekening dan transaksi.

main(String[] args): Fungsi utama yang menjalankan aplikasi. Menampilkan menu untuk pengguna memilih aksi (tambah rekening, setor tunai, tarik tunai, lihat transaksi, dll). Setelah memilih aksi, aplikasi akan memanggil metode dari RekeningOperations atau TransaksiOperations sesuai dengan aksi yang dipilih.

Fungsi-fungsi dalam Main:
Menu 1 (Tambah Rekening): Pengguna bisa menambahkan rekening baru dengan jenis (Tabungan/Giro) dan saldo awal.

Menu 2 (Lihat Semua Rekening): Menampilkan daftar semua rekening yang ada beserta saldo dan bunga jika ada.

Menu 3 (Setor Tunai): Pengguna bisa setor uang ke rekening tertentu dan mencatat transaksi setor.

Menu 4 (Tarik Tunai): Pengguna bisa tarik uang dari rekening, dengan pengecekan saldo terlebih dahulu, dan mencatat transaksi tarik.

Menu 5 (Lihat Riwayat Transaksi): Pengguna bisa melihat riwayat transaksi untuk rekening tertentu.

Menu 0 (Keluar): Keluar dari aplikasi.

