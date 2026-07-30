//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.serviceImpl;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.Constantes.MensajesConstantes;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.CuentaEquipoIngenieroDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service.CuentaEquipoIngenieroService;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao.CuentaEquipoIngenieroDAO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.CuentaEquipoIngeniero;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.CuentaEquipoIngenieroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
* * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 22/12/2025.
* Esta es la declaración de la implementación del servicio.
* Se inyectan DAOS y repositorios.
*/
@Service//DECLARACIÓN DE LA IMPLEMENTACIÓN DEL SERVICIO.
//DECLARACIÓN DE LA CLASE DE LA IMPLEMENTACIÓN DEL SERVICIO:
public class CuentaEquipoIngenieroServiceImpl implements CuentaEquipoIngenieroService {
    
    @Autowired//INYECTAMOS EL DAO.
    private CuentaEquipoIngenieroDAO cuentaEquipoIngenieroDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private CuentaEquipoIngenieroRepository cuentaEquipoIngenieroRepository;
    
    //CONTADOR DE REGISTROS FILTRADOS.
    //CONTAR TOTAL DE REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE CONTEO.
    public Long contarTotalRegistros(Long idCuentaEquipoIngeniero, String keyword, String nombreCuentaEquipoIngeniero) {
        return cuentaEquipoIngenieroRepository.findTotalRegistros(idCuentaEquipoIngeniero, keyword, nombreCuentaEquipoIngeniero);
    }
    
    //LISTADO DE REGISTROS FILTRADOS SIN PAGINACIÓN.
    //LISTAR REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public List<CuentaEquipoIngenieroDTO> listarCuentasEquiposIngenieros(Long idCuentaEquipoIngeniero, String keyword, String nombreCuentaEquipoIngeniero, String orderBy, String orderMode) {
        List<CuentaEquipoIngeniero> cuentasEquiposIngenieros = cuentaEquipoIngenieroRepository.findAllCuentasEquiposIngenieros(idCuentaEquipoIngeniero, keyword, nombreCuentaEquipoIngeniero, orderBy, orderMode);
        List<CuentaEquipoIngenieroDTO> cuentaEquipoIngenieroDTOS = new ArrayList<>();
        
        for (CuentaEquipoIngeniero cuentaEquipoIngeniero : cuentasEquiposIngenieros){
            cuentaEquipoIngenieroDTOS.add(cuentaEquipoIngenieroDAO.cuentaEquipoIngenieroDTO(cuentaEquipoIngeniero));
        }
        
