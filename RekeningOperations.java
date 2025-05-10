/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kasirbank;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RekeningOperations {
    private Connection conn = DatabaseConnection.getConnection();

    public void tambahRekening(String jenis, double saldo) {
        try {
            String query = "INSERT INTO rekening (jenis, saldo) VALUES (?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, jenis);
            stmt.setDouble(2, saldo);
            stmt.executeUpdate();
            System.out.println("Rekening berhasil ditambahkan.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Rekening> getSemuaRekening() {
        List<Rekening> list = new ArrayList<>();
        try {
            String query = "SELECT * FROM rekening";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("id");
                String jenis = rs.getString("jenis");
                double saldo = rs.getDouble("saldo");
                if (jenis.equalsIgnoreCase("Tabungan")) {
                    list.add(new Tabungan(id, saldo));
                } else {
                    list.add(new Giro(id, saldo));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void updateSaldo(int id, double saldoBaru) {
        try {
            String query = "UPDATE rekening SET saldo = ? WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setDouble(1, saldoBaru);
            stmt.setInt(2, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Rekening getRekeningById(int id) {
        try {
            String query = "SELECT * FROM rekening WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                String jenis = rs.getString("jenis");
                double saldo = rs.getDouble("saldo");
                return jenis.equalsIgnoreCase("Tabungan") ? new Tabungan(id, saldo) : new Giro(id, saldo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
