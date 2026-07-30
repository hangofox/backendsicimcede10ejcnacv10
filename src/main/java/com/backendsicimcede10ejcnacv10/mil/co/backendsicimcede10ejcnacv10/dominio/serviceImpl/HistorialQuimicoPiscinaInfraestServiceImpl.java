//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.serviceImpl;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.Constantes.MensajesConstantes;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.HistorialQuimicoPiscinaInfraestDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service.HistorialQuimicoPiscinaInfraestService;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao.HistorialQuimicoPiscinaInfraestDAO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.HistorialQuimicoPiscinaInfraest;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.HistorialQuimicoPiscinaInfraestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
* * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 15/04/2026.
* Esta es la declaración de la implementación del servicio.
* Se inyectan DAOS y repositorios.
*/
@Service//DECLARACIÓN DE LA IMPLEMENTACIÓN DEL SERVICIO.
//DECLARACIÓN DE LA CLASE DE LA IMPLEMENTACIÓN DEL SERVICIO:
public class HistorialQuimicoPiscinaInfraestServiceImpl implements HistorialQuimicoPiscinaInfraestService {
    
    @Autowired//INYECTAMOS EL DAO.
    private HistorialQuimicoPiscinaInfraestDAO historialQuimicoPiscinaInfraestDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private HistorialQuimicoPiscinaInfraestRepository historialQuimicoPiscinaInfraestRepository;
    
    //CONTADOR DE REGISTROS FILTRADOS.
    //CONTAR TOTAL DE REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE CONTEO.
    public Long contarTotalRegistros(Long idHistorialQuimicoPiscinaInfraest, String keyword, Long idInfraestructura) {
        return historialQuimicoPiscinaInfraestRepository.findTotalRegistros(idHistorialQuimicoPiscinaInfraest, keyword, idInfraestructura);
    }
    
    //LISTADO DE REGISTROS FILTRADOS SIN PAGINACIÓN.
    //LISTAR REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public List<HistorialQuimicoPiscinaInfraestDTO> listarHistorialesQuimicosPiscinasInfraest(Long idHistorialQuimicoPiscinaInfraest, String keyword, Long idInfraestructura, String orderBy, String orderMode) {
        List<HistorialQuimicoPiscinaInfraest> historialesQuimicosPiscinasInfraest = historialQuimicoPiscinaInfraestRepository.findAllHistorialesQuimicosPiscinasInfraest(idHistorialQuimicoPiscinaInfraest, keyword, idInfraestructura, orderBy, orderMode);
        List<HistorialQuimicoPiscinaInfraestDTO> historialQuimicoPiscinaInfraestDTOS = new ArrayList<>();
        for (HistorialQuimicoPiscinaInfraest historialQuimicoPiscinaInfraest : historialesQuimicosPiscinasInfraest) {
            historialQuimicoPiscinaInfraestDTOS.add(historialQuimicoPiscinaInfraestDAO.historialQuimicoPiscinaInfraestDTO(historialQuimicoPiscinaInfraest));
        }
        
