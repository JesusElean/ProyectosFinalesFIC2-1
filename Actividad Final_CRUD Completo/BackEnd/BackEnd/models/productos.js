const { DataTypes } = require('sequelize');
const sequelize = require('../conexion');

const Producto = sequelize.define('Producto', {
    IdProducto: { type: DataTypes.INTEGER, primaryKey: true, autoIncrement: true },
    Nombre: { type: DataTypes.STRING},
    Marca: { type: DataTypes.STRING },
    Proveedor: { type: DataTypes.STRING },
    Precio: { type: DataTypes.FLOAT },
    Descuento: { type: DataTypes.FLOAT },
    Unidad: { type: DataTypes.INTEGER },
},
{
    tableName: 'TablaProductos',
    timestamps: false,
});

module.exports = Producto;