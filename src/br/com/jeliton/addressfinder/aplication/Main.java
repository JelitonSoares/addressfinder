package br.com.jeliton.addressfinder.aplication;

import br.com.jeliton.addressfinder.domain.Address;
import br.com.jeliton.addressfinder.domain.Converter;
import br.com.jeliton.addressfinder.domain.FileCreator;
import br.com.jeliton.addressfinder.domain.SearchCEP;

import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //Instanciando os objetos que vão ser usados
        SearchCEP searchCEP = new SearchCEP();
        Converter converter = new Converter();
        FileCreator fileCreator = new FileCreator();
        Scanner scanner = new Scanner(System.in);
        List<String> list = new ArrayList<>();

        //Variável de controle do loop
        boolean exit = false;

        //Menu
        while (!exit) {
            //Iniciando o programa
            System.out.println("Deseja buscar um CEP? sim(s) não(n)");
            String searchCondition = scanner.nextLine();

            //Condição para que o usário decida se quer sair ou ficar
            if (searchCondition.equalsIgnoreCase("s")) {

                //Caso escolha "s" (sim) o programa solicita um CEP para buscar
                System.out.println("Digite um CEP para busca: ");
                String cep = scanner.nextLine();


                try {
                    /*Aqui eu faço a utilização do bloco try-catch para o tratamento de possíveis erros
                    * de busca e conversão, passando o cep para a classe SearchCEP responsável de buscar
                    * os CEPs e depois convertendo o CEP recebido para um objeto do tipo Address, é feito
                    * também a verificação se o CEP existe através do atributo error que é preenchido como
                    * true caso a API não encontre aquele CEP, caso o CEP exista nós convertemos o objeto
                    * Address em JSON e adicionamos ele a lista de endereços*/

                    searchCEP.search(cep);

                    String myCep = searchCEP.getCepFound();

                    converter.toAddress(myCep);

                    Address myAddress = converter.getAddress();

                    if (myAddress.getError()) {
                        System.out.println("CEP não encontrado!!");
                    } else {
                        converter.toJson(myAddress);
                        String myJson = converter.getJson();
                        list.add(myJson);

                        System.out.println("CEP Buscado com sucesso!!");
                    }

                    //Tratando as exceções
                } catch (IOException | InterruptedException exception) {
                    System.out.println("Ocorreu um erro na busca!!");
                    System.out.println(exception.getMessage());
                } catch (InvalidParameterException exception) {
                    System.out.println("Ocorreu um erro no CEP!!");
                    System.out.println(exception.getMessage());
                }


            } else if (searchCondition.equalsIgnoreCase("n")) {

                /*Caso o usuário escolha "n" (não) o programa grava a lista em um arquivo .json e finaliza, também
                * utilizamos o bloco try-catch para fazer o tratamento de erros*/

                try {
                    fileCreator.createFile(list.toString(), "cep.json");
                    System.out.println("Volte Sempre!!");
                } catch (IOException exception) {
                    System.out.println("Não foi possível abrir o arquivo!!");
                    System.out.println(exception.getMessage());
                } finally {
                    scanner.close();
                    exit = true;
                }

                //Caso nem "s" e nem "n" for escolhido o programa solicita uma opção válida
            } else System.out.println("Digite uma opção válida!!");
        }


    }
}
