//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.serviceImpl;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.Constantes.MensajesConstantes;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.EquipoTopografiaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service.EquipoTopografiaService;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao.EquipoTopografiaDAO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.EquipoTopografia;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.EquipoTopografiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 21/03/2026.
* Esta es la declaración de la implementación del servicio.
* Se inyectan DAOS y repositorios.
*/
@Service//DECLARACIÓN DE LA IMPLEMENTACIÓN DEL SERVICIO.
//DECLARACIÓN DE LA CLASE DE LA IMPLEMENTACIÓN DEL SERVICIO:
public class EquipoTopografiaServiceImpl implements EquipoTopografiaService {
    
    @Autowired//INYECTAMOS EL DAO.
    private EquipoTopografiaDAO equipoTopografiaDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private EquipoTopografiaRepository equipoTopografiaRepository;
    
    //CONTADOR DE REGISTROS FILTRADOS.
    //CONTAR TOTAL DE REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE CONTEO.
    public Long contarTotalRegistros(Long idEquipoTopografia, String keyword, String siglaoAcronimoUnidadMilitar) {
        return equipoTopografiaRepository.findTotalRegistros(idEquipoTopografia, keyword, siglaoAcronimoUnidadMilitar);
    }
    
    //LISTADO DE REGISTROS FILTRADOS SIN PAGINACIÓN.
    //LISTAR REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public List<EquipoTopografiaDTO> listarEquiposTopografias(Long idEquipoTopografia, String keyword, String siglaoAcronimoUnidadMilitar, String orderBy, String orderMode) {
        List<EquipoTopografia> equiposTopografias = equipoTopografiaRepository.findAllEquiposTopografias(idEquipoTopografia, keyword, siglaoAcronimoUnidadMilitar, orderBy, orderMode);
        List<EquipoTopografiaDTO> equipoTopografiaDTOS = new ArrayList<>();
        for (EquipoTopografia equipoTopografia : equiposTopografias) {
            equipoTopografiaDTOS.add(equipoTopografiaDAO.equipoTopografiaDTO(equipoTopografia));
        }
        
