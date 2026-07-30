//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.serviceImpl;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.Constantes.MensajesConstantes;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.SociedadUnidadCentralizadoraDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service.SociedadUnidadCentralizadoraService;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao.SociedadUnidadCentralizadoraDAO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.SociedadUnidadCentralizadora;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.SociedadUnidadCentralizadoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 24/03/2026.
* Esta es la declaración de la implementación del servicio.
* Se inyectan DAOS y repositorios.
*/
@Service//DECLARACIÓN DE LA IMPLEMENTACIÓN DEL SERVICIO.
//DECLARACIÓN DE LA CLASE DE LA IMPLEMENTACIÓN DEL SERVICIO:
public class SociedadUnidadCentralizadoraServiceImpl implements SociedadUnidadCentralizadoraService {
    
    @Autowired//INYECTAMOS EL DAO.
    private SociedadUnidadCentralizadoraDAO sociedadUnidadCentralizadoraDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private SociedadUnidadCentralizadoraRepository sociedadUnidadCentralizadoraRepository;
    
    //CONTAR TOTAL DE REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE CONTEO.
    public Long contarTotalRegistros(Long idSociedadUnidadCentralizadora, String keyword, String siglaoAcronimoUnidadMilitar) {
        return sociedadUnidadCentralizadoraRepository.findTotalRegistros(idSociedadUnidadCentralizadora, keyword, siglaoAcronimoUnidadMilitar);
    }
    
    //LISTAR REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public List<SociedadUnidadCentralizadoraDTO> listarSociedadesUnidadesCentralizadoras(Long idSociedadUnidadCentralizadora, String keyword, String siglaoAcronimoUnidadMilitar, String orderBy, String orderMode) {
        List<SociedadUnidadCentralizadora> sociedadesUnidadesCentralizadoras = sociedadUnidadCentralizadoraRepository.findAllSociedadesUnidadesCentralizadoras(idSociedadUnidadCentralizadora, keyword, siglaoAcronimoUnidadMilitar, orderBy, orderMode);
        List<SociedadUnidadCentralizadoraDTO> sociedadUnidadCentralizadoraDTOS = new ArrayList<>();
        for (SociedadUnidadCentralizadora sociedadUnidadCentralizadora : sociedadesUnidadesCentralizadoras) {
            sociedadUnidadCentralizadoraDTOS.add(sociedadUnidadCentralizadoraDAO.sociedadUnidadCentralizadoraDTO(sociedadUnidadCentralizadora));
        }
        
