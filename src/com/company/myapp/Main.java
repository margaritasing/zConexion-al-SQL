package com.company.myapp;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Sector sector = new Sector();
        Scanner sc = new Scanner(System.in);
        int op = 0;
        System.out.println("Welcome to the sistema");
        do{
            System.out.println("Elija una opción: ");
            System.out.println("1. Mostrar empleados");
            System.out.println("2. Buscar empleado por legajo");
            System.out.println("3. Agregar nuevo empleado");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            op = Integer.parseInt(sc.nextLine());
            switch (op){
                case 1: mostrarEmpleados(sector);break;
                case 2: buscarPorLegajo(sector);break;
                case 3: agregarNuevo(sector);break;
            }
        }while(op!=0);
    }

    private static void agregarNuevo(Sector sector) {
        System.out.println("Vamos a crear un nuevo empleado:");
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el nombre: ");
        String nombre = sc.nextLine();
        System.out.print("Ingrese el apellido: ");
        String apellido = sc.nextLine();
        Empleado empleado = new Empleado(nombre, apellido);
        sector.agregarEmpleado(empleado);
    }

    private static void buscarPorLegajo(Sector sector) {
        System.out.println("\nBuscar empleados \n");
        System.out.print("Ingrese un legajo: ");
        Scanner sc = new Scanner(System.in);
        int legajo = Integer.parseInt(sc.nextLine());
        sector.mostrarEmpleadoPorLegajo(legajo);
    }

    private static void mostrarEmpleados(Sector sector) {
        System.out.println("Empleados: ");
        sector.listarEmpleados();
    }
}
