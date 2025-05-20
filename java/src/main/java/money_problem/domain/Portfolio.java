/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package money_problem.domain;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author depinfo
 */
class Portfolio {
    
    private HashMap<Currency, Double> total;

    Portfolio() {
        this.total = new HashMap<>();
    }

    double evaluate(Bank bank, Currency currency) throws MissingExchangeRateException {
        double total = 0;
        for(Currency c : this.total.keySet()){
           total += bank.convert(this.total.get(c), c, currency);
        }
        return  total;
    }

    void add(double value, Currency currency) {
        double v = 0;
        try{
            v = this.total.get(currency);
        }
        catch(NullPointerException e){
            System.out.println("Devise non connue " + e);
        }
        finally{
           this.total.put(currency, v + value);
        }
    }
    
}