        return cuentaEquipoIngenieroDTOS;
    }
    
    //LISTADO DE REGISTROS FILTRADOS CON PAGINACIÓN.
    //LISTAR REGISTROS PAGINADOS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS PAGINADOS.
    public Slice<CuentaEquipoIngenieroDTO> listarCuentasEquiposIngenierosOrdenadosporIdPag(Pageable pageable, Long idCuentaEquipoIngeniero, String keyword, String nombreCuentaEquipoIngeniero, String orderBy, String orderMode) {
        Slice<CuentaEquipoIngeniero> cuentasEquiposIngenieros = cuentaEquipoIngenieroRepository.findAllCuentasEquiposIngenierosOrdenadosporIdPag(pageable, idCuentaEquipoIngeniero, keyword, nombreCuentaEquipoIngeniero, orderBy, orderMode);
        return cuentasEquiposIngenieros.map(cuentaEquipoIngeniero -> cuentaEquipoIngenieroDAO.cuentaEquipoIngenieroDTO(cuentaEquipoIngeniero));
    }
    
    //CREAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE CREAR REGISTRO.
    public RespuestaDTO crearCuentaEquipoIngeniero(CuentaEquipoIngenieroDTO cuentaEquipoIngenieroDTO) {
        Long maxIdCuentaEquipoIngeniero = null;
        CuentaEquipoIngeniero cuentaEquipoIngenieroNombre = cuentaEquipoIngenieroRepository.findByNombreCuentaEquipoIngeniero(cuentaEquipoIngenieroDTO.getNombreCuentaEquipoIngeniero().toUpperCase());
        CuentaEquipoIngeniero cuentaEquipoIngenieroNumero = cuentaEquipoIngenieroRepository.findByNumeroCuentaEquipoIngeniero(cuentaEquipoIngenieroDTO.getNumeroCuentaEquipoIngeniero().toUpperCase());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_CREADO, false);
        
        //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
        long banderaNombreRegistroEncontrado = 0;
        long banderaNumeroRegistroEncontrado = 0;
        
        if (!(cuentaEquipoIngenieroNombre == null)) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS ACTIVA BANDERA.
           banderaNombreRegistroEncontrado = 1;
        }
        if (!(cuentaEquipoIngenieroNumero == null)) {//SI ENCONTRO EL NÚMERO DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS ACTIVA BANDERA.
           banderaNumeroRegistroEncontrado = 1;
        }
        
        if (banderaNombreRegistroEncontrado == 1) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_YA_EXISTE, false);
           respuestaDTO.setCuentaEquipoIngenieroDTO(null);
        }
        if (banderaNumeroRegistroEncontrado == 1) {//SI ENCONTRO EL NÚMERO DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NÚMERO DE REGISTRO REPETIDO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_NUMERO_REGISTRO_YA_EXISTE, false);
           respuestaDTO.setCuentaEquipoIngenieroDTO(null);
        }
        if ((banderaNombreRegistroEncontrado == 0) && (banderaNumeroRegistroEncontrado == 0)) {//SI NO ENCONTRO NI EL NOMBRE NI EL NÚMERO CREA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO CREADO EXITOSAMENTE.
           maxIdCuentaEquipoIngeniero = cuentaEquipoIngenieroRepository.findMaxIdCuentaEquipoIngeniero();
           if (maxIdCuentaEquipoIngeniero == null) {//ESTO SE HACE EN CASO DE QUE SI LA TABLA DE LA BASE DE DATOS ESTA EN BLANCO Y VA SER EL PRIMER REGISTRO AL OBTENER UN VALOR NULO, SE ASIGNE CERO (0) AUTOMÁTICAMENTE PORQUE SI NO ARROJARIA UN ERROR DE CONVERSIÓN DE CARACTER NULO AL SUMAR CON NÚMERO ENTERO.
              maxIdCuentaEquipoIngeniero = Long.valueOf(0);
           }
           cuentaEquipoIngenieroDTO.setIdCuentaEquipoIngeniero(maxIdCuentaEquipoIngeniero + 1);//OBTENGO EL ID MAXIMO AUTOMATICO, SUMO (1) ENTERO PARA OBTENER EL NUEVO ID.
           
           cuentaEquipoIngenieroRepository.save(cuentaEquipoIngenieroDAO.cuentaEquipoIngeniero(cuentaEquipoIngenieroDTO));
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CREADO_EXITO, true);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR ID:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarCuentaEquipoIngenieroporId(Long idCuentaEquipoIngeniero) {
        Optional<CuentaEquipoIngeniero> cuentaEquipoIngenieroId = cuentaEquipoIngenieroRepository.findByIdCuentaEquipoIngeniero(Long.valueOf(idCuentaEquipoIngeniero));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (cuentaEquipoIngenieroId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO.setCuentaEquipoIngenieroDTO(cuentaEquipoIngenieroDAO.cuentaEquipoIngenieroDTO(cuentaEquipoIngenieroId.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (cuentaEquipoIngenieroId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setCuentaEquipoIngenieroDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR NOMBRE:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarCuentaEquipoIngenieroporNombreCuentaEquipoIngeniero(String nombreCuentaEquipoIngeniero) {
        Optional<CuentaEquipoIngeniero> cuentaEquipoIngenieroNombre = Optional.ofNullable(cuentaEquipoIngenieroRepository.findByNombreCuentaEquipoIngeniero(String.valueOf(nombreCuentaEquipoIngeniero)));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_NO_ENCONTRADO, false);
        
        if (cuentaEquipoIngenieroNombre.isPresent() == true) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL NOMBRE PROPORCIONADO.
           respuestaDTO.setCuentaEquipoIngenieroDTO(cuentaEquipoIngenieroDAO.cuentaEquipoIngenieroDTO(cuentaEquipoIngenieroNombre.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (cuentaEquipoIngenieroNombre.isPresent() == false) {//SI NO ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON EL NOMBRE PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_NO_ENCONTRADO, false);
           respuestaDTO.setCuentaEquipoIngenieroDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR NÚMERO:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarCuentaEquipoIngenieroporNumeroCuentaEquipoIngeniero(String numeroCuentaEquipoIngeniero) {
        Optional<CuentaEquipoIngeniero> cuentaEquipoIngenieroNumero = Optional.ofNullable(cuentaEquipoIngenieroRepository.findByNumeroCuentaEquipoIngeniero(String.valueOf(numeroCuentaEquipoIngeniero)));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NUMERO_REGISTRO_NO_ENCONTRADO, false);
        
        if (cuentaEquipoIngenieroNumero.isPresent() == true) {//SI ENCONTRO EL NÚMERO DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL NÚMERO PROPORCIONADO.
           respuestaDTO.setCuentaEquipoIngenieroDTO(cuentaEquipoIngenieroDAO.cuentaEquipoIngenieroDTO(cuentaEquipoIngenieroNumero.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (cuentaEquipoIngenieroNumero.isPresent() == false) {//SI NO ENCONTRO EL NÚMERO DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON EL NÚMERO PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NUMERO_REGISTRO_NO_ENCONTRADO, false);
           respuestaDTO.setCuentaEquipoIngenieroDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //MODIFICAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE MODIFICAR REGISTRO.
    public RespuestaDTO actualizarCuentaEquipoIngeniero(CuentaEquipoIngenieroDTO cuentaEquipoIngenieroDTO) {
        Optional<CuentaEquipoIngeniero> cuentaEquipoIngenieroId = cuentaEquipoIngenieroRepository.findByIdCuentaEquipoIngeniero(cuentaEquipoIngenieroDTO.getIdCuentaEquipoIngeniero());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
        
        if (cuentaEquipoIngenieroId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE VERIFICA LA UNICIDAD DEL NOMBRE Y DEL NÚMERO.
           //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
           long banderaNombreRegistroEncontrado = 0;
           long banderaNumeroRegistroEncontrado = 0;
           
           CuentaEquipoIngeniero cuentaEquipoIngenieroNombre = cuentaEquipoIngenieroRepository.findByNombreCuentaEquipoIngeniero(cuentaEquipoIngenieroDTO.getNombreCuentaEquipoIngeniero().toUpperCase());
           CuentaEquipoIngeniero cuentaEquipoIngenieroNumero = cuentaEquipoIngenieroRepository.findByNumeroCuentaEquipoIngeniero(cuentaEquipoIngenieroDTO.getNumeroCuentaEquipoIngeniero().toUpperCase());
           
           if (!(cuentaEquipoIngenieroNombre == null) && !(cuentaEquipoIngenieroNombre.getIdCuentaEquipoIngeniero().equals(cuentaEquipoIngenieroDTO.getIdCuentaEquipoIngeniero()))) {//SI ENCONTRO EL NOMBRE EN UN REGISTRO DIFERENTE AL ACTUAL ACTIVA BANDERA.
              banderaNombreRegistroEncontrado = 1;
           }
           if (!(cuentaEquipoIngenieroNumero == null) && !(cuentaEquipoIngenieroNumero.getIdCuentaEquipoIngeniero().equals(cuentaEquipoIngenieroDTO.getIdCuentaEquipoIngeniero()))) {//SI ENCONTRO EL NÚMERO EN UN REGISTRO DIFERENTE AL ACTUAL ACTIVA BANDERA.
              banderaNumeroRegistroEncontrado = 1;
           }
           
           if (banderaNombreRegistroEncontrado == 1) {//SI LA BUSQUEDA ENCONTRO UN REGISTRO CON EL MISMO NOMBRE ASOCIADO A UN ID DIFERENTE MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO.
              respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_YA_EXISTE, false);
              respuestaDTO.setCuentaEquipoIngenieroDTO(null);
           }
           if (banderaNumeroRegistroEncontrado == 1) {//SI LA BUSQUEDA ENCONTRO UN REGISTRO CON EL MISMO NÚMERO ASOCIADO A UN ID DIFERENTE MUESTRA UN MENSAJE DE NÚMERO DE REGISTRO REPETIDO.
              respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_NUMERO_REGISTRO_YA_EXISTE, false);
              respuestaDTO.setCuentaEquipoIngenieroDTO(null);
           }
           if ((banderaNombreRegistroEncontrado == 0) && (banderaNumeroRegistroEncontrado == 0)) {//SI NO ENCONTRO CONFLICTOS DE NOMBRE NI DE NÚMERO SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
              CuentaEquipoIngeniero cuentaEquipoIngeniero = cuentaEquipoIngenieroDAO.cuentaEquipoIngeniero(cuentaEquipoIngenieroDTO);
              cuentaEquipoIngenieroRepository.save(cuentaEquipoIngeniero);
              respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
           }
        }
        if (cuentaEquipoIngenieroId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MUESTRA UN MENSAJE DE REGISTRO NO MODIFICADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
           respuestaDTO.setCuentaEquipoIngenieroDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //ELIMINAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE ELIMINAR REGISTRO.
    public RespuestaDTO eliminarCuentaEquipoIngeniero(Long idCuentaEquipoIngeniero) {
        Optional<CuentaEquipoIngeniero> cuentaEquipoIngenieroId = cuentaEquipoIngenieroRepository.findById(idCuentaEquipoIngeniero);
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (cuentaEquipoIngenieroId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO.setCuentaEquipoIngenieroDTO(cuentaEquipoIngenieroDAO.cuentaEquipoIngenieroDTO(cuentaEquipoIngenieroId.get()));
           cuentaEquipoIngenieroRepository.delete(cuentaEquipoIngenieroId.get());
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ELIMINADO_EXITO, true);
        }
        if (cuentaEquipoIngenieroId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS NO ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO NO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setCuentaEquipoIngenieroDTO(null);
        }
        
        return respuestaDTO;
    }
}
