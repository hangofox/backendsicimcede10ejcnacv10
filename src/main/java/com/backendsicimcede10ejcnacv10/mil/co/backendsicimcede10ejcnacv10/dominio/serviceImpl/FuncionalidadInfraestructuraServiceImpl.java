//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.serviceImpl;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.Constantes.MensajesConstantes;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.FuncionalidadInfraestructuraDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service.FuncionalidadInfraestructuraService;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao.FuncionalidadInfraestructuraDAO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.FuncionalidadInfraestructura;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.FuncionalidadInfraestructuraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
* * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 16/03/2026.
* Esta es la declaración de la implementación del servicio.
* Se inyectan DAOS y repositorios.
*/
@Service//DECLARACIÓN DE LA IMPLEMENTACIÓN DEL SERVICIO.
//DECLARACIÓN DE LA CLASE DE LA IMPLEMENTACIÓN DEL SERVICIO:
public class FuncionalidadInfraestructuraServiceImpl implements FuncionalidadInfraestructuraService {
    
    @Autowired//INYECTAMOS EL DAO.
    private FuncionalidadInfraestructuraDAO funcionalidadInfraestructuraDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private FuncionalidadInfraestructuraRepository funcionalidadInfraestructuraRepository;
    
    //LISTAR REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public List<FuncionalidadInfraestructuraDTO> listarFuncionalidadesInfraestructura() {
        List<FuncionalidadInfraestructura> funcionalidadesInfraestructura = funcionalidadInfraestructuraRepository.findAll();
        List<FuncionalidadInfraestructuraDTO> funcionalidadInfraestructuraDTOS = new ArrayList<>();
        
        for (FuncionalidadInfraestructura funcionalidadInfraestructura : funcionalidadesInfraestructura){
            funcionalidadInfraestructuraDTOS.add(funcionalidadInfraestructuraDAO.funcionalidadInfraestructuraDTO(funcionalidadInfraestructura));
        }
        
