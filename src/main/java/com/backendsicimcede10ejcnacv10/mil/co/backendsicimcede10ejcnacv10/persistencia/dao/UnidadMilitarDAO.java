//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.UnidadMilitarDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.UnidadMilitar;
import org.springframework.stereotype.Component;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 01/08/2023.
* Declaración del método DAO.
*/
@Component//DECLARACIÓN DEL COMPONENTE PARA LOS METODOS DEL DAO.
public class UnidadMilitarDAO {
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 01/08/2023.
    * @param unidadMilitarDTO
    * Recibe un DTO para crear un objeto unidadMilitar.
    * @return unidadMilitar
    */
    public UnidadMilitar unidadMilitar(UnidadMilitarDTO unidadMilitarDTO){
        UnidadMilitar unidadMilitar = new UnidadMilitar();
        unidadMilitar.setIdUnidadMilitar(unidadMilitarDTO.getIdUnidadMilitar());
        unidadMilitar.setCodigoUnidadMilitar(unidadMilitarDTO.getCodigoUnidadMilitar().toUpperCase());
        unidadMilitar.setNombreUnidadMilitar(normalizarNombreUnidadMilitar(unidadMilitarDTO.getNombreUnidadMilitar()));
        unidadMilitar.setSiglaoAcronimoUnidadMilitar(unidadMilitarDTO.getSiglaoAcronimoUnidadMilitar().toUpperCase());
        unidadMilitar.setNombreArchivoFotoLogExtoFmtUnidadMilitar(unidadMilitarDTO.getNombreArchivoFotoLogExtoFmtUnidadMilitar());
        unidadMilitar.setNombreCarpetaAlmacenamientoUnidadMilitar(unidadMilitarDTO.getNombreCarpetaAlmacenamientoUnidadMilitar().toUpperCase());
        unidadMilitar.setNivelUnidadMilitar(unidadMilitarDTO.getNivelUnidadMilitar().toUpperCase());
        
        return unidadMilitar;
    }
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 01/08/2023.
    * @param unidadMilitar
    * Recibe un DTO para un objeto unidadMilitar para crear un DTO.
    * @return unidadMilitarDTO
    */
    public UnidadMilitarDTO unidadMilitarDTO(UnidadMilitar unidadMilitar){
        UnidadMilitarDTO unidadMilitarDTO = new UnidadMilitarDTO();
        unidadMilitarDTO.setIdUnidadMilitar(unidadMilitar.getIdUnidadMilitar());
        unidadMilitarDTO.setCodigoUnidadMilitar(unidadMilitar.getCodigoUnidadMilitar().toUpperCase());
        unidadMilitarDTO.setNombreUnidadMilitar(normalizarNombreUnidadMilitar(unidadMilitar.getNombreUnidadMilitar()));
        unidadMilitarDTO.setSiglaoAcronimoUnidadMilitar(unidadMilitar.getSiglaoAcronimoUnidadMilitar().toUpperCase());
        unidadMilitarDTO.setNombreArchivoFotoLogExtoFmtUnidadMilitar(unidadMilitar.getNombreArchivoFotoLogExtoFmtUnidadMilitar());
        unidadMilitarDTO.setNombreCarpetaAlmacenamientoUnidadMilitar(unidadMilitar.getNombreCarpetaAlmacenamientoUnidadMilitar().toUpperCase());
        unidadMilitarDTO.setNivelUnidadMilitar(unidadMilitar.getNivelUnidadMilitar().toUpperCase());
        
        return unidadMilitarDTO;
    }
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 21/10/2026.
    * @param nombreUnidadMilitar
    * Convierte el nombre de la unidad militar a mayúscula y deja la abreviatura de número como "No. "
    * (NO., NO, N°, Nº, N.°, NRO. O NUM. SEGUIDO DE UN NÚMERO), EJ: BATALLON DE APOYO Y SERVICIOS PARA EL COMBATE No. 6.
    * @return nombreUnidadMilitar normalizado.
    */
    public static String normalizarNombreUnidadMilitar(String nombreUnidadMilitar){
        if (nombreUnidadMilitar==null) {
           return null;
        }
        return nombreUnidadMilitar.toUpperCase().replaceAll("(^|[^A-ZÁÉÍÓÚÑ])(NO\\.?|N\\.?[°º]\\.?|N\\.|NRO\\.?|NUM\\.?)\\s*(\\d)", "$1No. $3");
    }
}
