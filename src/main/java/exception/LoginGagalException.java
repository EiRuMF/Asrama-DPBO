package exception;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author IVAN
 */
public class LoginGagalException extends Exception {
    private String emailYangDicoba;
    private int percobaan;

    public LoginGagalException(String emailYangDicoba, int percobaan) {
        // super() untuk mengisi pesan ke parent class Exception
        super("Login gagal untuk email: " + emailYangDicoba + " (percobaan ke-" + percobaan + ")");
        this.emailYangDicoba = emailYangDicoba;
        this.percobaan       = percobaan;
    }

    public String getEmailYangDicoba() { return emailYangDicoba; }
    public int getPercobaan()          { return percobaan; }
}
