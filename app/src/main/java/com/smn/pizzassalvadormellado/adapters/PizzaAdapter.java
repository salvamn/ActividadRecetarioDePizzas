package com.smn.pizzassalvadormellado.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.TooltipCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.tooltip.TooltipDrawable;
import com.smn.pizzassalvadormellado.R;
import com.smn.pizzassalvadormellado.models.Pizza;

import java.util.ArrayList;

public class PizzaAdapter extends RecyclerView.Adapter<PizzaAdapter.ViewHolder> {
    ArrayList<Pizza> listaRecetasPizzas;

    public PizzaAdapter(ArrayList<Pizza> pizzas){
        this.listaRecetasPizzas = pizzas;
    }

    @NonNull
    @Override
    public PizzaAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pizza, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PizzaAdapter.ViewHolder holder, int position) {
        holder.cargar(listaRecetasPizzas.get(position));
    }

    @Override
    public int getItemCount() {
        return listaRecetasPizzas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nombreReceta, precioReceta, ingredientePrincipal, ingredienteBase;
        ImageView imgCebolla, imgChampinion, imgMorron, imgTomate, imgTomateCherry, imgPalta,
                imgAjo, imgAlbaca, imgOregano;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.nombreReceta = itemView.findViewById(R.id.nombreReceta);
            this.precioReceta = itemView.findViewById(R.id.txtPrecio);

            this.ingredientePrincipal = itemView.findViewById(R.id.ingredientePrincipal);
            this.ingredienteBase = itemView.findViewById(R.id.basePizza);

            this.imgCebolla = itemView.findViewById(R.id.imgCebolla);
            this.imgChampinion = itemView.findViewById(R.id.imgChampinion);
            this.imgMorron = itemView.findViewById(R.id.imgMorron);
            this.imgTomate = itemView.findViewById(R.id.imgTomate);
            this.imgTomateCherry = itemView.findViewById(R.id.imgTomateCherry);
            this.imgPalta = itemView.findViewById(R.id.imgPalta);

            this.imgAjo = itemView.findViewById(R.id.imgAjo);
            this.imgAlbaca = itemView.findViewById(R.id.imgAlbaca);
            this.imgOregano = itemView.findViewById(R.id.imgOregano);
        }


        // Done: Terminar metodo que cargara los widgets con informacion.
        // DONE: Arreglar bug con el precio de la pizza.
        // TODO: Optimizar metodo.
        public void cargar(Pizza pizza){
            clickImg(imgCebolla, "No agrega");
            clickImg(imgChampinion, "No agrega");
            clickImg(imgMorron, "No agrega");
            clickImg(imgTomate, "No agrega");
            clickImg(imgTomateCherry, "No agrega");
            clickImg(imgPalta, "No agrega");

            clickImg(imgAjo, "No agrega");
            clickImg(imgAlbaca, "No agrega");
            clickImg(imgOregano, "No agrega");

            nombreReceta.setText("Receta: " + pizza.getNombrePizza());
            precioReceta.setText("$" + pizza.getPrecioPizza());
            ingredientePrincipal.setText("Ingrediente principal: " + pizza.getIngredientePrincipal());
            ingredienteBase.setText("Base de la pizza: " + pizza.getBasePizza());

            // Ingredientes Generales.
            if(pizza.isCebolla()){
                imgCebolla.setImageResource(R.drawable.cebolla);
                clickImg(imgCebolla, "Cebolla");
            }
            if(pizza.isChampinion()){
                imgChampinion.setImageResource(R.drawable.champinion);
                clickImg(imgChampinion, "Champiñon");
            }
            if(pizza.isMorron()){
                imgMorron.setImageResource(R.drawable.morron);
                clickImg(imgMorron, "Morron");
            }
            if(pizza.isTomateCherry()){
                imgTomateCherry.setImageResource(R.drawable.tomate_cherry);
                clickImg(imgTomateCherry, "Tomate Cherry");
            }
            if(pizza.isTomate()){
                imgTomate.setImageResource(R.drawable.tomate);
                clickImg(imgTomate, "Tomate");
            }
            if(pizza.isPalta()){
                imgPalta.setImageResource(R.drawable.palta);
                clickImg(imgPalta, "Palta");
            }

            // Igredientes tipo Aliño.
            if(pizza.isAjo()){
                imgAjo.setImageResource(R.drawable.ajo);
                clickImg(imgAjo, "Ajo");
            }
            if(pizza.isAlbaca()){
                imgAlbaca.setImageResource(R.drawable.albaca);
                clickImg(imgAlbaca, "Albaca");
            }
            if(pizza.isOregano()){
                imgOregano.setImageResource(R.drawable.oregano);
                clickImg(imgOregano, "Oregano");
            }
        }


        // DONE: Metodo que muestre un toast y el nombre del ingrediente cuando se le de click a la imageView.
        public void clickImg(ImageView imgIngrediente, String nombreIngrediente){
            View.OnClickListener clk = new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(imgIngrediente.getContext(), nombreIngrediente, Toast.LENGTH_SHORT).show();
                }
            };
            imgIngrediente.setOnClickListener(clk);
        }

    }
}
