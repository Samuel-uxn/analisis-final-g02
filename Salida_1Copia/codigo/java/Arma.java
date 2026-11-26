// Esqueleto generado por spec2code. Módulo: Inventario y equipamiento
// NO es una solución: clases y firmas con TODO. Completa la lógica y audita contra la spec.
package rpgmanager.inventarioyequipamiento;

/** Arma. Trazabilidad: RN-02. */
public class Arma extends Objeto {
    private int bonoAtaque;
    private int nivelMinimo;

    public Arma(String nombre, int peso, boolean marcaProtegido, int bonoAtaque, int nivelMinimo) {
        super(nombre, peso, marcaProtegido);
        this.bonoAtaque = bonoAtaque;
        this.nivelMinimo = nivelMinimo;
    }

    // TODO: getters y setters (encapsulamiento)

    /** equipar (RN-02). */
    public void equipar() {
        throw new UnsupportedOperationException("TODO: implementar Arma.equipar");
    }
}
