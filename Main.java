/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kasirbank;

import java.util.Scanner;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RekeningOperations ops = new RekeningOperations();
        TransaksiOperations transaksiOps = null;

        try {
            transaksiOps = new TransaksiOperations(); // inisialisasi aman
        } catch (SQLException e) {
            System.out.println("Gagal menghubungkan ke database transaksi: " + e.getMessage());
            return; // keluar dari program jika gagal koneksi
        }

        int pilihan;

        do {
            System.out.println("\n--- Menu Kasir Bank ---");
            System.out.println("1. Tambah Rekening");
            System.out.println("2. Lihat Semua Rekening");
            System.out.println("3. Setor Tunai");
            System.out.println("4. Tarik Tunai");
            System.out.println("5. Lihat Riwayat Transaksi");
            System.out.println("0. Keluar");
            System.out.print("Pilih: ");
            pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1:
                    System.out.print("Jenis rekening (Tabungan/Giro): ");
                    scanner.nextLine(); // buang newline
                    String jenis = scanner.nextLine();
                    System.out.print("Saldo awal: ");
                    double saldo = scanner.nextDouble();
                    ops.tambahRekening(jenis, saldo);
                    break;

                case 2:
                    for (Rekening r : ops.getSemuaRekening()) {
                        System.out.printf("ID: %d | Jenis: %s | Saldo: %.2f | Bunga: %.2f\n",
                                r.getId(), r.getJenis(), r.getSaldo(), r.hitungBunga());
                    }
                    break;

                case 3:
                    System.out.print("ID rekening: ");
                    int idSetor = scanner.nextInt();
                    Rekening rekeningSetor = ops.getRekeningById(idSetor);
                    if (rekeningSetor != null) {
                        System.out.print("Jumlah setor: ");
                        double jumlah = scanner.nextDouble();
                        rekeningSetor.setor(jumlah);
                        ops.updateSaldo(idSetor, rekeningSetor.getSaldo());
                        transaksiOps.setorTunai(idSetor, jumlah); // Pakai metode yang sesuai
                    } else {
                        System.out.println("Rekening tidak ditemukan.");
                    }
                    break;

                case 4:
                    System.out.print("ID rekening: ");
                    int idTarik = scanner.nextInt();
                    Rekening rekeningTarik = ops.getRekeningById(idTarik);
                    if (rekeningTarik != null) {
                        System.out.print("Jumlah tarik: ");
                        double jumlah = scanner.nextDouble();
                        if (jumlah > rekeningTarik.getSaldo()) {
                            System.out.println("Saldo tidak mencukupi.");
                        } else {
                            rekeningTarik.tarik(jumlah);
                            ops.updateSaldo(idTarik, rekeningTarik.getSaldo());
                            transaksiOps.tarikTunai(idTarik, jumlah); // Pakai metode yang sesuai
                        }
                    } else {
                        System.out.println("Rekening tidak ditemukan.");
                    }
                    break;

                case 5:
                    System.out.print("Masukkan ID rekening: ");
                    int idLihat = scanner.nextInt();
                    transaksiOps.tampilkanTransaksi(idLihat);
                    break;

                case 0:
                    System.out.println("Terima kasih!");
                    break;

                default:
                    System.out.println("Pilihan tidak valid!");
            }
        } while (pilihan != 0);

        scanner.close();
    }
}
