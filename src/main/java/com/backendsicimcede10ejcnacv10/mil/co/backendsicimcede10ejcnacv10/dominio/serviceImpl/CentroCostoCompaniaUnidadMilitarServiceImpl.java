//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.serviceImpl;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.Constantes.MensajesConstantes;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.CentroCostoCompaniaUnidadMilitarDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service.CentroCostoCompaniaUnidadMilitarService;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao.CentroCostoCompaniaUnidadMilitarDAO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.CentroCostoCompaniaUnidadMilitar;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.CentroCostoCompaniaUnidadMilitarRepository;
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
public class CentroCostoCompaniaUnidadMilitarServiceImpl implements CentroCostoCompaniaUnidadMilitarService {
    
    @Autowired//INYECTAMOS EL DAO.
    private CentroCostoCompaniaUnidadMilitarDAO centroCostoCompaniaUnidadMilitarDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private CentroCostoCompaniaUnidadMilitarRepository centroCostoCompaniaUnidadMilitarRepository;
    
    //CONTADOR DE REGISTROS FILTRADOS.
    //CONTAR TOTAL DE REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE CONTEO.
    public Long contarTotalRegistros(Long idCentroCostoCompaniaUnidadMilitar, String keyword, String nombreCompaniaUnidadMilitar) {
        return centroCostoCompaniaUnidadMilitarRepository.findTotalRegistros(idCentroCostoCompaniaUnidadMilitar, keyword, nombreCompaniaUnidadMilitar);
    }
    
    //LISTADO DE REGISTROS FILTRADOS SIN PAGINACIÓN.
    //LISTAR REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public List<CentroCostoCompaniaUnidadMilitarDTO> listarCentrosCostosCompaniasUnidadesMilitares(Long idCentroCostoCompaniaUnidadMilitar, String keyword, String nombreCompaniaUnidadMilitar, String orderBy, String orderMode) {
        List<CentroCostoCompaniaUnidadMilitar> centrosCostosCompaniasUnidadesMilitares = centroCostoCompaniaUnidadMilitarRepository.findAllCentrosCostosCompaniasUnidadesMilitares(idCentroCostoCompaniaUnidadMilitar, keyword, nombreCompaniaUnidadMilitar, orderBy, orderMode);
        List<CentroCostoCompaniaUnidadMilitarDTO> centroCostoCompaniaUnidadMilitarDTOS = new ArrayList<>();
        for (CentroCostoCompaniaUnidadMilitar centroCostoCompaniaUnidadMilitar : centrosCostosCompaniasUnidadesMilitares) {
            centroCostoCompaniaUnidadMilitarDTOS.add(centroCostoCompaniaUnidadMilitarDAO.centroCostoCompaniaUnidadMilitarDTO(centroCostoCompaniaUnidadMilitar));
        }
        
