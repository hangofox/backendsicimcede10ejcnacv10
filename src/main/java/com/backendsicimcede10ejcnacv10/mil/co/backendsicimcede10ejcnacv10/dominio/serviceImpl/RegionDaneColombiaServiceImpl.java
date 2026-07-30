//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.serviceImpl;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.Constantes.MensajesConstantes;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RegionDaneColombiaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service.RegionDaneColombiaService;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao.RegionDaneColombiaDAO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.RegionDaneColombia;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.RegionDaneColombiaRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
public class RegionDaneColombiaServiceImpl implements RegionDaneColombiaService {
    
    @Autowired//INYECTAMOS EL DAO.
    private RegionDaneColombiaDAO regionDaneColombiaDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private RegionDaneColombiaRepository regionDaneColombiaRepository;
    
    //1. CONTADORES DE REGISTROS FILTRADOS.
    //CONTAR TOTAL DE REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE CONTEO.
    public Long contarTotalRegistros() {
        Long totalRegistros = regionDaneColombiaRepository.findTotalRegistros();
        return totalRegistros;
    }
    
    //2. CONTADORES DE REGISTROS FILTRADOS.
    //CONTAR TOTAL DE REGISTROS POR PALABRA CLAVE:
    @Override//SOBREESCRIBIMOS EL METODO DE CONTEO.
    public Long contarTotalRegistrosporPalabraClave(String keyword) {
        Long totalRegistrosporPalabraClave = regionDaneColombiaRepository.findTotalRegistrosByKeyword(keyword);
        return totalRegistrosporPalabraClave;
    }
    
    //1. LISTADO DE REGISTROS FILTRADOS.
    //LISTAR REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public List<RegionDaneColombiaDTO> listarRegionesDaneColombia() {
        List<RegionDaneColombia> unidadesMilitares = regionDaneColombiaRepository.findAll();
        List<RegionDaneColombiaDTO> regionDaneColombiaDTOS = new ArrayList<>();
        
        for (RegionDaneColombia regionDaneColombia : unidadesMilitares){
            regionDaneColombiaDTOS.add(regionDaneColombiaDAO.regionDaneColombiaDTO(regionDaneColombia));
        }
        
