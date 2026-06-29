/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exception;

/**
 *
 * @author jamil
 */
public class KamarTidakDitemukanException extends Exception {

    public KamarTidakDitemukanException(String nomorKamar) {

        super("Kamar " + nomorKamar + " tidak ditemukan.");
    }
}
