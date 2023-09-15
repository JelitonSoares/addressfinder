package br.com.jeliton.addressfinder.domain;

import java.io.FileWriter;
import java.io.IOException;


public class FileCreator {
    public void createFile(String text, String file) throws IOException {

        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(text);
        fileWriter.close();
    }
}
