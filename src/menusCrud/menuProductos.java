package src.menusCrud;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import src.models.Categoria;
import src.models.Producto;
import src.models.comun.DbController;
import src.models.comun.DbObject;

public class menuProductos {
	
	
	private boolean salir;
	private int opcion;

	public Scanner keyboard = new Scanner(System.in);
	List<DbObject> productosLista = new ArrayList<>();
	
	public menuProductos() {
		
	}
	
	public void display() {
	
	Scanner keyboard = new Scanner(System.in);
	do {
		System.out.println("~~~~~~~~~~MENÚ_PRODUCTOS~~~~~~~~~\n");
		System.out.println("1.-Añadir\n2.-Leer\n3.-Actualizar\n4.-Eliminar\n5.-VUELTA AL MENU MAIN\n");
		System.out.println("Seleccione(1|2|3|4|5): ");

		opcion = Integer.parseInt(keyboard.nextLine());
		salir = false;
		switch (opcion) { 

		case 1:
			System.out.println("Añadir\n");
			crearCat();
			//añadirProductos();
			break;
		case 2:
			System.out.println("Leer\n");
			//leerProductos();
			readCat();
			break;
		case 3:
			System.out.println("Actualizar\n");// actualizarProductos();
			actualizaCategorias();
			break;
		case 4:
			System.out.println("Eliminar\n");// elminiarProductos();
			deleteCategorias();
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
	
	public void crearCat() {
		Producto pro = new Producto();
		System.out.println("Teclee el nombre del nuevo producto :");
		String productoNuevo = keyboard.nextLine();
		pro.setNombre(productoNuevo);
		System.out.println("teclee el id de la cateogira del producto");
		String idCat = keyboard.nextLine();
		pro.setId_categoria(Integer.parseInt(idCat));
		System.out.println("teclee el precio del produicto");
		String precio = keyboard.nextLine();
		pro.setPrecio(Integer.parseInt(precio));
		System.out.println("introduce el stock de productos");
		String stcokproducto = keyboard.nextLine();
		pro.setStock(Integer.parseInt(stcokproducto));
		
		
		pro.save();
		System.out.println("Listo, el apso de introducir una categoria realizado");

	}

	public void readCat() {

		Producto prd = new Producto();
		productosLista = prd.list();
		for (int i = 0; i < productosLista.size(); i++) {
			System.out.println(productosLista.get(i));

		}

	}

	public void actualizaCategorias() {
		Producto prd= new Producto();
		String updateNombre;
		String opcion;
		System.out.println("que quieres actualizar capullo");
		productosLista = prd.list();
		for (int i = 0; i < productosLista.size(); i++) {
			System.out.println(productosLista.get(i));

		}
		productosLista = prd.list();
		
		updateNombre = keyboard.nextLine();
		prd.getByid(Integer.parseInt(updateNombre));

		prd = (Producto) productosLista.get(Integer.parseInt(updateNombre));
		System.out.println("introduce el nuevo nombre");
		opcion = keyboard.nextLine();
		//int cambiaNombre = Integer.parseInt(opcion);
		prd.setNombre(opcion);
		DbController.getInstance().doUpdate(prd);
		
		//cat.setNombre(opcion);
		//cat.save();;

	}

	public void deleteCategorias() {
		Producto prd = new Producto();
		String deleteando;
		System.out.println("que quieres borrar ");
		productosLista = prd.list();
		for (int i = 0; i < productosLista.size(); i++) {
			System.out.println(productosLista.get(i));

		}
		deleteando = keyboard.nextLine();

		int delete = Integer.parseInt(deleteando);
		productosLista.get(delete).delete();

	}
}
