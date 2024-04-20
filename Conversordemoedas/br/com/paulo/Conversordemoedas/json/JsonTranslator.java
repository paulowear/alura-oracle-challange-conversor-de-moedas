package br.com.paulo.ConversorDeMoedas.json;

public class JsonTranslator {
    String conversionResult;
    String conversionRate;
    String lastUpdate;
    String nextUpdate;
    String currency;
    String currencyPair;

    // Construtor da classe para traduzir os dados do objeto CurrencyExchange
    public JsonTranslator(CurrencyExchange exchangeTranslate, String currency, String currencyPair) {
        this.conversionResult = exchangeTranslate.conversion_result();
        this.conversionRate = exchangeTranslate.conversion_rate();
        this.lastUpdate = exchangeTranslate.time_last_update_utc().substring(0,25);
        this.nextUpdate = exchangeTranslate.time_next_update_utc().substring(0,25);
        this.currency = currency;
        this.currencyPair = currencyPair;
    }



    // Sobrescreve a representação da tradução em formato de string
    @Override
    public String toString() {
        return "\n\n\n******************************************************"+
                "\nConvertendo: "+currency+" para "+currencyPair+
                "\n\nValor pós conversão: " + conversionResult+
                "\nTaxa de conversão: " + conversionRate+
                "\nUltima atualização: " + lastUpdate +
                "\nPróxima atualização: " + nextUpdate+
                "\n******************************************************\n\n\n";
    }
}
