package br.com.jeliton.addressfinder.domain;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.security.InvalidParameterException;

public class SearchCEP {
    private String cepFound;

    public String getCepFound() {
        return cepFound;
    }

    public void search (String cep) throws IOException, InterruptedException {

        if (cep.length() == 8) {

            String requestApi = "http://viacep.com.br/ws/" + cep + "/json/";

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(requestApi))
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            this.cepFound = response.body();
        } else throw new InvalidParameterException("Um CEP deve ter 8 (oito) digitos!!");
    }
}
