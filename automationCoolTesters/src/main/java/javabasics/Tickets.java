package javabasics;

public class Tickets {

	int precio1;
	double precio2;
	double precio3;
	boolean bandera = true;
	char nombre34;

	String nombre;

	public Tickets(int precioMaximo, int precioMinimo) {

		precio1 = precioMaximo - precioMinimo;
		precio2 = precioMaximo - precioMinimo + 3;
		nombre = "Constructor 2";

	}

	// constructor

	public Tickets(int precioMaximo) {

		precio1 = precioMaximo;
		precio2 = precioMaximo * (.85);
		precio3 = precioMaximo * (.5);
		nombre = "Constructor 1";

	}

	public void precioAdulto() {

		System.out.println("El precio del boleto adulto es: " + precio1);

		if (precio1 < 20) {

			System.out.println("No eres Adulto");

		}

		else {

			System.out.println("Ya eres un adutlo");

		}

		System.out.println("El nombre es: " + nombre);

	}

	public void precioEstudiante() {

		System.out.println("El precio del boleto Estudiante es: " + precio2);

	}

	public void precioNino() {

		System.out.println("El precio del boleto Ni�o es : " + precio3);

	}

	public static void main(String[] hola) {

		Tickets precio = new Tickets(20);
		Tickets constructor2 = new Tickets(20, 10);

		precio.precioAdulto();
		precio.precioEstudiante();
		precio.precioNino();

		constructor2.precioAdulto();
		constructor2.precioEstudiante();

	}

}