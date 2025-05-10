/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kasirbank;

public class Tabungan extends Rekening {
    public Tabungan(int id, double saldo) {
        super(id, saldo, "Tabungan");
    }

    @Override
    public double hitungBunga() {
        return saldo * 0.02;
    }
}
