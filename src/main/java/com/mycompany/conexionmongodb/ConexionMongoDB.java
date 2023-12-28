/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.conexionmongodb;

import com.mongodb.MongoClient;
import java.util.List;

/**
 *
 * @author FelipeV
 */
public class ConexionMongoDB {

    public static void main(String[] args) {
        System.out.println("PRUEBA CONEXION MONGODB");
        MongoClient mongo = new MongoClient("localhost",27017);
        
        if(mongo !=null){
            System.out.println("LITA DE LA BASE DE DATOS: ");
            List dbs = mongo.getDatabaseNames();
            for(int i = 0 ; i < dbs.size() ;i++){
            System.out.println(i+ " - " + dbs.get(i));
            }
        } else{
            System.out.println("ERROR: CONEXIÓN NO ESTABLECIDA");
        }
    }
}
