//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.serviceImpl;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.Constantes.MensajesConstantes;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.PelotonUnidadMilitarDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service.PelotonUnidadMilitarService;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao.PelotonUnidadMilitarDAO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.PelotonUnidadMilitar;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.PelotonUnidadMilitarRepository;
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
public class PelotonUnidadMilitarServiceImpl implements PelotonUnidadMilitarService {
    
    @Autowired//INYECTAMOS EL DAO.
    private PelotonUnidadMilitarDAO pelotonUnidadMilitarDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private PelotonUnidadMilitarRepository pelotonUnidadMilitarRepository;
    
    //CONTAR TOTAL DE REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE CONTEO.
    public Long contarTotalRegistros(Long idPelotonUnidadMilitar, String keyword, String nombreCompaniaUnidadMilitar) {
        return pelotonUnidadMilitarRepository.findTotalRegistros(idPelotonUnidadMilitar, keyword, nombreCompaniaUnidadMilitar);
    }
    
    //LISTAR REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public List<PelotonUnidadMilitarDTO> listarPelotonesUnidadesMilitares(Long idPelotonUnidadMilitar, String keyword, String nombreCompaniaUnidadMilitar, String orderBy, String orderMode) {
        List<PelotonUnidadMilitar> pelotonesUnidadesMilitares = pelotonUnidadMilitarRepository.findAllPelotonesUnidadesMilitares(idPelotonUnidadMilitar, keyword, nombreCompaniaUnidadMilitar, orderBy, orderMode);
        List<PelotonUnidadMilitarDTO> pelotonUnidadMilitarDTOS = new ArrayList<>();
        for (PelotonUnidadMilitar pelotonUnidadMilitar : pelotonesUnidadesMilitares) {
            pelotonUnidadMilitarDTOS.add(pelotonUnidadMilitarDAO.pelotonUnidadMilitarDTO(pelotonUnidadMilitar));
        }
        
