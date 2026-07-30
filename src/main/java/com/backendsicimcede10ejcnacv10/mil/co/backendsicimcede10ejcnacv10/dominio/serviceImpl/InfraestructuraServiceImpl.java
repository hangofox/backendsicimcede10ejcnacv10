//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.serviceImpl;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.Constantes.MensajesConstantes;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.InfraestructuraDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service.InfraestructuraService;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao.InfraestructuraDAO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.Infraestructura;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.InfraestructuraRepository;
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
public class InfraestructuraServiceImpl implements InfraestructuraService {
    
    @Autowired//INYECTAMOS EL DAO.
    private InfraestructuraDAO infraestructuraDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private InfraestructuraRepository infraestructuraRepository;
    
    //CONTADOR DE REGISTROS FILTRADOS.
    //CONTAR TOTAL DE REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE CONTEO.
    public Long contarTotalRegistros(Long idInfraestructura, String keyword, String siglaoAcronimoUnidadMilitar) {
        return infraestructuraRepository.findTotalRegistros(idInfraestructura, keyword, siglaoAcronimoUnidadMilitar);
    }
    
    //LISTADO DE REGISTROS FILTRADOS SIN PAGINACIÓN.
    //LISTAR REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public List<InfraestructuraDTO> listarInfraestructuras(Long idInfraestructura, String keyword, String siglaoAcronimoUnidadMilitar, String orderBy, String orderMode) {
        List<Infraestructura> infraestructuras = infraestructuraRepository.findAllInfraestructuras(idInfraestructura, keyword, siglaoAcronimoUnidadMilitar, orderBy, orderMode);
        List<InfraestructuraDTO> infraestructuraDTOS = new ArrayList<>();
        for (Infraestructura infraestructura : infraestructuras) {
            infraestructuraDTOS.add(infraestructuraDAO.infraestructuraDTO(infraestructura));
        }
        