        return regionDaneColombiaDTOS;
    }
    
    //LISTAR REGISTROS ORDENADOS CON FILTRO OPCIONAL POR PALABRA CLAVE:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public List<RegionDaneColombiaDTO> listarRegionesDaneColombia(String keyword, String orderBy, String orderMode) {
        List<RegionDaneColombia> unidadesMilitares = regionDaneColombiaRepository.findAllRegionesDaneColombia(keyword, orderBy, orderMode);
        List<RegionDaneColombiaDTO> regionDaneColombiaDTOS = new ArrayList<>();
        
        for (RegionDaneColombia regionDaneColombia : unidadesMilitares){
            regionDaneColombiaDTOS.add(regionDaneColombiaDAO.regionDaneColombiaDTO(regionDaneColombia));
        }
        
        return regionDaneColombiaDTOS;
    }
    
    //LISTAR REGISTROS PAGINADOS ORDENADOS CON FILTRO OPCIONAL POR PALABRA CLAVE:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public Slice<RegionDaneColombiaDTO> listarRegionesDaneColombiaPag(Pageable pageable, String keyword, String orderBy, String orderMode) {
        Slice<RegionDaneColombia> unidadesMilitares = regionDaneColombiaRepository.findAllRegionesDaneColombiaPag(pageable, keyword, orderBy, orderMode);
        return unidadesMilitares.map(regionDaneColombia -> regionDaneColombiaDAO.regionDaneColombiaDTO(regionDaneColombia));
    }
    
    //CREAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE CREAR REGISTRO.
    public RespuestaDTO crearRegionDaneColombia(RegionDaneColombiaDTO regionDaneColombiaDTO) {
        Long maxIdRegionDaneColombia=null;
        RegionDaneColombia regionDaneColombiaCodigo = regionDaneColombiaRepository.findByCodigoDaneColombia(regionDaneColombiaDTO.getCodigoDaneColombia());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_CREADO, false);
        
        //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
        long banderaCodigoRegistroEncontrado=0;
        
        if (!(regionDaneColombiaCodigo==null)) {//SI ENCONTRO EL CÓDIGO DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE CÓDIGO DE REGISTRO REPETIDO CON EL CÓDIGO PROPORCIONADO.
           banderaCodigoRegistroEncontrado=1;
        }
        
        //System.out.println("INGRESA METODO CREAR.");
        if (banderaCodigoRegistroEncontrado==1) {//SI ENCONTRO EL CÓDIGO DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE CÓDIGO DE REGISTRO REPETIDO CON EL CÓDIGO PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CODIGO_YA_EXISTE, false);
           respuestaDTO.setRegionDaneColombiaDTO(null);
        }
        if ((banderaCodigoRegistroEncontrado==0)) {//SI NO ENCONTRO EL CÓDIGO DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS CREA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO CREADO EXITOSAMENTE CON EL CÓDIGO PROPORCIONADO.
           maxIdRegionDaneColombia = regionDaneColombiaRepository.findMaxIdRegionDaneColombia();
           if (maxIdRegionDaneColombia==null) {//ESTO SE HACE EN CASO DE QUE SI LA TABLA DE LA BASE DE DATOS ESTA EN BLANCO Y VA SER EL PRIMER REGISTRO AL OBTENER UN VALOR NULO, SE ASIGNE CERO (0) AUTOMÁTICAMENTE PORQUE SI NO ARROJARIA UN ERROR DE CONVERSIÓN DE CARACTER NULO AL SUMAR CON NÚMERO ENTERO.
              maxIdRegionDaneColombia=Long.valueOf(0);
           }
           regionDaneColombiaDTO.setIdRegionDaneColombia(maxIdRegionDaneColombia+1);//OBTENGO EL ID MAXIMO AUTOMATICO, SUMO (1) ENTERO PARA OBTENER EL NUEVO ID.
           
           regionDaneColombiaRepository.save(regionDaneColombiaDAO.regionDaneColombia(regionDaneColombiaDTO));
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CREADO_EXITO, true);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR ID:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarRegionDaneColombiaporId(Long idRegionDaneColombia) {
        Optional<RegionDaneColombia> regionDaneColombiaId = regionDaneColombiaRepository.findByIdRegionDaneColombia(Long.valueOf(idRegionDaneColombia));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (regionDaneColombiaId.isPresent()==true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO.setRegionDaneColombiaDTO(regionDaneColombiaDAO.regionDaneColombiaDTO(regionDaneColombiaId.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (regionDaneColombiaId.isPresent()==false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setRegionDaneColombiaDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR NOMBRE:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarRegionDaneColombiaporNombreCiudadMunicipioDane(String nombreCiudadMunicipioDaneColombia) {
        Optional<RegionDaneColombia> regionDaneColombiaNombreCiudadMunicipio = Optional.ofNullable(regionDaneColombiaRepository.findByNombreCiudadMunicipioDaneColombia(nombreCiudadMunicipioDaneColombia));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_NO_ENCONTRADO, false);
        
        if (regionDaneColombiaNombreCiudadMunicipio.isPresent()==true) {//SI ENCONTRO NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL NOMBRE PROPORCIONADO.
           respuestaDTO.setRegionDaneColombiaDTO(regionDaneColombiaDAO.regionDaneColombiaDTO(regionDaneColombiaNombreCiudadMunicipio.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (regionDaneColombiaNombreCiudadMunicipio.isPresent()==false) {//SI NO ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON EL NOMBRE PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_NO_ENCONTRADO, false);
           respuestaDTO.setRegionDaneColombiaDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR CÓDIGO:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarRegionDaneColombiaporCodigoDane(String codigoDaneColombia) {
        Optional<RegionDaneColombia> regionDaneColombiaCodigoDaneColombia = Optional.ofNullable(regionDaneColombiaRepository.findByCodigoDaneColombia(codigoDaneColombia));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CODIGO_NO_ENCONTRADO, false);
        
        if (regionDaneColombiaCodigoDaneColombia.isPresent()==true) {//SI ENCONTRO CÓDIGO DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL CÓDIGO PROPORCIONADO.
           respuestaDTO.setRegionDaneColombiaDTO(regionDaneColombiaDAO.regionDaneColombiaDTO(regionDaneColombiaCodigoDaneColombia.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (regionDaneColombiaCodigoDaneColombia.isPresent()==false) {//SI NO ENCONTRO EL CÓDIGO DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON EL CÓDIGO PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_NO_ENCONTRADO, false);
           respuestaDTO.setRegionDaneColombiaDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //MODIFICAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE MODIFICAR REGISTRO.
    public RespuestaDTO actualizarRegionDaneColombia(RegionDaneColombiaDTO regionDaneColombiaDTO) {
        Optional<RegionDaneColombia> regionDaneColombiaId = regionDaneColombiaRepository.findByIdRegionDaneColombia(regionDaneColombiaDTO.getIdRegionDaneColombia());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
        
        if (regionDaneColombiaId.isPresent()==true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE VERIFICA EL CÓDIGO DEL REGISTRO CON EL ID PROPORCIONADO.
           if ( (regionDaneColombiaDTO.getCodigoDaneColombia().equals(regionDaneColombiaId.get().getCodigoDaneColombia())==true) ) {//SI EL CÓDIGO DIGITADO ES IGUAL AL CÓDIGO ALMACENADO EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
              RegionDaneColombia regionDaneColombia = regionDaneColombiaDAO.regionDaneColombia(regionDaneColombiaDTO);
              regionDaneColombiaRepository.save(regionDaneColombia);
              respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
           }
           if (regionDaneColombiaDTO.getCodigoDaneColombia().equals(regionDaneColombiaId.get().getCodigoDaneColombia())==false) {//SI EL CÓDIGO DIGITADO ES DIFERENTE AL CÓDIGO ALMACENADO EN LA TABLA DE LA BASE DE DATOS SE REALIZA BUSQUEDA PARA VERIFICAR SI ESTE CÓDIGO DIGITADO EXISTE EN OTROS REGISTROS.
              //consulte por nombre e imprima si existe y si no existe
              RegionDaneColombia regionDaneColombiaCodigo = regionDaneColombiaRepository.findByCodigoDaneColombia(regionDaneColombiaDTO.getCodigoDaneColombia());
              
              //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
              long banderaCodigoRegistroEncontrado=0;
              
              if (!(regionDaneColombiaCodigo==null)) {//SI ENCONTRO EL CÓDIGO DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE CÓDIGO DE REGISTRO REPETIDO CON EL CÓDIGO PROPORCIONADO.
                 banderaCodigoRegistroEncontrado=1;
              }
              
              if (banderaCodigoRegistroEncontrado==1) {//SI LA BUSQUEDA OBTIENE QUE EL CÓDIGO DIGITADO Y BUSCADO ES DIFERENTE DE NULO SIGNIFICA QUE ENCONTRO EL MISMO CÓDIGO ALMACENADO EN LA TABLA DE LA BASE DE DATOS Y MUESTRA UN MENSAJE DE CÓDIGO DEL REGISTRO REPETIDO.
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CODIGO_YA_EXISTE, false);
                 respuestaDTO.setRegionDaneColombiaDTO(null);
              }
              if (banderaCodigoRegistroEncontrado==0) {//SI LA BUSQUEDA OBTIENE QUE EL CÓDIGO DIGITADO Y BUSCADO ES NULO EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
                 RegionDaneColombia regionDaneColombia = regionDaneColombiaDAO.regionDaneColombia(regionDaneColombiaDTO);
                 regionDaneColombiaRepository.save(regionDaneColombia);
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
              }
           }
        }
        if (regionDaneColombiaId.isPresent()==false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MUESTRA UN MENSAJE DE REGISTRO NO MODIFICADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
           respuestaDTO.setRegionDaneColombiaDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //ELIMINAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE ELIMINAR REGISTRO.
    public RespuestaDTO eliminarRegionDaneColombia(Long idRegionDaneColombia) {
        Optional<RegionDaneColombia> regionDaneColombiaId = regionDaneColombiaRepository.findById(idRegionDaneColombia);
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (regionDaneColombiaId.isPresent()==true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO.setRegionDaneColombiaDTO(regionDaneColombiaDAO.regionDaneColombiaDTO(regionDaneColombiaId.get()));
           regionDaneColombiaRepository.delete(regionDaneColombiaId.get());
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ELIMINADO_EXITO, true);
        }
        if (regionDaneColombiaId.isPresent()==false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS NO ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO NO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setRegionDaneColombiaDTO(null);
        }
        
        return respuestaDTO;
    }
}
