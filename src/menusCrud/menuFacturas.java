package src.menusCrud;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import src.models.Categoria;
import src.models.Clientes;
import src.models.Factura;
import src.models.comun.DbController;
import src.models.comun.DbObject;

public class menuFacturas {
	
	
	private boolean salir;
	private int opcion;

	public Scanner keyboard = new Scanner(System.in);
	List<DbObject> facturasLista = new ArrayList<>();
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	public menuFacturas() {
		
	}
	
	public void display() throws ParseException {
	
	Scanner keyboard = new Scanner(System.in);
	do {
		System.out.println("~~~~~~~~~~MENÚ_FACTURAS~~~~~~~~~\n");
		System.out.println("1.-Añadir\n2.-Leer\n3.-Actualizar\n4.-Eliminar\n5.-VUELTA AL MENU MAIN\n");
		System.out.println("Seleccione(1|2|3|4|5): ");

		opcion = Integer.parseInt(keyboard.nextLine());
		salir = false;
		switch (opcion) {

		case 1:
			System.out.println("Añadir\n");
			//añadirFacturas();
			crearFac();
			break;
		case 2:
			System.out.println("Leer\n");// leerFacturas();
			readFac();
			break;
		case 3:
			System.out.println("Actualizar\n");// actualizarFacturas();
			actualizaFac();
			break;
		case 4:
			System.out.println("VUELTA AL MENU MAIN\n");// eliminarFacturas();
			deleteFacturas();
			break;
		case 5:
			System.out.println("ATRÁS\n");// salirApp();

			salir = true;
			break;
		default:
			System.out.println("ACCION NO VALIDA!\n");
		}
	} while (!salir);
	}
	public void crearFac() throws ParseException {
		Factura fc = new Factura();
		System.out.println("Teclee la fecha de la neuva factura :");
		String fecha = keyboard.nextLine();
		fc.setFecha(sdf.parse(fecha));
		System.out.println("Teclee el id del cliente de la factura :");
		String id = keyboard.nextLine();
		fc.setId_cliente(Integer.parseInt(id));
		System.out.println("Teclee la serie de la factura :");
		String serie = keyboard.nextLine();
		fc.setSerie(Integer.parseInt(serie));
		
		fc.save();
		System.out.println("Listo, el apso de introducir una categoria realizado");

	}

	public void readFac() {

		Factura fl = new Factura();
		facturasLista = fl.list();
		for (int i = 0; i < facturasLista.size(); i++) {
			System.out.println(facturasLista.get(i));

		}

	}

	public void actualizaFac() {
		Factura fc = new Factura();
		String updateNombre;
		String opcion;
		System.out.println("que quieres actualizar capullo");
		facturasLista = fc.list();
		for (int i = 0; i < facturasLista.size(); i++) {
			System.out.println(facturasLista.get(i));

		}
		facturasLista = fc.list();
		
		updateNombre = keyboard.nextLine();
		fc.getByid(Integer.parseInt(updateNombre));

		fc = (Factura) facturasLista.get(Integer.parseInt(updateNombre));
		System.out.println("introduce el nuevo nombre");
		opcion = keyboard.nextLine();
		//int cambiaNombre = Integer.parseInt(opcion);
		//fc.setNombre(opcion);
		DbController.getInstance().doUpdate(fc);
		
		//cat.setNombre(opcion);
		//cat.save();;

	}

	public void deleteFacturas() {
		Factura fc = new Factura();
		String deleteando;
		System.out.println("que quieres borrar ");
		facturasLista = fc.list();
		for (int i = 0; i < facturasLista.size(); i++) {
			System.out.println(facturasLista.get(i));

		}
		deleteando = keyboard.nextLine();

		int delete = Integer.parseInt(deleteando);
		facturasLista.get(delete).delete();

	}

}
