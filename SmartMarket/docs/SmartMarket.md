# Ejercicio Smart Market

## Enunciado

Smart Market es una cadena de supermercados que inició como una tienda local de abarrotes. Debido a su enfoque innovador, ha crecido rápidamente hasta convertirse en una red de autoservicios con presencia nacional. Para sus operaciones básicas, utilizaba un sistema tradicional donde el control de productos, ventas y personal se llevaba de forma manual o mediante hojas de cálculo.

Sin embargo, con la expansión de sucursales, el volumen de transacciones y usuarios ha aumentado considerablemente, y la empresa ha decidido desarrollar una aplicación que automatice sus procesos internos. Este nuevo sistema debe permitir registrar y gestionar los productos disponibles, como alimentos, bebidas, productos de aseo, las personas que realizan compras, el personal que atiende en las cajas o reabastece estantes, así como las ventas diarias realizadas. Además, se espera que los compradores puedan agregar artículos a un conjunto de selección, consultar el valor total a pagar y recibir un comprobante.

Para lograrlo, el equipo de desarrollo debe identificar las entidades clave del supermercado, sus características más relevantes y las acciones que cada una puede realizar dentro del sistema. El equipo de diseño debe estructurar una solución basada en principios de programación orientada a objetos, de modo que los elementos del supermercado se representen de forma organizada, reutilizable y flexible.

A partir del escenario descrito, se espera que se reconozcan los componentes generales que se deben modelar, así como ejemplos concretos derivados de cada uno. También se debe reflexionar sobre cómo estos elementos interactúan entre sí y cómo pueden contribuir a la construcción de una aplicación funcional y mantenible.

El equipo de desarrollo debe aplicar el principio de abstracción para identificar las características esenciales y comunes de los elementos del supermercado, representándolas mediante clases abstractas e interfaces que sirvan como base para especializaciones concretas.

A partir del escenario descrito, se espera que se definan superclases como Producto o Persona, que permitan derivar variantes específicas, por ejemplo, perecedero, no perecedero, cliente, empleado, así como medios de pago y promociones que extiendan su comportamiento. De igual manera, se debe reflexionar sobre cómo estas abstracciones facilitan la organización, reducen la complejidad y favorecen la extensibilidad del sistema, contribuyendo a la construcción de una aplicación robusta, funcional y mantenible.

## Pregunta a responder

¿Qué superclases, clases abstractas e interfaces debería definir el estudiante para Smart Market y qué responsabilidades esenciales debería concentrar cada una para garantizar que el modelo pueda extenderse sin modificar su núcleo?


# Diseno

        Producto (abstracta)
   codigo, nombre, precio, presentacion
         /                \
  Perecedero          NoPerecedero
  fechaVencimiento

  ## Diseno Actualizado

          Producto (abstracta)                 Persona (abstracta)
  codigo, nombre, precio, presentacion      nombre, identificacion, ...
         /            \                        /            \
  Perecedero     NoPerecedero              Cliente        Empleado
  fechaVencimiento                         afiliado        cargo
                                           puntos          salario

## Boceto de interfaces:

   MedioPago (interfaz)              Promocion (interfaz)
   pagar(monto)                      aplicarDescuento(precio, cantidad)
   /      |        \                    /                \
Efectivo Tarjeta Transferencia     DosPorUno   DescuentoSegundaUnidad

## Boceto de composición:

Comprobante ──tiene──> Venta ──tiene──> Carrito ──tiene muchos──> Producto
  numero                 fecha                  calcularTotal()
                         Cliente
                         Empleado
                         MedioPago

## Respuesta

Introducción
Smart Market pasó de ser una tienda local a una cadena nacional, y su control manual en hojas de cálculo ya no soporta el volumen de productos, personas y transacciones. Diseñar el sistema con programación orientada a objetos permite representar cada elemento del supermercado como una clase organizada, reutilizable y fácil de extender. Para lograrlo se aplican tres principios: herencia, polimorfismo y composición.

Herencia: organizar y reutilizar
La herencia permite que una clase hija reciba los atributos y métodos de una clase madre y agregue los suyos. En Smart Market se definen dos clases abstractas: Producto, con código, nombre, precio y presentación, de la que heredan Perecedero, que agrega fecha de vencimiento, y NoPerecedero; y Persona, con nombre e identificación, de la que heredan Cliente, que agrega afiliación y puntos, y Empleado, que agrega cargo y salario. Así, los datos comunes se escriben una sola vez en la madre y cada hija solo define lo que la hace diferente. Si mañana se venden productos congelados, basta con crear Congelado como hija de Perecedero, sin modificar las clases existentes.

Polimorfismo: garantizar flexibilidad
El polimorfismo permite que un mismo método se comporte distinto según la clase que lo ejecuta. En Smart Market se definen dos interfaces: MedioPago, con el método pagar(), implementada por Efectivo, Tarjeta y Transferencia; y Promocion, con el método aplicarDescuento(), implementada por DosPorUno y DescuentoSegundaUnidad. La caja solo da la orden de pagar o aplicar el descuento, sin necesidad de saber qué tipo concreto lo resuelve. Por eso, agregar un nuevo medio de pago, como el pago con QR, o una nueva promoción, no exige cambiar el núcleo del sistema.

Composición: conectar las transacciones
La composición consiste en construir una clase a partir de objetos de otras clases, en una relación “tiene un”. En Smart Market, un Carrito tiene muchos productos y calcula el total a pagar; una Venta tiene un cliente, un empleado, un carrito, un medio de pago y una fecha; y un Comprobante tiene un número y la venta que respalda. Cada objeto conserva sus propios datos y los demás se los piden cuando los necesitan, de forma parecida a la normalización en bases de datos, lo que evita la redundancia y permite cambiar una pieza sin afectar a las demás.

=================== HERENCIA ("es un") ===================

          Producto (abstracta)                      Persona (abstracta)
   codigo, nombre, precio, presentacion          nombre, identificacion
          /                \                        /              \
    Perecedero         NoPerecedero             Cliente          Empleado
    fechaVencimiento                            afiliado         cargo
         |                                      puntos           salario
     Congelado
     temperaturaMaxima

============== POLIMORFISMO (interfaces, "sabe hacer") ==============

        MedioPago (interfaz)                  Promocion (interfaz)
        pagar(monto)                          aplicarDescuento(precio, cantidad)
       /       |        \                        /                 \
  Efectivo  Tarjeta  Transferencia         DosPorUno    DescuentoSegundaUnidad

================ COMPOSICION ("tiene un") ================

  Comprobante ──tiene──> Venta ──tiene──> Carrito ──tiene muchos──> Producto
   numero                 fecha             calcularTotal()
                          │
                          ├──tiene──> Cliente
                          ├──tiene──> Empleado
                          └──tiene──> MedioPago

Conclusión
Los tres principios se complementan: la herencia organiza qué es cada entidad y reutiliza lo común, el polimorfismo permite que distintas clases respondan a la misma orden a su manera, y la composición conecta las piezas para formar las transacciones. El resultado es un sistema ordenado, sin código repetido y preparado para crecer junto con Smart Market sin tener que reescribir su núcleo.