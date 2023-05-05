package com.example.mobileproject;



import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import java.util.ArrayList;

public class recycle extends AppCompatActivity implements RecyclerViewInterface {
    ImageView merc;
    Adapter adapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle);

        System.out.println(R.drawable.background);

        recyclerView = findViewById(R.id.recycler1);
        adapter = new Adapter(getinfo(), this, this);
        recyclerView.setAdapter(adapter);

    }

    private ArrayList<Model> getinfo() {
        ArrayList<Model> content = new ArrayList<>();

        content.add(new Model(getString(R.string.merc), R.drawable.mercedes, getString(R.string.available), "This is Mercedes 2020 , its one of the kind in the middle east"));
        content.add(new Model(getString(R.string.kia), R.drawable.kia, getString(R.string.available), "This is KIA, its one of the kind in the middle east"));
        content.add(new Model(getString(R.string.verna), R.drawable.verna, getString(R.string.out), "This is Verna, its one of the kind in the middle east"));
        content.add(new Model(getString(R.string.logan), R.drawable.logan, getString(R.string.available), "This is Logan, its one of the kind in the middle east"));
        content.add(new Model(getString(R.string.pegu), R.drawable.peugeut, getString(R.string.available), "This is Peugeot, its one of the kind in the middle east"));
        content.add(new Model(getString(R.string.tesla), R.drawable.tesla, getString(R.string.soon), "This is Tesla, its one of the kind in the middle east"));
        return content;
    }


    @Override
    public void onItemClick(int position) {
        Intent intent = new Intent(recycle.this, details.class);
        intent.putExtra("merc", getinfo().get(position).image);
        intent.putExtra("name", getinfo().get(position).name);

        startActivity(intent);
    }

    @Override
    public void onBack() {

        recycle.this.finish();
        System.exit(0);
    }


}
