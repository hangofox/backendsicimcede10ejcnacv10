//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.SeguroDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.Aseguradora;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.Seguro;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.TipoSeguro;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.AseguradoraRepository;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.TipoSeguroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 24/03/2026.
* Declaración del método DAO.
*/
@Component//DECLARACIÓN DEL COMPONENTE PARA LOS METODOS DEL DAO.
public class SeguroDAO {
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private AseguradoraRepository aseguradoraRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private AseguradoraDAO aseguradoraDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private TipoSeguroRepository tipoSeguroRepository;
    
    @Autowired//INYECTAMOS EL DAO.
    private TipoSeguroDAO tipoSeguroDAO;
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 24/03/2026.
    * @param seguroDTO
    * Recibe un DTO para crear un objeto seguro.
    * @return seguro
    */
    public Seguro seguro(SeguroDTO seguroDTO){
        Seguro seguro = new Seguro();
        seguro.setIdSeguro(seguroDTO.getIdSeguro());
        seguro.setFechaHMSInicioSeguro(seguroDTO.getFechaHMSInicioSeguro());
        seguro.setFechaHMSExpiracionSeguro(seguroDTO.getFechaHMSExpiracionSeguro());
        seguro.setEstadoSeguro(seguroDTO.getEstadoSeguro().toUpperCase());
        
        //MAPEAR ASEGURADORA RELACIONADA.
        if (seguroDTO.getAseguradoraDTO() != null && seguroDTO.getAseguradoraDTO().getIdAseguradora() != null) {
           Optional<Aseguradora> aseguradoraFk = aseguradoraRepository.findByIdAseguradora(seguroDTO.getAseguradoraDTO().getIdAseguradora());
           aseguradoraFk.ifPresent(seguro::setAseguradora);
        }
        
        //MAPEAR TIPO SEGURO RELACIONADO.
        if (seguroDTO.getTipoSeguroDTO() != null && seguroDTO.getTipoSeguroDTO().getIdTipoSeguro() != null) {
           Optional<TipoSeguro> tipoSeguroFk = tipoSeguroRepository.findByIdTipoSeguro(seguroDTO.getTipoSeguroDTO().getIdTipoSeguro());
           tipoSeguroFk.ifPresent(seguro::setTipoSeguro);
        }
        
        return seguro;
    }
    
    /**
    * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
    * @Since 24/03/2026.
    * @param seguro
    * Recibe un objeto seguro para crear un DTO.
    * @return seguroDTO
    */
    public SeguroDTO seguroDTO(Seguro seguro){
        SeguroDTO seguroDTO = new SeguroDTO();
        seguroDTO.setIdSeguro(seguro.getIdSeguro());
        seguroDTO.setFechaHMSInicioSeguro(seguro.getFechaHMSInicioSeguro());
        seguroDTO.setFechaHMSExpiracionSeguro(seguro.getFechaHMSExpiracionSeguro());
        seguroDTO.setEstadoSeguro(seguro.getEstadoSeguro().toUpperCase());
        
        //MAPEAR ASEGURADORA RELACIONADA.
        if (seguro.getAseguradora() != null && seguro.getAseguradora().getIdAseguradora() != null) {
           Optional<Aseguradora> aseguradoraFk = aseguradoraRepository.findByIdAseguradora(seguro.getAseguradora().getIdAseguradora());
           aseguradoraFk.ifPresent(aseg -> seguroDTO.setAseguradoraDTO(aseguradoraDAO.aseguradoraDTO(aseg)));
        }
        
        //MAPEAR TIPO SEGURO RELACIONADO.
        if (seguro.getTipoSeguro() != null && seguro.getTipoSeguro().getIdTipoSeguro() != null) {
           Optional<TipoSeguro> tipoSeguroFk = tipoSeguroRepository.findByIdTipoSeguro(seguro.getTipoSeguro().getIdTipoSeguro());
           tipoSeguroFk.ifPresent(tipoSeg -> seguroDTO.setTipoSeguroDTO(tipoSeguroDAO.tipoSeguroDTO(tipoSeg)));
        }
        
        return seguroDTO;
    }
}
