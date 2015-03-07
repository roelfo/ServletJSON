/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.a00s.controller;

import com.a00s.util.ReplaceCaracteres;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Serializable;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import net.sf.json.JSONArray;

/**
 *
 * @author Rodrigo
 */
@ManagedBean
@ViewScoped
public class ChamaServlet implements Serializable{

    private String nome;
    private String sobrenome;
    private String algo;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        HashMap t = new HashMap();
        t.toString();
    }

    public void chamada() {
        HashMap map = new HashMap();
        map.put("nome", ReplaceCaracteres.remove(nome));
        map.put("sobrenome", ReplaceCaracteres.remove(sobrenome));
        map.put("algo", ReplaceCaracteres.remove(algo));
        try {
            executaEscrita(map);
        } catch (Exception e) {
        }

    }

    private void executaEscrita(HashMap map) throws IOException {
        URL url = new URL("http://localhost:8082/MapServlet/ex");
        URLConnection connection = url.openConnection();
        connection.setDoOutput(true);

        OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
        JSONArray arr = JSONArray.fromObject(map);
        out.write("map=" + arr);

        out.close();
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        in.close();

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getAlgo() {
        return algo;
    }

    public void setAlgo(String algo) {
        this.algo = algo;
    }

}
