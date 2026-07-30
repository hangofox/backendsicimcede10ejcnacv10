//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.serviceImpl;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.Constantes.MensajesConstantes;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.CompaniaUnidadMilitarDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service.CompaniaUnidadMilitarService;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao.CompaniaUnidadMilitarDAO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.CompaniaUnidadMilitar;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.CompaniaUnidadMilitarRepository;
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
public class CompaniaUnidadMilitarServiceImpl implements CompaniaUnidadMilitarService {
    
    @Autowired//INYECTAMOS EL DAO.
    private CompaniaUnidadMilitarDAO companiaUnidadMilitarDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private CompaniaUnidadMilitarRepository companiaUnidadMilitarRepository;
    
    //CONTAR TOTAL DE REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE CONTEO.
    public Long contarTotalRegistros(Long idCompaniaUnidadMilitar, String keyword, String siglaoAcronimoUnidadMilitar) {
        return companiaUnidadMilitarRepository.findTotalRegistros(idCompaniaUnidadMilitar, keyword, siglaoAcronimoUnidadMilitar);
    }
    
    //LISTAR REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public List<CompaniaUnidadMilitarDTO> listarCompaniasUnidadesMilitares(Long idCompaniaUnidadMilitar, String keyword, String siglaoAcronimoUnidadMilitar, String orderBy, String orderMode) {
        List<CompaniaUnidadMilitar> companiasUnidadesMilitares = companiaUnidadMilitarRepository.findAllCompaniasUnidadesMilitares(idCompaniaUnidadMilitar, keyword, siglaoAcronimoUnidadMilitar, orderBy, orderMode);
        List<CompaniaUnidadMilitarDTO> companiaUnidadMilitarDTOS = new ArrayList<>();
        for (CompaniaUnidadMilitar companiaUnidadMilitar : companiasUnidadesMilitares) {
            companiaUnidadMilitarDTOS.add(companiaUnidadMilitarDAO.companiaUnidadMilitarDTO(companiaUnidadMilitar));
        }
        