        return historialQuimicoPiscinaInfraestDTOS;
    }
    
    //LISTADO DE REGISTROS FILTRADOS CON PAGINACIÓN.
    //LISTAR REGISTROS CON PAGINACIÓN:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public Slice<HistorialQuimicoPiscinaInfraestDTO> listarHistorialesQuimicosPiscinasInfraestPag(Pageable pageable, Long idHistorialQuimicoPiscinaInfraest, String keyword, Long idInfraestructura, String orderBy, String orderMode) {
        Slice<HistorialQuimicoPiscinaInfraest> historialesQuimicosPiscinasInfraest = historialQuimicoPiscinaInfraestRepository.findAllHistorialesQuimicosPiscinasInfraestPag(pageable, idHistorialQuimicoPiscinaInfraest, keyword, idInfraestructura, orderBy, orderMode);
        return historialesQuimicosPiscinasInfraest.map(historialQuimicoPiscinaInfraest -> historialQuimicoPiscinaInfraestDAO.historialQuimicoPiscinaInfraestDTO(historialQuimicoPiscinaInfraest));
    }
    
    //CREAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE CREAR REGISTRO.
    public RespuestaDTO crearHistorialQuimicoPiscinaInfraest(HistorialQuimicoPiscinaInfraestDTO historialQuimicoPiscinaInfraestDTO) {
        Long maxIdHistorialQuimicoPiscinaInfraest = null;
        HistorialQuimicoPiscinaInfraest historialQuimicoPiscinaInfraestNombreYDenomInfraest = historialQuimicoPiscinaInfraestRepository.findByNombreHistorialQuimicoPiscinaInfraestAndDenominacionInfraestructura(historialQuimicoPiscinaInfraestDTO.getNombreHistorialQuimicoPiscinaInfraest().toUpperCase(), historialQuimicoPiscinaInfraestDTO.getInfraestructuraDTO().getDenominacionInfraestructura());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_CREADO, false);
        
        //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
        long banderaNombreRegistroEncontrado = 0;
        
        if (!(historialQuimicoPiscinaInfraestNombreYDenomInfraest == null)) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS Y ASOCIADO A UNA MISMA INFRAESTRUCTURA MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
           banderaNombreRegistroEncontrado = 1;
        }
        
        if (banderaNombreRegistroEncontrado == 1) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS Y ASOCIADO A UNA MISMA INFRAESTRUCTURA MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_HISTORIAL_QUIMICO_PISCINA_NOMBRE_YA_EXISTE_EN_INFRAESTRUCTURA, false);
           respuestaDTO.setHistorialQuimicoPiscinaInfraestDTO(null);
        }
        if (banderaNombreRegistroEncontrado == 0) {//SI NO ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS Y ASOCIADO A UNA MISMA INFRAESTRUCTURA CREA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO CREADO EXITOSAMENTE.
           maxIdHistorialQuimicoPiscinaInfraest = historialQuimicoPiscinaInfraestRepository.findMaxIdHistorialQuimicoPiscinaInfraest();
           if (maxIdHistorialQuimicoPiscinaInfraest == null) {
              maxIdHistorialQuimicoPiscinaInfraest = Long.valueOf(0);
           }
           historialQuimicoPiscinaInfraestDTO.setIdHistorialQuimicoPiscinaInfraest(maxIdHistorialQuimicoPiscinaInfraest + 1);
           
           //OBTENCIÓN AUTOMÁTICA DEL NÚMERO DE REGISTRO DEL HISTORIAL COMBINANDO LA CADENA "HIST-QUIM-PISC-INF" CON LA CADENA "-", ID DE LA LLAVE PRIMARIA, LA CADENA "-" Y LA FECHA Y HORA (AÑO, MES Y DÍA) DEL INGRESO EN FORMATO DE HORA MILITAR ACTUAL SIN INTERMEDIOS DE GUIONES Y PUNTOS:
           SimpleDateFormat objetoFechaHMS = new SimpleDateFormat("yyyyMMddHHmmss");
           String fechaHMSIngresoQuimicoPiscinaInfraestSinIntermedios = objetoFechaHMS.format(historialQuimicoPiscinaInfraestDTO.getFechaHMSIngresoQuimicoPiscinaInfraest());
           historialQuimicoPiscinaInfraestDTO.setNumRegHistorialQuimicoPiscinaInfraest("HIST-QUIM-PISC-INF" + "-" + (maxIdHistorialQuimicoPiscinaInfraest + 1) + "-" + fechaHMSIngresoQuimicoPiscinaInfraestSinIntermedios);
           
           historialQuimicoPiscinaInfraestRepository.save(historialQuimicoPiscinaInfraestDAO.historialQuimicoPiscinaInfraest(historialQuimicoPiscinaInfraestDTO));
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CREADO_EXITO, true);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR ID:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarHistorialQuimicoPiscinaInfraestporId(Long idHistorialQuimicoPiscinaInfraest) {
        Optional<HistorialQuimicoPiscinaInfraest> historialQuimicoPiscinaInfraestId = historialQuimicoPiscinaInfraestRepository.findByIdHistorialQuimicoPiscinaInfraest(Long.valueOf(idHistorialQuimicoPiscinaInfraest));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (historialQuimicoPiscinaInfraestId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO...
           respuestaDTO.setHistorialQuimicoPiscinaInfraestDTO(historialQuimicoPiscinaInfraestDAO.historialQuimicoPiscinaInfraestDTO(historialQuimicoPiscinaInfraestId.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (historialQuimicoPiscinaInfraestId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO...
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setHistorialQuimicoPiscinaInfraestDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR NUMERO DE REGISTRO (CAMPO ÚNICO):
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarHistorialQuimicoPiscinaInfraestporNumReg(String numRegHistorialQuimicoPiscinaInfraest) {
        if (numRegHistorialQuimicoPiscinaInfraest == null) {//SI EL PARAMETRO ES NULO NO SE REALIZA LA BUSQUEDA Y SE RETORNA UN MENSAJE DE REGISTRO NO ENCONTRADO.
           RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NUMERO_REGISTRO_NO_ENCONTRADO, false);
           respuestaDTO.setHistorialQuimicoPiscinaInfraestDTO(null);
           return respuestaDTO;
        }
        Optional<HistorialQuimicoPiscinaInfraest> historialQuimicoPiscinaInfraestNumReg = Optional.ofNullable(historialQuimicoPiscinaInfraestRepository.findByNumRegHistorialQuimicoPiscinaInfraest(numRegHistorialQuimicoPiscinaInfraest));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NUMERO_REGISTRO_NO_ENCONTRADO, false);
        
        if (historialQuimicoPiscinaInfraestNumReg.isPresent() == true) {//SI ENCONTRO EL REGISTRO CON EL NUMERO DE REGISTRO PROPORCIONADO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA.
           respuestaDTO.setHistorialQuimicoPiscinaInfraestDTO(historialQuimicoPiscinaInfraestDAO.historialQuimicoPiscinaInfraestDTO(historialQuimicoPiscinaInfraestNumReg.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (historialQuimicoPiscinaInfraestNumReg.isPresent() == false) {//SI NO ENCONTRO EL REGISTRO CON EL NUMERO DE REGISTRO PROPORCIONADO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE CONSULTA NO EXITOSA.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NUMERO_REGISTRO_NO_ENCONTRADO, false);
           respuestaDTO.setHistorialQuimicoPiscinaInfraestDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR NOMBRE:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO POR NOMBRE.
    public RespuestaDTO consultarHistorialQuimicoPiscinaInfraestporNombre(String nombreHistorialQuimicoPiscinaInfraest) {
        List<HistorialQuimicoPiscinaInfraest> historialQuimicoPiscinaInfraestNombre = historialQuimicoPiscinaInfraestRepository.findByNombreHistorialQuimicoPiscinaInfraest(nombreHistorialQuimicoPiscinaInfraest);
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (!historialQuimicoPiscinaInfraestNombre.isEmpty()) {//SI ENCONTRO EL NOMBRE DEL REGISTRO...
           respuestaDTO.setHistorialQuimicoPiscinaInfraestDTO(historialQuimicoPiscinaInfraestDAO.historialQuimicoPiscinaInfraestDTO(historialQuimicoPiscinaInfraestNombre.get(0)));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (historialQuimicoPiscinaInfraestNombre.isEmpty()) {//SI NO ENCONTRO EL NOMBRE DEL REGISTRO...
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setHistorialQuimicoPiscinaInfraestDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //MODIFICAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE MODIFICAR REGISTRO.
    public RespuestaDTO actualizarHistorialQuimicoPiscinaInfraest(HistorialQuimicoPiscinaInfraestDTO historialQuimicoPiscinaInfraestDTO) {
        Optional<HistorialQuimicoPiscinaInfraest> historialQuimicoPiscinaInfraestId = historialQuimicoPiscinaInfraestRepository.findByIdHistorialQuimicoPiscinaInfraest(historialQuimicoPiscinaInfraestDTO.getIdHistorialQuimicoPiscinaInfraest());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
        
        if (historialQuimicoPiscinaInfraestId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE VERIFICA EL NOMBRE DEL REGISTRO CON EL ID PROPORCIONADO.
           //SE PRESERVA EL NÚMERO DE REGISTRO ORIGINAL DE LA BASE DE DATOS PARA NO VIOLAR LA RESTRICCIÓN ÚNICA:
           historialQuimicoPiscinaInfraestDTO.setNumRegHistorialQuimicoPiscinaInfraest(historialQuimicoPiscinaInfraestId.get().getNumRegHistorialQuimicoPiscinaInfraest());
           if (historialQuimicoPiscinaInfraestDTO.getNombreHistorialQuimicoPiscinaInfraest().equals(historialQuimicoPiscinaInfraestId.get().getNombreHistorialQuimicoPiscinaInfraest()) == true) {//SI EL NOMBRE DIGITADO ES IGUAL AL NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS SE VERIFICA SI LA INFRAESTRUCTURA CAMBIO.
              if ( (historialQuimicoPiscinaInfraestDTO.getInfraestructuraDTO().getIdInfraestructura().equals(historialQuimicoPiscinaInfraestId.get().getInfraestructura().getIdInfraestructura())==true) ) {//SI LA INFRAESTRUCTURA NO CAMBIO SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
                 historialQuimicoPiscinaInfraestRepository.save(historialQuimicoPiscinaInfraestDAO.historialQuimicoPiscinaInfraest(historialQuimicoPiscinaInfraestDTO));
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
              }
              if (historialQuimicoPiscinaInfraestDTO.getInfraestructuraDTO().getIdInfraestructura().equals(historialQuimicoPiscinaInfraestId.get().getInfraestructura().getIdInfraestructura())==false) {//SI LA INFRAESTRUCTURA CAMBIO SE VERIFICA QUE EL MISMO NOMBRE NO EXISTA EN LA NUEVA INFRAESTRUCTURA.
                 HistorialQuimicoPiscinaInfraest historialQuimicoPiscinaInfraestNombreYDenomInfraest = historialQuimicoPiscinaInfraestRepository.findByNombreHistorialQuimicoPiscinaInfraestAndDenominacionInfraestructura(historialQuimicoPiscinaInfraestDTO.getNombreHistorialQuimicoPiscinaInfraest().toUpperCase(), historialQuimicoPiscinaInfraestDTO.getInfraestructuraDTO().getDenominacionInfraestructura());

                 //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
                 long banderaNombreRegistroEncontrado = 0;

                 if (!(historialQuimicoPiscinaInfraestNombreYDenomInfraest == null)) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS Y ASOCIADO A LA NUEVA INFRAESTRUCTURA MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
                    banderaNombreRegistroEncontrado=1;
                 }

                 if (banderaNombreRegistroEncontrado==1) {//SI LA BUSQUEDA OBTIENE QUE EL NOMBRE DIGITADO YA EXISTE EN LA NUEVA INFRAESTRUCTURA MUESTRA UN MENSAJE DE NOMBRE DEL REGISTRO REPETIDO.
                    respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_HISTORIAL_QUIMICO_PISCINA_NOMBRE_YA_EXISTE_EN_INFRAESTRUCTURA, false);
                    respuestaDTO.setHistorialQuimicoPiscinaInfraestDTO(null);
                 }
                 if (banderaNombreRegistroEncontrado == 0) {//SI LA BUSQUEDA OBTIENE QUE EL NOMBRE DIGITADO NO EXISTE EN LA NUEVA INFRAESTRUCTURA SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
                    historialQuimicoPiscinaInfraestRepository.save(historialQuimicoPiscinaInfraestDAO.historialQuimicoPiscinaInfraest(historialQuimicoPiscinaInfraestDTO));
                    respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
                 }
              }
           }
           if (historialQuimicoPiscinaInfraestDTO.getNombreHistorialQuimicoPiscinaInfraest().equals(historialQuimicoPiscinaInfraestId.get().getNombreHistorialQuimicoPiscinaInfraest()) == false) {//SI EL NOMBRE DIGITADO ES DIFERENTE AL NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS SE REALIZA BUSQUEDA PARA VERIFICAR SI ESTE NOMBRE DIGITADO EXISTE EN OTROS REGISTROS Y ASOCIADO A UNA MISMA INFRAESTRUCTURA.
              HistorialQuimicoPiscinaInfraest historialQuimicoPiscinaInfraestNombreYDenomInfraest = historialQuimicoPiscinaInfraestRepository.findByNombreHistorialQuimicoPiscinaInfraestAndDenominacionInfraestructura(historialQuimicoPiscinaInfraestDTO.getNombreHistorialQuimicoPiscinaInfraest().toUpperCase(), historialQuimicoPiscinaInfraestDTO.getInfraestructuraDTO().getDenominacionInfraestructura());
              
              //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
              long banderaNombreRegistroEncontrado = 0;
              
              if (!(historialQuimicoPiscinaInfraestNombreYDenomInfraest == null)) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS Y ASOCIADO A UNA MISMA INFRAESTRUCTURA MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
                 banderaNombreRegistroEncontrado = 1;
              }
              
              if (banderaNombreRegistroEncontrado == 1) {//SI LA BUSQUEDA OBTIENE QUE EL NOMBRE DIGITADO ES DIFERENTE DE NULO SIGNIFICA QUE ENCONTRO EL MISMO NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS Y ASOCIADO A UNA MISMA INFRAESTRUCTURA Y MUESTRA UN MENSAJE DE NOMBRE DEL REGISTRO REPETIDO.
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_HISTORIAL_QUIMICO_PISCINA_NOMBRE_YA_EXISTE_EN_INFRAESTRUCTURA, false);
                 respuestaDTO.setHistorialQuimicoPiscinaInfraestDTO(null);
              }
              if (banderaNombreRegistroEncontrado == 0) {//SI LA BUSQUEDA OBTIENE QUE EL NOMBRE DIGITADO ES NULO EN LA TABLA DE LA BASE DE DATOS Y ASOCIADO A UNA MISMA INFRAESTRUCTURA SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
                 historialQuimicoPiscinaInfraestRepository.save(historialQuimicoPiscinaInfraestDAO.historialQuimicoPiscinaInfraest(historialQuimicoPiscinaInfraestDTO));
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
              }
           }
        }
        if (historialQuimicoPiscinaInfraestId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MUESTRA UN MENSAJE DE REGISTRO NO MODIFICADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
           respuestaDTO.setHistorialQuimicoPiscinaInfraestDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //ELIMINAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE ELIMINAR REGISTRO.
    public RespuestaDTO eliminarHistorialQuimicoPiscinaInfraest(Long idHistorialQuimicoPiscinaInfraest) {
        Optional<HistorialQuimicoPiscinaInfraest> historialQuimicoPiscinaInfraestId = historialQuimicoPiscinaInfraestRepository.findById(idHistorialQuimicoPiscinaInfraest);
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (historialQuimicoPiscinaInfraestId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO...
           historialQuimicoPiscinaInfraestRepository.delete(historialQuimicoPiscinaInfraestId.get());
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ELIMINADO_EXITO, true);
        }
        if (historialQuimicoPiscinaInfraestId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO...
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setHistorialQuimicoPiscinaInfraestDTO(null);
        }
        
        return respuestaDTO;
    }
}
