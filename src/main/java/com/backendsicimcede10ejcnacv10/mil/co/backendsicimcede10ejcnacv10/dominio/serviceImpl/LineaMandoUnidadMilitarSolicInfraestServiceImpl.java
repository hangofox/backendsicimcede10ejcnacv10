//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.serviceImpl;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.Constantes.MensajesConstantes;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.LineaMandoUnidadMilitarSolicInfraestDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service.LineaMandoUnidadMilitarSolicInfraestService;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao.LineaMandoUnidadMilitarSolicInfraestDAO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.LineaMandoUnidadMilitarSolicInfraest;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.LineaMandoUnidadMilitarSolicInfraestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 20/10/2026.
* Esta es la declaración de la implementación del servicio.
* Se inyectan DAOS y repositorios.
*/
@Service//DECLARACIÓN DE LA IMPLEMENTACIÓN DEL SERVICIO.
//DECLARACIÓN DE LA CLASE DE LA IMPLEMENTACIÓN DEL SERVICIO:
public class LineaMandoUnidadMilitarSolicInfraestServiceImpl implements LineaMandoUnidadMilitarSolicInfraestService {
    
    @Autowired//INYECTAMOS EL DAO.
    private LineaMandoUnidadMilitarSolicInfraestDAO lineaMandoUnidadMilitarSolicInfraestDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private LineaMandoUnidadMilitarSolicInfraestRepository lineaMandoUnidadMilitarSolicInfraestRepository;
    
    //CONTADOR DE REGISTROS FILTRADOS.
    //CONTAR TOTAL DE REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE CONTEO.
    public Long contarTotalRegistros(Long idLineaMandoUnidadMilitarSolicInfraest, String keyword, String siglaoAcronimoUnidadMilitar) {
        return lineaMandoUnidadMilitarSolicInfraestRepository.findTotalRegistros(idLineaMandoUnidadMilitarSolicInfraest, keyword, siglaoAcronimoUnidadMilitar);
    }
    
    //LISTADO DE REGISTROS FILTRADOS SIN PAGINACIÓN.
    //LISTAR REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public List<LineaMandoUnidadMilitarSolicInfraestDTO> listarLineasMandosUnidadesMilitaresSolicInfraest(Long idLineaMandoUnidadMilitarSolicInfraest, String keyword, String siglaoAcronimoUnidadMilitar, String orderBy, String orderMode) {
        List<LineaMandoUnidadMilitarSolicInfraest> lineasMandosUnidadesMilitaresSolicInfraest = lineaMandoUnidadMilitarSolicInfraestRepository.findAllLineasMandosUnidadesMilitaresSolicInfraest(idLineaMandoUnidadMilitarSolicInfraest, keyword, siglaoAcronimoUnidadMilitar, orderBy, orderMode);
        List<LineaMandoUnidadMilitarSolicInfraestDTO> lineaMandoUnidadMilitarSolicInfraestDTOS = new ArrayList<>();
        for (LineaMandoUnidadMilitarSolicInfraest lineaMandoUnidadMilitarSolicInfraest : lineasMandosUnidadesMilitaresSolicInfraest) {
            lineaMandoUnidadMilitarSolicInfraestDTOS.add(lineaMandoUnidadMilitarSolicInfraestDAO.lineaMandoUnidadMilitarSolicInfraestDTO(lineaMandoUnidadMilitarSolicInfraest));
        }
        
