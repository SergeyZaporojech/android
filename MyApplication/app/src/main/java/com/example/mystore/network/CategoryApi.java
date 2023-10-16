package com.example.mystore.network;

import com.example.mystore.category.dto.CategoryCreateDto;
import com.example.mystore.category.dto.CategoryItemDTO;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface CategoryApi {
    @POST("/api/categories/create")
    public Call<CategoryItemDTO> create (@Body CategoryCreateDto model);
}
