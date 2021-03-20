package com.company.myapp;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Sector {
    private String dbName = "empresa";
    private String dbUser = "root";
    private String dbPwd = "ange09lina08";

    public void buscarYMostrar(String sql){
        ConexionDB conexionDB = new ConexionDB(dbName,dbUser,dbPwd);
        ResultSet resultados = conexionDB.consultar(sql);
        try{
            mostrarResultados(resultados);
        }catch(SQLException e){
            System.out.println("No se encontraron resultados.");
        }finally {
            conexionDB.cerrar();
        }
    }

    private void mostrarResultados(ResultSet resultados) throws SQLException {
        if(resultados != null)
            while(resultados.next())
                System.out.println("Nombre: "+resultados.getString("nombre"));
    }

    public void mostrarEmpleadoPorLegajo(int legajo){
        buscarYMostrar("SELECT nombre, apellido FROM empleados WHERE legajo = "+legajo);
    }
    public void listarEmpleados() {
        buscarYMostrar("SELECT nombre FROM empleados");
    }

    public boolean agregarEmpleado(Empleado empleado) {
        ConexionDB conexionDB = new ConexionDB(dbName,dbUser,dbPwd);
        String nombre = empleado.getNombre();
        String apellido = empleado.getApellido();
        String sql = "INSERT INTO empleados (nombre, apellido) VALUES ('"+
                nombre + "','"+apellido+"');";
        boolean respuesta = false;
        try {
            respuesta = conexionDB.insertar(sql);
        }catch(SQLException e){
            e.printStackTrace();
            System.out.println("No se pudo agregar al empleado.");
        }finally {
            conexionDB.cerrar();
        }
        return respuesta;
    }
}
