package br.com.jeliton.addressfinder.service;

import br.com.jeliton.addressfinder.domain.Address;
import br.com.jeliton.addressfinder.domain.AddressViaCep;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;

public class Converter {

    private Gson gson = new GsonBuilder().setPrettyPrinting().create();


    //Implementando o método que converte um objeto Address para json
    public String toJson(Address address) {
        return gson.toJson(address);
    }


    //Método que transforma um json em objeto Address
    public Address toAddress(String json) {

        /*Aqui usamos um bloco try-catch para tratar as exceções e usamos o método fromJson da biblioteca Gson
         * para transformar um json em objeto Address*/
        try {
            AddressViaCep addressViaCep = gson.fromJson(json, AddressViaCep.class);

            return new Address(addressViaCep);

        } catch (JsonSyntaxException exception) {
            System.out.println("Erro na sintaxe do JSON");
            System.out.println(exception.getMessage());
        }

        throw new IllegalStateException("Algo na desserialização deu errado !!");
    }
}
