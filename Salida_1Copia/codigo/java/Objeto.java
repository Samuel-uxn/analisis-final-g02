// Esqueleto generado por spec2code. Módulo: Inventario y equipamiento
// NO es una solución: clases y firmas con TODO. Completa la lógica y audita contra la spec.
package rpgmanager.inventarioyequipamiento;

/** Objeto. Trazabilidad: RN-01, RN-05. */
public class Objeto {
    private String nombre;
    private int peso;
    private boolean marcaProtegido;
    private Arma arma; // asociacion ()
    private Armadura armadura; // asociacion ()

    public Objeto(String nombre, int peso, boolean marcaProtegido) {
        this.nombre = nombre;
        this.peso = peso;
        this.marcaProtegido = marcaProtegido;
    }

    // TODO: getters y setters (encapsulamiento)

    /** equipar (RN-02). */
    public void equipar() {
        throw new UnsupportedOperationException("TODO: implementar Objeto.equipar");
    }

    /** descartar (RN-05). */
    public void descartar() {
        throw new UnsupportedOperationException("TODO: implementar Objeto.descartar");
    }
}
