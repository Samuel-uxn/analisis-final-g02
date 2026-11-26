// Esqueleto generado por spec2code. Módulo: Inventario y equipamiento
// NO es una solución: clases y firmas con TODO. Completa la lógica y audita contra la spec.
package rpgmanager.inventarioyequipamiento;

/** Armadura. Trazabilidad: RF-10, RF-07, RF-08, RF-09. */
public class Armadura {
    private String codigo;
    private int bonoDefensa;
    private int nivelMinimo;

    public Armadura(String codigo, int bonoDefensa, int nivelMinimo) {
        this.codigo = codigo;
        this.bonoDefensa = bonoDefensa;
        this.nivelMinimo = nivelMinimo;
    }

    // TODO: getters y setters (encapsulamiento)

    /** equipar (RF-10, RN-02, RN-04, RN-08, RN-09, RN-10, RN-11). */
    public void equipar() {
        throw new UnsupportedOperationException("TODO: implementar Armadura.equipar");
    }
}
