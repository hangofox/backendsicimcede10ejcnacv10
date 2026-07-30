//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.serviceImpl;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.Constantes.MensajesConstantes;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.UnidadMilitarRealizadoraMantenimientoDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service.UnidadMilitarRealizadoraMantenimientoService;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao.UnidadMilitarRealizadoraMantenimientoDAO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.UnidadMilitarRealizadoraMantenimiento;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.UnidadMilitarRealizadoraMantenimientoRepository;
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
public class UnidadMilitarRealizadoraMantenimientoServiceImpl implements UnidadMilitarRealizadoraMantenimientoService {
    
    @Autowired//INYECTAMOS EL DAO.
    private UnidadMilitarRealizadoraMantenimientoDAO unidadMilitarRealizadoraMantenimientoDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private UnidadMilitarRealizadoraMantenimientoRepository unidadMilitarRealizadoraMantenimientoRepository;
    
    //CONTADOR DE REGISTROS FILTRADOS.
    //CONTAR TOTAL DE REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE CONTEO.
    public Long contarTotalRegistros(Long idUnidadMilitarRealizadoraMantenimiento, String keyword, String siglaoAcronimoUnidadMilitar) {
        return unidadMilitarRealizadoraMantenimientoRepository.findTotalRegistros(idUnidadMilitarRealizadoraMantenimiento, keyword, siglaoAcronimoUnidadMilitar);
    }
    
    //LISTADO DE REGISTROS FILTRADOS SIN PAGINACIÓN.
    //LISTAR REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public List<UnidadMilitarRealizadoraMantenimientoDTO> listarUnidadesMilitaresRealizadorasMantenimientos(Long idUnidadMilitarRealizadoraMantenimiento, String keyword, String siglaoAcronimoUnidadMilitar, String orderBy, String orderMode) {
        List<UnidadMilitarRealizadoraMantenimiento> unidadesMilitaresRealizadorasMantenimientos = unidadMilitarRealizadoraMantenimientoRepository.findAllUnidadesMilitaresRealizadorasMantenimientos(idUnidadMilitarRealizadoraMantenimiento, keyword, siglaoAcronimoUnidadMilitar, orderBy, orderMode);
        List<UnidadMilitarRealizadoraMantenimientoDTO> unidadMilitarRealizadoraMantenimientoDTOS = new ArrayList<>();
        for (UnidadMilitarRealizadoraMantenimiento unidadMilitarRealizadoraMantenimiento : unidadesMilitaresRealizadorasMantenimientos) {
            unidadMilitarRealizadoraMantenimientoDTOS.add(unidadMilitarRealizadoraMantenimientoDAO.unidadMilitarRealizadoraMantenimientoDTO(unidadMilitarRealizadoraMantenimiento));
        }
        
