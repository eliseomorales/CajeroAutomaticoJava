package com.indra.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Movimiento {
	LocalDateTime fecha;
	double saldo;
	double cantidadRetirada;
	
	public Movimiento(LocalDateTime fecha, double saldo, double cantidadRetirada) {
		super();
		this.fecha = fecha;
		this.saldo = saldo;
		this.cantidadRetirada = cantidadRetirada;
	}
	public LocalDateTime getFecha() {
		return fecha;
	}
	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}
	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public double getCantidadRetirada() {
		return cantidadRetirada;
	}
	public void setCantidadRetirada(double cantidadRetirada) {
		this.cantidadRetirada = cantidadRetirada;
	}
	
	@Override
	public String toString() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formatDateTime = fecha.format(formatter);
        
		return "Movimiento [fecha=" + formatDateTime + ", Saldo Anterior=" + saldo + ", Cantidad Retirada=" + cantidadRetirada + "]";
	}
}
