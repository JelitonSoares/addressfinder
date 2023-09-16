package br.com.jeliton.addressfinder.domain;

public record AddressViaCep(String cep, String logradouro, String complemento, String bairro, String localidade,
                            String uf, String ibge, String ddd, boolean erro) {
}
