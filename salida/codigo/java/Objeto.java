// Esqueleto generado por spec2code. Módulo: Inventario y equipamiento
// NO es una solución: clases y firmas con TODO. Completa la lógica y audita contra la spec.
package rpgmanager.inventarioyequipamiento;

/** Objeto. Trazabilidad: RF-06, RF-08, RF-09, RF-10. */
public class Objeto {
    private String codigo;
    private String nombre;
    private int peso;
    private String tipo;
    private boolean marcaProtegido;
    private boolean marcaEquipado;

    public Objeto(String codigo, String nombre, int peso, String tipo, boolean marcaProtegido, boolean marcaEquipado) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.peso = peso;
        this.tipo = tipo;
        this.marcaProtegido = marcaProtegido;
        this.marcaEquipado = marcaEquipado;
    }

    // TODO: getters y setters (encapsulamiento)

    /** marcar_protegido (RF-09, RN-05, RN-07, RN-09, RN-10, RN-11). */
    public void marcarProtegido() {
        throw new UnsupportedOperationException("TODO: implementar Objeto.marcar_protegido");
    }

    /** desmarcar_protegido (RF-09, RN-05, RN-07, RN-09, RN-10, RN-11). */
    public void desmarcarProtegido() {
        throw new UnsupportedOperationException("TODO: implementar Objeto.desmarcar_protegido");
    }
}
