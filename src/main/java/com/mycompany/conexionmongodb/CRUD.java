/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.conexionmongodb;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;

/**
 *
 * @author FelipeV
 */
public class CRUD {

    public static void main(String[] args) {
        MongoClient mongo = crearConexion();

        if (mongo != null) {
            DB db = mongo.getDB("ACL");

////INSERTAR 
//               System.out.println("BASE DE DATOS CREADA");
//               insertarUsuario(db, "usuarios", "Felipe", "Velasco");
//               insertarUsuario(db, "usuarios", "Andrea", "Perez");
//               insertarUsuario(db, "usuarios", "Miguel", "Donoso");


//UPDATE
//               System.out.println("ANTES DEL UPDATE");
               mostrarColeccion(db, "usuarios");
//               actualizarDocumento(db, "usuarios","Felipe");
//               System.out.println("DESPUES DEL UPDATE");
//               buscarPorNombre(db, "usuarios", "Felipe");

//ELIMINAR
//              System.out.println("ANTES DEL DELETE");
//              mostrarColeccion(db, "usuarios");
//              borrarDocumento(db, "usuarios", "Velasco");
//              System.out.println("DESPUES DEL DELETE");
//              mostrarColeccion(db, "usuarios");

        }
    }

    public static MongoClient crearConexion() {
        System.out.println("PRUEBA DE CONEXION MONGODB");
        MongoClient mongo = null;

        mongo = new MongoClient("localhost", 27017);
        return mongo;
    }

    //INSERTAR
    public static void insertarUsuario(DB db, String coleccion, String nombre, String apellido) {

        DBCollection colec = db.getCollection(coleccion);

        BasicDBObject documento = new BasicDBObject();
        documento.put("nombre", nombre);
        documento.put("apellido", apellido);

        colec.insert(documento);
    }

    //MOSTRAR
    public static void mostrarColeccion(DB db, String coleccion) {
        DBCollection colec = db.getCollection(coleccion);

        DBCursor cursor = colec.find();

        while (cursor.hasNext()) {
            System.out.println("* " + cursor.next().get("nombre") + " - " + cursor.curr().get("apellido"));

        }
    }

    //BUSCAR POR NOMBRE
    public static void buscarPorNombre(DB db, String coleccion, String nombre) {
        DBCollection colect = db.getCollection(coleccion);

        BasicDBObject consulta = new BasicDBObject();
        consulta.put("nombre", nombre);

        DBCursor cursor = colect.find(consulta);
        while (cursor.hasNext()) {
            System.out.println("-- " + cursor.next().get("nombre") + "  -  " + cursor.curr().get("apellido"));
        }
    }

    //ACTUALIZAR
    public static void actualizarDocumento(DB db, String coleccion, String nombre) {
        DBCollection colec = db.getCollection(coleccion);

        BasicDBObject actualizarApellido = new BasicDBObject();
        actualizarApellido.append("$set", new BasicDBObject().append("apellido", "Velasco"));

        BasicDBObject buscarPorNombre = new BasicDBObject();
        buscarPorNombre.append("nombre", nombre);

        colec.updateMulti(buscarPorNombre, actualizarApellido);
    }

    //ELIMINAR
    public static void borrarDocumento(DB db, String coleccion, String nombre) {
        DBCollection colec = db.getCollection(coleccion);

        colec.remove(new BasicDBObject().append("apellido", nombre));
    }
}
