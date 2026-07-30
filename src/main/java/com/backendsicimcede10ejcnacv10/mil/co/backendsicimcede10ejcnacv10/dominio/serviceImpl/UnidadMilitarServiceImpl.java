//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.serviceImpl;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.Constantes.MensajesConstantes;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.UnidadMilitarDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service.UnidadMilitarService;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao.UnidadMilitarDAO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.UnidadMilitar;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.UnidadMilitarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
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
public class UnidadMilitarServiceImpl implements UnidadMilitarService {
    
    @Autowired//INYECTAMOS EL DAO.
    private UnidadMilitarDAO unidadMilitarDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private UnidadMilitarRepository unidadMilitarRepository;
    
    //CONTAR TOTAL DE REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE CONTAR TOTAL DE REGISTROS.
    public Long contarTotalRegistros(Long idUnidadMilitar, String keyword) {
        return unidadMilitarRepository.findTotalRegistros(idUnidadMilitar, keyword);
    }
    
    //LISTAR REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public List<UnidadMilitarDTO> listarUnidadesMilitares(Long idUnidadMilitar, String keyword, String orderBy, String orderMode) {
        List<UnidadMilitar> unidadesMilitares = unidadMilitarRepository.findAllUnidadesMilitares(idUnidadMilitar, keyword, orderBy, orderMode);
        List<UnidadMilitarDTO> unidadMilitarDTOS = new ArrayList<>();
        
        for (UnidadMilitar unidadMilitar : unidadesMilitares){
            unidadMilitarDTOS.add(unidadMilitarDAO.unidadMilitarDTO(unidadMilitar));
        }
        