        return funcionalidadInfraestructuraDTOS;
    }
    
    //LISTAR REGISTROS ORDENADOS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public List<FuncionalidadInfraestructuraDTO> listarFuncionalidadesInfraestructuraOrdenadasporId(String orderBy, String orderMode) {
        List<FuncionalidadInfraestructura> funcionalidadesInfraestructura = funcionalidadInfraestructuraRepository.findAllFuncionalidadesInfraestructura(orderBy, orderMode);
        List<FuncionalidadInfraestructuraDTO> funcionalidadInfraestructuraDTOS = new ArrayList<>();
        
        for (FuncionalidadInfraestructura funcionalidadInfraestructura : funcionalidadesInfraestructura){
            funcionalidadInfraestructuraDTOS.add(funcionalidadInfraestructuraDAO.funcionalidadInfraestructuraDTO(funcionalidadInfraestructura));
        }
        
        return funcionalidadInfraestructuraDTOS;
    }
    
    //LISTAR REGISTROS ORDENADOS CON PAGINACIÓN:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public Slice<FuncionalidadInfraestructuraDTO> listarFuncionalidadesInfraestructuraOrdenadasporIdPag(Pageable pageable, String orderBy, String orderMode) {
        Slice<FuncionalidadInfraestructura> funcionalidadesInfraestructura = funcionalidadInfraestructuraRepository.findAllFuncionalidadesInfraestructuraPag(pageable, orderBy, orderMode);
        return funcionalidadesInfraestructura.map(funcionalidadInfraestructura -> funcionalidadInfraestructuraDAO.funcionalidadInfraestructuraDTO(funcionalidadInfraestructura));
    }
    
    //CREAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE CREAR REGISTRO.
    public RespuestaDTO crearFuncionalidadInfraestructura(FuncionalidadInfraestructuraDTO funcionalidadInfraestructuraDTO) {
        Long maxIdFuncionalidadInfraestructura=null;
        FuncionalidadInfraestructura funcionalidadInfraestructuraNombre = funcionalidadInfraestructuraRepository.findByNombreFuncionalidadInfraestructura(funcionalidadInfraestructuraDTO.getNombreFuncionalidadInfraestructura().toUpperCase());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_CREADO, false);
        
        //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
        long banderaNombreRegistroEncontrado=0;
        
        if (!(funcionalidadInfraestructuraNombre==null)) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
           banderaNombreRegistroEncontrado=1;
        }
        
        if (banderaNombreRegistroEncontrado==1) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_YA_EXISTE, false);
           respuestaDTO.setFuncionalidadInfraestructuraDTO(null);
        }
        if ((banderaNombreRegistroEncontrado==0) ) {//SI NO ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS CREA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO CREADO EXITOSAMENTE CON EL NOMBRE PROPORCIONADO.
           maxIdFuncionalidadInfraestructura = funcionalidadInfraestructuraRepository.findMaxIdFuncionalidadInfraestructura();
           if (maxIdFuncionalidadInfraestructura==null) {//ESTO SE HACE EN CASO DE QUE SI LA TABLA DE LA BASE DE DATOS ESTA EN BLANCO Y VA SER EL PRIMER REGISTRO AL OBTENER UN VALOR NULO, SE ASIGNE CERO (0) AUTOMÁTICAMENTE PORQUE SI NO ARROJARIA UN ERROR DE CONVERSIÓN DE CARACTER NULO AL SUMAR CON NÚMERO ENTERO.
              maxIdFuncionalidadInfraestructura=Long.valueOf(0);
           }
           funcionalidadInfraestructuraDTO.setIdFuncionalidadInfraestructura(maxIdFuncionalidadInfraestructura+1);//OBTENGO EL ID MAXIMO AUTOMATICO, SUMO (1) ENTERO PARA OBTENER EL NUEVO ID.
           
           funcionalidadInfraestructuraRepository.save(funcionalidadInfraestructuraDAO.funcionalidadInfraestructura(funcionalidadInfraestructuraDTO));
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CREADO_EXITO, true);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR ID:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarFuncionalidadInfraestructuraporId(Long idFuncionalidadInfraestructura) {
        Optional<FuncionalidadInfraestructura> funcionalidadInfraestructuraId = funcionalidadInfraestructuraRepository.findByIdFuncionalidadInfraestructura(Long.valueOf(idFuncionalidadInfraestructura));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (funcionalidadInfraestructuraId.isPresent()==true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO.setFuncionalidadInfraestructuraDTO(funcionalidadInfraestructuraDAO.funcionalidadInfraestructuraDTO(funcionalidadInfraestructuraId.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (funcionalidadInfraestructuraId.isPresent()==false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setFuncionalidadInfraestructuraDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR NOMBRE:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarFuncionalidadInfraestructuraporNombre(String nombreFuncionalidadInfraestructura) {
        Optional<FuncionalidadInfraestructura> funcionalidadInfraestructuraNombre = Optional.ofNullable(funcionalidadInfraestructuraRepository.findByNombreFuncionalidadInfraestructura(String.valueOf(nombreFuncionalidadInfraestructura)));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_NO_ENCONTRADO, false);
        
        if (funcionalidadInfraestructuraNombre.isPresent()==true) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL NOMBRE PROPORCIONADO.
           respuestaDTO.setFuncionalidadInfraestructuraDTO(funcionalidadInfraestructuraDAO.funcionalidadInfraestructuraDTO(funcionalidadInfraestructuraNombre.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (funcionalidadInfraestructuraNombre.isPresent()==false) {//SI NO ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON EL NOMBRE PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_NO_ENCONTRADO, false);
           respuestaDTO.setFuncionalidadInfraestructuraDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //MODIFICAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE MODIFICAR REGISTRO.
    public RespuestaDTO actualizarFuncionalidadInfraestructura(FuncionalidadInfraestructuraDTO funcionalidadInfraestructuraDTO) {
        Optional<FuncionalidadInfraestructura> funcionalidadInfraestructuraId = funcionalidadInfraestructuraRepository.findByIdFuncionalidadInfraestructura(funcionalidadInfraestructuraDTO.getIdFuncionalidadInfraestructura());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
        
        if (funcionalidadInfraestructuraId.isPresent()==true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE VERIFICA EL NOMBRE DEL REGISTRO CON EL ID PROPORCIONADO.
           if ( (funcionalidadInfraestructuraDTO.getNombreFuncionalidadInfraestructura().equals(funcionalidadInfraestructuraId.get().getNombreFuncionalidadInfraestructura())==true) ) {//SI EL NOMBRE DIGITADO ES IGUAL AL NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
              FuncionalidadInfraestructura funcionalidadInfraestructura = funcionalidadInfraestructuraDAO.funcionalidadInfraestructura(funcionalidadInfraestructuraDTO);
              funcionalidadInfraestructuraRepository.save(funcionalidadInfraestructura);
              respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
           }
           if (funcionalidadInfraestructuraDTO.getNombreFuncionalidadInfraestructura().equals(funcionalidadInfraestructuraId.get().getNombreFuncionalidadInfraestructura())==false) {//SI EL NOMBRE DIGITADO ES DIFERENTE AL NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS SE REALIZA BUSQUEDA PARA VERIFICAR SI ESTE NOMBRE DIGITADO EXISTE EN OTROS REGISTROS.
              //consulte por nombre e imprima si existe y si no existe
              FuncionalidadInfraestructura funcionalidadInfraestructuraNombre = funcionalidadInfraestructuraRepository.findByNombreFuncionalidadInfraestructura(funcionalidadInfraestructuraDTO.getNombreFuncionalidadInfraestructura().toUpperCase());
              
              //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
              long banderaNombreRegistroEncontrado=0;
              
              if (!(funcionalidadInfraestructuraNombre==null)) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
                 banderaNombreRegistroEncontrado=1;
              }
              
              if (banderaNombreRegistroEncontrado==1) {//SI LA BUSQUEDA OBTIENE QUE EL NOMBRE DIGITADO Y BUSCADO ES DIFERENTE DE NULO SIGNIFICA QUE ENCONTRO EL MISMO NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS Y MUESTRA UN MENSAJE DE NOMBRE DEL REGISTRO REPETIDO.
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_YA_EXISTE, false);
                 respuestaDTO.setFuncionalidadInfraestructuraDTO(null);
              }
              if (banderaNombreRegistroEncontrado==0) {//SI LA BUSQUEDA OBTIENE QUE EL NOMBRE DIGITADO Y BUSCADO ES NULO EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
                 FuncionalidadInfraestructura funcionalidadInfraestructura = funcionalidadInfraestructuraDAO.funcionalidadInfraestructura(funcionalidadInfraestructuraDTO);
                 funcionalidadInfraestructuraRepository.save(funcionalidadInfraestructura);
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
              }
           }
        }
        if (funcionalidadInfraestructuraId.isPresent()==false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MUESTRA UN MENSAJE DE REGISTRO NO MODIFICADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
           respuestaDTO.setFuncionalidadInfraestructuraDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //ELIMINAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE ELIMINAR REGISTRO.
    public RespuestaDTO eliminarFuncionalidadInfraestructura(Long idFuncionalidadInfraestructura) {
        Optional<FuncionalidadInfraestructura> funcionalidadInfraestructuraId  = funcionalidadInfraestructuraRepository.findById(idFuncionalidadInfraestructura);
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (funcionalidadInfraestructuraId .isPresent()==true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO.setFuncionalidadInfraestructuraDTO(funcionalidadInfraestructuraDAO.funcionalidadInfraestructuraDTO(funcionalidadInfraestructuraId.get()));
           funcionalidadInfraestructuraRepository.delete(funcionalidadInfraestructuraId.get());
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ELIMINADO_EXITO, true);
        }
        if (funcionalidadInfraestructuraId .isPresent()==false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS NO ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO NO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setFuncionalidadInfraestructuraDTO(null);
        }
        
        return respuestaDTO;
    }
}
