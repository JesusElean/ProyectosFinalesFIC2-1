package com.example.fruteriarancholopezapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

public class BasesDeDatosSQLite extends SQLiteOpenHelper {

    public BasesDeDatosSQLite(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        // Tabla de Productos
            db.execSQL("CREATE TABLE producto ( \n" +
                    "ID_Producto INTEGER PRIMARY KEY AUTOINCREMENT, \n" +
                    "Nombre TEXT NOT NULL, \n" +
                    "Precio REAL NOT NULL, \n" +
                    "Stock INTEGER NOT NULL, \n" +
                    "Unidad TEXT NOT NULL "+ ");");

        // Tabla de Venta
            db.execSQL("CREATE TABLE Venta ( \n " +
                "ID_Venta INTEGER PRIMARY KEY AUTOINCREMENT, \n " +
                "Fecha TEXT NOT NULL, \n " +
                "Total REAL NOT NULL, \n " +
                "ID_Cliente INTEGER NOT NULL, \n " +
                "Tipo_Pago TEXT NOT NULL, \n " +
                    "FOREIGN KEY (ID_Cliente) REFERENCES Cliente(ID_Cliente) );");

        // Tabla de Detalle_Venta
          db.execSQL("CREATE TABLE Detalle_Venta ( \n " +
                "ID_Detalle INTEGER PRIMARY KEY AUTOINCREMENT, \n " +
                "ID_Venta INTEGER NOT NULL, \n " +
                "ID_Producto INTEGER NOT NULL, \n " +
                "Cantidad INTEGER NOT NULL, \n " +
                "Subtotal REAL NOT NULL, \n " +
                "FOREIGN KEY (ID_Venta) REFERENCES Venta(ID_Venta), \n " +
                "FOREIGN KEY (ID_Producto) REFERENCES Producto(ID_Producto) );");

        // Tabla de Cliente
         db.execSQL("CREATE TABLE Cliente ( \n " +
                "ID_Cliente INTEGER PRIMARY KEY AUTOINCREMENT, \n " +
                "Nombre TEXT NOT NULL, \n " +
                "Telefono TEXT NOT NULL, \n " +
                "Saldo_Pendiente REAL NOT NULL );");

        // Tabla de Pago_Credito
         db.execSQL("CREATE TABLE Pago_Credito ( \n " +
                "ID_Pago INTEGER PRIMARY KEY AUTOINCREMENT, \n " +
                "ID_Cliente INTEGER NOT NULL, \n " +
                "Fecha_Pago TEXT NOT NULL, \n " +
                "Monto REAL NOT NULL, \n " +
                "FOREIGN KEY (ID_Cliente) REFERENCES Cliente(ID_Cliente) );");

        // Tabla de Usuario
        db.execSQL("CREATE TABLE Usuario ( \n " +
                "ID_Usuario INTEGER PRIMARY KEY AUTOINCREMENT, \n " +
                "Nombre TEXT NOT NULL, \n " +
                "Rol TEXT NOT NULL, \n " +
                "Contrasena TEXT NOT NULL );");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS producto");
        db.execSQL("DROP TABLE IF EXISTS Venta");
        db.execSQL("DROP TABLE IF EXISTS Detalle_Venta");
        db.execSQL("DROP TABLE IF EXISTS Cliente");
        db.execSQL("DROP TABLE IF EXISTS Pago_Credito");
        db.execSQL("DROP TABLE IF EXISTS Usuario");
        onCreate(db);
    }
}
