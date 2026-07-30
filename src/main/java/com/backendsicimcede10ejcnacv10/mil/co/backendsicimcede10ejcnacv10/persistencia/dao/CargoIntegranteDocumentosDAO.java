//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.CargoIntegranteDocumentosDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.CargoIntegranteDocumentos;
import org.springframework.stereotype.Component;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 17/12/2025.
* Declaración del método DAO.
*/
@Component//DECLARACIÓN DEL COMPONENTE PARA LOS METODOS DEL DAO.
public class CargoIntegranteDocumentosDAO {
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 17/12/2025.
    * @param cargoIntegranteDocumentosDTO
    * Recibe un DTO para crear un objeto cargoIntegranteDocumentos.
    * @return cargoIntegranteDocumentos
    */
    public CargoIntegranteDocumentos cargoIntegranteDocumentos(CargoIntegranteDocumentosDTO cargoIntegranteDocumentosDTO){
        CargoIntegranteDocumentos cargoIntegranteDocumentos = new CargoIntegranteDocumentos();
        cargoIntegranteDocumentos.setIdCargoIntegranteDocumentos(cargoIntegranteDocumentosDTO.getIdCargoIntegranteDocumentos());
        cargoIntegranteDocumentos.setNombreCargoIntegranteDocumentos(cargoIntegranteDocumentosDTO.getNombreCargoIntegranteDocumentos().toUpperCase());
        
        return cargoIntegranteDocumentos;
    }
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 17/12/2025.
    * @param cargoIntegranteDocumentos
    * Recibe un DTO para un objeto cargoIntegranteDocumentos para crear un DTO.
    * @return cargoIntegranteDocumentosDTO
    */
    public CargoIntegranteDocumentosDTO cargoIntegranteDocumentosDTO(CargoIntegranteDocumentos cargoIntegranteDocumentos){
        CargoIntegranteDocumentosDTO cargoIntegranteDocumentosDTO = new CargoIntegranteDocumentosDTO();
        cargoIntegranteDocumentosDTO.setIdCargoIntegranteDocumentos(cargoIntegranteDocumentos.getIdCargoIntegranteDocumentos());
        cargoIntegranteDocumentosDTO.setNombreCargoIntegranteDocumentos(cargoIntegranteDocumentos.getNombreCargoIntegranteDocumentos().toUpperCase());
        
        return cargoIntegranteDocumentosDTO;
    }
}
