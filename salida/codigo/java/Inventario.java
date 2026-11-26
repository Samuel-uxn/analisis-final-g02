// Esqueleto generado por spec2code. Módulo: Inventario y equipamiento
// NO es una solución: clases y firmas con TODO. Completa la lógica y audita contra la spec.
package rpgmanager.inventarioyequipamiento;

/** Inventario. Trazabilidad: RF-01, RF-02, RF-03, RF-04, RF-05, RF-06, RF-07, RF-08, RF-09, RF-10. */
public class Inventario {
    private String codigo;
    private int capacidadMaxima;
    private int pesoTotal;
    private int capacidadDisponible;
    private Objeto objeto; // asociacion: contiene ()

    public Inventario(String codigo, int capacidadMaxima, int pesoTotal, int capacidadDisponible) {
        this.codigo = codigo;
        this.capacidadMaxima = capacidadMaxima;
        this.pesoTotal = pesoTotal;
        this.capacidadDisponible = capacidadDisponible;
    }

    // TODO: getters y setters (encapsulamiento)

    /** agregar_objeto (RF-01, RN-07, RN-09, RN-10, RN-11). */
    public void agregarObjeto() {
        throw new UnsupportedOperationException("TODO: implementar Inventario.agregar_objeto");
    }

    /** listar_objetos (RF-02, RN-07, RN-09, RN-10, RN-11). */
    public void listarObjetos() {
        throw new UnsupportedOperationException("TODO: implementar Inventario.listar_objetos");
    }

    /** filtrar_objetos (RF-03, RN-07, RN-09, RN-10, RN-11). */
    public void filtrarObjetos() {
        throw new UnsupportedOperationException("TODO: implementar Inventario.filtrar_objetos");
    }

    /** consultar_capacidad_disponible (RF-04, RN-07, RN-09, RN-10, RN-11). */
    public void consultarCapacidadDisponible() {
        throw new UnsupportedOperationException("TODO: implementar Inventario.consultar_capacidad_disponible");
    }
}
