package com.example.dell.listview_fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Songlist extends Fragment
{
    ListView lv;
    String songsname[];


    public Songlist() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_songlist, container, false);

        lv=v.findViewById(R.id.listview);
        songsname = getResources().getStringArray(R.array.songs);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1,songsname);
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                String TempListViewClickedValue = songsname[position].toString();
                Bundle b=new Bundle();
                b.putString("ss",TempListViewClickedValue);
                play p1=new play();
                p1.setArguments(b);
                FragmentManager fm=getFragmentManager();
                FragmentTransaction ft=fm.beginTransaction();
                ft.replace(R.id.main_page,p1);//  ft.add(R.id.main_page,new play());
                ft.addToBackStack("");//use for back (fragment)
                ft.commit();




            }
        });





        return v;

    }

}
