/**
 * Clase Mesa
 * - **Responsabilidades:**
 *   - Representar una mesa en el restaurante.
 *
 * - **Propiedades:**
 *   - `numero`: Int - Número de la mesa.
 *   - `capacidad`: Int - Capacidad máxima de personas que pueden sentarse en la mesa. Solo existen mesas de 1 a 6 comensales.
 *   - `estado`: String - Estado de la mesa (por ejemplo, "libre", "reservada y "ocupada").
 *   - `pedidos`: List<Pedido> - Lista de pedidos realizados por la mesa.
 *
 * - **Métodos:**
 *   - `ocuparMesa()`: Cambia el estado de la mesa a "ocupada", pero solo si la mesa está en estado "libre".
 *   - `ocuparReserva()`: Cambia el estado de la mesa a "ocupada", pero solo si la mesa está en estado "reservada".
 *   - `liberarMesa()`: Cambia el estado de la mesa a "libre".
 *   - `agregarPedido(Pedido)`: Agrega un pedido a los pedidos de la mesa.
 * */
class Mesa(var numero: Int, var capacidad : Int, ) {
    var estado = "libre"
    var pedidos : MutableList<Pedido> = mutableListOf()
    fun ocuparMesa(){
        if (this.estado == "libre") this.estado= "ocupado" else println("La mesa esta ocupada")
    }
    fun ocuparReserva(){
        if (this.estado == "ocupado") this.estado= "reservada" else println("La mesa esta ocupada")
    }
    fun liberarMesa(){
        if (this.estado == "ocupado") this.estado= "libre" else println("La mesa esta libre")
    }
    fun agregarPedido(pedido: Pedido){
        pedidos.add(pedido)
    }

    override fun toString(): String {
        println("${this.numero}: $estado")
        pedidos.forEach{println(it)}
        return ""
    }

}