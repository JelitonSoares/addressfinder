package br.com.jeliton.addressfinder.domain;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Converter {
    private String json;
    private Address address;

    Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .create();

    public String getJson() {
        return json;
    }

    public Address getAddress() {
        return address;
    }

    public void toJson(Address address) {
          this.json =  gson.toJson(address);
    }

    public void toAddress(String json) {
        AddressViaCep addressViaCep = gson.fromJson(json, AddressViaCep.class);

        this.address = new Address(addressViaCep);
    }
}
