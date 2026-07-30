//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.serviceImpl;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.Constantes.MensajesConstantes;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.CentroCostoPelotonUnidadMilitarDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service.CentroCostoPelotonUnidadMilitarService;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao.CentroCostoPelotonUnidadMilitarDAO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.CentroCostoPelotonUnidadMilitar;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.CentroCostoPelotonUnidadMilitarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 25/03/2026.
* Esta es la declaración de la implementación del servicio.
* Se inyectan DAOS y repositorios.
*/
@Service//DECLARACIÓN DE LA IMPLEMENTACIÓN DEL SERVICIO.
//DECLARACIÓN DE LA CLASE DE LA IMPLEMENTACIÓN DEL SERVICIO:
public class CentroCostoPelotonUnidadMilitarServiceImpl implements CentroCostoPelotonUnidadMilitarService {
    
    @Autowired//INYECTAMOS EL DAO.
    private CentroCostoPelotonUnidadMilitarDAO centroCostoPelotonUnidadMilitarDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private CentroCostoPelotonUnidadMilitarRepository centroCostoPelotonUnidadMilitarRepository;
    
    //CONTADOR DE REGISTROS FILTRADOS.
    //CONTAR TOTAL DE REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE CONTEO.
    public Long contarTotalRegistros(Long idCentroCostoPelotonUnidadMilitar, String keyword, String nombrePelotonUnidadMilitar) {
        return centroCostoPelotonUnidadMilitarRepository.findTotalRegistros(idCentroCostoPelotonUnidadMilitar, keyword, nombrePelotonUnidadMilitar);
    }
    
    //LISTADO DE REGISTROS FILTRADOS SIN PAGINACIÓN.
    //LISTAR REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public List<CentroCostoPelotonUnidadMilitarDTO> listarCentrosCostosPelotonesUnidadesMilitares(Long idCentroCostoPelotonUnidadMilitar, String keyword, String nombrePelotonUnidadMilitar, String orderBy, String orderMode) {
        List<CentroCostoPelotonUnidadMilitar> centrosCostosPelotonesUnidadesMilitares = centroCostoPelotonUnidadMilitarRepository.findAllCentrosCostosPelotonesUnidadesMilitares(idCentroCostoPelotonUnidadMilitar, keyword, nombrePelotonUnidadMilitar, orderBy, orderMode);
        List<CentroCostoPelotonUnidadMilitarDTO> centroCostoPelotonUnidadMilitarDTOS = new ArrayList<>();
        for (CentroCostoPelotonUnidadMilitar centroCostoPelotonUnidadMilitar : centrosCostosPelotonesUnidadesMilitares) {
            centroCostoPelotonUnidadMilitarDTOS.add(centroCostoPelotonUnidadMilitarDAO.centroCostoPelotonUnidadMilitarDTO(centroCostoPelotonUnidadMilitar));
        }
        
