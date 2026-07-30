//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10;

//IMPORTACIÓN DE LIBRERIAS:
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/*//DECLARACIÓN DE LA CLASE PRINCIPAL:
@SpringBootApplication
//@EntityScan(basePackages = "com.torrescede10ejcnacv10.mil.co.torrescede10ejcnacv10.persistencia.entity")
public class torresCEDE10ejcnacv10Application {

	public static void main(String[] args) {
		SpringApplication.run(torresCEDE10ejcnacv10Application.class, args);
	}
}*/
//DECLARACIÓN DE LA CLASE PRINCIPAL:
@SpringBootApplication
public class SICIMCEDE10EjcNacv10Application extends SpringBootServletInitializer {
	/**
	* Método requerido para permitir que WebLogic gestione el despliegue del WAR.
	* Sobrescribimos el método configure para registrar esta clase como punto de entrada.
	*/
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(SICIMCEDE10EjcNacv10Application.class);
	}
	public static void main(String[] args) {
		SpringApplication.run(SICIMCEDE10EjcNacv10Application.class, args);
	}
}
/*//DECLARACIÓN DE LA CLASE PRINCIPAL:
@SpringBootApplication
public class torresCEDE10ejcnacv10Application extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(torresCEDE10ejcnacv10Application.class, args);
	}
}*/