        return companiaUnidadMilitarDTOS;
    }
    
    //LISTAR REGISTROS PAGINADOS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS PAGINADOS.
    public Slice<CompaniaUnidadMilitarDTO> listarCompaniasUnidadesMilitaresPag(Pageable pageable, Long idCompaniaUnidadMilitar, String keyword, String siglaoAcronimoUnidadMilitar, String orderBy, String orderMode) {
        Slice<CompaniaUnidadMilitar> companiasUnidadesMilitares = companiaUnidadMilitarRepository.findAllCompaniasUnidadesMilitaresPag(pageable, idCompaniaUnidadMilitar, keyword, siglaoAcronimoUnidadMilitar, orderBy, orderMode);
        return companiasUnidadesMilitares.map(companiaUnidadMilitar -> companiaUnidadMilitarDAO.companiaUnidadMilitarDTO(companiaUnidadMilitar));
    }
    
    //CREAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE CREAR REGISTRO.
    public RespuestaDTO crearCompaniaUnidadMilitar(CompaniaUnidadMilitarDTO companiaUnidadMilitarDTO) {
        Long maxIdCompaniaUnidadMilitar = null;
        CompaniaUnidadMilitar companiaUnidadMilitarNombreySAUnidadMilitar = companiaUnidadMilitarRepository.findByNombreCompaniaUnidadMilitarAndSAUnidadMilitar(companiaUnidadMilitarDTO.getNombreCompaniaUnidadMilitar().toUpperCase(), companiaUnidadMilitarDTO.getUnidadMilitarDTO().getSiglaoAcronimoUnidadMilitar());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_CREADO, false);
        
        //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
        long banderaNombreRegistroEncontrado = 0;
        
        if (!(companiaUnidadMilitarNombreySAUnidadMilitar == null)) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS Y ASOCIADO A UN MISMO REGISTRO RELACIONAL MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
           banderaNombreRegistroEncontrado = 1;
        }
        
        if (banderaNombreRegistroEncontrado == 1) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS Y ASOCIADO A UN MISMO REGISTRO RELACIONAL MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_EN_UNIDAD_MILITAR_YA_EXISTE, false);
           respuestaDTO.setCompaniaUnidadMilitarDTO(null);
        }
        if (banderaNombreRegistroEncontrado == 0) {//SI NO ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS Y ASOCIADO A UN MISMO REGISTRO RELACIONAL CREA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO CREADO EXITOSAMENTE.
           maxIdCompaniaUnidadMilitar = companiaUnidadMilitarRepository.findMaxIdCompaniaUnidadMilitar();
           if (maxIdCompaniaUnidadMilitar == null) {//ESTO SE HACE EN CASO DE QUE SI LA TABLA DE LA BASE DE DATOS ESTA EN BLANCO Y VA SER EL PRIMER REGISTRO AL OBTENER UN VALOR NULO, SE ASIGNE CERO (0) AUTOMÁTICAMENTE.
              maxIdCompaniaUnidadMilitar = Long.valueOf(0);
           }
           companiaUnidadMilitarDTO.setIdCompaniaUnidadMilitar(maxIdCompaniaUnidadMilitar + 1);//OBTENGO EL ID MAXIMO AUTOMATICO, SUMO (1) ENTERO PARA OBTENER EL NUEVO ID.
           companiaUnidadMilitarRepository.save(companiaUnidadMilitarDAO.companiaUnidadMilitar(companiaUnidadMilitarDTO));
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CREADO_EXITO, true);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR ID:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarCompaniaUnidadMilitarporId(Long idCompaniaUnidadMilitar) {
        Optional<CompaniaUnidadMilitar> companiaUnidadMilitarId = companiaUnidadMilitarRepository.findByIdCompaniaUnidadMilitar(Long.valueOf(idCompaniaUnidadMilitar));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (companiaUnidadMilitarId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO.setCompaniaUnidadMilitarDTO(companiaUnidadMilitarDAO.companiaUnidadMilitarDTO(companiaUnidadMilitarId.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (companiaUnidadMilitarId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE CONSULTA NO EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setCompaniaUnidadMilitarDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR NOMBRE Y SIGLA O ACRÓNIMO DE UNIDAD MILITAR:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarCompaniaUnidadMilitarporNombreySAUnidadMilitar(String nombreCompaniaUnidadMilitar, String siglaoAcronimoUnidadMilitar) {
        Optional<CompaniaUnidadMilitar> companiaUnidadMilitarNombre = Optional.ofNullable(companiaUnidadMilitarRepository.findByNombreCompaniaUnidadMilitarAndSAUnidadMilitar(String.valueOf(nombreCompaniaUnidadMilitar), String.valueOf(siglaoAcronimoUnidadMilitar)));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_NO_ENCONTRADO, false);
        
        if (companiaUnidadMilitarNombre.isPresent() == true) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL NOMBRE PROPORCIONADO.
           respuestaDTO.setCompaniaUnidadMilitarDTO(companiaUnidadMilitarDAO.companiaUnidadMilitarDTO(companiaUnidadMilitarNombre.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (companiaUnidadMilitarNombre.isPresent() == false) {//SI NO ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE CONSULTA NO EXITOSA CON EL NOMBRE PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_NO_ENCONTRADO, false);
           respuestaDTO.setCompaniaUnidadMilitarDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //MODIFICAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE MODIFICAR REGISTRO.
    public RespuestaDTO actualizarCompaniaUnidadMilitar(CompaniaUnidadMilitarDTO companiaUnidadMilitarDTO) {
        Optional<CompaniaUnidadMilitar> companiaUnidadMilitarId = companiaUnidadMilitarRepository.findByIdCompaniaUnidadMilitar(companiaUnidadMilitarDTO.getIdCompaniaUnidadMilitar());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
        
        if (companiaUnidadMilitarId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE VERIFICA EL NOMBRE DEL REGISTRO CON EL ID PROPORCIONADO.
           if (companiaUnidadMilitarDTO.getNombreCompaniaUnidadMilitar().equals(companiaUnidadMilitarId.get().getNombreCompaniaUnidadMilitar()) == true) {//SI EL NOMBRE DIGITADO ES IGUAL AL NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
              companiaUnidadMilitarRepository.save(companiaUnidadMilitarDAO.companiaUnidadMilitar(companiaUnidadMilitarDTO));
              respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
           }
           if (companiaUnidadMilitarDTO.getNombreCompaniaUnidadMilitar().equals(companiaUnidadMilitarId.get().getNombreCompaniaUnidadMilitar()) == false) {//SI EL NOMBRE DIGITADO ES DIFERENTE AL NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS SE REALIZA BUSQUEDA PARA VERIFICAR SI ESTE NOMBRE DIGITADO EXISTE EN OTROS REGISTROS Y ASOCIADOS A UN MISMO REGISTRO RELACIONAL.
              CompaniaUnidadMilitar companiaUnidadMilitarNombreySAUnidadMilitar = companiaUnidadMilitarRepository.findByNombreCompaniaUnidadMilitarAndSAUnidadMilitar(companiaUnidadMilitarDTO.getNombreCompaniaUnidadMilitar().toUpperCase(), companiaUnidadMilitarDTO.getUnidadMilitarDTO().getSiglaoAcronimoUnidadMilitar());
              
              //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
              long banderaNombreRegistroEncontrado = 0;
              
              if (!(companiaUnidadMilitarNombreySAUnidadMilitar == null)) {//SI ENCONTRO EL NOMBRE DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS Y ASOCIADO A UN MISMO REGISTRO RELACIONAL MUESTRA UN MENSAJE DE NOMBRE DE REGISTRO REPETIDO CON EL NOMBRE PROPORCIONADO.
                 banderaNombreRegistroEncontrado = 1;
              }
              
              if (banderaNombreRegistroEncontrado == 1) {//SI LA BUSQUEDA OBTIENE QUE EL NOMBRE DIGITADO ES DIFERENTE DE NULO SIGNIFICA QUE ENCONTRO EL MISMO NOMBRE ALMACENADO EN LA TABLA DE LA BASE DE DATOS Y ASOCIADO A UN MISMO REGISTRO RELACIONAL Y MUESTRA UN MENSAJE DE NOMBRE DEL REGISTRO REPETIDO.
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_EN_UNIDAD_MILITAR_YA_EXISTE, false);
                 respuestaDTO.setCompaniaUnidadMilitarDTO(null);
              }
              if (banderaNombreRegistroEncontrado == 0) {//SI LA BUSQUEDA OBTIENE QUE EL NOMBRE DIGITADO ES NULO EN LA TABLA DE LA BASE DE DATOS Y ASOCIADO A UN MISMO REGISTRO RELACIONAL SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
                 companiaUnidadMilitarRepository.save(companiaUnidadMilitarDAO.companiaUnidadMilitar(companiaUnidadMilitarDTO));
                 respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
              }
           }
        }
        if (companiaUnidadMilitarId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MUESTRA UN MENSAJE DE REGISTRO NO MODIFICADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
           respuestaDTO.setCompaniaUnidadMilitarDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //ELIMINAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE ELIMINAR REGISTRO.
    public RespuestaDTO eliminarCompaniaUnidadMilitar(Long idCompaniaUnidadMilitar) {
        Optional<CompaniaUnidadMilitar> companiaUnidadMilitarId = companiaUnidadMilitarRepository.findById(idCompaniaUnidadMilitar);
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (companiaUnidadMilitarId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO.setCompaniaUnidadMilitarDTO(companiaUnidadMilitarDAO.companiaUnidadMilitarDTO(companiaUnidadMilitarId.get()));
           companiaUnidadMilitarRepository.delete(companiaUnidadMilitarId.get());
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ELIMINADO_EXITO, true);
        }
        if (companiaUnidadMilitarId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS NO ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO NO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setCompaniaUnidadMilitarDTO(null);
        }
        
        return respuestaDTO;
    }
}
