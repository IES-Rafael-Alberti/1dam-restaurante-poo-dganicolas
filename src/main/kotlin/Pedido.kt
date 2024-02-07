/**
 *  Clase Pedido
 * - **Responsabilidades:**
 *   - Mantener un registro de los platos pedidos por un cliente.
 *   - `contPedidos`: Int - No pertenece a ningún pedido en concreto, sino que es un valor global a todos y se utilizará para calcular automáticamente los números de los pedidos.
 *
 * - **Propiedades:**
 *   - `numero`: Int - El número de pedido será calculado automáticamente al crear cada pedido con respecto a un contador que existirá en la clase Pedido.
 *   - `platos`: List<Plato> - Lista de platos que componen el pedido.
 *   - `estado`: String - Estado del pedido (por ejemplo, "pendiente", "preparación", "listo" y "servido"). Por defecto, todo pedido estará en estado pendiente.
 *
 * - **Métodos:**
 *   - `agregarPlato(plato: Plato)`: Añade un nuevo plato al pedido.
 *   - `eliminarPlato(nombrePlato: String)`: Elimina un plato del pedido basándose en el nombre.
 *   - `calcularPrecio()`: Calcula el precio total del pedido sumando los precios de cada plato.
 *   - `calcularTiempo()`: Calcula el tiempo total de preparación sumando el tiempo de preparación de cada plato.
 *   - `toString()`: Retornar la información del pedido utilizando el número de mesa, el método toString() de cada plato y su estado. (por ejemplo, "Hamburguesa (8 min.) -> 8.99€ (carne, huevo, queso, pan y tomate)")
 *
 * */
class Pedido() {
    var numero= contPedidos
    var platos = mutableListOf<Plato>()
    var estado = "pendiente"
    init{
        contPedidos ++
    }
    fun agregarPlato(plato: Plato){
        platos.add(plato)
    }
    fun eliminarPlato(nombrePlato: String){
        platos.remove(platos.find {it.nombre == nombrePlato})
    }
    fun calcularPrecio(){
        platos.sumOf { it.precio }
    }
    fun calcularTiempo(){
        platos.sumOf { it.tiempoPreparacion }
    }
//
    override fun toString():String{

    platos.forEach{ println(it) }//ivan gpt 1,2,3,4,5,6,7 plato in platos == it
    /**for(plato in platos){
        println(plato)
    }*/
    return "estado: $estado"//retorna el string
    }
    companion object{
        var contPedidos = 0

    }
}