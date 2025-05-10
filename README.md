# UTS PEMROGRAMAN BERORIENTASI OBJEK 2

# Profil
Nama: {Derian}
NIM: { 23552011114 }
Studi Kasus: {Kasir Bank}

# Kasir Bank
 Kasir sistem keuangan seperti setor dan tarik tunai.

 # 4 Pilar OOP dalam Studi Kasus
 
 # 1. Inheritance
 penerapan:
 Membuat kelas Tabungan yang mewarisi kelas Rekening. Kelas Tabungan akan memiliki semua atribut dan metode yang ada di Rekening (seperti 
 getSaldo(), setor(), dll), dan bisa menambahkan fungsionalitas tambahan, misalnya perhitungan bunga
 
 # 2. Polymorphism
 Polymorphism dapat diterapkan jika memiliki berbagai jenis rekening yang memiliki cara berbeda untuk menghitung bunga. Metode 
 hitungBunga() dapat di-override pada setiap subclass rekening, seperti Tabungan, yang menghitung bunga berdasarkan jenis rekeningnya.

 # 3. Encapsulation
 Setiap objek Rekening memiliki atribut-atribut seperti saldo dan jenis, yang diatur sebagai private untuk mencegah akses langsung dari 
 luar kelas. Kemudian, akses ke atribut-atribut ini diberikan melalui metode getter (getSaldo(), getJenis()) dan setter (setor(double 
 jumlah), tarik(double jumlah)).

 # 4. Abstraction
 Jika kita ingin menyembunyikan implementasi spesifik dari jenis rekening, kita bisa membuat kelas Rekening menjadi kelas abstrak dan 
 mendefinisikan metode abstract untuk menghitung bunga yang akan diimplementasikan oleh kelas turunan (Tabungan, Giro).

 # Demo Proyek
 
    


  
   
