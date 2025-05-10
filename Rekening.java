/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kasirbank;

public abstract class Rekening implements LayananKeuangan {
    protected int id;
    protected double saldo;
    protected String jenis;

    public Rekening(int id, double saldo, String jenis) {
        this.id = id;
        this.saldo = saldo;
        this.jenis = jenis;
    }

    public int getId() {
        return id;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getJenis() {
        return jenis;
    }

    @Override
    public void setor(double jumlah) {
        saldo += jumlah;
    }

    @Override
    public void tarik(double jumlah) {
        if (jumlah <= saldo) {
            saldo -= jumlah;
        } else {
            System.out.println("Saldo tidak cukup.");
        }
    }

    @Override
    public double cekSaldo() {
        return saldo;
    }

    public abstract double hitungBunga();
}
