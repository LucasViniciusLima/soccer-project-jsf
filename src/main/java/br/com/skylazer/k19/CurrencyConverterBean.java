package br.com.skylazer.k19;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

import java.text.DecimalFormat;
import java.util.LinkedHashMap;
import java.util.Map;

@Named("currencyConverterBean")
@RequestScoped
public class CurrencyConverterBean {
    private String from;
    private String to;
    private Double value = 0d;
    private Double result;
    private Map<String, Double> taxes = new LinkedHashMap<>();
    private final DecimalFormat df = new DecimalFormat("#.##");

    public CurrencyConverterBean(){
        this.taxes.put("Real", 1d);
        this.taxes.put("Dollar americano", 5.68d);
        this.taxes.put("Peso Argentino", 0.0048d);
        this.taxes.put("Euro", 6.46d);
    }

    public void convert() {
        final double notFormatedNumber = this.value * this.taxes.get(this.from) / this.taxes.get(this.to);
        this.result = Double.valueOf(df.format(notFormatedNumber));
    }

    public Map<String, Double> getTaxes() {
        return taxes;
    }

    public void setTaxes(Map<String, Double> taxes) {
        this.taxes = taxes;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public Double getResult() {
        return result;
    }

    public void setResult(Double result) {
        this.result = result;
    }
}
