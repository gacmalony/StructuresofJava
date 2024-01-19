package com.example.mvcstructure;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyMVVMST extends ViewModel {

    MutableLiveData<String> mutableLiveData = new MutableLiveData<>();



    private MyModel getDat(){
        MyModel mein = new MyModel("MVVM STRUCTURE", 10000, 4);
        return mein;

    }
    public void getspecificData(){
        String str = getDat().getStr();
        mutableLiveData.setValue(str);
    }

}
