//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.FuncionalidadInfraestructuraDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.FuncionalidadInfraestructura;
import org.springframework.stereotype.Component;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 16/03/2026.
* Declaración del método DAO.
*/
@Component//DECLARACIÓN DEL COMPONENTE PARA LOS METODOS DEL DAO.
public class FuncionalidadInfraestructuraDAO {
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 16/03/2026.
    * @param funcionalidadInfraestructuraDTO
    * Recibe un DTO para crear un objeto funcionalidadInfraestructura.
    * @return funcionalidadInfraestructura
    */
    public FuncionalidadInfraestructura funcionalidadInfraestructura(FuncionalidadInfraestructuraDTO funcionalidadInfraestructuraDTO){
        FuncionalidadInfraestructura funcionalidadInfraestructura = new FuncionalidadInfraestructura();
        funcionalidadInfraestructura.setIdFuncionalidadInfraestructura(funcionalidadInfraestructuraDTO.getIdFuncionalidadInfraestructura());
        funcionalidadInfraestructura.setNombreFuncionalidadInfraestructura(funcionalidadInfraestructuraDTO.getNombreFuncionalidadInfraestructura().toUpperCase());
        
        return funcionalidadInfraestructura;
    }
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 16/03/2026.
    * @param funcionalidadInfraestructura
    * Recibe un DTO para un objeto funcionalidadInfraestructura para crear un DTO.
    * @return funcionalidadInfraestructuraDTO
    */
    public FuncionalidadInfraestructuraDTO funcionalidadInfraestructuraDTO(FuncionalidadInfraestructura funcionalidadInfraestructura){
        FuncionalidadInfraestructuraDTO funcionalidadInfraestructuraDTO = new FuncionalidadInfraestructuraDTO();
        funcionalidadInfraestructuraDTO.setIdFuncionalidadInfraestructura(funcionalidadInfraestructura.getIdFuncionalidadInfraestructura());
        funcionalidadInfraestructuraDTO.setNombreFuncionalidadInfraestructura(funcionalidadInfraestructura.getNombreFuncionalidadInfraestructura().toUpperCase());
        
        return funcionalidadInfraestructuraDTO;
    }
}