        return centroCostoPelotonUnidadMilitarDTOS;
    }
    
    //LISTADO DE REGISTROS FILTRADOS CON PAGINACIÓN.
    //LISTAR REGISTROS PAGINADOS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS PAGINADOS.
    public Slice<CentroCostoPelotonUnidadMilitarDTO> listarCentrosCostosPelotonesUnidadesMilitaresPag(Pageable pageable, Long idCentroCostoPelotonUnidadMilitar, String keyword, String nombrePelotonUnidadMilitar, String orderBy, String orderMode) {
        Slice<CentroCostoPelotonUnidadMilitar> centrosCostosPelotonesUnidadesMilitares = centroCostoPelotonUnidadMilitarRepository.findAllCentrosCostosPelotonesUnidadesMilitaresPag(pageable, idCentroCostoPelotonUnidadMilitar, keyword, nombrePelotonUnidadMilitar, orderBy, orderMode);
        return centrosCostosPelotonesUnidadesMilitares.map(centroCostoPelotonUnidadMilitar -> centroCostoPelotonUnidadMilitarDAO.centroCostoPelotonUnidadMilitarDTO(centroCostoPelotonUnidadMilitar));
    }
    
    //CREAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE CREAR REGISTRO.
    public RespuestaDTO crearCentroCostoPelotonUnidadMilitar(CentroCostoPelotonUnidadMilitarDTO centroCostoPelotonUnidadMilitarDTO) {
        Long maxIdCentroCostoPelotonUnidadMilitar = null;
        CentroCostoPelotonUnidadMilitar centroCostoPelotonUnidadMilitarNombreYPeloton = centroCostoPelotonUnidadMilitarRepository.findByNombrePelotonUnidadMilitarAndCentroCostoPelotonUnidadMilitar(centroCostoPelotonUnidadMilitarDTO.getPelotonUnidadMilitarDTO().getNombrePelotonUnidadMilitar(), centroCostoPelotonUnidadMilitarDTO.getCentroCostoPelotonUnidadMilitar().toUpperCase());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_CREADO, false);
        
        //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
        long banderaNombreRegistroEncontrado = 0;
        
        if (!(centroCostoPelotonUnidadMilitarNombreYPeloton == null)) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS Y ASOCIADO A UN MISMO PELOTÓN DE UNIDAD MILITAR MUESTRA UN MENSAJE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
           banderaNombreRegistroEncontrado = 1;
        }
        
        if (banderaNombreRegistroEncontrado == 1) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS Y ASOCIADO A UN MISMO PELOTÓN DE UNIDAD MILITAR MUESTRA UN MENSAJE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CENTRO_COSTO_YA_EXISTE, false);
           respuestaDTO.setCentroCostoPelotonUnidadMilitarDTO(null);
        }
        if (banderaNombreRegistroEncontrado == 0) {//SI NO ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS Y ASOCIADO A UN MISMO PELOTÓN DE UNIDAD MILITAR CREA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO CREADO EXITOSAMENTE.
           maxIdCentroCostoPelotonUnidadMilitar = centroCostoPelotonUnidadMilitarRepository.findMaxIdCentroCostoPelotonUnidadMilitar();
           if (maxIdCentroCostoPelotonUnidadMilitar == null) {//ESTO SE HACE EN CASO DE QUE SI LA TABLA DE LA BASE DE DATOS ESTA EN BLANCO Y VA SER EL PRIMER REGISTRO AL OBTENER UN VALOR NULO, SE ASIGNE CERO (0) AUTOMÁTICAMENTE.
              maxIdCentroCostoPelotonUnidadMilitar = Long.valueOf(0);
           }
           centroCostoPelotonUnidadMilitarDTO.setIdCentroCostoPelotonUnidadMilitar(maxIdCentroCostoPelotonUnidadMilitar + 1);//OBTENGO EL ID MAXIMO AUTOMATICO, SUMO (1) ENTERO PARA OBTENER EL NUEVO ID.
           centroCostoPelotonUnidadMilitarRepository.save(centroCostoPelotonUnidadMilitarDAO.centroCostoPelotonUnidadMilitar(centroCostoPelotonUnidadMilitarDTO));
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CREADO_EXITO, true);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR ID:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarCentroCostoPelotonUnidadMilitarporId(Long idCentroCostoPelotonUnidadMilitar) {
        Optional<CentroCostoPelotonUnidadMilitar> centroCostoPelotonUnidadMilitarId = centroCostoPelotonUnidadMilitarRepository.findByIdCentroCostoPelotonUnidadMilitar(Long.valueOf(idCentroCostoPelotonUnidadMilitar));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (centroCostoPelotonUnidadMilitarId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO.setCentroCostoPelotonUnidadMilitarDTO(centroCostoPelotonUnidadMilitarDAO.centroCostoPelotonUnidadMilitarDTO(centroCostoPelotonUnidadMilitarId.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (centroCostoPelotonUnidadMilitarId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE CONSULTA NO EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setCentroCostoPelotonUnidadMilitarDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR NOMBRE Y NOMBRE DE PELOTÓN DE UNIDAD MILITAR:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarCentroCostoPelotonUnidadMilitarporNombreYNombrePelotonUnidadMilitar(String centroCostoPelotonUnidadMilitar, String nombrePelotonUnidadMilitar) {
        Optional<CentroCostoPelotonUnidadMilitar> centroCostoPelotonUnidadMilitarNombre = Optional.ofNullable(centroCostoPelotonUnidadMilitarRepository.findByNombrePelotonUnidadMilitarAndCentroCostoPelotonUnidadMilitar(String.valueOf(nombrePelotonUnidadMilitar), String.valueOf(centroCostoPelotonUnidadMilitar)));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CENTRO_COSTO_Y_PELOTON_UNIDAD_MILITAR_NO_ENCONTRADOS, false);
        
        if (centroCostoPelotonUnidadMilitarNombre.isPresent() == true) {//SI ENCONTRO EL CENTRO DE COSTO Y NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL NOMBRE PROPORCIONADO.
           respuestaDTO.setCentroCostoPelotonUnidadMilitarDTO(centroCostoPelotonUnidadMilitarDAO.centroCostoPelotonUnidadMilitarDTO(centroCostoPelotonUnidadMilitarNombre.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (centroCostoPelotonUnidadMilitarNombre.isPresent() == false) {//SI NO ENCONTRO EL CENTRO DE COSTO Y NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE CONSULTA NO EXITOSA CON EL NOMBRE PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CENTRO_COSTO_Y_PELOTON_UNIDAD_MILITAR_NO_ENCONTRADOS, false);
           respuestaDTO.setCentroCostoPelotonUnidadMilitarDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //MODIFICAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE MODIFICAR REGISTRO.
    public RespuestaDTO actualizarCentroCostoPelotonUnidadMilitar(CentroCostoPelotonUnidadMilitarDTO centroCostoPelotonUnidadMilitarDTO) {
        Optional<CentroCostoPelotonUnidadMilitar> centroCostoPelotonUnidadMilitarId = centroCostoPelotonUnidadMilitarRepository.findByIdCentroCostoPelotonUnidadMilitar(centroCostoPelotonUnidadMilitarDTO.getIdCentroCostoPelotonUnidadMilitar());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
        
        if (centroCostoPelotonUnidadMilitarId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE VERIFICA EL NOMBRE DEL REGISTRO CON EL ID PROPORCIONADO.
           if (centroCostoPelotonUnidadMilitarDTO.getCentroCostoPelotonUnidadMilitar().equals(centroCostoPelotonUnidadMilitarId.get().getCentroCostoPelotonUnidadMilitar()) == true) {//SI EL NOMBRE DIGITADO ES IGUAL AL NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
              centroCostoPelotonUnidadMilitarRepository.save(centroCostoPelotonUnidadMilitarDAO.centroCostoPelotonUnidadMilitar(centroCostoPelotonUnidadMilitarDTO));
              respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
           }
           if (centroCostoPelotonUnidadMilitarDTO.getCentroCostoPelotonUnidadMilitar().equals(centroCostoPelotonUnidadMilitarId.get().getCentroCostoPelotonUnidadMilitar()) == false) {//SI EL NOMBRE DIGITADO ES DIFERENTE AL NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS SE REALIZA BUSQUEDA PARA VERIFICAR SI ESTE NOMBRE DIGITADO EXISTE EN OTROS REGISTROS Y ASOCIADOS A UN MISMO PELOTÓN DE UNIDAD MILITAR.
              CentroCostoPelotonUnidadMilitar centroCostoPelotonUnidadMilitarNombreYPeloton = centroCostoPelotonUnidadMilitarRepository.findByNombrePelotonUnidadMilitarAndCentroCostoPelotonUnidadMilitar(centroCostoPelotonUnidadMilitarDTO.getPelotonUnidadMilitarDTO().getNombrePelotonUnidadMilitar(), centroCostoPelotonUnidadMilitarDTO.getCentroCostoPelotonUnidadMilitar().toUpperCase());
              
              //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
              long banderaNombreRegistroEncontrado = 0;
              
              if (!(centroCostoPelotonUnidadMilitarNombreYPeloton == null)) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS Y ASOCIADO A UN MISMO PELOTÓN DE UNIDAD MILITAR MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
                 banderaNombreRegistroEncontrado = 1;
              }
              
              if (banderaNombreRegistroEncontrado == 1) {//SI LA BUSQUEDA OBTIENE QUE EL NOMBRE DIGITADO ES DIFERENTE DE NULO SIGNIFICA QUE ENCONTRO EL MISMO NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS Y ASOCIADO A UN MISMO PELOTÓN DE UNIDAD MILITAR Y MUESTRA UN MENSAJE DE NOMBRE DEL REGISTRO REPETIDO.
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CENTRO_COSTO_YA_EXISTE, false);
                 respuestaDTO.setCentroCostoPelotonUnidadMilitarDTO(null);
              }
              if (banderaNombreRegistroEncontrado == 0) {//SI LA BUSQUEDA OBTIENE QUE EL NOMBRE DIGITADO ES NULO EN LA TABLA DE LA BASE DE DATOS Y ASOCIADO A UN MISMO PELOTÓN DE UNIDAD MILITAR SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
                 centroCostoPelotonUnidadMilitarRepository.save(centroCostoPelotonUnidadMilitarDAO.centroCostoPelotonUnidadMilitar(centroCostoPelotonUnidadMilitarDTO));
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
              }
           }
        }
        if (centroCostoPelotonUnidadMilitarId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MUESTRA UN MENSAJE DE REGISTRO NO MODIFICADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
           respuestaDTO.setCentroCostoPelotonUnidadMilitarDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //ELIMINAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE ELIMINAR REGISTRO.
    public RespuestaDTO eliminarCentroCostoPelotonUnidadMilitar(Long idCentroCostoPelotonUnidadMilitar) {
        Optional<CentroCostoPelotonUnidadMilitar> centroCostoPelotonUnidadMilitarId = centroCostoPelotonUnidadMilitarRepository.findById(idCentroCostoPelotonUnidadMilitar);
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (centroCostoPelotonUnidadMilitarId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO.setCentroCostoPelotonUnidadMilitarDTO(centroCostoPelotonUnidadMilitarDAO.centroCostoPelotonUnidadMilitarDTO(centroCostoPelotonUnidadMilitarId.get()));
           centroCostoPelotonUnidadMilitarRepository.delete(centroCostoPelotonUnidadMilitarId.get());
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ELIMINADO_EXITO, true);
        }
        if (centroCostoPelotonUnidadMilitarId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS NO ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO NO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setCentroCostoPelotonUnidadMilitarDTO(null);
        }
        
        return respuestaDTO;
    }
}
