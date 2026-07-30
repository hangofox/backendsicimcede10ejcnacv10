//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.serviceImpl;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.Constantes.MensajesConstantes;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.TerrenoDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service.TerrenoService;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao.TerrenoDAO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.Terreno;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.TerrenoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
* * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 24/03/2026.
* Esta es la declaración de la implementación del servicio.
* Se inyectan DAOS y repositorios.
*/
@Service//DECLARACIÓN DE LA IMPLEMENTACIÓN DEL SERVICIO.
//DECLARACIÓN DE LA CLASE DE LA IMPLEMENTACIÓN DEL SERVICIO:
public class TerrenoServiceImpl implements TerrenoService {
    
    @Autowired//INYECTAMOS EL DAO.
    private TerrenoDAO terrenoDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private TerrenoRepository terrenoRepository;
    
    //CONTADOR DE REGISTROS FILTRADOS.
    //CONTAR TOTAL DE REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE CONTEO.
    public Long contarTotalRegistros(Long idTerreno, String keyword, String siglaoAcronimoUnidadMilitar) {
        return terrenoRepository.findTotalRegistros(idTerreno, keyword, siglaoAcronimoUnidadMilitar);
    }
    
    //LISTADO DE REGISTROS FILTRADOS SIN PAGINACIÓN.
    //LISTAR REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public List<TerrenoDTO> listarTerrenos(Long idTerreno, String keyword, String siglaoAcronimoUnidadMilitar, String orderBy, String orderMode) {
        List<Terreno> terrenos = terrenoRepository.findAllTerrenos(idTerreno, keyword, siglaoAcronimoUnidadMilitar, orderBy, orderMode);
        List<TerrenoDTO> terrenoDTOS = new ArrayList<>();
        for (Terreno terreno : terrenos) {
            terrenoDTOS.add(terrenoDAO.terrenoDTO(terreno));
        }
        
