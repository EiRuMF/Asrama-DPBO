/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exception;

/**
 *
 * @author IVAN
 */
public class KamarPenuhException extends Exception{
    private String kamarId;

    public KamarPenuhException(String kamarId) {
        super("Kamar sudah penuh, tidak bisa menambah mahasiswa lagi.");
        this.kamarId = kamarId;
    }        

    public String getKamarId() {
        return kamarId;
    }
}
