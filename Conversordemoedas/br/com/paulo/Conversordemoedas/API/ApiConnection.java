package br.com.paulo.ConversorDeMoedas.API;

import br.com.paulo.ConversorDeMoedas.logs.Log;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiConnection {
    private String apikey = System.getenv("API_KEY");//COLOQUE SUA API KEY AQUI OU ADICIONE .ENV AO SEU PROJETO
    private String exchangeUri = "https://v6.exchangerate-api.com/v6/";

    // Método para conectar-se à API de conversão de moedas e obter o resultado da conversão
    public void Connection(String currency, String currencyPair, String value, Log log) {
        try {
            HttpClient client = HttpClient.newHttpClient();
            // Constrói a requisição HTTP para a API de conversão de moedas
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(exchangeUri + apikey + "/pair/" + currency + "/" + currencyPair + "/" + value))
                    .build();
            // Envia a requisição HTTP e obtém a resposta
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            // Instancia a classe Exchange para manipular o resultado da conversão
            Exchange currencyExchange = new Exchange();
            // Chama o método para imprimir o resultado da conversão e registrar no histórico
            currencyExchange.printExchange(response.body(), currency, currencyPair, log);

        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }



}
