package com.example;

import java.io.*;
import java.net.*;
import javax.sound.midi.SysexMessage;

public class ClientStr {
    String nomeServer = "localhost";
    int portaServer = 5556;
    Socket mioSocket;
    BufferedReader tastiera;
    String stringaUtente;
    String stringaRicevutaDalServer;
    DataOutputStream outserver;
    BufferedReader inserver;
    String stringa;

    public void connetti() {
        try {
            System.out.println("client partito");

            tastiera = new BufferedReader(new InputStreamReader(System.in));
            mioSocket = new Socket(nomeServer, portaServer);
            outserver = new DataOutputStream(mioSocket.getOutputStream());
            inserver = new BufferedReader(new InputStreamReader(mioSocket.getInputStream()));

        } catch (Exception e) {

            System.out.println(e.getMessage());
            System.out.println("errore durante la comunicazione col server!");
        }
    }

    public void comunica() {
        try {

            System.out.println("il gioco dell'impiccato");
            System.out.println("0 per iniziare" + '\n');
            stringaUtente = tastiera.readLine();
            System.out.println("1 per lettera" + '\n' + " 2 per parola" + '\n');
            outserver.writeBytes(stringaUtente + '\n');
            stringa = inserver.readLine();
            System.out.println(stringa);

            mioSocket.close();
        } catch (Exception e) {

            System.out.println(e.getMessage());
            System.out.println("errore durante la comunicazione col server!");
        }
    }
}