        return pelotonUnidadMilitarDTOS;
    }
    
    //LISTAR REGISTROS PAGINADOS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS PAGINADOS.
    public Slice<PelotonUnidadMilitarDTO> listarPelotonesUnidadesMilitaresPag(Pageable pageable, Long idPelotonUnidadMilitar, String keyword, String nombreCompaniaUnidadMilitar, String orderBy, String orderMode) {
        Slice<PelotonUnidadMilitar> pelotonesUnidadesMilitares = pelotonUnidadMilitarRepository.findAllPelotonesUnidadesMilitaresPag(pageable, idPelotonUnidadMilitar, keyword, nombreCompaniaUnidadMilitar, orderBy, orderMode);
        return pelotonesUnidadesMilitares.map(pelotonUnidadMilitar -> pelotonUnidadMilitarDAO.pelotonUnidadMilitarDTO(pelotonUnidadMilitar));
    }
    
    //CREAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE CREAR REGISTRO.
    public RespuestaDTO crearPelotonUnidadMilitar(PelotonUnidadMilitarDTO pelotonUnidadMilitarDTO) {
        Long maxIdPelotonUnidadMilitar = null;
        PelotonUnidadMilitar pelotonUnidadMilitarNombreyNombreCompaniaUnidadMilitar = pelotonUnidadMilitarRepository.findByNombrePelotonUnidadMilitarAndNombreCompaniaUnidadMilitar(pelotonUnidadMilitarDTO.getNombrePelotonUnidadMilitar().toUpperCase(), pelotonUnidadMilitarDTO.getCompaniaUnidadMilitarDTO().getNombreCompaniaUnidadMilitar());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_CREADO, false);
        
        //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
        long banderaNombreRegistroEncontrado = 0;
        
        if (!(pelotonUnidadMilitarNombreyNombreCompaniaUnidadMilitar == null)) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS Y ASOCIADO A UN MISMO REGISTRO RELACIONAL MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
           banderaNombreRegistroEncontrado = 1;
        }
        
        if (banderaNombreRegistroEncontrado == 1) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS Y ASOCIADO A UN MISMO REGISTRO RELACIONAL MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_EN_COMPANIA_UNIDAD_MILITAR_YA_EXISTE, false);
           respuestaDTO.setPelotonUnidadMilitarDTO(null);
        }
        if (banderaNombreRegistroEncontrado == 0) {//SI NO ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS Y ASOCIADO A UN MISMO REGISTRO RELACIONAL CREA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO CREADO EXITOSAMENTE.
           maxIdPelotonUnidadMilitar = pelotonUnidadMilitarRepository.findMaxIdPelotonUnidadMilitar();
           if (maxIdPelotonUnidadMilitar == null) {//ESTO SE HACE EN CASO DE QUE SI LA TABLA DE LA BASE DE DATOS ESTA EN BLANCO Y VA SER EL PRIMER REGISTRO AL OBTENER UN VALOR NULO, SE ASIGNE CERO (0) AUTOMÁTICAMENTE.
              maxIdPelotonUnidadMilitar = Long.valueOf(0);
           }
           pelotonUnidadMilitarDTO.setIdPelotonUnidadMilitar(maxIdPelotonUnidadMilitar + 1);//OBTENGO EL ID MAXIMO AUTOMATICO, SUMO (1) ENTERO PARA OBTENER EL NUEVO ID.
           pelotonUnidadMilitarRepository.save(pelotonUnidadMilitarDAO.pelotonUnidadMilitar(pelotonUnidadMilitarDTO));
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CREADO_EXITO, true);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR ID:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarPelotonUnidadMilitarporId(Long idPelotonUnidadMilitar) {
        Optional<PelotonUnidadMilitar> pelotonUnidadMilitarId = pelotonUnidadMilitarRepository.findByIdPelotonUnidadMilitar(Long.valueOf(idPelotonUnidadMilitar));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (pelotonUnidadMilitarId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO.setPelotonUnidadMilitarDTO(pelotonUnidadMilitarDAO.pelotonUnidadMilitarDTO(pelotonUnidadMilitarId.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (pelotonUnidadMilitarId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE CONSULTA NO EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setPelotonUnidadMilitarDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR NOMBRE, NOMBRE COMPAÑIA UNIDAD MILITAR Y SIGLA O ACRÓNIMO DE LA UNIDAD MILITAR:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarPelotonUnidadMilitarporNombreYNombreCompaniaUnidadMilitar(String nombrePelotonUnidadMilitar, String nombreCompaniaUnidadMilitar, String siglaoAcronimoUnidadMilitar) {
        Optional<PelotonUnidadMilitar> pelotonUnidadMilitarNombre = Optional.ofNullable(pelotonUnidadMilitarRepository.findByNombrePelotonUnidadMilitarAndNombreCompaniaUnidadMilitarAndSiglaoAcronimoUnidadMilitar(String.valueOf(nombrePelotonUnidadMilitar), String.valueOf(nombreCompaniaUnidadMilitar), String.valueOf(siglaoAcronimoUnidadMilitar)));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_NO_ENCONTRADO, false);
        
        if (pelotonUnidadMilitarNombre.isPresent() == true) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL NOMBRE PROPORCIONADO.
           respuestaDTO.setPelotonUnidadMilitarDTO(pelotonUnidadMilitarDAO.pelotonUnidadMilitarDTO(pelotonUnidadMilitarNombre.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (pelotonUnidadMilitarNombre.isPresent() == false) {//SI NO ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE CONSULTA NO EXITOSA CON EL NOMBRE PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_NO_ENCONTRADO, false);
           respuestaDTO.setPelotonUnidadMilitarDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //MODIFICAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE MODIFICAR REGISTRO.
    public RespuestaDTO actualizarPelotonUnidadMilitar(PelotonUnidadMilitarDTO pelotonUnidadMilitarDTO) {
        Optional<PelotonUnidadMilitar> pelotonUnidadMilitarId = pelotonUnidadMilitarRepository.findByIdPelotonUnidadMilitar(pelotonUnidadMilitarDTO.getIdPelotonUnidadMilitar());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
        
        if (pelotonUnidadMilitarId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE VERIFICA EL NOMBRE DEL REGISTRO CON EL ID PROPORCIONADO.
           if (pelotonUnidadMilitarDTO.getNombrePelotonUnidadMilitar().equals(pelotonUnidadMilitarId.get().getNombrePelotonUnidadMilitar()) == true) {//SI EL NOMBRE DIGITADO ES IGUAL AL NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
              pelotonUnidadMilitarRepository.save(pelotonUnidadMilitarDAO.pelotonUnidadMilitar(pelotonUnidadMilitarDTO));
              respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
           }
           if (pelotonUnidadMilitarDTO.getNombrePelotonUnidadMilitar().equals(pelotonUnidadMilitarId.get().getNombrePelotonUnidadMilitar()) == false) {//SI EL NOMBRE DIGITADO ES DIFERENTE AL NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS SE REALIZA BUSQUEDA PARA VERIFICAR SI ESTE NOMBRE DIGITADO EXISTE EN OTROS REGISTROS Y ASOCIADOS A UN MISMO REGISTRO RELACIONAL.
              PelotonUnidadMilitar pelotonUnidadMilitarNombreyNombreCompaniaUnidadMilitar = pelotonUnidadMilitarRepository.findByNombrePelotonUnidadMilitarAndNombreCompaniaUnidadMilitar(pelotonUnidadMilitarDTO.getNombrePelotonUnidadMilitar().toUpperCase(), pelotonUnidadMilitarDTO.getCompaniaUnidadMilitarDTO().getNombreCompaniaUnidadMilitar());
              
              //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
              long banderaNombreRegistroEncontrado = 0;
              
              if (!(pelotonUnidadMilitarNombreyNombreCompaniaUnidadMilitar == null)) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS Y ASOCIADO A UN MISMO REGISTRO RELACIONAL MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
                 banderaNombreRegistroEncontrado = 1;
              }
              
              if (banderaNombreRegistroEncontrado == 1) {//SI LA BUSQUEDA OBTIENE QUE EL NOMBRE DIGITADO ES DIFERENTE DE NULO SIGNIFICA QUE ENCONTRO EL MISMO NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS Y ASOCIADO A UN MISMO REGISTRO RELACIONAL Y MUESTRA UN MENSAJE DE NOMBRE DEL REGISTRO REPETIDO.
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_EN_COMPANIA_UNIDAD_MILITAR_YA_EXISTE, false);
                 respuestaDTO.setPelotonUnidadMilitarDTO(null);
              }
              if (banderaNombreRegistroEncontrado == 0) {//SI LA BUSQUEDA OBTIENE QUE EL NOMBRE DIGITADO ES NULO EN LA TABLA DE LA BASE DE DATOS Y ASOCIADO A UN MISMO REGISTRO RELACIONAL SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
                 pelotonUnidadMilitarRepository.save(pelotonUnidadMilitarDAO.pelotonUnidadMilitar(pelotonUnidadMilitarDTO));
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
              }
           }
        }
        if (pelotonUnidadMilitarId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MUESTRA UN MENSAJE DE REGISTRO NO MODIFICADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
           respuestaDTO.setPelotonUnidadMilitarDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //ELIMINAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE ELIMINAR REGISTRO.
    public RespuestaDTO eliminarPelotonUnidadMilitar(Long idPelotonUnidadMilitar) {
        Optional<PelotonUnidadMilitar> pelotonUnidadMilitarId = pelotonUnidadMilitarRepository.findById(idPelotonUnidadMilitar);
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (pelotonUnidadMilitarId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO.setPelotonUnidadMilitarDTO(pelotonUnidadMilitarDAO.pelotonUnidadMilitarDTO(pelotonUnidadMilitarId.get()));
           pelotonUnidadMilitarRepository.delete(pelotonUnidadMilitarId.get());
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ELIMINADO_EXITO, true);
        }
        if (pelotonUnidadMilitarId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS NO ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO NO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setPelotonUnidadMilitarDTO(null);
        }
        
        return respuestaDTO;
    }
}
