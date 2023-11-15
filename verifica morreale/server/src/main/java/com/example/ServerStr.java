package com.example;
import java.io.*;
import java.net.*;
import java.util.*;
import java.lang.Math;


import javax.sound.midi.SysexMessage;

    public class ServerStr {
        ServerSocket server = null;
        Socket client = null;
        String stringaRicevuta = null;
        BufferedReader inDalClient;
        DataOutputStream outVersoClient;
        String parola;
        String [] arr = {"giovanni","pasta","pirata","Treno","lavagna","computer"};
        

        public Socket attendi(){
            try{
                System.out.println("server partito");

                server = new ServerSocket(5556);

                client = server.accept();

                server.close();

                inDalClient = new BufferedReader(new InputStreamReader(client.getInputStream()));
                outVersoClient = new DataOutputStream(client.getOutputStream());
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            System.out.println("errore durante l'istanza del server");
            System.exit(1);
        }
        return client;
    }

    public void comunica(){
        
        try{

            int numGenerato =(int) (Math.random()*6);

            parola = arr[numGenerato];
            
            stringaRicevuta = inDalClient.readLine();
            System.out.println(stringaRicevuta+'\n');
            outVersoClient.writeBytes(parola);
               
            client.close();
        }   catch(Exception e){}

    }
}