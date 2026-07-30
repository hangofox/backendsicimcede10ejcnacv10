//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.serviceImpl;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.Constantes.MensajesConstantes;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.MunicionEspecialDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service.MunicionEspecialService;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao.MunicionEspecialDAO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.MunicionEspecial;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.MunicionEspecialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 24/03/2026.
* Esta es la declaración de la implementación del servicio.
* Se inyectan DAOS y repositorios.
*/
@Service//DECLARACIÓN DE LA IMPLEMENTACIÓN DEL SERVICIO.
//DECLARACIÓN DE LA CLASE DE LA IMPLEMENTACIÓN DEL SERVICIO:
public class MunicionEspecialServiceImpl implements MunicionEspecialService {
    
    @Autowired//INYECTAMOS EL DAO.
    private MunicionEspecialDAO municionEspecialDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private MunicionEspecialRepository municionEspecialRepository;
    
    //CONTAR TOTAL DE REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE CONTEO.
    public Long contarTotalRegistros(Long idMunicionEspecial, String keyword, String nombrePelotonUnidadMilitar, String nombreTipoDespejeMilitarArtefactoExplosivo) {
        return municionEspecialRepository.findTotalRegistros(idMunicionEspecial, keyword, nombrePelotonUnidadMilitar, nombreTipoDespejeMilitarArtefactoExplosivo);
    }
    
    //LISTAR REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public List<MunicionEspecialDTO> listarMunicionesEspeciales(Long idMunicionEspecial, String keyword, String nombrePelotonUnidadMilitar, String nombreTipoDespejeMilitarArtefactoExplosivo, String orderBy, String orderMode) {
        List<MunicionEspecial> municionesEspeciales = municionEspecialRepository.findAllMunicionesEspeciales(idMunicionEspecial, keyword, nombrePelotonUnidadMilitar, nombreTipoDespejeMilitarArtefactoExplosivo, orderBy, orderMode);
        List<MunicionEspecialDTO> municionEspecialDTOS = new ArrayList<>();
        for (MunicionEspecial municionEspecial : municionesEspeciales) {
            municionEspecialDTOS.add(municionEspecialDAO.municionEspecialDTO(municionEspecial));
        }
        