        return unidadMilitarRealizadoraMantenimientoDTOS;
    }
    
    //LISTADO DE REGISTROS FILTRADOS CON PAGINACIÓN.
    //LISTAR REGISTROS PAGINADOS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS PAGINADOS.
    public Slice<UnidadMilitarRealizadoraMantenimientoDTO> listarUnidadesMilitaresRealizadorasMantenimientosPag(Pageable pageable, Long idUnidadMilitarRealizadoraMantenimiento, String keyword, String siglaoAcronimoUnidadMilitar, String orderBy, String orderMode) {
        Slice<UnidadMilitarRealizadoraMantenimiento> unidadesMilitaresRealizadorasMantenimientos = unidadMilitarRealizadoraMantenimientoRepository.findAllUnidadesMilitaresRealizadorasMantenimientosPag(pageable, idUnidadMilitarRealizadoraMantenimiento, keyword, siglaoAcronimoUnidadMilitar, orderBy, orderMode);
        return unidadesMilitaresRealizadorasMantenimientos.map(unidadMilitarRealizadoraMantenimiento -> unidadMilitarRealizadoraMantenimientoDAO.unidadMilitarRealizadoraMantenimientoDTO(unidadMilitarRealizadoraMantenimiento));
    }
    
    //CREAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE CREAR REGISTRO.
    public RespuestaDTO crearUnidadMilitarRealizadoraMantenimiento(UnidadMilitarRealizadoraMantenimientoDTO unidadMilitarRealizadoraMantenimientoDTO) {
        Long maxIdUnidadMilitarRealizadoraMantenimiento = null;
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_CREADO, false);
        
        //VALIDAR QUE LA UNIDAD MILITAR NO ESTE YA REGISTRADA EN OTRA UNIDAD MILITAR REALIZADORA DE MANTENIMIENTO:
        Optional<UnidadMilitarRealizadoraMantenimiento> unidadMilitarRealizadoraMantenimientoUnidadMilitar = unidadMilitarRealizadoraMantenimientoRepository.findByIdUnidadMilitar(unidadMilitarRealizadoraMantenimientoDTO.getUnidadMilitarDTO().getIdUnidadMilitar());
        if (unidadMilitarRealizadoraMantenimientoUnidadMilitar.isPresent() == true) {//SI ENCONTRO LA UNIDAD MILITAR YA REGISTRADA EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE ADVERTENCIA.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_UNIDAD_MILITAR_YA_EXISTE, false);
           return respuestaDTO;
        }
        
        //VALIDAR QUE EL CODIGO DE LA UNIDAD MILITAR REALIZADORA DE MANTENIMIENTO NO ESTE YA REGISTRADO:
        Optional<UnidadMilitarRealizadoraMantenimiento> unidadMilitarRealizadoraMantenimientoCodigo = unidadMilitarRealizadoraMantenimientoRepository.findByCodigoUnidadMilitarRealizadoraMantenimiento(unidadMilitarRealizadoraMantenimientoDTO.getCodigoUnidadMilitarRealizadoraMantenimiento().toUpperCase());
        if (unidadMilitarRealizadoraMantenimientoCodigo.isPresent() == true) {//SI ENCONTRO EL CODIGO YA REGISTRADO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE ADVERTENCIA.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CODIGO_YA_EXISTE, false);
           return respuestaDTO;
        }
        
        maxIdUnidadMilitarRealizadoraMantenimiento = unidadMilitarRealizadoraMantenimientoRepository.findMaxIdUnidadMilitarRealizadoraMantenimiento();
        if (maxIdUnidadMilitarRealizadoraMantenimiento == null) {//ESTO SE HACE EN CASO DE QUE SI LA TABLA DE LA BASE DE DATOS ESTA EN BLANCO Y VA SER EL PRIMER REGISTRO AL OBTENER UN VALOR NULO, SE ASIGNE CERO (0) AUTOMÁTICAMENTE.
           maxIdUnidadMilitarRealizadoraMantenimiento = Long.valueOf(0);
        }
        unidadMilitarRealizadoraMantenimientoDTO.setIdUnidadMilitarRealizadoraMantenimiento(maxIdUnidadMilitarRealizadoraMantenimiento + 1);//OBTENGO EL ID MAXIMO AUTOMATICO, SUMO (1) ENTERO PARA OBTENER EL NUEVO ID.
        unidadMilitarRealizadoraMantenimientoRepository.save(unidadMilitarRealizadoraMantenimientoDAO.unidadMilitarRealizadoraMantenimiento(unidadMilitarRealizadoraMantenimientoDTO));
        respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CREADO_EXITO, true);
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR ID:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO POR ID.
    public RespuestaDTO consultarUnidadMilitarRealizadoraMantenimientoportId(Long idUnidadMilitarRealizadoraMantenimiento) {
        Optional<UnidadMilitarRealizadoraMantenimiento> unidadMilitarRealizadoraMantenimientoId = unidadMilitarRealizadoraMantenimientoRepository.findByIdUnidadMilitarRealizadoraMantenimiento(Long.valueOf(idUnidadMilitarRealizadoraMantenimiento));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (unidadMilitarRealizadoraMantenimientoId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO.setUnidadMilitarRealizadoraMantenimientoDTO(unidadMilitarRealizadoraMantenimientoDAO.unidadMilitarRealizadoraMantenimientoDTO(unidadMilitarRealizadoraMantenimientoId.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (unidadMilitarRealizadoraMantenimientoId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE CONSULTA NO EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setUnidadMilitarRealizadoraMantenimientoDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR CODIGO DE LA UNIDAD MILITAR REALIZADORA DE MANTENIMIENTO (CAMPO ÚNICO):
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO POR CODIGO.
    public RespuestaDTO consultarUnidadMilitarRealizadoraMantenimientoporCodigo(String codigoUnidadMilitarRealizadoraMantenimiento) {
        Optional<UnidadMilitarRealizadoraMantenimiento> unidadMilitarRealizadoraMantenimientoCodigo = unidadMilitarRealizadoraMantenimientoRepository.findByCodigoUnidadMilitarRealizadoraMantenimiento(codigoUnidadMilitarRealizadoraMantenimiento);
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CODIGO_NO_ENCONTRADO, false);
        
        if (unidadMilitarRealizadoraMantenimientoCodigo.isPresent() == true) {//SI ENCONTRO EL CODIGO DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL CODIGO PROPORCIONADO.
           respuestaDTO.setUnidadMilitarRealizadoraMantenimientoDTO(unidadMilitarRealizadoraMantenimientoDAO.unidadMilitarRealizadoraMantenimientoDTO(unidadMilitarRealizadoraMantenimientoCodigo.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (unidadMilitarRealizadoraMantenimientoCodigo.isPresent() == false) {//SI NO ENCONTRO EL CODIGO DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE CONSULTA NO EXITOSA CON EL CODIGO PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CODIGO_NO_ENCONTRADO, false);
           respuestaDTO.setUnidadMilitarRealizadoraMantenimientoDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //MODIFICAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE MODIFICAR REGISTRO.
    public RespuestaDTO actualizarUnidadMilitarRealizadoraMantenimiento(UnidadMilitarRealizadoraMantenimientoDTO unidadMilitarRealizadoraMantenimientoDTO) {
        Optional<UnidadMilitarRealizadoraMantenimiento> unidadMilitarRealizadoraMantenimientoId = unidadMilitarRealizadoraMantenimientoRepository.findByIdUnidadMilitarRealizadoraMantenimiento(unidadMilitarRealizadoraMantenimientoDTO.getIdUnidadMilitarRealizadoraMantenimiento());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
        
        if (unidadMilitarRealizadoraMantenimientoId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
           //VALIDAR QUE EL CODIGO DE LA UNIDAD MILITAR REALIZADORA DE MANTENIMIENTO NO ESTE YA REGISTRADO EN OTRO REGISTRO:
           Optional<UnidadMilitarRealizadoraMantenimiento> unidadMilitarRealizadoraMantenimientoCodigo = unidadMilitarRealizadoraMantenimientoRepository.findByCodigoUnidadMilitarRealizadoraMantenimiento(unidadMilitarRealizadoraMantenimientoDTO.getCodigoUnidadMilitarRealizadoraMantenimiento().toUpperCase());
           if (unidadMilitarRealizadoraMantenimientoCodigo.isPresent() == true && !unidadMilitarRealizadoraMantenimientoCodigo.get().getIdUnidadMilitarRealizadoraMantenimiento().equals(unidadMilitarRealizadoraMantenimientoDTO.getIdUnidadMilitarRealizadoraMantenimiento())) {//SI EL CODIGO PERTENECE A OTRO REGISTRO DIFERENTE AL QUE SE ESTA MODIFICANDO.
              respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CODIGO_YA_EXISTE, false);
              return respuestaDTO;
           }
           //VALIDAR QUE LA UNIDAD MILITAR NO ESTE YA REGISTRADA EN OTRO REGISTRO:
           Optional<UnidadMilitarRealizadoraMantenimiento> unidadMilitarRealizadoraMantenimientoUnidadMilitar = unidadMilitarRealizadoraMantenimientoRepository.findByIdUnidadMilitar(unidadMilitarRealizadoraMantenimientoDTO.getUnidadMilitarDTO().getIdUnidadMilitar());
           if (unidadMilitarRealizadoraMantenimientoUnidadMilitar.isPresent() == true && !unidadMilitarRealizadoraMantenimientoUnidadMilitar.get().getIdUnidadMilitarRealizadoraMantenimiento().equals(unidadMilitarRealizadoraMantenimientoDTO.getIdUnidadMilitarRealizadoraMantenimiento())) {//SI LA UNIDAD MILITAR PERTENECE A OTRO REGISTRO DIFERENTE AL QUE SE ESTA MODIFICANDO.
              respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_UNIDAD_MILITAR_YA_EXISTE, false);
              return respuestaDTO;
           }
           unidadMilitarRealizadoraMantenimientoRepository.save(unidadMilitarRealizadoraMantenimientoDAO.unidadMilitarRealizadoraMantenimiento(unidadMilitarRealizadoraMantenimientoDTO));
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
        }
        if (unidadMilitarRealizadoraMantenimientoId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MUESTRA UN MENSAJE DE REGISTRO NO MODIFICADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
           respuestaDTO.setUnidadMilitarRealizadoraMantenimientoDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //ELIMINAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE ELIMINAR REGISTRO.
    public RespuestaDTO eliminarUnidadMilitarRealizadoraMantenimiento(Long idUnidadMilitarRealizadoraMantenimiento) {
        Optional<UnidadMilitarRealizadoraMantenimiento> unidadMilitarRealizadoraMantenimientoId = unidadMilitarRealizadoraMantenimientoRepository.findById(idUnidadMilitarRealizadoraMantenimiento);
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (unidadMilitarRealizadoraMantenimientoId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO.setUnidadMilitarRealizadoraMantenimientoDTO(unidadMilitarRealizadoraMantenimientoDAO.unidadMilitarRealizadoraMantenimientoDTO(unidadMilitarRealizadoraMantenimientoId.get()));
           unidadMilitarRealizadoraMantenimientoRepository.delete(unidadMilitarRealizadoraMantenimientoId.get());
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ELIMINADO_EXITO, true);
        }
        if (unidadMilitarRealizadoraMantenimientoId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS NO ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO NO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setUnidadMilitarRealizadoraMantenimientoDTO(null);
        }
        
        return respuestaDTO;
    }
}