        return equipoTopografiaDTOS;
    }
    
    //LISTADO DE REGISTROS FILTRADOS CON PAGINACIÓN.
    //LISTAR REGISTROS PAGINADOS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS PAGINADOS.
    public Slice<EquipoTopografiaDTO> listarEquiposTopografiasPag(Pageable pageable, Long idEquipoTopografia, String keyword, String siglaoAcronimoUnidadMilitar, String orderBy, String orderMode) {
        Slice<EquipoTopografia> equiposTopografias = equipoTopografiaRepository.findAllEquiposTopografiasPag(pageable, idEquipoTopografia, keyword, siglaoAcronimoUnidadMilitar, orderBy, orderMode);
        return equiposTopografias.map(equipoTopografia -> equipoTopografiaDAO.equipoTopografiaDTO(equipoTopografia));
    }
    
    //CREAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE CREAR REGISTRO.
    public RespuestaDTO crearEquipoTopografia(EquipoTopografiaDTO equipoTopografiaDTO) {
        Long maxIdEquipoTopografia = null;
        EquipoTopografia equipoTopografiaDenominacionySigla = equipoTopografiaRepository.findByDenominacionEquipoTopografiaAndSiglaoAcronimoUnidadMilitar(equipoTopografiaDTO.getDenominacionEquipoTopografia().toUpperCase(), equipoTopografiaDTO.getUnidadMilitarDTO().getSiglaoAcronimoUnidadMilitar());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_CREADO, false);
        
        //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
        long banderaNombreRegistroEncontrado = 0;
        
        if (!(equipoTopografiaDenominacionySigla == null)) {//SI ENCONTRO LA DENOMINACION DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS Y ASOCIADO A UNA MISMA UNIDAD MILITAR MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
           banderaNombreRegistroEncontrado = 1;
        }
        
        if (banderaNombreRegistroEncontrado == 1) {//SI ENCONTRO LA DENOMINACION DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS Y ASOCIADO A UNA MISMA UNIDAD MILITAR MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_EN_UNIDAD_MILITAR_YA_EXISTE, false);
           respuestaDTO.setEquipoTopografiaDTO(null);
        }
        if (banderaNombreRegistroEncontrado == 0) {//SI NO ENCONTRO LA DENOMINACION DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS Y ASOCIADO A UNA MISMA UNIDAD MILITAR CREA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO CREADO EXITOSAMENTE.
           maxIdEquipoTopografia = equipoTopografiaRepository.findMaxIdEquipoTopografia();
           if (maxIdEquipoTopografia == null) {//ESTO SE HACE EN CASO DE QUE SI LA TABLA DE LA BASE DE DATOS ESTA EN BLANCO Y VA SER EL PRIMER REGISTRO AL OBTENER UN VALOR NULO, SE ASIGNE CERO (0) AUTOMÁTICAMENTE.
              maxIdEquipoTopografia = Long.valueOf(0);
           }
           equipoTopografiaDTO.setIdEquipoTopografia(maxIdEquipoTopografia + 1);//OBTENGO EL ID MAXIMO AUTOMATICO, SUMO (1) ENTERO PARA OBTENER EL NUEVO ID.
           equipoTopografiaRepository.save(equipoTopografiaDAO.equipoTopografia(equipoTopografiaDTO));
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CREADO_EXITO, true);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR ID:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarEquipoTopografiaporId(Long idEquipoTopografia) {
        Optional<EquipoTopografia> equipoTopografiaId = equipoTopografiaRepository.findByIdEquipoTopografia(Long.valueOf(idEquipoTopografia));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (equipoTopografiaId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO.setEquipoTopografiaDTO(equipoTopografiaDAO.equipoTopografiaDTO(equipoTopografiaId.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (equipoTopografiaId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE CONSULTA NO EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setEquipoTopografiaDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR DENOMINACION Y SIGLA O ACRONIMO DE UNIDAD MILITAR:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarEquipoTopografiaporDenominacionySiglaoAcronimoUnidadMilitar(String denominacionEquipoTopografia, String siglaoAcronimoUnidadMilitar) {
        Optional<EquipoTopografia> equipoTopografiaDenominacion = Optional.ofNullable(equipoTopografiaRepository.findByDenominacionEquipoTopografiaAndSiglaoAcronimoUnidadMilitar(String.valueOf(denominacionEquipoTopografia), String.valueOf(siglaoAcronimoUnidadMilitar)));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_NO_ENCONTRADO, false);
        
        if (equipoTopografiaDenominacion.isPresent() == true) {//SI ENCONTRO LA DENOMINACION DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON LA DENOMINACION PROPORCIONADA.
           respuestaDTO.setEquipoTopografiaDTO(equipoTopografiaDAO.equipoTopografiaDTO(equipoTopografiaDenominacion.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (equipoTopografiaDenominacion.isPresent() == false) {//SI NO ENCONTRO LA DENOMINACION DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE CONSULTA NO EXITOSA CON LA DENOMINACION PROPORCIONADA.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_NO_ENCONTRADO, false);
           respuestaDTO.setEquipoTopografiaDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //MODIFICAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE MODIFICAR REGISTRO.
    public RespuestaDTO actualizarEquipoTopografia(EquipoTopografiaDTO equipoTopografiaDTO) {
        Optional<EquipoTopografia> equipoTopografiaId = equipoTopografiaRepository.findByIdEquipoTopografia(equipoTopografiaDTO.getIdEquipoTopografia());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
        
        if (equipoTopografiaId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE VERIFICA LA DENOMINACION DEL REGISTRO CON EL ID PROPORCIONADO.
           if (equipoTopografiaDTO.getDenominacionEquipoTopografia().equals(equipoTopografiaId.get().getDenominacionEquipoTopografia()) == true) {//SI LA DENOMINACION DIGITADA ES IGUAL A LA DENOMINACION ALMACENADA EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
              equipoTopografiaRepository.save(equipoTopografiaDAO.equipoTopografia(equipoTopografiaDTO));
              respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
           }
           if (equipoTopografiaDTO.getDenominacionEquipoTopografia().equals(equipoTopografiaId.get().getDenominacionEquipoTopografia()) == false) {//SI LA DENOMINACION DIGITADA ES DIFERENTE A LA DENOMINACION ALMACENADA EN LA TABLA DE LA BASE DE DATOS SE REALIZA BUSQUEDA PARA VERIFICAR SI ESTA DENOMINACION DIGITADA EXISTE EN OTROS REGISTROS Y ASOCIADOS A UNA MISMA UNIDAD MILITAR.
              EquipoTopografia equipoTopografiaDenominacionySigla = equipoTopografiaRepository.findByDenominacionEquipoTopografiaAndSiglaoAcronimoUnidadMilitar(equipoTopografiaDTO.getDenominacionEquipoTopografia().toUpperCase(), equipoTopografiaDTO.getUnidadMilitarDTO().getSiglaoAcronimoUnidadMilitar());
              
              //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
              long banderaNombreRegistroEncontrado = 0;
              
              if (!(equipoTopografiaDenominacionySigla == null)) {//SI ENCONTRO LA DENOMINACION DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS Y ASOCIADO A UNA MISMA UNIDAD MILITAR MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
                 banderaNombreRegistroEncontrado = 1;
              }
              
              if (banderaNombreRegistroEncontrado == 1) {//SI LA BUSQUEDA OBTIENE QUE LA DENOMINACION DIGITADA ES DIFERENTE DE NULO SIGNIFICA QUE ENCONTRO LA MISMA DENOMINACION ALMACENADA EN LA TABLA DE LA BASE DE DATOS Y ASOCIADO A UNA MISMA UNIDAD MILITAR Y MUESTRA UN MENSAJE DE NOMBRE DEL REGISTRO REPETIDO.
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_EN_UNIDAD_MILITAR_YA_EXISTE, false);
                 respuestaDTO.setEquipoTopografiaDTO(null);
              }
              if (banderaNombreRegistroEncontrado == 0) {//SI LA BUSQUEDA OBTIENE QUE LA DENOMINACION DIGITADA ES NULA EN LA TABLA DE LA BASE DE DATOS Y ASOCIADO A UNA MISMA UNIDAD MILITAR SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
                 equipoTopografiaRepository.save(equipoTopografiaDAO.equipoTopografia(equipoTopografiaDTO));
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
              }
           }
        }
        if (equipoTopografiaId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MUESTRA UN MENSAJE DE REGISTRO NO MODIFICADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
           respuestaDTO.setEquipoTopografiaDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //ELIMINAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE ELIMINAR REGISTRO.
    public RespuestaDTO eliminarEquipoTopografia(Long idEquipoTopografia) {
        Optional<EquipoTopografia> equipoTopografiaId = equipoTopografiaRepository.findById(idEquipoTopografia);
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (equipoTopografiaId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO.setEquipoTopografiaDTO(equipoTopografiaDAO.equipoTopografiaDTO(equipoTopografiaId.get()));
           equipoTopografiaRepository.delete(equipoTopografiaId.get());
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ELIMINADO_EXITO, true);
        }
        if (equipoTopografiaId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS NO ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO NO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setEquipoTopografiaDTO(null);
        }
        
        return respuestaDTO;
    }
}
