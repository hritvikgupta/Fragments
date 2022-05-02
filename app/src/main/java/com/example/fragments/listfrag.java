package com.example.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;
import java.util.*;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;


//Originally extends Fragment is written here, but we have written
//ListFragments as list are generally used with fragments so a class is predefined or created for fragments
public class listfrag extends ListFragment {

    ItemsSelected activity;
    //used this to connect to the detail fragments
    //Like a class, a Interface can have methods and variables, but the methods declared in an interface are by default abstract (only method signature, no body).
    //Interfaces are a collection of constants, methods(abstract, static, and default), and nested types. All the methods of the interface need to be defined in the class. The interface is like a Class. The interface keyword is used to declare an interface.

    public interface ItemsSelected {
        void OnItemSelected(int index);

    }
    public listfrag() {
        // Required empty public constructor
    }
    //onAttach is used when fragement is associated with the main activity
    //here context is the link that is attaching frgment to the main activity
    @Override
    public void onAttach(Context context){
        super.onAttach(context);

        //this mathod communicate to the main activity
         //Therefore, we use the context to do se

         activity = (ItemsSelected) context;


     }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ArrayList<String> data = new ArrayList<String>();
        data.add("This is item 1:");
        data.add("This is item 2:");
        data.add("This is item 3: ");

        //This getActivity() get all the data from this fragment and pass it over here
        //it is similar to this, or this.MainActivity
        setListAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, data));


    }



    @Override
    public void onListItemClick(@NonNull ListView l, @NonNull View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        //By clicking the items on the list it should communicate something
        //so for that we uses the position of items selected
        //here onitemselected contacts to the main activity using the activity variable we have created that
        // connects to the context in onAttach button to connect it to main activity
        //in Main activity onItemSelected takes an int index that we  have created above in interface as well in main activity
        activity.OnItemSelected(position);


    }
}
