/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kasirbank;

/**
 *
 * @author wderi
 */


public interface LayananKeuangan {
    void setor(double jumlah);
    void tarik(double jumlah);
    double cekSaldo();
}
