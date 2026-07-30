//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.MaquinariaPesadaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.MaquinariaPesada;
import org.springframework.stereotype.Component;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 17/12/2025.
* Declaración del método DAO.
*/
@Component//DECLARACIÓN DEL COMPONENTE PARA LOS METODOS DEL DAO.
public class MaquinariaPesadaDAO {
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 17/12/2025.
    * @param maquinariaPesadaDTO
    * Recibe un DTO para crear un objeto maquinariaPesada.
    * @return maquinariaPesada
    */
    public MaquinariaPesada maquinariaPesada(MaquinariaPesadaDTO maquinariaPesadaDTO){
        MaquinariaPesada maquinariaPesada = new MaquinariaPesada();
        maquinariaPesada.setIdMaquinariaPesada(maquinariaPesadaDTO.getIdMaquinariaPesada());
        maquinariaPesada.setNombreMaquinariaPesada(maquinariaPesadaDTO.getNombreMaquinariaPesada().toUpperCase());
        maquinariaPesada.setEmpadronamientoMaquinariaPesada(maquinariaPesadaDTO.getEmpadronamientoMaquinariaPesada().toUpperCase());

        return maquinariaPesada;
    }

    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 17/12/2025.
    * @param maquinariaPesada
    * Recibe un DTO para un objeto maquinariaPesada para crear un DTO.
    * @return maquinariaPesadaDTO
    */
    public MaquinariaPesadaDTO maquinariaPesadaDTO(MaquinariaPesada maquinariaPesada){
        MaquinariaPesadaDTO maquinariaPesadaDTO = new MaquinariaPesadaDTO();
        maquinariaPesadaDTO.setIdMaquinariaPesada(maquinariaPesada.getIdMaquinariaPesada());
        maquinariaPesadaDTO.setNombreMaquinariaPesada(maquinariaPesada.getNombreMaquinariaPesada().toUpperCase());
        maquinariaPesadaDTO.setEmpadronamientoMaquinariaPesada(maquinariaPesada.getEmpadronamientoMaquinariaPesada().toUpperCase());

        return maquinariaPesadaDTO;
    }
}
