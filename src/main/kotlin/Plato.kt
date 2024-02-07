import java.lang.module.ModuleDescriptor.Requires

/**
 * Clase Plato
 * Responsabilidades:
 *
 * Representar la información de un plato.
 * Propiedades:
 *
 * nombre: String - El nombre del plato. No puede ser vacío. ----
 * precio: Double - El precio del plato. Debe ser mayor que 0. ----
 * tiempoPreparacion: Int - Tiempo estimado para preparar el plato (en minutos). ----
 * ingredientes: List - Lista de ingredientes necesarios para el plato. ----
 * Métodos:
 * agregarIngrediente(ingrediente: String): Añade un nuevo ingrediente a la lista de ingredientes del plato.
 * toString(): Retornar la información del plato (por ejemplo, "Hamburguesa (8 min.) -> 8.99€ (carne, huevo, queso, pan y tomate)")
 * Premisas y Requisitos:
 * El nombre del plato no puede ser vacío.
 * El precio del plato debe ser mayor que 0.
 * El tiempo de preparación no podrá ser igual o inferior a 1.
 * Un ingrediente no puede ser vacío.
 * eConsiderar el uso de propidades de Kotlin para validar automáticamente estas restricciones tanto al crear un plato cómo al modificar sus valores.* */
/**es la clase de platos
 * donde guardaremos informacion sobre los diferentes platos que contenga el restaurante
 * @property nombre : nombre del plato
 * @property precio : lo que cuesta en € el plato
 * @property tiempoPreparacion : el tiempo estimado de preparacion
 * @property ingredientes : una lista dentro de los platos que contiene los diferentes ingredientes
 * */
class Plato(nombre: String, precio:Double, tiempoPreparacion: Int, ingredientes: MutableList<String>) {
    var nombre = nombre
        set(value) {
            require (value.isNotBlank()){"el nombre no debe estar vacio"}
            field=value
        }
    var precio = precio
        set(value) {
            require (value > 0.0){"el precio debe de ser positivo"}
            field=value
        }
    var tiempoPreparacion = tiempoPreparacion
        set(value) {
            require (tiempoPreparacion >= 1){"el tiempo de preparacion debe ser mayor o igual a 1 min "}
            field=value
        }
    var ingredientes = ingredientes
    //inicializa el objeto plato, y comprueba que precio no sea un numero menor y que el nombre no este vacio
    init {

        this.nombre=nombre
        this.precio = precio
        this.tiempoPreparacion = tiempoPreparacion
        this.ingredientes=ingredientes
        require (nombre.isNotBlank()){"el nombre no debe estar vacio"}
        require(this.precio > 0){"el precio debe ser positivo"}
        require (this.ingredientes.isNotEmpty()){"un plato sin ingredientes???"}
        require(this.tiempoPreparacion >= 1){"el tiempo de preparacion no debe ser menor o igual a 1"}
    }


    fun agregarIngrediente(ingrediente: String){
        if (ingrediente.isNotBlank()){
            println("el ingredientes no puede estar vacio")
        }else{ this.ingredientes.add(ingrediente)}
        println("el ingrediente: $ingrediente, ha sido añadido al plato: $nombre")
    }

    override fun toString(): String = "$nombre ($tiempoPreparacion min.) -> $precio (${ingredientes.joinToString(", ") }})"
}