package com.smn.pizzassalvadormellado;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.smn.pizzassalvadormellado.adapters.PizzaAdapter;
import com.smn.pizzassalvadormellado.models.Pizza;

import java.util.ArrayList;

public class recetasDisponibles extends AppCompatActivity {
    RecyclerView reclicerPizzas;
    public static ArrayList<Pizza> listaPizzas = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recetas_disponibles);

        this.reclicerPizzas = findViewById(R.id.reciclerPizzas);
        this.reclicerPizzas.setLayoutManager(new LinearLayoutManager(recetasDisponibles.this));

        /*
        listaPizzas.add(new Pizza(
                "Pizza a lo pobre", "Carne", "Blanca", true,
                false,false,false,false,false,false,false,
                true, 2500));
        listaPizzas.add(new Pizza(
                "Pizza a lo rico", "Mixto", "Blanca", true,
                true,true,true,true,true,true,true,
                true, 10000));
         */
        reclicerPizzas.setAdapter(new PizzaAdapter(listaPizzas));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.mi_menu, menu);
        return true;
    }

    // Detecta el item seleccionado del menu y realiza la accion correspondiente.
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.menuCrearReceta){
            Intent intentCrearReceta = new Intent(recetasDisponibles.this, MainActivity.class);
            startActivity(intentCrearReceta);
            return true;
        }
        if(item.getItemId() == R.id.menuRecetasDisponibles){
            Intent intentRecetasDisponibles = new Intent(recetasDisponibles.this, recetasDisponibles.class);
            startActivity(intentRecetasDisponibles);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}