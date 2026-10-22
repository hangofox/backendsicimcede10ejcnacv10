//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.serviceImpl;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.Constantes.MensajesConstantes;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.LineaMandoUnidadMilitarDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service.LineaMandoUnidadMilitarService;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao.LineaMandoUnidadMilitarDAO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.LineaMandoUnidadMilitar;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.LineaMandoUnidadMilitarRepository;
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
public class LineaMandoUnidadMilitarServiceImpl implements LineaMandoUnidadMilitarService {
    
    @Autowired//INYECTAMOS EL DAO.
    private LineaMandoUnidadMilitarDAO lineaMandoUnidadMilitarDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private LineaMandoUnidadMilitarRepository lineaMandoUnidadMilitarRepository;
    
    //CONTADOR DE REGISTROS FILTRADOS.
    //CONTAR TOTAL DE REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE CONTEO.
    public Long contarTotalRegistros(Long idLineaMandoUnidadMilitar, String keyword, String siglaoAcronimoUnidadMilitar) {
        return lineaMandoUnidadMilitarRepository.findTotalRegistros(idLineaMandoUnidadMilitar, keyword, siglaoAcronimoUnidadMilitar);
    }
    
    //LISTADO DE REGISTROS FILTRADOS SIN PAGINACIÓN.
    //LISTAR REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public List<LineaMandoUnidadMilitarDTO> listarLineasMandosUnidadesMilitares(Long idLineaMandoUnidadMilitar, String keyword, String siglaoAcronimoUnidadMilitar, String orderBy, String orderMode) {
        List<LineaMandoUnidadMilitar> lineasMandosUnidadesMilitares = lineaMandoUnidadMilitarRepository.findAllLineasMandosUnidadesMilitares(idLineaMandoUnidadMilitar, keyword, siglaoAcronimoUnidadMilitar, orderBy, orderMode);
        List<LineaMandoUnidadMilitarDTO> lineaMandoUnidadMilitarDTOS = new ArrayList<>();
        for (LineaMandoUnidadMilitar lineaMandoUnidadMilitar : lineasMandosUnidadesMilitares) {
            lineaMandoUnidadMilitarDTOS.add(lineaMandoUnidadMilitarDAO.lineaMandoUnidadMilitarDTO(lineaMandoUnidadMilitar));
        }
        
