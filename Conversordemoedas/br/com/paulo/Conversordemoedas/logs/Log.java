package br.com.paulo.ConversorDeMoedas.logs;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Log {
    List<String> logList =new ArrayList<>();

    // Método para retornar o histórico de conversões
    public List<String> getLogList() {
        return logList;
    }

    // Método para adicionar uma nova entrada ao histórico de conversões
    public void addtoList(String currency){
        logList.add(log(currency));
    }

    // Método para formatar a entrada no histórico de conversões
    private String log(String currency){
        LocalDateTime timeAndDate = LocalDateTime.now();
        // Cria um DateTimeFormatter para formatar datas e horas no padrão "dia-mês-ano hora:minuto:segundo"
        DateTimeFormatter timeAndDateFormat = DateTimeFormatter.ofPattern("dd-MM-yyy HH:mm:ss");
        return currency.substring(58,currency.length()-150) +
                "\nData e Horário da conversão:\n"+
                timeAndDate.format(timeAndDateFormat)+
                "\n-------------------------------------------";
    }
}
