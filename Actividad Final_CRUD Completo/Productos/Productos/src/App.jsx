import React, { useState, useEffect } from "react";
import "./App.css";

const App = () => {
  const [productos, setProductos] = useState([]);
  const [formData, setFormData] = useState({
    IdProducto: "",
    Nombre: "",
    Marca: "",
    Proveedor: "",
    Precio: "",
    Descuento: "",
    Unidad: "",
  });

  // Obtener productos
  const obtenerProductos = async () => {
    const res = await fetch("http://localhost:3000/productos");
    const data = await res.json();
    setProductos(data);
  };

  // Manejar cambios en el formulario
  const manejarCambio = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  // Agregar producto
  const agregarProducto = async () => {
    await fetch("http://localhost:3000/productos", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(formData),
    });
    obtenerProductos();
  };

  // Modificar producto
  const modificarProducto = async () => {
    await fetch(`http://localhost:3000/productos/${formData.IdProducto}`, {
      method: "PUT",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(formData),
    });
    obtenerProductos();
  };

  // Eliminar producto
  const eliminarProducto = async () => {
    await fetch(`http://localhost:3000/productos/${formData.IdProducto}`, {
      method: "DELETE",
    });
    obtenerProductos();
  };

  useEffect(() => {
    obtenerProductos();
  }, []);

  return (
  <div>
    <div className="navbar">SUPER PC GAMING STORE</div>

  <div className="container">
  <h2>REGISTRO DE INVENTARIO DE LA TIENDA</h2>

  <div className="input-container">
    <input type="number" name="IdProducto" placeholder="ID" onChange={manejarCambio} />
    <input type="text" name="Nombre" placeholder="Nombre" onChange={manejarCambio} />
    <input type="text" name="Marca" placeholder="Marca" onChange={manejarCambio} />
    <input type="text" name="Proveedor" placeholder="Proveedor" onChange={manejarCambio} />
    <input type="number" name="Precio" placeholder="Precio" onChange={manejarCambio} />
    <input type="number" name="Descuento" placeholder="Descuento" onChange={manejarCambio} />
    <input type="number" name="Unidad" placeholder="Unidad" onChange={manejarCambio} />
  </div>

  <div className="button-container">
    <button onClick={agregarProducto}>Agregar</button>
    <button onClick={modificarProducto}>Modificar</button>
    <button onClick={eliminarProducto}>Eliminar</button>
    <button onClick={obtenerProductos}>Consultar</button>
  </div>
</div>


    <h2>Lista de Productos</h2>
    <div className="product-list">
      {productos.map((producto) => (
        <div key={producto.IdProducto} className="product-card">
          <img src="https://via.placeholder.com/150" alt="Producto" />
          <h3>{producto.Nombre}</h3>
          <p>Marca: {producto.Marca}</p>
          <p>Proveedor: {producto.Proveedor}</p>
          <p>Precio: ${producto.Precio}</p>
        </div>
      ))}
    </div>
  </div>
);
};

export default App;
