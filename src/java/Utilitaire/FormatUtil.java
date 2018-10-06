/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilitaire;

import java.text.DecimalFormat;

/**
 *
 * @author pc
 */
public class FormatUtil {
    
    public static String StringAddFormator(String _number_1, String _number_2){
    DecimalFormat df = new DecimalFormat("#.##");
        double result = Double.parseDouble(_number_1.replaceAll(",", "."))+Double.parseDouble(_number_2.replaceAll(",", "."));
        return df.format(result);
    }
    
}
