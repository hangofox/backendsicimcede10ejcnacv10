//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.TipoEstructuraInfraestructuraArrendadaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.TipoEstructuraInfraestructuraArrendada;
import org.springframework.stereotype.Component;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 01/12/2025.
* Declaración del método DAO.
*/
@Component//DECLARACIÓN DEL COMPONENTE PARA LOS METODOS DEL DAO.
public class TipoEstructuraInfraestructuraArrendadaDAO {
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 01/12/2025.
    * @param tipoEstructuraInfraestructuraArrendadaDTO
    * Recibe un DTO para crear un objeto tipoEstructuraInfraestructuraArrendada.
    * @return tipoEstructuraInfraestructuraArrendada
    */
    public TipoEstructuraInfraestructuraArrendada tipoEstructuraInfraestructuraArrendada(TipoEstructuraInfraestructuraArrendadaDTO tipoEstructuraInfraestructuraArrendadaDTO){
        TipoEstructuraInfraestructuraArrendada tipoEstructuraInfraestructuraArrendada = new TipoEstructuraInfraestructuraArrendada();
        tipoEstructuraInfraestructuraArrendada.setIdTipoEstructuraInfraestructuraArrendada(tipoEstructuraInfraestructuraArrendadaDTO.getIdTipoEstructuraInfraestructuraArrendada());
        tipoEstructuraInfraestructuraArrendada.setNombreTipoEstructuraInfraestructuraArrendada(tipoEstructuraInfraestructuraArrendadaDTO.getNombreTipoEstructuraInfraestructuraArrendada().toUpperCase());
        
        return tipoEstructuraInfraestructuraArrendada;
    }
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 01/12/2025.
    * @param tipoEstructuraInfraestructuraArrendada
    * Recibe un DTO para un objeto tipoEstructuraInfraestructuraArrendada para crear un DTO.
    * @return tipoEstructuraInfraestructuraArrendadaDTO
    */
    public TipoEstructuraInfraestructuraArrendadaDTO tipoEstructuraInfraestructuraArrendadaDTO(TipoEstructuraInfraestructuraArrendada tipoEstructuraInfraestructuraArrendada){
        TipoEstructuraInfraestructuraArrendadaDTO tipoEstructuraInfraestructuraArrendadaDTO = new TipoEstructuraInfraestructuraArrendadaDTO();
        tipoEstructuraInfraestructuraArrendadaDTO.setIdTipoEstructuraInfraestructuraArrendada(tipoEstructuraInfraestructuraArrendada.getIdTipoEstructuraInfraestructuraArrendada());
        tipoEstructuraInfraestructuraArrendadaDTO.setNombreTipoEstructuraInfraestructuraArrendada(tipoEstructuraInfraestructuraArrendada.getNombreTipoEstructuraInfraestructuraArrendada().toUpperCase());
        
        return tipoEstructuraInfraestructuraArrendadaDTO;
    }
}
