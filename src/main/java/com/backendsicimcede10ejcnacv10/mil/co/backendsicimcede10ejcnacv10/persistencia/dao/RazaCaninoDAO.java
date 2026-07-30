//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RazaCaninoDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.RazaCanino;
import org.springframework.stereotype.Component;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 16/03/2026.
* Declaración del método DAO.
*/
@Component//DECLARACIÓN DEL COMPONENTE PARA LOS METODOS DEL DAO.
public class RazaCaninoDAO {
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 16/03/2026.
    * @param razaCaninoDTO
    * Recibe un DTO para crear un objeto razaCanino.
    * @return razaCanino
    */
    public RazaCanino razaCanino(RazaCaninoDTO razaCaninoDTO){
        RazaCanino razaCanino = new RazaCanino();
        razaCanino.setIdRazaCanino(razaCaninoDTO.getIdRazaCanino());
        razaCanino.setNombreRazaCanino(razaCaninoDTO.getNombreRazaCanino().toUpperCase());
        
        return razaCanino;
    }
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 16/03/2026.
    * @param razaCanino
    * Recibe un DTO para un objeto razaCanino para crear un DTO.
    * @return razaCaninoDTO
    */
    public RazaCaninoDTO razaCaninoDTO(RazaCanino razaCanino){
        RazaCaninoDTO razaCaninoDTO = new RazaCaninoDTO();
        razaCaninoDTO.setIdRazaCanino(razaCanino.getIdRazaCanino());
        razaCaninoDTO.setNombreRazaCanino(razaCanino.getNombreRazaCanino().toUpperCase());
        
        return razaCaninoDTO;
    }
}