        return lineaMandoUnidadMilitarSolicInfraestDTOS;
    }
    
    //LISTADO DE REGISTROS FILTRADOS CON PAGINACIÓN.
    //LISTAR REGISTROS PAGINADOS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS PAGINADOS.
    public Slice<LineaMandoUnidadMilitarSolicInfraestDTO> listarLineasMandosUnidadesMilitaresSolicInfraestPag(Pageable pageable, Long idLineaMandoUnidadMilitarSolicInfraest, String keyword, String siglaoAcronimoUnidadMilitar, String orderBy, String orderMode) {
        Slice<LineaMandoUnidadMilitarSolicInfraest> lineasMandosUnidadesMilitaresSolicInfraest = lineaMandoUnidadMilitarSolicInfraestRepository.findAllLineasMandosUnidadesMilitaresSolicInfraestPag(pageable, idLineaMandoUnidadMilitarSolicInfraest, keyword, siglaoAcronimoUnidadMilitar, orderBy, orderMode);
        return lineasMandosUnidadesMilitaresSolicInfraest.map(lineaMandoUnidadMilitarSolicInfraest -> lineaMandoUnidadMilitarSolicInfraestDAO.lineaMandoUnidadMilitarSolicInfraestDTO(lineaMandoUnidadMilitarSolicInfraest));
    }
    
    //CREAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE CREAR REGISTRO.
    public RespuestaDTO crearLineaMandoUnidadMilitarSolicInfraest(LineaMandoUnidadMilitarSolicInfraestDTO lineaMandoUnidadMilitarSolicInfraestDTO) {
        Long maxIdLineaMandoUnidadMilitarSolicInfraest = null;
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_CREADO, false);
        
        //VALIDAR QUE LA UNIDAD MILITAR NO ESTE YA REGISTRADA EN OTRA LÍNEA DE MANDO DE SOLICITUD DE INFRAESTRUCTURA:
        Optional<LineaMandoUnidadMilitarSolicInfraest> lineaMandoUnidadMilitarSolicInfraestUnidadMilitar = lineaMandoUnidadMilitarSolicInfraestRepository.findByIdUnidadMilitar(lineaMandoUnidadMilitarSolicInfraestDTO.getUnidadMilitarDTO().getIdUnidadMilitar());
        if (lineaMandoUnidadMilitarSolicInfraestUnidadMilitar.isPresent() == true) {//SI ENCONTRO LA UNIDAD MILITAR YA REGISTRADA EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE ADVERTENCIA.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_UNIDAD_MILITAR_YA_EXISTE, false);
           return respuestaDTO;
        }
        
        maxIdLineaMandoUnidadMilitarSolicInfraest = lineaMandoUnidadMilitarSolicInfraestRepository.findMaxIdLineaMandoUnidadMilitarSolicInfraest();
        if (maxIdLineaMandoUnidadMilitarSolicInfraest == null) {//ESTO SE HACE EN CASO DE QUE SI LA TABLA DE LA BASE DE DATOS ESTA EN BLANCO Y VA SER EL PRIMER REGISTRO AL OBTENER UN VALOR NULO, SE ASIGNE CERO (0) AUTOMÁTICAMENTE.
           maxIdLineaMandoUnidadMilitarSolicInfraest = Long.valueOf(0);
        }
        lineaMandoUnidadMilitarSolicInfraestDTO.setIdLineaMandoUnidadMilitarSolicInfraest(maxIdLineaMandoUnidadMilitarSolicInfraest + 1);//OBTENGO EL ID MAXIMO AUTOMATICO, SUMO (1) ENTERO PARA OBTENER EL NUEVO ID.
        lineaMandoUnidadMilitarSolicInfraestRepository.save(lineaMandoUnidadMilitarSolicInfraestDAO.lineaMandoUnidadMilitarSolicInfraest(lineaMandoUnidadMilitarSolicInfraestDTO));
        respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CREADO_EXITO, true);
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR ID:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarLineaMandoUnidadMilitarSolicInfraestporId(Long idLineaMandoUnidadMilitarSolicInfraest) {
        Optional<LineaMandoUnidadMilitarSolicInfraest> lineaMandoUnidadMilitarSolicInfraestId = lineaMandoUnidadMilitarSolicInfraestRepository.findByIdLineaMandoUnidadMilitarSolicInfraest(Long.valueOf(idLineaMandoUnidadMilitarSolicInfraest));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (lineaMandoUnidadMilitarSolicInfraestId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO.setLineaMandoUnidadMilitarSolicInfraestDTO(lineaMandoUnidadMilitarSolicInfraestDAO.lineaMandoUnidadMilitarSolicInfraestDTO(lineaMandoUnidadMilitarSolicInfraestId.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (lineaMandoUnidadMilitarSolicInfraestId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE CONSULTA NO EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setLineaMandoUnidadMilitarSolicInfraestDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR LÍNEA DE MANDO Y SIGLA O ACRONIMO DE UNIDAD MILITAR:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarLineaMandoUnidadMilitarSolicInfraestporLineaMandoySiglaoAcronimoUnidadMilitar(String lineaMandoUnidadMilitarSolicInfraest, String siglaoAcronimoUnidadMilitar) {
        Optional<LineaMandoUnidadMilitarSolicInfraest> lineaMandoUnidadMilitarSolicInfraestLineaMando = Optional.ofNullable(lineaMandoUnidadMilitarSolicInfraestRepository.findByLineaMandoUnidadMilitarSolicInfraestAndSiglaoAcronimoUnidadMilitar(String.valueOf(lineaMandoUnidadMilitarSolicInfraest), String.valueOf(siglaoAcronimoUnidadMilitar)));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_LINEA_MANDO_Y_UNIDAD_MILITAR_NO_ENCONTRADOS, false);
        
        if (lineaMandoUnidadMilitarSolicInfraestLineaMando.isPresent() == true) {//SI ENCONTRO LA LÍNEA DE MANDO Y UNIDAD MILITAR DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON LA LÍNEA DE MANDO PROPORCIONADA.
           respuestaDTO.setLineaMandoUnidadMilitarSolicInfraestDTO(lineaMandoUnidadMilitarSolicInfraestDAO.lineaMandoUnidadMilitarSolicInfraestDTO(lineaMandoUnidadMilitarSolicInfraestLineaMando.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (lineaMandoUnidadMilitarSolicInfraestLineaMando.isPresent() == false) {//SI NO ENCONTRO LA LÍNEA DE MANDO Y UNIDAD MILITAR DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE CONSULTA NO EXITOSA CON LA LÍNEA DE MANDO PROPORCIONADA.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_LINEA_MANDO_Y_UNIDAD_MILITAR_NO_ENCONTRADOS, false);
           respuestaDTO.setLineaMandoUnidadMilitarSolicInfraestDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //MODIFICAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE MODIFICAR REGISTRO.
    public RespuestaDTO actualizarLineaMandoUnidadMilitarSolicInfraest(LineaMandoUnidadMilitarSolicInfraestDTO lineaMandoUnidadMilitarSolicInfraestDTO) {
        Optional<LineaMandoUnidadMilitarSolicInfraest> lineaMandoUnidadMilitarSolicInfraestId = lineaMandoUnidadMilitarSolicInfraestRepository.findByIdLineaMandoUnidadMilitarSolicInfraest(lineaMandoUnidadMilitarSolicInfraestDTO.getIdLineaMandoUnidadMilitarSolicInfraest());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
        
        if (lineaMandoUnidadMilitarSolicInfraestId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
           //VALIDAR QUE LA UNIDAD MILITAR NO ESTE YA REGISTRADA EN OTRO REGISTRO:
           Optional<LineaMandoUnidadMilitarSolicInfraest> lineaMandoUnidadMilitarSolicInfraestUnidadMilitar = lineaMandoUnidadMilitarSolicInfraestRepository.findByIdUnidadMilitar(lineaMandoUnidadMilitarSolicInfraestDTO.getUnidadMilitarDTO().getIdUnidadMilitar());
           if (lineaMandoUnidadMilitarSolicInfraestUnidadMilitar.isPresent() == true && !lineaMandoUnidadMilitarSolicInfraestUnidadMilitar.get().getIdLineaMandoUnidadMilitarSolicInfraest().equals(lineaMandoUnidadMilitarSolicInfraestDTO.getIdLineaMandoUnidadMilitarSolicInfraest())) {//SI LA UNIDAD MILITAR PERTENECE A OTRO REGISTRO DIFERENTE AL QUE SE ESTA MODIFICANDO.
              respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_UNIDAD_MILITAR_YA_EXISTE, false);
              return respuestaDTO;
           }
           lineaMandoUnidadMilitarSolicInfraestRepository.save(lineaMandoUnidadMilitarSolicInfraestDAO.lineaMandoUnidadMilitarSolicInfraest(lineaMandoUnidadMilitarSolicInfraestDTO));
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
        }
        if (lineaMandoUnidadMilitarSolicInfraestId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MUESTRA UN MENSAJE DE REGISTRO NO MODIFICADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
           respuestaDTO.setLineaMandoUnidadMilitarSolicInfraestDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //ELIMINAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE ELIMINAR REGISTRO.
    public RespuestaDTO eliminarLineaMandoUnidadMilitarSolicInfraest(Long idLineaMandoUnidadMilitarSolicInfraest) {
        Optional<LineaMandoUnidadMilitarSolicInfraest> lineaMandoUnidadMilitarSolicInfraestId = lineaMandoUnidadMilitarSolicInfraestRepository.findById(idLineaMandoUnidadMilitarSolicInfraest);
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (lineaMandoUnidadMilitarSolicInfraestId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO.setLineaMandoUnidadMilitarSolicInfraestDTO(lineaMandoUnidadMilitarSolicInfraestDAO.lineaMandoUnidadMilitarSolicInfraestDTO(lineaMandoUnidadMilitarSolicInfraestId.get()));
           lineaMandoUnidadMilitarSolicInfraestRepository.delete(lineaMandoUnidadMilitarSolicInfraestId.get());
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ELIMINADO_EXITO, true);
        }
        if (lineaMandoUnidadMilitarSolicInfraestId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS NO ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO NO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setLineaMandoUnidadMilitarSolicInfraestDTO(null);
        }
        
        return respuestaDTO;
    }
}
