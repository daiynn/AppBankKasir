/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kasirbank;

public class Giro extends Rekening {
    public Giro(int id, double saldo) {
        super(id, saldo, "Giro");
    }

    @Override
    public double hitungBunga() {
        return saldo * 0.01;
    }
}

