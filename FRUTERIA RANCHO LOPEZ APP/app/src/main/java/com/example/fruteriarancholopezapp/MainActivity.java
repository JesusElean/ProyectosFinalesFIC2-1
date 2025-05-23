package com.example.fruteriarancholopezapp;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.util.Log;

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

    private static final int RC_SIGN_IN = 9001; // Corregido
    private GoogleSignInClient googleSignInClient; // Variable global

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        // Configuración de Google Sign-In
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken("364531119454-0dmodbiq439pi9u7ml3ltqujkhg3n7v0.apps.googleusercontent.com")
                .requestEmail()
                .build();

        googleSignInClient = GoogleSignIn.getClient(this, gso);

        SesionUsuario sesionUsuario = new SesionUsuario(this);
        if (sesionUsuario.obtenerEmail() != null) {
            // Si hay un usuario guardado, ir directamente a MenuPrincipal
            Intent intent = new Intent(this, MenuPrincipal.class);
            startActivity(intent);
            finish();
        }

        // Ajuste de diseño para evitar solapamiento con barras del sistema
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.mainProductos), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    // Método para iniciar sesión con Google
    public void onInicioSesion(View view) {
        Intent signInIntent = googleSignInClient.getSignInIntent(); // Se usa la instancia global
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);
        }
    }



    //Metodo para capturar los resultados del inicio de sesion con google.
    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);
            if (account != null) {
                SesionUsuario sesionUsuario = new SesionUsuario(this);
                sesionUsuario.guardarUsuario(account.getDisplayName(), account.getEmail(), account.getId());

                // Navegar a MenuPrincipal
                Intent intent = new Intent(this, MenuPrincipal.class);
                startActivity(intent);
                finish();
            }
        } catch (ApiException e) {
            Log.w("GoogleSignIn", "Error en el inicio de sesión: " + e.getStatusCode());
        }
    }


    public void onSalir(View view) {
        finish();
    }
}
