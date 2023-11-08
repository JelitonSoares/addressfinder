package br.com.jeliton.addressfinder.service;

import java.io.IOException;
import java.net.URI;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.security.InvalidParameterException;

public class SearchCep {

    /*Implementando o método search que faz a busca do CEP através de uma requisição HTTP à API ViaCEP e armazena
    * o json retornado no atributo cepFund
    * lançamos as exceções para trata-las no método main
    * */
    public  String search (String cep) throws IOException, InterruptedException {

        if (cep.length() != 8) {
            throw new InvalidParameterException("cep = 8 digitos");

        } else if (cep == null) {
            throw new NullPointerException("cep = null");

        } else {
            String requestApi = "http://viacep.com.br/ws/" + cep + "/json/";

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(requestApi))
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            return response.body();
        }
    }
}
