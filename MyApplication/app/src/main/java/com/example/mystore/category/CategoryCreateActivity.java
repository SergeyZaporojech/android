package com.example.mystore.category;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;

import com.example.mystore.MainActivity;
import com.example.mystore.R;
import com.example.mystore.category.dto.CategoryCreateDto;
import com.example.mystore.category.dto.CategoryItemDTO;
import com.example.mystore.service.ApplicationNetwork;
import com.google.android.material.textfield.TextInputLayout;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoryCreateActivity extends AppCompatActivity {

    private TextInputLayout tfCategoryName;
    private TextInputLayout tfCategoryImage;
    private TextInputLayout tfCategoryDescription;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_create);
        tfCategoryName= findViewById(R.id.tfCategoryName);
        tfCategoryImage= findViewById(R.id.tfCategoryImage);
        tfCategoryDescription= findViewById(R.id.tfCategoryDescription);
    }

    public  void onClickAddCategory (View view)
    {
        String name = tfCategoryName.getEditText().getText().toString();
        String image = tfCategoryImage.getEditText().getText().toString();
        String description = tfCategoryDescription.getEditText().getText().toString();

       Log.d("myapp", "on click button");
       Log.d("name", "Name: " + name);
       Log.d("image", "Image: " + image);
       Log.d("description", "Description: " + description);


        CategoryCreateDto dto = new CategoryCreateDto();
        dto.setName(name);
        dto.setImage(image);
        dto.setDescription(description);
        ApplicationNetwork.getInstance()
                .getCategory()
                .create(dto)
                .enqueue(new Callback<CategoryItemDTO>() {
                    @Override
                    public void onResponse(Call<CategoryItemDTO> call, Response<CategoryItemDTO> response) {
                        if (response.isSuccessful()){
                            CategoryItemDTO result = response.body();
                            Log.i("myapp", "Create category id = " + result.getId());}
                            Intent intent = new Intent(CategoryCreateActivity.this, MainActivity.class);
                            startActivity(intent);
                            finish();

                    }

                    @Override
                    public void onFailure(Call<CategoryItemDTO> call, Throwable t) {

                    }
                });
    }
}