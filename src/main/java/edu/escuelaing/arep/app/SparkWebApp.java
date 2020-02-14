/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.arep.app;


import java.util.Iterator;
import java.util.List;
import static spark.Spark.*;
import spark.Request;
import spark.Response;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author sarah.vieda
 */
public class SparkWebApp {
    
    private static List o;
    
    /**
	 * Este metodo utiliza metodos de SparkWeb y funciones lambda.
	 */
	public static void main (String[]args){
            port(getPort());
            get("/inputdata",(req,res) -> inputDataPage(req,res));
            get("/resultados",(req,res) -> {
                    res.type("application/json");
                    return resultDataPage(req,res);
            });
             
        }
        
        /**
	 * Este metodo recibe los datos que el usuario desea agregar a la Linked List
	 * @param req
	 * @param res
	 * @return pageC
	 */
	private static String inputDataPage(Request req, Response res) {
		String pageC
			="<!DOCTYPE html>" 
			+"<html>"
			+"<body>" 
			+ "<h2>Bandeja de entrada de los numeros:</h2>"
			+ "<h2>(Introduzca los numeros separados por una coma)</h2>" 
			+ "<form action='/resultados\'>" 
			+ "<input type=\"text\" name='data'>"
			+ "<input type=\"submit\" value=\"Continue\">"  
			+ "</form>" 
			+ "</body>"
			+ "</html>";
		return pageC;
	}
        /**
	 * Este metodo retorna la lista ordenada de los datos ingresados en la Linked List
	 * @param req
	 * @param res
	 * @return resp
	 */
	private static JSONObject resultDataPage(Request req, Response res) {
                JSONObject resp = new JSONObject();
                JSONArray array = new JSONArray();
		String [] valores=req.queryParams("data").split(",");
		int[] l = new int [valores.length];
                int temp = 0;
                for (String i:valores){
                   int entero = Integer.parseInt(i);
                   l[temp]=entero;
                   temp++;
                }
		Ordena.mergeSort(l,l.length);
                //Ordena.retornaSuma(l);
                for(int j:l){
                    array.add(j);
                }
                resp.put("Lista de valores", array);
                //sumatoria
                resp.put("Sumatoria",Ordena.retornaSuma(l));
                
		
		
		return resp;
	
	}

        static int getPort(){
        if (System.getenv("PORT")!=null){
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }
    
}
