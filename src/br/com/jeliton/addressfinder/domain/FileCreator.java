package br.com.jeliton.addressfinder.domain;

import java.io.FileWriter;
import java.io.IOException;


public class FileCreator {

    //Implementando o método que usa a biblioteca FileWriter para criar um arquivo que guarda a lista de json
    public void createFile(String text, String file) throws IOException {

        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(text);
        fileWriter.close();
    }



}
