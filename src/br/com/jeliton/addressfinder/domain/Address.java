package br.com.jeliton.addressfinder.domain;

public class Address {
    private String cep;
    private String publicPlace;
    private String complement;
    private String neighborhood;
    private String county;
    private String uf;
    private String codingIbge;
    private String ddd;

    public Address(AddressViaCep addressViaCep) {
        this.cep = addressViaCep.cep();
        this.publicPlace = addressViaCep.logradouro();
        this.complement = addressViaCep.complemento();
        this.neighborhood = addressViaCep.bairro();
        this.county = addressViaCep.localidade();
        this.uf = addressViaCep.uf();
        this.codingIbge = addressViaCep.ibge();
        this.ddd = addressViaCep.ddd();
    }

    public String getCep() {
        return cep;
    }

    public String getPublicPlace() {
        return publicPlace;
    }

    public String getComplement() {
        return complement;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public String getCounty() {
        return county;
    }

    public String getUf() {
        return uf;
    }

    public String getCodingIbge() {
        return codingIbge;
    }

    public String getDdd() {
        return ddd;
    }

    public String toString() {
        return """
                CEP: %s
                LOGRADOURO: %s
                COMPLEMENTO: %s
                BAIRRO: %s
                MUNICÍPIO: %s
                UF: %s
                CÓDIGO IBGE: %s
                DDD: %s""".formatted(this.cep, this.publicPlace, this.complement,
                this.neighborhood, this.county, this.uf, this.codingIbge, this.ddd);
    }
}
