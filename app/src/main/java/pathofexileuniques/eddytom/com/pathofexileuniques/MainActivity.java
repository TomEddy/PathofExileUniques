package pathofexileuniques.eddytom.com.pathofexileuniques;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button all,cat,search,myUniq,amulets,belts,rings,quivers,body,boots,gloves,helmets,shields,axes,bows,claws,daggers,fishing,maces,staves,swords,wands,flasks,jewels,maps,access,armour,weapons;
    private ImageView display,searchdisplay;
    private AutoCompleteTextView search_bar;
    private ArrayAdapter search_adapter;
    private int counter;
    private ArrayList<Unique> allUniques, tempList,savedList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                all.setVisibility(View.VISIBLE);
                cat.setVisibility(View.VISIBLE);
                search.setVisibility(View.VISIBLE);
                myUniq.setVisibility(View.VISIBLE);
                display.setVisibility(View.GONE);
                searchdisplay.setVisibility(View.GONE);
                search_bar.setVisibility(View.GONE);
                search_bar.setText("");

                amulets.setVisibility(View.GONE);
                belts.setVisibility(View.GONE);
                rings.setVisibility(View.GONE);
                quivers.setVisibility(View.GONE);
                body.setVisibility(View.GONE);
                boots.setVisibility(View.GONE);
                gloves.setVisibility(View.GONE);
                helmets.setVisibility(View.GONE);
                shields.setVisibility(View.GONE);
                axes.setVisibility(View.GONE);
                bows.setVisibility(View.GONE);
                claws.setVisibility(View.GONE);
                daggers.setVisibility(View.GONE);
                fishing.setVisibility(View.GONE);
                maces.setVisibility(View.GONE);
                staves.setVisibility(View.GONE);
                swords.setVisibility(View.GONE);
                wands.setVisibility(View.GONE);
                flasks.setVisibility(View.GONE);
                jewels.setVisibility(View.GONE);
                maps.setVisibility(View.GONE);
                access.setVisibility(View.GONE);
                armour.setVisibility(View.GONE);
                weapons.setVisibility(View.GONE);



                counter = 0;
                tempList = null;
                tempList = (ArrayList<Unique>) allUniques.clone();
                display.setImageResource(allUniques.get(0).getImage_Resource());
                // Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                 //       .setAction("Action", null).show();
            }
        });

        all = findViewById(R.id.All_but);
        cat = findViewById(R.id.Catagories_but);
        search = findViewById(R.id.Search_but);
        myUniq = findViewById(R.id.MyUniques_but);
        display = findViewById(R.id.ItemDisplay);
        searchdisplay = findViewById(R.id.searchDisplay);
        search_bar = findViewById(R.id.ItemSearch);
        amulets = findViewById(R.id.amulet_but);
        belts = findViewById(R.id.belt_but);
        rings = findViewById(R.id.ring_but);
        quivers = findViewById(R.id.quiver_but);
        body = findViewById(R.id.body_but);
        boots = findViewById(R.id.boots_but);
        gloves = findViewById(R.id.gloves_but);
        helmets = findViewById(R.id.helmets_but);
        shields = findViewById(R.id.shields_but);
        axes = findViewById(R.id.axes_but);
        bows = findViewById(R.id.bows_but);
        claws = findViewById(R.id.claws_but);
        daggers = findViewById(R.id.daggers_but);
        fishing = findViewById(R.id.fishingrod_but);
        maces = findViewById(R.id.maces_but);
        staves = findViewById(R.id.staves_but);
        swords = findViewById(R.id.swords_but);
        wands = findViewById(R.id.wands_but);
        flasks = findViewById(R.id.flasks_but);
        jewels = findViewById(R.id.jewels_but);
        maps = findViewById(R.id.maps_but);
        access = findViewById(R.id.accessories_but);
        armour = findViewById(R.id.armour_but);
        weapons = findViewById(R.id.weapons_but);
        counter = 0;
        setUp();

        all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                all.setVisibility(View.GONE);
                cat.setVisibility(View.GONE);
                search.setVisibility(View.GONE);
                myUniq.setVisibility(View.GONE);

                display.setVisibility(View.VISIBLE);

            }
        });
//Category set up
        cat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                all.setVisibility(View.GONE);
                cat.setVisibility(View.GONE);
                search.setVisibility(View.GONE);
                myUniq.setVisibility(View.GONE);

                access.setVisibility(View.VISIBLE);
                armour.setVisibility(View.VISIBLE);
                weapons.setVisibility(View.VISIBLE);
                flasks.setVisibility(View.VISIBLE);
                jewels.setVisibility(View.VISIBLE);
                maps.setVisibility(View.VISIBLE);
            }
        });

        access.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                access.setVisibility(View.GONE);
                armour.setVisibility(View.GONE);
                weapons.setVisibility(View.GONE);
                flasks.setVisibility(View.GONE);
                jewels.setVisibility(View.GONE);
                maps.setVisibility(View.GONE);

                amulets.setVisibility(View.VISIBLE);
                belts.setVisibility(View.VISIBLE);
                rings.setVisibility(View.VISIBLE);
                quivers.setVisibility(View.VISIBLE);
            }
        });

        amulets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                amulets.setVisibility(View.GONE);
                belts.setVisibility(View.GONE);
                rings.setVisibility(View.GONE);
                quivers.setVisibility(View.GONE);

                for(int i = 0; i< tempList.size(); i++){
                    if(tempList.get(i).getCategory() != 0 ){
                        tempList.remove(i);
                        i--;
                    }
                }
                display.setImageResource(tempList.get(0).getImage_Resource());
                display.setVisibility(View.VISIBLE);
            }
        });

        belts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                amulets.setVisibility(View.GONE);
                belts.setVisibility(View.GONE);
                rings.setVisibility(View.GONE);
                quivers.setVisibility(View.GONE);

                for(int i = 0; i< tempList.size(); i++){
                    if(tempList.get(i).getCategory() != 1 ){
                        tempList.remove(i);
                        i--;
                    }
                }
                display.setImageResource(tempList.get(0).getImage_Resource());
                display.setVisibility(View.VISIBLE);
            }
        });
        rings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                amulets.setVisibility(View.GONE);
                belts.setVisibility(View.GONE);
                rings.setVisibility(View.GONE);
                quivers.setVisibility(View.GONE);

                for(int i = 0; i< tempList.size(); i++){
                    if(tempList.get(i).getCategory() != 2 ){
                        tempList.remove(i);
                        i--;
                    }
                }
                display.setImageResource(tempList.get(0).getImage_Resource());
                display.setVisibility(View.VISIBLE);
            }
        });
        quivers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                amulets.setVisibility(View.GONE);
                belts.setVisibility(View.GONE);
                rings.setVisibility(View.GONE);
                quivers.setVisibility(View.GONE);

                for(int i = 0; i< tempList.size(); i++){
                    if(tempList.get(i).getCategory() != 3 ){
                        tempList.remove(i);
                        i--;
                    }
                }
                display.setImageResource(tempList.get(0).getImage_Resource());
                display.setVisibility(View.VISIBLE);
            }
        });

        armour.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                access.setVisibility(View.GONE);
                armour.setVisibility(View.GONE);
                weapons.setVisibility(View.GONE);
                flasks.setVisibility(View.GONE);
                jewels.setVisibility(View.GONE);
                maps.setVisibility(View.GONE);

                body.setVisibility(View.VISIBLE);
                boots.setVisibility(View.VISIBLE);
                gloves.setVisibility(View.VISIBLE);
                helmets.setVisibility(View.VISIBLE);
                shields.setVisibility(View.VISIBLE);
            }
        });

        body.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                body.setVisibility(View.GONE);
                boots.setVisibility(View.GONE);
                gloves.setVisibility(View.GONE);
                helmets.setVisibility(View.GONE);
                shields.setVisibility(View.GONE);

                for(int i = 0; i< tempList.size(); i++){
                    if(tempList.get(i).getCategory() != 4 ){
                        tempList.remove(i);
                        i--;
                    }
                }
                display.setImageResource(tempList.get(0).getImage_Resource());
                display.setVisibility(View.VISIBLE);
            }
        });

        boots.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                body.setVisibility(View.GONE);
                boots.setVisibility(View.GONE);
                gloves.setVisibility(View.GONE);
                helmets.setVisibility(View.GONE);
                shields.setVisibility(View.GONE);

                for(int i = 0; i< tempList.size(); i++){
                    if(tempList.get(i).getCategory() != 5 ){
                        tempList.remove(i);
                        i--;
                    }
                }
                display.setImageResource(tempList.get(0).getImage_Resource());
                display.setVisibility(View.VISIBLE);
            }
        });

        gloves.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                body.setVisibility(View.GONE);
                boots.setVisibility(View.GONE);
                gloves.setVisibility(View.GONE);
                helmets.setVisibility(View.GONE);
                shields.setVisibility(View.GONE);

                for(int i = 0; i< tempList.size(); i++){
                    if(tempList.get(i).getCategory() != 6 ){
                        tempList.remove(i);
                        i--;
                    }
                }
                display.setImageResource(tempList.get(0).getImage_Resource());
                display.setVisibility(View.VISIBLE);
            }
        });

        helmets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                body.setVisibility(View.GONE);
                boots.setVisibility(View.GONE);
                gloves.setVisibility(View.GONE);
                helmets.setVisibility(View.GONE);
                shields.setVisibility(View.GONE);

                for(int i = 0; i< tempList.size(); i++){
                    if(tempList.get(i).getCategory() != 7 ){
                        tempList.remove(i);
                        i--;
                    }
                }
                display.setImageResource(tempList.get(0).getImage_Resource());
                display.setVisibility(View.VISIBLE);
            }
        });

        shields.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                body.setVisibility(View.GONE);
                boots.setVisibility(View.GONE);
                gloves.setVisibility(View.GONE);
                helmets.setVisibility(View.GONE);
                shields.setVisibility(View.GONE);

                for(int i = 0; i< tempList.size(); i++){
                    if(tempList.get(i).getCategory() != 8 ){
                        tempList.remove(i);
                        i--;
                    }
                }
                display.setImageResource(tempList.get(0).getImage_Resource());
                display.setVisibility(View.VISIBLE);
            }
        });

        weapons.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                access.setVisibility(View.GONE);
                armour.setVisibility(View.GONE);
                weapons.setVisibility(View.GONE);
                flasks.setVisibility(View.GONE);
                jewels.setVisibility(View.GONE);
                maps.setVisibility(View.GONE);

                axes.setVisibility(View.VISIBLE);
                bows.setVisibility(View.VISIBLE);
                claws.setVisibility(View.VISIBLE);
                daggers.setVisibility(View.VISIBLE);
                fishing.setVisibility(View.VISIBLE);
                maces.setVisibility(View.VISIBLE);
                staves.setVisibility(View.VISIBLE);
                swords.setVisibility(View.VISIBLE);
                wands.setVisibility(View.VISIBLE);
            }
        });

        axes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                axes.setVisibility(View.GONE);
                bows.setVisibility(View.GONE);
                claws.setVisibility(View.GONE);
                daggers.setVisibility(View.GONE);
                fishing.setVisibility(View.GONE);
                maces.setVisibility(View.GONE);
                staves.setVisibility(View.GONE);
                swords.setVisibility(View.GONE);
                wands.setVisibility(View.GONE);

                for(int i = 0; i< tempList.size(); i++){
                    if(tempList.get(i).getCategory() != 9 ){
                        tempList.remove(i);
                        i--;
                    }
                }
                display.setImageResource(tempList.get(0).getImage_Resource());
                display.setVisibility(View.VISIBLE);
            }
        });

        bows.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                axes.setVisibility(View.GONE);
                bows.setVisibility(View.GONE);
                claws.setVisibility(View.GONE);
                daggers.setVisibility(View.GONE);
                fishing.setVisibility(View.GONE);
                maces.setVisibility(View.GONE);
                staves.setVisibility(View.GONE);
                swords.setVisibility(View.GONE);
                wands.setVisibility(View.GONE);

                for(int i = 0; i< tempList.size(); i++){
                    if(tempList.get(i).getCategory() != 10 ){
                        tempList.remove(i);
                        i--;
                    }
                }
                display.setImageResource(tempList.get(0).getImage_Resource());
                display.setVisibility(View.VISIBLE);
            }
        });

        claws.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                axes.setVisibility(View.GONE);
                bows.setVisibility(View.GONE);
                claws.setVisibility(View.GONE);
                daggers.setVisibility(View.GONE);
                fishing.setVisibility(View.GONE);
                maces.setVisibility(View.GONE);
                staves.setVisibility(View.GONE);
                swords.setVisibility(View.GONE);
                wands.setVisibility(View.GONE);

                for(int i = 0; i< tempList.size(); i++){
                    if(tempList.get(i).getCategory() != 11 ){
                        tempList.remove(i);
                        i--;
                    }
                }
                display.setImageResource(tempList.get(0).getImage_Resource());
                display.setVisibility(View.VISIBLE);
            }
        });

        daggers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                axes.setVisibility(View.GONE);
                bows.setVisibility(View.GONE);
                claws.setVisibility(View.GONE);
                daggers.setVisibility(View.GONE);
                fishing.setVisibility(View.GONE);
                maces.setVisibility(View.GONE);
                staves.setVisibility(View.GONE);
                swords.setVisibility(View.GONE);
                wands.setVisibility(View.GONE);

                for(int i = 0; i< tempList.size(); i++){
                    if(tempList.get(i).getCategory() != 12 ){
                        tempList.remove(i);
                        i--;
                    }
                }
                display.setImageResource(tempList.get(0).getImage_Resource());
                display.setVisibility(View.VISIBLE);
            }
        });

        fishing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                axes.setVisibility(View.GONE);
                bows.setVisibility(View.GONE);
                claws.setVisibility(View.GONE);
                daggers.setVisibility(View.GONE);
                fishing.setVisibility(View.GONE);
                maces.setVisibility(View.GONE);
                staves.setVisibility(View.GONE);
                swords.setVisibility(View.GONE);
                wands.setVisibility(View.GONE);

                for(int i = 0; i< tempList.size(); i++){
                    if(tempList.get(i).getCategory() != 13 ){
                        tempList.remove(i);
                        i--;
                    }
                }
                display.setImageResource(tempList.get(0).getImage_Resource());
                display.setVisibility(View.VISIBLE);
            }
        });

        maces.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                axes.setVisibility(View.GONE);
                bows.setVisibility(View.GONE);
                claws.setVisibility(View.GONE);
                daggers.setVisibility(View.GONE);
                fishing.setVisibility(View.GONE);
                maces.setVisibility(View.GONE);
                staves.setVisibility(View.GONE);
                swords.setVisibility(View.GONE);
                wands.setVisibility(View.GONE);

                for(int i = 0; i< tempList.size(); i++){
                    if(tempList.get(i).getCategory() != 14 ){
                        tempList.remove(i);
                        i--;
                    }
                }
                display.setImageResource(tempList.get(0).getImage_Resource());
                display.setVisibility(View.VISIBLE);
            }
        });

        staves.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                axes.setVisibility(View.GONE);
                bows.setVisibility(View.GONE);
                claws.setVisibility(View.GONE);
                daggers.setVisibility(View.GONE);
                fishing.setVisibility(View.GONE);
                maces.setVisibility(View.GONE);
                staves.setVisibility(View.GONE);
                swords.setVisibility(View.GONE);
                wands.setVisibility(View.GONE);

                for(int i = 0; i< tempList.size(); i++){
                    if(tempList.get(i).getCategory() != 15 ){
                        tempList.remove(i);
                        i--;
                    }
                }
                display.setImageResource(tempList.get(0).getImage_Resource());
                display.setVisibility(View.VISIBLE);
            }
        });

        swords.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                axes.setVisibility(View.GONE);
                bows.setVisibility(View.GONE);
                claws.setVisibility(View.GONE);
                daggers.setVisibility(View.GONE);
                fishing.setVisibility(View.GONE);
                maces.setVisibility(View.GONE);
                staves.setVisibility(View.GONE);
                swords.setVisibility(View.GONE);
                wands.setVisibility(View.GONE);

                for(int i = 0; i< tempList.size(); i++){
                    if(tempList.get(i).getCategory() != 16 ){
                        tempList.remove(i);
                        i--;
                    }
                }
                display.setImageResource(tempList.get(0).getImage_Resource());
                display.setVisibility(View.VISIBLE);
            }
        });

        wands.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                axes.setVisibility(View.GONE);
                bows.setVisibility(View.GONE);
                claws.setVisibility(View.GONE);
                daggers.setVisibility(View.GONE);
                fishing.setVisibility(View.GONE);
                maces.setVisibility(View.GONE);
                staves.setVisibility(View.GONE);
                swords.setVisibility(View.GONE);
                wands.setVisibility(View.GONE);

                for(int i = 0; i< tempList.size(); i++){
                    if(tempList.get(i).getCategory() != 17 ){
                        tempList.remove(i);
                        i--;
                    }
                }
                display.setImageResource(tempList.get(0).getImage_Resource());
                display.setVisibility(View.VISIBLE);
            }
        });

        flasks.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                access.setVisibility(View.GONE);
                armour.setVisibility(View.GONE);
                weapons.setVisibility(View.GONE);
                flasks.setVisibility(View.GONE);
                jewels.setVisibility(View.GONE);
                maps.setVisibility(View.GONE);

                for(int i = 0; i< tempList.size(); i++){
                    if(tempList.get(i).getCategory() != 18 ){
                        tempList.remove(i);
                        i--;
                    }
                }
                display.setImageResource(tempList.get(0).getImage_Resource());
                display.setVisibility(View.VISIBLE);
            }
        });

        jewels.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                access.setVisibility(View.GONE);
                armour.setVisibility(View.GONE);
                weapons.setVisibility(View.GONE);
                flasks.setVisibility(View.GONE);
                jewels.setVisibility(View.GONE);
                maps.setVisibility(View.GONE);

                for(int i = 0; i< tempList.size(); i++){
                    if(tempList.get(i).getCategory() != 19 ){
                        tempList.remove(i);
                        i--;
                    }
                }
                display.setImageResource(tempList.get(0).getImage_Resource());
                display.setVisibility(View.VISIBLE);
            }
        });

        maps.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                access.setVisibility(View.GONE);
                armour.setVisibility(View.GONE);
                weapons.setVisibility(View.GONE);
                flasks.setVisibility(View.GONE);
                jewels.setVisibility(View.GONE);
                maps.setVisibility(View.GONE);

                for(int i = 0; i< tempList.size(); i++){
                    if(tempList.get(i).getCategory() != 20 ){
                        tempList.remove(i);
                        i--;
                    }
                }
                display.setImageResource(tempList.get(0).getImage_Resource());
                display.setVisibility(View.VISIBLE);
            }
        });

        myUniq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(savedList.size() != 0) {
                    all.setVisibility(View.GONE);
                    cat.setVisibility(View.GONE);
                    search.setVisibility(View.GONE);
                    myUniq.setVisibility(View.GONE);

                    tempList = (ArrayList<Unique>) savedList.clone();
                    display.setImageResource(tempList.get(0).getImage_Resource());
                    display.setVisibility(View.VISIBLE);
                }else{
                    Toast.makeText(MainActivity.this, "Double tap items to save here.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        display.setOnTouchListener(new OnSwipeTouchListener(MainActivity.this) {

            public void onSwipeTop() {
                //Toast.makeText(MainActivity.this, "top", Toast.LENGTH_SHORT).show();
            }
            public void onSwipeRight() {
                if(counter > 0) {
                    counter--;
                    display.setImageResource(tempList.get(counter).getImage_Resource());
                }else {
                    Toast.makeText(MainActivity.this, "Beginning of List", Toast.LENGTH_SHORT).show();
                }
            }
            public void onSwipeLeft() {
                if(counter < tempList.size()-1) {
                    counter++;
                    display.setImageResource(tempList.get(counter).getImage_Resource());
                }else{
                    Toast.makeText(MainActivity.this, "End of List", Toast.LENGTH_SHORT).show();
                }
                }
            public void onSwipeBottom() {
                //Toast.makeText(MainActivity.this, "bottom", Toast.LENGTH_SHORT).show();
            }

            public void onDT() {
                if(savedList.contains(tempList.get(counter))){
                    savedList.remove(tempList.get(counter));
                    Toast.makeText(MainActivity.this, "Removed", Toast.LENGTH_SHORT).show();
                    writeToFile(MainActivity.this);
                }else{
                    savedList.add(tempList.get(counter));
                    Toast.makeText(MainActivity.this, "Saved", Toast.LENGTH_SHORT).show();
                    writeToFile(MainActivity.this);
                }
            }

        });



        search_bar.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                InputMethodManager in = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                in.hideSoftInputFromWindow(view.getApplicationWindowToken(), 0);
                searchdisplay.setVisibility(View.VISIBLE);
                String value = (String)adapterView.getItemAtPosition(i);
                int j = 0;
                while(!value.equals(tempList.get(j).getName())){
                    j++;
                }
                searchdisplay.setImageResource(tempList.get(j).getImage_Resource());
                counter = j;
                search_bar.dismissDropDown();
                search_bar.setVisibility(View.GONE);
            }
        });
        searchdisplay.setOnTouchListener(new OnSwipeTouchListener(MainActivity.this) {

            public void onSwipeTop() {
            }
            public void onSwipeRight() {
            }
            public void onSwipeLeft() {
            }
            public void onSwipeBottom() {
            }
            public void onDT() {
                if(savedList.contains(tempList.get(counter))){
                    Toast.makeText(MainActivity.this, "Removed", Toast.LENGTH_SHORT).show();
                    savedList.remove(tempList.get(counter));
                    writeToFile(MainActivity.this);

                }else{
                    Toast.makeText(MainActivity.this, "Saved", Toast.LENGTH_SHORT).show();
                    savedList.add(tempList.get(counter));
                    writeToFile(MainActivity.this);
                }
            }
        });
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                all.setVisibility(View.GONE);
                cat.setVisibility(View.GONE);
                search.setVisibility(View.GONE);
                myUniq.setVisibility(View.GONE);

                search_bar.setVisibility(View.VISIBLE);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

