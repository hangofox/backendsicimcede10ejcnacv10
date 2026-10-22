//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.serviceImpl;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.Constantes.MensajesConstantes;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.UnidadMilitarDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service.UnidadMilitarService;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao.UnidadMilitarDAO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.LineaMandoUnidadMilitar;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.UnidadMilitar;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.LineaMandoUnidadMilitarRepository;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.UnidadMilitarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
* * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 01/08/2023.
* Esta es la declaración de la implementación del servicio.
* Se inyectan DAOS y repositorios.
*/
@Service//DECLARACIÓN DE LA IMPLEMENTACIÓN DEL SERVICIO.
//DECLARACIÓN DE LA CLASE DE LA IMPLEMENTACIÓN DEL SERVICIO:
public class UnidadMilitarServiceImpl implements UnidadMilitarService {
    
    @Autowired//INYECTAMOS EL DAO.
    private UnidadMilitarDAO unidadMilitarDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private UnidadMilitarRepository unidadMilitarRepository;
    
    @Autowired//INYECTAMOS EL REPOSITORIO DE LAS LÍNEAS DE MANDO (SE ACTUALIZAN AL CAMBIAR LA SIGLA O ACRÓNIMO).
    private LineaMandoUnidadMilitarRepository lineaMandoUnidadMilitarRepository;
    
    //CONTAR TOTAL DE REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE CONTAR TOTAL DE REGISTROS.
    public Long contarTotalRegistros(Long idUnidadMilitar, String keyword, String nivelUnidadMilitar) {
        return unidadMilitarRepository.findTotalRegistros(idUnidadMilitar, keyword, nivelUnidadMilitar);
    }
    
    //LISTAR REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public List<UnidadMilitarDTO> listarUnidadesMilitares(Long idUnidadMilitar, String keyword, String nivelUnidadMilitar, String orderBy, String orderMode) {
        List<UnidadMilitar> unidadesMilitares = unidadMilitarRepository.findAllUnidadesMilitares(idUnidadMilitar, keyword, nivelUnidadMilitar, orderBy, orderMode);
        List<UnidadMilitarDTO> unidadMilitarDTOS = new ArrayList<>();
        
        for (UnidadMilitar unidadMilitar : unidadesMilitares){
            unidadMilitarDTOS.add(unidadMilitarDAO.unidadMilitarDTO(unidadMilitar));
        }
        
