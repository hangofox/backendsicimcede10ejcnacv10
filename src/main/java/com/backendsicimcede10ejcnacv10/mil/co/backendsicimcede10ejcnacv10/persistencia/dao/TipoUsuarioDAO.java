//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.TipoUsuarioDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.TipoUsuario;
import org.springframework.stereotype.Component;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 01/08/2023.
* Declaración del método DAO.
*/
@Component//DECLARACIÓN DEL COMPONENTE PARA LOS METODOS DEL DAO.
public class TipoUsuarioDAO {
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 01/08/2023.
    * @param tipoUsuarioDTO
    * Recibe un DTO para crear un objeto tipoUsuario.
    * @return tipoUsuario
    */
    public TipoUsuario tipoUsuario(TipoUsuarioDTO tipoUsuarioDTO){
        TipoUsuario tipoUsuario = new TipoUsuario();
        tipoUsuario.setIdTipoUsuario(tipoUsuarioDTO.getIdTipoUsuario());
        tipoUsuario.setNombreTipoUsuario(tipoUsuarioDTO.getNombreTipoUsuario().toUpperCase());
        
        return tipoUsuario;
    }
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 01/08/2023.
    * @param tipoUsuario
    * Recibe un DTO para un objeto tipoUsuario para crear un DTO.
    * @return tipoUsuarioDTO
    */
    public TipoUsuarioDTO tipoUsuarioDTO(TipoUsuario tipoUsuario){
        TipoUsuarioDTO tipoUsuarioDTO = new TipoUsuarioDTO();
        tipoUsuarioDTO.setIdTipoUsuario(tipoUsuario.getIdTipoUsuario());
        tipoUsuarioDTO.setNombreTipoUsuario(tipoUsuario.getNombreTipoUsuario().toUpperCase());
        
        return tipoUsuarioDTO;
    }
}
