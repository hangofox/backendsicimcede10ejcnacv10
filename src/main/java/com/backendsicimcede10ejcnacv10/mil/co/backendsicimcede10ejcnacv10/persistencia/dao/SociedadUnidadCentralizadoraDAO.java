//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.SociedadUnidadCentralizadoraDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.SociedadUnidadCentralizadora;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.UnidadMilitar;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.UnidadMilitarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 24/03/2026.
* Declaración del método DAO.
*/
@Component//DECLARACIÓN DEL COMPONENTE PARA LOS METODOS DEL DAO.
public class SociedadUnidadCentralizadoraDAO {
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private UnidadMilitarRepository unidadMilitarRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private UnidadMilitarDAO unidadMilitarDAO;
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 24/03/2026.
    * @param sociedadUnidadCentralizadoraDTO
    * Recibe un DTO para crear un objeto sociedadUnidadCentralizadora.
    * @return sociedadUnidadCentralizadora
    */
    public SociedadUnidadCentralizadora sociedadUnidadCentralizadora(SociedadUnidadCentralizadoraDTO sociedadUnidadCentralizadoraDTO){
        SociedadUnidadCentralizadora sociedadUnidadCentralizadora = new SociedadUnidadCentralizadora();
        sociedadUnidadCentralizadora.setIdSociedadUnidadCentralizadora(sociedadUnidadCentralizadoraDTO.getIdSociedadUnidadCentralizadora());
        sociedadUnidadCentralizadora.setCodigoSociedadUnidadCentralizadora(sociedadUnidadCentralizadoraDTO.getCodigoSociedadUnidadCentralizadora().toUpperCase());
        
        //MAPEAR UNIDAD MILITAR RELACIONADA.
        if (sociedadUnidadCentralizadoraDTO.getUnidadMilitarDTO() != null && sociedadUnidadCentralizadoraDTO.getUnidadMilitarDTO().getIdUnidadMilitar() != null) {
           Optional<UnidadMilitar> unidadMilitarFk = unidadMilitarRepository.findByIdUnidadMilitar(sociedadUnidadCentralizadoraDTO.getUnidadMilitarDTO().getIdUnidadMilitar());
           unidadMilitarFk.ifPresent(sociedadUnidadCentralizadora::setUnidadMilitar);
        }
        
        return sociedadUnidadCentralizadora;
    }
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 24/03/2026.
    * @param sociedadUnidadCentralizadora
    * Recibe un objeto sociedadUnidadCentralizadora para crear un DTO.
    * @return sociedadUnidadCentralizadoraDTO
    */
    public SociedadUnidadCentralizadoraDTO sociedadUnidadCentralizadoraDTO(SociedadUnidadCentralizadora sociedadUnidadCentralizadora){
        SociedadUnidadCentralizadoraDTO sociedadUnidadCentralizadoraDTO = new SociedadUnidadCentralizadoraDTO();
        sociedadUnidadCentralizadoraDTO.setIdSociedadUnidadCentralizadora(sociedadUnidadCentralizadora.getIdSociedadUnidadCentralizadora());
        sociedadUnidadCentralizadoraDTO.setCodigoSociedadUnidadCentralizadora(sociedadUnidadCentralizadora.getCodigoSociedadUnidadCentralizadora());
        
        //MAPEAR UNIDAD MILITAR RELACIONADA.
        if (sociedadUnidadCentralizadora.getUnidadMilitar() != null && sociedadUnidadCentralizadora.getUnidadMilitar().getIdUnidadMilitar() != null) {
           Optional<UnidadMilitar> unidadMilitarFk = unidadMilitarRepository.findByIdUnidadMilitar(sociedadUnidadCentralizadora.getUnidadMilitar().getIdUnidadMilitar());
           unidadMilitarFk.ifPresent(unidadMilitar -> sociedadUnidadCentralizadoraDTO.setUnidadMilitarDTO(unidadMilitarDAO.unidadMilitarDTO(unidadMilitar)));
        }
        
        return sociedadUnidadCentralizadoraDTO;
    }
}
