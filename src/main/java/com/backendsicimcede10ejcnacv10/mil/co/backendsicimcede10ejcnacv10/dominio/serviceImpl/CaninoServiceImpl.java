//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.serviceImpl;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.Constantes.MensajesConstantes;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.CaninoDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service.CaninoService;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao.CaninoDAO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.Canino;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.CaninoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 20/03/2026.
* Esta es la declaración de la implementación del servicio.
* Se inyectan DAOS y repositorios.
*/
@Service//DECLARACIÓN DE LA IMPLEMENTACIÓN DEL SERVICIO.
//DECLARACIÓN DE LA CLASE DE LA IMPLEMENTACIÓN DEL SERVICIO:
public class CaninoServiceImpl implements CaninoService {
    
    @Autowired//INYECTAMOS EL DAO.
    private CaninoDAO caninoDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private CaninoRepository caninoRepository;
    
    //CONTAR TOTAL DE REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE CONTEO.
    public Long contarTotalRegistros(Long idCanino, String keyword, String nombreCompaniaUnidadMilitar, String nombreTipoDespejeMilitarArtefactoExplosivo) {
        return caninoRepository.findTotalRegistros(idCanino, keyword, nombreCompaniaUnidadMilitar, nombreTipoDespejeMilitarArtefactoExplosivo);
    }
    
    //LISTAR REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public List<CaninoDTO> listarCaninos(Long idCanino, String keyword, String nombreCompaniaUnidadMilitar, String nombreTipoDespejeMilitarArtefactoExplosivo, String orderBy, String orderMode) {
        List<Canino> caninos = caninoRepository.findAllCaninos(idCanino, keyword, nombreCompaniaUnidadMilitar, nombreTipoDespejeMilitarArtefactoExplosivo, orderBy, orderMode);
        List<CaninoDTO> caninoDTOS = new ArrayList<>();
        for (Canino canino : caninos) {
            caninoDTOS.add(caninoDAO.caninoDTO(canino));
        }
        
