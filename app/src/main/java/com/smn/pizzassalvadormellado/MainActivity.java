package com.smn.pizzassalvadormellado;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.smn.pizzassalvadormellado.models.Pizza;

public class MainActivity extends AppCompatActivity {
    RadioButton rbtCarne, rbtPollo, rbtMixto, rbtRoja, rbtBlanca;
    CheckBox chkCebolla, chkChampiniones, chkMorron, chkTomate, chkTomateCherry, chkPalta, chkAjo, chkAlbaca, chkOregano;
    EditText nombreReceta;
    Button btnGuardarReceta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Enlazamos las variables con los widgets.
        nombreReceta = findViewById(R.id.cajaNombreReceta);

        rbtCarne = findViewById(R.id.rdbCarne);
        rbtPollo = findViewById(R.id.rdbPollo);
        rbtMixto = findViewById(R.id.rdbMixto);

        rbtBlanca = findViewById(R.id.rdbBlanca);
        rbtRoja = findViewById(R.id.rdbRoja);

        chkCebolla = findViewById(R.id.chkCebolla);
        chkChampiniones = findViewById(R.id.chkChampinon);
        chkMorron = findViewById(R.id.chkMorron);
        chkTomate = findViewById(R.id.chkTomate);
        chkTomateCherry = findViewById(R.id.chkTomateCherry);
        chkPalta = findViewById(R.id.chkPalta);

        chkAjo = findViewById(R.id.chkAjo);
        chkAlbaca = findViewById(R.id.chkAlbana);
        chkOregano = findViewById(R.id.chkOregano);

        // TODO: El boton debe verificar y guardar la informacion
        btnGuardarReceta = findViewById(R.id.btnGuardarReceta);
        btnGuardarReceta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(verificarSeleccionIngredientes()){
                    Pizza pizza = new Pizza();
                    pizza.setNombrePizza(nombreReceta.getText().toString());

                    // Ingrediente principal
                    if(rbtCarne.isChecked())
                        pizza.setIngredientePrincipal("Carne");
                    else if(rbtPollo.isChecked())
                        pizza.setIngredientePrincipal("Pollo");
                    else if(rbtMixto.isChecked())
                        pizza.setIngredientePrincipal("Mixto");
                    else
                        pizza.setIngredientePrincipal("Nada");

                    // Ingrediente base de la pizza
                    pizza.setBasePizza(rbtRoja.isChecked() ? "Roja":"Blanca");

                    // Ingredientes generales
                    pizza.setCebolla(chkCebolla.isChecked());
                    pizza.setChampinion(chkChampiniones.isChecked());
                    pizza.setMorron(chkMorron.isChecked());
                    pizza.setTomate(chkTomate.isChecked());
                    pizza.setTomateCherry(chkTomateCherry.isChecked());
                    pizza.setPalta(chkPalta.isChecked());

                    // Aliños
                    pizza.setAjo(chkAjo.isChecked());
                    pizza.setAlbaca(chkAlbaca.isChecked());
                    pizza.setOregano(chkOregano.isChecked());

                    // Precio de la pizza
                    int precio = precioPizza(pizza);
                    pizza.setPrecioPizza(precio);

                    recetasDisponibles.listaPizzas.add(pizza);

                    Toast.makeText(MainActivity.this, "Receta creada con exito", Toast.LENGTH_LONG).show();

                    reiniciarReceta();
                }

            }
        });
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
            Intent intentCrearReceta = new Intent(MainActivity.this, MainActivity.class);
            startActivity(intentCrearReceta);
            return true;
        }
        if(item.getItemId() == R.id.menuRecetasDisponibles){
            Intent intentRecetasDisponibles = new Intent(MainActivity.this, recetasDisponibles.class);
            startActivity(intentRecetasDisponibles);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    // DONE: Modificar metodo precioPizza.
    public int precioPizza(Pizza pizza){
        // Precio base de $500, ya que la base de la pizza independientemente de la opcion tiene un valor de $500 y es
        // una opcion obligatoria.
        int valorPizza = 500;

        // DONE: Si la receta es vegana estos ingredientes deberian ser opcionales y no obligatorios.
        if(pizza.getIngredientePrincipal().equals("Carne") || pizza.getIngredientePrincipal().equals("Pollo")){
            valorPizza += 1500;
        }else if(pizza.getIngredientePrincipal().equals("Mix")){
            valorPizza += 2000;
        }

        boolean[] listaIngredientesPizza = {
                pizza.isCebolla(), pizza.isChampinion(), pizza.isMorron(), pizza.isTomate(),
                pizza.isTomateCherry(), pizza.isPalta()
        };
        boolean[] listaAliniosPizza = {pizza.isAjo(), pizza.isAlbaca(), pizza.isOregano()};

        for(boolean ingrediente: listaIngredientesPizza){
            if(ingrediente){
                valorPizza += 1000;
            }
        }
        for(boolean alinio: listaAliniosPizza){
            if(alinio){
                valorPizza += 500;
            }
        }
        return valorPizza;
    }

    /*
    DONE: Metodo que permite verificar que los radoiButtons estan marcados y que la receta tenga un nombre valido.
    DONE: En caso de que la receta vegana no se deberia verificar el ingrediente principal.
    DONE: Verificar que el radiobuton base de la pizza este marcado.
     */
    public boolean verificarSeleccionIngredientes(){

        if(nombreReceta.getText().toString().equals("")){
            Toast.makeText(this, "Ingrese nombre a la receta", Toast.LENGTH_SHORT).show();
            return false;
        }

        else if(!rbtRoja.isChecked() && !rbtBlanca.isChecked()){
            Toast.makeText(this, "Marque la base de la pizza", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    // DONE: Metodo que deseleccione los radiobutton y checkbox y limpie la caja de texto.
    public void reiniciarReceta(){
        nombreReceta.setText("");
        rbtCarne.setChecked(false);
        rbtPollo.setChecked(false);
        rbtMixto.setChecked(false);
        rbtRoja.setChecked(false);
        rbtBlanca.setChecked(false);
        chkCebolla.setChecked(false);
        chkChampiniones.setChecked(false);
        chkMorron.setChecked(false);
        chkTomateCherry.setChecked(false);
        chkPalta.setChecked(false);
        chkAjo.setChecked(false);
        chkAlbaca.setChecked(false);
        chkOregano.setChecked(false);
    }
}