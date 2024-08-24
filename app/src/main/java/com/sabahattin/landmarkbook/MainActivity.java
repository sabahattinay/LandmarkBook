package com.sabahattin.landmarkbook;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.sabahattin.landmarkbook.databinding.ActivityMainBinding;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class MainActivity extends AppCompatActivity {



    ArrayList<Landmark> landmarksArraylist;
    private ActivityMainBinding binding;
    static Landmark chosenLandmark;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        landmarksArraylist = new ArrayList<>();

        //Data
        Landmark pisa = new Landmark("Pisa", "Italy", "The Leaning Tower of Pisa (Italian: torre pendente di Pisa), or simply the Tower of Pisa (torre di Pisa), is the campanile, or freestanding bell tower, of Pisa Cathedral. It is known for its nearly four-degree lean, the result of an unstable foundation. The tower is one of three structures in the Pisa's Cathedral Square (Piazza del Duomo), which includes the cathedral and Pisa Baptistry. ", R.drawable.italypisa);
        Landmark eiffel = new Landmark("Eiffel", "France", "The Eiffel Tower (French: Tour Eiffel) is a wrought-iron lattice tower on the Champ de Mars in Paris, France. It is named after the engineer Gustave Eiffel, whose company designed and built the tower from 1887 to 1889. ", R.drawable.eiffeltower);
        Landmark colosseum = new Landmark("Colosseum", "France", "The Colosseum (Italian: Colosseo) is an elliptical amphitheatre in the centre of the city of Rome, Italy, just east of the Roman Forum. It is the largest ancient amphitheatre ever built, and is still the largest standing amphitheatre in the world, despite its age. Construction began under the Emperor Vespasian  in 72 and was completed in AD 80 under his successor and heir, Titus.", R.drawable.colosseum);
        Landmark londonBridge = new Landmark("London Bridge", "United Kingdom", "The name London Bridge refers to several historic crossings that have spanned the River Thames between the City of London and Southwark, in central London since Roman times. The current crossing, which opened to traffic in 1973, is a box girder bridge built from concrete and steel. It replaced a 19th-century stone-arched bridge, which in turn superseded a 600-year-old stone-built medieval structure." ,R.drawable.londonbridge);

        landmarksArraylist.add(pisa);
        landmarksArraylist.add(eiffel);
        landmarksArraylist.add(colosseum);
        landmarksArraylist.add(londonBridge);


        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        LandmarkAdapter landmarkAdapter = new LandmarkAdapter(landmarksArraylist);
        binding.recyclerView.setAdapter(landmarkAdapter);

/*
        //Adapter
         //Listview
         //mapping


        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,
                landmarksArraylist.stream().map(landmark -> landmark.name).collect(Collectors.toList())
        );
        binding.listView.setAdapter(arrayAdapter);


        binding.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Toast.makeText(MainActivity.this,landmarksArraylist.get(i).name, Toast.LENGTH_LONG).show();
                Intent intent = new Intent(MainActivity.this,DetailsActivity.class);

                intent.putExtra("landmark", landmarksArraylist.get(i));

            }


        });


 */



 

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }






}