        return unidadMilitarDTOS;
    }
    
    //LISTAR REGISTROS PAGINADOS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS PAGINADOS.
    public Slice<UnidadMilitarDTO> listarUnidadesMilitaresPag(Pageable pageable, Long idUnidadMilitar, String keyword, String orderBy, String orderMode) {
        Slice<UnidadMilitar> unidadesMilitares = unidadMilitarRepository.findAllUnidadesMilitaresPag(pageable, idUnidadMilitar, keyword, orderBy, orderMode);
        return unidadesMilitares.map(unidadMilitar -> unidadMilitarDAO.unidadMilitarDTO(unidadMilitar));
    }
    
    //CREAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE CREAR REGISTRO.
    public RespuestaDTO crearUnidadMilitar(UnidadMilitarDTO unidadMilitarDTO) {
        Long maxIdUnidadMilitar=null;
        UnidadMilitar unidadMilitarNombre = unidadMilitarRepository.findByNombreUnidadMilitar(unidadMilitarDTO.getNombreUnidadMilitar().toUpperCase());
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
    public RespuestaDTO actualizarUnidadMilitar(UnidadMilitarDTO unidadMilitarDTO) {
        Optional<UnidadMilitar> unidadMilitarId = unidadMilitarRepository.findByIdUnidadMilitar(unidadMilitarDTO.getIdUnidadMilitar());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
        
        if (unidadMilitarId.isPresent()==true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE VERIFICA EL NOMBRE DEL REGISTRO CON EL ID PROPORCIONADO.
           if ( (unidadMilitarDTO.getNombreUnidadMilitar().equals(unidadMilitarId.get().getNombreUnidadMilitar())==true)&&(unidadMilitarDTO.getSiglaoAcronimoUnidadMilitar().equals(unidadMilitarId.get().getSiglaoAcronimoUnidadMilitar())==true)&&(unidadMilitarDTO.getCodigoUnidadMilitar().equals(unidadMilitarId.get().getCodigoUnidadMilitar())==true) ) {//SI EL NOMBRE, SIGLA O ACRÓNIMO Y CÓDIGO DIGITADO ES IGUAL AL ALMACENADO EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
              UnidadMilitar unidadMilitar = unidadMilitarDAO.unidadMilitar(unidadMilitarDTO);
              unidadMilitarRepository.save(unidadMilitar);
              respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
           }
           if (unidadMilitarDTO.getNombreUnidadMilitar().equals(unidadMilitarId.get().getNombreUnidadMilitar())==false) {//SI EL NOMBRE O SIGLA O ACRÓNIMO DIGITADO ES DIFERENTE AL NOMBRE O SIGLA O ACRÓNIMO ALMACENADO EN LA TABLA DE LA BASE DE DATOS SE REALIZA BUSQUEDA PARA VERIFICAR SI ESTE NOMBRE O SIGLA O ACRÓNIMO DIGITADO EXISTE EN OTROS REGISTROS.
              //consulte por nombre e imprima si existe y si no existe
              UnidadMilitar unidadMilitarNombre = unidadMilitarRepository.findByNombreUnidadMilitar(unidadMilitarDTO.getNombreUnidadMilitar().toUpperCase());
              
              //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
              long banderaNombreRegistroEncontrado=0;
              
              if (!(unidadMilitarNombre==null)) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
                 banderaNombreRegistroEncontrado=1;
              }
              
              if (banderaNombreRegistroEncontrado==1) {//SI LA BUSQUEDA OBTIENE QUE EL NOMBRE DIGITADO Y BUSCADO ES DIFERENTE DE NULO SIGNIFICA QUE ENCONTRO EL MISMO NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS Y MUESTRA UN MENSAJE DE NOMBRE DEL REGISTRO REPETIDO.
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_YA_EXISTE, false);
                 respuestaDTO.setUnidadMilitarDTO(null);
              }
              if (banderaNombreRegistroEncontrado==0) {//SI LA BUSQUEDA OBTIENE QUE EL NOMBRE DIGITADO Y BUSCADO ES NULO EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
                 UnidadMilitar unidadMilitar = unidadMilitarDAO.unidadMilitar(unidadMilitarDTO);
                 unidadMilitarRepository.save(unidadMilitar);
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
              }
           }
           if (unidadMilitarDTO.getSiglaoAcronimoUnidadMilitar().equals(unidadMilitarId.get().getSiglaoAcronimoUnidadMilitar())==false) {//SI LA SIGLA O ACRÓNIMO DIGITADO ES DIFERENTE AL ALMACENADO EN LA TABLA DE LA BASE DE DATOS SE REALIZA BUSQUEDA PARA VERIFICAR SI EXISTE EN OTROS REGISTROS.
              //consulte por nombre e imprima si existe y si no existe
              UnidadMilitar unidadMilitarSiglaoAcronimo = unidadMilitarRepository.findBySiglaoAcronimoUnidadMilitar(unidadMilitarDTO.getSiglaoAcronimoUnidadMilitar().toUpperCase());
              
              //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
              long banderaSiglaoAcronimoEncontrado=0;
              
              if (!(unidadMilitarSiglaoAcronimo==null)) {//SI ENCONTRO LA SIGLA O ACRÓNIMO DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE SIGLA O ACRÓNIMO DE REGISTRO REPETIDO CON LA MISMA SIGLA O ACRÓNIMO PROPORCIONADO.
                 banderaSiglaoAcronimoEncontrado=1;
              }
              
              if (banderaSiglaoAcronimoEncontrado==1) {//SI LA BUSQUEDA OBTIENE QUE LA SIGLA O ACRÓNIMO DIGITADO Y BUSCADO ES DIFERENTE DE NULO SIGNIFICA QUE ENCONTRO LA MISMA SIGLA O ACRÓNIMO ALMACENADO EN LA TABLA DE LA BASE DE DATOS Y MUESTRA UN MENSAJE DE SIGLA O ACRÓNIMO DEL REGISTRO REPETIDO.
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_SIGLA_O_ACRONIMO_YA_EXISTE, false);
                 respuestaDTO.setUnidadMilitarDTO(null);
              }
              if (banderaSiglaoAcronimoEncontrado==0) {//SI LA BUSQUEDA OBTIENE QUE LA SIGLA O ACRÓNIMO DIGITADO Y BUSCADO ES NULO EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
                 UnidadMilitar unidadMilitar = unidadMilitarDAO.unidadMilitar(unidadMilitarDTO);
                 unidadMilitarRepository.save(unidadMilitar);
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
              }
           }
           if (unidadMilitarDTO.getCodigoUnidadMilitar().equals(unidadMilitarId.get().getCodigoUnidadMilitar())==false) {//SI EL CÓDIGO DIGITADO ES DIFERENTE AL ALMACENADO EN LA TABLA DE LA BASE DE DATOS SE REALIZA BUSQUEDA PARA VERIFICAR SI EXISTE EN OTROS REGISTROS.
              UnidadMilitar unidadMilitarCodigo = unidadMilitarRepository.findByCodigoUnidadMilitar(unidadMilitarDTO.getCodigoUnidadMilitar().toUpperCase());
              
              //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
              long banderaCodigoRegistroEncontrado=0;
              
              if (!(unidadMilitarCodigo==null)) {//SI ENCONTRO EL CÓDIGO DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE CÓDIGO DE REGISTRO REPETIDO CON EL CÓDIGO PROPORCIONADO.
                 banderaCodigoRegistroEncontrado=1;
              }
              
              if (banderaCodigoRegistroEncontrado==1) {//SI LA BUSQUEDA OBTIENE QUE EL CÓDIGO DIGITADO Y BUSCADO ES DIFERENTE DE NULO SIGNIFICA QUE ENCONTRO EL MISMO CÓDIGO ALMACENADO EN LA TABLA DE LA BASE DE DATOS Y MUESTRA UN MENSAJE DE CÓDIGO DEL REGISTRO REPETIDO.
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CODIGO_YA_EXISTE, false);
                 respuestaDTO.setUnidadMilitarDTO(null);
              }
              if (banderaCodigoRegistroEncontrado==0) {//SI LA BUSQUEDA OBTIENE QUE EL CÓDIGO DIGITADO Y BUSCADO ES NULO EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
                 UnidadMilitar unidadMilitar = unidadMilitarDAO.unidadMilitar(unidadMilitarDTO);
                 unidadMilitarRepository.save(unidadMilitar);
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
              }
           }
        }
        if (unidadMilitarId.isPresent()==false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MUESTRA UN MENSAJE DE REGISTRO NO MODIFICADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
           respuestaDTO.setUnidadMilitarDTO(null);
        }
        
        return respuestaDTO;
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
