//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.CuentaEquipoIngenieroDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.CuentaEquipoIngeniero;
import org.springframework.stereotype.Component;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 22/12/2025.
* Declaración del método DAO.
*/
@Component//DECLARACIÓN DEL COMPONENTE PARA LOS METODOS DEL DAO.
public class CuentaEquipoIngenieroDAO {
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 22/12/2025.
    * @param cuentaEquipoIngenieroDTO
    * Recibe un DTO para crear un objeto cuentaEquipoIngeniero.
    * @return cuentaEquipoIngeniero
    */
    public CuentaEquipoIngeniero cuentaEquipoIngeniero(CuentaEquipoIngenieroDTO cuentaEquipoIngenieroDTO){
        CuentaEquipoIngeniero cuentaEquipoIngeniero = new CuentaEquipoIngeniero();
        cuentaEquipoIngeniero.setIdCuentaEquipoIngeniero(cuentaEquipoIngenieroDTO.getIdCuentaEquipoIngeniero());
        cuentaEquipoIngeniero.setNombreCuentaEquipoIngeniero(cuentaEquipoIngenieroDTO.getNombreCuentaEquipoIngeniero().toUpperCase());
        cuentaEquipoIngeniero.setNumeroCuentaEquipoIngeniero(cuentaEquipoIngenieroDTO.getNumeroCuentaEquipoIngeniero().toUpperCase());
        return cuentaEquipoIngeniero;
    }
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 22/12/2025.
    * @param cuentaEquipoIngeniero
    * Recibe un DTO para un objeto cuentaEquipoIngeniero para crear un DTO.
    * @return cuentaEquipoIngenieroDTO
    */
    public CuentaEquipoIngenieroDTO cuentaEquipoIngenieroDTO(CuentaEquipoIngeniero cuentaEquipoIngeniero){
        CuentaEquipoIngenieroDTO cuentaEquipoIngenieroDTO = new CuentaEquipoIngenieroDTO();
        cuentaEquipoIngenieroDTO.setIdCuentaEquipoIngeniero(cuentaEquipoIngeniero.getIdCuentaEquipoIngeniero());
        cuentaEquipoIngenieroDTO.setNombreCuentaEquipoIngeniero(cuentaEquipoIngeniero.getNombreCuentaEquipoIngeniero().toUpperCase());
        cuentaEquipoIngenieroDTO.setNumeroCuentaEquipoIngeniero(cuentaEquipoIngeniero.getNumeroCuentaEquipoIngeniero().toUpperCase());
        return cuentaEquipoIngenieroDTO;
    }
}
