//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.serviceImpl;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.Constantes.MensajesConstantes;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.CentroCostoUnidadMilitarDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service.CentroCostoUnidadMilitarService;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao.CentroCostoUnidadMilitarDAO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.CentroCostoUnidadMilitar;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.CentroCostoUnidadMilitarRepository;
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
public class CentroCostoUnidadMilitarServiceImpl implements CentroCostoUnidadMilitarService {
    
    @Autowired//INYECTAMOS EL DAO.
    private CentroCostoUnidadMilitarDAO centroCostoUnidadMilitarDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private CentroCostoUnidadMilitarRepository centroCostoUnidadMilitarRepository;
    
    //CONTADOR DE REGISTROS FILTRADOS.
    //CONTAR TOTAL DE REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE CONTEO.
    public Long contarTotalRegistros(Long idCentroCostoUnidadMilitar, String keyword, String siglaoAcronimoUnidadMilitar) {
        return centroCostoUnidadMilitarRepository.findTotalRegistros(idCentroCostoUnidadMilitar, keyword, siglaoAcronimoUnidadMilitar);
    }
    
    //LISTADO DE REGISTROS FILTRADOS SIN PAGINACIÓN.
    //LISTAR REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public List<CentroCostoUnidadMilitarDTO> listarCentrosCostosUnidadesMilitares(Long idCentroCostoUnidadMilitar, String keyword, String siglaoAcronimoUnidadMilitar, String orderBy, String orderMode) {
        List<CentroCostoUnidadMilitar> centrosCostosUnidadesMilitares = centroCostoUnidadMilitarRepository.findAllCentrosCostosUnidadesMilitares(idCentroCostoUnidadMilitar, keyword, siglaoAcronimoUnidadMilitar, orderBy, orderMode);
        List<CentroCostoUnidadMilitarDTO> centroCostoUnidadMilitarDTOS = new ArrayList<>();
        for (CentroCostoUnidadMilitar centroCostoUnidadMilitar : centrosCostosUnidadesMilitares) {
            centroCostoUnidadMilitarDTOS.add(centroCostoUnidadMilitarDAO.centroCostoUnidadMilitarDTO(centroCostoUnidadMilitar));
        }
        
