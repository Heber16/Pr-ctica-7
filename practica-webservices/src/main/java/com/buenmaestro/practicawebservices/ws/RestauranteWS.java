/**
 * 
 */
package com.buenmaestro.practicawebservices.ws;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.buenmaestro.practicawebservices.entity.Restaurante;
import com.buenmaestro.practicawebservices.service.RestauranteService;

/**
 * @author heber
 *
 */
@Path("restaurantesWS")
public class RestauranteWS {
	
	private RestauranteService restauranteService = new RestauranteService();
	
	@GET
	@Path("consultarRestaurantes")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public List<Restaurante> consultarRestaurantes() {

		return this.restauranteService.consultarRestaurantes();
	}
	
	@POST
	@Path("guardarRestaurante")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response guardarRestaurante(Restaurante restaurante) {

		if (restaurante == null) {

			return Response.status(400).entity("No se ingresó información del restaurante, favor de capturar sus datos")
					.build();

		}
		
		if (restaurante.getDireccion() == null || restaurante.getDireccion().isEmpty()) {
			return Response.status(400).entity("La dirección del restaurante es requerida").build();
		}

		if (restaurante.getNombre() == null || restaurante.getNombre().isEmpty()) {
			return Response.status(400).entity("El nombre del restaurante es requerido").build();
		}
		GenericEntity<Restaurante> restauranteGeneric = new GenericEntity<Restaurante>(restaurante, Restaurante.class);
		return Response.ok(restauranteGeneric).build();
	}

}
