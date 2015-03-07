/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.a00s.util;

/**
 *
 * @author Rodrigo
 */
public class ReplaceCaracteres {
    public static String remove(String valor){
        valor = valor.replace("%", "%25");
        valor = valor.replace("?", "%3f");
        valor = valor.replace("<", "%3c");
        valor = valor.replace(">", "%3e");
        valor = valor.replace("&", "%26");
        valor = valor.replace(" ", "%20");
        valor = valor.replace("/", "%2f");
        valor = valor.replace(":", "%3a");
        valor = valor.replace("#", "%23");
        valor = valor.replace("|", "%7c");
        valor = valor.replace(";", "%3b");
        //valor = valor.replace("\"", "%21");
        
        return valor;
    }
}
