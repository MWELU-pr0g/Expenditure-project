package com.cmutinda.expenditure;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity implements ExpenditureList.OnDbOpListener {
public static FragmentManager fragmentManager;

  ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





        if (findViewById(R.id.frag_container) != null) {

            if (savedInstanceState != null) ;
            {


                fragmentManager = getSupportFragmentManager();
                FragmentTransaction transaction = fragmentManager.beginTransaction();

                ExpenditureList expenditureList = new ExpenditureList();
                transaction.add(R.id.frag_container, expenditureList, null).commit();

                return;
            }

        }}

    @Override
    public void dbOpPerformed(int method) {

    }
}
