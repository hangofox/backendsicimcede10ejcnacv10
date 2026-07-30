//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.FuncionalidadDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.Funcionalidad;
import org.springframework.stereotype.Component;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 01/08/2023.
* Declaración del método DAO.
*/
@Component//DECLARACIÓN DEL COMPONENTE PARA LOS METODOS DEL DAO.
public class FuncionalidadDAO {
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 01/08/2023.
    * @param funcionalidadDTO
    * Recibe un DTO para crear un objeto funcionalidad.
    * @return funcionalidad
    */
    public Funcionalidad funcionalidad(FuncionalidadDTO funcionalidadDTO){
        Funcionalidad funcionalidad = new Funcionalidad();
        funcionalidad.setIdFuncionalidad(funcionalidadDTO.getIdFuncionalidad());
        funcionalidad.setNombreFuncionalidad(funcionalidadDTO.getNombreFuncionalidad().toUpperCase());
        funcionalidad.setNombreIconoMenuPrincipalFuncionalidad(funcionalidadDTO.getNombreIconoMenuPrincipalFuncionalidad());
        funcionalidad.setLabelMenuPrincipalFuncionalidad(funcionalidadDTO.getLabelMenuPrincipalFuncionalidad());
        
        return funcionalidad;
    }
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 01/08/2023.
    * @param funcionalidad
    * Recibe un DTO para un objeto funcionalidad para crear un DTO.
    * @return funcionalidadDTO
    */
    public FuncionalidadDTO funcionalidadDTO(Funcionalidad funcionalidad){
        FuncionalidadDTO funcionalidadDTO = new FuncionalidadDTO();
        funcionalidadDTO.setIdFuncionalidad(funcionalidad.getIdFuncionalidad());
        funcionalidadDTO.setNombreFuncionalidad(funcionalidad.getNombreFuncionalidad().toUpperCase());
        funcionalidadDTO.setNombreIconoMenuPrincipalFuncionalidad(funcionalidad.getNombreIconoMenuPrincipalFuncionalidad());
        funcionalidadDTO.setLabelMenuPrincipalFuncionalidad(funcionalidad.getLabelMenuPrincipalFuncionalidad());
        
        return funcionalidadDTO;
    }
}
