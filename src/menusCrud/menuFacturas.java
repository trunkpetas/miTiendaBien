package src.menusCrud;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import src.models.Categoria;
import src.models.Clientes;
import src.models.Factura;
import src.models.Producto;
import src.models.comun.DbController;
import src.models.comun.DbObject;

public class menuFacturas {

	private boolean salir;
	private int opcion;

	public Scanner keyboard = new Scanner(System.in);
	List<DbObject> facturasLista = new ArrayList<>();
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

	List<DbObject> clientesLista = new ArrayList<>();

	public menuFacturas() {

	}

	public void display() throws ParseException {

		Scanner keyboard = new Scanner(System.in);
		do {
			System.out.println("~~~~~~~~~~MEN�_FACTURAS~~~~~~~~~\n");
			System.out.println("1.-A�adir\n2.-Leer\n3.-Actualizar\n4.-Eliminar\n5.-VUELTA AL MENU MAIN\n");
			System.out.println("Seleccione(1|2|3|4|5): ");

			opcion = Integer.parseInt(keyboard.nextLine());
			salir = false;
			switch (opcion) {

			case 1:
				System.out.println("A�adir\n");
				// a�adirFacturas();
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
				System.out.println("ATR�S\n");// salirApp();

				salir = true;
				break;
			default:
				System.out.println("ACCION NO VALIDA!\n");
			}
		} while (!salir);
	}

	public void crearFac() throws ParseException {
		Factura fc = new Factura();
		System.out.println("Teclee la fecha de la neuva factura dd/MM/yyyy :");
		String fecha = keyboard.nextLine();
		//fc.setFecha(sdf.parse(fecha));
		fc.setFecha(null);
		Clientes cl = new Clientes();

		clientesLista = cl.list();
		for (int i = 0; i < clientesLista.size(); i++) {
			System.out.println(clientesLista.get(i).getId() + " " + clientesLista.get(i));
		}
		
		System.out.println("Teclee el id del cliente de la factura :");
		int idCl = Integer.parseInt(keyboard.nextLine()); 
		fc.setId_cliente((idCl));
		
		
		
		System.out.println("Teclee la serie de la factura :");
		String serie = keyboard.nextLine();
		fc.setSerie(Integer.parseInt(serie));

		fc.save();
		System.out.println("Listo, el apso de introducir una categoria realizado");

	}

	public void readFac() {
		Factura fl = new Factura();
		facturasLista = fl.list();
		if (facturasLista.isEmpty()) {
			System.out.println("Lista vac�a no tengo nada que leer espabila");
		} else {

			facturasLista = fl.list();
			for (int i = 0; i < facturasLista.size(); i++) {
				System.out.println(facturasLista.get(i).getId() + "." + facturasLista.get(i));

			}
		}

	}

	public void actualizaFac() throws ParseException {
		Factura fc= new Factura();
		facturasLista = fc.list();
		fc = null;
		if (facturasLista.isEmpty()) {
			System.out.println("Lista vac�a no tengo nada que actualizar espabila");
		} else {
			
			String updateNombre;
			String opcion;
			System.out.println("que quieres actualizar capullo");
			for (int i = 0; i < facturasLista.size(); i++) {
				System.out.println(facturasLista.get(i).getId() + "." + facturasLista.get(i));

			}

			updateNombre = keyboard.nextLine();
			// fc = (Factura)fc.getByid(Integer.parseInt(updateNombre));

			for (DbObject dbObject : facturasLista) {
				Factura f = (Factura) dbObject;
				if (f.getId().equals(Integer.parseInt(updateNombre))) {
					fc = f;
					break;
				}
			}
			if(fc == null) {
				actualizaFac();
				return;
			}
			
			//fc = (Factura) facturasLista.get(Integer.parseInt(updateNombre));
			System.out.println("Teclee la fecha de la neuva factura dd/MM/yyyy :");
			String fecha = keyboard.nextLine();
			//fc.setFecha(sdf.parse(fecha));
			fc.setFecha(null);
			
			
			Clientes cl = new Clientes();

			clientesLista = cl.list();
			for (int i = 0; i < clientesLista.size(); i++) {
				System.out.println(clientesLista.get(i).getId() + " " + clientesLista.get(i));
			}
			
			System.out.println("Teclee el id del cliente de la factura :");
			int idCl = Integer.parseInt(keyboard.nextLine()); 
			fc.setId_cliente((idCl));
			System.out.println("Teclee la serie de la factura :");
			String serie = keyboard.nextLine();
			fc.setSerie(Integer.parseInt(serie));
			// System.out.println("introduce el nuevo nombre");
			// opcion = keyboard.nextLine();
			// int cambiaNombre = Integer.parseInt(opcion);
			// fc.setNombre(opcion);
			fc.save();
			// DbController.getInstance().doUpdate(fc);

			// cat.setNombre(opcion);
			// cat.save();;

		}
	}

	public void deleteFacturas() {
		if (facturasLista.isEmpty()) {
			System.out.println("Lista vac�a no tengo nada que borrar espabila");
		} else {
			Factura fc = new Factura();
			String deleteando;
			System.out.println("que quieres borrar ");
			facturasLista = fc.list();
			for (int i = 0; i < facturasLista.size(); i++) {
				System.out.println(facturasLista.get(i).getId() + "." + facturasLista.get(i));

			}
			deleteando = keyboard.nextLine();

			int delete = Integer.parseInt(deleteando);
			facturasLista.get(delete).delete();
		}
	}

}
