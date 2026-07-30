//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.serviceImpl;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.Constantes.MensajesConstantes;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.TipoDespejeMilitarArtefactoExplosivoDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service.TipoDespejeMilitarArtefactoExplosivoService;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao.TipoDespejeMilitarArtefactoExplosivoDAO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.TipoDespejeMilitarArtefactoExplosivo;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.TipoDespejeMilitarArtefactoExplosivoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
* * @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 01/12/2025.
* Esta es la declaración de la implementación del servicio.
* Se inyectan DAOS y repositorios.
*/
@Service//DECLARACIÓN DE LA IMPLEMENTACIÓN DEL SERVICIO.
//DECLARACIÓN DE LA CLASE DE LA IMPLEMENTACIÓN DEL SERVICIO:
public class TipoDespejeMilitarArtefactoExplosivoServiceImpl implements TipoDespejeMilitarArtefactoExplosivoService {
    
    @Autowired//INYECTAMOS EL DAO.
    private TipoDespejeMilitarArtefactoExplosivoDAO tipoDespejeMilitarArtefactoExplosivoDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private TipoDespejeMilitarArtefactoExplosivoRepository tipoDespejeMilitarArtefactoExplosivoRepository;
    
    //CONTAR REGISTROS FILTRADOS:
    @Override//SOBREESCRIBIMOS EL METODO DE CONTAR REGISTROS.
    public Long contarTotalRegistros(Long idTipoDespejeMilitarArtefactoExplosivo, String keyword) {
        return tipoDespejeMilitarArtefactoExplosivoRepository.findTotalRegistros(idTipoDespejeMilitarArtefactoExplosivo, keyword);
    }
    
    //LISTAR REGISTROS FILTRADOS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public List<TipoDespejeMilitarArtefactoExplosivoDTO> listarTiposDespejesMilitaresArtefactosExplosivos(Long idTipoDespejeMilitarArtefactoExplosivo, String keyword, String orderBy, String orderMode) {
        List<TipoDespejeMilitarArtefactoExplosivo> tiposDespejesArtefactosExplosivos = tipoDespejeMilitarArtefactoExplosivoRepository.findAllTiposDespejesMilitaresArtefactosExplosivos(idTipoDespejeMilitarArtefactoExplosivo, keyword, orderBy, orderMode);
        List<TipoDespejeMilitarArtefactoExplosivoDTO> tipoDespejeMilitarArtefactoExplosivoDTOS = new ArrayList<>();
        
        for (TipoDespejeMilitarArtefactoExplosivo tipoDespejeMilitarArtefactoExplosivo : tiposDespejesArtefactosExplosivos){
            tipoDespejeMilitarArtefactoExplosivoDTOS.add(tipoDespejeMilitarArtefactoExplosivoDAO.tipoDespejeMilitarArtefactoExplosivoDTO(tipoDespejeMilitarArtefactoExplosivo));
        }
        
