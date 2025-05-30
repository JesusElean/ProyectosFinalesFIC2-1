const express = require('express');
const bodyParser = require('body-parser');
const productos = require('./models/productos');
const puerto = 3000;

const app = express();
app.use(bodyParser.json());

app.listen(puerto, () => {
    console.log('Servicio iniciado en el puerto', puerto);
});

const cors = require("cors");
app.use(cors());

// Create
app.post('/productos', async (req, res) => {
    try {
        const { Nombre, Marca, Proveedor, Precio, Descuento, Unidad } = req.body;
        const data = await productos.create({ Nombre, Marca, Proveedor, Precio, Descuento, Unidad });
        res.status(201).send(data);
    } catch (error) {
        console.error(error);
        res.status(500).send({ mensaje: 'Error al crear producto', error });
    }
});

// Read
app.get('/productos', async (req, res) => {
    try {
        const data = await productos.findAll();
        res.status(200).send(data);
    } catch (error) {
        console.error(error);
        res.status(500).send({ mensaje: 'Error al obtener productos', error });
    }
});

// Update
app.put('/productos/:IdProducto', async (req, res) => {
    try {
        const { Nombre, Marca, Proveedor, Precio, Descuento, Unidad } = req.body;
        const { IdProducto } = req.params;
        const data = await productos.update(
            { Nombre, Marca, Proveedor, Precio, Descuento, Unidad },
            { where: { IdProducto } }
        );
        res.status(200).send(data);
    } catch (error) {
        console.error(error);
        res.status(500).send({ mensaje: 'Error al actualizar producto', error });
    }
});

// Delete
app.delete('/productos/:IdProducto', async (req, res) => {
    try {
        const { IdProducto } = req.params;
        const data = await productos.destroy({ where: { IdProducto } });
        res.status(200).send({ mensaje: 'Producto eliminado', resultado: data });
    } catch (error) {
        console.error(error);
        res.status(500).send({ mensaje: 'Error al eliminar producto', error });
    }
});
