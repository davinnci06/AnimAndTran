package com.example.animandtran;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private FragmentManager fragmentManager;
    private Fragment fragmentA;
    private Fragment fragmentB;
    private Fragment frag_home;
    private Animation fadeOut;
    private Animation fadeIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Realizar el enlace de del titulo
        TextView TView = findViewById(R.id.titulo);
        // Cargar la animación de desvanecimiento
        Animation anim1 = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
        // Iniciar la animación del Titulo
        TView.startAnimation(anim1);


        // Inicializar los fragmentos
        fragmentA = new AFragment();
        fragmentB = new BFragment();

        // Obtener el administrador de fragmentos
        fragmentManager = getSupportFragmentManager();

        // Obtener las referencias a los botones
        Button botonA = findViewById(R.id.btn_fragment_a);
        Button botonB = findViewById(R.id.btn_fragment_b);

        //Añadir la animacion de los botones
        botonA.startAnimation(anim1);
        botonB.startAnimation(anim1);


        // Configurar el evento onClick para el botón A
        botonA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToFragmentA(v);
            }
        });

        // Configurar el evento onClick para el botón B
        botonB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToFragmentB(v);
            }
        });
    }
    // Método para cambiar al Fragmento A
    private void showFragmentA(Fragment fragment) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.setCustomAnimations(R.anim.slide_in_right,0); // Aplicar animaciones de desvanecimiento
        transaction.replace(R.id.fragment_container, fragment);
        transaction.commit();
    }

    // Método para cambiar al Fragmento B
    private void showFragmentB(Fragment fragment) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.setCustomAnimations(R.anim.slide_in_right, 0); // Aplicar animación de desplazamiento horizontal al Fragmento B
        transaction.replace(R.id.fragment_container, fragment);
        transaction.commit();
    }
    // Evento para cambiar al Fragmento B
    public void goToFragmentB(View view) {
        showFragmentB(fragmentB);
    }

    // Evento para cambiar al Fragmento A
    public void goToFragmentA(View view) {
        showFragmentA(fragmentA);
    }
}