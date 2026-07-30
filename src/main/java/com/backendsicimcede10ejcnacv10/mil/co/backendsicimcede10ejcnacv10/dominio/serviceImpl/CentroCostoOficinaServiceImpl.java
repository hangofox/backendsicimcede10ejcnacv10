//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.serviceImpl;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.Constantes.MensajesConstantes;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.CentroCostoOficinaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service.CentroCostoOficinaService;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao.CentroCostoOficinaDAO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.CentroCostoOficina;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.CentroCostoOficinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
* * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 01/08/2023.
* Esta es la declaración de la implementación del servicio.
* Se inyectan DAOS y repositorios.
*/
@Service//DECLARACIÓN DE LA IMPLEMENTACIÓN DEL SERVICIO.
//DECLARACIÓN DE LA CLASE DE LA IMPLEMENTACIÓN DEL SERVICIO:
public class CentroCostoOficinaServiceImpl implements CentroCostoOficinaService {
    
    @Autowired//INYECTAMOS EL DAO.
    private CentroCostoOficinaDAO centroCostoOficinaDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private CentroCostoOficinaRepository centroCostoOficinaRepository;
    
    //CONTADOR DE REGISTROS FILTRADOS.
    //CONTAR TOTAL DE REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE CONTEO.
    public Long contarTotalRegistros(Long idCentroCostoOficina, String keyword, String siglaoAcronimoUnidadMilitar, String nombreOficina) {
        return centroCostoOficinaRepository.findTotalRegistros(idCentroCostoOficina, keyword, siglaoAcronimoUnidadMilitar, nombreOficina);
    }
    
    //LISTADO DE REGISTROS FILTRADOS SIN PAGINACIÓN.
    //LISTAR REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public List<CentroCostoOficinaDTO> listarCentrosCostosOficinas(Long idCentroCostoOficina, String keyword, String siglaoAcronimoUnidadMilitar, String nombreOficina, String orderBy, String orderMode) {
        List<CentroCostoOficina> centrosCostosOficinas = centroCostoOficinaRepository.findAllCentrosCostosOficinas(idCentroCostoOficina, keyword, siglaoAcronimoUnidadMilitar, nombreOficina, orderBy, orderMode);
        List<CentroCostoOficinaDTO> centroCostoOficinaDTOS = new ArrayList<>();
        for (CentroCostoOficina centroCostoOficina : centrosCostosOficinas) {
            centroCostoOficinaDTOS.add(centroCostoOficinaDAO.centroCostoOficinaDTO(centroCostoOficina));
        }
        
