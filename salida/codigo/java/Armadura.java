// Esqueleto generado por spec2code. Módulo: Inventario y equipamiento
// NO es una solución: clases y firmas con TODO. Completa la lógica y audita contra la spec.
package rpgmanager.inventarioyequipamiento;

/** Armadura. Trazabilidad: RN-02. */
public class Armadura extends Objeto {
    private int bonoDefensa;
    private int nivelMinimo;

    public Armadura(String nombre, int peso, boolean marcaProtegido, int bonoDefensa, int nivelMinimo) {
        super(nombre, peso, marcaProtegido);
        this.bonoDefensa = bonoDefensa;
        this.nivelMinimo = nivelMinimo;
    }

    // TODO: getters y setters (encapsulamiento)

    /** equipar (RN-02). */
    public void equipar() {
        throw new UnsupportedOperationException("TODO: implementar Armadura.equipar");
    }
}
