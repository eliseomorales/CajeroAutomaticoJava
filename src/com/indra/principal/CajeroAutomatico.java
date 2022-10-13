package com.indra.principal;

import java.util.Scanner;

/**
 * 
 * @author Eliseo
 *
 */
public class CajeroAutomatico {

	public static void main(String[] args) {
		/**
		 * Programa principal cajeron automatico
		 */
		ProcesoCajero procesoCajero = new ProcesoCajero();
		Scanner in = new Scanner(System.in);
		//Iniciamos el numero de intentos
		int intento=1;
		String cadena1 = "Ingresa el PIN: ";
		//creamos el ciclo para los intentos
		while(intento <= 3){
			String cadena = intento>1? "PIN Incorrecto\n(Intento "+intento + ") "+cadena1 : cadena1;
			System.out.println(cadena);
			String pin = in.next();
			if (pin.equals("1234"))
				break;
			else
				intento++;
		}
		if (intento > 3){
			System.out.println("PIN INCORRECTO\nSe terminaron los intentos");
			return;
		}
		
		procesoCajero.procesoCajero();
	}
}
