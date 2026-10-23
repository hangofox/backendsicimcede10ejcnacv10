package com.backendsicimcede10ejcnacv10.mil.co.backendsicimcede10ejcnacv10.dominio.Constantes;

/**
* @Autor PD04. HERNAN ADOLFO NUÑEZ GONZALEZ.
* @Since 23/10/2026.
* Declaración de las constantes de los estados de las solicitudes de infraestructuras (campo ESTADO_SOLICITUD_INFRAESTRUCTURA).
*/
public class EstadosSolicitudesInfraestructurasConstantes {

    /**
    * ESTADOS QUE SE ASIGNAN AUTOMÁTICAMENTE A MEDIDA QUE SE REGISTRAN INTEGRANTES EN EL HISTORIAL DE LA SOLICITUD, SEGÚN EL PASO
    * MÁS AVANZADO DE LA LÍNEA DE MANDO QUE YA TIENE INTEGRANTES: 1.º PASO (O NINGUNO) = CREACION, 2.º = VERIFICACION,
    * 3.º = VALIDACION, 4.º EN ADELANTE = ASIGNACION.
    */

    public static final String ESTADO_CREACION = "CREACION";
    public static final String ESTADO_VERIFICACION = "VERIFICACION";
    public static final String ESTADO_VALIDACION = "VALIDACION";
    public static final String ESTADO_ASIGNACION = "ASIGNACION";

    /**
    * ESTADOS QUE SE ASIGNAN MANUALMENTE DESDE LA SOLICITUD EN ASIGNACION; UNA VEZ ASIGNADOS, YA NO SE RECALCULAN AUTOMÁTICAMENTE.
    */

    public static final String ESTADO_APROBACION = "APROBACION";
    public static final String ESTADO_RECHAZADO = "RECHAZADO";
}