        return terrenoDTOS;
    }
    
    //LISTADO DE REGISTROS FILTRADOS CON PAGINACIÓN.
    //LISTAR REGISTROS CON PAGINACIÓN:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public Slice<TerrenoDTO> listarTerrenosPag(Pageable pageable, Long idTerreno, String keyword, String siglaoAcronimoUnidadMilitar, String orderBy, String orderMode) {
        Slice<Terreno> terrenos = terrenoRepository.findAllTerrenosPag(pageable, idTerreno, keyword, siglaoAcronimoUnidadMilitar, orderBy, orderMode);
        return terrenos.map(terreno -> terrenoDAO.terrenoDTO(terreno));
    }
    
    //CREAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE CREAR REGISTRO.
    public RespuestaDTO crearTerreno(TerrenoDTO terrenoDTO) {
        Long maxIdTerreno = null;
        Terreno terrenoUnico = terrenoRepository.findByNumeroInventarioTerrenoOrNumeroActivoFijoTerreno(terrenoDTO.getNumeroInventarioTerreno(), terrenoDTO.getNumeroActivoFijoTerreno());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_CREADO, false);
        
        //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
        long banderaRegistroEncontrado = 0;
        
        if (!(terrenoUnico == null)) {//SI ENCONTRO EL NUMERO INVENTARIO O NUMERO ACTIVO FIJO DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE REGISTRO REPETIDO CON LOS DATOS PROPORCIONADOS.
           banderaRegistroEncontrado = 1;
        }
        
        //System.out.println("INGRESA METODO CREAR.");
        if (banderaRegistroEncontrado == 1) {//SI ENCONTRO EL NUMERO INVENTARIO O NUMERO ACTIVO FIJO DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE REGISTRO REPETIDO CON LOS DATOS PROPORCIONADOS.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NUMERO_INVENTARIO_O_ACTIVO_FIJO_YA_EXISTE, false);
           respuestaDTO.setTerrenoDTO(null);
        }
        if (banderaRegistroEncontrado == 0) {//SI NO ENCONTRO EL NUMERO INVENTARIO O NUMERO ACTIVO FIJO DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS CREA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO CREADO EXITOSAMENTE.
           maxIdTerreno = terrenoRepository.findMaxIdTerreno();
           if (maxIdTerreno == null) {//ESTO SE HACE EN CASO DE QUE SI LA TABLA DE LA BASE DE DATOS ESTA EN BLANCO Y VA SER EL PRIMER REGISTRO AL OBTENER UN VALOR NULO, SE ASIGNE CERO (0) AUTOMÁTICAMENTE PORQUE SI NO ARROJARIA UN ERROR DE CONVERSIÓN DE CARACTER NULO AL SUMAR CON NÚMERO ENTERO.
              maxIdTerreno = Long.valueOf(0);
           }
           terrenoDTO.setIdTerreno(maxIdTerreno + 1);//OBTENGO EL ID MAXIMO AUTOMATICO, SUMO (1) ENTERO PARA OBTENER EL NUEVO ID.

           terrenoRepository.save(terrenoDAO.terreno(terrenoDTO));
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CREADO_EXITO, true);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR ID:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarTerrenoportId(Long idTerreno) {
        Optional<Terreno> terrenoId = terrenoRepository.findByIdTerreno(Long.valueOf(idTerreno));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (terrenoId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO.setTerrenoDTO(terrenoDAO.terrenoDTO(terrenoId.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (terrenoId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setTerrenoDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR NUMERO INVENTARIO Y NUMERO ACTIVO FIJO (CAMPOS ÚNICOS COMBINADOS):
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarTerrenoportNumeroInventarioNumeroActivoFijo(String numeroInventarioTerreno, String numeroActivoFijoTerreno) {
        if (numeroInventarioTerreno == null && numeroActivoFijoTerreno == null) {//SI TODOS LOS PARAMETROS SON NULOS NO SE REALIZA LA BUSQUEDA Y SE RETORNA UN MENSAJE DE REGISTRO NO ENCONTRADO.
           RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NUMERO_INVENTARIO_NUMERO_ACTIVO_FIJO_NO_ENCONTRADOS, false);
           respuestaDTO.setTerrenoDTO(null);
           return respuestaDTO;
        }
        Optional<Terreno> terrenoNumero = Optional.ofNullable(terrenoRepository.findByNumeroInventarioTerrenoOrNumeroActivoFijoTerreno(numeroInventarioTerreno, numeroActivoFijoTerreno));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NUMERO_INVENTARIO_NUMERO_ACTIVO_FIJO_NO_ENCONTRADOS, false);
        
        if (terrenoNumero.isPresent() == true) {//SI ENCONTRO EL REGISTRO CON LOS CAMPOS ÚNICOS PROPORCIONADOS EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA.
           respuestaDTO.setTerrenoDTO(terrenoDAO.terrenoDTO(terrenoNumero.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (terrenoNumero.isPresent() == false) {//SI NO ENCONTRO EL REGISTRO CON LOS CAMPOS ÚNICOS PROPORCIONADOS EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE CONSULTA NO EXITOSA.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NUMERO_INVENTARIO_NUMERO_ACTIVO_FIJO_NO_ENCONTRADOS, false);
           respuestaDTO.setTerrenoDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //MODIFICAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE MODIFICAR REGISTRO.
    public RespuestaDTO actualizarTerreno(TerrenoDTO terrenoDTO) {
        Optional<Terreno> terrenoId = terrenoRepository.findByIdTerreno(terrenoDTO.getIdTerreno());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
        
        if (terrenoId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE VERIFICA LA UNICIDAD DE LOS CAMPOS ÚNICOS DEL REGISTRO CON EL ID PROPORCIONADO.
           Terreno terrenoUnico = terrenoRepository.findByNumeroInventarioTerrenoOrNumeroActivoFijoTerreno(terrenoDTO.getNumeroInventarioTerreno(), terrenoDTO.getNumeroActivoFijoTerreno());
           
           //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
           long banderaRegistroEncontrado = 0;
           
           if (!(terrenoUnico == null) && !(terrenoUnico.getIdTerreno().equals(terrenoDTO.getIdTerreno()))) {//SI ENCONTRO UN REGISTRO DIFERENTE AL ACTUAL CON EL MISMO NUMERO INVENTARIO O NUMERO ACTIVO FIJO MUESTRA UN MENSAJE DE DATOS ÚNICOS REPETIDOS.
              banderaRegistroEncontrado = 1;
           }
           
           if (banderaRegistroEncontrado == 1) {//SI LA BUSQUEDA ENCONTRO UN REGISTRO CON LOS MISMOS CAMPOS ÚNICOS ASOCIADOS A UN ID DIFERENTE MUESTRA UN MENSAJE DE DATOS ÚNICOS REPETIDOS.
              respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NUMERO_INVENTARIO_O_ACTIVO_FIJO_YA_EXISTE, false);
              respuestaDTO.setTerrenoDTO(null);
           }
           if (banderaRegistroEncontrado == 0) {//SI NO ENCONTRO UN REGISTRO DIFERENTE AL ACTUAL CON LOS MISMOS CAMPOS ÚNICOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
              terrenoRepository.save(terrenoDAO.terreno(terrenoDTO));
              respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
           }
        }
        if (terrenoId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MUESTRA UN MENSAJE DE REGISTRO NO MODIFICADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
           respuestaDTO.setTerrenoDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //ELIMINAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE ELIMINAR REGISTRO.
    public RespuestaDTO eliminarTerreno(Long idTerreno) {
        Optional<Terreno> terrenoId = terrenoRepository.findById(idTerreno);
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (terrenoId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO.setTerrenoDTO(terrenoDAO.terrenoDTO(terrenoId.get()));
           terrenoRepository.delete(terrenoId.get());
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ELIMINADO_EXITO, true);
        }
        if (terrenoId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS NO ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO NO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setTerrenoDTO(null);
        }
        
        return respuestaDTO;
    }
}