        return caninoDTOS;
    }
    
    //LISTAR REGISTROS PAGINADOS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS PAGINADOS.
    public Slice<CaninoDTO> listarCaninosPag(Pageable pageable, Long idCanino, String keyword, String nombreCompaniaUnidadMilitar, String nombreTipoDespejeMilitarArtefactoExplosivo, String orderBy, String orderMode) {
        Slice<Canino> caninos = caninoRepository.findAllCaninosPag(pageable, idCanino, keyword, nombreCompaniaUnidadMilitar, nombreTipoDespejeMilitarArtefactoExplosivo, orderBy, orderMode);
        return caninos.map(canino -> caninoDAO.caninoDTO(canino));
    }
    
    //CREAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE CREAR REGISTRO.
    public RespuestaDTO crearCanino(CaninoDTO caninoDTO) {
        Long maxIdCanino = null;
        List<Canino> caninosUnicos = caninoRepository.findByNumeroChipCaninoOrNumeroInventarioCaninoOrNumeroActivoFijoCanino(caninoDTO.getNumeroChipCanino(), caninoDTO.getNumeroInventarioCanino(), caninoDTO.getNumeroActivoFijoCanino());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_CREADO, false);
        
        //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
        long banderaRegistroEncontrado = 0;
        
        if (!(caninosUnicos.isEmpty())) {//SI ENCONTRO EL NUMERO CHIP, NUMERO INVENTARIO O NUMERO ACTIVO FIJO DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE REGISTRO REPETIDO CON LOS DATOS PROPORCIONADOS.
           banderaRegistroEncontrado = 1;
        }
        
        if (banderaRegistroEncontrado == 1) {//SI ENCONTRO EL NUMERO CHIP, NUMERO INVENTARIO O NUMERO ACTIVO FIJO DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE REGISTRO REPETIDO CON LOS DATOS PROPORCIONADOS.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NUMERO_CHIP_O_NUMERO_INVENTARIO_O_ACTIVO_FIJO_YA_EXISTE, false);
           respuestaDTO.setCaninoDTO(null);
        }
        if (banderaRegistroEncontrado == 0) {//SI NO ENCONTRO EL NUMERO CHIP, NUMERO INVENTARIO O NUMERO ACTIVO FIJO DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS CREA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO CREADO EXITOSAMENTE.
           maxIdCanino = caninoRepository.findMaxIdCanino();
           if (maxIdCanino == null) {//ESTO SE HACE EN CASO DE QUE SI LA TABLA DE LA BASE DE DATOS ESTA EN BLANCO Y VA SER EL PRIMER REGISTRO AL OBTENER UN VALOR NULO, SE ASIGNE CERO (0) AUTOMÁTICAMENTE.
              maxIdCanino = Long.valueOf(0);
           }
           caninoDTO.setIdCanino(maxIdCanino + 1);//OBTENGO EL ID MAXIMO AUTOMATICO, SUMO (1) ENTERO PARA OBTENER EL NUEVO ID.
           caninoRepository.save(caninoDAO.canino(caninoDTO));
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CREADO_EXITO, true);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR ID:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarCaninoporId(Long idCanino) {
        Optional<Canino> caninoId = caninoRepository.findByIdCanino(Long.valueOf(idCanino));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (caninoId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO.setCaninoDTO(caninoDAO.caninoDTO(caninoId.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (caninoId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE CONSULTA NO EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setCaninoDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR NUMERO CHIP, NUMERO INVENTARIO Y NUMERO ACTIVO FIJO (CAMPOS ÚNICOS COMBINADOS):
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarCaninoporNumeroChipNumeroInventarioNumeroActivoFijo(String numeroChipCanino, String numeroInventarioCanino, String numeroActivoFijoCanino) {
        if (numeroChipCanino == null && numeroInventarioCanino == null && numeroActivoFijoCanino == null) {//SI TODOS LOS PARAMETROS SON NULOS NO SE REALIZA LA BUSQUEDA Y SE RETORNA UN MENSAJE DE REGISTRO NO ENCONTRADO.
           RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NUMERO_CHIP_NUMERO_INVENTARIO_NUMERO_ACTIVO_FIJO_NO_ENCONTRADOS, false);
           respuestaDTO.setCaninoDTO(null);
           return respuestaDTO;
        }
        List<Canino> caninosUnicos = caninoRepository.findByNumeroChipCaninoOrNumeroInventarioCaninoOrNumeroActivoFijoCanino(numeroChipCanino, numeroInventarioCanino, numeroActivoFijoCanino);
        Optional<Canino> caninoUnico = caninosUnicos.isEmpty() ? Optional.empty() : Optional.of(caninosUnicos.get(0));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NUMERO_CHIP_NUMERO_INVENTARIO_NUMERO_ACTIVO_FIJO_NO_ENCONTRADOS, false);
        
        if (caninoUnico.isPresent() == true) {//SI ENCONTRO EL REGISTRO CON LOS CAMPOS ÚNICOS PROPORCIONADOS EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA.
           respuestaDTO.setCaninoDTO(caninoDAO.caninoDTO(caninoUnico.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (caninoUnico.isPresent() == false) {//SI NO ENCONTRO EL REGISTRO CON LOS CAMPOS ÚNICOS PROPORCIONADOS EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE CONSULTA NO EXITOSA.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NUMERO_CHIP_NUMERO_INVENTARIO_NUMERO_ACTIVO_FIJO_NO_ENCONTRADOS, false);
           respuestaDTO.setCaninoDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //MODIFICAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE MODIFICAR REGISTRO.
    public RespuestaDTO actualizarCanino(CaninoDTO caninoDTO) {
        Optional<Canino> caninoId = caninoRepository.findByIdCanino(caninoDTO.getIdCanino());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
        
        if (caninoId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE VERIFICA LA UNICIDAD DE LOS CAMPOS ÚNICOS DEL REGISTRO CON EL ID PROPORCIONADO.
           List<Canino> caninosUnicos = caninoRepository.findByNumeroChipCaninoOrNumeroInventarioCaninoOrNumeroActivoFijoCanino(caninoDTO.getNumeroChipCanino(), caninoDTO.getNumeroInventarioCanino(), caninoDTO.getNumeroActivoFijoCanino());
           
           //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
           long banderaRegistroEncontrado = 0;
           
           for (Canino caninoUnico : caninosUnicos) {//SE RECORRE LA LISTA PORQUE EL REGISTRO ACTUAL PUEDE COINCIDIR CONSIGO MISMO EN UN CAMPO, POR LO QUE SE DEBE DESCARTAR Y SOLO VALIDAR CONTRA REGISTROS DE ID DIFERENTE.
              if (!(caninoUnico.getIdCanino().equals(caninoDTO.getIdCanino()))) {//SI ENCONTRO UN REGISTRO DIFERENTE AL ACTUAL CON EL MISMO NUMERO CHIP, NUMERO INVENTARIO O NUMERO ACTIVO FIJO MUESTRA UN MENSAJE DE DATOS ÚNICOS REPETIDOS.
                 banderaRegistroEncontrado = 1;
                 break;
              }
           }
           
           if (banderaRegistroEncontrado == 1) {//SI LA BUSQUEDA ENCONTRO UN REGISTRO CON LOS MISMOS CAMPOS ÚNICOS ASOCIADOS A UN ID DIFERENTE MUESTRA UN MENSAJE DE DATOS ÚNICOS REPETIDOS.
              respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NUMERO_CHIP_O_NUMERO_INVENTARIO_O_ACTIVO_FIJO_YA_EXISTE, false);
              respuestaDTO.setCaninoDTO(null);
           }
           if (banderaRegistroEncontrado == 0) {//SI NO ENCONTRO UN REGISTRO DIFERENTE AL ACTUAL CON LOS MISMOS CAMPOS ÚNICOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
              caninoRepository.save(caninoDAO.canino(caninoDTO));
              respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
           }
        }
        if (caninoId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MUESTRA UN MENSAJE DE REGISTRO NO MODIFICADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
           respuestaDTO.setCaninoDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //ELIMINAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE ELIMINAR REGISTRO.
    public RespuestaDTO eliminarCanino(Long idCanino) {
        Optional<Canino> caninoId = caninoRepository.findById(idCanino);
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (caninoId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO.setCaninoDTO(caninoDAO.caninoDTO(caninoId.get()));
           caninoRepository.delete(caninoId.get());
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ELIMINADO_EXITO, true);
        }
        if (caninoId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS NO ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO NO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setCaninoDTO(null);
        }
        
        return respuestaDTO;
    }
}
