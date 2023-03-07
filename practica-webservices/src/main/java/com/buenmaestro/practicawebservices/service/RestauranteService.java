/**
 * 
 */
package com.buenmaestro.practicawebservices.service;

import java.util.ArrayList;
import java.util.List;

import com.buenmaestro.practicawebservices.entity.Restaurante;

/**
 * @author heber
 *
 */
public class RestauranteService {
	
	public List<Restaurante> consultarRestaurantes() {
		List<Restaurante> restaurantes = new ArrayList();

		Restaurante restaurante = new Restaurante();
		restaurante.setIdRestaurante(15L);
		restaurante.setNombre("Pizza Hut");
		restaurante.setDireccion("Querétaro");
		restaurante.setSlogan("No hay una pizza mejor");

		Restaurante restauranteNuevo = new Restaurante();
		restauranteNuevo.setIdRestaurante(16L);
		restauranteNuevo.setNombre("Carl's Jr");
		restauranteNuevo.setDireccion("Tlaxcala");
		restauranteNuevo.setSlogan("A comer en serio");

		restaurantes.add(restaurante);
		restaurantes.add(restauranteNuevo);

		return restaurantes;
	}

}
