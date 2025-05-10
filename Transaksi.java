/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kasirbank;

import java.util.Date;

public class Transaksi {
    private int rekeningId;
    private String tipe;
    private double jumlah;
    private Date tanggal;

    public Transaksi(int rekeningId, String tipe, double jumlah, Date tanggal) {
        this.rekeningId = rekeningId;
        this.tipe = tipe;
        this.jumlah = jumlah;
        this.tanggal = tanggal;
    }

    public int getRekeningId() {
        return rekeningId;
    }

    public String getTipe() {
        return tipe;
    }

    public double getJumlah() {
        return jumlah;
    }

    public Date getTanggal() {
        return tanggal;
    }
}

