//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.TipoEventoApoyoRealizadoDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.TipoEventoApoyoRealizado;
import org.springframework.stereotype.Component;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 01/12/2025.
* Declaración del método DAO.
*/
@Component//DECLARACIÓN DEL COMPONENTE PARA LOS METODOS DEL DAO.
public class TipoEventoApoyoRealizadoDAO {
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 01/12/2025.
    * @param tipoEventoApoyoRealizadoDTO
    * Recibe un DTO para crear un objeto tipoEventoApoyoRealizado.
    * @return tipoEventoApoyoRealizado
    */
    public TipoEventoApoyoRealizado tipoEventoApoyoRealizado(TipoEventoApoyoRealizadoDTO tipoEventoApoyoRealizadoDTO){
        TipoEventoApoyoRealizado tipoEventoApoyoRealizado = new TipoEventoApoyoRealizado();
        tipoEventoApoyoRealizado.setIdTipoEventoApoyoRealizado(tipoEventoApoyoRealizadoDTO.getIdTipoEventoApoyoRealizado());
        tipoEventoApoyoRealizado.setNombreTipoEventoApoyoRealizado(tipoEventoApoyoRealizadoDTO.getNombreTipoEventoApoyoRealizado().toUpperCase());
        
        return tipoEventoApoyoRealizado;
    }
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 01/12/2025.
    * @param tipoEventoApoyoRealizado
    * Recibe un DTO para un objeto tipoEventoApoyoRealizado para crear un DTO.
    * @return tipoEventoApoyoRealizadoDTO
    */
    public TipoEventoApoyoRealizadoDTO tipoEventoApoyoRealizadoDTO(TipoEventoApoyoRealizado tipoEventoApoyoRealizado){
        TipoEventoApoyoRealizadoDTO tipoEventoApoyoRealizadoDTO = new TipoEventoApoyoRealizadoDTO();
        tipoEventoApoyoRealizadoDTO.setIdTipoEventoApoyoRealizado(tipoEventoApoyoRealizado.getIdTipoEventoApoyoRealizado());
        tipoEventoApoyoRealizadoDTO.setNombreTipoEventoApoyoRealizado(tipoEventoApoyoRealizado.getNombreTipoEventoApoyoRealizado().toUpperCase());
        
        return tipoEventoApoyoRealizadoDTO;
    }
}
