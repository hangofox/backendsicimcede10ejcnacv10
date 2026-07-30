//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.serviceImpl;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.Constantes.MensajesConstantes;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.MaquinariaPesadaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service.MaquinariaPesadaService;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao.MaquinariaPesadaDAO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.MaquinariaPesada;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.MaquinariaPesadaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
* * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 17/12/2025.
* Esta es la declaración de la implementación del servicio.
* Se inyectan DAOS y repositorios.
*/
@Service//DECLARACIÓN DE LA IMPLEMENTACIÓN DEL SERVICIO.
//DECLARACIÓN DE LA CLASE DE LA IMPLEMENTACIÓN DEL SERVICIO:
public class MaquinariaPesadaServiceImpl implements MaquinariaPesadaService {
    
    @Autowired//INYECTAMOS EL DAO.
    private MaquinariaPesadaDAO maquinariaPesadaDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private MaquinariaPesadaRepository maquinariaPesadaRepository;
    
    //LISTAR REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public List<MaquinariaPesadaDTO> listarMaquinariasPesadas() {
        List<MaquinariaPesada> maquinariasPesadas = maquinariaPesadaRepository.findAll();
        List<MaquinariaPesadaDTO> maquinariaPesadaDTOS = new ArrayList<>();
        
        for (MaquinariaPesada maquinariaPesada : maquinariasPesadas){
            maquinariaPesadaDTOS.add(maquinariaPesadaDAO.maquinariaPesadaDTO(maquinariaPesada));
        }
        
