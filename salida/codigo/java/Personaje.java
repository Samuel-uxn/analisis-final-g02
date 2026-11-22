// Esqueleto generado por spec2code. Módulo: Inventario y equipamiento
// NO es una solución: clases y firmas con TODO. Completa la lógica y audita contra la spec.
package rpgmanager.inventarioyequipamiento;

import java.util.ArrayList;
import java.util.List;

/** Personaje. Trazabilidad: RN-02. */
public class Personaje {
    private String nombre;
    private int nivel;
    private int ataqueBase;
    private int defensaBase;
    private List<Inventario> inventarios = new ArrayList<>(); // asociacion ()

    public Personaje(String nombre, int nivel, int ataqueBase, int defensaBase) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.ataqueBase = ataqueBase;
        this.defensaBase = defensaBase;
    }

    // TODO: getters y setters (encapsulamiento)

    /** equipar_arma (RN-02). */
    public void equiparArma() {
        throw new UnsupportedOperationException("TODO: implementar Personaje.equipar_arma");
    }

    /** equipar_armadura (RN-02). */
    public void equiparArmadura() {
        throw new UnsupportedOperationException("TODO: implementar Personaje.equipar_armadura");
    }
}