        return centroCostoUnidadMilitarDTOS;
    }
    
    //LISTADO DE REGISTROS FILTRADOS CON PAGINACIÓN.
    //LISTAR REGISTROS PAGINADOS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS PAGINADOS.
    public Slice<CentroCostoUnidadMilitarDTO> listarCentrosCostosUnidadesMilitaresPag(Pageable pageable, Long idCentroCostoUnidadMilitar, String keyword, String siglaoAcronimoUnidadMilitar, String orderBy, String orderMode) {
        Slice<CentroCostoUnidadMilitar> centrosCostosUnidadesMilitares = centroCostoUnidadMilitarRepository.findAllCentrosCostosUnidadesMilitaresPag(pageable, idCentroCostoUnidadMilitar, keyword, siglaoAcronimoUnidadMilitar, orderBy, orderMode);
        return centrosCostosUnidadesMilitares.map(centroCostoUnidadMilitar -> centroCostoUnidadMilitarDAO.centroCostoUnidadMilitarDTO(centroCostoUnidadMilitar));
    }
    
    //CREAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE CREAR REGISTRO.
    public RespuestaDTO crearCentroCostoUnidadMilitar(CentroCostoUnidadMilitarDTO centroCostoUnidadMilitarDTO) {
        Long maxIdCentroCostoUnidadMilitar = null;
        CentroCostoUnidadMilitar centroCostoUnidadMilitarCentroySigla = centroCostoUnidadMilitarRepository.findByCentroCostoUnidadMilitarAndSiglaoAcronimoUnidadMilitar(centroCostoUnidadMilitarDTO.getCentroCostoUnidadMilitar().toUpperCase(), centroCostoUnidadMilitarDTO.getUnidadMilitarDTO().getSiglaoAcronimoUnidadMilitar());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_CREADO, false);
        
        //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
        long banderaNombreRegistroEncontrado = 0;
        
        if (!(centroCostoUnidadMilitarCentroySigla == null)) {//SI ENCONTRO EL CENTRO DE COSTO DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS Y ASOCIADO A UNA MISMA UNIDAD MILITAR MUESTRA UN MENSAJE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
           banderaNombreRegistroEncontrado = 1;
        }
        
        if (banderaNombreRegistroEncontrado == 1) {//SI ENCONTRO EL CENTRO DE COSTO DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS Y ASOCIADO A UNA MISMA UNIDAD MILITAR MUESTRA UN MENSAJE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CENTRO_COSTO_YA_EXISTE, false);
           respuestaDTO.setCentroCostoUnidadMilitarDTO(null);
        }
        if (banderaNombreRegistroEncontrado == 0) {//SI NO ENCONTRO EL CENTRO DE COSTO DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS Y ASOCIADO A UNA MISMA UNIDAD MILITAR CREA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO CREADO EXITOSAMENTE.
           maxIdCentroCostoUnidadMilitar = centroCostoUnidadMilitarRepository.findMaxIdCentroCostoUnidadMilitar();
           if (maxIdCentroCostoUnidadMilitar == null) {//ESTO SE HACE EN CASO DE QUE SI LA TABLA DE LA BASE DE DATOS ESTA EN BLANCO Y VA SER EL PRIMER REGISTRO AL OBTENER UN VALOR NULO, SE ASIGNE CERO (0) AUTOMÁTICAMENTE.
              maxIdCentroCostoUnidadMilitar = Long.valueOf(0);
           }
           centroCostoUnidadMilitarDTO.setIdCentroCostoUnidadMilitar(maxIdCentroCostoUnidadMilitar + 1);//OBTENGO EL ID MAXIMO AUTOMATICO, SUMO (1) ENTERO PARA OBTENER EL NUEVO ID.
           centroCostoUnidadMilitarRepository.save(centroCostoUnidadMilitarDAO.centroCostoUnidadMilitar(centroCostoUnidadMilitarDTO));
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CREADO_EXITO, true);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR ID:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarCentroCostoUnidadMilitarporId(Long idCentroCostoUnidadMilitar) {
        Optional<CentroCostoUnidadMilitar> centroCostoUnidadMilitarId = centroCostoUnidadMilitarRepository.findByIdCentroCostoUnidadMilitar(Long.valueOf(idCentroCostoUnidadMilitar));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (centroCostoUnidadMilitarId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO.setCentroCostoUnidadMilitarDTO(centroCostoUnidadMilitarDAO.centroCostoUnidadMilitarDTO(centroCostoUnidadMilitarId.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (centroCostoUnidadMilitarId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE CONSULTA NO EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setCentroCostoUnidadMilitarDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR CENTRO Y SIGLA O ACRONIMO DE UNIDAD MILITAR:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarCentroCostoUnidadMilitarporCentroCostoySiglaoAcronimoUnidadMilitar(String centroCostoUnidadMilitar, String siglaoAcronimoUnidadMilitar) {
        Optional<CentroCostoUnidadMilitar> centroCostoUnidadMilitarCentroCosto = Optional.ofNullable(centroCostoUnidadMilitarRepository.findByCentroCostoUnidadMilitarAndSiglaoAcronimoUnidadMilitar(String.valueOf(centroCostoUnidadMilitar), String.valueOf(siglaoAcronimoUnidadMilitar)));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CENTRO_COSTO_Y_UNIDAD_MILITAR_NO_ENCONTRADOS, false);
        
        if (centroCostoUnidadMilitarCentroCosto.isPresent() == true) {//SI ENCONTRO EL CENTRO DE COSTO Y UNIDAD MILITAR DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL CENTRO DE COSTO PROPORCIONADO.
           respuestaDTO.setCentroCostoUnidadMilitarDTO(centroCostoUnidadMilitarDAO.centroCostoUnidadMilitarDTO(centroCostoUnidadMilitarCentroCosto.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (centroCostoUnidadMilitarCentroCosto.isPresent() == false) {//SI NO ENCONTRO EL CENTRO DE COSTO Y UNIDAD MIITAR DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE CONSULTA NO EXITOSA CON EL CENTRO DE COSTO PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CENTRO_COSTO_Y_UNIDAD_MILITAR_NO_ENCONTRADOS, false);
           respuestaDTO.setCentroCostoUnidadMilitarDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //MODIFICAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE MODIFICAR REGISTRO.
    public RespuestaDTO actualizarCentroCostoUnidadMilitar(CentroCostoUnidadMilitarDTO centroCostoUnidadMilitarDTO) {
        Optional<CentroCostoUnidadMilitar> centroCostoUnidadMilitarId = centroCostoUnidadMilitarRepository.findByIdCentroCostoUnidadMilitar(centroCostoUnidadMilitarDTO.getIdCentroCostoUnidadMilitar());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
        
        if (centroCostoUnidadMilitarId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE VERIFICA EL CENTRO DE COSTO DEL REGISTRO CON EL ID PROPORCIONADO.
           if (centroCostoUnidadMilitarDTO.getCentroCostoUnidadMilitar().equals(centroCostoUnidadMilitarId.get().getCentroCostoUnidadMilitar()) == true) {//SI EL CENTRO DE COSTO DIGITADO ES IGUAL AL ALMACENADO EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
              centroCostoUnidadMilitarRepository.save(centroCostoUnidadMilitarDAO.centroCostoUnidadMilitar(centroCostoUnidadMilitarDTO));
              respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
           }
           if (centroCostoUnidadMilitarDTO.getCentroCostoUnidadMilitar().equals(centroCostoUnidadMilitarId.get().getCentroCostoUnidadMilitar()) == false) {//SI EL CENTRO DE COSTO DIGITADO ES DIFERENTE AL ALMACENADO EN LA TABLA DE LA BASE DE DATOS SE REALIZA BUSQUEDA PARA VERIFICAR SI ESTE CENTRO DE COSTO DIGITADO EXISTE EN OTROS REGISTROS Y ASOCIADOS A UNA MISMA UNIDAD MILITAR.
              CentroCostoUnidadMilitar centroCostoUnidadMilitarCentroySigla = centroCostoUnidadMilitarRepository.findByCentroCostoUnidadMilitarAndSiglaoAcronimoUnidadMilitar(centroCostoUnidadMilitarDTO.getCentroCostoUnidadMilitar().toUpperCase(), centroCostoUnidadMilitarDTO.getUnidadMilitarDTO().getSiglaoAcronimoUnidadMilitar());
              
              //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
              long banderaNombreRegistroEncontrado = 0;
              
              if (!(centroCostoUnidadMilitarCentroySigla == null)) {//SI ENCONTRO EL CENTRO DE COSTO DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS Y ASOCIADO A UNA MISMA UNIDAD MILITAR MUESTRA UN MENSAJE DE CENTRO DE COSTO REPETIDO.
                 banderaNombreRegistroEncontrado = 1;
              }
              
              if (banderaNombreRegistroEncontrado == 1) {//SI LA BUSQUEDA OBTIENE QUE EL CENTRO DE COSTO DIGITADO ES DIFERENTE DE NULO SIGNIFICA QUE ENCONTRO EL MISMO CENTRO DE COSTO ALMACENADO EN LA TABLA DE LA BASE DE DATOS Y ASOCIADO A UNA MISMA UNIDAD MILITAR Y MUESTRA UN MENSAJE DE NOMBRE DEL REGISTRO REPETIDO.
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CENTRO_COSTO_YA_EXISTE, false);
                 respuestaDTO.setCentroCostoUnidadMilitarDTO(null);
              }
              if (banderaNombreRegistroEncontrado == 0) {//SI LA BUSQUEDA OBTIENE QUE EL CENTRO DE COSTO DIGITADO ES NULO EN LA TABLA DE LA BASE DE DATOS Y ASOCIADO A UNA MISMA UNIDAD MILITAR SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
                 centroCostoUnidadMilitarRepository.save(centroCostoUnidadMilitarDAO.centroCostoUnidadMilitar(centroCostoUnidadMilitarDTO));
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
              }
           }
        }
        if (centroCostoUnidadMilitarId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MUESTRA UN MENSAJE DE REGISTRO NO MODIFICADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
           respuestaDTO.setCentroCostoUnidadMilitarDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //ELIMINAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE ELIMINAR REGISTRO.
    public RespuestaDTO eliminarCentroCostoUnidadMilitar(Long idCentroCostoUnidadMilitar) {
        Optional<CentroCostoUnidadMilitar> centroCostoUnidadMilitarId = centroCostoUnidadMilitarRepository.findById(idCentroCostoUnidadMilitar);
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (centroCostoUnidadMilitarId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO.setCentroCostoUnidadMilitarDTO(centroCostoUnidadMilitarDAO.centroCostoUnidadMilitarDTO(centroCostoUnidadMilitarId.get()));
           centroCostoUnidadMilitarRepository.delete(centroCostoUnidadMilitarId.get());
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ELIMINADO_EXITO, true);
        }
        if (centroCostoUnidadMilitarId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS NO ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO NO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setCentroCostoUnidadMilitarDTO(null);
        }
        
        return respuestaDTO;
    }
}
