package src.menusCrud;

import java.text.ParseException;
import java.util.Scanner;

public class menuMain {

	private boolean salir;
	private int opcion;

	public menuMain() {

	}

	public void display() throws ParseException {

		Scanner keyboard = new Scanner(System.in);
		
		//if(opcion ==)
		
		do {
			System.out.println("~~~~~~~~~~MENÚ~~~~~~~~~\n");
			System.out.println("1.-Productos\n2.-Clientes\n3.-Categorias\n4.-Facturas\n5.-FacturasLinea\n6.-Salir\n");
			System.out.println("Seleccione(1|2|3|4|5): ");

			
			opcion = Integer.parseInt(keyboard.nextLine());

			menuCategoria mC = new menuCategoria();
			menuClientes mCl = new menuClientes();
			menuFacturas mF = new menuFacturas();
			menuProductos mP = new menuProductos();
			menuFactura_lineas mfl = new menuFactura_lineas();
			switch (opcion) {

			case 1:
				System.out.println("Productos\n");// productos();
				mP.display();
				break;
			case 2:
				System.out.println("Cosa 1\n");// clientes();
				mCl.display();
				break;
			case 3:
				System.out.println("Cosa 3\n");// categorias();
				mC.display();
				break;
			case 4:
				System.out.println("Cosa 4\n");// facturas();
				mF.display();
				break;
			case 5:
				System.out.println("Cosa 5\n");// facturas();
				mfl.display();
				break;
				
			case 6:
				System.out.println("FUERA\n");// salirApp();
				System.exit(0);

				break;
			default:
				System.out.println("ACCION NO VALIDA!\n");
			}
		} while (true);
	}
}
