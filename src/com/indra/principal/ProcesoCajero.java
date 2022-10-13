package com.indra.principal;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.indra.model.Movimiento;

public class ProcesoCajero {
	
	private Scanner in = new Scanner(System.in);
	private List<Movimiento> listaMovimientos = new ArrayList<>();
	
	public void procesoCajero(){
		double saldo = 1000;
		int opcion = 0;
		System.out.println("¡BIENVENIDO ELISEO!");
		while (opcion != 4){
			System.out.println("\nSelecciona la opción deseada:");
			System.out.println("1. Consultar Saldo");
			System.out.println("2. Retirar Saldo");
			System.out.println("3. Historico de movimientos");
			System.out.println("4. Cerrar sesión");
			
			String op = in.nextLine();
			try {
				opcion = Integer.parseInt(op);
			} catch (Exception e) {
				opcion =0;
			}

			
			switch (opcion) {
			case 1:
				System.out.println("El saldo es: " + saldo);
				System.out.println("\n\tPRESIONE ENTER PARA REGRESAR AL MENU..."); //Mensaje en pantalla
	    		in.nextLine(); //Ahora el programa se detiene hasta que se pulse ENTER
				break;
			case 2:
				saldo = crearMovimiento(saldo);
				break;
			case 3:
				imprimirMovimientos();
				break;
			case 4:
				System.out.println("Se cerró la sesión");
				break;
			default:
				System.out.println("OPCION INVALIDA");
				break;
			}
		}
	}
	
	public double crearMovimiento(double saldo){
		double saldoFinal = 0;
		System.out.println("Ingrese el monto a retirar: ");
		String cantidad = in.nextLine();
		double cantidadRetiro = 0;
		try{
			cantidadRetiro = Double.parseDouble(cantidad);
		}
		catch (Exception e) {
			cantidadRetiro = 0;
			System.out.println("!INGRESE UNA CANTIDAD VALIDA!");
			System.out.println("\n\tPRESIONE ENTER PARA REGRESAR AL MENU..."); 
    		in.nextLine();
    		return saldo;
		}
		if (cantidadRetiro ==0){
			System.out.println("!INGRESE UNA CANTIDAD VALIDA!");
			System.out.println("\n\tPRESIONE ENTER PARA REGRESAR AL MENU..."); 
    		in.nextLine();
    		return saldo;			
		}
		if(cantidadRetiro > saldo){
			System.out.println("Fondos insuficientes!");
    		System.out.println("\n\tPRESIONE ENTER PARA REGRESAR AL MENU..."); //Mensaje en pantalla
    		in.nextLine(); //Ahora el programa se detiene hasta que se pulse ENTER
    		saldoFinal = saldo;
		}
		else{
			saldoFinal = saldo - cantidadRetiro;
			Movimiento movimiento = new Movimiento(LocalDateTime.now(), saldo, cantidadRetiro);
			System.out.println("¡OPERACION EXITOSA!");
			listaMovimientos.add(movimiento);
			System.out.println("\n\tPRESIONE ENTER PARA REGRESAR AL MENU..."); //Mensaje en pantalla
    		in.nextLine(); //Ahora el programa se detiene hasta que se pulse ENTER
		}
		
		return saldoFinal;
	}
	
	public void imprimirMovimientos(){
		for(Movimiento m : listaMovimientos){
			System.out.println(m);
		}
		System.out.println("\n\tPRESIONE ENTER PARA REGRESAR AL MENU..."); //Mensaje en pantalla
		in.nextLine(); //Ahora el programa se detiene hasta que se pulse ENTER
	}

}
