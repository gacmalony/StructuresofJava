package com.example.mvcstructure;

public class Presenter  {
    MVP mvp;
    MainActivity mainActivity;

    public Presenter(MVP mvp) {
        this.mvp = mvp;
    }

    public MyModel GetAppFromModel(){
        return new MyModel("NOW SHOWING WITH MVP STRUCTURE",10000,4);
    }


    // 3- Linkage Between presenter and MainActivity (Calling The interface)
    public void getAppName(){
        mvp.getAppName( GetAppFromModel().getStr());
    }

}