        return tipoDespejeMilitarArtefactoExplosivoDTOS;
    }
    
    //LISTAR REGISTROS FILTRADOS PAGINADOS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS PAGINADOS.
    public Slice<TipoDespejeMilitarArtefactoExplosivoDTO> listarTiposDespejesMilitaresArtefactosExplosivosPag(Pageable pageable, Long idTipoDespejeMilitarArtefactoExplosivo, String keyword, String orderBy, String orderMode) {
        Slice<TipoDespejeMilitarArtefactoExplosivo> tiposDespejesArtefactosExplosivos = tipoDespejeMilitarArtefactoExplosivoRepository.findAllTiposDespejesMilitaresArtefactosExplosivosPag(pageable, idTipoDespejeMilitarArtefactoExplosivo, keyword, orderBy, orderMode);
        return tiposDespejesArtefactosExplosivos.map(tipoDespejeMilitarArtefactoExplosivo -> tipoDespejeMilitarArtefactoExplosivoDAO.tipoDespejeMilitarArtefactoExplosivoDTO(tipoDespejeMilitarArtefactoExplosivo));
    }
    
    //CREAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE CREAR REGISTRO.
    public RespuestaDTO crearTipoDespejeMilitarArtefactoExplosivo(TipoDespejeMilitarArtefactoExplosivoDTO tipoDespejeMilitarArtefactoExplosivoDTO) {
        Long maxIdTipoDespejeMilitarArtefactoExplosivo=null;
        TipoDespejeMilitarArtefactoExplosivo tipoDespejeMilitarArtefactoExplosivoNombre = tipoDespejeMilitarArtefactoExplosivoRepository.findByNombreTipoDespejeMilitarArtefactoExplosivo(tipoDespejeMilitarArtefactoExplosivoDTO.getNombreTipoDespejeMilitarArtefactoExplosivo().toUpperCase());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_CREADO, false);
        
        //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
        long banderaNombreRegistroEncontrado=0;
        
        if (!(tipoDespejeMilitarArtefactoExplosivoNombre==null)) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
           banderaNombreRegistroEncontrado=1;
        }
        
        //System.out.println("INGRESA METODO CREAR.");
        if (banderaNombreRegistroEncontrado==1) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_YA_EXISTE, false);
           respuestaDTO.setTipoDespejeMilitarArtefactoExplosivoDTO(null);
        }
        if ((banderaNombreRegistroEncontrado==0) ) {//SI NO ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS CREA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO CREADO EXITOSAMENTE CON EL NOMBRE PROPORCIONADO.
           maxIdTipoDespejeMilitarArtefactoExplosivo = tipoDespejeMilitarArtefactoExplosivoRepository.findMaxIdTipoDespejeMilitarArtefactoExplosivo();
           if (maxIdTipoDespejeMilitarArtefactoExplosivo==null) {//ESTO SE HACE EN CASO DE QUE SI LA TABLA DE LA BASE DE DATOS ESTA EN BLANCO Y VA SER EL PRIMER REGISTRO AL OBTENER UN VALOR NULO, SE ASIGNE CERO (0) AUTOMÁTICAMENTE PORQUE SI NO ARROJARIA UN ERROR DE CONVERSIÓN DE CARACTER NULO AL SUMAR CON NÚMERO ENTERO.
              maxIdTipoDespejeMilitarArtefactoExplosivo=Long.valueOf(0);
           }
           tipoDespejeMilitarArtefactoExplosivoDTO.setIdTipoDespejeMilitarArtefactoExplosivo(maxIdTipoDespejeMilitarArtefactoExplosivo+1);//OBTENGO EL ID MAXIMO AUTOMATICO, SUMO (1) ENTERO PARA OBTENER EL NUEVO ID.
           
           tipoDespejeMilitarArtefactoExplosivoRepository.save(tipoDespejeMilitarArtefactoExplosivoDAO.tipoDespejeMilitarArtefactoExplosivo(tipoDespejeMilitarArtefactoExplosivoDTO));
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CREADO_EXITO, true);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR ID:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarTipoDespejeMilitarArtefactoExplosivoporId(Long idTipoDespejeMilitarArtefactoExplosivo) {
        Optional<TipoDespejeMilitarArtefactoExplosivo> tipoDespejeMilitarArtefactoExplosivoId = tipoDespejeMilitarArtefactoExplosivoRepository.findByIdTipoDespejeMilitarArtefactoExplosivo(Long.valueOf(idTipoDespejeMilitarArtefactoExplosivo));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (tipoDespejeMilitarArtefactoExplosivoId.isPresent()==true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO.setTipoDespejeMilitarArtefactoExplosivoDTO(tipoDespejeMilitarArtefactoExplosivoDAO.tipoDespejeMilitarArtefactoExplosivoDTO(tipoDespejeMilitarArtefactoExplosivoId.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (tipoDespejeMilitarArtefactoExplosivoId.isPresent()==false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setTipoDespejeMilitarArtefactoExplosivoDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR NOMBRE:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarTipoDespejeMilitarArtefactoExplosivoporNombre(String nombreTipoDespejeMilitarArtefactoExplosivo) {
        Optional<TipoDespejeMilitarArtefactoExplosivo> tipoDespejeMilitarArtefactoExplosivoNombre = Optional.ofNullable(tipoDespejeMilitarArtefactoExplosivoRepository.findByNombreTipoDespejeMilitarArtefactoExplosivo(String.valueOf(nombreTipoDespejeMilitarArtefactoExplosivo)));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_NO_ENCONTRADO, false);
        
        if (tipoDespejeMilitarArtefactoExplosivoNombre.isPresent()==true) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL NOMBRE PROPORCIONADO.
           respuestaDTO.setTipoDespejeMilitarArtefactoExplosivoDTO(tipoDespejeMilitarArtefactoExplosivoDAO.tipoDespejeMilitarArtefactoExplosivoDTO(tipoDespejeMilitarArtefactoExplosivoNombre.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (tipoDespejeMilitarArtefactoExplosivoNombre.isPresent()==false) {//SI NO ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA NO EXITOSA CON EL NOMBRE PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_NO_ENCONTRADO, false);
           respuestaDTO.setTipoDespejeMilitarArtefactoExplosivoDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //MODIFICAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE MODIFICAR REGISTRO.
    public RespuestaDTO actualizarTipoDespejeMilitarArtefactoExplosivo(TipoDespejeMilitarArtefactoExplosivoDTO tipoDespejeMilitarArtefactoExplosivoDTO) {
        Optional<TipoDespejeMilitarArtefactoExplosivo> tipoDespejeMilitarArtefactoExplosivoId = tipoDespejeMilitarArtefactoExplosivoRepository.findByIdTipoDespejeMilitarArtefactoExplosivo(tipoDespejeMilitarArtefactoExplosivoDTO.getIdTipoDespejeMilitarArtefactoExplosivo());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
        
        if (tipoDespejeMilitarArtefactoExplosivoId.isPresent()==true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE VERIFICA EL NOMBRE DEL REGISTRO CON EL ID PROPORCIONADO.
           if ( (tipoDespejeMilitarArtefactoExplosivoDTO.getNombreTipoDespejeMilitarArtefactoExplosivo().equals(tipoDespejeMilitarArtefactoExplosivoId.get().getNombreTipoDespejeMilitarArtefactoExplosivo())==true) ) {//SI EL NOMBRE DIGITADO ES IGUAL AL NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
              TipoDespejeMilitarArtefactoExplosivo tipoDespejeMilitarArtefactoExplosivo = tipoDespejeMilitarArtefactoExplosivoDAO.tipoDespejeMilitarArtefactoExplosivo(tipoDespejeMilitarArtefactoExplosivoDTO);
              tipoDespejeMilitarArtefactoExplosivoRepository.save(tipoDespejeMilitarArtefactoExplosivo);
              respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
           }
           if (tipoDespejeMilitarArtefactoExplosivoDTO.getNombreTipoDespejeMilitarArtefactoExplosivo().equals(tipoDespejeMilitarArtefactoExplosivoId.get().getNombreTipoDespejeMilitarArtefactoExplosivo())==false) {//SI EL NOMBRE DIGITADO ES DIFERENTE AL NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS SE REALIZA BUSQUEDA PARA VERIFICAR SI ESTE NOMBRE DIGITADO EXISTE EN OTROS REGISTROS.
              //consulte por nombre e imprima si existe y si no existe
              TipoDespejeMilitarArtefactoExplosivo tipoDespejeMilitarArtefactoExplosivoNombre = tipoDespejeMilitarArtefactoExplosivoRepository.findByNombreTipoDespejeMilitarArtefactoExplosivo(tipoDespejeMilitarArtefactoExplosivoDTO.getNombreTipoDespejeMilitarArtefactoExplosivo().toUpperCase());
              
              //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
              long banderaNombreRegistroEncontrado=0;
              
              if (!(tipoDespejeMilitarArtefactoExplosivoNombre==null)) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
                 banderaNombreRegistroEncontrado=1;
              }
              
              if (banderaNombreRegistroEncontrado==1) {//SI LA BUSQUEDA OBTIENE QUE EL NOMBRE DIGITADO Y BUSCADO ES DIFERENTE DE NULO SIGNIFICA QUE ENCONTRO EL MISMO NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS Y MUESTRA UN MENSAJE DE NOMBRE DEL REGISTRO REPETIDO.
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_YA_EXISTE, false);
                 respuestaDTO.setTipoDespejeMilitarArtefactoExplosivoDTO(null);
              }
              if (banderaNombreRegistroEncontrado==0) {//SI LA BUSQUEDA OBTIENE QUE EL NOMBRE DIGITADO Y BUSCADO ES NULO EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
                 TipoDespejeMilitarArtefactoExplosivo tipoDespejeMilitarArtefactoExplosivo = tipoDespejeMilitarArtefactoExplosivoDAO.tipoDespejeMilitarArtefactoExplosivo(tipoDespejeMilitarArtefactoExplosivoDTO);
                 tipoDespejeMilitarArtefactoExplosivoRepository.save(tipoDespejeMilitarArtefactoExplosivo);
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
              }
           }
        }
        if (tipoDespejeMilitarArtefactoExplosivoId.isPresent()==false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MUESTRA UN MENSAJE DE REGISTRO NO MODIFICADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
           respuestaDTO.setTipoDespejeMilitarArtefactoExplosivoDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //ELIMINAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE ELIMINAR REGISTRO.
    public RespuestaDTO eliminarTipoDespejeMilitarArtefactoExplosivo(Long idTipoDespejeMilitarArtefactoExplosivo) {
        Optional<TipoDespejeMilitarArtefactoExplosivo> tipoDespejeMilitarArtefactoExplosivoId  = tipoDespejeMilitarArtefactoExplosivoRepository.findById(idTipoDespejeMilitarArtefactoExplosivo);
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (tipoDespejeMilitarArtefactoExplosivoId .isPresent()==true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO.setTipoDespejeMilitarArtefactoExplosivoDTO(tipoDespejeMilitarArtefactoExplosivoDAO.tipoDespejeMilitarArtefactoExplosivoDTO(tipoDespejeMilitarArtefactoExplosivoId.get()));
           tipoDespejeMilitarArtefactoExplosivoRepository.delete(tipoDespejeMilitarArtefactoExplosivoId.get());
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ELIMINADO_EXITO, true);
        }
        if (tipoDespejeMilitarArtefactoExplosivoId .isPresent()==false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS NO ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO NO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setTipoDespejeMilitarArtefactoExplosivoDTO(null);
        }
        
        return respuestaDTO;
    }
}
