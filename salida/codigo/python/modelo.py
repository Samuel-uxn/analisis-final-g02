"""Esqueleto generado por spec2code. Módulo: Inventario y equipamiento

NO es una solución: son clases y firmas con TODO. Completa la lógica, audita cada
clase contra la spec y corrige la SPEC (no este archivo) cuando el error venga de ella.
"""
from __future__ import annotations



class Personaje:
    """Personaje. Trazabilidad: RN-02."""

    def __init__(self, nombre: str, nivel: int, ataque_base: int, defensa_base: int) -> None:
        self.nombre: str = nombre  # TODO: encapsulamiento (propiedades)
        self.nivel: int = nivel  # TODO: encapsulamiento (propiedades)
        self.ataque_base: int = ataque_base  # TODO: encapsulamiento (propiedades)
        self.defensa_base: int = defensa_base  # TODO: encapsulamiento (propiedades)
        self.inventarios: list[Inventario] = []  # asociacion ()

    def equipar_arma(self) -> None:
        """equipar_arma (RN-02)."""
        raise NotImplementedError("TODO: implementar Personaje.equipar_arma")

    def equipar_armadura(self) -> None:
        """equipar_armadura (RN-02)."""
        raise NotImplementedError("TODO: implementar Personaje.equipar_armadura")


class Objeto:
    """Objeto. Trazabilidad: RN-01, RN-05."""

    def __init__(self, nombre: str, peso: int, marca_protegido: bool) -> None:
        self.nombre: str = nombre  # TODO: encapsulamiento (propiedades)
        self.peso: int = peso  # TODO: encapsulamiento (propiedades)
        self.marca_protegido: bool = marca_protegido  # TODO: encapsulamiento (propiedades)
        self.arma: Arma | None = None  # asociacion ()
        self.armadura: Armadura | None = None  # asociacion ()

    def equipar(self) -> None:
        """equipar (RN-02)."""
        raise NotImplementedError("TODO: implementar Objeto.equipar")

    def descartar(self) -> None:
        """descartar (RN-05)."""
        raise NotImplementedError("TODO: implementar Objeto.descartar")


class Arma(Objeto):
    """Arma. Trazabilidad: RN-02."""

    def __init__(self, nombre: str, peso: int, marca_protegido: bool, bono_ataque: int, nivel_minimo: int) -> None:
        super().__init__(nombre, peso, marca_protegido)
        self.bono_ataque: int = bono_ataque  # TODO: encapsulamiento (propiedades)
        self.nivel_minimo: int = nivel_minimo  # TODO: encapsulamiento (propiedades)

    def equipar(self) -> None:
        """equipar (RN-02)."""
        raise NotImplementedError("TODO: implementar Arma.equipar")


class Armadura(Objeto):
    """Armadura. Trazabilidad: RN-02."""

    def __init__(self, nombre: str, peso: int, marca_protegido: bool, bono_defensa: int, nivel_minimo: int) -> None:
        super().__init__(nombre, peso, marca_protegido)
        self.bono_defensa: int = bono_defensa  # TODO: encapsulamiento (propiedades)
        self.nivel_minimo: int = nivel_minimo  # TODO: encapsulamiento (propiedades)

    def equipar(self) -> None:
        """equipar (RN-02)."""
        raise NotImplementedError("TODO: implementar Armadura.equipar")


class Inventario:
    """Inventario. Trazabilidad: RN-01, RN-07."""

    def __init__(self, personaje: int, capacidad_maxima: int, objetos: list) -> None:
        self.personaje: int = personaje  # TODO: encapsulamiento (propiedades)
        self.capacidad_maxima: int = capacidad_maxima  # TODO: encapsulamiento (propiedades)
        self.objetos: list = objetos  # TODO: encapsulamiento (propiedades)

    def agregar_objeto(self) -> None:
        """agregar_objeto (RN-01)."""
        raise NotImplementedError("TODO: implementar Inventario.agregar_objeto")

    def listar_objetos(self) -> None:
        """listar_objetos (RN-07)."""
        raise NotImplementedError("TODO: implementar Inventario.listar_objetos")

    def filtrar_objetos(self) -> None:
        """filtrar_objetos (RN-07)."""
        raise NotImplementedError("TODO: implementar Inventario.filtrar_objetos")

    def consultar_capacidad_disponible(self) -> None:
        """consultar_capacidad_disponible (RN-07)."""
        raise NotImplementedError("TODO: implementar Inventario.consultar_capacidad_disponible")