        return centroCostoCompaniaUnidadMilitarDTOS;
    }
    
    //LISTADO DE REGISTROS FILTRADOS CON PAGINACIÓN.
    //LISTAR REGISTROS PAGINADOS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS PAGINADOS.
    public Slice<CentroCostoCompaniaUnidadMilitarDTO> listarCentrosCostosCompaniasUnidadesMilitaresPag(Pageable pageable, Long idCentroCostoCompaniaUnidadMilitar, String keyword, String nombreCompaniaUnidadMilitar, String orderBy, String orderMode) {
        Slice<CentroCostoCompaniaUnidadMilitar> centrosCostosCompaniasUnidadesMilitares = centroCostoCompaniaUnidadMilitarRepository.findAllCentrosCostosCompaniasUnidadesMilitaresPag(pageable, idCentroCostoCompaniaUnidadMilitar, keyword, nombreCompaniaUnidadMilitar, orderBy, orderMode);
        return centrosCostosCompaniasUnidadesMilitares.map(centroCostoCompaniaUnidadMilitar -> centroCostoCompaniaUnidadMilitarDAO.centroCostoCompaniaUnidadMilitarDTO(centroCostoCompaniaUnidadMilitar));
    }
    
    //CREAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE CREAR REGISTRO.
    public RespuestaDTO crearCentroCostoCompaniaUnidadMilitar(CentroCostoCompaniaUnidadMilitarDTO centroCostoCompaniaUnidadMilitarDTO) {
        Long maxIdCentroCostoCompaniaUnidadMilitar = null;
        CentroCostoCompaniaUnidadMilitar centroCostoCompaniaUnidadMilitarNombreYCompania = centroCostoCompaniaUnidadMilitarRepository.findByNombreCompaniaUnidadMilitarAndCentroCostoCompaniaUnidadMilitar(centroCostoCompaniaUnidadMilitarDTO.getCompaniaUnidadMilitarDTO().getNombreCompaniaUnidadMilitar(), centroCostoCompaniaUnidadMilitarDTO.getCentroCostoCompaniaUnidadMilitar().toUpperCase());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_CREADO, false);
        
        //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
        long banderaNombreRegistroEncontrado = 0;
        
        if (!(centroCostoCompaniaUnidadMilitarNombreYCompania == null)) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS Y ASOCIADO A UNA MISMA COMPAÑIA DE UNIDAD MILITAR MUESTRA UN MENSAJE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
           banderaNombreRegistroEncontrado = 1;
        }
        
        if (banderaNombreRegistroEncontrado == 1) {//SI ENCONTRO EL CENTRO DE COSTO DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS Y ASOCIADO A UNA MISMA COMPAÑIA DE UNIDAD MILITAR MUESTRA UN MENSAJE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CENTRO_COSTO_YA_EXISTE, false);
           respuestaDTO.setCentroCostoCompaniaUnidadMilitarDTO(null);
        }
        if (banderaNombreRegistroEncontrado == 0) {//SI NO ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS Y ASOCIADO A UNA MISMA COMPAÑIA DE UNIDAD MILITAR CREA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO CREADO EXITOSAMENTE.
           maxIdCentroCostoCompaniaUnidadMilitar = centroCostoCompaniaUnidadMilitarRepository.findMaxIdCentroCostoCompaniaUnidadMilitar();
           if (maxIdCentroCostoCompaniaUnidadMilitar == null) {//ESTO SE HACE EN CASO DE QUE SI LA TABLA DE LA BASE DE DATOS ESTA EN BLANCO Y VA SER EL PRIMER REGISTRO AL OBTENER UN VALOR NULO, SE ASIGNE CERO (0) AUTOMÁTICAMENTE.
              maxIdCentroCostoCompaniaUnidadMilitar = Long.valueOf(0);
           }
           centroCostoCompaniaUnidadMilitarDTO.setIdCentroCostoCompaniaUnidadMilitar(maxIdCentroCostoCompaniaUnidadMilitar + 1);//OBTENGO EL ID MAXIMO AUTOMATICO, SUMO (1) ENTERO PARA OBTENER EL NUEVO ID.
           centroCostoCompaniaUnidadMilitarRepository.save(centroCostoCompaniaUnidadMilitarDAO.centroCostoCompaniaUnidadMilitar(centroCostoCompaniaUnidadMilitarDTO));
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CREADO_EXITO, true);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR ID:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarCentroCostoCompaniaUnidadMilitarporId(Long idCentroCostoCompaniaUnidadMilitar) {
        Optional<CentroCostoCompaniaUnidadMilitar> centroCostoCompaniaUnidadMilitarId = centroCostoCompaniaUnidadMilitarRepository.findByIdCentroCostoCompaniaUnidadMilitar(Long.valueOf(idCentroCostoCompaniaUnidadMilitar));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (centroCostoCompaniaUnidadMilitarId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO.setCentroCostoCompaniaUnidadMilitarDTO(centroCostoCompaniaUnidadMilitarDAO.centroCostoCompaniaUnidadMilitarDTO(centroCostoCompaniaUnidadMilitarId.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (centroCostoCompaniaUnidadMilitarId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE CONSULTA NO EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setCentroCostoCompaniaUnidadMilitarDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR NOMBRE Y NOMBRE COMPAÑIA DE UNIDAD MILITAR:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarCentroCostoCompaniaUnidadMilitarporNombreYNombreCompaniaUnidadMilitar(String centroCostoCompaniaUnidadMilitar, String nombreCompaniaUnidadMilitar) {
        Optional<CentroCostoCompaniaUnidadMilitar> centroCostoCompaniaUnidadMilitarNombre = Optional.ofNullable(centroCostoCompaniaUnidadMilitarRepository.findByNombreCompaniaUnidadMilitarAndCentroCostoCompaniaUnidadMilitar(String.valueOf(nombreCompaniaUnidadMilitar), String.valueOf(centroCostoCompaniaUnidadMilitar)));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CENTRO_COSTO_Y_COMPANIA_UNIDAD_MILITAR_NO_ENCONTRADOS, false);
        
        if (centroCostoCompaniaUnidadMilitarNombre.isPresent() == true) {//SI ENCONTRO EL CENTRO DE COSTO Y NOMBRE DE LA COMPAÑIA DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL NOMBRE PROPORCIONADO.
           respuestaDTO.setCentroCostoCompaniaUnidadMilitarDTO(centroCostoCompaniaUnidadMilitarDAO.centroCostoCompaniaUnidadMilitarDTO(centroCostoCompaniaUnidadMilitarNombre.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (centroCostoCompaniaUnidadMilitarNombre.isPresent() == false) {//SI NO ENCONTRO EL CENTRO DE COSTO Y NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE CONSULTA NO EXITOSA CON EL NOMBRE PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CENTRO_COSTO_Y_COMPANIA_UNIDAD_MILITAR_NO_ENCONTRADOS, false);
           respuestaDTO.setCentroCostoCompaniaUnidadMilitarDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //MODIFICAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE MODIFICAR REGISTRO.
    public RespuestaDTO actualizarCentroCostoCompaniaUnidadMilitar(CentroCostoCompaniaUnidadMilitarDTO centroCostoCompaniaUnidadMilitarDTO) {
        Optional<CentroCostoCompaniaUnidadMilitar> centroCostoCompaniaUnidadMilitarId = centroCostoCompaniaUnidadMilitarRepository.findByIdCentroCostoCompaniaUnidadMilitar(centroCostoCompaniaUnidadMilitarDTO.getIdCentroCostoCompaniaUnidadMilitar());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
        
        if (centroCostoCompaniaUnidadMilitarId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE VERIFICA EL NOMBRE DEL REGISTRO CON EL ID PROPORCIONADO.
           if (centroCostoCompaniaUnidadMilitarDTO.getCentroCostoCompaniaUnidadMilitar().equals(centroCostoCompaniaUnidadMilitarId.get().getCentroCostoCompaniaUnidadMilitar()) == true) {//SI EL NOMBRE DIGITADO ES IGUAL AL NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
              centroCostoCompaniaUnidadMilitarRepository.save(centroCostoCompaniaUnidadMilitarDAO.centroCostoCompaniaUnidadMilitar(centroCostoCompaniaUnidadMilitarDTO));
              respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
           }
           if (centroCostoCompaniaUnidadMilitarDTO.getCentroCostoCompaniaUnidadMilitar().equals(centroCostoCompaniaUnidadMilitarId.get().getCentroCostoCompaniaUnidadMilitar()) == false) {//SI EL NOMBRE DIGITADO ES DIFERENTE AL NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS SE REALIZA BUSQUEDA PARA VERIFICAR SI ESTE NOMBRE DIGITADO EXISTE EN OTROS REGISTROS Y ASOCIADOS A UNA MISMA COMPAÑIA DE UNIDAD MILITAR.
              CentroCostoCompaniaUnidadMilitar centroCostoCompaniaUnidadMilitarNombreYCompania = centroCostoCompaniaUnidadMilitarRepository.findByNombreCompaniaUnidadMilitarAndCentroCostoCompaniaUnidadMilitar(centroCostoCompaniaUnidadMilitarDTO.getCompaniaUnidadMilitarDTO().getNombreCompaniaUnidadMilitar(), centroCostoCompaniaUnidadMilitarDTO.getCentroCostoCompaniaUnidadMilitar().toUpperCase());
              
              //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
              long banderaNombreRegistroEncontrado = 0;
              
              if (!(centroCostoCompaniaUnidadMilitarNombreYCompania == null)) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS Y ASOCIADO A UNA MISMA COMPAÑIA DE UNIDAD MILITAR MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
                 banderaNombreRegistroEncontrado = 1;
              }
              
              if (banderaNombreRegistroEncontrado == 1) {//SI LA BUSQUEDA OBTIENE QUE EL CENTRO DE COSTO DIGITADO ES DIFERENTE DE NULO SIGNIFICA QUE ENCONTRO EL MISMO NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS Y ASOCIADO A UNA MISMA COMPAÑIA DE UNIDAD MILITAR Y MUESTRA UN MENSAJE DE NOMBRE DEL REGISTRO REPETIDO.
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CENTRO_COSTO_YA_EXISTE, false);
                 respuestaDTO.setCentroCostoCompaniaUnidadMilitarDTO(null);
              }
              if (banderaNombreRegistroEncontrado == 0) {//SI LA BUSQUEDA OBTIENE QUE EL CENTRO DE COSTO DIGITADO ES NULO EN LA TABLA DE LA BASE DE DATOS Y ASOCIADO A UNA MISMA COMPAÑIA DE UNIDAD MILITAR SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
                 centroCostoCompaniaUnidadMilitarRepository.save(centroCostoCompaniaUnidadMilitarDAO.centroCostoCompaniaUnidadMilitar(centroCostoCompaniaUnidadMilitarDTO));
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
              }
           }
        }
        if (centroCostoCompaniaUnidadMilitarId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MUESTRA UN MENSAJE DE REGISTRO NO MODIFICADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
           respuestaDTO.setCentroCostoCompaniaUnidadMilitarDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //ELIMINAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE ELIMINAR REGISTRO.
    public RespuestaDTO eliminarCentroCostoCompaniaUnidadMilitar(Long idCentroCostoCompaniaUnidadMilitar) {
        Optional<CentroCostoCompaniaUnidadMilitar> centroCostoCompaniaUnidadMilitarId = centroCostoCompaniaUnidadMilitarRepository.findById(idCentroCostoCompaniaUnidadMilitar);
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (centroCostoCompaniaUnidadMilitarId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO.setCentroCostoCompaniaUnidadMilitarDTO(centroCostoCompaniaUnidadMilitarDAO.centroCostoCompaniaUnidadMilitarDTO(centroCostoCompaniaUnidadMilitarId.get()));
           centroCostoCompaniaUnidadMilitarRepository.delete(centroCostoCompaniaUnidadMilitarId.get());
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ELIMINADO_EXITO, true);
        }
        if (centroCostoCompaniaUnidadMilitarId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS NO ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO NO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setCentroCostoCompaniaUnidadMilitarDTO(null);
        }
        
        return respuestaDTO;
    }
}