private void setUp(){

    Unique Aruku = new Unique("Araku Tiki", 0, "http://poe.trade/search/eyehohokuihuko", R.drawable.arakutiki);
    Unique Astra = new Unique("Astramentis", 0, "http://poe.trade/search/amosiyukinamit", R.drawable.astramentis);
    Unique AtziriFoi = new Unique("Atziri's Foible", 0, "http://poe.trade/search/iwoonononasika", R.drawable.atzirifoible);
    Unique AulUprising = new Unique("Aul's Uprising", 0, "http://poe.trade/search/kahiusichuhazy", R.drawable.aulsuprising);
    Unique AulUprising2 = new Unique("Aul's Uprising", 0, "http://poe.trade/search/kahiusichuhazy", R.drawable.aulsuprisingtwo);
    Unique AulUprising3 = new Unique("Aul's Uprising", 0, "http://poe.trade/search/kahiusichuhazy", R.drawable.aulsuprisingthree);
    Unique AulUprising4 = new Unique("Aul's Uprising", 0, "http://poe.trade/search/kahiusichuhazy", R.drawable.aulsuprisingfour);
    Unique BiscosCollar = new Unique("Bisco's Collar", 0, "http://poe.trade/search/awoyusikimarin", R.drawable.biscocollar);
    Unique BlightwellClutch = new Unique("Blightwell Clutching Talisman", 0, "http://poe.trade/search/mikamoniguonar", R.drawable.blightwell);
    Unique BloodCorruption = new Unique("Blood of Corruption", 0, "http://poe.trade/search/eumaugoharinas", R.drawable.bloodofcor);
    Unique Bloodgrip = new Unique("Bloodgrip", 0, "http://poe.trade/search/esazukubekarur", R.drawable.bloodgrip);
    Unique Carnage = new Unique("Carnage Heart", 0, "http://poe.trade/search/tukukasikanoto", R.drawable.carnage);
    Unique Choir = new Unique("Choir of the Storm", 0, "http://poe.trade/search/eohitukigonato", R.drawable.choir);
    Unique DarSal = new Unique("Daresso's Salute", 0, "http://poe.trade/search/tobitotohetako", R.drawable.daressosolu);
    Unique Extractor = new Unique("Extractor Mentis", 0, "http://poe.trade/search/ehinoyohikatim", R.drawable.extractor);
    Unique EyeChay = new Unique("Eye of Chayula", 0, "http://poe.trade/search/inanihatamarug", R.drawable.eyechay);
    Unique EyeInnoc = new Unique("Eye of Innocence", 0, "http://poe.trade/search/inanonosanahot", R.drawable.eyeinoc);
    Unique EyeGreat = new Unique("Eyes of the Greatwolf", 0, "http://poe.trade/search/arimikitotasak", R.drawable.eyegreatwolf);
    Unique Gloom = new Unique("Gloomfang", 0, "http://poe.trade/search/tariwanyonanik", R.drawable.gloomfang);
    Unique Hinekora = new Unique("Hinekora's Sight", 0, "http://poe.trade/search/retomowaraahih", R.drawable.hinekora);
    Unique Impress1 = new Unique("Impresence (Chaos)", 0, "http://poe.trade/search/itikitetonamir", R.drawable.impressone);
    Unique Impress2 = new Unique("Impresence (Lightning)", 0, "http://poe.trade/search/tehamitabuukah", R.drawable.impresstwo);
    Unique Impress3 = new Unique("Impresence (Physical)", 0, "http://poe.trade/search/hurihanatohoni", R.drawable.impressthree);
    Unique Impress4 = new Unique("Impresence (Cold)", 0, "http://poe.trade/search/amonokoromoood", R.drawable.impressfour);
    Unique Impress5 = new Unique("Impresence (Fire)", 0, "http://poe.trade/search/orinimohamiumi", R.drawable.impressfive);
    Unique KaruiCharge = new Unique("Karui Charge", 0, "http://poe.trade/search/omasubominoiat", R.drawable.karuich);
    Unique KaruiWard = new Unique("Karui Ward", 0, "http://poe.trade/search/onitamorotadun", R.drawable.karuiward);
    Unique MaligarosCruelty = new Unique("Maligaro's Cruelty", 0, "http://poe.trade/search/hakeyonononiar", R.drawable.malicru);
    Unique MarylenesFallacy = new Unique("Marylene's Fallacy", 0, "http://poe.trade/search/badoozyakinina", R.drawable.maryl);
    Unique NaturalHierarchy = new Unique("Natural Hierarchy", 0, "http://poe.trade/search/usiutarinihate", R.drawable.naturalh);
    Unique NgamahuTiki = new Unique("Ngamahu Tiki", 0, "http://poe.trade/search/betosomenamgor", R.drawable.ngamahu);
    Unique NightsHold = new Unique("Night's Hold", 0, "http://poe.trade/search/auboriosiyukah", R.drawable.nightshold);
    Unique PerquilsToe = new Unique("Perquil's Toe", 0, "http://poe.trade/search/ominonateitasi", R.drawable.perqtoe);
    Unique PresenceofChayula = new Unique("Presence of Chayula", 0, "http://poe.trade/search/oruhitaremoman", R.drawable.preschay);
    Unique RashkaldorsPatience = new Unique("Rashkaldor's Patience", 0, "http://poe.trade/search/imazitowokamek", R.drawable.rashkal);
    Unique RigwaldsCurse = new Unique("Rigwald's Curse", 0, "http://poe.trade/search/ekiuwimonoatuk", R.drawable.riwaldscurse);
    Unique SacrificialHeart = new Unique("Sacrificial Heart", 0, "http://poe.trade/search/otamohionuarin", R.drawable.sacheart);
    Unique ShapersSeed = new Unique("Shaper's Seed", 0, "http://poe.trade/search/mikitononaurit", R.drawable.shapeseed);
    Unique Sidhebreath = new Unique("Sidhebreath", 0, "http://poe.trade/search/hiwatitihihika", R.drawable.sidebreath);
    Unique StarofWraeclast = new Unique("Star of Wraeclast", 0, "http://poe.trade/search/harasitohebani", R.drawable.starofw);
    Unique StoneofLazhwar = new Unique("Stone of Lazhwar", 0, "http://poe.trade/search/iusimoahimokah", R.drawable.stoneofl);
    Unique TearofPurity = new Unique("Tear of Purity", 0, "http://poe.trade/search/imasomakokomak", R.drawable.tearofpur);
    Unique TheAnvil = new Unique("The Anvil", 0, "http://poe.trade/search/imkuhamarihehi", R.drawable.anvil);
    Unique TheAscetic = new Unique("The Ascetic", 0, "http://poe.trade/search/ahosarutebomod", R.drawable.theascetic);
    Unique TheAylardex = new Unique("The Aylardex", 0, "http://poe.trade/search/onayobamotokat", R.drawable.theaylar);
    Unique TheEffigon = new Unique("The Effigon", 0, "http://poe.trade/search/ahuzahidosinag", R.drawable.theeffig);
    Unique TheHalcyon = new Unique("The Halcyon", 0, "http://poe.trade/search/ekuketahuhamas", R.drawable.thehal);
    Unique TheIgnomon = new Unique("The Ignomon", 0, "http://poe.trade/search/okuhokaboyohot", R.drawable.theign);
    Unique ThePandemonius = new Unique("The Pandemonius", 0, "http://poe.trade/search/gomahotametazi", R.drawable.theperand);
    Unique ThePrimordialChain = new Unique("The Primordial Chain", 0, "http://poe.trade/search/sihinomokokamo", R.drawable.theprimo);
    Unique UngilsHarmony = new Unique("Ungil's Harmony", 0, "http://poe.trade/search/ariyosenohimom", R.drawable.ungilsharm);
    Unique VictariosAcuity = new Unique("Victario's Acuity", 0, "http://poe.trade/search/oritamkurahano", R.drawable.victaracu);
    Unique VollsDevotion = new Unique("Voll's Devotion", 0, "http://poe.trade/search/asasiyazitonim", R.drawable.vollsdevo);
    Unique WarpedTimepiece = new Unique("Warped Timepiece", 0, "http://poe.trade/search/ahotuihinarena", R.drawable.warpedtime);
    Unique Winterheart = new Unique("Winterheart", 0, "http://poe.trade/search/inakobusadukoh", R.drawable.winterheart);
    Unique XophsBlood = new Unique("Xoph's Blood", 0, "http://poe.trade/search/rarokanniwoato", R.drawable.xophblood);
    Unique XophsHeart = new Unique("Xoph's Heart", 0, "http://poe.trade/search/atukaradunauwo", R.drawable.xophheart);
    Unique YokeofSuffering = new Unique("Yoke of Suffering", 0, "http://poe.trade/search/azawaritomenau", R.drawable.yokesuff);
    Unique ZerphisHeart = new Unique("Zerphi's Heart", 0, "http://poe.trade/search/utanasumomidot", R.drawable.zephriheart);
    Unique AscentFromFlesh = new Unique("Ascent From Flesh", 1, "http://poe.trade/search/monoonikoheter", R.drawable.acentfrom);
    Unique Auxium = new Unique("Auxium", 1, "http://poe.trade/search/otokitokutirik", R.drawable.auxium);
    Unique BatedBreath = new Unique("Bated Breath", 1, "http://poe.trade/search/ihuamokomitomi", R.drawable.batedbreath);
    Unique BeltoftheDeceiver = new Unique("Belt of the Deceiver", 1, "http://poe.trade/search/kinosokiurimit", R.drawable.beltdeci);
    Unique BiscosLeash = new Unique("Bisco's Leash", 1, "http://poe.trade/search/ahusononamomah", R.drawable.biscoleesh);
    Unique CowardsChains = new Unique("Coward's Chains", 1, "http://poe.trade/search/okokahihukitom", R.drawable.cowardchain);
    Unique CowardsLegacy = new Unique("Coward's Legacy", 1, "http://poe.trade/search/enarimitaratek", R.drawable.cowardsleg);
    Unique CyclopeanCoil = new Unique("Cyclopean Coil", 1, "http://poe.trade/search/ikokaruwonamok", R.drawable.cyclopeancoil);
    Unique DarknessEnthroned = new Unique("Darkness Enthroned", 1, "http://poe.trade/search/umdakimotoohit", R.drawable.darcknessen);
    Unique DoryanisInvitation1 = new Unique("Doryani's Invitation (Cold Damage)", 1, "http://poe.trade/search/kokowohubusido", R.drawable.doryinvone);
    Unique DoryanisInvitation2 = new Unique("Doryani's Invitation (Fire Damage)", 1, "http://poe.trade/search/okositetahobet", R.drawable.doryinvtwo);
    Unique DoryanisInvitation3 = new Unique("Doryani's Invitation (Physical Damage)", 1, "http://poe.trade/search/enabamiduamase", R.drawable.doryinvthree);
    Unique DoryanisInvitation4 = new Unique("Doryani's Invitation (Lightning Damage)", 1, "http://poe.trade/search/asikatamanawoa", R.drawable.doryinvfour);
    Unique DyadianDawn = new Unique("Dyadian Dawn", 1, "http://poe.trade/search/habusihohiwamo", R.drawable.dyadiandawn);
    Unique Faminebind = new Unique("Faminebind", 1, "http://poe.trade/search/onotasakuosahu", R.drawable.faminbind);
    Unique Feastbind = new Unique("Feastbind", 1, "http://poe.trade/search/arusihetunarug", R.drawable.feastbind);
    Unique Gluttony = new Unique("Gluttony", 1, "http://poe.trade/search/harikaribakaru", R.drawable.gluttony);
    Unique Headhunter = new Unique("Headhunter", 1, "http://poe.trade/search/ekikanokanikam", R.drawable.headhunter);
    Unique ImmortalFlesh = new Unique("Immortal Flesh", 1, "http://poe.trade/search/hanyomoneyeyuk", R.drawable.immortalflesh);
    Unique MaligarosRestraint = new Unique("Maligaro's Restraint", 1, "http://poe.trade/search/winowonoramaga", R.drawable.malirest);
    Unique MeginordsGirdle = new Unique("Meginord's Girdle", 1, "http://poe.trade/search/imabomonikedut", R.drawable.meginords);
    Unique PerandusBlazon = new Unique("Perandus Blazon", 1, "http://poe.trade/search/kautotehomabeo", R.drawable.perandusblaz);
    Unique Perseverance = new Unique("Perseverance", 1, "http://poe.trade/search/orikamerarirun", R.drawable.perserverance);
    Unique Prismweave = new Unique("Prismweave", 1, "http://poe.trade/search/izubumhitinoga", R.drawable.prismweave);
    Unique RyslathasCoil = new Unique("Ryslatha's Coil", 1, "http://poe.trade/search/onaritahetonau", R.drawable.ryslath);
    Unique SoulTether = new Unique("Soul Tether", 1, "http://poe.trade/search/enooteyakahure", R.drawable.soultether);
    Unique Soulthirst = new Unique("Soulthirst", 1, "http://poe.trade/search/idutauhuokutoa", R.drawable.soulthirst);
    Unique StringofServitude = new Unique("String of Servitude", 1, "http://poe.trade/search/okamanisoresit", R.drawable.stringofserv);
    Unique Sunblast = new Unique("Sunblast", 1, "http://poe.trade/search/irukukiuminiyo", R.drawable.sunblast);
    Unique TheFlowUntethered = new Unique("The Flow Untethered", 1, "http://poe.trade/search/arerikiyarukak", R.drawable.theflow);
    Unique TheMagnate = new Unique("The Magnate", 1, "http://poe.trade/search/aroniariketezu", R.drawable.themagnate);
    Unique TheNomad = new Unique("The Nomad", 1, "http://poe.trade/search/iduriworarahit", R.drawable.thenomad);
    Unique TheRetch = new Unique("The Retch", 1, "http://poe.trade/search/uwoikiminihiha", R.drawable.theretch);
    Unique TheTactician = new Unique("The Tactician", 1, "http://poe.trade/search/ikahukarisakit", R.drawable.thetactician);
    Unique UmbilicusImmortalis = new Unique("Umbilicus Immortalis", 1, "http://poe.trade/search/rikatahorunihi", R.drawable.umbilicious);
    Unique WurmsMolt = new Unique("Wurm's Molt", 1, "http://poe.trade/search/unikasimosahed", R.drawable.wurmsmolt);
    Unique AhkelisMeadow = new Unique("Ahkeli's Meadow", 2, "http://poe.trade/search/arihadonomyate", R.drawable.ahkelimeadow);
    Unique AhkelisMountain = new Unique("Ahkeli's Mountain", 2, "http://poe.trade/search/umoketatusokok", R.drawable.ahkelimountain);
    Unique AhkelisValley = new Unique("Ahkeli's Valley", 2, "http://poe.trade/search/tonaninitekoto", R.drawable.ahkelivalley);
    Unique Andvarius = new Unique("Andvarius", 2, "http://poe.trade/search/omtenatenonoma", R.drawable.andv);
    Unique AnglersPlait = new Unique("Angler's Plait", 2, "http://poe.trade/search/ramnanitasuhum", R.drawable.anglerspl);
    Unique BereksGrip = new Unique("Berek's Grip", 2, "http://poe.trade/search/ohikiumasaetan", R.drawable.bereksgrip);
    Unique BereksPass = new Unique("Berek's Pass", 2, "http://poe.trade/search/okenabinitabet", R.drawable.berekspass);
    Unique BereksRespite = new Unique("Berek's Respite", 2, "http://poe.trade/search/aserahamamakah", R.drawable.bereksrespite);
    Unique Blackheart = new Unique("Blackheart", 2, "http://poe.trade/search/itetasemekawim", R.drawable.blackheart);
    Unique Bloodboil = new Unique("Bloodboil", 2, "http://poe.trade/search/onozunegeakami", R.drawable.bloodboil);
    Unique BrinerotMark = new Unique("Brinerot Mark", 2, "http://poe.trade/search/itumokoniterik", R.drawable.brinenotmark);
    Unique CalloftheBrotherhood = new Unique("Call of the Brotherhood", 2, "http://poe.trade/search/awaenimikotazi", R.drawable.callofthebrotherhood);
    Unique DeathRush = new Unique("Death Rush", 2, "http://poe.trade/search/abuhotesehunit", R.drawable.deathrush);
    Unique DoedresDamning = new Unique("Doedre's Damning", 2, "http://poe.trade/search/usitoteuritoki", R.drawable.doesdresdamning);
    Unique DreamFragments = new Unique("Dream Fragments", 2, "http://poe.trade/search/hiwihahuhanima", R.drawable.dreamfragments);
    Unique Emberwake = new Unique("Emberwake", 2, "http://poe.trade/search/hamikahinorima", R.drawable.emberwake);
    Unique EssenceWorm = new Unique("Essence Worm", 2, "http://poe.trade/search/idoseyakadowos", R.drawable.essenceworm);
    Unique GiftsfromAbove = new Unique("Gifts from Above", 2, "http://poe.trade/search/omokisadunariy", R.drawable.giftssfromabove);
    Unique HeartboundLoop = new Unique("Heartbound Loop", 2, "http://poe.trade/search/usikimeyahomga", R.drawable.heartboundloop);
    Unique KaomsSign = new Unique("Kaom's Sign", 2, "http://poe.trade/search/owoboyaredunad", R.drawable.kaomssign);
    Unique KaomsWay = new Unique("Kaom's Way", 2, "http://poe.trade/search/urinanikikosei", R.drawable.kaomsway);
    Unique Kikazaru = new Unique("Kikazaru", 2, "http://poe.trade/search/iumoduramaheta", R.drawable.kikazaru);
    Unique LeHeupofAll = new Unique("Le Heup of All", 2, "http://poe.trade/search/nikotamikehamo", R.drawable.leheup);
    Unique LorisLantern = new Unique("Lori's Lantern", 2, "http://poe.trade/search/imichowakimitu", R.drawable.lorislantern);
    Unique MalachaisArtifice = new Unique("Malachai's Artifice", 2, "http://poe.trade/search/hihitorohosima", R.drawable.malachaisartifice);
    Unique MarkofSubmission = new Unique("Mark of Submission", 2, "http://poe.trade/search/oyakahaukeraba", R.drawable.markofsubmission);
    Unique MarkoftheElder = new Unique("Mark of the Elder", 2, "http://poe.trade/search/onimeugowonzob", R.drawable.markoftheelder);
    Unique MarkoftheShaper = new Unique("Mark of the Shaper", 2, "http://poe.trade/search/uhohikinoosama", R.drawable.markoftheshaper);
    Unique MingsHeart = new Unique("Ming's Heart", 2, "http://poe.trade/search/otoionakamikin", R.drawable.mingsheart);
    Unique MokousEmbrace = new Unique("Mokou's Embrace", 2, "http://poe.trade/search/ahasikamooniha", R.drawable.mokousembrace);
    Unique MutewindSeal = new Unique("Mutewind Seal", 2, "http://poe.trade/search/tuhimoyorihawo", R.drawable.mutewindseal);
    Unique NgamahusSign = new Unique("Ngamahu's Sign", 2, "http://poe.trade/search/imemohutomakun", R.drawable.ngamahussign);
    Unique PerandusSignet = new Unique("Perandus Signet", 2, "http://poe.trade/search/sehanoohugimam", R.drawable.peransussignet);
    Unique Praxis = new Unique("Praxis", 2, "http://poe.trade/search/agatatakisimom", R.drawable.praxis);
    Unique PrecursorsEmblem1 = new Unique("Precursor's Emblem (Endurance, Frenzy and Power Charge)", 2, "http://poe.trade/search/omahinanooyosi", R.drawable.percusersemblem);
    Unique PrecursorsEmblem2 = new Unique("Precursor's Emblem (Endurance Charge)", 2, "http://poe.trade/search/oyotetohomamah", R.drawable.precurs2);
    Unique PrecursorsEmblem3 = new Unique("Precursor's Emblem (Frenzy Charge)", 2, "http://poe.trade/search/umikokuoyukino", R.drawable.precurs3);
    Unique PrecursorsEmblem4 = new Unique("Precursor's Emblem (Power Charge)", 2, "http://poe.trade/search/omgoheyamokoom", R.drawable.precurs4);
    Unique PrecursorsEmblem5 = new Unique("Precursor's Emblem (Frenzy and Power Charge)", 2, "http://poe.trade/search/ewowameketahah", R.drawable.precurs5);
    Unique PrecursorsEmblem6 = new Unique("Precursor's Emblem (Endurance and Frenzy Charge)", 2, "http://poe.trade/search/nadorikatesete", R.drawable.precurs6);
    Unique PrecursorsEmblem7 = new Unique("Precursor's Emblem (Endurance and Power Charge)", 2, "http://poe.trade/search/sokikorukoasom", R.drawable.precurs7);
    Unique PutembosMeadow = new Unique("Putembo's Meadow", 2, "http://poe.trade/search/azomonizurohim", R.drawable.putembosmeadow);
    Unique PutembosMountain = new Unique("Putembo's Mountain", 2, "http://poe.trade/search/hetaurumkonito", R.drawable.putembosmountain);
    Unique PutembosValley = new Unique("Putembo's Valley", 2, "http://poe.trade/search/iteutomikahioh", R.drawable.putembosvalley);
    Unique Pyre = new Unique("Pyre", 2, "http://poe.trade/search/osarimosasiter", R.drawable.pyre);
    Unique RedbladeBand = new Unique("Redblade Band", 2, "http://poe.trade/search/amimimonitowom", R.drawable.redbladeband);
    Unique RigwaldsCrest = new Unique("Rigwald's Crest", 2, "http://poe.trade/search/omomohikazugot", R.drawable.rigwaldscrest);
    Unique RomirasBanquet = new Unique("Romira's Banquet", 2, "http://poe.trade/search/kadumeyoonatok", R.drawable.romirasbanquet);
    Unique ShavronnesRevelation = new Unique("Shavronne's Revelation", 2, "http://poe.trade/search/kaharutorimata", R.drawable.shavronnesrevelation);
    Unique SibylsLament = new Unique("Sibyl's Lament", 2, "http://poe.trade/search/hinatonatetiub", R.drawable.sibylslament);
    Unique Snakepit = new Unique("Snakepit", 2, "http://poe.trade/search/imkionoiseware", R.drawable.snakepit);
    Unique Stormfire = new Unique("Stormfire", 2, "http://poe.trade/search/aohoohitohetoh", R.drawable.stormfire);
    Unique TasaliosSign = new Unique("Tasalio's Sign", 2, "http://poe.trade/search/omomhohitooono", R.drawable.tasaliossign);
    Unique TheHungryLoop = new Unique("The Hungry Loop", 2, "http://poe.trade/search/kamonarekamios", R.drawable.thehungryloop);
    Unique ThePariah = new Unique("The Pariah", 2, "http://poe.trade/search/iitarekugetona", R.drawable.thepariah);
    Unique TheTaming = new Unique("The Taming", 2, "http://poe.trade/search/usiyekikimaron", R.drawable.thetaming);
    Unique TheWardensBrand = new Unique("The Warden's Brand", 2, "http://poe.trade/search/hokikahonoetah", R.drawable.thewardensband);
    Unique ThiefsTorment = new Unique("Thief's Torment", 2, "http://poe.trade/search/inareyasaniwek", R.drawable.thiefstorment);
    Unique Timeclasp = new Unique("Timeclasp", 2, "http://poe.trade/search/iwoniomimarein", R.drawable.timeclasp);
    Unique Timetwist = new Unique("Timetwist", 2, "http://poe.trade/search/umimitahutoteh", R.drawable.timetwist);
    Unique UzazasMeadow = new Unique("Uzaza's Meadow", 2, "http://poe.trade/search/amamabokimiono", R.drawable.uzazusmeadow);
    Unique UzazasMountain = new Unique("Uzaza's Mountain", 2, "http://poe.trade/search/kamomiohihogiy", R.drawable.uzazusmountain);
    Unique UzazasValley = new Unique("Uzaza's Valley", 2, "http://poe.trade/search/hukutoriinoyet", R.drawable.uzazusvalley);
    Unique ValakosSign = new Unique("Valako's Sign", 2, "http://poe.trade/search/nasetareyahiso", R.drawable.valakossign);
    Unique Valyrium = new Unique("Valyrium", 2, "http://poe.trade/search/oobinamebeyazi", R.drawable.valyrium);
    Unique VentorsGamble = new Unique("Ventor's Gamble", 2, "http://poe.trade/search/utakoohitarisi", R.drawable.ventorsgamble);
    Unique Voideye = new Unique("Voideye", 2, "http://poe.trade/search/okidusenowommi", R.drawable.voideye);
    Unique Voidheart = new Unique("Voidheart", 2, "http://poe.trade/search/uwanazukokikos", R.drawable.voidheart);
    Unique Winterweave = new Unique("Winterweave", 2, "http://poe.trade/search/hubamokinoruno", R.drawable.winterweave);
    Unique AsphyxiasWrath = new Unique("Asphyxia's Wrath", 3, "http://poe.trade/search/ninikiatoroiti", R.drawable.asphyxiaswrath);
    Unique Blackgleam = new Unique("Blackgleam", 3, "http://poe.trade/search/moakutubenitot", R.drawable.blackgleam);
    Unique Cragfall = new Unique("Cragfall", 3, "http://poe.trade/search/uriwarumitasik", R.drawable.cragfall);
    Unique Craghead = new Unique("Craghead", 3, "http://poe.trade/search/rekakuikayaruh", R.drawable.craghead);
    Unique Drillneck = new Unique("Drillneck", 3, "http://poe.trade/search/ohetogagomotok", R.drawable.drillneck);
    Unique HyrrisBite = new Unique("Hyrri's Bite", 3, "http://poe.trade/search/ekasitesiteyak", R.drawable.hyrrisbite);
    Unique HyrrisDemise = new Unique("Hyrri's Demise", 3, "http://poe.trade/search/naritakahuteti", R.drawable.hyrrisdemise);
    Unique MaloneysNightfall = new Unique("Maloney's Nightfall", 3, "http://poe.trade/search/omokikutomitob", R.drawable.malonysnightfall);
    Unique Rearguard = new Unique("Rearguard", 3, "http://poe.trade/search/ewohiwogurered", R.drawable.reargaurd);
    Unique RigwaldsQuills = new Unique("Rigwald's Quills", 3, "http://poe.trade/search/asahebomenzumg", R.drawable.rigwaldsquills);
    Unique SaemusGift = new Unique("Saemus' Gift", 3, "http://poe.trade/search/sikemenitihooa", R.drawable.saemusgift);
    Unique Skirmish = new Unique("Skirmish", 3, "http://poe.trade/search/huhuomokinagon", R.drawable.sirmish);
    Unique SoulStrike = new Unique("Soul Strike", 3, "http://poe.trade/search/gusekihamabuio", R.drawable.soulstrike);
    Unique TheFracturingSpinner = new Unique("The Fracturing Spinner", 3, "http://poe.trade/search/memauwanaurini", R.drawable.thefracturedspinner);
    Unique TheSignalFire = new Unique("The Signal Fire", 3, "http://poe.trade/search/oraramamitagot", R.drawable.thesignalfire);
    Unique Voidfletcher = new Unique("Voidfletcher", 3, "http://poe.trade/search/rereyenoonauhu", R.drawable.voidfletcher);
    Unique Bramblejack = new Unique("Bramblejack", 4, "http://poe.trade/search/itatositakaran", R.drawable.bramblejack);
    Unique CraiceannsCarapace = new Unique("Craiceann's Carapace", 4, "http://poe.trade/search/izuninitaobeno", R.drawable.craiceannscarapace);
    Unique DeathsOath = new Unique("Death's Oath", 4, "http://poe.trade/search/uminominaseyom", R.drawable.deathsoath);
    Unique GreedsEmbrace = new Unique("Greed's Embrace", 4, "http://poe.trade/search/hasaonakarenos", R.drawable.greedsembrace);
    Unique IronHeart = new Unique("Iron Heart", 4, "http://poe.trade/search/kioteniwekonam", R.drawable.ironheart);
    Unique KaomsHeart = new Unique("Kaom's Heart", 4, "http://poe.trade/search/okatokohobokit", R.drawable.kaomsheart);
    Unique LioneyesVision = new Unique("Lioneye's Vision", 4, "http://poe.trade/search/ikizohuworitau", R.drawable.lioneyesvision);
    Unique SolarisLorica = new Unique("Solaris Lorica", 4, "http://poe.trade/", R.drawable.solarislorica);
    Unique TheBrassDome = new Unique("The Brass Dome", 4, "http://poe.trade/search/asitokotasonow", R.drawable.thebrassdome);
    Unique TheIronFortress = new Unique("The Iron Fortress", 4, "http://poe.trade/search/nonioukonobenz", R.drawable.theironfortress);
    Unique WallofBrambles = new Unique("Wall of Brambles", 4, "http://poe.trade/search/masinonaminote", R.drawable.wallofbrambles);
    Unique Ashrend = new Unique("Ashrend", 4, "http://poe.trade/search/inonamasinohom", R.drawable.ashrend);
    Unique Briskwrap = new Unique("Briskwrap", 4, "http://poe.trade/search/ranagosikiniag", R.drawable.briskwrap);
    Unique BronnsLithe = new Unique("Bronn's Lithe", 4, "http://poe.trade/search/zikahonabonote", R.drawable.brommslithe);
    Unique CosprisWill = new Unique("Cospri's Will", 4, "http://poe.trade/search/kiukanahotekit", R.drawable.cospriswill);
    Unique FoxsFortune = new Unique("Fox's Fortune", 4, "http://poe.trade/search/hegumaumiumahu", R.drawable.foxsfourtune);
    Unique Foxshade = new Unique("Foxshade", 4, "http://poe.trade/search/owoomadubohano", R.drawable.foxshade);
    Unique HyrrisIre = new Unique("Hyrri's Ire", 4, "http://poe.trade/search/ititooyoahiniw", R.drawable.hyrrisire);
    Unique Kintsugi = new Unique("Kintsugi", 4, "http://poe.trade/search/ukinoninorunar", R.drawable.kitsugi);
    Unique QueenoftheForest = new Unique("Queen of the Forest", 4, "http://poe.trade/search/auwarionimimok", R.drawable.queenoftheforest);
    Unique ThePerfectForm = new Unique("The Perfect Form", 4, "http://poe.trade/search/abiyakonimhira", R.drawable.theperfectform);
    Unique TheRatCage = new Unique("The Rat Cage", 4, "http://poe.trade/search/onataharomitom", R.drawable.theratcage);
    Unique TheSnowblindGrace = new Unique("The Snowblind Grace", 4, "http://poe.trade/search/anzironazihuri", R.drawable.thesnowblindgrace);
    Unique Wildwrap = new Unique("Wildwrap", 4, "http://poe.trade/search/sasigisikitani", R.drawable.wildwrap);
    Unique YrielsFostering1 = new Unique("Yriel's Fostering (Rhoa)", 4, "http://poe.trade/search/nitohekizaoter", R.drawable.yrielsfostering);
    Unique YrielsFostering2 = new Unique("Yriel's Fostering (Snake)", 4, "http://poe.trade/search/iwasaomanaukan", R.drawable.yrielsfostering2);
    Unique YrielsFostering3 = new Unique("Yriel's Fostering (Ursa)", 4, "http://poe.trade/search/imtowakohagami", R.drawable.yrielsfostering3);
    Unique CloakofFlame = new Unique("Cloak of Flame", 4, "http://poe.trade/search/basinisinatoge", R.drawable.cloakofflame);
    Unique CloakofTawmrIsley = new Unique("Cloak of Tawm'r Isley", 4, "http://poe.trade/search/mazunenoboozan", R.drawable.cloakoftawmrisley);
    Unique DiallasMalefaction = new Unique("Dialla's Malefaction", 4, "http://poe.trade/search/aninotetonosis", R.drawable.diallasmalefaction);
    Unique DoedresSkin = new Unique("Doedre's Skin", 4, "http://poe.trade/search/oohisunziramin", R.drawable.doedresskin);
    Unique FenumusShroud = new Unique("Fenumus' Shroud", 4, "http://poe.trade/search/ikitetekorarua", R.drawable.fenumusshroud);
    Unique InfernalMantle = new Unique("Infernal Mantle", 4, "http://poe.trade/search/omahiobiorikit", R.drawable.infernalmantle);
    Unique ShavronnesWrappings = new Unique("Shavronne's Wrappings", 4, "http://poe.trade/search/okuiwahunaunow", R.drawable.shavronneswrappings);
    Unique SkinoftheLords = new Unique("Skin of the Lords", 4, "http://poe.trade/search/arikokannorita", R.drawable.skinofthelords);
    Unique SkinoftheLoyal = new Unique("Skin of the Lords", 4, "http://poe.trade/search/arikokannorita", R.drawable.skinoftheloyal);
    Unique SoulMantle = new Unique("Soul Mantle", 4, "http://poe.trade/search/maritugamotomo", R.drawable.soulmantle);
    Unique TabulaRasa = new Unique("Tabula Rasa", 4, "http://poe.trade/search/iretetotoomiwo", R.drawable.tabularosa);
    Unique TheBeastFurShawl = new Unique("The Beast Fur Shawl", 4, "http://poe.trade/search/utaboteukukimo", R.drawable.thebeastofthefurshawl);
    Unique TheComingCalamity = new Unique("The Coming Calamity", 4, "http://poe.trade/search/mitedugomonana", R.drawable.thecomingcalamity);
    Unique TheCovenant = new Unique("The Covenant", 4, "http://poe.trade/search/moyanosedomeka", R.drawable.thecovenant);
    Unique ThousandRibbons = new Unique("Thousand Ribbons", 4, "http://poe.trade/search/arorumakorinik", R.drawable.thousandribbons);
    Unique VisMortis = new Unique("Vis Mortis", 4, "http://poe.trade/search/hebetebetonika", R.drawable.vismortis);
    Unique ZahndethusCassock = new Unique("Zahndethus' Cassock", 4, "http://poe.trade/search/hutewoihinomit", R.drawable.zahndethuscassock);
    Unique BellyoftheBeast = new Unique("Belly of the Beast", 4, "http://poe.trade/search/miutarihomitor", R.drawable.bellyofthebeast);
    Unique CherrubimsMaleficence = new Unique("Cherrubim's Maleficence", 4, "http://poe.trade/search/marimenoikonik", R.drawable.cherrubimsmaleficence);
    Unique DaressosDefiance = new Unique("Daresso's Defiance", 4, "http://poe.trade/search/omamoyotitubid", R.drawable.daressosdefiance);
    Unique FarrulsFur = new Unique("Farrul's Fur", 4, "http://poe.trade/search/iinarohutonagu", R.drawable.farrulsfur);
    Unique GruthkulsPelt = new Unique("Gruthkul's Pelt", 4, "http://poe.trade/search/amahenakimomah", R.drawable.gruthkulspelt);
    Unique LightningCoil = new Unique("Lightning Coil", 4, "http://poe.trade/search/etokukitukamiy", R.drawable.lightiningcoil);
    Unique VipersScales = new Unique("Viper's Scales", 4, "http://poe.trade/search/nononarihanina", R.drawable.vipersscales);
    Unique AmbusCharge = new Unique("Ambu's Charge", 4, "http://poe.trade/search/ukugaunanitoho", R.drawable.ambuscharge);
    Unique ChainsofCommand = new Unique("Chains of Command", 4, "http://poe.trade/search/tinitetoonatio", R.drawable.chainsofcommand);
    Unique CrystalVault = new Unique("Crystal Vault", 4, "http://poe.trade/search/oonarimoohuhoa", R.drawable.crystalvault);
    Unique GeofrisSanctuary = new Unique("Geofri's Sanctuary", 4, "http://poe.trade/search/adakohuteremit", R.drawable.geofrissanctuary);
    Unique Icetomb = new Unique("Icetomb", 4, "http://poe.trade/search/ikobenotemitem", R.drawable.icetomb);
    Unique IncandescentHeart = new Unique("Incandescent Heart", 4, "http://poe.trade/search/omahinahisinog", R.drawable.incandescentheart);
    Unique Kingsguard = new Unique("Kingsguard", 4, "http://poe.trade/search/ugoniyosaridot", R.drawable.kingsguard);
    Unique LightbaneRaiment = new Unique("Lightbane Raiment", 4, "http://poe.trade/search/okoumerasarure", R.drawable.lightbaneraiment);
    Unique Loreweave = new Unique("Loreweave", 4, "http://poe.trade/search/siwonakikoriuy", R.drawable.loreweave);
    Unique VollsProtector = new Unique("Voll's Protector", 4, "http://poe.trade/search/agomiyerimoohe", R.drawable.vollsprotector);
    Unique Bloodbond = new Unique("Bloodbond", 4, "http://poe.trade/search/ehahetoriyotun", R.drawable.bloodbond);
    Unique CloakofDefiance = new Unique("Cloak of Defiance", 4, "http://poe.trade/search/aminihoharitet", R.drawable.cloakofdefiance);
    Unique VictariosInfluence = new Unique("Victario's Influence", 4, "http://poe.trade/search/huhanihiukikis", R.drawable.victariosinfluence);
    Unique Dendrobate = new Unique("Dendrobate", 4, "http://poe.trade/search/ichiiniotatome", R.drawable.dendrobate);
    Unique CarcassJack = new Unique("Carcass Jack", 4, "http://poe.trade/search/ekoasosetehiko", R.drawable.carcasejack);
    Unique SaqawalsNest = new Unique("Saqawal's Nest", 4, "http://poe.trade/search/myatomomotaser", R.drawable.saqawalsnest);
    Unique InpulsasBrokenHeart = new Unique("Inpulsa's Broken Heart", 4, "http://poe.trade/search/amoterenisioga", R.drawable.inpulsasbrokenheart);
    Unique Tinkerskin = new Unique("Tinkerskin", 4, "http://poe.trade/search/iohobitanazuho", R.drawable.tinkerskin);
    Unique ShroudoftheLightless = new Unique("Shroud of the Lightless", 4, "http://poe.trade/search/itumikomosiyok", R.drawable.shroudofthelightless);
    Unique TheRestlessWard = new Unique("The Restless Ward", 4, "http://poe.trade/search/amatoahabekoha", R.drawable.therestlessward);
    Unique Shadowstitch = new Unique("Shadowstitch", 4, "http://poe.trade/search/adukitokikurik", R.drawable.shadowstitch);
    Unique AtzirisSplendourOne = new Unique("Atziri's Splendour (Armour and Energy Shield)", 4, "http://poe.trade/search/ahonitatonasim", R.drawable.atzirissplendour);
    Unique AtzirisSplendourTwo = new Unique("Atziri's Splendour (Armour and Life)", 4, "http://poe.trade/search/bareyeyatahoan", R.drawable.atzirissplendourtwo);
    Unique AtzirisSplendourThree = new Unique("Atziri's Splendour (Armour, Energy Shield and Life)", 4, "http://poe.trade/search/okekiteomoseka", R.drawable.atzirissplendourthree);
    Unique AtzirisSplendourFour = new Unique("Atziri's Splendour (Armour, Evasion and Energy Shield)", 4, "http://poe.trade/search/akitihugonagoh", R.drawable.atzirissplendourfour);
    Unique AtzirisSplendourFive = new Unique("Atziri's Splendour (Armour, Evasion and Life)", 4, "http://poe.trade/search/uworusomokotay", R.drawable.atzirissplendourfive);
    Unique AtzirisSplendourSix = new Unique("Atziri's Splendour (Energy Shield)", 4, "http://poe.trade/search/ohahamosoorito", R.drawable.atzirissplendoursix);
    Unique AtzirisSplendourSeven = new Unique("Atziri's Splendour (Evasion and Energy Shield)", 4, "http://poe.trade/search/usawohewonoowo", R.drawable.atzirissplendourseven);
    Unique AtzirisSplendourEight = new Unique("Atziri's Splendour (Evasion and Life)", 4, "http://poe.trade/search/gamasinokogamo", R.drawable.atzirissplendoureight);
    Unique AtzirisSplendourNine = new Unique("Atziri's Splendour (Evasion, Energy Shield and Life)", 4, "http://poe.trade/search/basanitometaho", R.drawable.atzirissplendournine);
    Unique CraiceannsTracks = new Unique("Craiceann's Tracks", 5, "http://poe.trade/search/ugitetamakakeb", R.drawable.craiceannstracks);
    Unique DoryanisDelusionOne = new Unique("Doryani's Delusion (Armour)", 5, "http://poe.trade/search/winonokekikasi", R.drawable.doryanisdelusion);
    Unique KaomsRoots = new Unique("Kaom's Roots", 5, "http://poe.trade/search/kimtumazugoham", R.drawable.kaomsroots);
    Unique RedbladeTramplers = new Unique("Redblade Tramplers", 5, "http://poe.trade/search/oogasiyomanino", R.drawable.redbladetramplers);
    Unique Stormcharger = new Unique("Stormcharger", 5, "http://poe.trade/search/iharomamohotog", R.drawable.stormcharger);
    Unique TheInfinitePursuit = new Unique("The Infinite Pursuit", 5, "http://poe.trade/search/okizuretoyatas", R.drawable.theinfinitepursuit);
    Unique TheRedTrail = new Unique("The Red Trail", 5, "http://poe.trade/search/itohokitanoaan", R.drawable.theredtrails);
    Unique Windscream = new Unique("Windscream", 5, "http://poe.trade/search/omitinarikoher", R.drawable.windscream);
    Unique Windshriek = new Unique("Windshriek", 5, "http://poe.trade/search/sikitanonahusa", R.drawable.windshriek);
    Unique AbberathsHooves = new Unique("Abberath's Hooves", 5, "http://poe.trade/search/totasikinonoba", R.drawable.abberathshooves);
    Unique AtzirisStep = new Unique("Atziri's Step", 5, "http://poe.trade/search/imahahuowotoma", R.drawable.atzirisstep);
    Unique Deerstalker = new Unique("Deerstalker", 5, "http://poe.trade/search/imikakarinasen", R.drawable.deerstalker);
    Unique DoryanisDelusionTwo = new Unique("Doryani's Delusion (Evasion)", 5, "http://poe.trade/search/narioyutamonih", R.drawable.doryanisdelusiontwo);
    Unique FarrulsChase = new Unique("Farrul's Chase", 5, "http://poe.trade/search/aheatoyenaniri", R.drawable.farrulschase);
    Unique GarukhansFlight = new Unique("Garukhan's Flight", 5, "http://poe.trade/search/omanoyokataroo", R.drawable.garukhansflight);
    Unique Goldwyrm = new Unique("Goldwyrm", 5, "http://poe.trade/search/kusenoikanitom", R.drawable.goldwyrm);
    Unique SevenLeagueStep = new Unique("Seven-League Step", 5, "http://poe.trade/search/sautotanakeson", R.drawable.sevenleaguestep);
    Unique SinTrek = new Unique("Sin Trek", 5, "http://poe.trade/search/ugameworausahu", R.drawable.sintrek);
    Unique TheBloodDance = new Unique("The Blood Dance", 5, "http://poe.trade/search/ketowominonono", R.drawable.theblooddance);
    Unique ThreestepAssault = new Unique("Three-step Assault", 5, "http://poe.trade/search/onagatomotenno", R.drawable.threestepassault);
    Unique VictariosFlight = new Unique("Victario's Flight", 5, "http://poe.trade/search/owitateayuruna", R.drawable.victariosflight);
    Unique BonesofUllr = new Unique("Bones of Ullr", 5, "http://poe.trade/search/miosimokitasit", R.drawable.bonesofullr);
    Unique DoryanisDelusionthree = new Unique("Doryani's Delusion (Energy Shield)", 5, "http://poe.trade/search/anaruanodoseri", R.drawable.doryanisdelusionthree);
    Unique Greedtrap = new Unique("Greedtrap", 5, "http://poe.trade/search/menomiseyetena", R.drawable.greedtrap);
    Unique InyasEpiphany = new Unique("Inya's Epiphany", 5, "http://poe.trade/search/obotennomaguni", R.drawable.inyasepiphany);
    Unique Rainbowstride = new Unique("Rainbowstride", 5, "http://poe.trade/search/ourihukininiti", R.drawable.rainbowstride);
    Unique ShavronnesGambit = new Unique("Shavronne's Gambit", 5, "http://poe.trade/search/iosetenatenaru", R.drawable.shavronnesgambit);
    Unique ShavronnesPace = new Unique("Shavronne's Pace", 5, "http://poe.trade/search/rikositomanosi", R.drawable.shavronnespace);
    Unique Skyforth = new Unique("Skyforth", 5, "http://poe.trade/search/tinomosukutaza", R.drawable.skyforth);
    Unique SteppanEard = new Unique("Steppan Eard", 5, "http://poe.trade/search/sikamokitomaro", R.drawable.steppaneard);
    Unique Wanderlust = new Unique("Wanderlust", 5, "http://poe.trade/search/kisedusoarikir", R.drawable.wanderlust);
    Unique Wondertrap = new Unique("Wondertrap", 5, "http://poe.trade/search/notokamomonaus", R.drawable.wondertrap);
    Unique DarkrayVectors = new Unique("Darkray Vectors", 5, "http://poe.trade/search/kohesenenotote", R.drawable.darkrayvectors);
    Unique Duskblight = new Unique("Duskblight", 5, "http://poe.trade/search/iorimdoyariyot", R.drawable.duskblight);
    Unique Dusktoe = new Unique("Dusktoe", 5, "http://poe.trade/search/usariwanyahiko", R.drawable.dusktoe);
    Unique LioneyesPaws = new Unique("Lioneye's Paws", 5, "http://poe.trade/search/akamotesenaron", R.drawable.lioneyespaws);
    Unique MutewindWhispersteps = new Unique("Mutewind Whispersteps", 5, "http://poe.trade/search/hahotewararomo", R.drawable.mutewindwhispersteps);
    Unique SaqawalsTalons = new Unique("Saqawal's Talons", 5, "http://poe.trade/search/omotamarotaraz", R.drawable.saqawalstalons);
    Unique AlberonsWarpath = new Unique("Alberon's Warpath", 5, "http://poe.trade/search/nitamonayokona", R.drawable.alberonswarpath);
    Unique DeathsDoor = new Unique("Death's Door", 5, "http://poe.trade/search/emohitadusiori", R.drawable.deathsdoor);
    Unique GangsMomentum = new Unique("Gang's Momentum", 5, "http://poe.trade/search/umigohitimarig", R.drawable.gangsmomentum);
    Unique RalakeshsImpatience = new Unique("Ralakesh's Impatience", 5, "http://poe.trade/search/tisatasogetema", R.drawable.ralakeshsimpatience);
    Unique WakeofDestruction = new Unique("Wake of Destruction", 5, "http://poe.trade/search/onikononokuhah", R.drawable.wakeofdestruction);
    Unique BrinerotWhalers = new Unique("Brinerot Whalers", 5, "http://poe.trade/search/atitokasikitat", R.drawable.brinerotwhalers);
    Unique BubonicTrailOne = new Unique("Bubonic Trail (1 Abyssal Socket)", 5, "http://poe.trade/search/inametodamanar", R.drawable.bubonictrialone);
    Unique BubonicTrailTwo = new Unique("Bubonic Trail (2 Abyssal Sockets)", 5, "http://poe.trade/search/otahinihonimta", R.drawable.bubonictrailtwo);
    Unique DanceoftheOffered = new Unique("Dance of the Offered", 5, "http://poe.trade/search/akekoraabohiha", R.drawable.danceoftheoffered);
    Unique FenumusSpinnerets = new Unique("Fenumus' Spinnerets", 5, "http://poe.trade/search/utomnimayakogu", R.drawable.fenumusspinnerets);
    Unique NomicsStorm = new Unique("Nomic's Storm", 5, "http://poe.trade/search/nikukosukoahuk", R.drawable.nomicsstorm);
    Unique Omeyocan = new Unique("Omeyocan", 5, "http://poe.trade/search/onimomimtosuba", R.drawable.omeyocan);
    Unique Sundance = new Unique("Sundance", 5, "http://poe.trade/search/sokurokikumaru", R.drawable.sundance);
    Unique Sunspite = new Unique("Sunspite", 5, "http://poe.trade/search/hatenitiretohu", R.drawable.sunspite);
    Unique Voidwalker = new Unique("Voidwalker", 5, "http://poe.trade/search/arasanokatazio", R.drawable.voidwalker);
    Unique DemigodsStride = new Unique("Demigod's Stride", 5, "http://poe.trade/search/okumonabakuwor", R.drawable.demigodsstride);
    Unique AtzirisAcuity = new Unique("Atziri's Acuity", 6, "http://poe.trade/search/iokagonoanokar", R.drawable.atzirisacuity);
    Unique CraiceannsPincers = new Unique("Craiceann's Pincers", 6, "http://poe.trade/search/hukotorausiniu", R.drawable.craiceannspincers);
    Unique DoryanisFist = new Unique("Doryani's Fist", 6, "http://poe.trade/search/aisasokumanyak", R.drawable.doryanisfist);
    Unique EmpiresGrasp = new Unique("Empire's Grasp", 6, "http://poe.trade/search/abookokiramime", R.drawable.empiresgrasp);
    Unique Giantsbane = new Unique("Giantsbane", 6, "http://poe.trade/search/basikikurahase", R.drawable.giantsbane);
    Unique LochtonialCaress = new Unique("Lochtonial Caress", 6, "http://poe.trade/search/hakinaruometoh", R.drawable.lochtonialcaress);
    Unique MeginordsVise = new Unique("Meginord's Vise", 6, "http://poe.trade/search/esamamonimirom", R.drawable.meginordsvise);
    Unique VerusosBatteringRams = new Unique("Veruso's Battering Rams", 6, "http://poe.trade/search/genoiitomokabe", R.drawable.verusosbatteringrams);
    Unique WindsofChange = new Unique("Winds of Change", 6, "http://poe.trade/search/aubusanamonage", R.drawable.windsofchange);
    Unique Hrimburn = new Unique("Hrimburn", 6, "http://poe.trade/search/azugonamotowah", R.drawable.hrimburn);
    Unique Hrimsorrow = new Unique("Hrimsorrow", 6, "http://poe.trade/search/asitoesimosina", R.drawable.hrimsorrow);
    Unique MaligarosVirtuosity = new Unique("Maligaro's Virtuosity", 6, "http://poe.trade/search/uoomohomazasim", R.drawable.maligarosvirtuosity);
    Unique Oskarm = new Unique("Oskarm", 6, "http://poe.trade/search/itemasubetoman", R.drawable.oskarm);
    Unique Allelopathy = new Unique("Allelopathy", 6, "http://poe.trade/search/inositeyoyomek", R.drawable.allelopathy);
    Unique AsenathsGentleTouch = new Unique("Asenath's Gentle Touch", 6, "http://poe.trade/search/ukoyahakiresik", R.drawable.asenathsgentletouch);
    Unique DemonStitcher = new Unique("Demon Stitcher", 6, "http://poe.trade/search/utokahitazugam", R.drawable.demonstitcher);
    Unique DoedresMalevolence = new Unique("Doedre's Malevolence", 6, "http://poe.trade/search/yomoserigutita", R.drawable.doedresmalevolence);
    Unique DoedresTenure = new Unique("Doedre's Tenure", 6, "http://poe.trade/search/enisabaregohiu", R.drawable.doedrestenure);
    Unique GripoftheCouncil = new Unique("Grip of the Council", 6, "http://poe.trade/search/ogowotomahazih", R.drawable.gripofthecouncil);
    Unique KalisasGrace = new Unique("Kalisa's Grace", 6, "http://poe.trade/search/abooyasisimkar", R.drawable.kalisasgrace);
    Unique SadimasTouch = new Unique("Sadima's Touch", 6, "http://poe.trade/search/aridohiwasimer", R.drawable.sadimastouch);
    Unique Voidbringer = new Unique("Voidbringer", 6, "http://poe.trade/search/akanaugokaukim", R.drawable.voidbringer);
    Unique Aurseize = new Unique("Aurseize", 6, "http://poe.trade/search/hoyoioharimiha", R.drawable.aueseize);
    Unique FarrulsPounce = new Unique("Farrul's Pounce", 6, "http://poe.trade/search/itarekigakohir", R.drawable.farrulspounce);
    Unique FleshandSpirit = new Unique("Flesh and Spirit", 6, "http://poe.trade/search/ozubahikosehum", R.drawable.fleshandspirit);
    Unique Haemophilia = new Unique("Haemophilia", 6, "http://poe.trade/search/amimohonianari", R.drawable.haemophilia);
    Unique Slitherpinch = new Unique("Slitherpinch", 6, "http://poe.trade/search/ananinowoakamo", R.drawable.slitherpinch);
    Unique Surgebinders = new Unique("Surgebinders", 6, "http://poe.trade/search/iworiyomohukon", R.drawable.surgebinders);
    Unique TombfistOne = new Unique("Tombfist (1 Abyssal Socket)", 6, "http://poe.trade/search/amizurirazomat", R.drawable.tombfistone);
    Unique TombfistTwo = new Unique("Tombfist (2 Abyssal Socket)", 6, "http://poe.trade/search/igugiamkahaudo", R.drawable.tombfisttwo);
    Unique VaalCaress = new Unique("Vaal Caress", 6, "http://poe.trade/search/oteyoduruiyuka", R.drawable.vaalcaress);
    Unique Wyrmsign = new Unique("Wyrmsign", 6, "http://poe.trade/search/itahagonahohod", R.drawable.wrymsign);
    Unique CommandofthePit = new Unique("Command of the Pit (1 Abyssal Socket)", 6, "http://poe.trade/search/arurimonohokob", R.drawable.commandofthepit);
    Unique CommandofthePitTwo = new Unique("Command of the Pit (2 Abyssal Socket)", 6, "http://poe.trade/search/hemoasarurudor", R.drawable.commandofthepittwo);
    Unique NullandVoid = new Unique("Null and Void", 6, "http://poe.trade/", R.drawable.nullandvoid);
    Unique Repentance = new Unique("Repentance", 6, "http://poe.trade/search/otemamomesedow", R.drawable.repentance);
    Unique SaqawalsWinds = new Unique("Saqawal's Winds", 6, "http://poe.trade/search/anakahuaminoko", R.drawable.saqawalswinds);
    Unique ShacklesoftheWretched = new Unique("Shackles of the Wretched", 6, "http://poe.trade/search/okonauanokohot", R.drawable.shackelsofthewretched);
    Unique ShapersTouch = new Unique("Shaper's Touch", 6, "http://poe.trade/search/ebawonarurahab", R.drawable.shaperstouch);
    Unique Southbound = new Unique("Southbound", 6, "http://poe.trade/search/nohinyoatosika", R.drawable.southbound);
    Unique VolkuursGuidanceOne = new Unique("Volkuur's Guidance (Lightning)", 6, "http://poe.trade/search/sugouhamtenahe", R.drawable.volkuursguidance);
    Unique VolkuursGuidanceTwo = new Unique("Volkuur's Guidance (Cold)", 6, "http://poe.trade/search/etehuritogohed", R.drawable.volkuursguidancetwo);
    Unique VolkuursGuidanceThree = new Unique("Volkuur's Guidance (Fire)", 6, "http://poe.trade/search/ohamaharowakak", R.drawable.volkuursguidancethree);
    Unique ArchitectsHand = new Unique("Architect's Hand", 6, "http://poe.trade/search/totegerakonani", R.drawable.architectshand);
    Unique BlasphemersGrasp = new Unique("Blasphemer's Grasp", 6, "http://poe.trade/search/akahukazahonoo", R.drawable.blasphemersgrasp);
    Unique Facebreaker = new Unique("Facebreaker", 6, "http://poe.trade/search/kositonataroke", R.drawable.facebreaker);
    Unique FenumusWeave = new Unique("Fenumus' Weave", 6, "http://poe.trade/search/okikikitewahun", R.drawable.fenumusweave);
    Unique MalachaisMark = new Unique("Malachai's Mark", 6, "http://poe.trade/search/onoteyoritunat", R.drawable.malachaismark);
    Unique OndarsClasp = new Unique("Ondar's Clasp", 6, "http://poe.trade/search/onahukonatotet", R.drawable.ondarsclasp);
    Unique ShadowsandDust = new Unique("Shadows and Dust", 6, "http://poe.trade/search/izubenodutakub", R.drawable.shadowsanddust);
    Unique SlavedriversHand = new Unique("Slavedriver's Hand", 6, "http://poe.trade/search/oyaririkisitat", R.drawable.slavedrivershand);
    Unique Snakebite = new Unique("Snakebite", 6, "http://poe.trade/", R.drawable.snakebite);
    Unique TheEmbalmer = new Unique("The Embalmer", 6, " ", R.drawable.theembalmer);
    Unique Thunderfist = new Unique("Thunderfist", 6, " ", R.drawable.thunderfist);

    Unique DemigodsTouch = new Unique("Demigod's Touch", 6, " ", R.drawable.demigodstouch);

//Helmets - code 7
    Unique Abyssus = new Unique("Abyssus", 7, " ", R.drawable.abyssus);
    Unique EzomyteHold = new Unique("Ezomyte Hold", 7, " ", R.drawable.ezomyte);
    Unique EzomytePeak = new Unique("Ezomyte Peak", 7, " ", R.drawable.ezomytepeak);
    Unique HrimnorsResolve = new Unique("Hrimnor's Resolve", 7, " ", R.drawable.hrimnorsresolve);
    Unique TheBaron = new Unique("The Baron", 7, " ", R.drawable.thebaron);
    Unique TheFormlessFlame = new Unique("The Formless Flame", 7, " ", R.drawable.theformlessflame);
    Unique TheFormlessInferno = new Unique("The Formless Inferno", 7, " ", R.drawable.theformlessinferno);

    Unique AlphasHowl = new Unique("Alpha's Howl", 7, " ", R.drawable.alphashowl);
    Unique FairgravesTricorne = new Unique("Fairgraves' Tricorne", 7, " ", R.drawable.fairgravestricorne);
    Unique Frostferno = new Unique("Frostferno", 7, " ", R.drawable.frostferno);
    Unique Goldrim = new Unique("Goldrim", 7, " ", R.drawable.goldrim);
    Unique Heatshiver = new Unique("Heatshiver", 7, " ", R.drawable.heatshiver);
    Unique Obscurantis = new Unique("Obscurantis", 7, " ", R.drawable.obscurantis);
    Unique RatsNest = new Unique("Rat's Nest", 7, " ", R.drawable.ratsnest);
    Unique SaqawalsFlock = new Unique("Saqawal's Flock", 7, " ", R.drawable.saqawalsflock);
    Unique StarkonjasHead = new Unique("Starkonja's Head", 7, " ", R.drawable.starkonjashead);

    Unique AsenathsChant = new Unique("Asenath's Chant", 7, " ", R.drawable.asenathschant);
    Unique AsenathsMark = new Unique("Asenath's Mark", 7, " ", R.drawable.asenathsmark);
    Unique ChitusApex = new Unique("Chitus' Apex", 7, " ", R.drawable.chitusapex);
    Unique CrownofEyes = new Unique("Crown of Eyes", 7, " ", R.drawable.crownofeyes);
    Unique CrownofThorns = new Unique("Crown of Thorns", 7, " ", R.drawable.crownofthornes);
    Unique DoedresScorn = new Unique("Doedre's Scorn", 7, " ", R.drawable.doedresscorn);
    Unique EbersUnification = new Unique("Eber's Unification", 7, " ", R.drawable.ebersunification);
    Unique FenumusToxins = new Unique("Fenumus' Toxins", 7, " ", R.drawable.fenumustoxins);
    Unique HaleNegatorOne = new Unique("Hale Negator (1 Abyssal Socket)", 7, " ", R.drawable.halenegator);
    Unique HaleNegatorTwo = new Unique("Hale Negator (2 Abyssal Socket)", 7, " ", R.drawable.halenegatortwo);
    Unique Indigon = new Unique("Indigon", 7, " ", R.drawable.indigon);
    Unique MarkoftheRedCovenant = new Unique("Mark of the Red Covenant", 7, " ", R.drawable.markoftheredcovenant);
    Unique MartyrsCrown = new Unique("Martyr's Crown", 7, " ", R.drawable.martyrscrown);
    Unique RimeGaze = new Unique("Rime Gaze", 7, " ", R.drawable.rimegaze);
    Unique ScoldsBridle = new Unique("Scold's Bridle", 7, " ", R.drawable.scoldsbridle);
    Unique Wraithlord = new Unique("Wraithlord", 7, " ", R.drawable.wraithlord);
    Unique YlfebansTrickery = new Unique("Ylfeban's Trickery", 7, " ", R.drawable.ylfebanstrickery);

    Unique BlackSunCrest = new Unique("Black Sun Crest", 7, " ", R.drawable.blacksuncrest);
    Unique Deidbell = new Unique("Deidbell", 7, " ", R.drawable.deidbell);
    Unique Deidbellow = new Unique("Deidbellow", 7, " ", R.drawable.deidbellow);
    Unique DevotosDevotion = new Unique("Devoto's Devotion", 7, " ", R.drawable.devotosdevotion);
    Unique Skullhead = new Unique("Skullhead", 7, " ", R.drawable.skullhead);
    Unique TheBringerofRain = new Unique("The Bringer of Rain", 7, " ", R.drawable.thebringerofrain);
    Unique ThePeregrine = new Unique("The Peregrine", 7, " ", R.drawable.theperegrine);

    Unique AhnsContempt = new Unique("Ahn's Contempt", 7, " ", R.drawable.ahnscontempt);
    Unique CraiceannsChitin = new Unique("Craiceann's Chitin", 7, " ", R.drawable.craiceannschitin);
    Unique CrownoftheTyrant = new Unique("Crown of the Tyrant", 7, " ", R.drawable.crownofthetyrant);
    Unique GeofrisCrest = new Unique("Geofri's Crest", 7, " ", R.drawable.geofriscrest);
    Unique GeofrisLegacy = new Unique("Geofri's Legacy", 7, " ", R.drawable.geofrislegacy);
    Unique Honourhome = new Unique("Honourhome", 7, " ", R.drawable.honourhome);
    Unique KitavasThirst = new Unique("Kitava's Thirst", 7, " ", R.drawable.kitavasthirst);
    Unique LightpoacherOne = new Unique("Lightpoacher (1 Abyssal Socket)", 7, " ", R.drawable.lightpoacher);
    Unique LightpoacherTwo = new Unique("Lightpoacher (2 Abyssal Socket)", 7, " ", R.drawable.lightpoachertwo);
    Unique MalachaisVision = new Unique("Malachai's Vision", 7, " ", R.drawable.malachaisvision);
    Unique MaskoftheSpiritDrinker = new Unique("Mask of the Spirit Drinker", 7, " ", R.drawable.maskofthespiritdrinker);
    Unique MaskoftheStitchedDemon = new Unique("Mask of the Stitched Demon", 7, " ", R.drawable.maskofthestitcheddemon);
    Unique MemoryVault = new Unique("Memory Vault", 7, " ", R.drawable.memoryvault);
    Unique Mindspiral = new Unique("Mindspiral", 7, " ", R.drawable.mindspiral);
    Unique SpeakersWreath = new Unique("Speaker's Wreath", 7, " ", R.drawable.speakerswreath);
    Unique TheBrineCrown = new Unique("The Brine Crown", 7, " ", R.drawable.thebrinecrown);
    Unique TheBrokenCrown = new Unique("The Broken Crown", 7, " ", R.drawable.thebrokencrown);
    Unique VeiloftheNight = new Unique("Veil of the Night", 7, " ", R.drawable.veilofthenight);
    Unique VollsVision = new Unique("Voll's Vision", 7, " ", R.drawable.vollsvision);

    Unique CrownofthePaleKing = new Unique("Crown of the Pale King", 7, " ", R.drawable.crownofthepaleking);
    Unique CurtainCall = new Unique("Curtain Call", 7, " ", R.drawable.curtaincall);
    Unique FarrulsBite = new Unique("Farrul's Bite", 7, " ", R.drawable.farrulsbite);
    Unique GorgonsGaze = new Unique("Gorgon's Gaze", 7, " ", R.drawable.gorgonsgaze);
    Unique HereticsVeil = new Unique("Heretic's Veil", 7, " ", R.drawable.hereticsveil);
    Unique LeerCast = new Unique("Leer Cast", 7, " ", R.drawable.leercast);
    Unique MalachaisAwakening = new Unique("Malachai's Awakening", 7, " ", R.drawable.malachaisawakening);
    Unique MalachaisSimula = new Unique("Malachai's Simula", 7, " ", R.drawable.malachaissimula);
    Unique MindoftheCouncil = new Unique("Mind of the Council", 7, " ", R.drawable.mindofthecouncil);
    Unique TheGull = new Unique("The Gull", 7, " ", R.drawable.thegull);
    Unique TheTempestsBinding = new Unique("The Tempest's Binding", 7, " ", R.drawable.thetempestsbinding);
    Unique TheThreeDragons = new Unique("The Three Dragons", 7, " ", R.drawable.thethreedragons);
    Unique TheVertex = new Unique("The Vertex", 7, " ", R.drawable.thevertex);

    Unique DemigodsTriumph = new Unique("Demigod's Triumph", 7, " ", R.drawable.demigodstriumph);

    //Shields - code 8
    Unique AhnsHeritage = new Unique("Ahn's Heritage", 8, " ", R.drawable.ahnsheritage);
    Unique ChernobogsPillar = new Unique("Chernobog's Pillar", 8, " ", R.drawable.chernobogspillar);
    Unique LioneyesRemorse = new Unique("Lioneye's Remorse", 8, " ", R.drawable.lioneyesremorse);
    Unique Lycosidae = new Unique("Lycosidae", 8, " ", R.drawable.lycosidae);
    Unique MagnaEclipsis = new Unique("Magna Eclipsis", 8, " ", R.drawable.magnaeclipsis);
    Unique RedbladeBanner = new Unique("Redblade Banner", 8, " ", R.drawable.redbladebanner);
    Unique TheAnticipation = new Unique("The Anticipation", 8, " ", R.drawable.theanticipation);
    Unique TheSurrender = new Unique("The Surrender", 8, " ", R.drawable.thesurrenderer);
    Unique TituciusSpan = new Unique("Titucius' Span", 8, " ", R.drawable.tituciusspan);
    Unique TrolltimberSpire = new Unique("Trolltimber Spire", 8, " ", R.drawable.trolltimberspire);
    Unique TukohamasFortress = new Unique("Tukohama's Fortress", 8, " ", R.drawable.tukohamasfortress);

    Unique AtzirisMirror = new Unique("Atziri's Mirror", 8, " ", R.drawable.atzirismirror);
    Unique AtzirisReflection = new Unique("Atziri's Reflection", 8, " ", R.drawable.atzirisreflection);
    Unique ChaliceofHorrors = new Unique("Chalice of Horrors", 8, " ", R.drawable.chaliceofhorrors);
    Unique CrestofPerandus = new Unique("Crest of Perandus", 8, " ", R.drawable.crestoftheperandus);
    Unique GreatOldOnesWard = new Unique("Great Old One's Ward", 8, " ", R.drawable.greatoldonesward);
    Unique Kaltenhalt = new Unique("Kaltenhalt", 8, " ", R.drawable.kaltenhalt);
    Unique Kaltensoul = new Unique("Kaltensoul", 8, " ", R.drawable.kaltensoul);
    Unique MutewindPennant = new Unique("Mutewind Pennant", 8, " ", R.drawable.mutewindpennant);
    Unique ThirstforHorrors = new Unique("Thirst for Horrors", 8, " ", R.drawable.thirstforhorrors);
    Unique ThousandTeethTemu = new Unique("Thousand Teeth Temu", 8, " ", R.drawable.thousandteethtemu);

    Unique ApepsSlumber = new Unique("Apep's Slumber", 8, " ", R.drawable.apepsslumber);
    Unique ApepsSupremacy = new Unique("Apep's Supremacy", 8, " ", R.drawable.apepssupremacy);
    Unique BrinerotFlag = new Unique("Brinerot Flag", 8, " ", R.drawable.brinerotflag);
    Unique EshsMirror = new Unique("Esh's Mirror", 8, " ", R.drawable.eshsmirror);
    Unique EshsVisage = new Unique("Esh's Visage", 8, " ", R.drawable.eshsvisage);
    Unique KongmingsStratagem = new Unique("Kongming's Stratagem", 8, " ", R.drawable.kongmingsstratgem);
    Unique LightofLunaris = new Unique("Light of Lunaris", 8, " ", R.drawable.lightoflunaris);
    Unique MalachaisLoop = new Unique("Malachai's Loop", 8, " ", R.drawable.malachaisloop);
    Unique MatuaTupuna = new Unique("Matua Tupuna", 8, " ", R.drawable.matuatupuna);
    Unique RathpithGlobe = new Unique("Rathpith Globe", 8, " ", R.drawable.rathpithglobe);
    Unique SentarisAnswer = new Unique("Sentari's Answer", 8, " ", R.drawable.sentarisanswer);
    Unique TheEternalApple = new Unique("The Eternal Apple", 8, " ", R.drawable.theeternalapple);

    Unique DaressosCourage = new Unique("Daresso's Courage", 8, " ", R.drawable.daressoscourage);
    Unique TheDeepOnesHide = new Unique("The Deep One's Hide", 8, " ", R.drawable.thedeeponeshide);
    Unique VixLunaris = new Unique("Vix Lunaris", 8, " ", R.drawable.vixlunaris);
    Unique WheeloftheStormsail = new Unique("Wheel of the Stormsail", 8, " ", R.drawable.wheelofthestormsail);

    Unique AegisAurora = new Unique("Aegis Aurora", 8, " ", R.drawable.aegisaurora);
    Unique BrokenFaith = new Unique("Broken Faith", 8, " ", R.drawable.brokenfaith);
    Unique InvictusSolaris = new Unique("Invictus Solaris", 8, " ", R.drawable.invictussolaris);
    Unique PrismGuardian = new Unique("Prism Guardian", 8, " ", R.drawable.prismgaurdian);
    Unique RiseofthePhoenix = new Unique("Rise of the Phoenix", 8, " ", R.drawable.riseofthephoenix);
    Unique SaffellsFrame = new Unique("Saffell's Frame", 8, " ", R.drawable.saffellsframe);
    Unique Springleaf = new Unique("Springleaf", 8, " ", R.drawable.springleaf);
    Unique TheOak = new Unique("The Oak", 8, " ", R.drawable.theoak);
    Unique TheUnshatteredWill = new Unique("The Unshattered Will", 8, " ", R.drawable.theunshatteredwill);
    Unique UnyieldingFlame = new Unique("Unyielding Flame", 8, " ", R.drawable.unyieldingflame);
    Unique VictariosCharity = new Unique("Victario's Charity", 8, " ", R.drawable.victarioscharity);

    Unique Glitterdisc = new Unique("Glitterdisc", 8, " ", R.drawable.glitterdisk);
    Unique JawsofAgony = new Unique("Jaws of Agony", 8, " ", R.drawable.jawsofagony);
    Unique LepersAlms = new Unique("Leper's Alms", 8, " ", R.drawable.lepersalms);
    Unique MaligarosLens = new Unique("Maligaro's Lens", 8, " ", R.drawable.maligaroslens);
    Unique ZeelsAmplifier = new Unique("Zeel's Amplifier", 8, " ", R.drawable.zeelsamplifier);

//Axes - code 9
    Unique Dreadarc = new Unique("Dreadarc", 9, " ", R.drawable.dreadarc);
    Unique Dreadsurge = new Unique("Dreadsurge", 9, " ", R.drawable.dreadsurge);
    Unique Dyadus = new Unique("Dyadus", 9, " ", R.drawable.dyadus);
    Unique JacktheAxe = new Unique("Jack, the Axe", 9, " ", R.drawable.jacktheaxe);
    Unique MoonbendersWing = new Unique("Moonbender's Wing", 9, " ", R.drawable.moonbenderswing);
    Unique RelentlessFury = new Unique("Relentless Fury", 9, " ", R.drawable.relentlessfurry);
    Unique RigwaldsSavagery = new Unique("Rigwald's Savagery", 9, " ", R.drawable.rigwaldssavagery);
    Unique SoulTaker = new Unique("Soul Taker", 9, " ", R.drawable.soultaker);
    Unique TheGryphon = new Unique("The Gryphon", 9, " ", R.drawable.thegryphon);
    Unique TheScreamingEagle = new Unique("The Screaming Eagle", 9, " ", R.drawable.thescreamingeagle);

    Unique AtzirisDisfavour = new Unique("Atziri's Disfavour", 9, " ", R.drawable.atzirisdisfavour);
    Unique DebeonsDirge = new Unique("Debeon's Dirge", 9, " ", R.drawable.debeonsdirge);
    Unique HezmanasBloodlust = new Unique("Hezmana's Bloodlust", 9, " ", R.drawable.hezmanasbloodlust);
    Unique KaomsPrimacy = new Unique("Kaom's Primacy", 9, " ", R.drawable.kaomsprimacy);
    Unique Kingmaker = new Unique("Kingmaker", 9, " ", R.drawable.kingmaker);
    Unique KitavasFeast = new Unique("Kitava's Feast", 9, " ", R.drawable.kitavasfeast);
    Unique Limbsplit = new Unique("Limbsplit", 9, " ", R.drawable.limbsplit);
    Unique NgamahusFlame = new Unique("Ngamahu's Flame", 9, " ", R.drawable.ngamahusflame);
    Unique ReapersPursuit = new Unique("Reaper's Pursuit", 9, " ", R.drawable.reaperspursuit);
    Unique SinvictasMettle = new Unique("Sinvicta's Mettle", 9, " ", R.drawable.sinvictasmettle);
    Unique TheBloodReaper = new Unique("The Blood Reaper", 9, " ", R.drawable.thebloodreaper);
    Unique TheCauteriser = new Unique("The Cauteriser", 9, " ", R.drawable.thecauteriser);
    Unique TheHarvest = new Unique("The Harvest", 9, " ", R.drawable.theharvest);
    Unique UulNetolsEmbrace = new Unique("Uul-Netol's Embrace", 9, " ", R.drawable.uulnetolsembrace);
    Unique UulNetolsKiss = new Unique("Uul-Netol's Kiss", 9, " ", R.drawable.uulnetolskiss);
    Unique Wideswing = new Unique("Wideswing", 9, " ", R.drawable.widesing);
    Unique WingsofEntropy = new Unique("Wings of Entropy", 9, " ", R.drawable.wingsofentropy);

//Bows - code 10
    Unique Arborix = new Unique("Arborix", 10, " ", R.drawable.arborix);
    Unique ChinSol = new Unique("Chin Sol", 10, " ", R.drawable.chinsol);
    Unique Darkscorn = new Unique("Darkscorn", 10, " ", R.drawable.darkscorn);
    Unique DeathsHarp = new Unique("Death's Harp", 10, " ", R.drawable.deathsharp);
    Unique DeathsOpus = new Unique("Death's Opus", 10, " ", R.drawable.deathsopus);
    Unique DoomfletchsPrism = new Unique("Doomfletch's Prism", 10, " ", R.drawable.doomfletchsprism);
    Unique Doomfletch = new Unique("Doomfletch", 10, " ", R.drawable.doomfletch);
    Unique Hopeshredder = new Unique("Hopeshredder", 10, " ", R.drawable.hopeshredder);
    Unique Infractem = new Unique("Infractem", 10, " ", R.drawable.infractem);
    Unique IronCommander = new Unique("Iron Commander", 10, " ", R.drawable.ironcommander);
    Unique LioneyesGlare = new Unique("Lioneye's Glare", 10, " ", R.drawable.lioneyesglare);
    Unique NullsInclination = new Unique("Null's Inclination", 10, " ", R.drawable.nullsinclination);
    Unique NurosHarp = new Unique("Nuro's Harp", 10, " ", R.drawable.nurosharp);
    Unique QuillRain = new Unique("Quill Rain", 10, " ", R.drawable.quillrain);
    Unique ReachoftheCouncil = new Unique("Reach of the Council", 10, " ", R.drawable.reachofthecouncil);
    Unique RothsReach = new Unique("Roth's Reach", 10, " ", R.drawable.rothsreach);
    Unique Silverbough = new Unique("Silverbough", 10, " ", R.drawable.silverbough);
    Unique Silverbranch = new Unique("Silverbranch", 10, " ", R.drawable.silverbranch);
    Unique Slivertongue = new Unique("Slivertongue", 10, " ", R.drawable.silvertoungue);
    Unique StormCloud = new Unique("Storm Cloud", 10, " ", R.drawable.stormcloud);
    Unique TheTempest = new Unique("The Tempest", 10, " ", R.drawable.thetempest);
    Unique VoltaxicRift = new Unique("Voltaxic Rift", 10, " ", R.drawable.voltaxicrift);
    Unique Windripper = new Unique("Windripper", 10, " ", R.drawable.windripper);
    Unique XophsInception = new Unique("Xoph's Inception", 10, " ", R.drawable.xophsinception);
    Unique XophsNurture = new Unique("Xoph's Nurture", 10, " ", R.drawable.xophsnurture);

//Claws - code 11
    Unique AdvancingFortress = new Unique("Advancing Fortress", 11, " ", R.drawable.advancingfortress);
    Unique AlDhih = new Unique("Al Dhih", 11, " ", R.drawable.aldhih);
    Unique Allure = new Unique("Allure", 11, " ", R.drawable.allure);
    Unique Bloodseeker = new Unique("Bloodseeker", 11, " ", R.drawable.bloodseeker);
    Unique CybilsPaw = new Unique("Cybil's Paw", 11, " ", R.drawable.cybilspaw);
    Unique EssentiaSanguis = new Unique("Essentia Sanguis", 11, " ", R.drawable.essentiasanguis);
    Unique HandofThoughtandMotion = new Unique("Hand of Thought and Motion", 11, " ", R.drawable.handofthoughtandmotion);
    Unique HandofWisdomandAction = new Unique("Hand of Wisdom and Action", 11, " ", R.drawable.handofwisdomandaction);
    Unique IzarosDilemma = new Unique("Izaro's Dilemma", 11, " ", R.drawable.izarosdilemma);
    Unique LastResort = new Unique("Last Resort", 11, " ", R.drawable.lastresort);
    Unique MortemMorsu = new Unique("Mortem Morsu", 11, " ", R.drawable.mortemmorsu);
    Unique OrnamentoftheEast = new Unique("Ornament of the East", 11, " ", R.drawable.ornamentoftheeast);
    Unique Rive = new Unique("Rive", 11, " ", R.drawable.rive);
    Unique TheScourge = new Unique("The Scourge", 11, " ", R.drawable.thescourge);
    Unique TheWaspNest = new Unique("The Wasp Nest", 11, " ", R.drawable.thewaspnest);
    Unique TouchofAnguish = new Unique("Touch of Anguish", 11, " ", R.drawable.touchofanguish);
    Unique Wildslash = new Unique("Wildslash", 11, " ", R.drawable.wildslash);

    //Daggers - code 12
    Unique ArakaalisFang = new Unique("Arakaali's Fang", 12, " ", R.drawable.arakaalisfang);
    Unique BinosKitchenKnife = new Unique("Bino's Kitchen Knife", 12, " ", R.drawable.binoskitchenknife);
    Unique Bloodplay = new Unique("Bloodplay", 12, " ", R.drawable.bloodplay);
    Unique Divinarius = new Unique("Divinarius", 12, " ", R.drawable.divinarius);
    Unique Goredrill = new Unique("Goredrill", 12, " ", R.drawable.goredrill);
    Unique Heartbreaker = new Unique("Heartbreaker", 12, " ", R.drawable.heartbreaker);
    Unique MarkoftheDoubtingKnight = new Unique("Mark of the Doubting Knight", 12, " ", R.drawable.markofthedoubtingknight);
    Unique Mightflay = new Unique("Mightflay", 12, " ", R.drawable.mightflay);
    Unique SanguineGambol = new Unique("Sanguine Gambol", 12, " ", R.drawable.sanguinegambol);
    Unique Taproot = new Unique("Taproot", 12, " ", R.drawable.taproot);
    Unique TheConsumingDark = new Unique("The Consuming Dark", 12, " ", R.drawable.theconsumingdark);
    Unique UngilsGauche = new Unique("Ungil's Gauche", 12, " ", R.drawable.ungilsgauche);
    Unique Vulconus = new Unique("Vulconus", 12, " ", R.drawable.vulconus);
    Unique WhiteWind = new Unique("White Wind", 12, " ", R.drawable.whitewind);
    Unique Widowmaker = new Unique("Widowmaker", 12, " ", R.drawable.widowmaker);

//Fishing Rods - code 13
    Unique Reefbane = new Unique("Reefbane", 13, " ", R.drawable.reefbane);
    Unique SongoftheSirens = new Unique("Song of the Sirens", 13, " ", R.drawable.songofthesirens);

//Maces - code 14
    Unique Brightbeak = new Unique("Brightbeak", 14, " ", R.drawable.brightbeak);
    Unique CallinellusMalleus = new Unique("Callinellus Malleus", 14, " ", R.drawable.callinellusmalleus);
    Unique CameriasAvarice = new Unique("Cameria's Avarice", 14, " ", R.drawable.cameriasavarice);
    Unique CameriasMaul = new Unique("Cameria's Maul", 14, " ", R.drawable.cameriasmaul);
    Unique Clayshaper = new Unique("Clayshaper", 14, " ", R.drawable.clayshaper);
    Unique FleshEater = new Unique("Flesh-Eater", 14, " ", R.drawable.flesheater);
    Unique Frostbreath = new Unique("Frostbreath", 14, " ", R.drawable.frostbreath);
    Unique Gorebreaker = new Unique("Gorebreaker", 14, " ", R.drawable.gorebreaker);
    Unique LaviangasWisdom = new Unique("Lavianga's Wisdom", 14, " ", R.drawable.laviangaswisdom);
    Unique Mjolner = new Unique("Mjölner", 14, " ", R.drawable.mjolner);
    Unique Nebuloch = new Unique("Nebuloch", 14, " ", R.drawable.nebuloch);

    Unique Augyre = new Unique("Augyre", 14, " ", R.drawable.augyre);
    Unique AxiomPerpetuum = new Unique("Axiom Perpetuum", 14, " ", R.drawable.axiomperpetuum);
    Unique Balefire = new Unique("Balefire", 14, " ", R.drawable.balefire);
    Unique Bitterdream = new Unique("Bitterdream", 14, " ", R.drawable.bitterdream);
    Unique BreathoftheCouncil = new Unique("Breath of the Council", 14, " ", R.drawable.breathofthecouncil);
    Unique BrutusLeadSprinkler = new Unique("Brutus' Lead Sprinkler", 14, " ", R.drawable.brutusleadsprinkler);
    Unique CerberusLimb = new Unique("Cerberus Limb", 14, " ", R.drawable.cerberuslimb);
    Unique DeathsHand = new Unique("Death's Hand", 14, " ", R.drawable.deathshand);
    Unique DoonCuebiyari = new Unique("Doon Cuebiyari", 14, " ", R.drawable.dooncuebiyari);
    Unique DoryanisCatalyst = new Unique("Doryani's Catalyst", 14, " ", R.drawable.doryaniscatalyst);
    Unique EarendelsEmbrace = new Unique("Earendel's Embrace", 14, " ", R.drawable.earendelsembrace);
    Unique MontregulsGrasp = new Unique("Mon'tregul's Grasp", 14, " ", R.drawable.montregulsgrasp);
    Unique NyctasLantern = new Unique("Nycta's Lantern", 14, " ", R.drawable.nyctaslantern);
    Unique Singularity = new Unique("Singularity", 14, " ", R.drawable.singularity);
    Unique SpineoftheFirstClaimant = new Unique("Spine of the First Claimant", 14, " ", R.drawable.spineofthefirstclaimant);
    Unique TheDarkSeerOne = new Unique("The Dark Seer (Life ES)", 14, " ", R.drawable.thedarkseerone);
    Unique TheDarkSeerTwo = new Unique("The Dark Seer (Mana ES)", 14, " ", R.drawable.thedarkseertwo);
    Unique TheDarkSeerThree = new Unique("The Dark Seer (Life Mana)", 14, " ", R.drawable.thedarkseerthree);
    Unique TheSupremeTruth = new Unique("The Supreme Truth", 14, " ", R.drawable.thesupremetruth);

    Unique BrainRattler = new Unique("Brain Rattler", 14, " ", R.drawable.brainrattler);
    Unique ChaberCairn = new Unique("Chaber Cairn", 14, " ", R.drawable.chabercairn);
    Unique ChoberChaber = new Unique("Chober Chaber", 14, " ", R.drawable.choberchaber);
    Unique GeofrisBaptism = new Unique("Geofri's Baptism", 14, " ", R.drawable.geofrisbaptism);
    Unique GeofrisDevotion = new Unique("Geofri's Devotion", 14, " ", R.drawable.geofrisdevotion);
    Unique HrimnorsDirge = new Unique("Hrimnor's Dirge", 14, " ", R.drawable.hrimnorsdirge);
    Unique HrimnorsHymn = new Unique("Hrimnor's Hymn", 14, " ", R.drawable.hrimnorshymn);
    Unique JorrhastsBlacksteel = new Unique("Jorrhast's Blacksteel", 14, " ", R.drawable.jorrhastsblacksteel);
    Unique KongorsUndyingRage = new Unique("Kongor's Undying Rage", 14, " ", R.drawable.kongorsundyingrage);
    Unique MarohiErqi = new Unique("Marohi Erqi", 14, " ", R.drawable.marohierqi);
    Unique Panquetzaliztli = new Unique("Panquetzaliztli", 14, " ", R.drawable.panquetzaliztli);
    Unique Quecholli = new Unique("Quecholli", 14, " ", R.drawable.quencholli);
    Unique Tidebreaker = new Unique("Tidebreaker", 14, " ", R.drawable.tidebreaker);
    Unique Trypanon = new Unique("Trypanon", 14, " ", R.drawable.trypanon);
    Unique Voidhome = new Unique("Voidhome", 14, " ", R.drawable.voidhome);

//Staffes - code 15
    Unique AgnerodEast = new Unique("Agnerod East", 15, " ", R.drawable.agnerodeast);
    Unique AgnerodNorth = new Unique("Agnerod North", 15, " ", R.drawable.agnerodnorth);
    Unique AgnerodSouth = new Unique("Agnerod South", 15, " ", R.drawable.agnerodsouth);
    Unique AgnerodWest = new Unique("Agnerod West", 15, " ", R.drawable.agnerodwest);
    Unique CaneofUnravelling = new Unique("Cane of Unravelling", 15, " ", R.drawable.caneofunravelling);
   //check for picture quality
    Unique Disintegrator = new Unique("Disintegrator", 15, " ", R.drawable.disintegrator);
    Unique Duskdawn = new Unique("Duskdawn", 15, " ", R.drawable.duskdawn);
    Unique DyingBreath = new Unique("Dying Breath", 15, " ", R.drawable.dyingbreath);
    Unique FemursoftheSaints = new Unique("Femurs of the Saints", 15, " ", R.drawable.femursofthesaints);
    Unique Fencoil = new Unique("Fencoil", 15, " ", R.drawable.fencoil);
    Unique HegemonysEra = new Unique("Hegemony's Era", 15, " ", R.drawable.hegemonysera);
    Unique MartyrofInnocence = new Unique("Martyr of Innocence", 15, " ", R.drawable.martyrofinnocence);
    Unique Mirebough = new Unique("Mirebough", 15, " ", R.drawable.mirebouch);
    Unique PillaroftheCagedGod = new Unique("Pillar of the Caged God", 15, " ", R.drawable.pillarofthecagedgod);
    Unique PledgeofHands = new Unique("Pledge of Hands", 15, " ", R.drawable.pledgeofhands);
    Unique RealmEnder = new Unique("Realm Ender", 15, " ", R.drawable.realmender);
    Unique Realmshaper = new Unique("Realmshaper", 15, " ", R.drawable.realmshaper);
    Unique SireofShards = new Unique("Sire of Shards", 15, " ", R.drawable.sireofshards);
    Unique Soulwrest = new Unique("Soulwrest", 15, " ", R.drawable.soulwrest);
    Unique TarynsShiver = new Unique("Taryn's Shiver", 15, " ", R.drawable.tarynsshiver);
    Unique TheBloodThorn = new Unique("The Blood Thorn", 15, " ", R.drawable.thebloodthorn);
    Unique TheEnmityDivine = new Unique("The Enmity Divine", 15, " ", R.drawable.theenmitydivine);
    Unique TheGreySpire = new Unique("The Grey Spire", 15, " ", R.drawable.thegreyspire);
    Unique TheSearingTouch = new Unique("The Searing Touch", 15, " ", R.drawable.thesearingtouch);
    Unique TheStormheart = new Unique("The Stormheart", 15, " ", R.drawable.thestormheart);
    Unique TheStormwall = new Unique("The Stormwall", 15, " ", R.drawable.thestormwall);
    Unique TheWhisperingIce = new Unique("The Whispering Ice", 15, " ", R.drawable.thewhisperingice);
    Unique TremorRod = new Unique("Tremor Rod", 15, " ", R.drawable.tremorrod);
    Unique XirgilsCrank = new Unique("Xirgil's Crank", 15, " ", R.drawable.xirgilscrank);

//Swords - code 16
    Unique AhnsMight = new Unique("Ahn's Might", 16, " ", R.drawable.ahnsmight);
    Unique BeltimberBlade = new Unique("Beltimber Blade", 16, " ", R.drawable.beltimberblade);
    Unique Dreadbeak = new Unique("Dreadbeak", 16, " ", R.drawable.dreadbeak);
    Unique Dreamfeather = new Unique("Dreamfeather", 16, " ", R.drawable.dreamfeather);
    Unique EphemeralEdge = new Unique("Ephemeral Edge", 16, " ", R.drawable.ephemeraledge);
    Unique FateoftheVaal = new Unique("Fate of the Vaal", 16, " ", R.drawable.fateofthevaal);
    Unique GrelwoodShank = new Unique("Grelwood Shank", 16, " ", R.drawable.grelwoodshank);
    Unique HyaonsFury = new Unique("Hyaon's Fury", 16, " ", R.drawable.hyaonsfury);
    Unique Ichimonji = new Unique("Ichimonji", 16, " ", R.drawable.ichimonji);
    Unique InnsburyEdge = new Unique("Innsbury Edge", 16, " ", R.drawable.innsburyedge);
    Unique LakishusBlade = new Unique("Lakishu's Blade", 16, " ", R.drawable.lakishusblade);
    Unique OniGoroshi = new Unique("Oni-Goroshi", 16, " ", R.drawable.onigoroshi);
    Unique PrismaticEclipse = new Unique("Prismatic Eclipse", 16, " ", R.drawable.prismaticeclipse);
    Unique RazoroftheSeventhSun = new Unique("Razor of the Seventh Sun", 16, " ", R.drawable.razoroftheseventhsun);
    Unique RebukeoftheVaal = new Unique("Rebuke of the Vaal", 16, " ", R.drawable.rebukeofthevaal);
    Unique Redbeak = new Unique("Redbeak", 16, " ", R.drawable.redbeak);
    Unique RigwaldsCommand = new Unique("Rigwald's Command", 16, " ", R.drawable.rigwaldscommand);
    Unique Scaeva = new Unique("Scaeva", 16, " ", R.drawable.scaeva);
    Unique SeveredinSleep = new Unique("Severed in Sleep", 16, " ", R.drawable.severedinsleep);
    Unique StoryoftheVaal = new Unique("Story of the Vaal", 16, " ", R.drawable.storyofthevaal);
    Unique TheGoddessScorned = new Unique("The Goddess Scorned", 16, " ", R.drawable.thegoddessscorned);
    Unique ThePrincess = new Unique("The Princess", 16, " ", R.drawable.theprincess);
    Unique TheRipplingThoughts = new Unique("The Rippling Thoughts", 16, " ", R.drawable.theripplingthoughts);
    Unique TheTempestuousSteel = new Unique("The Tempestuous Steel", 16, " ", R.drawable.thetempestuoussteel);
    Unique UnitedinDream = new Unique("United in Dream", 16, " ", R.drawable.unitedindream);
    Unique Varunastra = new Unique("Varunastra", 16, " ", R.drawable.varunastra);

    Unique Aurumvorax = new Unique("Aurumvorax", 16, " ", R.drawable.aurumvorax);
    Unique ChitusNeedle = new Unique("Chitus' Needle", 16, " ", R.drawable.chitusneedle);
    Unique CosprisMalice = new Unique("Cospri's Malice", 16, " ", R.drawable.cosprismalice);
    Unique DaressosPassion = new Unique("Daresso's Passion", 16, " ", R.drawable.daressospassion);
    Unique EwarsMirage = new Unique("Ewar's Mirage", 16, " ", R.drawable.ewarsmirage);
    Unique FidelitasSpike = new Unique("Fidelitas' Spike", 16, " ", R.drawable.fidelitasspike);
    Unique TheGoddessBound = new Unique("The Goddess Bound", 16, " ", R.drawable.thegoddessbound);

    Unique Doomsower = new Unique("Doomsower", 16, " ", R.drawable.doomshower);
    Unique EdgeofMadness = new Unique("Edge of Madness", 16, " ", R.drawable.edgeofmadness);
    Unique Hiltless = new Unique("Hiltless", 16, " ", R.drawable.hiltless);
    Unique KondosPride = new Unique("Kondo's Pride", 16, " ", R.drawable.kondospride);
    Unique OrosSacrifice = new Unique("Oro's Sacrifice", 16, " ", R.drawable.orossacrifice);
    Unique QueensDecree = new Unique("Queen's Decree", 16, " ", R.drawable.queensdecree);
    Unique QueensEscape = new Unique("Queen's Escape", 16, " ", R.drawable.queensescape);
    Unique RigwaldsCharge = new Unique("Rigwald's Charge", 16, " ", R.drawable.rigwaldscharge);
    Unique Shiversting = new Unique("Shiversting", 16, " ", R.drawable.shiversting);
    Unique Starforge = new Unique("Starforge", 16, " ", R.drawable.starforge);
    Unique TerminusEst = new Unique("Terminus Est", 16, " ", R.drawable.terminusest);
    Unique TheDancingDervish = new Unique("The Dancing Dervish", 16, " ", R.drawable.thedancingdervish);
    Unique TheDancingDuo = new Unique("The Dancing Duo", 16, " ", R.drawable.thedancingduo);
    Unique Voidforge = new Unique("Voidforge", 16, " ", R.drawable.voidforge);

//Wands - code 17
    Unique AbberathsHorn = new Unique("Abberath's Horn", 17, " ", R.drawable.abberathshorn);
    Unique AmplificationRod = new Unique("Amplification Rod", 17, " ", R.drawable.amplificationrod);
    Unique ApepsRage = new Unique("Apep's Rage", 17, " ", R.drawable.apepsrage);
    Unique Ashcaller = new Unique("Ashcaller", 17, " ", R.drawable.ashcaller);
    Unique CoronaSolaris = new Unique("Corona Solaris", 17, " ", R.drawable.coronasolaris);
    Unique EclipseSolaris = new Unique("Eclipse Solaris", 17, " ", R.drawable.eclipsesolaris);
    Unique Lifesprig = new Unique("Lifesprig", 17, " ", R.drawable.lifesprig);
    Unique MidnightBargain = new Unique("Midnight Bargain", 17, " ", R.drawable.midnightbargain);
    Unique Moonsorrow = new Unique("Moonsorrow", 17, " ", R.drawable.moonsorrow);
    Unique Obliteration = new Unique("Obliteration", 17, " ", R.drawable.obliteration);
    Unique PiscatorsVigil = new Unique("Piscator's Vigil", 17, " ", R.drawable.piscatorsvigil);
    Unique ReverberationRod = new Unique("Reverberation Rod", 17, " ", R.drawable.reverberationrod);
    Unique ShadeofSolaris = new Unique("Shade of Solaris", 17, " ", R.drawable.shadeofsolaris);
    Unique Shimmeron = new Unique("Shimmeron", 17, " ", R.drawable.shimmeron);
    Unique StormPrison = new Unique("Storm Prison", 17, " ", R.drawable.stormprison);
    Unique ThePoetsPen = new Unique("The Poet's Pen", 17, " ", R.drawable.thepoetspen);
    Unique Tulborn = new Unique("Tulborn", 17, " ", R.drawable.tulborn);
    Unique Tulfall = new Unique("Tulfall", 17, " ", R.drawable.tulfall);
    Unique Twyzel = new Unique("Twyzel", 17, " ", R.drawable.twyzel);
    Unique VoidBattery = new Unique("Void Battery", 17, " ", R.drawable.voidbattery);

//Flasks - code 18
    Unique BloodoftheKarui = new Unique("Blood of the Karui", 18, " ", R.drawable.bloodofthekarui);

    Unique DoedresElixir = new Unique("Doedre's Elixir", 18, " ", R.drawable.doedreselixir);
    Unique LaviangasSpirit = new Unique("Lavianga's Spirit", 18, " ", R.drawable.laviangasspirit);
    Unique ZerphisLastBreath = new Unique("Zerphi's Last Breath", 18, " ", R.drawable.zephrislastbreath);

    Unique DivinationDistillate = new Unique("Divination Distillate", 18, " ", R.drawable.divinationdistillate);
    Unique TheWrithingJar = new Unique("The Writhing Jar", 18, " ", R.drawable.thewrithingjar);

    Unique AtzirisPromise = new Unique("Atziri's Promise", 18, " ", R.drawable.atzirispromise);
    Unique CoruscatingElixir = new Unique("Coruscating Elixir", 18, " ", R.drawable.coruscatingelixir);
    Unique DyingSun = new Unique("Dying Sun", 18, " ", R.drawable.dyingsun);
    Unique ForbiddenTaste = new Unique("Forbidden Taste", 18, " ", R.drawable.forbiddentaste);
    Unique KiarasDetermination = new Unique("Kiara's Determination", 18, " ", R.drawable.kiarasdetermination);
    Unique LionsRoar = new Unique("Lion's Roar", 18, " ", R.drawable.lionsroar);
    Unique Rotgut = new Unique("Rotgut", 18, " ", R.drawable.rotgut);
    Unique RumisConcoction = new Unique("Rumi's Concoction", 18, " ", R.drawable.rumisconcoction);
    Unique SinsRebirth = new Unique("Sin's Rebirth", 18, " ", R.drawable.sinsrebirth);
    Unique SoulCatcher = new Unique("Soul Catcher", 18, " ", R.drawable.soulcatcher);
    Unique SoulRipper = new Unique("Soul Ripper", 18, " ", R.drawable.soulripper);
    Unique TasteofHate = new Unique("Taste of Hate", 18, " ", R.drawable.tasteofhate);
    Unique TheOverflowingChalice = new Unique("The Overflowing Chalice", 18, " ", R.drawable.theoverflowingchalice);
    Unique TheSorrowoftheDivine = new Unique("The Sorrow of the Divine", 18, " ", R.drawable.thesorrowofthedivine);
    Unique TheWiseOak = new Unique("The Wise Oak", 18, " ", R.drawable.thewiseoak);
    Unique VesselofVinktarOne = new Unique("Vessel of Vinktar (Physical Damage Converted to Lightning Damage)", 18, " ", R.drawable.vesselofvinktarone);
    Unique VesselofVinktarTwo = new Unique("Vessel of Vinktar (Added Lightning Damage to Spells)", 18, " ", R.drawable.vesselofvinktartwo);
    Unique VesselofVinktarThree = new Unique("Vessel of Vinktar (Added Lightning Damage to Attacks)", 18, " ", R.drawable.vesselofvinktarthree);
    Unique VesselofVinktarFour = new Unique("Vessel of Vinktar (Lightning Penetration)", 18, " ", R.drawable.vesselofvinktarfour);
    Unique WitchfireBrew = new Unique("Witchfire Brew", 18, " ", R.drawable.witchfirebrew);

//Jewels - code 19
    Unique AnatomicalKnowledge = new Unique("Anatomical Knowledge", 19, " ", R.drawable.anatomicalknowlendge);
    Unique Apparitions = new Unique("Apparitions", 19, " ", R.drawable.apparitions);
    Unique AssassinsHaste = new Unique("Assassin's Haste", 19, " ", R.drawable.assassinshaste);
    Unique Brawn = new Unique("Brawn", 19, " ", R.drawable.brawn);
    Unique BruteForceSolution = new Unique("Brute Force Solution", 19, " ", R.drawable.bruteforcesolution);
    Unique CarefulPlanning = new Unique("Careful Planning", 19, " ", R.drawable.carefullplanning);
    Unique CheapConstruction = new Unique("Cheap Construction", 19, " ", R.drawable.cheapconstruction);
    Unique ClearMind = new Unique("Clear Mind", 19, " ", R.drawable.clearmind);
    Unique CoatedShrapnel = new Unique("Coated Shrapnel", 19, " ", R.drawable.coatedshrapnel);
    Unique ColdSteel = new Unique("Cold Steel", 19, " ", R.drawable.coldsteel);
    Unique CollateralDamage = new Unique("Collateral Damage", 19, " ", R.drawable.collateraldamage);
    Unique CombatFocusOne = new Unique("Combat Focus (Cobalt Jewel)", 19, " ", R.drawable.combatfocusone);
    Unique CombatFocusTwo = new Unique("Combat Focus (Crimson Jewel)", 19, " ", R.drawable.combatfocustwo);
    Unique CombatFocusThree = new Unique("Combat Focus (Viridian Jewel)", 19, " ", R.drawable.combatfocusthree);
    Unique ConquerorsEfficiency = new Unique("Conqueror's Efficiency", 19, " ", R.drawable.conquerorsefficiency);
    Unique ConquerorsLongevity = new Unique("Conqueror's Longevity", 19, " ", R.drawable.conquerorslongevity);
    Unique ConquerorsPotency = new Unique("Conqueror's Potency", 19, " ", R.drawable.conquerorspotency);
    Unique DeadReckoning = new Unique("Dead Reckoning", 19, " ", R.drawable.deadreckoning);
    Unique EfficientTraining = new Unique("Efficient Training", 19, " ", R.drawable.efficienttraining);
    Unique EldritchKnowledge = new Unique("Eldritch Knowledge", 19, " ", R.drawable.eldritchknowledge);
    Unique EmperorsCunning = new Unique("Emperor's Cunning", 19, " ", R.drawable.emperorscunning);
    Unique EmperorsMastery = new Unique("Emperor's Mastery", 19, " ", R.drawable.emperorsmastery);
    Unique EmperorsMight = new Unique("Emperor's Might", 19, " ", R.drawable.emperorsmight);
    Unique EmperorsWit = new Unique("Emperor's Wit", 19, " ", R.drawable.emperorswit);
    Unique EnergisedArmour = new Unique("Energised Armour", 19, " ", R.drawable.energisedarmour);
    Unique EnergyFromWithin = new Unique("Energy From Within", 19, " ", R.drawable.energyfromwithin);
    Unique FertileMind = new Unique("Fertile Mind", 19, " ", R.drawable.fertilemind);
    Unique FightforSurvival = new Unique("Fight for Survival", 19, " ", R.drawable.fightforsurvival);
    Unique Fireborn = new Unique("Fireborn", 19, " ", R.drawable.fireborn);
    Unique FirstSnow = new Unique("First Snow", 19, " ", R.drawable.firstsnow);
    Unique FluidMotion = new Unique("Fluid Motion", 19, " ", R.drawable.fluidmotion);
    Unique FortifiedLegion = new Unique("Fortified Legion", 19, " ", R.drawable.fortifiedlegion);
    Unique FragileBloom = new Unique("Fragile Bloom", 19, " ", R.drawable.fragilebloom);
    Unique FromDust = new Unique("From Dust", 19, " ", R.drawable.fromdust);
    Unique FrozenTrail = new Unique("Frozen Trail", 19, " ", R.drawable.frozentrail);
    Unique GrandSpectrumOne = new Unique("Grand Spectrum (Viridian Jewel)", 19, " ", R.drawable.grandspectrum);
    Unique GrandSpectrumTwo = new Unique("Grand Spectrum (Crimson Jewel)", 19, " ", R.drawable.grandspectrumtwo);
    Unique GrandSpectrumThree = new Unique("Grand Spectrum (Cobalt Jewel)", 19, " ", R.drawable.grandspectrumthree);
    Unique GrowingAgony = new Unique("Growing Agony", 19, " ", R.drawable.growingagony);
    Unique HairTrigger = new Unique("Hair Trigger", 19, " ", R.drawable.hairtrigger);
    Unique HazardousResearch = new Unique("Hazardous Research", 19, " ", R.drawable.hazardousresearch);
    Unique HealthyMind = new Unique("Healthy Mind", 19, " ", R.drawable.healthymind);
    Unique HiddenPotential = new Unique("Hidden Potential", 19, " ", R.drawable.hiddenpotential);
    Unique Hotfooted = new Unique("Hotfooted", 19, " ", R.drawable.hotfooted);
    Unique Inertia = new Unique("Inertia", 19, " ", R.drawable.intertia);
    Unique Inevitability = new Unique("Inevitability", 19, " ", R.drawable.inevitability);
    Unique InspiredLearning = new Unique("Inspired Learning", 19, " ", R.drawable.inspiredlearning);
    Unique IntuitiveLeap = new Unique("Intuitive Leap", 19, " ", R.drawable.intuitiveleap);
    Unique IzarosTurmoil = new Unique("Izaro's Turmoil", 19, " ", R.drawable.izarosturmoil);
    Unique LioneyesFall = new Unique("Lioneye's Fall", 19, " ", R.drawable.lioneyesfall);
    Unique MaliciousIntent = new Unique("Malicious Intent", 19, " ", R.drawable.malicousintent);
    Unique MantraofFlames = new Unique("Mantra of Flames", 19, " ", R.drawable.mantraofflames);
    Unique MartialArtistry = new Unique("Martial Artistry", 19, " ", R.drawable.martialartistry);
    Unique MightandInfluence = new Unique("Might and Influence", 19, " ", R.drawable.mightandinfluence);
    Unique MightinAllForms = new Unique("Might in All Forms", 19, " ", R.drawable.mightinallforms);
    Unique MightoftheMeek = new Unique("Might of the Meek", 19, " ", R.drawable.mightofthemeek);
    Unique OmenontheWinds = new Unique("Omen on the Winds", 19, " ", R.drawable.omenonthewinds);
    Unique OverwhelmingOdds = new Unique("Overwhelming Odds", 19, " ", R.drawable.overwhelmingodds);
    Unique PitchDarkness = new Unique("Pitch Darkness", 19, " ", R.drawable.pitchdarkness);
    Unique PoachersAim = new Unique("Poacher's Aim", 19, " ", R.drawable.poachersaim);
    Unique PrimordialEminence = new Unique("Primordial Eminence", 19, " ", R.drawable.primordialeminence);
    Unique PrimordialHarmony = new Unique("Primordial Harmony", 19, " ", R.drawable.primordialharmony);
    Unique PrimordialMight = new Unique("Primordial Might", 19, " ", R.drawable.primordialmight);
    Unique Pugilist = new Unique("Pugilist", 19, " ", R.drawable.pugilist);
    Unique PureTalent = new Unique("Pure Talent", 19, " ", R.drawable.puretalent);
    Unique RainofSplinters = new Unique("Rain of Splinters", 19, " ", R.drawable.rainofsplinters);
    Unique RapidExpansion = new Unique("Rapid Expansion", 19, " ", R.drawable.rapidexpansion);
    Unique RecklessDefence = new Unique("Reckless Defence", 19, " ", R.drawable.recklessdefence);
    Unique RingofBlades = new Unique("Ring of Blades", 19, " ", R.drawable.ringofblades);
    Unique RollingFlames = new Unique("Rolling Flames", 19, " ", R.drawable.rollingflames);
    Unique ShatteredChains = new Unique("Shattered Chains", 19, " ", R.drawable.shatteredchains);
    Unique SoulsWick = new Unique("Soul's Wick", 19, " ", R.drawable.soulswick);
    Unique SpireofStone = new Unique("Spire of Stone", 19, " ", R.drawable.spireofsoul);
    Unique SpiritGuards = new Unique("Spirit Guards", 19, " ", R.drawable.spiritguards);
    Unique SpiritedResponse = new Unique("Spirited Response", 19, " ", R.drawable.spiritedresponse);
    Unique SpreadingRot = new Unique("Spreading Rot", 19, " ", R.drawable.spreadingrot);
    Unique StaticElectricity = new Unique("Static Electricity", 19, " ", R.drawable.staticelectricity);
    Unique SteelSpirit = new Unique("Steel Spirit", 19, " ", R.drawable.steelspirit);
    Unique SuddenIgnition = new Unique("Sudden Ignition", 19, " ", R.drawable.suddenignition);
    Unique SurvivalInstincts = new Unique("Survival Instincts", 19, " ", R.drawable.survivalinstincts);
    Unique SurvivalSecrets = new Unique("Survival Secrets", 19, " ", R.drawable.survivalsecrets);
    Unique SurvivalSkills = new Unique("Survival Skills", 19, " ", R.drawable.survivalskills);
    Unique TemperedFlesh = new Unique("Tempered Flesh", 19, " ", R.drawable.temperedflesh);
    Unique TemperedMind = new Unique("Tempered Mind", 19, " ", R.drawable.temperedmind);
    Unique TemperedSpirit = new Unique("Tempered Spirit", 19, " ", R.drawable.temperedspirit);
    Unique TheAnimaStone = new Unique("The Anima Stone", 19, " ", R.drawable.theanimastone);
    Unique TheBlueDream = new Unique("The Blue Dream", 19, " ", R.drawable.thebluedream);
    Unique TheBlueNightmare = new Unique("The Blue Nightmare", 19, " ", R.drawable.thebluenightmare);
    Unique TheGoldenRule = new Unique("The Golden Rule", 19, " ", R.drawable.thegoldenrule);
    Unique TheGreenDream = new Unique("The Green Dream", 19, " ", R.drawable.thegreendream);
    Unique TheGreenNightmare = new Unique("The Green Nightmare", 19, " ", R.drawable.thegreennightmare);
    Unique TheLongWinter = new Unique("The Long Winter", 19, " ", R.drawable.thelongwinter);
    Unique TheRedDream = new Unique("The Red Dream", 19, " ", R.drawable.thereddream);
    Unique TheRedNightmare = new Unique("The Red Nightmare", 19, " ", R.drawable.therednightmare);
    Unique TheVigil = new Unique("The Vigil", 19, " ", R.drawable.thevigil);
    Unique ToDust = new Unique("To Dust", 19, " ", R.drawable.todust);
    Unique TranscendentFlesh = new Unique("Transcendent Flesh", 19, " ", R.drawable.transcendentflesh);
    Unique TranscendentMind = new Unique("Transcendent Mind", 19, " ", R.drawable.transcendentmind);
    Unique TranscendentSpirit = new Unique("Transcendent Spirit", 19, " ", R.drawable.transcendentspirit);
    Unique UnendingHunger = new Unique("Unending Hunger", 19, " ", R.drawable.unendinghunger);
    Unique UnnaturalInstinct = new Unique("Unnatural Instinct", 19, " ", R.drawable.unnaturalinstinct);
    Unique UnstablePayload = new Unique("Unstable Payload", 19, " ", R.drawable.unstablepayload);
    Unique ViolentDead = new Unique("Violent Dead", 19, " ", R.drawable.violentdead);
    Unique VolleyFire = new Unique("Volley Fire", 19, " ", R.drawable.volleyfire);
    Unique WarlordsReach = new Unique("Warlord's Reach", 19, " ", R.drawable.warlordsreach);
    Unique WatchersEye = new Unique("Watcher's Eye", 19, " ", R.drawable.watcherseye);
    Unique WeightoftheEmpire = new Unique("Weight of the Empire", 19, " ", R.drawable.weightoftheempire);
    Unique Wildfire = new Unique("Wildfire", 19, " ", R.drawable.wildfire);
    Unique WinterBurial = new Unique("Winter Burial", 19, " ", R.drawable.winterburial);
    Unique WintersBounty = new Unique("Winter's Bounty", 19, " ", R.drawable.wintersbounty);

    Unique AncientWaystones = new Unique("Ancient Waystones", 19, " ", R.drawable.ancientwaystones);
    Unique AtzirisReign = new Unique("Atziri's Reign", 19, " ", R.drawable.atzirisreign);
    Unique BloodSacrifice = new Unique("Blood Sacrifice", 19, " ", R.drawable.bloodsacrifice);
    Unique BrittleBarrier = new Unique("Brittle Barrier", 19, " ", R.drawable.brittlebarrier);
    Unique ChillofCorruption = new Unique("Chill of Corruption", 19, " ", R.drawable.chillofcorruption);
    Unique Combustibles = new Unique("Combustibles", 19, " ", R.drawable.combustibles);
    Unique CorruptedEnergy = new Unique("Corrupted Energy", 19, " ", R.drawable.corruptedenergy);
    Unique FeveredMind = new Unique("Fevered Mind", 19, " ", R.drawable.feveredmind);
    Unique Fragility = new Unique("Fragility", 19, " ", R.drawable.fragility);
    Unique HungryAbyss = new Unique("Hungry Abyss", 19, " ", R.drawable.hungryabyss);
    Unique MutatedGrowth = new Unique("Mutated Growth", 19, " ", R.drawable.mutatedgrowth);
    Unique Pacifism = new Unique("Pacifism", 19, " ", R.drawable.pacifism);
    Unique Powerlessness = new Unique("Powerlessness", 19, " ", R.drawable.powerlessness);
    Unique SacrificialHarvest = new Unique("Sacrificial Harvest", 19, " ", R.drawable.sacrificialharvest);
    Unique SelfFlagellation = new Unique("Self-Flagellation", 19, " ", R.drawable.selfflagellation);
    Unique VaalSentencing = new Unique("Vaal Sentencing", 19, " ", R.drawable.vaalsentencing);
    Unique WeightofSin = new Unique("Weight of Sin", 19, " ", R.drawable.weightofsin);

//Maps - code 20
    Unique ActonsNightmare = new Unique("Acton's Nightmare", 20, " ", R.drawable.actionsnightmare);
    Unique CaerBlaiddWolfpacksDen = new Unique("Caer Blaidd, Wolfpack's Den", 20, " ", R.drawable.caerblaiddwolfpacksden);
    Unique DeathandTaxes = new Unique("Death and Taxes", 20, " ", R.drawable.deathandtaxes);
    Unique DoryanisMachinarium = new Unique("Doryani's Machinarium", 20, " ", R.drawable.doryannismachinarium);
    Unique HallofGrandmasters = new Unique("Hall of Grandmasters", 20, " ", R.drawable.hallofgrandmasters);
    Unique HallowedGround = new Unique("Hallowed Ground", 20, " ", R.drawable.hallowedground);
    Unique MaelstromofChaos = new Unique("Maelström of Chaos", 20, " ", R.drawable.maelstormofchaos);
    Unique MaoKun = new Unique("Mao Kun", 20, " ", R.drawable.maokun);
    Unique ObasCursedTrove = new Unique("Oba's Cursed Trove", 20, " ", R.drawable.obascursedtrove);
    Unique OlmecsSanctum = new Unique("Olmec's Sanctum", 20, " ", R.drawable.olmecssanctum);
    Unique PillarsofArun = new Unique("Pillars of Arun", 20, " ", R.drawable.pillarsofarun);
    Unique PoorjoysAsylum = new Unique("Poorjoy's Asylum", 20, " ", R.drawable.poorjoysasylum);
    Unique TheBeachheadOne = new Unique("The Beachhead (High Tier)", 20, " ", R.drawable.thebeachheadone);
    Unique TheBeachheadTwo = new Unique("The Beachhead (Low Tier)", 20, " ", R.drawable.thebeachheadtwo);
    Unique TheBeachheadThree = new Unique("The Beachhead (Mid Tier)", 20, " ", R.drawable.thebeachheadthree);
    Unique TheCowardsTrial = new Unique("The Coward's Trial", 20, " ", R.drawable.thecowardstrial);
    Unique ThePerandusManor = new Unique("The Perandus Manor", 20, " ", R.drawable.theperandusmanor);
    Unique ThePutridCloister = new Unique("The Putrid Cloister", 20, " ", R.drawable.theputridcloister);
    Unique TheTwilightTemple = new Unique("The Twilight Temple", 20, " ", R.drawable.thetwilighttemple);
    Unique TheVinktarSquare = new Unique("The Vinktar Square", 20, " ", R.drawable.thevinktarsquare);
    Unique VaultsofAtziri = new Unique("Vaults of Atziri", 20, " ", R.drawable.vaultsofatziri);
    Unique WhakawairuaTuahu = new Unique("Whakawairua Tuahu", 20, " ", R.drawable.whakawairuatuahu);




    allUniques = new ArrayList<>();
    allUniques.add(Aruku);
    allUniques.add(Astra);
    allUniques.add(AtziriFoi);
    allUniques.add(AulUprising);
    allUniques.add(AulUprising2);
    allUniques.add(AulUprising3);
    allUniques.add(AulUprising4);
    allUniques.add(BiscosCollar);
    allUniques.add(BlightwellClutch);
    allUniques.add(BloodCorruption);
    allUniques.add(Bloodgrip);
    allUniques.add(Carnage);
    allUniques.add(Choir);
    allUniques.add(DarSal);
    allUniques.add(Extractor);
    allUniques.add(EyeChay);
    allUniques.add(EyeInnoc);
    allUniques.add(EyeGreat);
    allUniques.add(Gloom);
    allUniques.add(Hinekora);
    allUniques.add(Impress1);
    allUniques.add(Impress2);
    allUniques.add(Impress3);
    allUniques.add(Impress4);
    allUniques.add(Impress5);
    allUniques.add(KaruiCharge);
    allUniques.add(KaruiWard);
    allUniques.add(MaligarosCruelty);
    allUniques.add(MarylenesFallacy);
    allUniques.add(NaturalHierarchy);
    allUniques.add(NgamahuTiki);
    allUniques.add(NightsHold);
    allUniques.add(PerquilsToe);
    allUniques.add(PresenceofChayula);
    allUniques.add(RashkaldorsPatience);
    allUniques.add(RigwaldsCurse);
    allUniques.add(SacrificialHeart);
    allUniques.add(ShapersSeed);
    allUniques.add(Sidhebreath);
    allUniques.add(StarofWraeclast);
    allUniques.add(StoneofLazhwar);
    allUniques.add(TearofPurity);
    allUniques.add(TheAnvil);
    allUniques.add(TheAscetic);
    allUniques.add(TheAylardex);
    allUniques.add(TheEffigon);
    allUniques.add(TheHalcyon);
    allUniques.add(TheIgnomon);
    allUniques.add(ThePandemonius);
    allUniques.add(ThePrimordialChain);
    allUniques.add(UngilsHarmony);
    allUniques.add(VictariosAcuity);
    allUniques.add(VollsDevotion);
    allUniques.add(WarpedTimepiece);
    allUniques.add(Winterheart);
    allUniques.add(XophsBlood);
    allUniques.add(XophsHeart);
    allUniques.add(YokeofSuffering);
    allUniques.add(ZerphisHeart);

    allUniques.add(AscentFromFlesh);
    allUniques.add(Auxium);
    allUniques.add(BatedBreath);
    allUniques.add(BeltoftheDeceiver);
    allUniques.add(BiscosLeash);
    allUniques.add(CowardsChains);
    allUniques.add(CowardsLegacy);
    allUniques.add(CyclopeanCoil);
    allUniques.add(DarknessEnthroned);
    allUniques.add(DoryanisInvitation1);
    allUniques.add(DoryanisInvitation2);
    allUniques.add(DoryanisInvitation3);
    allUniques.add(DoryanisInvitation4);
    allUniques.add(DyadianDawn);
    allUniques.add(Faminebind);
    allUniques.add(Feastbind);
    allUniques.add(Gluttony);
    allUniques.add(Headhunter);
    allUniques.add(ImmortalFlesh);
    allUniques.add(MaligarosRestraint);
    allUniques.add(MeginordsGirdle);
    allUniques.add(PerandusBlazon);
    allUniques.add(Perseverance);
    allUniques.add(Prismweave);
    allUniques.add(RyslathasCoil);
    allUniques.add(SoulTether);
    allUniques.add(Soulthirst);
    allUniques.add(StringofServitude);
    allUniques.add(Sunblast);
    allUniques.add(TheFlowUntethered);
    allUniques.add(TheMagnate);
    allUniques.add(TheNomad);
    allUniques.add(TheRetch);
    allUniques.add(TheTactician);
    allUniques.add(UmbilicusImmortalis);
    allUniques.add(WurmsMolt);

    allUniques.add(AhkelisMeadow);
    allUniques.add(AhkelisMountain);
    allUniques.add(AhkelisValley);
    allUniques.add(Andvarius);
    allUniques.add(AnglersPlait);
    allUniques.add(BereksGrip);
    allUniques.add(BereksPass);
    allUniques.add(BereksRespite);
    allUniques.add(Blackheart);
    allUniques.add(Bloodboil);
    allUniques.add(BrinerotMark);
    allUniques.add(CalloftheBrotherhood);
    allUniques.add(DeathRush);
    allUniques.add(DoedresDamning);
    allUniques.add(DreamFragments);
    allUniques.add(Emberwake);
    allUniques.add(EssenceWorm);
    allUniques.add(GiftsfromAbove);
    allUniques.add(HeartboundLoop);
    allUniques.add(KaomsSign);
    allUniques.add(KaomsWay);
    allUniques.add(Kikazaru);
    allUniques.add(LeHeupofAll);
    allUniques.add(LorisLantern);
    allUniques.add(MalachaisArtifice);
    allUniques.add(MarkofSubmission);
    allUniques.add(MarkoftheElder);
    allUniques.add(MarkoftheShaper);
    allUniques.add(MingsHeart);
    allUniques.add(MokousEmbrace);
    allUniques.add(MutewindSeal);
    allUniques.add(NgamahusSign);
    allUniques.add(PerandusSignet);
    allUniques.add(Praxis);
    allUniques.add(PrecursorsEmblem1);
    allUniques.add(PrecursorsEmblem2);
    allUniques.add(PrecursorsEmblem3);
    allUniques.add(PrecursorsEmblem4);
    allUniques.add(PrecursorsEmblem5);
    allUniques.add(PrecursorsEmblem6);
    allUniques.add(PrecursorsEmblem7);
    allUniques.add(PutembosMeadow);
    allUniques.add(PutembosMountain);
    allUniques.add(PutembosValley);
    allUniques.add(Pyre);
    allUniques.add(RedbladeBand);
    allUniques.add(RigwaldsCrest);
    allUniques.add(RomirasBanquet);
    allUniques.add(ShavronnesRevelation);
    allUniques.add(SibylsLament);
    allUniques.add(Snakepit);
    allUniques.add(Stormfire);
    allUniques.add(TasaliosSign);
    allUniques.add(TheHungryLoop);
    allUniques.add(ThePariah);
    allUniques.add(TheTaming);
    allUniques.add(TheWardensBrand);
    allUniques.add(ThiefsTorment);
    allUniques.add(Timeclasp);
    allUniques.add(Timetwist);
    allUniques.add(UzazasMeadow);
    allUniques.add(UzazasMountain);
    allUniques.add(UzazasValley);
    allUniques.add(ValakosSign);
    allUniques.add(Valyrium);
    allUniques.add(VentorsGamble);
    allUniques.add(Voideye);
    allUniques.add(Voidheart);
    allUniques.add(Winterweave);

    allUniques.add(AsphyxiasWrath);
    allUniques.add(Blackgleam);
    allUniques.add(Cragfall);
    allUniques.add(Craghead);
    allUniques.add(Drillneck);
    allUniques.add(HyrrisBite);
    allUniques.add(HyrrisDemise);
    allUniques.add(MaloneysNightfall);
    allUniques.add(Rearguard);
    allUniques.add(RigwaldsQuills);
    allUniques.add(SaemusGift);
    allUniques.add(Skirmish);
    allUniques.add(SoulStrike);
    allUniques.add(TheFracturingSpinner);
    allUniques.add(TheSignalFire);
    allUniques.add(Voidfletcher);

    allUniques.add(Bramblejack);
    allUniques.add(CraiceannsCarapace);
    allUniques.add(DeathsOath);
    allUniques.add(GreedsEmbrace);
    allUniques.add(IronHeart);
    allUniques.add(KaomsHeart);
    allUniques.add(LioneyesVision);
    allUniques.add(SolarisLorica);
    allUniques.add(TheBrassDome);
    allUniques.add(TheIronFortress);
    allUniques.add(WallofBrambles);
    allUniques.add(Ashrend);
    allUniques.add(Briskwrap);
    allUniques.add(BronnsLithe);
    allUniques.add(CosprisWill);
    allUniques.add(FoxsFortune);
    allUniques.add(Foxshade);
    allUniques.add(HyrrisIre);
    allUniques.add(Kintsugi);
    allUniques.add(QueenoftheForest);
    allUniques.add(ThePerfectForm);
    allUniques.add(TheRatCage);
    allUniques.add(TheSnowblindGrace);
    allUniques.add(Wildwrap);
    allUniques.add(YrielsFostering1);
    allUniques.add(YrielsFostering2);
    allUniques.add(YrielsFostering3);
    allUniques.add(CloakofFlame);
    allUniques.add(CloakofTawmrIsley);
    allUniques.add(DiallasMalefaction);
    allUniques.add(DoedresSkin);
    allUniques.add(FenumusShroud);
    allUniques.add(InfernalMantle);
    allUniques.add(ShavronnesWrappings);
    allUniques.add(SkinoftheLords);
    allUniques.add(SkinoftheLoyal);
    allUniques.add(SoulMantle);
    allUniques.add(TabulaRasa);
    allUniques.add(TheBeastFurShawl);
    allUniques.add(TheComingCalamity);
    allUniques.add(TheCovenant);
    allUniques.add(ThousandRibbons);
    allUniques.add(VisMortis);
    allUniques.add(ZahndethusCassock);
    allUniques.add(BellyoftheBeast);
    allUniques.add(CherrubimsMaleficence);
    allUniques.add(DaressosDefiance);
    allUniques.add(FarrulsFur);
    allUniques.add(GruthkulsPelt);
    allUniques.add(LightningCoil);
    allUniques.add(VipersScales);
    allUniques.add(AmbusCharge);
    allUniques.add(ChainsofCommand);
    allUniques.add(CrystalVault);
    allUniques.add(GeofrisSanctuary);
    allUniques.add(Icetomb);
    allUniques.add(IncandescentHeart);
    allUniques.add(Kingsguard);
    allUniques.add(LightbaneRaiment);
    allUniques.add(Loreweave);
    allUniques.add(VollsProtector);
    allUniques.add(Bloodbond);
    allUniques.add(CarcassJack);
    allUniques.add(CloakofDefiance);
    allUniques.add(Dendrobate);
    allUniques.add(InpulsasBrokenHeart);
    allUniques.add(SaqawalsNest);
    allUniques.add(ShroudoftheLightless);
    allUniques.add(TheRestlessWard);
    allUniques.add(Tinkerskin);
    allUniques.add(VictariosInfluence);
    allUniques.add(AtzirisSplendourOne);
    allUniques.add(AtzirisSplendourTwo);
    allUniques.add(AtzirisSplendourThree);
    allUniques.add(AtzirisSplendourFour);
    allUniques.add(AtzirisSplendourFive);
    allUniques.add(AtzirisSplendourSix);
    allUniques.add(AtzirisSplendourSeven);
    allUniques.add(AtzirisSplendourEight);
    allUniques.add(AtzirisSplendourNine);
    allUniques.add(Shadowstitch);

    allUniques.add(CraiceannsTracks);
    allUniques.add(DoryanisDelusionOne);
    allUniques.add(KaomsRoots);
    allUniques.add(RedbladeTramplers);
    allUniques.add(Stormcharger);
    allUniques.add(TheInfinitePursuit);
    allUniques.add(TheRedTrail);
    allUniques.add(Windscream);
    allUniques.add(Windshriek);
    allUniques.add(AbberathsHooves);
    allUniques.add(AtzirisStep);
    allUniques.add(Deerstalker);
    allUniques.add(DoryanisDelusionTwo);
    allUniques.add(FarrulsChase);
    allUniques.add(GarukhansFlight);
    allUniques.add(Goldwyrm);
    allUniques.add(SevenLeagueStep);
    allUniques.add(SinTrek);
    allUniques.add(TheBloodDance);
    allUniques.add(ThreestepAssault);
    allUniques.add(VictariosFlight);
    allUniques.add(BonesofUllr);
    allUniques.add(DoryanisDelusionthree);
    allUniques.add(Greedtrap);
    allUniques.add(InyasEpiphany);
    allUniques.add(Rainbowstride);
    allUniques.add(ShavronnesGambit);
    allUniques.add(ShavronnesPace);
    allUniques.add(Skyforth);
    allUniques.add(SteppanEard);
    allUniques.add(Wanderlust);
    allUniques.add(Wondertrap);
    allUniques.add(DarkrayVectors);
    allUniques.add(Duskblight);
    allUniques.add(Dusktoe);
    allUniques.add(LioneyesPaws);
    allUniques.add(MutewindWhispersteps);
    allUniques.add(SaqawalsTalons);
    allUniques.add(AlberonsWarpath);
    allUniques.add(DeathsDoor);
    allUniques.add(GangsMomentum);
    allUniques.add(RalakeshsImpatience);
    allUniques.add(WakeofDestruction);
    allUniques.add(BrinerotWhalers);
    allUniques.add(BubonicTrailOne);
    allUniques.add(BubonicTrailTwo);
    allUniques.add(DanceoftheOffered);
    allUniques.add(FenumusSpinnerets);
    allUniques.add(NomicsStorm);
    allUniques.add(Omeyocan);
    allUniques.add(Sundance);
    allUniques.add(Sunspite);
    allUniques.add(Voidwalker);
    allUniques.add(DemigodsStride);

    allUniques.add(AtzirisAcuity);
    allUniques.add(CraiceannsPincers);
    allUniques.add(DoryanisFist);
    allUniques.add(EmpiresGrasp);
    allUniques.add(Giantsbane);
    allUniques.add(LochtonialCaress);
    allUniques.add(MeginordsVise);
    allUniques.add(VerusosBatteringRams);
    allUniques.add(WindsofChange);
    allUniques.add(Hrimburn);
    allUniques.add(Hrimsorrow);
    allUniques.add(MaligarosVirtuosity);
    allUniques.add(Oskarm);
    allUniques.add(Allelopathy);
    allUniques.add(AsenathsGentleTouch);
    allUniques.add(DemonStitcher);
    allUniques.add(DoedresMalevolence);
    allUniques.add(DoedresTenure);
    allUniques.add(GripoftheCouncil);
    allUniques.add(KalisasGrace);
    allUniques.add(SadimasTouch);
    allUniques.add(Voidbringer);
    allUniques.add(Aurseize);
    allUniques.add(FarrulsPounce);
    allUniques.add(FleshandSpirit);
    allUniques.add(Haemophilia);
    allUniques.add(Slitherpinch);
    allUniques.add(Surgebinders);
    allUniques.add(TombfistOne);
    allUniques.add(TombfistTwo);
    allUniques.add(VaalCaress);
    allUniques.add(Wyrmsign);
    allUniques.add(CommandofthePit);
    allUniques.add(CommandofthePitTwo);
    allUniques.add(NullandVoid);
    allUniques.add(Repentance);
    allUniques.add(SaqawalsWinds);
    allUniques.add(ShacklesoftheWretched);
    allUniques.add(ShapersTouch);
    allUniques.add(Southbound);
    allUniques.add(VolkuursGuidanceOne);
    allUniques.add(VolkuursGuidanceTwo);
    allUniques.add(VolkuursGuidanceThree);
    allUniques.add(ArchitectsHand);
    allUniques.add(BlasphemersGrasp);
    allUniques.add(Facebreaker);
    allUniques.add(FenumusWeave);
    allUniques.add(MalachaisMark);
    allUniques.add(OndarsClasp);
    allUniques.add(ShadowsandDust);
    allUniques.add(SlavedriversHand);
    allUniques.add(Snakebite);
    allUniques.add(TheEmbalmer);
    allUniques.add(Thunderfist);
    allUniques.add(DemigodsTouch);

    allUniques.add(Abyssus);
    allUniques.add(EzomyteHold);
    allUniques.add(EzomytePeak);
    allUniques.add(HrimnorsResolve);
    allUniques.add(TheBaron);
    allUniques.add(TheFormlessFlame);
    allUniques.add(TheFormlessInferno);
    allUniques.add(AlphasHowl);
    allUniques.add(FairgravesTricorne);
    allUniques.add(Frostferno);
    allUniques.add(Goldrim);
    allUniques.add(Heatshiver);
    allUniques.add(Obscurantis);
    allUniques.add(RatsNest);
    allUniques.add(SaqawalsFlock);
    allUniques.add(StarkonjasHead);
    allUniques.add(AsenathsChant);
    allUniques.add(AsenathsMark);
    allUniques.add(ChitusApex);
    allUniques.add(CrownofEyes);
    allUniques.add(CrownofThorns);
    allUniques.add(DoedresScorn);
    allUniques.add(EbersUnification);
    allUniques.add(FenumusToxins);
    allUniques.add(HaleNegatorOne);
    allUniques.add(HaleNegatorTwo);
    allUniques.add(Indigon);
    allUniques.add(MarkoftheRedCovenant);
    allUniques.add(MartyrsCrown);
    allUniques.add(RimeGaze);
    allUniques.add(ScoldsBridle);
    allUniques.add(Wraithlord);
    allUniques.add(YlfebansTrickery);
    allUniques.add(BlackSunCrest);
    allUniques.add(Deidbell);
    allUniques.add(Deidbellow);
    allUniques.add(DevotosDevotion);
    allUniques.add(Skullhead);
    allUniques.add(TheBringerofRain);
    allUniques.add(ThePeregrine);
    allUniques.add(AhnsContempt);
    allUniques.add(CraiceannsChitin);
    allUniques.add(CrownoftheTyrant);
    allUniques.add(GeofrisCrest);
    allUniques.add(GeofrisLegacy);
    allUniques.add(Honourhome);
    allUniques.add(KitavasThirst);
    allUniques.add(LightpoacherOne);
    allUniques.add(LightpoacherTwo);
    allUniques.add(MalachaisVision);
    allUniques.add(MaskoftheSpiritDrinker);
    allUniques.add(MaskoftheStitchedDemon);
    allUniques.add(MemoryVault);
    allUniques.add(Mindspiral);
    allUniques.add(SpeakersWreath);
    allUniques.add(TheBrineCrown);
    allUniques.add(TheBrokenCrown);
    allUniques.add(VeiloftheNight);
    allUniques.add(VollsVision);
    allUniques.add(CrownofthePaleKing);
    allUniques.add(CurtainCall);
    allUniques.add(FarrulsBite);
    allUniques.add(GorgonsGaze);
    allUniques.add(HereticsVeil);
    allUniques.add(LeerCast);
    allUniques.add(MalachaisAwakening);
    allUniques.add(MalachaisSimula);
    allUniques.add(MindoftheCouncil);
    allUniques.add(TheGull);
    allUniques.add(TheTempestsBinding);
    allUniques.add(TheThreeDragons);
    allUniques.add(TheVertex);
    allUniques.add(DemigodsTriumph);

    allUniques.add(AhnsHeritage);
    allUniques.add(ChernobogsPillar);
    allUniques.add(LioneyesRemorse);
    allUniques.add(Lycosidae);
    allUniques.add(MagnaEclipsis);
    allUniques.add(RedbladeBanner);
    allUniques.add(TheAnticipation);
    allUniques.add(TheSurrender);
    allUniques.add(TituciusSpan);
    allUniques.add(TrolltimberSpire);
    allUniques.add(TukohamasFortress);
    allUniques.add(AtzirisMirror);
    allUniques.add(AtzirisReflection);
    allUniques.add(ChaliceofHorrors);
    allUniques.add(CrestofPerandus);
    allUniques.add(GreatOldOnesWard);
    allUniques.add(Kaltenhalt);
    allUniques.add(Kaltensoul);
    allUniques.add(MutewindPennant);
    allUniques.add(ThirstforHorrors);
    allUniques.add(ThousandTeethTemu);
    allUniques.add(ApepsSlumber);
    allUniques.add(ApepsSupremacy);
    allUniques.add(BrinerotFlag);
    allUniques.add(EshsMirror);
    allUniques.add(EshsVisage);
    allUniques.add(KongmingsStratagem);
    allUniques.add(LightofLunaris);
    allUniques.add(MalachaisLoop);
    allUniques.add(MatuaTupuna);
    allUniques.add(RathpithGlobe);
    allUniques.add(SentarisAnswer);
    allUniques.add(TheEternalApple);
    allUniques.add(DaressosCourage);
    allUniques.add(TheDeepOnesHide);
    allUniques.add(VixLunaris);
    allUniques.add(WheeloftheStormsail);
    allUniques.add(AegisAurora);
    allUniques.add(BrokenFaith);
    allUniques.add(InvictusSolaris);
    allUniques.add(PrismGuardian);
    allUniques.add(RiseofthePhoenix);
    allUniques.add(SaffellsFrame);
    allUniques.add(Springleaf);
    allUniques.add(TheOak);
    allUniques.add(TheUnshatteredWill);
    allUniques.add(UnyieldingFlame);
    allUniques.add(VictariosCharity);
    allUniques.add(Glitterdisc);
    allUniques.add(JawsofAgony);
    allUniques.add(LepersAlms);
    allUniques.add(MaligarosLens);
    allUniques.add(ZeelsAmplifier);

    allUniques.add(Dreadarc);
    allUniques.add(Dreadsurge);
    allUniques.add(Dyadus);
    allUniques.add(JacktheAxe);
    allUniques.add(MoonbendersWing);
    allUniques.add(RelentlessFury);
    allUniques.add(RigwaldsSavagery);
    allUniques.add(SoulTaker);
    allUniques.add(TheGryphon);
    allUniques.add(TheScreamingEagle);
    allUniques.add(AtzirisDisfavour);
    allUniques.add(DebeonsDirge);
    allUniques.add(HezmanasBloodlust);
    allUniques.add(KaomsPrimacy);
    allUniques.add(Kingmaker);
    allUniques.add(KitavasFeast);
    allUniques.add(Limbsplit);
    allUniques.add(NgamahusFlame);
    allUniques.add(ReapersPursuit);
    allUniques.add(SinvictasMettle);
    allUniques.add(TheBloodReaper);
    allUniques.add(TheCauteriser);
    allUniques.add(TheHarvest);
    allUniques.add(UulNetolsEmbrace);
    allUniques.add(UulNetolsKiss);
    allUniques.add(Wideswing);
    allUniques.add(WingsofEntropy);

    allUniques.add(Arborix);
    allUniques.add(ChinSol);
    allUniques.add(Darkscorn);
    allUniques.add(DeathsHarp);
    allUniques.add(DeathsOpus);
    allUniques.add(DoomfletchsPrism);
    allUniques.add(Doomfletch);
    allUniques.add(Hopeshredder);
    allUniques.add(Infractem);
    allUniques.add(IronCommander);
    allUniques.add(LioneyesGlare);
    allUniques.add(NullsInclination);
    allUniques.add(NurosHarp);
    allUniques.add(QuillRain);
    allUniques.add(ReachoftheCouncil);
    allUniques.add(RothsReach);
    allUniques.add(Silverbough);
    allUniques.add(Silverbranch);
    allUniques.add(Slivertongue);
    allUniques.add(StormCloud);
    allUniques.add(TheTempest);
    allUniques.add(VoltaxicRift);
    allUniques.add(Windripper);
    allUniques.add(XophsInception);
    allUniques.add(XophsNurture);

    allUniques.add(AdvancingFortress);
    allUniques.add(AlDhih);
    allUniques.add(Allure);
    allUniques.add(Bloodseeker);
    allUniques.add(CybilsPaw);
    allUniques.add(EssentiaSanguis);
    allUniques.add(HandofThoughtandMotion);
    allUniques.add(HandofWisdomandAction);
    allUniques.add(IzarosDilemma);
    allUniques.add(LastResort);
    allUniques.add(MortemMorsu);
    allUniques.add(OrnamentoftheEast);
    allUniques.add(Rive);
    allUniques.add(TheScourge);
    allUniques.add(TheWaspNest);
    allUniques.add(TouchofAnguish);
    allUniques.add(Wildslash);

    allUniques.add(ArakaalisFang);
    allUniques.add(BinosKitchenKnife);
    allUniques.add(Bloodplay);
    allUniques.add(Divinarius);
    allUniques.add(Goredrill);
    allUniques.add(Heartbreaker);
    allUniques.add(MarkoftheDoubtingKnight);
    allUniques.add(Mightflay);
    allUniques.add(SanguineGambol);
    allUniques.add(Taproot);
    allUniques.add(TheConsumingDark);
    allUniques.add(UngilsGauche);
    allUniques.add(Vulconus);
    allUniques.add(WhiteWind);
    allUniques.add(Widowmaker);

    allUniques.add(Reefbane);
    allUniques.add(SongoftheSirens);

    allUniques.add(Brightbeak);
    allUniques.add(CallinellusMalleus);
    allUniques.add(CameriasAvarice);
    allUniques.add(CameriasMaul);
    allUniques.add(Clayshaper);
    allUniques.add(FleshEater);
    allUniques.add(Frostbreath);
    allUniques.add(Gorebreaker);
    allUniques.add(LaviangasWisdom);
    allUniques.add(Mjolner);
    allUniques.add(Nebuloch);
    allUniques.add(Augyre);
    allUniques.add(AxiomPerpetuum);
    allUniques.add(Balefire);
    allUniques.add(Bitterdream);
    allUniques.add(BreathoftheCouncil);
    allUniques.add(BrutusLeadSprinkler);
    allUniques.add(CerberusLimb);
    allUniques.add(DeathsHand);
    allUniques.add(DoonCuebiyari);
    allUniques.add(DoryanisCatalyst);
    allUniques.add(EarendelsEmbrace);
    allUniques.add(MontregulsGrasp);
    allUniques.add(NyctasLantern);
    allUniques.add(Singularity);
    allUniques.add(SpineoftheFirstClaimant);
    allUniques.add(TheDarkSeerOne);
    allUniques.add(TheDarkSeerTwo);
    allUniques.add(TheDarkSeerThree);
    allUniques.add(TheSupremeTruth);
    allUniques.add(BrainRattler);
    allUniques.add(ChaberCairn);
    allUniques.add(ChoberChaber);
    allUniques.add(GeofrisBaptism);
    allUniques.add(GeofrisDevotion);
    allUniques.add(HrimnorsDirge);
    allUniques.add(HrimnorsHymn);
    allUniques.add(JorrhastsBlacksteel);
    allUniques.add(KongorsUndyingRage);
    allUniques.add(MarohiErqi);
    allUniques.add(Panquetzaliztli);
    allUniques.add(Quecholli);
    allUniques.add(Tidebreaker);
    allUniques.add(Trypanon);
    allUniques.add(Voidhome);

    allUniques.add(AgnerodEast);
    allUniques.add(AgnerodNorth);
    allUniques.add(AgnerodSouth);
    allUniques.add(AgnerodWest);
    allUniques.add(CaneofUnravelling);
    allUniques.add(Disintegrator);
    allUniques.add(Duskdawn);
    allUniques.add(DyingBreath);
    allUniques.add(FemursoftheSaints);
    allUniques.add(Fencoil);
    allUniques.add(HegemonysEra);
    allUniques.add(MartyrofInnocence);
    allUniques.add(Mirebough);
    allUniques.add(PillaroftheCagedGod);
    allUniques.add(PledgeofHands);
    allUniques.add(RealmEnder);
    allUniques.add(Realmshaper);
    allUniques.add(SireofShards);
    allUniques.add(Soulwrest);
    allUniques.add(TarynsShiver);
    allUniques.add(TheBloodThorn);
    allUniques.add(TheEnmityDivine);
    allUniques.add(TheGreySpire);
    allUniques.add(TheSearingTouch);
    allUniques.add(TheStormheart);
    allUniques.add(TheStormwall);
    allUniques.add(TheWhisperingIce);
    allUniques.add(TremorRod);
    allUniques.add(XirgilsCrank);

    allUniques.add(AhnsMight);
    allUniques.add(BeltimberBlade);
    allUniques.add(Dreadbeak);
    allUniques.add(Dreamfeather);
    allUniques.add(EphemeralEdge);
    allUniques.add(FateoftheVaal);
    allUniques.add(GrelwoodShank);
    allUniques.add(HyaonsFury);
    allUniques.add(Ichimonji);
    allUniques.add(InnsburyEdge);
    allUniques.add(LakishusBlade);
    allUniques.add(OniGoroshi);
    allUniques.add(PrismaticEclipse);
    allUniques.add(RazoroftheSeventhSun);
    allUniques.add(RebukeoftheVaal);
    allUniques.add(Redbeak);
    allUniques.add(RigwaldsCommand);
    allUniques.add(Scaeva);
    allUniques.add(SeveredinSleep);
    allUniques.add(StoryoftheVaal);
    allUniques.add(TheGoddessScorned);
    allUniques.add(ThePrincess);
    allUniques.add(TheRipplingThoughts);
    allUniques.add(TheTempestuousSteel);
    allUniques.add(UnitedinDream);
    allUniques.add(Varunastra);

    allUniques.add(Aurumvorax);
    allUniques.add(ChitusNeedle);
    allUniques.add(CosprisMalice);
    allUniques.add(DaressosPassion);
    allUniques.add(EwarsMirage);
    allUniques.add(FidelitasSpike);
    allUniques.add(TheGoddessBound);

    allUniques.add(Doomsower);
    allUniques.add(EdgeofMadness);
    allUniques.add(Hiltless);
    allUniques.add(KondosPride);
    allUniques.add(OrosSacrifice);
    allUniques.add(QueensDecree);
    allUniques.add(QueensEscape);
    allUniques.add(RigwaldsCharge);
    allUniques.add(Shiversting);
    allUniques.add(Starforge);
    allUniques.add(TerminusEst);
    allUniques.add(TheDancingDervish);
    allUniques.add(TheDancingDuo);
    allUniques.add(Voidforge);

    allUniques.add(AbberathsHorn);
    allUniques.add(AmplificationRod);
    allUniques.add(ApepsRage);
    allUniques.add(Ashcaller);
    allUniques.add(CoronaSolaris);
    allUniques.add(EclipseSolaris);
    allUniques.add(Lifesprig);
    allUniques.add(MidnightBargain);
    allUniques.add(Moonsorrow);
    allUniques.add(Obliteration);
    allUniques.add(PiscatorsVigil);
    allUniques.add(ReverberationRod);
    allUniques.add(ShadeofSolaris);
    allUniques.add(Shimmeron);
    allUniques.add(StormPrison);
    allUniques.add(ThePoetsPen);
    allUniques.add(Tulborn);
    allUniques.add(Tulfall);
    allUniques.add(Twyzel);
    allUniques.add(VoidBattery);

    allUniques.add(BloodoftheKarui);
    allUniques.add(DoedresElixir);
    allUniques.add(LaviangasSpirit);
    allUniques.add(ZerphisLastBreath);
    allUniques.add(DivinationDistillate);
    allUniques.add(TheWrithingJar);
    allUniques.add(AtzirisPromise);
    allUniques.add(CoruscatingElixir);
    allUniques.add(DyingSun);
    allUniques.add(ForbiddenTaste);
    allUniques.add(KiarasDetermination);
    allUniques.add(LionsRoar);
    allUniques.add(Rotgut);
    allUniques.add(RumisConcoction);
    allUniques.add(SinsRebirth);
    allUniques.add(SoulCatcher);
    allUniques.add(SoulRipper);
    allUniques.add(TasteofHate);
    allUniques.add(TheOverflowingChalice);
    allUniques.add(TheSorrowoftheDivine);
    allUniques.add(TheWiseOak);
    allUniques.add(VesselofVinktarOne);
    allUniques.add(VesselofVinktarTwo);
    allUniques.add(VesselofVinktarThree);
    allUniques.add(VesselofVinktarFour);
    allUniques.add(WitchfireBrew);

    allUniques.add(AnatomicalKnowledge);
    allUniques.add(Apparitions);
    allUniques.add(AssassinsHaste);
    allUniques.add(Brawn);
    allUniques.add(BruteForceSolution);
    allUniques.add(CarefulPlanning);
    allUniques.add(CheapConstruction);
    allUniques.add(ClearMind);
    allUniques.add(CoatedShrapnel);
    allUniques.add(ColdSteel);
    allUniques.add(CollateralDamage);
    allUniques.add(CombatFocusOne);
    allUniques.add(CombatFocusTwo);
    allUniques.add(CombatFocusThree);
    allUniques.add(ConquerorsEfficiency);
    allUniques.add(ConquerorsLongevity);
    allUniques.add(ConquerorsPotency);
    allUniques.add(DeadReckoning);
    allUniques.add(EfficientTraining);
    allUniques.add(EldritchKnowledge);
    allUniques.add(EmperorsCunning);
    allUniques.add(EmperorsMastery);
    allUniques.add(EmperorsMight);
    allUniques.add(EmperorsWit);
    allUniques.add(EnergisedArmour);
    allUniques.add(EnergyFromWithin);
    allUniques.add(FertileMind);
    allUniques.add(FightforSurvival);
    allUniques.add(Fireborn);
    allUniques.add(FirstSnow);
    allUniques.add(FluidMotion);
    allUniques.add(FortifiedLegion);
    allUniques.add(FragileBloom);
    allUniques.add(FromDust);
    allUniques.add(FrozenTrail);
    allUniques.add(GrandSpectrumOne);
    allUniques.add(GrandSpectrumTwo);
    allUniques.add(GrandSpectrumThree);
    allUniques.add(GrowingAgony);
    allUniques.add(HairTrigger);
    allUniques.add(HazardousResearch);
    allUniques.add(HealthyMind);
    allUniques.add(HiddenPotential);
    allUniques.add(Hotfooted);
    allUniques.add(Inertia);
    allUniques.add(Inevitability);
    allUniques.add(InspiredLearning);
    allUniques.add(IntuitiveLeap);
    allUniques.add(IzarosTurmoil);
    allUniques.add(LioneyesFall);
    allUniques.add(MaliciousIntent);
    allUniques.add(MantraofFlames);
    allUniques.add(MartialArtistry);
    allUniques.add(MightandInfluence);
    allUniques.add(MightinAllForms);
    allUniques.add(MightoftheMeek);
    allUniques.add(OmenontheWinds);
    allUniques.add(OverwhelmingOdds);
    allUniques.add(PitchDarkness);
    allUniques.add(PoachersAim);
    allUniques.add(PrimordialEminence);
    allUniques.add(PrimordialHarmony);
    allUniques.add(PrimordialMight);
    allUniques.add(Pugilist);
    allUniques.add(PureTalent);
    allUniques.add(RainofSplinters);
    allUniques.add(RapidExpansion);
    allUniques.add(RecklessDefence);
    allUniques.add(RingofBlades);
    allUniques.add(RollingFlames);
    allUniques.add(ShatteredChains);
    allUniques.add(SoulsWick);
    allUniques.add(SpireofStone);
    allUniques.add(SpiritGuards);
    allUniques.add(SpiritedResponse);
    allUniques.add(SpreadingRot);
    allUniques.add(StaticElectricity);
    allUniques.add(SteelSpirit);
    allUniques.add(SuddenIgnition);
    allUniques.add(SurvivalInstincts);
    allUniques.add(SurvivalSecrets);
    allUniques.add(SurvivalSkills);
    allUniques.add(TemperedFlesh);
    allUniques.add(TemperedMind);
    allUniques.add(TemperedSpirit);
    allUniques.add(TheAnimaStone);
    allUniques.add(TheBlueDream);
    allUniques.add(TheBlueNightmare);
    allUniques.add(TheGoldenRule);
    allUniques.add(TheGreenDream);
    allUniques.add(TheGreenNightmare);
    allUniques.add(TheLongWinter);
    allUniques.add(TheRedDream);
    allUniques.add(TheRedNightmare);
    allUniques.add(TheVigil);
    allUniques.add(ToDust);
    allUniques.add(TranscendentFlesh);
    allUniques.add(TranscendentMind);
    allUniques.add(TranscendentSpirit);
    allUniques.add(UnendingHunger);
    allUniques.add(UnnaturalInstinct);
    allUniques.add(UnstablePayload);
    allUniques.add(ViolentDead);
    allUniques.add(VolleyFire);
    allUniques.add(WarlordsReach);
    allUniques.add(WatchersEye);
    allUniques.add(WeightoftheEmpire);
    allUniques.add(Wildfire);
    allUniques.add(WinterBurial);
    allUniques.add(WintersBounty);

    allUniques.add(AncientWaystones);
    allUniques.add(AtzirisReign);
    allUniques.add(BloodSacrifice);
    allUniques.add(BrittleBarrier);
    allUniques.add(ChillofCorruption);
    allUniques.add(Combustibles);
    allUniques.add(CorruptedEnergy);
    allUniques.add(FeveredMind);
    allUniques.add(Fragility);
    allUniques.add(HungryAbyss);
    allUniques.add(MutatedGrowth);
    allUniques.add(Pacifism);
    allUniques.add(Powerlessness);
    allUniques.add(SacrificialHarvest);
    allUniques.add(SelfFlagellation);
    allUniques.add(VaalSentencing);
    allUniques.add(WeightofSin);

    allUniques.add(ActonsNightmare);
    allUniques.add(CaerBlaiddWolfpacksDen);
    allUniques.add(DeathandTaxes);
    allUniques.add(DoryanisMachinarium);
    allUniques.add(HallofGrandmasters);
    allUniques.add(HallowedGround);
    allUniques.add(MaelstromofChaos);
    allUniques.add(MaoKun);
    allUniques.add(ObasCursedTrove);
    allUniques.add(OlmecsSanctum);
    allUniques.add(PillarsofArun);
    allUniques.add(PoorjoysAsylum);
    allUniques.add(TheBeachheadOne);
    allUniques.add(TheBeachheadTwo);
    allUniques.add(TheBeachheadThree);
    allUniques.add(TheCowardsTrial);
    allUniques.add(ThePerandusManor);
    allUniques.add(ThePutridCloister);
    allUniques.add(TheTwilightTemple);
    allUniques.add(TheVinktarSquare);
    allUniques.add(VaultsofAtziri);
    allUniques.add(WhakawairuaTuahu);

    tempList = new ArrayList<>();
    tempList = (ArrayList<Unique>) allUniques.clone();
    savedList = new ArrayList<>();
    String[] savedIndices = readFromFile(MainActivity.this).split(" ");

    String[] names = new String[allUniques.size()];
    for(int i = 0; i< allUniques.size(); i++){
        names[i] = allUniques.get(i).getName();
        allUniques.get(i).setIndex(i);
    }

    for(int j =0; j < savedIndices.length; j++){
        try{
                if (savedIndices[j].matches("\\d+")) {
                        savedList.add(allUniques.get(Integer.parseInt(savedIndices[j])));
                }
        }catch(NumberFormatException e){Log.e("Exception", "Tried to parse non integer: " + e.toString());}
    }
    search_adapter = new ArrayAdapter<String>(this,android.R.layout.select_dialog_item, names);
    search_bar.setThreshold(2);
    search_bar.setAdapter(search_adapter);
}


    private void writeToFile(Context context) {
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput("saveditems.txt", Context.MODE_PRIVATE));
            for(int i= 0;i<savedList.size();i++){
                outputStreamWriter.write(savedList.get(i).getIndex()+" ");
            }
            outputStreamWriter.close();
        }
        catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
        new HtmlSync(){
            @Override public void onPostExecute(String result)
            {
                Toast.makeText(MainActivity.this, result, Toast.LENGTH_SHORT).show();
            }
        }.execute();
    }

    private String readFromFile(Context context) {

        String ret = "";

        try {
            InputStream inputStream = context.openFileInput("saveditems.txt");

            if ( inputStream != null ) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String receiveString = "";
                StringBuilder stringBuilder = new StringBuilder();

                while ( (receiveString = bufferedReader.readLine()) != null ) {
                    stringBuilder.append(receiveString);
                }

                inputStream.close();
                ret = stringBuilder.toString();
            }
        }
        catch (FileNotFoundException e) {
            Log.e("login activity", "File not found: " + e.toString());
        } catch (IOException e) {
            Log.e("login activity", "Can not read file: " + e.toString());
        }

        return ret;
    }
}


