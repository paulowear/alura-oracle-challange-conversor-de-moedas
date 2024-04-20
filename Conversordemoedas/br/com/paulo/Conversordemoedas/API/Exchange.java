package br.com.paulo.ConversorDeMoedas.API;

import br.com.paulo.ConversorDeMoedas.json.CurrencyExchange;
import br.com.paulo.ConversorDeMoedas.json.JsonTranslator;
import br.com.paulo.ConversorDeMoedas.logs.Log;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class Exchange {

    // Método para imprimir o resultado da conversão e registrar no histórico
    public void printExchange(String body, String currency, String currencyPair, Log log) {
        // Cria um objeto Gson para fazer a desserialização do JSON
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
                .setPrettyPrinting()
                .create();
        // Desserializa o corpo da resposta da API para um objeto CurrencyExchange
        CurrencyExchange exchange = gson.fromJson(body, CurrencyExchange.class);
        // Cria um objeto JsonTranslator para traduzir o resultado da conversão
        JsonTranslator currencyExchange = new JsonTranslator(exchange, currency, currencyPair);
        // Imprime o resultado da conversão
        System.out.println(currencyExchange.toString());
        // Adiciona o resultado da conversão ao histórico de conversões
        log.addtoList(currencyExchange.toString());
    }


}
