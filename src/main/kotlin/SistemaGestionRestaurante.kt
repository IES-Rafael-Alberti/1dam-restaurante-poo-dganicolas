/**
 * Sistema de Gestión de Restaurante
 * - **Responsabilidades:**
 *   - Integrar y gestionar las operaciones del restaurante.
 *
 * - **Propiedades:**
 *   - `mesas`: List<Mesa> - Lista de todas las mesas en el restaurante.
 *
 * - **Métodos:**
 *   - `realizarPedido(numeroMesa: Int, pedido: Pedido)`: Asocia un nuevo pedido a una mesa. Debe verificar que la mesa esté ocupada antes de asociar el pedido.
 *   - `cerrarPedido(numeroMesa: Int, numeroPedido: Int?)`: Si el númeroPedido es null, cambia el estado del último pedido de una mesa a "servido". Si le llega un numeroPedido, entonces debe buscar el pedido con dicho número y cambiar su estado a "servido".
 *   - `cerrarMesa(numeroMesa: Int)`: Si todos los pedidos están servidos, libera la mesa.
 *   - `buscarPlatos()`: Retorna una lista con el nombre de los platos pedidos. Si no hay ninguno retorna null.
 *   - `contarPlato(nombre: String)`: Cuenta el número de veces que se ha pedido un plato. Si no hay ninguno retorna null.
 *   - `buscarPlatoMasPedido()`: Busca y retorna el o los platos más pedidos. Si no hay ninguno retorna null. Utiliza los dos métodos anteriores.
 *
 * ***NOTA***: Muy útiles para esta clase los siguientes métodos que podéis investigar... find{}, let{}, lastOrNull() y all{}.
 *
 * **Premisas y Requisitos:**
 * - La capacidad de una mesa debe ser un número positivo.
 * - El estado de la mesa debe ser manejado adecuadamente para reflejar si está libre, reservada u ocupada.
 *
 * */
class SistemaGestionRestaurante(private val mesas: List<Mesa>) {

    //`realizarPedido(numeroMesa: Int, pedido: Pedido)`: Asocia un nuevo pedido a una mesa. Debe verificar que la mesa esté ocupada antes de asociar el pedido.
    fun realizarPedido(numeroMesa: Int, pedido: Pedido) {

    }

    fun cerrarPedido(numeroMesa: Int, numeroPedido: Int? = null) {
        //TODO desarrollar este método...
    }

    fun cerrarMesa(numeroMesa: Int) {
        //TODO desarrollar este método...
    }

    fun buscarPlatos(): List<String>? {
        val platos = mesas.flatMap { it.pedidos }.flatMap { it.platos }.map { it.nombre }
        return platos.ifEmpty { null }
    }

    fun contarPlato(nombre: String): Int? {
        val count = mesas.flatMap { it.pedidos }
            .flatMap { it.platos }
            .count { it.nombre == nombre }
        return if (count > 0) count else null
    }

    fun buscarPlatoMasPedido(): List<String>? {
        val platoCounts = mesas.flatMap { it.pedidos }
            .flatMap { it.platos }
            .groupingBy { it.nombre }
            .eachCount()

        val maxCount = platoCounts.maxByOrNull { it.value }?.value
        return maxCount?.let { max -> platoCounts.filter { it.value == max }.keys.toList() }
    }
}