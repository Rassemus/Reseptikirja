package com.example.reseptikirja;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ItemDetailsFragment extends Fragment {

    public ItemDetailsFragment()
    {
        super(R.layout.recipe_list_item);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ImageView ivRecipeImage = view.findViewById(R.id.ivRecipeImage);
        TextView tvRecipeName = view.findViewById(R.id.tvRecipeName);
        TextView tvRecipeText = view.findViewById(R.id.tvRecipeMainText);
        TextView tvRecipeTime = view.findViewById(R.id.tvRecipeTimeRequired);

        String recipeName = getArguments().getString("recipeName");

        Recipe recipe = MainActivity.database.recipeDao().findByName(recipeName);
        if(recipe != null){
            ivRecipeImage.setImageResource(recipe.imageId);
            tvRecipeName.setText(recipe.name);
            tvRecipeText.setText(recipe.mainText);
            tvRecipeTime.setText("" + recipe.timeRequirement + " min");
        }

    }
}