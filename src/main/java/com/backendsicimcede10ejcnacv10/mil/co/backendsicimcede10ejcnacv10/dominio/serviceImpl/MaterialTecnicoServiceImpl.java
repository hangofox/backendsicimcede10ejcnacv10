//DECLARACIÓN DE PAQUETES:
package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.serviceImpl;

//IMPORTACIÓN DE LIBRERIAS:
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.Constantes.MensajesConstantes;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.MaterialTecnicoDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.dto.RespuestaDTO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.service.MaterialTecnicoService;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.dao.MaterialTecnicoDAO;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.entity.MaterialTecnico;
import com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.persistencia.repository.MaterialTecnicoRepository;
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
public class MaterialTecnicoServiceImpl implements MaterialTecnicoService {
    
    @Autowired//INYECTAMOS EL DAO.
    private MaterialTecnicoDAO materialTecnicoDAO;
    
    @Autowired//INYECTAMOS EL REPOSITORIO.
    private MaterialTecnicoRepository materialTecnicoRepository;
    
    //CONTADOR DE REGISTROS FILTRADOS.
    //CONTAR TOTAL DE REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE CONTEO.
    public Long contarTotalRegistros(Long idMaterialTecnico, String keyword, String siglaoAcronimoUnidadMilitar, String nombreTipoDespejeMilitarArtefactoExplosivo) {
        return materialTecnicoRepository.findTotalRegistros(idMaterialTecnico, keyword, siglaoAcronimoUnidadMilitar, nombreTipoDespejeMilitarArtefactoExplosivo);
    }
    
    //LISTADO DE REGISTROS FILTRADOS SIN PAGINACIÓN.
    //LISTAR REGISTROS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS.
    public List<MaterialTecnicoDTO> listarMaterialesTecnicos(Long idMaterialTecnico, String keyword, String siglaoAcronimoUnidadMilitar, String nombreTipoDespejeMilitarArtefactoExplosivo, String orderBy, String orderMode) {
        List<MaterialTecnico> materialesTecnicos = materialTecnicoRepository.findAllMaterialesTecnicos(idMaterialTecnico, keyword, siglaoAcronimoUnidadMilitar, nombreTipoDespejeMilitarArtefactoExplosivo, orderBy, orderMode);
        List<MaterialTecnicoDTO> materialTecnicoDTOS = new ArrayList<>();
        for (MaterialTecnico materialTecnico : materialesTecnicos) {
            materialTecnicoDTOS.add(materialTecnicoDAO.materialTecnicoDTO(materialTecnico));
        }
        
        return materialTecnicoDTOS;
    }
    
    //LISTADO DE REGISTROS FILTRADOS CON PAGINACIÓN.
    //LISTAR REGISTROS PAGINADOS:
    @Override//SOBREESCRIBIMOS EL METODO DE LISTAR REGISTROS PAGINADOS.
    public Slice<MaterialTecnicoDTO> listarMaterialesTecnicosPag(Pageable pageable, Long idMaterialTecnico, String keyword, String siglaoAcronimoUnidadMilitar, String nombreTipoDespejeMilitarArtefactoExplosivo, String orderBy, String orderMode) {
        Slice<MaterialTecnico> materialesTecnicos = materialTecnicoRepository.findAllMaterialesTecnicosPag(pageable, idMaterialTecnico, keyword, siglaoAcronimoUnidadMilitar, nombreTipoDespejeMilitarArtefactoExplosivo, orderBy, orderMode);
        return materialesTecnicos.map(materialTecnico -> materialTecnicoDAO.materialTecnicoDTO(materialTecnico));
    }
    
    //CREAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE CREAR REGISTRO.
    public RespuestaDTO crearMaterialTecnico(MaterialTecnicoDTO materialTecnicoDTO) {
        Long maxIdMaterialTecnico = null;
        MaterialTecnico materialTecnicoNombreyUnidadMilitar = materialTecnicoRepository.findByNombreMaterialTecnicoAndSAUnidadMilitar(materialTecnicoDTO.getNombreMaterialTecnico().toUpperCase(), materialTecnicoDTO.getUnidadMilitarDTO().getSiglaoAcronimoUnidadMilitar());
        MaterialTecnico materialTecnicoUnico = materialTecnicoRepository.findByNumeroInventarioMaterialTecnicoOrNumeroActivoFijoMaterialTecnico(materialTecnicoDTO.getNumeroInventarioMaterialTecnico(), materialTecnicoDTO.getNumeroActivoFijoMaterialTecnico());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_CREADO, false);
        