        return municionEspecialDTOS;
    }
    
    //LISTAR REGISTROS PAGINADOS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS PAGINADOS.
    public Slice<MunicionEspecialDTO> listarMunicionesEspecialesPag(Pageable pageable, Long idMunicionEspecial, String keyword, String nombrePelotonUnidadMilitar, String nombreTipoDespejeMilitarArtefactoExplosivo, String orderBy, String orderMode) {
        Slice<MunicionEspecial> municionesEspeciales = municionEspecialRepository.findAllMunicionesEspecialesPag(pageable, idMunicionEspecial, keyword, nombrePelotonUnidadMilitar, nombreTipoDespejeMilitarArtefactoExplosivo, orderBy, orderMode);
        return municionesEspeciales.map(municionEspecial -> municionEspecialDAO.municionEspecialDTO(municionEspecial));
    }
    
    //CREAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE CREAR REGISTRO.
    public RespuestaDTO crearMunicionEspecial(MunicionEspecialDTO municionEspecialDTO) {
        Long maxIdMunicionEspecial = null;
        MunicionEspecial municionEspecialNombreYPeloton = municionEspecialRepository.findByNombrePelotonUnidadMilitarAndNombreMunicionEspecial(municionEspecialDTO.getPelotonUnidadMilitarDTO().getNombrePelotonUnidadMilitar(), municionEspecialDTO.getNombreMunicionEspecial().toUpperCase());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_CREADO, false);
        
        //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
        long banderaNombreRegistroEncontrado = 0;
        
        if (!(municionEspecialNombreYPeloton == null)) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS Y ASOCIADO A UN MISMO PELOTÓN DE UNIDAD MILITAR MUESTRA UN MENSAJE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
           banderaNombreRegistroEncontrado = 1;
        }
        
        if (banderaNombreRegistroEncontrado == 1) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS Y ASOCIADO A UN MISMO PELOTÓN DE UNIDAD MILITAR MUESTRA UN MENSAJE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_EN_PELOTON_UNIDAD_MILITAR_YA_EXISTE, false);
           respuestaDTO.setMunicionEspecialDTO(null);
        }
        if (banderaNombreRegistroEncontrado == 0) {//SI NO ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS Y ASOCIADO A UN MISMO PELOTÓN DE UNIDAD MILITAR CREA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO CREADO EXITOSAMENTE.
           maxIdMunicionEspecial = municionEspecialRepository.findMaxIdMunicionEspecial();
           if (maxIdMunicionEspecial == null) {//ESTO SE HACE EN CASO DE QUE SI LA TABLA DE LA BASE DE DATOS ESTA EN BLANCO Y VA SER EL PRIMER REGISTRO AL OBTENER UN VALOR NULO, SE ASIGNE CERO (0) AUTOMÁTICAMENTE.
              maxIdMunicionEspecial = Long.valueOf(0);
           }
           municionEspecialDTO.setIdMunicionEspecial(maxIdMunicionEspecial + 1);//OBTENGO EL ID MAXIMO AUTOMATICO, SUMO (1) ENTERO PARA OBTENER EL NUEVO ID.
           municionEspecialRepository.save(municionEspecialDAO.municionEspecial(municionEspecialDTO));
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CREADO_EXITO, true);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR ID:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarMunicionEspecialporId(Long idMunicionEspecial) {
        Optional<MunicionEspecial> municionEspecialId = municionEspecialRepository.findByIdMunicionEspecial(Long.valueOf(idMunicionEspecial));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (municionEspecialId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO.setMunicionEspecialDTO(municionEspecialDAO.municionEspecialDTO(municionEspecialId.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (municionEspecialId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE CONSULTA NO EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setMunicionEspecialDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR NOMBRE Y LOTE:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarMunicionEspecialporNombreYLote(String nombreMunicionEspecial, String loteMunicionEspecial) {
        Optional<MunicionEspecial> municionEspecialNombre = Optional.ofNullable(municionEspecialRepository.findByNombreMunicionEspecialAndLoteMunicionEspecial(String.valueOf(nombreMunicionEspecial), String.valueOf(loteMunicionEspecial)));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_NO_ENCONTRADO, false);
        
        if (municionEspecialNombre.isPresent() == true) {//SI ENCONTRO EL NOMBRE Y LOTE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL NOMBRE Y LOTE PROPORCIONADOS.
           respuestaDTO.setMunicionEspecialDTO(municionEspecialDAO.municionEspecialDTO(municionEspecialNombre.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (municionEspecialNombre.isPresent() == false) {//SI NO ENCONTRO EL NOMBRE Y LOTE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE CONSULTA NO EXITOSA CON EL NOMBRE Y LOTE PROPORCIONADOS.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_NO_ENCONTRADO, false);
           respuestaDTO.setMunicionEspecialDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //MODIFICAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE MODIFICAR REGISTRO.
    public RespuestaDTO actualizarMunicionEspecial(MunicionEspecialDTO municionEspecialDTO) {
        Optional<MunicionEspecial> municionEspecialId = municionEspecialRepository.findByIdMunicionEspecial(municionEspecialDTO.getIdMunicionEspecial());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
        
        if (municionEspecialId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE VERIFICA EL NOMBRE DEL REGISTRO CON EL ID PROPORCIONADO.
           if (municionEspecialDTO.getNombreMunicionEspecial().equals(municionEspecialId.get().getNombreMunicionEspecial()) == true) {//SI EL NOMBRE DIGITADO ES IGUAL AL NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
              municionEspecialRepository.save(municionEspecialDAO.municionEspecial(municionEspecialDTO));
              respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
           }
           if (municionEspecialDTO.getNombreMunicionEspecial().equals(municionEspecialId.get().getNombreMunicionEspecial()) == false) {//SI EL NOMBRE DIGITADO ES DIFERENTE AL NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS SE REALIZA BUSQUEDA PARA VERIFICAR SI ESTE NOMBRE DIGITADO EXISTE EN OTROS REGISTROS Y ASOCIADOS A UN MISMO PELOTÓN DE UNIDAD MILITAR.
              MunicionEspecial municionEspecialNombreYPeloton = municionEspecialRepository.findByNombrePelotonUnidadMilitarAndNombreMunicionEspecial(municionEspecialDTO.getPelotonUnidadMilitarDTO().getNombrePelotonUnidadMilitar(), municionEspecialDTO.getNombreMunicionEspecial().toUpperCase());
              
              //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
              long banderaNombreRegistroEncontrado = 0;
              
              if (!(municionEspecialNombreYPeloton == null)) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS Y ASOCIADO A UN MISMO PELOTÓN DE UNIDAD MILITAR MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
                 banderaNombreRegistroEncontrado = 1;
              }
              
              if (banderaNombreRegistroEncontrado == 1) {//SI LA BUSQUEDA OBTIENE QUE EL NOMBRE DIGITADO ES DIFERENTE DE NULO SIGNIFICA QUE ENCONTRO EL MISMO NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS Y ASOCIADO A UN MISMO PELOTÓN DE UNIDAD MILITAR Y MUESTRA UN MENSAJE DE NOMBRE DEL REGISTRO REPETIDO.
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_EN_PELOTON_UNIDAD_MILITAR_YA_EXISTE, false);
                 respuestaDTO.setMunicionEspecialDTO(null);
              }
              if (banderaNombreRegistroEncontrado == 0) {//SI LA BUSQUEDA OBTIENE QUE EL NOMBRE DIGITADO ES NULO EN LA TABLA DE LA BASE DE DATOS Y ASOCIADO A UN MISMO PELOTÓN DE UNIDAD MILITAR SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
                 municionEspecialRepository.save(municionEspecialDAO.municionEspecial(municionEspecialDTO));
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
              }
           }
        }
        if (municionEspecialId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MUESTRA UN MENSAJE DE REGISTRO NO MODIFICADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
           respuestaDTO.setMunicionEspecialDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //ELIMINAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE ELIMINAR REGISTRO.
    public RespuestaDTO eliminarMunicionEspecial(Long idMunicionEspecial) {
        Optional<MunicionEspecial> municionEspecialId = municionEspecialRepository.findById(idMunicionEspecial);
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (municionEspecialId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO.setMunicionEspecialDTO(municionEspecialDAO.municionEspecialDTO(municionEspecialId.get()));
           municionEspecialRepository.delete(municionEspecialId.get());
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ELIMINADO_EXITO, true);
        }
        if (municionEspecialId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS NO ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO NO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setMunicionEspecialDTO(null);
        }
        
        return respuestaDTO;
    }
}
