package com.example.fruteriarancholopezapp;

import android.app.ActivityOptions;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.common.api.ApiException;


public class MainActivity extends AppCompatActivity {

    private static final int RC_SIGN_IN = 9001;
    private GoogleSignInClient googleSignInClient;
    private EditText etNombreUsuario, etContrasena;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        etNombreUsuario = findViewById(R.id.eTEmailUsuario);
        etContrasena = findViewById(R.id.eTContraseña);
        SharedPreferences sharedPreferences = getSharedPreferences("UserData", MODE_PRIVATE);
        String nombreGuardado = sharedPreferences.getString("nombre", "");
        String passwordGuardado = sharedPreferences.getString("password", "");
        if (!nombreGuardado.isEmpty()) {
            etNombreUsuario.setText(nombreGuardado);
        }
        if (!passwordGuardado.isEmpty()) {
            etContrasena.setText(passwordGuardado);
        }

        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken("364531119454-0dmodbiq439pi9u7ml3ltqujkhg3n7v0.apps.googleusercontent.com")
                .requestEmail()
                .build();

        googleSignInClient = GoogleSignIn.getClient(this, gso);

        SesionUsuario sesionUsuario = new SesionUsuario(this);
        if (sesionUsuario.obtenerEmail() != null) {
            Intent intent = new Intent(this, MenuPrincipal.class);
            startActivity(intent);
            finish();
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.mainProductos), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void onInicioSesion(View view) {
        Intent signInIntent = googleSignInClient.getSignInIntent(); // Se usa la instancia global
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }
    public void onIniciarSesion(View view) {
        String inputNombre = etNombreUsuario.getText().toString().trim();
        String inputPassword = etContrasena.getText().toString().trim();

        SharedPreferences sharedPreferences = getSharedPreferences("UserData", MODE_PRIVATE);
        String nombreGuardado = sharedPreferences.getString("nombre", "");
        String passwordGuardado = sharedPreferences.getString("password", "");

        if (inputNombre.equals(nombreGuardado) && inputPassword.equals(passwordGuardado)) {
            Toast.makeText(this, "¡Bienvenido " + inputNombre + "!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, MenuPrincipal.class);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(this, "Error: usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();
        }
    }

    public void onRegistrarCuenta(View view) {
        Intent intent = new Intent(this, RegistrarCuenta.class);
        startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(this).toBundle());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }
    }

    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);
            if (account != null) {
                SesionUsuario sesionUsuario = new SesionUsuario(this);
                sesionUsuario.guardarUsuario(account.getDisplayName(), account.getEmail(), account.getId());

                Intent intent = new Intent(this, MenuPrincipal.class);
                startActivity(intent);
                finish();
            }
        } catch (ApiException e) {
            Log.w("GoogleSignIn", "Error en el inicio de sesión: " + e.getStatusCode());
        }
    }


    public void onSalirApp(View view) {
        finish();
    }
}