//Crude but effective program used independently to retrieve URLS from website to generate items.
/*
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.*;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.Robot;

import static java.lang.Integer.parseInt;

public class Main {

    public static void main(String[] args) throws UnsupportedEncodingException, InterruptedException, UnsupportedFlavorException {
        try {
            inputFile();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }
    private static void inputFile() throws UnsupportedEncodingException, AWTException, InterruptedException, UnsupportedFlavorException {
        String filename = "items.txt";
        String newFileName = "newitems.txt";

        String decodedPath = "";
        String newdecodedPath = "";
        try {
            String path = Main.class.getProtectionDomain().getCodeSource().getLocation().getPath();
            decodedPath = URLDecoder.decode(path, "UTF-8")+filename;

            newdecodedPath = URLDecoder.decode(path, "UTF-8")+newFileName;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        try {
            File myFile = new File(newdecodedPath);
            if (!myFile.exists()){
                myFile.createNewFile();
            }
            BufferedReader b_reader = new BufferedReader(new FileReader(decodedPath));
            BufferedWriter b_writer = new BufferedWriter(new FileWriter(myFile));
            String c_line;
            String[] nums;
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

            Robot robot = new Robot();
            robot.setAutoDelay(300);

            while ((c_line = b_reader.readLine()) != null) {
                    nums = c_line.split("\"");
                    counter ++;
                    //URL Box
                    //robot.mouseMove(380,53);
                    if (nums.length == 5){
                    StringSelection stringSelection = new StringSelection(nums[1]);
                    clipboard.setContents(stringSelection, stringSelection);
                    //Search Box
                    robot.mouseMove(760,380);
                    robot.mousePress(InputEvent.BUTTON1_MASK);
                    robot.mousePress(InputEvent.BUTTON1_MASK);
                    robot.keyPress(KeyEvent.VK_CONTROL);
                    robot.keyPress(KeyEvent.VK_V);
                    robot.keyRelease(KeyEvent.VK_V);
                    robot.keyRelease(KeyEvent.VK_CONTROL);
                    robot.keyPress(KeyEvent.VK_ENTER);
                    robot.keyRelease(KeyEvent.VK_ENTER);

                    robot.keyPress(KeyEvent.VK_CONTROL);
                    robot.keyPress(KeyEvent.VK_L);
                    robot.keyRelease(KeyEvent.VK_L);
                    robot.keyRelease(KeyEvent.VK_CONTROL);

                    robot.keyPress(KeyEvent.VK_CONTROL);
                    robot.keyPress(KeyEvent.VK_C);
                    robot.keyRelease(KeyEvent.VK_C);
                    robot.keyRelease(KeyEvent.VK_CONTROL);
                    String temp = "";
                    for(int i=0; i<nums.length; i++){
        if(i != 3 && i!= 1) {
        temp = temp + nums[i] ;
        }else if(i == 3){

        temp = temp + "\""+(String)clipboard.getData(DataFlavor.stringFlavor)+"\"";
        }else{
        temp = temp + "\""+nums[i]+"\"";
        }
        }
        System.out.println(temp);
        b_writer.write(temp);
        b_writer.newLine();

        StringSelection stringSelectiontwo = new StringSelection("poe.trade");
        clipboard.setContents(stringSelectiontwo, stringSelectiontwo);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        }
        }

        b_writer.close();
        } catch (IOException e) {
        System.err.println("File not found");
        }
        }
        }
 */
