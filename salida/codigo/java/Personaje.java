// Esqueleto generado por spec2code. Módulo: Inventario y equipamiento
// NO es una solución: clases y firmas con TODO. Completa la lógica y audita contra la spec.
package rpgmanager.inventarioyequipamiento;

import java.util.ArrayList;
import java.util.List;

/** Personaje. Trazabilidad: RF-01, RF-02, RF-03, RF-04, RF-05, RF-06, RF-07, RF-08, RF-09, RF-10. */
public class Personaje {
    private String codigo;
    private String nombre;
    private int nivel;
    private int ataqueBase;
    private int defensaBase;
    private int ataqueTotal;
    private int defensaTotal;
    private String armaEquipada;
    private String armaduraEquipada;
    private List<Inventario> inventarios = new ArrayList<>(); // asociacion: tiene ()

    public Personaje(String codigo, String nombre, int nivel, int ataqueBase, int defensaBase, int ataqueTotal, int defensaTotal, String armaEquipada, String armaduraEquipada) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.nivel = nivel;
        this.ataqueBase = ataqueBase;
        this.defensaBase = defensaBase;
        this.ataqueTotal = ataqueTotal;
        this.defensaTotal = defensaTotal;
        this.armaEquipada = armaEquipada;
        this.armaduraEquipada = armaduraEquipada;
    }

    // TODO: getters y setters (encapsulamiento)

    /** calcular_ataque_total (RN-08). */
    public void calcularAtaqueTotal() {
        throw new UnsupportedOperationException("TODO: implementar Personaje.calcular_ataque_total");
    }

    /** calcular_defensa_total (RN-08). */
    public void calcularDefensaTotal() {
        throw new UnsupportedOperationException("TODO: implementar Personaje.calcular_defensa_total");
    }
}
