// Esqueleto generado por spec2code. Módulo: Inventario y equipamiento
// NO es una solución: clases y firmas con TODO. Completa la lógica y audita contra la spec.
package rpgmanager.inventarioyequipamiento;

import java.util.List;

/** Inventario. Trazabilidad: RN-01, RN-07. */
public class Inventario {
    private int personaje;
    private int capacidadMaxima;
    private List<Object> objetos;

    public Inventario(int personaje, int capacidadMaxima, List<Object> objetos) {
        this.personaje = personaje;
        this.capacidadMaxima = capacidadMaxima;
        this.objetos = objetos;
    }

    // TODO: getters y setters (encapsulamiento)

    /** agregar_objeto (RN-01). */
    public void agregarObjeto() {
        throw new UnsupportedOperationException("TODO: implementar Inventario.agregar_objeto");
    }

    /** listar_objetos (RN-07). */
    public void listarObjetos() {
        throw new UnsupportedOperationException("TODO: implementar Inventario.listar_objetos");
    }

    /** filtrar_objetos (RN-07). */
    public void filtrarObjetos() {
        throw new UnsupportedOperationException("TODO: implementar Inventario.filtrar_objetos");
    }

    /** consultar_capacidad_disponible (RN-07). */
    public void consultarCapacidadDisponible() {
        throw new UnsupportedOperationException("TODO: implementar Inventario.consultar_capacidad_disponible");
    }
}
