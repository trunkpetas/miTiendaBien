package src.menusCrud;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import src.models.Categoria;
import src.models.Producto;
import src.models.comun.DbObject;

public class menuProductos {

	private boolean salir;
	private int opcion;

	public Scanner keyboard = new Scanner(System.in);
	List<DbObject> productosLista = new ArrayList<>();
	List<DbObject> categoriasLista = new ArrayList<>();

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
				crearPrd();
				// añadirProductos();
				break;
			case 2:
				System.out.println("Leer\n");
				// leerProductos();
				readPrd();
				break;
			case 3:
				System.out.println("Actualizar\n");// actualizarProductos();
				actualizaPrdo();
				break;
			case 4:
				System.out.println("Eliminar\n");// elminiarProductos();
				deleteProductos();
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

	public void crearPrd() {
		Producto pro = new Producto();
		System.out.println("Teclee el nombre del nuevo producto :");
		String productoNuevo = keyboard.nextLine();
		pro.setNombre(productoNuevo);

		Categoria cat = new Categoria();
		categoriasLista = cat.list();
		for (int i = 0; i < categoriasLista.size(); i++) {
			System.out.println(categoriasLista.get(i).getId() + " " + categoriasLista.get(i));
		}

		System.out.println("teclee el id de la cateogira del producto");
		int idCat = Integer.parseInt(keyboard.nextLine()); 
		pro.setId_categoria(idCat);
		
		System.out.println("teclee el precio del produicto");
		String precio = keyboard.nextLine();
		pro.setPrecio(Integer.parseInt(precio));
		System.out.println("introduce el stock de productos");
		String stcokproducto = keyboard.nextLine();
		pro.setStock(Integer.parseInt(stcokproducto));

		pro.save();
		System.out.println("Listo, el apso de introducir una categoria realizado");

	}

	public void readPrd() {
		Producto prd = new Producto();
		productosLista = prd.list();

		if (productosLista.isEmpty()) {
			System.out.println("Lista vacía no tengo nada que mostrar espabila");
		} else {
			productosLista = prd.list();
			for (int i = 0; i < productosLista.size(); i++) {
				System.out.println(productosLista.get(i).getId() + "." + productosLista.get(i));

			}
		}

	}

	public void actualizaPrdo() {
		
		
		Producto prd = new Producto();
		productosLista = prd.list();
		prd = null;
		if (productosLista.isEmpty()) {
			System.out.println("Lista vacía no tengo nada que actualizar espabila");
		} else {

			
			String updateNombre;
			String nombre;
			System.out.println("que quieres actualizar capullo \n");
		 
			for (int i = 0; i < productosLista.size(); i++) {
				System.out.println(productosLista.get(i).getId() + "." + productosLista.get(i));

			} 

			updateNombre = keyboard.nextLine();
			//(Producto) productosLista.get(Integer.parseInt(updateNombre));
			
			for (DbObject dbObject : productosLista) {
				Producto p = (Producto) dbObject;
				if (p.getId().equals(Integer.parseInt(updateNombre))) {
					prd = p;
					break;
				}
			}
			if(prd == null) {
				actualizaPrdo();
				return;
			}

			// prd = (Producto) productosLista.get(Integer.parseInt(updateNombre));
			System.out.println("introduce el nuevo nombre");
			nombre = keyboard.nextLine();
			prd.setNombre(nombre);
			
			Categoria cat = new Categoria();
			categoriasLista = cat.list();
			for (int i = 0; i < categoriasLista.size(); i++) {
				System.out.println(categoriasLista.get(i).getId() + " " + categoriasLista.get(i));
			}

			System.out.println("teclee el id de la cateogira del producto");
			int idCat = Integer.parseInt(keyboard.nextLine());
			prd.setId_categoria(idCat);

			System.out.println("teclee el precio del produicto");
			String precio = keyboard.nextLine();
			prd.setPrecio(Integer.parseInt(precio));
			System.out.println("introduce el stock de productos");
			String stcokproducto = keyboard.nextLine();
			prd.setStock(Integer.parseInt(stcokproducto));

			// int cambiaNombre = Integer.parseInt(opcion);
			prd.setNombre(nombre);
			prd.save();
			// DbController.getInstance().doUpdate(prd);

			// cat.setNombre(opcion);
			// cat.save();;

		}
	}

	public void deleteProductos() {

		if (productosLista.isEmpty()) {
			System.out.println("Lista vacía no tengo nada que borrar espabila");
		} else {

			Producto prd = new Producto();
			String deleteando;
			System.out.println("que quieres borrar ");
			productosLista = prd.list();
			for (int i = 0; i < productosLista.size(); i++) {
				System.out.println(productosLista.get(i).getId() + "." + productosLista.get(i));

			}
			deleteando = keyboard.nextLine();

			int delete = Integer.parseInt(deleteando);
			productosLista.get(delete).delete();

		}
	}
}