        return lineaMandoUnidadMilitarDTOS;
    }
    
    //LISTADO DE REGISTROS FILTRADOS CON PAGINACIÓN.
    //LISTAR REGISTROS PAGINADOS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS PAGINADOS.
    public Slice<LineaMandoUnidadMilitarDTO> listarLineasMandosUnidadesMilitaresPag(Pageable pageable, Long idLineaMandoUnidadMilitar, String keyword, String siglaoAcronimoUnidadMilitar, String orderBy, String orderMode) {
        Slice<LineaMandoUnidadMilitar> lineasMandosUnidadesMilitares = lineaMandoUnidadMilitarRepository.findAllLineasMandosUnidadesMilitaresPag(pageable, idLineaMandoUnidadMilitar, keyword, siglaoAcronimoUnidadMilitar, orderBy, orderMode);
        return lineasMandosUnidadesMilitares.map(lineaMandoUnidadMilitar -> lineaMandoUnidadMilitarDAO.lineaMandoUnidadMilitarDTO(lineaMandoUnidadMilitar));
    }
    
    //CREAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE CREAR REGISTRO.
    public RespuestaDTO crearLineaMandoUnidadMilitar(LineaMandoUnidadMilitarDTO lineaMandoUnidadMilitarDTO) {
        Long maxIdLineaMandoUnidadMilitar = null;
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_CREADO, false);
        
        //VALIDAR QUE LA UNIDAD MILITAR NO ESTE YA REGISTRADA EN OTRA LÍNEA DE MANDO (LAS RUTAS ALTERNATIVAS VAN EN LA MISMA LÍNEA ENTRE CORCHETES):
        Optional<LineaMandoUnidadMilitar> lineaMandoUnidadMilitarUnidadMilitar = lineaMandoUnidadMilitarRepository.findByIdUnidadMilitar(lineaMandoUnidadMilitarDTO.getUnidadMilitarDTO().getIdUnidadMilitar());
        if (lineaMandoUnidadMilitarUnidadMilitar.isPresent() == true) {//SI ENCONTRO LA UNIDAD MILITAR YA REGISTRADA EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE ADVERTENCIA.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_UNIDAD_MILITAR_YA_EXISTE, false);
           return respuestaDTO;
        }
        
        maxIdLineaMandoUnidadMilitar = lineaMandoUnidadMilitarRepository.findMaxIdLineaMandoUnidadMilitar();
        if (maxIdLineaMandoUnidadMilitar == null) {//ESTO SE HACE EN CASO DE QUE SI LA TABLA DE LA BASE DE DATOS ESTA EN BLANCO Y VA SER EL PRIMER REGISTRO AL OBTENER UN VALOR NULO, SE ASIGNE CERO (0) AUTOMÁTICAMENTE.
           maxIdLineaMandoUnidadMilitar = Long.valueOf(0);
        }
        lineaMandoUnidadMilitarDTO.setIdLineaMandoUnidadMilitar(maxIdLineaMandoUnidadMilitar + 1);//OBTENGO EL ID MAXIMO AUTOMATICO, SUMO (1) ENTERO PARA OBTENER EL NUEVO ID.
        lineaMandoUnidadMilitarRepository.save(lineaMandoUnidadMilitarDAO.lineaMandoUnidadMilitar(lineaMandoUnidadMilitarDTO));
        respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CREADO_EXITO, true);
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR ID:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarLineaMandoUnidadMilitarporId(Long idLineaMandoUnidadMilitar) {
        Optional<LineaMandoUnidadMilitar> lineaMandoUnidadMilitarId = lineaMandoUnidadMilitarRepository.findByIdLineaMandoUnidadMilitar(Long.valueOf(idLineaMandoUnidadMilitar));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (lineaMandoUnidadMilitarId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO.setLineaMandoUnidadMilitarDTO(lineaMandoUnidadMilitarDAO.lineaMandoUnidadMilitarDTO(lineaMandoUnidadMilitarId.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (lineaMandoUnidadMilitarId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE CONSULTA NO EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setLineaMandoUnidadMilitarDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR LÍNEA DE MANDO Y SIGLA O ACRONIMO DE UNIDAD MILITAR:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarLineaMandoUnidadMilitarporLineaMandoySiglaoAcronimoUnidadMilitar(String lineaMandoUnidadMilitar, String siglaoAcronimoUnidadMilitar) {
        Optional<LineaMandoUnidadMilitar> lineaMandoUnidadMilitarLineaMando = Optional.ofNullable(lineaMandoUnidadMilitarRepository.findByLineaMandoUnidadMilitarAndSiglaoAcronimoUnidadMilitar(String.valueOf(lineaMandoUnidadMilitar), String.valueOf(siglaoAcronimoUnidadMilitar)));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_LINEA_MANDO_Y_UNIDAD_MILITAR_NO_ENCONTRADOS, false);
        
        if (lineaMandoUnidadMilitarLineaMando.isPresent() == true) {//SI ENCONTRO LA LÍNEA DE MANDO Y UNIDAD MILITAR DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON LA LÍNEA DE MANDO PROPORCIONADA.
           respuestaDTO.setLineaMandoUnidadMilitarDTO(lineaMandoUnidadMilitarDAO.lineaMandoUnidadMilitarDTO(lineaMandoUnidadMilitarLineaMando.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (lineaMandoUnidadMilitarLineaMando.isPresent() == false) {//SI NO ENCONTRO LA LÍNEA DE MANDO Y UNIDAD MILITAR DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE CONSULTA NO EXITOSA CON LA LÍNEA DE MANDO PROPORCIONADA.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_LINEA_MANDO_Y_UNIDAD_MILITAR_NO_ENCONTRADOS, false);
           respuestaDTO.setLineaMandoUnidadMilitarDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //MODIFICAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE MODIFICAR REGISTRO.
    public RespuestaDTO actualizarLineaMandoUnidadMilitar(LineaMandoUnidadMilitarDTO lineaMandoUnidadMilitarDTO) {
        Optional<LineaMandoUnidadMilitar> lineaMandoUnidadMilitarId = lineaMandoUnidadMilitarRepository.findByIdLineaMandoUnidadMilitar(lineaMandoUnidadMilitarDTO.getIdLineaMandoUnidadMilitar());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
        
        if (lineaMandoUnidadMilitarId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
           //VALIDAR QUE LA UNIDAD MILITAR NO ESTE YA REGISTRADA EN OTRO REGISTRO:
           Optional<LineaMandoUnidadMilitar> lineaMandoUnidadMilitarUnidadMilitar = lineaMandoUnidadMilitarRepository.findByIdUnidadMilitar(lineaMandoUnidadMilitarDTO.getUnidadMilitarDTO().getIdUnidadMilitar());
           if (lineaMandoUnidadMilitarUnidadMilitar.isPresent() == true && !lineaMandoUnidadMilitarUnidadMilitar.get().getIdLineaMandoUnidadMilitar().equals(lineaMandoUnidadMilitarDTO.getIdLineaMandoUnidadMilitar())) {//SI LA UNIDAD MILITAR PERTENECE A OTRO REGISTRO DIFERENTE AL QUE SE ESTA MODIFICANDO.
              respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_UNIDAD_MILITAR_YA_EXISTE, false);
              return respuestaDTO;
           }
           lineaMandoUnidadMilitarRepository.save(lineaMandoUnidadMilitarDAO.lineaMandoUnidadMilitar(lineaMandoUnidadMilitarDTO));
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
        }
        if (lineaMandoUnidadMilitarId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MUESTRA UN MENSAJE DE REGISTRO NO MODIFICADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
           respuestaDTO.setLineaMandoUnidadMilitarDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //ELIMINAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE ELIMINAR REGISTRO.
    public RespuestaDTO eliminarLineaMandoUnidadMilitar(Long idLineaMandoUnidadMilitar) {
        Optional<LineaMandoUnidadMilitar> lineaMandoUnidadMilitarId = lineaMandoUnidadMilitarRepository.findById(idLineaMandoUnidadMilitar);
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (lineaMandoUnidadMilitarId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO.setLineaMandoUnidadMilitarDTO(lineaMandoUnidadMilitarDAO.lineaMandoUnidadMilitarDTO(lineaMandoUnidadMilitarId.get()));
           lineaMandoUnidadMilitarRepository.delete(lineaMandoUnidadMilitarId.get());
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ELIMINADO_EXITO, true);
        }
        if (lineaMandoUnidadMilitarId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS NO ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO NO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setLineaMandoUnidadMilitarDTO(null);
        }
        
        return respuestaDTO;
    }
}
