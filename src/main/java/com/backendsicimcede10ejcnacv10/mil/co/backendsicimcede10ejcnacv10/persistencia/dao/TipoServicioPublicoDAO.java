//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.TipoServicioPublicoDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.TipoServicioPublico;
import org.springframework.stereotype.Component;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 01/12/2025.
* Declaración del método DAO.
*/
@Component//DECLARACIÓN DEL COMPONENTE PARA LOS METODOS DEL DAO.
public class TipoServicioPublicoDAO {
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 01/12/2025.
    * @param tipoServicioPublicoDTO
    * Recibe un DTO para crear un objeto tipoServicioPublico.
    * @return tipoServicioPublico
    */
    public TipoServicioPublico tipoServicioPublico(TipoServicioPublicoDTO tipoServicioPublicoDTO){
        TipoServicioPublico tipoServicioPublico = new TipoServicioPublico();
        tipoServicioPublico.setIdTipoServicioPublico(tipoServicioPublicoDTO.getIdTipoServicioPublico());
        tipoServicioPublico.setNombreTipoServicioPublico(tipoServicioPublicoDTO.getNombreTipoServicioPublico().toUpperCase());
        
        return tipoServicioPublico;
    }
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 01/12/2025.
    * @param tipoServicioPublico
    * Recibe un DTO para un objeto tipoServicioPublico para crear un DTO.
    * @return tipoServicioPublicoDTO
    */
    public TipoServicioPublicoDTO tipoServicioPublicoDTO(TipoServicioPublico tipoServicioPublico){
        TipoServicioPublicoDTO tipoServicioPublicoDTO = new TipoServicioPublicoDTO();
        tipoServicioPublicoDTO.setIdTipoServicioPublico(tipoServicioPublico.getIdTipoServicioPublico());
        tipoServicioPublicoDTO.setNombreTipoServicioPublico(tipoServicioPublico.getNombreTipoServicioPublico().toUpperCase());
        
        return tipoServicioPublicoDTO;
    }
}
