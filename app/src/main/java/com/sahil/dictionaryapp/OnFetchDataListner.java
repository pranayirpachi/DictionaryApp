package com.sahil.dictionaryapp;

import com.sahil.dictionaryapp.Models.APIResponse;

public interface OnFetchDataListner {
    void onFetchData(APIResponse apiResponse, String message) ;

    void onError(String message);

    void onErrorData(String message);
}
