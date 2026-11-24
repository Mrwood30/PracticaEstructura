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