        return infraestructuraDTOS;
    }
    
    //LISTADO DE REGISTROS FILTRADOS CON PAGINACIÓN.
    //LISTAR REGISTROS CON PAGINACIÓN:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public Slice<InfraestructuraDTO> listarInfraestructurasPag(Pageable pageable, Long idInfraestructura, String keyword, String siglaoAcronimoUnidadMilitar, String orderBy, String orderMode) {
        Slice<Infraestructura> infraestructuras = infraestructuraRepository.findAllInfraestructurasPag(pageable, idInfraestructura, keyword, siglaoAcronimoUnidadMilitar, orderBy, orderMode);
        return infraestructuras.map(infraestructura -> infraestructuraDAO.infraestructuraDTO(infraestructura));
    }
    
    //CREAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE CREAR REGISTRO.
    public RespuestaDTO crearInfraestructura(InfraestructuraDTO infraestructuraDTO) {
        Long maxIdInfraestructura = null;
        Infraestructura infraestructuraUnica = infraestructuraRepository.findByNumeroInventarioInfraestructuraOrNumeroActivoFijoInfraestructura(infraestructuraDTO.getNumeroInventarioInfraestructura(), infraestructuraDTO.getNumeroActivoFijoInfraestructura());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_CREADO, false);
        
        //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
        long banderaRegistroEncontrado = 0;
        
        if (!(infraestructuraUnica == null)) {//SI ENCONTRO EL NUMERO INVENTARIO O NUMERO ACTIVO FIJO DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE REGISTRO REPETIDO CON LOS DATOS PROPORCIONADOS.
           banderaRegistroEncontrado = 1;
        }
        
        //System.out.println("INGRESA METODO CREAR.");
        if (banderaRegistroEncontrado == 1) {//SI ENCONTRO EL NUMERO INVENTARIO O NUMERO ACTIVO FIJO DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE REGISTRO REPETIDO CON LOS DATOS PROPORCIONADOS.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NUMERO_INVENTARIO_O_ACTIVO_FIJO_YA_EXISTE, false);
           respuestaDTO.setInfraestructuraDTO(null);
        }
        if (banderaRegistroEncontrado == 0) {//SI NO ENCONTRO EL NUMERO INVENTARIO O NUMERO ACTIVO FIJO DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS CREA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO CREADO EXITOSAMENTE.
           maxIdInfraestructura = infraestructuraRepository.findMaxIdInfraestructura();
           if (maxIdInfraestructura == null) {//ESTO SE HACE EN CASO DE QUE SI LA TABLA DE LA BASE DE DATOS ESTA EN BLANCO Y VA SER EL PRIMER REGISTRO AL OBTENER UN VALOR NULO, SE ASIGNE CERO (0) AUTOMÁTICAMENTE PORQUE SI NO ARROJARIA UN ERROR DE CONVERSIÓN DE CARACTER NULO AL SUMAR CON NÚMERO ENTERO.
              maxIdInfraestructura = Long.valueOf(0);
           }
           infraestructuraDTO.setIdInfraestructura(maxIdInfraestructura + 1);//OBTENGO EL ID MAXIMO AUTOMATICO, SUMO (1) ENTERO PARA OBTENER EL NUEVO ID.
           
           infraestructuraRepository.save(infraestructuraDAO.infraestructura(infraestructuraDTO));
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CREADO_EXITO, true);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR ID:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarInfraestructuraporId(Long idInfraestructura) {
        Optional<Infraestructura> infraestructuraId = infraestructuraRepository.findByIdInfraestructura(Long.valueOf(idInfraestructura));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (infraestructuraId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO.setInfraestructuraDTO(infraestructuraDAO.infraestructuraDTO(infraestructuraId.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (infraestructuraId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setInfraestructuraDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR NUMERO INVENTARIO Y NUMERO ACTIVO FIJO (CAMPOS ÚNICOS COMBINADOS):
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarInfraestructuraporNumeroInventarioNumeroActivoFijo(String numeroInventarioInfraestructura, String numeroActivoFijoInfraestructura) {
        if (numeroInventarioInfraestructura == null && numeroActivoFijoInfraestructura == null) {//SI TODOS LOS PARAMETROS SON NULOS NO SE REALIZA LA BUSQUEDA Y SE RETORNA UN MENSAJE DE REGISTRO NO ENCONTRADO.
           RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NUMERO_INVENTARIO_NUMERO_ACTIVO_FIJO_NO_ENCONTRADOS, false);
           respuestaDTO.setInfraestructuraDTO(null);
           return respuestaDTO;
        }
        Optional<Infraestructura> infraestructuraNumero = Optional.ofNullable(infraestructuraRepository.findByNumeroInventarioInfraestructuraOrNumeroActivoFijoInfraestructura(numeroInventarioInfraestructura, numeroActivoFijoInfraestructura));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NUMERO_INVENTARIO_NUMERO_ACTIVO_FIJO_NO_ENCONTRADOS, false);
        
        if (infraestructuraNumero.isPresent() == true) {//SI ENCONTRO EL REGISTRO CON LOS CAMPOS ÚNICOS PROPORCIONADOS EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA.
           respuestaDTO.setInfraestructuraDTO(infraestructuraDAO.infraestructuraDTO(infraestructuraNumero.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (infraestructuraNumero.isPresent() == false) {//SI NO ENCONTRO EL REGISTRO CON LOS CAMPOS ÚNICOS PROPORCIONADOS EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE CONSULTA NO EXITOSA.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NUMERO_INVENTARIO_NUMERO_ACTIVO_FIJO_NO_ENCONTRADOS, false);
           respuestaDTO.setInfraestructuraDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //MODIFICAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE MODIFICAR REGISTRO.
    public RespuestaDTO actualizarInfraestructura(InfraestructuraDTO infraestructuraDTO) {
        Optional<Infraestructura> infraestructuraId = infraestructuraRepository.findByIdInfraestructura(infraestructuraDTO.getIdInfraestructura());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
        
        if (infraestructuraId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE VERIFICA LA UNICIDAD DE LOS CAMPOS ÚNICOS DEL REGISTRO CON EL ID PROPORCIONADO.
           Infraestructura infraestructuraUnica = infraestructuraRepository.findByNumeroInventarioInfraestructuraOrNumeroActivoFijoInfraestructura(infraestructuraDTO.getNumeroInventarioInfraestructura(), infraestructuraDTO.getNumeroActivoFijoInfraestructura());
           
           //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
           long banderaRegistroEncontrado = 0;
           
           if (!(infraestructuraUnica == null) && !(infraestructuraUnica.getIdInfraestructura().equals(infraestructuraDTO.getIdInfraestructura()))) {//SI ENCONTRO UN REGISTRO DIFERENTE AL ACTUAL CON EL MISMO NUMERO INVENTARIO O NUMERO ACTIVO FIJO MUESTRA UN MENSAJE DE DATOS ÚNICOS REPETIDOS.
              banderaRegistroEncontrado = 1;
           }
           
           if (banderaRegistroEncontrado == 1) {//SI LA BUSQUEDA ENCONTRO UN REGISTRO CON LOS MISMOS CAMPOS ÚNICOS ASOCIADOS A UN ID DIFERENTE MUESTRA UN MENSAJE DE DATOS ÚNICOS REPETIDOS.
              respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NUMERO_INVENTARIO_O_ACTIVO_FIJO_YA_EXISTE, false);
              respuestaDTO.setInfraestructuraDTO(null);
           }
           if (banderaRegistroEncontrado == 0) {//SI NO ENCONTRO UN REGISTRO DIFERENTE AL ACTUAL CON LOS MISMOS CAMPOS ÚNICOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
              infraestructuraRepository.save(infraestructuraDAO.infraestructura(infraestructuraDTO));
              respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
           }
        }
        if (infraestructuraId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MUESTRA UN MENSAJE DE REGISTRO NO MODIFICADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
           respuestaDTO.setInfraestructuraDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //ELIMINAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE ELIMINAR REGISTRO.
    public RespuestaDTO eliminarInfraestructura(Long idInfraestructura) {
        Optional<Infraestructura> infraestructuraId = infraestructuraRepository.findById(idInfraestructura);
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (infraestructuraId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO.setInfraestructuraDTO(infraestructuraDAO.infraestructuraDTO(infraestructuraId.get()));
           infraestructuraRepository.delete(infraestructuraId.get());
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ELIMINADO_EXITO, true);
        }
        if (infraestructuraId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS NO ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO NO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setInfraestructuraDTO(null);
        }
        
        return respuestaDTO;
    }
}