        //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
        long banderaNombreRegistroEncontrado = 0;
        long banderaRegistroEncontrado = 0;
        
        if (!(materialTecnicoNombreyUnidadMilitar == null)) {//SI ENCONTRO EL NOMBRE DEL REGISTRO REPETIDO DENTRO DE LA MISMA UNIDAD MILITAR MUESTRA UN MENSAJE DE NOMBRE YA EXISTENTE EN LA UNIDAD MILITAR.
           banderaNombreRegistroEncontrado = 1;
        }
        if (banderaNombreRegistroEncontrado == 0 && !(materialTecnicoUnico == null)) {//SI ENCONTRO EL NUMERO INVENTARIO O NUMERO ACTIVO FIJO DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE REGISTRO REPETIDO CON LOS DATOS PROPORCIONADOS.
           banderaRegistroEncontrado = 1;
        }
        
        if (banderaNombreRegistroEncontrado == 1) {//SI ENCONTRO EL NOMBRE DEL REGISTRO REPETIDO DENTRO DE LA MISMA UNIDAD MILITAR MUESTRA UN MENSAJE DE NOMBRE YA EXISTENTE EN LA UNIDAD MILITAR.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_EN_UNIDAD_MILITAR_YA_EXISTE, false);
           respuestaDTO.setMaterialTecnicoDTO(null);
        }
        if (banderaNombreRegistroEncontrado == 0 && banderaRegistroEncontrado == 1) {//SI ENCONTRO EL NUMERO INVENTARIO O NUMERO ACTIVO FIJO DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE REGISTRO REPETIDO CON LOS DATOS PROPORCIONADOS.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NUMERO_INVENTARIO_O_ACTIVO_FIJO_YA_EXISTE, false);
           respuestaDTO.setMaterialTecnicoDTO(null);
        }
        if (banderaNombreRegistroEncontrado == 0 && banderaRegistroEncontrado == 0) {//SI NO ENCONTRO EL NOMBRE REPETIDO EN LA UNIDAD MILITAR NI EL NUMERO INVENTARIO O NUMERO ACTIVO FIJO DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS CREA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO CREADO EXITOSAMENTE.
           maxIdMaterialTecnico = materialTecnicoRepository.findMaxIdMaterialTecnico();
           if (maxIdMaterialTecnico == null) {//ESTO SE HACE EN CASO DE QUE SI LA TABLA DE LA BASE DE DATOS ESTA EN BLANCO Y VA SER EL PRIMER REGISTRO AL OBTENER UN VALOR NULO, SE ASIGNE CERO (0) AUTOMÁTICAMENTE.
              maxIdMaterialTecnico = Long.valueOf(0);
           }
           materialTecnicoDTO.setIdMaterialTecnico(maxIdMaterialTecnico + 1);//OBTENGO EL ID MAXIMO AUTOMATICO, SUMO (1) ENTERO PARA OBTENER EL NUEVO ID.
           materialTecnicoRepository.save(materialTecnicoDAO.materialTecnico(materialTecnicoDTO));
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_CREADO_EXITO, true);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR ID:
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarMaterialTecnicoporId(Long idMaterialTecnico) {
        Optional<MaterialTecnico> materialTecnicoId = materialTecnicoRepository.findByIdMaterialTecnico(Long.valueOf(idMaterialTecnico));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (materialTecnicoId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO.setMaterialTecnicoDTO(materialTecnicoDAO.materialTecnicoDTO(materialTecnicoId.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (materialTecnicoId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE CONSULTA NO EXITOSA CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setMaterialTecnicoDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //LEER CONSULTA DE REGISTRO POR NUMERO INVENTARIO Y NUMERO ACTIVO FIJO (CAMPOS ÚNICOS COMBINADOS):
    @Override//SOBREESCRIBIMOS EL METODO DE LEER CONSULTA DE REGISTRO.
    public RespuestaDTO consultarMaterialTecnicoporNumeroInventarioNumeroActivoFijo(String numeroInventarioMaterialTecnico, String numeroActivoFijoMaterialTecnico) {
        if (numeroInventarioMaterialTecnico == null && numeroActivoFijoMaterialTecnico == null) {//SI TODOS LOS PARAMETROS SON NULOS NO SE REALIZA LA BUSQUEDA Y SE RETORNA UN MENSAJE DE REGISTRO NO ENCONTRADO.
           RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NUMERO_INVENTARIO_NUMERO_ACTIVO_FIJO_NO_ENCONTRADOS, false);
           respuestaDTO.setMaterialTecnicoDTO(null);
           return respuestaDTO;
        }
        Optional<MaterialTecnico> materialTecnicoUnico = Optional.ofNullable(materialTecnicoRepository.findByNumeroInventarioMaterialTecnicoOrNumeroActivoFijoMaterialTecnico(numeroInventarioMaterialTecnico, numeroActivoFijoMaterialTecnico));
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NUMERO_INVENTARIO_NUMERO_ACTIVO_FIJO_NO_ENCONTRADOS, false);
        
        if (materialTecnicoUnico.isPresent() == true) {//SI ENCONTRO EL REGISTRO CON LOS CAMPOS ÚNICOS PROPORCIONADOS EN LA TABLA DE LA BASE DE DATOS MUESTRA EL REGISTRO CON UN MENSAJE DE CONSULTA EXITOSA.
           respuestaDTO.setMaterialTecnicoDTO(materialTecnicoDAO.materialTecnicoDTO(materialTecnicoUnico.get()));
           respuestaDTO.setMensaje(MensajesConstantes.MSG_REGISTRO_CONSULTADO_EXITO);
           respuestaDTO.setBanderaexito(true);
        }
        if (materialTecnicoUnico.isPresent() == false) {//SI NO ENCONTRO EL REGISTRO CON LOS CAMPOS ÚNICOS PROPORCIONADOS EN LA TABLA DE LA BASE DE DATOS MUESTRA UN MENSAJE DE CONSULTA NO EXITOSA.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NUMERO_INVENTARIO_NUMERO_ACTIVO_FIJO_NO_ENCONTRADOS, false);
           respuestaDTO.setMaterialTecnicoDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //MODIFICAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE MODIFICAR REGISTRO.
    public RespuestaDTO actualizarMaterialTecnico(MaterialTecnicoDTO materialTecnicoDTO) {
        Optional<MaterialTecnico> materialTecnicoId = materialTecnicoRepository.findByIdMaterialTecnico(materialTecnicoDTO.getIdMaterialTecnico());
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
        
        if (materialTecnicoId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE VERIFICA LA UNICIDAD DE LOS CAMPOS ÚNICOS DEL REGISTRO CON EL ID PROPORCIONADO.
           MaterialTecnico materialTecnicoNombreyUnidadMilitar = materialTecnicoRepository.findByNombreMaterialTecnicoAndSAUnidadMilitar(materialTecnicoDTO.getNombreMaterialTecnico().toUpperCase(), materialTecnicoDTO.getUnidadMilitarDTO().getSiglaoAcronimoUnidadMilitar());
           MaterialTecnico materialTecnicoUnico = materialTecnicoRepository.findByNumeroInventarioMaterialTecnicoOrNumeroActivoFijoMaterialTecnico(materialTecnicoDTO.getNumeroInventarioMaterialTecnico(), materialTecnicoDTO.getNumeroActivoFijoMaterialTecnico());
           
           //DECLARACIÓN E INICIALIZACIÓN DE LAS BANDERAS EN CERO (0):
           long banderaNombreRegistroEncontrado = 0;
           long banderaRegistroEncontrado = 0;
           
           if (!(materialTecnicoNombreyUnidadMilitar == null) && !(materialTecnicoNombreyUnidadMilitar.getIdMaterialTecnico().equals(materialTecnicoDTO.getIdMaterialTecnico()))) {//SI ENCONTRO UN REGISTRO DIFERENTE AL ACTUAL CON EL MISMO NOMBRE DENTRO DE LA MISMA UNIDAD MILITAR MUESTRA UN MENSAJE DE NOMBRE YA EXISTENTE EN LA UNIDAD MILITAR.
              banderaNombreRegistroEncontrado = 1;
           }
           if (banderaNombreRegistroEncontrado == 0 && !(materialTecnicoUnico == null) && !(materialTecnicoUnico.getIdMaterialTecnico().equals(materialTecnicoDTO.getIdMaterialTecnico()))) {//SI ENCONTRO UN REGISTRO DIFERENTE AL ACTUAL CON EL MISMO NUMERO INVENTARIO O NUMERO ACTIVO FIJO MUESTRA UN MENSAJE DE DATOS ÚNICOS REPETIDOS.
              banderaRegistroEncontrado = 1;
           }
           
           if (banderaNombreRegistroEncontrado == 1) {//SI LA BUSQUEDA ENCONTRO UN REGISTRO CON EL MISMO NOMBRE DENTRO DE LA MISMA UNIDAD MILITAR ASOCIADO A UN ID DIFERENTE MUESTRA UN MENSAJE DE NOMBRE YA EXISTENTE EN LA UNIDAD MILITAR.
              respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NOMBRE_EN_UNIDAD_MILITAR_YA_EXISTE, false);
              respuestaDTO.setMaterialTecnicoDTO(null);
           }
           if (banderaNombreRegistroEncontrado == 0 && banderaRegistroEncontrado == 1) {//SI LA BUSQUEDA ENCONTRO UN REGISTRO CON LOS MISMOS CAMPOS ÚNICOS ASOCIADOS A UN ID DIFERENTE MUESTRA UN MENSAJE DE DATOS ÚNICOS REPETIDOS.
              respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NUMERO_INVENTARIO_O_ACTIVO_FIJO_YA_EXISTE, false);
              respuestaDTO.setMaterialTecnicoDTO(null);
           }
           if (banderaNombreRegistroEncontrado == 0 && banderaRegistroEncontrado == 0) {//SI NO ENCONTRO UN REGISTRO DIFERENTE AL ACTUAL CON EL MISMO NOMBRE EN LA UNIDAD MILITAR NI CON LOS MISMOS CAMPOS ÚNICOS SE MODIFICA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO MODIFICADO EXITOSAMENTE.
              materialTecnicoRepository.save(materialTecnicoDAO.materialTecnico(materialTecnicoDTO));
              respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ACTUALIZADO_EXITO, true);
           }
        }
        if (materialTecnicoId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS SE MUESTRA UN MENSAJE DE REGISTRO NO MODIFICADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_NO_ACTUALIZADO, false);
           respuestaDTO.setMaterialTecnicoDTO(null);
        }
        
        return respuestaDTO;
    }
    
    //ELIMINAR REGISTRO:
    @Override//SOBREESCRIBIMOS EL METODO DE ELIMINAR REGISTRO.
    public RespuestaDTO eliminarMaterialTecnico(Long idMaterialTecnico) {
        Optional<MaterialTecnico> materialTecnicoId = materialTecnicoRepository.findById(idMaterialTecnico);
        RespuestaDTO respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
        
        if (materialTecnicoId.isPresent() == true) {//SI ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO.setMaterialTecnicoDTO(materialTecnicoDAO.materialTecnicoDTO(materialTecnicoId.get()));
           materialTecnicoRepository.delete(materialTecnicoId.get());
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ELIMINADO_EXITO, true);
        }
        if (materialTecnicoId.isPresent() == false) {//SI NO ENCONTRO EL ID DEL REGISTRO EN LA TABLA DE LA BASE DE DATOS NO ELIMINA EL REGISTRO Y MUESTRA UN MENSAJE DE REGISTRO NO ELIMINADO EXITOSAMENTE CON EL ID PROPORCIONADO.
           respuestaDTO = new RespuestaDTO(MensajesConstantes.MSG_REGISTRO_ID_NO_ENCONTRADO, false);
           respuestaDTO.setMaterialTecnicoDTO(null);
        }
        
        return respuestaDTO;
    }
}