        return unidadMilitarDTOS;
    }
    
    //LISTAR REGISTROS PAGINADOS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS PAGINADOS.
    public Slice<UnidadMilitarDTO> listarUnidadesMilitaresPag(Pageable pageable, Long idUnidadMilitar, String keyword, String nivelUnidadMilitar, String orderBy, String orderMode) {
        Slice<UnidadMilitar> unidadesMilitares = unidadMilitarRepository.findAllUnidadesMilitaresPag(pageable, idUnidadMilitar, keyword, nivelUnidadMilitar, orderBy, orderMode);
        return unidadesMilitares.map(unidadMilitar -> unidadMilitarDAO.unidadMilitarDTO(unidadMilitar));
    }
    
    //CREAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE CREAR REGISTRO.
    public RespuestaDTO crearUnidadMilitar(UnidadMilitarDTO unidadMilitarDTO) {
        Long maxIdUnidadMilitar=null;
        UnidadMilitar unidadMilitarNombre = unidadMilitarRepository.findByNombreUnidadMilitar(UnidadMilitarDAO.normalizarNombreUnidadMilitar(unidadMilitarDTO.getNombreUnidadMilitar()));
        UnidadMilitar unidadMilitarSiglaoAcronimo = unidadMilitarRepository.findBySiglaoAcronimoUnidadMilitar(unidadMilitarDTO.getSiglaoAcronimoUnidadMilitar().toUpperCase());
        UnidadMilitar unidadMilitarCodigo = unidadMilitarRepository.findByCodigoUnidadMilitar(unidadMilitarDTO.getCodigoUnidadMilitar().toUpperCase());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_CREADO, false);
        
        //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
        long banderaNombreRegistroEncontrado=0, banderaSiglaoAcronimoEncontrado=0, banderaCodigoRegistroEncontrado=0;
        
        if (!(unidadMilitarNombre==null)) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
           banderaNombreRegistroEncontrado=1;
        }
        if (!(unidadMilitarSiglaoAcronimo==null)) {//SI ENCONTRO LA SIGLA O ACRÓNIMO DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE SIGLA O ACRÓNIMO DE REGISTRO REPETIDO CON LA MISMA SIGLA O ACRÓNIMO PROPORCIONADO.
           banderaSiglaoAcronimoEncontrado=1;
        }
        if (!(unidadMilitarCodigo==null)) {//SI ENCONTRO EL CÓDIGO DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE CÓDIGO DE REGISTRO REPETIDO CON EL CÓDIGO PROPORCIONADO.
           banderaCodigoRegistroEncontrado=1;
        }
        
        //System.out.println("INGRESA METODO CREAR.");
        if (banderaNombreRegistroEncontrado==1) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_YA_EXISTE, false);
           respuestaDTO.setUnidadMilitarDTO(null);
        }
        if (banderaSiglaoAcronimoEncontrado==1) {//SI ENCONTRO LA SIGLA O ACRÓNIMO DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE SIGLA O ACRÓNIMO DE REGISTRO REPETIDO CON LA SIGLA O ACRÓNIMO PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_SIGLA_O_ACRONIMO_YA_EXISTE, false);
           respuestaDTO.setUnidadMilitarDTO(null);
        }
        if (banderaCodigoRegistroEncontrado==1) {//SI ENCONTRO EL CÓDIGO DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE CÓDIGO DE REGISTRO REPETIDO CON EL CÓDIGO PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CODIGO_YA_EXISTE, false);
           respuestaDTO.setUnidadMilitarDTO(null);
        }
        if ((banderaNombreRegistroEncontrado==0)&&(banderaSiglaoAcronimoEncontrado==0)&&(banderaCodigoRegistroEncontrado==0)) {//SI NO ENCONTRO EL NOMBRE, SIGLA O ACRÓNIMO Y CÓDIGO DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS CREA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO CREADO EXITOSAMENTE.
           maxIdUnidadMilitar = unidadMilitarRepository.findMaxIdUnidadMilitar();
           if (maxIdUnidadMilitar==null) {//ESTO SE HACE EN CASO DE QUE SI LA TABLA DE LA BASE DE DATOS ESTA EN BLANCO Y VA SER EL PRIMER REGISTRO AL OBTENER UN VALOR NULO, SE ASIGNE CERO (0) AUTOMÁTICAMENTE PORQUE SI NO ARROJARIA UN ERROR DE CONVERSIÓN DE CARACTER NULO AL SUMAR CON NÚMERO ENTERO.
              maxIdUnidadMilitar=Long.valueOf(0);
           }
           unidadMilitarDTO.setIdUnidadMilitar(maxIdUnidadMilitar+1);//OBTENGO EL ID MAXIMO AUTOMATICO, SUMO (1) ENTERO PARA OBTENER EL NUEVO ID.
           
           unidadMilitarRepository.save(unidadMilitarDAO.unidadMilitar(unidadMilitarDTO));
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CREADO_EXITO, true);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR ID:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarUnidadMilitarporId(Long idUnidadMilitar) {
        Optional<UnidadMilitar> unidadMilitarId = unidadMilitarRepository.findByIdUnidadMilitar(Long.valueOf(idUnidadMilitar));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (unidadMilitarId.isPresent()==true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO.setUnidadMilitarDTO(unidadMilitarDAO.unidadMilitarDTO(unidadMilitarId.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (unidadMilitarId.isPresent()==false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setUnidadMilitarDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR CÓDIGO:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarUnidadMilitarporCodigo(String codigoUnidadMilitar) {
        Optional<UnidadMilitar> unidadMilitarCodigo = Optional.ofNullable(unidadMilitarRepository.findByCodigoUnidadMilitar(codigoUnidadMilitar.toUpperCase()));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CODIGO_NO_ENCONTRADO, false);
        
        if (unidadMilitarCodigo.isPresent()==true) {//SI ENCONTRO EL CÓDIGO DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL CÓDIGO PROPORCIONADO.
           respuestaDTO.setUnidadMilitarDTO(unidadMilitarDAO.unidadMilitarDTO(unidadMilitarCodigo.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (unidadMilitarCodigo.isPresent()==false) {//SI NO ENCONTRO EL CÓDIGO DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON EL CÓDIGO PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CODIGO_NO_ENCONTRADO, false);
           respuestaDTO.setUnidadMilitarDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR SIGLA O ACRÓNIMO:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarUnidadMilitarporSiglaoAcronimo(String siglaoAcronimoUnidadMilitar) {
        Optional<UnidadMilitar> unidadMilitarSiglaoAcronimo = Optional.ofNullable(unidadMilitarRepository.findBySiglaoAcronimoUnidadMilitar(siglaoAcronimoUnidadMilitar));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_SIGLA_O_ACRONIMO_NO_ENCONTRADO, false);
        
        if (unidadMilitarSiglaoAcronimo.isPresent()==true) {//SI ENCONTRO LA SIGLA O ACRÓNIMO DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON LA SIGLA O ACRÓNIMO PROPORCIONADO.
           respuestaDTO.setUnidadMilitarDTO(unidadMilitarDAO.unidadMilitarDTO(unidadMilitarSiglaoAcronimo.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (unidadMilitarSiglaoAcronimo.isPresent()==false) {//SI NO ENCONTRO LA SIGLA O ACRÓNIMO DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON LA SIGLA O ACRÓNIMO PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_SIGLA_O_ACRONIMO_NO_ENCONTRADO, false);
           respuestaDTO.setUnidadMilitarDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //MODIFICAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE MODIFICAR REGISTRO.
    @Transactional//LA MODIFICACIÓN DE LA UNIDAD MILITAR Y LA ACTUALIZACIÓN DE SUS LÍNEAS DE MANDO SE CONFIRMAN O SE REVIERTEN JUNTAS.
    public RespuestaDTO actualizarUnidadMilitar(UnidadMilitarDTO unidadMilitarDTO) {
        Optional<UnidadMilitar> unidadMilitarId = unidadMilitarRepository.findByIdUnidadMilitar(unidadMilitarDTO.getIdUnidadMilitar());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
        
        if (unidadMilitarId.isPresent()==false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MUESTRA UN MENSAJE DE REGISTRO NO MODIFICADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO.setUnidadMilitarDTO(null);
           return respuestaDTO;
        }
        
        //VALORES DIGITADOS NORMALIZADOS IGUAL QUE COMO SE ALMACENAN (VER UnidadMilitarDAO):
        String nombreNuevo = UnidadMilitarDAO.normalizarNombreUnidadMilitar(unidadMilitarDTO.getNombreUnidadMilitar());
        String siglaoAcronimoNuevo = unidadMilitarDTO.getSiglaoAcronimoUnidadMilitar().toUpperCase();
        String codigoNuevo = unidadMilitarDTO.getCodigoUnidadMilitar().toUpperCase();
        String siglaoAcronimoAnterior = unidadMilitarId.get().getSiglaoAcronimoUnidadMilitar();
        
        //PRIMERO SE VALIDA QUE EL NOMBRE, LA SIGLA O ACRÓNIMO Y EL CÓDIGO NO EXISTAN EN OTRO REGISTRO; SOLO SI LOS TRES SON VÁLIDOS
        //SE MODIFICA EL REGISTRO (ANTES SE GUARDABA CADA CAMPO POR SEPARADO Y EL REGISTRO QUEDABA MODIFICADO AUNQUE OTRO CAMPO ESTUVIERA REPETIDO):
        if (existeEnOtroRegistro(unidadMilitarRepository.findByNombreUnidadMilitar(nombreNuevo), unidadMilitarDTO.getIdUnidadMilitar())) {//NOMBRE REPETIDO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_YA_EXISTE, false);
           respuestaDTO.setUnidadMilitarDTO(null);
           return respuestaDTO;
        }
        if (existeEnOtroRegistro(unidadMilitarRepository.findBySiglaoAcronimoUnidadMilitar(siglaoAcronimoNuevo), unidadMilitarDTO.getIdUnidadMilitar())) {//SIGLA O ACRÓNIMO REPETIDO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_SIGLA_O_ACRONIMO_YA_EXISTE, false);
           respuestaDTO.setUnidadMilitarDTO(null);
           return respuestaDTO;
        }
        if (existeEnOtroRegistro(unidadMilitarRepository.findByCodigoUnidadMilitar(codigoNuevo), unidadMilitarDTO.getIdUnidadMilitar())) {//CÓDIGO REPETIDO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CODIGO_YA_EXISTE, false);
           respuestaDTO.setUnidadMilitarDTO(null);
           return respuestaDTO;
        }
        
        //SI CAMBIÓ LA SIGLA O ACRÓNIMO SE PREPARAN LAS LÍNEAS DE MANDO QUE LA USAN COMO PASO (EJ. CAOCC->JEMOP->SECEJ->COEJC):
        List<LineaMandoUnidadMilitar> lineasMandosActualizadas = new ArrayList<>();
        if (siglaoAcronimoNuevo.equals(siglaoAcronimoAnterior)==false) {
           for (LineaMandoUnidadMilitar lineaMando : lineaMandoUnidadMilitarRepository.findByPasoSiglaoAcronimoUnidadMilitar(siglaoAcronimoAnterior)) {
              String lineaMandoNueva = reemplazarPasoLineaMando(lineaMando.getLineaMandoUnidadMilitar(), siglaoAcronimoAnterior, siglaoAcronimoNuevo);
              if (lineaMandoNueva.equals(lineaMando.getLineaMandoUnidadMilitar())) {//EL LIKE PUDO TRAER UNA LÍNEA SIN EL PASO EXACTO.
                 continue;
              }
              if (lineaMandoNueva.length() > 255) {//LA COLUMNA LINEA_MANDO_UNIDAD_MILITAR ES VARCHAR2(255).
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_LINEA_MANDO_EXCEDE_LONGITUD_CON_SIGLA_NUEVA, false);
                 respuestaDTO.setUnidadMilitarDTO(null);
                 return respuestaDTO;
              }
              lineaMando.setLineaMandoUnidadMilitar(lineaMandoNueva);
              lineasMandosActualizadas.add(lineaMando);
           }
        }
        
        //SE MODIFICA EL REGISTRO Y LAS LÍNEAS DE MANDO EN LA MISMA TRANSACCIÓN:
        UnidadMilitar unidadMilitar = unidadMilitarDAO.unidadMilitar(unidadMilitarDTO);
        unidadMilitarRepository.save(unidadMilitar);
        lineaMandoUnidadMilitarRepository.saveAll(lineasMandosActualizadas);
        
        String mensaje = MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO;
        if (lineasMandosActualizadas.isEmpty()==false) {
           mensaje = mensaje + " Se actualizó la sigla o acrónimo en " + lineasMandosActualizadas.size() + (lineasMandosActualizadas.size()==1 ? " línea de mando." : " líneas de mando.");
        }
        respuestaDTO = new RespuestaDTO(mensaje, true);
        
        return respuestaDTO;
    }
    
    //INDICA SI EL REGISTRO ENCONTRADO POR NOMBRE, SIGLA O CÓDIGO PERTENECE A OTRA UNIDAD MILITAR (NO AL QUE SE ESTÁ MODIFICANDO):
    private boolean existeEnOtroRegistro(UnidadMilitar unidadMilitarEncontrada, Long idUnidadMilitar) {
        return unidadMilitarEncontrada!=null && unidadMilitarEncontrada.getIdUnidadMilitar().equals(idUnidadMilitar)==false;
    }
    
    //REEMPLAZA LA SIGLA O ACRÓNIMO ANTERIOR POR LA NUEVA SOLO CUANDO ES UN PASO COMPLETO DE LA LÍNEA DE MANDO, ES DECIR, CUANDO
    //ESTÁ ENTRE LOS SEPARADORES "->", "[" O "]" DE LOS FINALES ALTERNATIVOS (EJ. "CAOCC->[SECEJ->CEDE10][CEDE10]"), PARA QUE
    //CAMBIAR "BR06" NO ALTERE OTRA SIGLA QUE LA CONTENGA COMO "BR06A". SE QUITAN LOS ESPACIOS ALREDEDOR DE LOS SEPARADORES:
    private String reemplazarPasoLineaMando(String lineaMando, String siglaoAcronimoAnterior, String siglaoAcronimoNuevo) {
        String lineaMandoCompacta = lineaMando.trim().replaceAll("\\s*(->|\\[|\\])\\s*", "$1");
        return lineaMandoCompacta.replaceAll("(^|->|\\[|\\])" + Pattern.quote(siglaoAcronimoAnterior) + "(?=$|->|\\[|\\])", "$1" + Matcher.quoteReplacement(siglaoAcronimoNuevo));
    }
    
    //ELIMINAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE ELIMINAR REGISTRO.
    public RespuestaDTO eliminarUnidadMilitar(Long idUnidadMilitar) {
        Optional<UnidadMilitar> unidadMilitarId = unidadMilitarRepository.findById(idUnidadMilitar);
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (unidadMilitarId.isPresent()==true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO.setUnidadMilitarDTO(unidadMilitarDAO.unidadMilitarDTO(unidadMilitarId.get()));
           unidadMilitarRepository.delete(unidadMilitarId.get());
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ELIMINADO_EXITO, true);
        }
        if (unidadMilitarId.isPresent()==false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS NO ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO NO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setUnidadMilitarDTO(null);
        }
        
        return respuestaDTO;
    }
}