        return sociedadUnidadCentralizadoraDTOS;
    }
    
    //LISTAR REGISTROS PAGINADOS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS PAGINADOS.
    public Slice<SociedadUnidadCentralizadoraDTO> listarSociedadesUnidadesCentralizadorasPag(Pageable pageable, Long idSociedadUnidadCentralizadora, String keyword, String siglaoAcronimoUnidadMilitar, String orderBy, String orderMode) {
        Slice<SociedadUnidadCentralizadora> sociedadesUnidadesCentralizadoras = sociedadUnidadCentralizadoraRepository.findAllSociedadesUnidadesCentralizadorasPag(pageable, idSociedadUnidadCentralizadora, keyword, siglaoAcronimoUnidadMilitar, orderBy, orderMode);
        return sociedadesUnidadesCentralizadoras.map(sociedadUnidadCentralizadora -> sociedadUnidadCentralizadoraDAO.sociedadUnidadCentralizadoraDTO(sociedadUnidadCentralizadora));
    }
    
    //CREAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE CREAR REGISTRO.
    public RespuestaDTO crearSociedadUnidadCentralizadora(SociedadUnidadCentralizadoraDTO sociedadUnidadCentralizadoraDTO) {
        Long maxIdSociedadUnidadCentralizadora = null;
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_CREADO, false);
        
        //VALIDAR QUE LA UNIDAD MILITAR NO ESTE YA REGISTRADA EN OTRA SOCIEDAD UNIDAD CENTRALIZADORA:
        Optional<SociedadUnidadCentralizadora> sociedadUnidadCentralizadoraUnidadMilitar = sociedadUnidadCentralizadoraRepository.findByIdUnidadMilitar(sociedadUnidadCentralizadoraDTO.getUnidadMilitarDTO().getIdUnidadMilitar());
        if (sociedadUnidadCentralizadoraUnidadMilitar.isPresent() == true) {//SI ENCONTRO LA UNIDAD MILITAR YA REGISTRADA EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE ADVERTENCIA.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_UNIDAD_MILITAR_YA_EXISTE, false);
           return respuestaDTO;
        }
        
        //VALIDAR QUE EL CODIGO DE LA SOCIEDAD DE LA UNIDAD CENTRALIZADORA NO ESTE YA REGISTRADO:
        Optional<SociedadUnidadCentralizadora> sociedadUnidadCentralizadoraCodigo = sociedadUnidadCentralizadoraRepository.findByCodigoSociedadUnidadCentralizadora(sociedadUnidadCentralizadoraDTO.getCodigoSociedadUnidadCentralizadora().toUpperCase());
        if (sociedadUnidadCentralizadoraCodigo.isPresent() == true) {//SI ENCONTRO EL CODIGO YA REGISTRADO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE ADVERTENCIA.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CODIGO_YA_EXISTE, false);
           return respuestaDTO;
        }
        
        maxIdSociedadUnidadCentralizadora = sociedadUnidadCentralizadoraRepository.findMaxIdSociedadUnidadCentralizadora();
        if (maxIdSociedadUnidadCentralizadora == null) {//ESTO SE HACE EN CASO DE QUE SI LA TABLA DE LA BASE DE DATOS ESTA EN BLANCO Y VA SER EL PRIMER REGISTRO AL OBTENER UN VALOR NULO, SE ASIGNE CERO (0) AUTOMÁTICAMENTE.
           maxIdSociedadUnidadCentralizadora = Long.valueOf(0);
        }
        sociedadUnidadCentralizadoraDTO.setIdSociedadUnidadCentralizadora(maxIdSociedadUnidadCentralizadora + 1);//OBTENGO EL ID MAXIMO AUTOMATICO, SUMO (1) ENTERO PARA OBTENER EL NUEVO ID.
        sociedadUnidadCentralizadoraRepository.save(sociedadUnidadCentralizadoraDAO.sociedadUnidadCentralizadora(sociedadUnidadCentralizadoraDTO));
        respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CREADO_EXITO, true);
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR ID:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO POR ID.
    public RespuestaDTO consultarSociedadUnidadCentralizadoraporId(Long idSociedadUnidadCentralizadora) {
        Optional<SociedadUnidadCentralizadora> sociedadUnidadCentralizadoraId = sociedadUnidadCentralizadoraRepository.findByIdSociedadUnidadCentralizadora(Long.valueOf(idSociedadUnidadCentralizadora));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (sociedadUnidadCentralizadoraId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO.setSociedadUnidadCentralizadoraDTO(sociedadUnidadCentralizadoraDAO.sociedadUnidadCentralizadoraDTO(sociedadUnidadCentralizadoraId.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (sociedadUnidadCentralizadoraId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE CONSULTA NO EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setSociedadUnidadCentralizadoraDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR CODIGO DE LA SOCIEDAD DE UNIDAD CENTRALIZADORA (CAMPO ÚNICO):
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO POR CODIGO.
    public RespuestaDTO consultarSociedadUnidadCentralizadoraporCodigo(String codigoSociedadUnidadCentralizadora) {
        Optional<SociedadUnidadCentralizadora> sociedadUnidadCentralizadoraCodigo = sociedadUnidadCentralizadoraRepository.findByCodigoSociedadUnidadCentralizadora(codigoSociedadUnidadCentralizadora);
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CODIGO_NO_ENCONTRADO, false);
        
        if (sociedadUnidadCentralizadoraCodigo.isPresent() == true) {//SI ENCONTRO EL CODIGO DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL CODIGO PROPORCIONADO.
           respuestaDTO.setSociedadUnidadCentralizadoraDTO(sociedadUnidadCentralizadoraDAO.sociedadUnidadCentralizadoraDTO(sociedadUnidadCentralizadoraCodigo.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (sociedadUnidadCentralizadoraCodigo.isPresent() == false) {//SI NO ENCONTRO EL CODIGO DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE CONSULTA NO EXITOSA CON EL CODIGO PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CODIGO_NO_ENCONTRADO, false);
           respuestaDTO.setSociedadUnidadCentralizadoraDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //MODIFICAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE MODIFICAR REGISTRO.
    public RespuestaDTO actualizarSociedadUnidadCentralizadora(SociedadUnidadCentralizadoraDTO sociedadUnidadCentralizadoraDTO) {
        Optional<SociedadUnidadCentralizadora> sociedadUnidadCentralizadoraId = sociedadUnidadCentralizadoraRepository.findByIdSociedadUnidadCentralizadora(sociedadUnidadCentralizadoraDTO.getIdSociedadUnidadCentralizadora());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
        
        if (sociedadUnidadCentralizadoraId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
           //VALIDAR QUE EL CODIGO DE LA SOCIEDAD DE UNIDAD CENTRALIZADORA NO ESTE YA REGISTRADO EN OTRO REGISTRO:
           Optional<SociedadUnidadCentralizadora> sociedadUnidadCentralizadoraCodigo = sociedadUnidadCentralizadoraRepository.findByCodigoSociedadUnidadCentralizadora(sociedadUnidadCentralizadoraDTO.getCodigoSociedadUnidadCentralizadora().toUpperCase());
           if (sociedadUnidadCentralizadoraCodigo.isPresent() == true && !sociedadUnidadCentralizadoraCodigo.get().getIdSociedadUnidadCentralizadora().equals(sociedadUnidadCentralizadoraDTO.getIdSociedadUnidadCentralizadora())) {//SI EL CODIGO PERTENECE A OTRO REGISTRO DIFERENTE AL QUE SE ESTA MODIFICANDO.
              respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CODIGO_YA_EXISTE, false);
              return respuestaDTO;
           }
           //VALIDAR QUE LA UNIDAD MILITAR NO ESTE YA REGISTRADA EN OTRO REGISTRO:
           Optional<SociedadUnidadCentralizadora> sociedadUnidadCentralizadoraUnidadMilitar = sociedadUnidadCentralizadoraRepository.findByIdUnidadMilitar(sociedadUnidadCentralizadoraDTO.getUnidadMilitarDTO().getIdUnidadMilitar());
           if (sociedadUnidadCentralizadoraUnidadMilitar.isPresent() == true && !sociedadUnidadCentralizadoraUnidadMilitar.get().getIdSociedadUnidadCentralizadora().equals(sociedadUnidadCentralizadoraDTO.getIdSociedadUnidadCentralizadora())) {//SI LA UNIDAD MILITAR PERTENECE A OTRO REGISTRO DIFERENTE AL QUE SE ESTA MODIFICANDO.
              respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_UNIDAD_MILITAR_YA_EXISTE, false);
              return respuestaDTO;
           }
           sociedadUnidadCentralizadoraRepository.save(sociedadUnidadCentralizadoraDAO.sociedadUnidadCentralizadora(sociedadUnidadCentralizadoraDTO));
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
        }
        if (sociedadUnidadCentralizadoraId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MUESTRA UN MENSAJE DE REGISTRO NO MODIFICADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
           respuestaDTO.setSociedadUnidadCentralizadoraDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //ELIMINAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE ELIMINAR REGISTRO.
    public RespuestaDTO eliminarSociedadUnidadCentralizadora(Long idSociedadUnidadCentralizadora) {
        Optional<SociedadUnidadCentralizadora> sociedadUnidadCentralizadoraId = sociedadUnidadCentralizadoraRepository.findById(idSociedadUnidadCentralizadora);
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (sociedadUnidadCentralizadoraId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO.setSociedadUnidadCentralizadoraDTO(sociedadUnidadCentralizadoraDAO.sociedadUnidadCentralizadoraDTO(sociedadUnidadCentralizadoraId.get()));
           sociedadUnidadCentralizadoraRepository.delete(sociedadUnidadCentralizadoraId.get());
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ELIMINADO_EXITO, true);
        }
        if (sociedadUnidadCentralizadoraId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS NO ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO NO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setSociedadUnidadCentralizadoraDTO(null);
        }
        
        return respuestaDTO;
    }
}
