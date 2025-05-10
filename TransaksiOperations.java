/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kasirbank;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TransaksiOperations {
    private Connection connection;

    public TransaksiOperations() throws SQLException {
        this.connection = DatabaseConnection.getConnection();
    }

    public void setorTunai(int rekeningId, double jumlah) {
        try {
            // Tambah saldo
            String updateSaldo = "UPDATE rekening SET saldo = saldo + ? WHERE id = ?";
            try (PreparedStatement stmt = connection.prepareStatement(updateSaldo)) {
                stmt.setDouble(1, jumlah);
                stmt.setInt(2, rekeningId);
                stmt.executeUpdate();
            }

            // Simpan transaksi
            simpanTransaksi(rekeningId, "setor", jumlah);
            System.out.println("Setor tunai berhasil.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void tarikTunai(int rekeningId, double jumlah) {
        try {
            // Cek saldo dulu
            String cekSaldo = "SELECT saldo FROM rekening WHERE id = ?";
            double saldo = 0;
            try (PreparedStatement stmt = connection.prepareStatement(cekSaldo)) {
                stmt.setInt(1, rekeningId);
                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        saldo = rs.getDouble("saldo");
                    } else {
                        System.out.println("Rekening tidak ditemukan.");
                        return;
                    }
                }
            }

            if (saldo < jumlah) {
                System.out.println("Saldo tidak cukup untuk melakukan penarikan.");
                return;
            }

            // Kurangi saldo
            String updateSaldo = "UPDATE rekening SET saldo = saldo - ? WHERE id = ?";
            try (PreparedStatement stmt = connection.prepareStatement(updateSaldo)) {
                stmt.setDouble(1, jumlah);
                stmt.setInt(2, rekeningId);
                stmt.executeUpdate();
            }

            // Simpan transaksi
            simpanTransaksi(rekeningId, "tarik", jumlah);
            System.out.println("Tarik tunai berhasil.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void simpanTransaksi(int rekeningId, String tipe, double jumlah) throws SQLException {
        String query = "INSERT INTO transaksi (rekening_id, tipe, jumlah) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, rekeningId);
            stmt.setString(2, tipe);
            stmt.setDouble(3, jumlah);
            stmt.executeUpdate();
        }
    }

    public void tampilkanTransaksi(int rekeningId) {
        String query = "SELECT * FROM transaksi WHERE rekening_id = ? ORDER BY tanggal DESC";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, rekeningId);
            try (ResultSet rs = stmt.executeQuery()) {
                System.out.println("Riwayat Transaksi:");
                while (rs.next()) {
                    System.out.println("ID: " + rs.getInt("id") +
                                       ", Tipe: " + rs.getString("tipe") +
                                       ", Jumlah: " + rs.getDouble("jumlah") +
                                       ", Tanggal: " + rs.getTimestamp("tanggal"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void tambahTransaksi(int rekeningId, String tipe, double jumlah) {
    try {
        simpanTransaksi(rekeningId, tipe, jumlah);
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

}
