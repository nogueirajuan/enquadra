/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.each.enquadra.controller.utils;

import java.math.BigDecimal;
import java.time.Year;
import java.util.Calendar;

/**
 *
 * @author victorluni
 */
public class Util {

    public Integer Calculate(int month, int period) {
        //Integer month = Integer.parseInt(new SimpleDateFormat("MM").format(date.getTime()));
        return (int) (Math.ceil((double) month / (double) period));

    }

    public Integer getCurrentYear() {

        return Year.now().getValue();
    }

    public Integer getCurrentQuad() {
        Calendar c = Calendar.getInstance();
        int month = c.get(Calendar.MONTH) + 1;

        return Calculate(month, 4);
    }
    
    public Integer getCurrentDay(){
        Calendar c = Calendar.getInstance();
        int day = c.get(Calendar.DAY_OF_MONTH);
        return day;
    }
    
    public Integer getCurrentMonth(){
        Calendar c = Calendar.getInstance();
        return c.get(Calendar.MONTH)+1;
    }
    
    
    public BigDecimal string2bigdecimal(String par) {
        BigDecimal result;
        if (!(par.equals(""))) {
            double y = Double.parseDouble(par);
            result = BigDecimal.valueOf(y);
        } else {
            double z = 0.0;
            result = BigDecimal.valueOf(z);
        }

        return result;
    }

}
