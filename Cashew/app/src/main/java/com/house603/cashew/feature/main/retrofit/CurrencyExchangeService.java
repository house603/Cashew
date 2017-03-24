package com.house603.cashew.feature.main.retrofit;

import com.house603.cashew.model.CurrencyModel;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by tomm on 4/4/16 AD.
 */
public interface CurrencyExchangeService {
    @GET("rates")
    Call<CurrencyModel> loadCurrencyExchange();
}
