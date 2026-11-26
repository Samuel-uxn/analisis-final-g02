// Esqueleto generado por spec2code. Módulo: Inventario y equipamiento
// NO es una solución: clases y firmas con TODO. Completa la lógica y audita contra la spec.
package rpgmanager.inventarioyequipamiento;

/** Arma. Trazabilidad: RF-07, RF-08, RF-09, RF-10. */
public class Arma {
    private String codigo;
    private int bonoAtaque;
    private int nivelMinimo;

    public Arma(String codigo, int bonoAtaque, int nivelMinimo) {
        this.codigo = codigo;
        this.bonoAtaque = bonoAtaque;
        this.nivelMinimo = nivelMinimo;
    }

    // TODO: getters y setters (encapsulamiento)

    /** equipar (RF-07, RN-02, RN-03, RN-08, RN-09, RN-10, RN-11). */
    public void equipar() {
        throw new UnsupportedOperationException("TODO: implementar Arma.equipar");
    }
}