        return maquinariaPesadaDTOS;
    }
    
    //LISTAR REGISTROS ORDENADOS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public List<MaquinariaPesadaDTO> listarMaquinariasPesadas(Long idMaquinariaPesada, String orderBy, String orderMode) {
        List<MaquinariaPesada> maquinariasPesadas = maquinariaPesadaRepository.findAllMaquinariasPesadas(idMaquinariaPesada, orderBy, orderMode);
        List<MaquinariaPesadaDTO> maquinariaPesadaDTOS = new ArrayList<>();
        
        for (MaquinariaPesada maquinariaPesada : maquinariasPesadas){
            maquinariaPesadaDTOS.add(maquinariaPesadaDAO.maquinariaPesadaDTO(maquinariaPesada));
        }
        
        return maquinariaPesadaDTOS;
    }
    
    //LISTAR REGISTROS PAGINADOS ORDENADOS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public Slice<MaquinariaPesadaDTO> listarMaquinariasPesadasPag(Pageable pageable, Long idMaquinariaPesada, String orderBy, String orderMode) {
        Slice<MaquinariaPesada> maquinariasPesadas = maquinariaPesadaRepository.findAllMaquinariasPesadasPag(pageable, idMaquinariaPesada, orderBy, orderMode);
        return maquinariasPesadas.map(maquinariaPesada -> maquinariaPesadaDAO.maquinariaPesadaDTO(maquinariaPesada));
    }
    
    //CREAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE CREAR REGISTRO.
    public RespuestaDTO crearMaquinariaPesada(MaquinariaPesadaDTO maquinariaPesadaDTO) {
        Long maxIdMaquinariaPesada=null;
        MaquinariaPesada maquinariaPesadaNombre = maquinariaPesadaRepository.findByNombreMaquinariaPesada(maquinariaPesadaDTO.getNombreMaquinariaPesada().toUpperCase());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_CREADO, false);
        
        //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
        long banderaNombreRegistroEncontrado=0;
        
        if (!(maquinariaPesadaNombre==null)) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
           banderaNombreRegistroEncontrado=1;
        }
        
        //System.out.println("INGRESA METODO CREAR.");
        if (banderaNombreRegistroEncontrado==1) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_YA_EXISTE, false);
           respuestaDTO.setMaquinariaPesadaDTO(null);
        }
        if ((banderaNombreRegistroEncontrado==0) ) {//SI NO ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS CREA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO CREADO EXITOSAMENTE CON EL NOMBRE PROPORCIONADO.
           maxIdMaquinariaPesada = maquinariaPesadaRepository.findMaxIdMaquinariaPesada();
           if (maxIdMaquinariaPesada==null) {//ESTO SE HACE EN CASO DE QUE SI LA TABLA DE LA BASE DE DATOS ESTA EN BLANCO Y VA SER EL PRIMER REGISTRO AL OBTENER UN VALOR NULO, SE ASIGNE CERO (0) AUTOMÁTICAMENTE PORQUE SI NO ARROJARIA UN ERROR DE CONVERSIÓN DE CARACTER NULO AL SUMAR CON NÚMERO ENTERO.
              maxIdMaquinariaPesada=Long.valueOf(0);
           }
           maquinariaPesadaDTO.setIdMaquinariaPesada(maxIdMaquinariaPesada+1);//OBTENGO EL ID MAXIMO AUTOMATICO, SUMO (1) ENTERO PARA OBTENER EL NUEVO ID.
           
           maquinariaPesadaRepository.save(maquinariaPesadaDAO.maquinariaPesada(maquinariaPesadaDTO));
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CREADO_EXITO, true);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR ID:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarMaquinariaPesadaporId(Long idMaquinariaPesada) {
        Optional<MaquinariaPesada> maquinariaPesadaId = maquinariaPesadaRepository.findByIdMaquinariaPesada(Long.valueOf(idMaquinariaPesada));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (maquinariaPesadaId.isPresent()==true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO.setMaquinariaPesadaDTO(maquinariaPesadaDAO.maquinariaPesadaDTO(maquinariaPesadaId.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (maquinariaPesadaId.isPresent()==false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setMaquinariaPesadaDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR NOMBRE:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarMaquinariaPesadaporNombre(String nombreMaquinariaPesada) {
        Optional<MaquinariaPesada> maquinariaPesadaNombre = Optional.ofNullable(maquinariaPesadaRepository.findByNombreMaquinariaPesada(String.valueOf(nombreMaquinariaPesada)));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_NO_ENCONTRADO, false);
        
        if (maquinariaPesadaNombre.isPresent()==true) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL NOMBRE PROPORCIONADO.
           respuestaDTO.setMaquinariaPesadaDTO(maquinariaPesadaDAO.maquinariaPesadaDTO(maquinariaPesadaNombre.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (maquinariaPesadaNombre.isPresent()==false) {//SI NO ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON EL NOMBRE PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_NO_ENCONTRADO, false);
           respuestaDTO.setMaquinariaPesadaDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //MODIFICAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE MODIFICAR REGISTRO.
    public RespuestaDTO actualizarMaquinariaPesada(MaquinariaPesadaDTO maquinariaPesadaDTO) {
        Optional<MaquinariaPesada> maquinariaPesadaId = maquinariaPesadaRepository.findByIdMaquinariaPesada(maquinariaPesadaDTO.getIdMaquinariaPesada());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
        
        if (maquinariaPesadaId.isPresent()==true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE VERIFICA EL NOMBRE DEL REGISTRO CON EL ID PROPORCIONADO.
           if ( (maquinariaPesadaDTO.getNombreMaquinariaPesada().equals(maquinariaPesadaId.get().getNombreMaquinariaPesada())==true) ) {//SI EL NOMBRE DIGITADO ES IGUAL AL NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
              MaquinariaPesada maquinariaPesada = maquinariaPesadaDAO.maquinariaPesada(maquinariaPesadaDTO);
              maquinariaPesadaRepository.save(maquinariaPesada);
              respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
           }
           if (maquinariaPesadaDTO.getNombreMaquinariaPesada().equals(maquinariaPesadaId.get().getNombreMaquinariaPesada())==false) {//SI EL NOMBRE DIGITADO ES DIFERENTE AL NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS SE REALIZA BUSQUEDA PARA VERIFICAR SI ESTE NOMBRE DIGITADO EXISTE EN OTROS REGISTROS.
              //consulte por nombre e imprima si existe y si no existe
              MaquinariaPesada maquinariaPesadaNombre = maquinariaPesadaRepository.findByNombreMaquinariaPesada(maquinariaPesadaDTO.getNombreMaquinariaPesada().toUpperCase());
              
              //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
              long banderaNombreRegistroEncontrado=0;
              
              if (!(maquinariaPesadaNombre==null)) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
                 banderaNombreRegistroEncontrado=1;
              }
              
              if (banderaNombreRegistroEncontrado==1) {//SI LA BUSQUEDA OBTIENE QUE EL NOMBRE DIGITADO Y BUSCADO ES DIFERENTE DE NULO SIGNIFICA QUE ENCONTRO EL MISMO NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS Y MUESTRA UN MENSAJE DE NOMBRE DEL REGISTRO REPETIDO.
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_YA_EXISTE, false);
                 respuestaDTO.setMaquinariaPesadaDTO(null);
              }
              if (banderaNombreRegistroEncontrado==0) {//SI LA BUSQUEDA OBTIENE QUE EL NOMBRE DIGITADO Y BUSCADO ES NULO EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
                 MaquinariaPesada maquinariaPesada = maquinariaPesadaDAO.maquinariaPesada(maquinariaPesadaDTO);
                 maquinariaPesadaRepository.save(maquinariaPesada);
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
              }
           }
        }
        if (maquinariaPesadaId.isPresent()==false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MUESTRA UN MENSAJE DE REGISTRO NO MODIFICADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
           respuestaDTO.setMaquinariaPesadaDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //ELIMINAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE ELIMINAR REGISTRO.
    public RespuestaDTO eliminarMaquinariaPesada(Long idMaquinariaPesada) {
        Optional<MaquinariaPesada> maquinariaPesadaId  = maquinariaPesadaRepository.findById(idMaquinariaPesada);
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (maquinariaPesadaId .isPresent()==true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO.setMaquinariaPesadaDTO(maquinariaPesadaDAO.maquinariaPesadaDTO(maquinariaPesadaId.get()));
           maquinariaPesadaRepository.delete(maquinariaPesadaId.get());
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ELIMINADO_EXITO, true);
        }
        if (maquinariaPesadaId .isPresent()==false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS NO ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO NO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setMaquinariaPesadaDTO(null);
        }
        
        return respuestaDTO;
    }
}
