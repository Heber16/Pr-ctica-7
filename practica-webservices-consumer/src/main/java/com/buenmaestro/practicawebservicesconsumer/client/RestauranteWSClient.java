/**
 * 
 */
package com.buenmaestro.practicawebservicesconsumer.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.buenmaestro.practicawebservicesconsumer.dto.RestauranteDTO;

/**
 * @author heber
 *
 */
public class RestauranteWSClient {
	
	public static void main(String[] args) {
		
		/** CONSULTA RESTAURANTES
		Client client = ClientBuilder.newClient();
		WebTarget webTarget = client.target("http://localhost:8080/practica-webservices/buenmaestro/restaurantesWS")
				.path("consultarRestaurantes");
		Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON); 
		Response response = invocationBuilder.get();
		System.out.println(response.readEntity(String.class));
	
	**/
	
		//::::::::::POST::::::::::::::::::::
		
				Client client = ClientBuilder.newClient();
			    WebTarget webTarget = client.target("http://localhost:8080/practica-webservices/buenmaestro/restaurantesWS").path("guardarRestaurante");
			    
			    RestauranteDTO res = new RestauranteDTO();
			    res.setIdRestaurante(17L);
			    res.setNombre("Ejemplo");
			    res.setDireccion("Nuevo");
			    res.setSlogan("Slogan");
			    
			    
			    Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
			    Response response = invocationBuilder.post(Entity.entity(res, MediaType.APPLICATION_JSON));
			    
			    if(response.getStatus() == 400) {
			    	String error = response.readEntity(String.class);
			    	System.out.println(error);
			    }
			    
			    if(response.getStatus() == 200) {
			    	RestauranteDTO restauranteDTO = response.readEntity(RestauranteDTO.class);
				    System.out.println(restauranteDTO.getNombre());
			    }
	
	}
	
	
}
