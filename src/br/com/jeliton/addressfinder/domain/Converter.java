package br.com.jeliton.addressfinder.domain;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

public class Converter {
    private String json;
    private Address address;

    //Instanciando a biblioteca que realiza a conversão
    Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .create();

    public String getJson() {
        return json;
    }

    public Address getAddress() {
        return address;
    }

    //Implementando o método que converte um objeto Address para json
    public void toJson(Address address) {
          this.json =  gson.toJson(address);
    }


    //Método que transforma um json em objeto Address
    public void toAddress(String json) {


        /*Aqui usamos um bloco try-catch para tratar as exceções e usamos o método fromJson da biblioteca Gson
        * para transformar um json em objeto Address*/
        try {
            AddressViaCep addressViaCep = gson.fromJson(json, AddressViaCep.class);
            this.address = new Address(addressViaCep);
        } catch (JsonSyntaxException exception) {
            System.out.println("Erro na sintaxe do JSON");
            System.out.println(exception.getMessage());
        }

    }
}
