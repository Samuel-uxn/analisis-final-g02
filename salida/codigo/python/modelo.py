"""Esqueleto generado por spec2code. Módulo: Inventario y equipamiento

NO es una solución: son clases y firmas con TODO. Completa la lógica, audita cada
clase contra la spec y corrige la SPEC (no este archivo) cuando el error venga de ella.
"""
from __future__ import annotations



class Personaje:
    """Personaje. Trazabilidad: RF-01, RF-02, RF-03, RF-04, RF-05, RF-06, RF-07, RF-08, RF-09, RF-10."""

    def __init__(self, codigo: str, nombre: str, nivel: int, ataque_base: int, defensa_base: int, ataque_total: int, defensa_total: int, arma_equipada: str, armadura_equipada: str) -> None:
        self.codigo: str = codigo  # TODO: encapsulamiento (propiedades)
        self.nombre: str = nombre  # TODO: encapsulamiento (propiedades)
        self.nivel: int = nivel  # TODO: encapsulamiento (propiedades)
        self.ataque_base: int = ataque_base  # TODO: encapsulamiento (propiedades)
        self.defensa_base: int = defensa_base  # TODO: encapsulamiento (propiedades)
        self.ataque_total: int = ataque_total  # TODO: encapsulamiento (propiedades)
        self.defensa_total: int = defensa_total  # TODO: encapsulamiento (propiedades)
        self.arma_equipada: str = arma_equipada  # TODO: encapsulamiento (propiedades)
        self.armadura_equipada: str = armadura_equipada  # TODO: encapsulamiento (propiedades)
        self.inventarios: list[Inventario] = []  # asociacion: tiene ()

    def calcular_ataque_total(self) -> None:
        """calcular_ataque_total (RN-08)."""
        raise NotImplementedError("TODO: implementar Personaje.calcular_ataque_total")

    def calcular_defensa_total(self) -> None:
        """calcular_defensa_total (RN-08)."""
        raise NotImplementedError("TODO: implementar Personaje.calcular_defensa_total")


class Inventario:
    """Inventario. Trazabilidad: RF-01, RF-02, RF-03, RF-04, RF-05, RF-06, RF-07, RF-08, RF-09, RF-10."""

    def __init__(self, codigo: str, capacidad_maxima: int, peso_total: int, capacidad_disponible: int) -> None:
        self.codigo: str = codigo  # TODO: encapsulamiento (propiedades)
        self.capacidad_maxima: int = capacidad_maxima  # TODO: encapsulamiento (propiedades)
        self.peso_total: int = peso_total  # TODO: encapsulamiento (propiedades)
        self.capacidad_disponible: int = capacidad_disponible  # TODO: encapsulamiento (propiedades)
        self.objeto: Objeto | None = None  # asociacion: contiene ()

    def agregar_objeto(self) -> None:
        """agregar_objeto (RF-01, RN-07, RN-09, RN-10, RN-11)."""
        raise NotImplementedError("TODO: implementar Inventario.agregar_objeto")

    def listar_objetos(self) -> None:
        """listar_objetos (RF-02, RN-07, RN-09, RN-10, RN-11)."""
        raise NotImplementedError("TODO: implementar Inventario.listar_objetos")

    def filtrar_objetos(self) -> None:
        """filtrar_objetos (RF-03, RN-07, RN-09, RN-10, RN-11)."""
        raise NotImplementedError("TODO: implementar Inventario.filtrar_objetos")

    def consultar_capacidad_disponible(self) -> None:
        """consultar_capacidad_disponible (RF-04, RN-07, RN-09, RN-10, RN-11)."""
        raise NotImplementedError("TODO: implementar Inventario.consultar_capacidad_disponible")


class Objeto:
    """Objeto. Trazabilidad: RF-06, RF-08, RF-09, RF-10."""

    def __init__(self, codigo: str, nombre: str, peso: int, tipo: str, marca_protegido: bool, marca_equipado: bool) -> None:
        self.codigo: str = codigo  # TODO: encapsulamiento (propiedades)
        self.nombre: str = nombre  # TODO: encapsulamiento (propiedades)
        self.peso: int = peso  # TODO: encapsulamiento (propiedades)
        self.tipo: str = tipo  # TODO: encapsulamiento (propiedades)
        self.marca_protegido: bool = marca_protegido  # TODO: encapsulamiento (propiedades)
        self.marca_equipado: bool = marca_equipado  # TODO: encapsulamiento (propiedades)

    def marcar_protegido(self) -> None:
        """marcar_protegido (RF-09, RN-05, RN-07, RN-09, RN-10, RN-11)."""
        raise NotImplementedError("TODO: implementar Objeto.marcar_protegido")

    def desmarcar_protegido(self) -> None:
        """desmarcar_protegido (RF-09, RN-05, RN-07, RN-09, RN-10, RN-11)."""
        raise NotImplementedError("TODO: implementar Objeto.desmarcar_protegido")


class Arma:
    """Arma. Trazabilidad: RF-07, RF-08, RF-09, RF-10."""

    def __init__(self, codigo: str, bono_ataque: int, nivel_minimo: int) -> None:
        self.codigo: str = codigo  # TODO: encapsulamiento (propiedades)
        self.bono_ataque: int = bono_ataque  # TODO: encapsulamiento (propiedades)
        self.nivel_minimo: int = nivel_minimo  # TODO: encapsulamiento (propiedades)

    def equipar(self) -> None:
        """equipar (RF-07, RN-02, RN-03, RN-08, RN-09, RN-10, RN-11)."""
        raise NotImplementedError("TODO: implementar Arma.equipar")


class Armadura:
    """Armadura. Trazabilidad: RF-10, RF-07, RF-08, RF-09."""

    def __init__(self, codigo: str, bono_defensa: int, nivel_minimo: int) -> None:
        self.codigo: str = codigo  # TODO: encapsulamiento (propiedades)
        self.bono_defensa: int = bono_defensa  # TODO: encapsulamiento (propiedades)
        self.nivel_minimo: int = nivel_minimo  # TODO: encapsulamiento (propiedades)

    def equipar(self) -> None:
        """equipar (RF-10, RN-02, RN-04, RN-08, RN-09, RN-10, RN-11)."""
        raise NotImplementedError("TODO: implementar Armadura.equipar")


class Otro:
    """Otro. Trazabilidad: RF-06, RF-07, RF-08, RF-09."""

    def __init__(self, codigo: str, nombre: str, peso: int) -> None:
        self.codigo: str = codigo  # TODO: encapsulamiento (propiedades)
        self.nombre: str = nombre  # TODO: encapsulamiento (propiedades)
        self.peso: int = peso  # TODO: encapsulamiento (propiedades)