        return centroCostoOficinaDTOS;
    }
    
    //LISTADO DE REGISTROS FILTRADOS CON PAGINACIÓN.
    //LISTAR REGISTROS CON PAGINACIÓN:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public Slice<CentroCostoOficinaDTO> listarCentrosCostosOficinasPag(Pageable pageable, Long idCentroCostoOficina, String keyword, String siglaoAcronimoUnidadMilitar, String nombreOficina, String orderBy, String orderMode) {
        Slice<CentroCostoOficina> centrosCostosOficinas = centroCostoOficinaRepository.findAllCentrosCostosOficinasPag(pageable, idCentroCostoOficina, keyword, siglaoAcronimoUnidadMilitar, nombreOficina, orderBy, orderMode);
        return centrosCostosOficinas.map(centroCostoOficina -> centroCostoOficinaDAO.centroCostoOficinaDTO(centroCostoOficina));
    }
    
    //CREAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE CREAR REGISTRO.
    public RespuestaDTO crearCentroCostoOficina(CentroCostoOficinaDTO centroCostoOficinaDTO) {
        Long maxIdCentroCostoOficina = null;
        CentroCostoOficina centroCostoOficinaNumeroDocumentoIdentificacion = centroCostoOficinaRepository.findByCentroCostoOficina(centroCostoOficinaDTO.getCentroCostoOficina());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_CREADO, false);
        
        //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
        long banderaCentroCostoRegistroEncontrado=0;
        
        if (!(centroCostoOficinaNumeroDocumentoIdentificacion==null)) {//SI ENCONTRO EL CENTRO DE COSTO DE LA OFICINA DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE CENTRO DE COSTO DE LA OFICINA DE REGISTRO REPETIDO CON EL CENTRO DE COSTO DE LA OFICINA PROPORCIONADO.
           banderaCentroCostoRegistroEncontrado=1;
        }
        
        //System.out.println("INGRESA METODO CREAR.");
        if (banderaCentroCostoRegistroEncontrado==1) {//SI ENCONTRO EL CENTRO DE COSTO DE LA OFICINA DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE CENTRO DE COSTO DE LA OFICINA DE REGISTRO REPETIDO CON EL CENTRO DE COSTO DE LA OFICINA PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CENTRO_COSTO_YA_EXISTE, false);
           respuestaDTO.setCentroCostoOficinaDTO(null);
        }
        if ((banderaCentroCostoRegistroEncontrado==0)) {//SI NO ENCONTRO EL CENTRO DE COSTO DE LA OFICINA DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS CREA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO CREADO EXITOSAMENTE CON EL CENTRO DE COSTO DE LA OFICINA PROPORCIONADO.
           maxIdCentroCostoOficina = centroCostoOficinaRepository.findMaxIdCentroCostoOficina();
           if (maxIdCentroCostoOficina==null) {//ESTO SE HACE EN CASO DE QUE SI LA TABLA DE LA BASE DE DATOS ESTA EN BLANCO Y VA SER EL PRIMER REGISTRO AL OBTENER UN VALOR NULO, SE ASIGNE CERO (0) AUTOMÁTICAMENTE PORQUE SI NO ARROJARIA UN ERROR DE CONVERSIÓN DE CARACTER NULO AL SUMAR CON NÚMERO ENTERO.
              maxIdCentroCostoOficina=Long.valueOf(0);
           }
           centroCostoOficinaDTO.setIdCentroCostoOficina(maxIdCentroCostoOficina+1);//OBTENGO EL ID MAXIMO AUTOMATICO, SUMO (1) ENTERO PARA OBTENER EL NUEVO ID.
           
           centroCostoOficinaRepository.save(centroCostoOficinaDAO.centroCostoOficina(centroCostoOficinaDTO));
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CREADO_EXITO, true);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR ID:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarCentroCostoOficinaporId(Long idCentroCostoOficina) {
        Optional<CentroCostoOficina> centroCostoOficinaId = centroCostoOficinaRepository.findByIdCentroCostoOficina(Long.valueOf(idCentroCostoOficina));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        //CentroCostoOficinaDTO centroCostoOficinaDTO = null;
        if (centroCostoOficinaId.isPresent()==true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL ID PROPORCIONADO.
           //centroCostoOficinaDTO.setNombreTipoDocumentoIdentificacion("CEDULA");
           respuestaDTO.setCentroCostoOficinaDTO(centroCostoOficinaDAO.centroCostoOficinaDTO(centroCostoOficinaId.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (centroCostoOficinaId.isPresent()==false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setCentroCostoOficinaDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR CENTRO DE COSTO DE LA OFICINA Y NOMBRE DE LA OFICINA:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarCentroCostoOficinaporCentroCostoyNombreOficina(String centroCostoOficina, String nombreOficina) {
        Optional<CentroCostoOficina> centroCostoOficinaCentroCosto = Optional.ofNullable(centroCostoOficinaRepository.findByCentroCostoOficinaAndNombreOficina(String.valueOf(centroCostoOficina), String.valueOf(nombreOficina)));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CENTRO_COSTO_Y_OFICINA_NO_ENCONTRADOS, false);
        
        if (centroCostoOficinaCentroCosto.isPresent() == true) {//SI ENCONTRO EL CENTRO DE COSTO Y EL NOMBRE DE LA OFICINA EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA.
           respuestaDTO.setCentroCostoOficinaDTO(centroCostoOficinaDAO.centroCostoOficinaDTO(centroCostoOficinaCentroCosto.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (centroCostoOficinaCentroCosto.isPresent() == false) {//SI NO ENCONTRO EL CENTRO DE COSTO Y EL NOMBRE DE LA OFICINA EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE CONSULTA NO EXITOSA.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CENTRO_COSTO_Y_OFICINA_NO_ENCONTRADOS, false);
           respuestaDTO.setCentroCostoOficinaDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //MODIFICAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE MODIFICAR REGISTRO.
    public RespuestaDTO actualizarCentroCostoOficina(CentroCostoOficinaDTO centroCostoOficinaDTO) {
        Optional<CentroCostoOficina> centroCostoOficinaId = centroCostoOficinaRepository.findByIdCentroCostoOficina(centroCostoOficinaDTO.getIdCentroCostoOficina());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
        
        if (centroCostoOficinaId.isPresent()==true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE VERIFICA EL CENTRO DE COSTO DE LA OFICINA DEL REGISTRO CON EL ID PROPORCIONADO.
           if ( (centroCostoOficinaDTO.getCentroCostoOficina().equals(centroCostoOficinaId.get().getCentroCostoOficina())==true) ) {//SI EL CENTRO DE COSTO DE LA OFICINA DIGITADO ES IGUAL AL CENTRO DE COSTO DE LA OFICINA EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
              CentroCostoOficina centroCostoOficina = centroCostoOficinaDAO.centroCostoOficina(centroCostoOficinaDTO);
              centroCostoOficinaRepository.save(centroCostoOficina);
              respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
           }
           if (centroCostoOficinaDTO.getCentroCostoOficina().equals(centroCostoOficinaId.get().getCentroCostoOficina())==false) {//SI EL CENTRO DE COSTO DE LA OFICINA O NICKNAME DIGITADO ES DIFERENTE AL CENTRO DE COSTO DE LA OFICINA O NICKNAME ALMACENADO EN LA TABLA DE LA BASE DE DATOS SE REALIZA BUSQUEDA PARA VERIFICAR SI ESTE CENTRO DE COSTO DE LA OFICINA O NICKNAME DIGITADO EXISTE EN OTROS REGISTROS.
              //consulte por CENTRO DE COSTO DE LA OFICINA e imprima si existe y si no existe
              CentroCostoOficina centroCostoOficinaCodigo = centroCostoOficinaRepository.findByCentroCostoOficina(centroCostoOficinaDTO.getCentroCostoOficina());
              
              //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
              long banderaCentroCostoRegistroEncontrado=0;
              
              if (!(centroCostoOficinaCodigo==null)) {//SI ENCONTRO EL CENTRO DE COSTO DE LA OFICINA DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE CENTRO DE COSTO DE LA OFICINA DE REGISTRO REPETIDO CON EL CENTRO DE COSTO DE LA OFICINA PROPORCIONADO.
                 banderaCentroCostoRegistroEncontrado=1;
              }
              
              if (banderaCentroCostoRegistroEncontrado==1) {//SI LA BUSQUEDA OBTIENE QUE EL CENTRO DE COSTO DE LA OFICINA DIGITADO Y BUSCADO ES DIFERENTE DE NULO SIGNIFICA QUE ENCONTRO EL MISMO CENTRO DE COSTO DE LA OFICINA ALMACENADO EN LA TABLA DE LA BASE DE DATOS Y MUESTRA UN MENSAJE DE CENTRO DE COSTO DE LA OFICINA DEL REGISTRO REPETIDO.
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CENTRO_COSTO_YA_EXISTE, false);
                 respuestaDTO.setCentroCostoOficinaDTO(null);
              }
              if (banderaCentroCostoRegistroEncontrado==0) {//SI LA BUSQUEDA OBTIENE QUE EL CENTRO DE COSTO DE LA OFICINA DIGITADO Y BUSCADO ES NULO EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
                 CentroCostoOficina centroCostoOficina = centroCostoOficinaDAO.centroCostoOficina(centroCostoOficinaDTO);
                 centroCostoOficinaRepository.save(centroCostoOficina);
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
              }
           }
        }
        if (centroCostoOficinaId.isPresent()==false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MUESTRA UN MENSAJE DE REGISTRO NO MODIFICADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
           respuestaDTO.setCentroCostoOficinaDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //ELIMINAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE ELIMINAR REGISTRO.
    public RespuestaDTO eliminarCentroCostoOficina(Long idCentroCostoOficina) {
        Optional<CentroCostoOficina> centroCostoOficinaId = centroCostoOficinaRepository.findById(idCentroCostoOficina);
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (centroCostoOficinaId.isPresent()==true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO.setCentroCostoOficinaDTO(centroCostoOficinaDAO.centroCostoOficinaDTO(centroCostoOficinaId.get()));
            centroCostoOficinaRepository.delete(centroCostoOficinaId.get());
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ELIMINADO_EXITO, true);
        }
        if (centroCostoOficinaId.isPresent()==false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS NO ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO NO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setCentroCostoOficinaDTO(null);
        }
        
        return respuestaDTO;
    }
}
