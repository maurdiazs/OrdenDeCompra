package com.example.detalleordenescompra;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class OrdenCompraController {

    // Listas en memoria para almacenar las órdenes de compra, productos y estados de las órdenes
    private List<OrdenCompra> ordenesCompra;
    private List<Producto> productos;
    private List<EstadoOrden> estadosOrden;

    // Constructor
    public OrdenCompraController() {
        this.productos = new ArrayList<>();
        this.estadosOrden = new ArrayList<>();
        this.ordenesCompra = new ArrayList<>();

        // Poblar los productos
        productos.add(new Producto(1, "Comida para perros", "Comida nutritiva para perros adultos", 20.0));
        productos.add(new Producto(2, "Juguete para gatos", "Pelota con cascabel para gatos", 5.5));
        productos.add(new Producto(3, "Collar antipulgas", "Collar repelente de pulgas y garrapatas", 15.0));

        // Poblar los estados de las órdenes
        estadosOrden.add(new EstadoOrden(1, "Procesando"));
        estadosOrden.add(new EstadoOrden(2, "Enviado"));
        estadosOrden.add(new EstadoOrden(3, "Entregado"));
        estadosOrden.add(new EstadoOrden(4, "Cancelado"));

        // Poblar algunas órdenes de compra
        ordenesCompra.add(new OrdenCompra(1, 101, Arrays.asList(productos.get(0), productos.get(1)), LocalDate.of(2024, 9, 1), estadosOrden.get(0)));
        ordenesCompra.add(new OrdenCompra(2, 102, Arrays.asList(productos.get(1)), LocalDate.of(2024, 9, 2), estadosOrden.get(1)));
        ordenesCompra.add(new OrdenCompra(3, 103, Arrays.asList(productos.get(0), productos.get(2)), LocalDate.of(2024, 9, 3), estadosOrden.get(2)));
        ordenesCompra.add(new OrdenCompra(4, 104, Arrays.asList(productos.get(2)), LocalDate.of(2024, 9, 4), estadosOrden.get(3)));
        ordenesCompra.add(new OrdenCompra(5, 105, Arrays.asList(productos.get(0)), LocalDate.of(2024, 9, 5), estadosOrden.get(0)));
    }

    // Método para obtener todas las órdenes de compra
    @GetMapping("/ordenesCompra")
    public List<OrdenCompra> listarOrdenesCompra() {
        return ordenesCompra;
    }

    // Método para obtener órdenes de compra por estado
    @GetMapping("/ordenesCompra/porEstado")
    public List<OrdenCompra> obtenerOrdenesPorEstado(@RequestParam String estado) {
        return ordenesCompra.stream()
                            .filter(orden -> orden.getEstadoOrden().getDescripcion().equalsIgnoreCase(estado))
                            .collect(Collectors.toList());
    }

    // Método para obtener todos los productos
    @GetMapping("/productos")
    public List<Producto> listarProductos() {
        return productos;
    }

    // Método para obtener todos los estados de las órdenes
    @GetMapping("/estadosOrden")
    public List<EstadoOrden> listarEstadosOrden() {
        return estadosOrden;
    }
}
