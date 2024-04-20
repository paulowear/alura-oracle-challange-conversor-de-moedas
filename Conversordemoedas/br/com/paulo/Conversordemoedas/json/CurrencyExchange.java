package br.com.paulo.ConversorDeMoedas.json;

// Classe de registro que representa os dados de uma resposta JSON da API de conversão de moedas
public record CurrencyExchange(String time_last_update_utc, String conversion_result, String conversion_rate, String time_next_update_utc) {
}
