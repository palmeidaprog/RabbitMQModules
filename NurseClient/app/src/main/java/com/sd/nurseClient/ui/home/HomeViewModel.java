package com.sd.nurseClient.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }

    public ArrayList<String> loadTableData() {
        ArrayList <String> data = new ArrayList<>();
        data.add("João");
        data.add("Cleyton");
        data.add("Jonas");
        data.add("Maurio");
        data.add("Carlos");
        data.add("Maria");
        data.add("João");
        data.add("Cleyton");
        data.add("Jonas");
        data.add("Maurio");
        data.add("Carlos");
        data.add("Maria");
        data.add("João");
        data.add("Cleyton");
        data.add("Jonas");
        data.add("Maurio");
        data.add("Carlos");
        data.add("Maria");
        return data;
    }
}