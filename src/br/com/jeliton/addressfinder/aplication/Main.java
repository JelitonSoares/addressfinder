package br.com.jeliton.addressfinder.aplication;

import br.com.jeliton.addressfinder.domain.Address;
import br.com.jeliton.addressfinder.domain.Converter;
import br.com.jeliton.addressfinder.domain.FileCreator;
import br.com.jeliton.addressfinder.domain.SearchCEP;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {

        SearchCEP searchCEP = new SearchCEP();

        searchCEP.search("01001000");
        Converter converter = new Converter();


        converter.toAddress(searchCEP.getCepFound());

        Address myAddress = converter.getAddress();

        converter.toJson(myAddress);

        String myJson = converter.getJson();

        System.out.println(myJson);
        System.out.println(myAddress);

        List<String> list = new ArrayList<>();

        list.add(myJson);

        FileCreator fileCreator = new FileCreator();

        fileCreator.createFile(list.toString(), "cep.json");

    }
}
