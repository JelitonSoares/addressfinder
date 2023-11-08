package br.com.jeliton.addressfinder.service;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class FileCreator {

    //Implementando o método que usa a biblioteca FileWriter para criar um arquivo que guarda a lista de json
    public void createFile(String text, String file) throws IOException {

        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(text);
        fileWriter.close();
    }

}
