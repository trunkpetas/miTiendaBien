package src.menusCrud;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import src.models.Categoria;
import src.models.Factura;
import src.models.FacturaLinea;
import src.models.Producto;
import src.models.comun.DbController;
import src.models.comun.DbObject;

public class menuFactura_lineas {

	private boolean salir;
	private int opcion;
	public Scanner keyboard = new Scanner(System.in);
	List<DbObject> facturaLineaLista = new ArrayList<>();
	List<DbObject> facturasLista = new ArrayList<>();

	public menuFactura_lineas() {

	}

	public void display() {

		Scanner keyboard = new Scanner(System.in);
		do {
			System.out.println("~~~~~~~~~~MENÚ_FACTURA_LINEAS~~~~~~~~~\n");
			System.out.println("1.-Añadir\n2.-Leer\n3.-Actualizar\n4.-Eliminar\n5.-VUELTA AL MENU MAIN\n");
			System.out.println("Seleccione(1|2|3|4|5): ");

			opcion = Integer.parseInt(keyboard.nextLine());
			salir = false;
			switch (opcion) {

			case 1:
				System.out.println("Añadir\n");// añadirCategoria();
				crearFacturaLinea();
				break;
			case 2:
				System.out.println("Leer\n");// leerCategoria();
				readFacturaLinea();
				break;
			case 3:
				System.out.println("Actualizar\n");// actualizarCategoria();
				actualizaFacturaLinea();
				break;
			case 4:
				System.out.println("Eliminar\n");// eliminarCategoria();
				deleteFacturaLinea();
				break;
			case 5:
				System.out.println("VUELTA AL MENU MAIN\n");// salirApp();

				salir = true;
				break;
			default:
				System.out.println("ACCION NO VALIDA!\n");
			}
		} while (!salir);
	}

	public void crearFacturaLinea() {
		FacturaLinea fl = new FacturaLinea();
		System.out.println("Teclee el nombre de la neuva lineafac :");
		String factuflNombre = keyboard.nextLine();
		fl.setNombre(factuflNombre);
		
		
		Factura fc = new Factura();
		facturasLista = fc.list();
		for (int i = 0; i < facturasLista.size(); i++) {
			System.out.println(facturasLista.get(i).getId() + " " + facturasLista.get(i));
		}
		
		System.out.println("teclee el id de la factura que le corresponda");
		int idFact = Integer.parseInt(keyboard.nextLine());
		fl.setId_factura(idFact);
		

		System.out.println("Teclee el precio de la neuva lineafac :");
		String factuprecio = keyboard.nextLine();
		fl.setPrecio(Integer.parseInt(factuprecio));
		
		fl.save();
		System.out.println("Listo, el apso de introducir una categoria realizado");

	}

	public void readFacturaLinea() {
		FacturaLinea fl = new FacturaLinea();
		facturaLineaLista = fl.list();

		if (facturaLineaLista.isEmpty()) {
			System.out.println("Lista vacía no tengo nada que leer espabila");
		} else {

			facturaLineaLista = fl.list();
			for (int i = 0; i < facturaLineaLista.size(); i++) {
				System.out.println(facturaLineaLista.get(i).getId() + "." + facturaLineaLista.get(i));

			}
		}

	}

	public void actualizaFacturaLinea() {
		FacturaLinea fl= new FacturaLinea();
		facturaLineaLista = fl.list();
		fl = null;
		
		
		if (facturaLineaLista.isEmpty()) {
			System.out.println("Lista vacía no tengo nada que borrar espabila");
		} else {

			
			String updateNombre;
			String nombreFL;
			System.out.println("que quieres actualizar capullo");
			
			for (int i = 0; i < facturaLineaLista.size(); i++) {
				System.out.println(facturaLineaLista.get(i).getId() + "." + facturaLineaLista.get(i));

			}
			

			updateNombre = keyboard.nextLine();
			// cat = (Categoria) cat.getByid(Integer.parseInt(updateNombre));

			for (DbObject dbObject : facturaLineaLista) {
				FacturaLinea f = (FacturaLinea) dbObject;
				if (f.getId().equals(Integer.parseInt(updateNombre))) {
					fl = f;
					break;
				}
			}
			if(fl == null) {
				actualizaFacturaLinea();
				return;
			}
			
			
			System.out.println("introduce el nuevo nombre");
			nombreFL = keyboard.nextLine();
			fl.setNombre(nombreFL);

			
			System.out.println("teclee el nuevo id de la factura que le corresponda");
			int idFact = Integer.parseInt(keyboard.nextLine());
			fl.setId_factura(idFact);
			

			System.out.println("Teclee el nuevo precio de la neuva lineafac :");
			String factuprecio = keyboard.nextLine();
			fl.setPrecio(Integer.parseInt(factuprecio));
			
			// int cambiaNombre = Integer.parseInt(opcion);
			fl.save();
			// DbController.getInstance().doUpdate(cat);

			// cat.setNombre(opcion);
			// cat.save();;
		}
	}

	public void deleteFacturaLinea() {


		FacturaLinea fl = new FacturaLinea();
		facturaLineaLista = fl.list();
		
		if (facturaLineaLista.isEmpty()) {
			System.out.println("Lista vacía no tengo nada que borrar espabila");
		} else {

			
			String deleteando;
			System.out.println("que quieres borrar ");
			
			for (int i = 0; i < facturaLineaLista.size(); i++) {
				System.out.println(facturaLineaLista.get(i).getId() + "." + facturaLineaLista.get(i));

			}
			deleteando = keyboard.nextLine();

			int delete = Integer.parseInt(deleteando);
			facturaLineaLista.get(delete).delete();

		}
	}

}
