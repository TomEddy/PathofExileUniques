package pathofexileuniques.eddytom.com.pathofexileuniques;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
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

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button all,cat,search,myUniq,amulets,belts,rings,quivers;
    private ImageView display,searchdisplay;
    private AutoCompleteTextView search_bar;
    private ArrayAdapter search_adapter;
    private int counter;
    private ArrayList<Unique> allUniques, tempList;


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

        cat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                all.setVisibility(View.GONE);
                cat.setVisibility(View.GONE);
                search.setVisibility(View.GONE);
                myUniq.setVisibility(View.GONE);

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
                    if(tempList.get(i).getCatagory() != 0 ){
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
                    if(tempList.get(i).getCatagory() != 1 ){
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
                    if(tempList.get(i).getCatagory() != 2 ){
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
                    if(tempList.get(i).getCatagory() != 3 ){
                        tempList.remove(i);
                        i--;
                    }
                }
                display.setImageResource(tempList.get(0).getImage_Resource());
                display.setVisibility(View.VISIBLE);
            }
        });


        display.setOnTouchListener(new OnSwipeTouchListener(MainActivity.this) {
            public void onSwipeTop() {
                Toast.makeText(MainActivity.this, "top", Toast.LENGTH_SHORT).show();
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
                if(counter < tempList.size()) {
                    counter++;
                    display.setImageResource(tempList.get(counter).getImage_Resource());
                }else{
                    Toast.makeText(MainActivity.this, "End of List", Toast.LENGTH_SHORT).show();
                }
                }
            public void onSwipeBottom() {
                Toast.makeText(MainActivity.this, "bottom", Toast.LENGTH_SHORT).show();
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
                search_bar.dismissDropDown();
                search_bar.setVisibility(View.GONE);
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

            //Amulets - code 0
            ArrayList<String> temp = new ArrayList<>();
            temp.add("Maximum Life");
            temp.add("Fire Resistance");
            temp.add("Life Regenerated");
            temp.add("Evasion Rating");
            Unique Aruku = new Unique("Aruku Tiki", 0, temp, R.drawable.arakutiki);
            temp.clear();
            temp.add("All Attributes");
            Unique Astra = new Unique("Astramentis", 0, temp, R.drawable.astramentis);
            Unique AtziriFoi = new Unique("Atziri's Foible", 0, temp, R.drawable.atzirifoible);
            Unique AulUprising = new Unique("Aul's Uprising", 0, temp, R.drawable.aulsuprising);
            Unique AulUprising2 = new Unique("Aul's Uprising", 0, temp, R.drawable.aulsuprisingtwo);
            Unique AulUprising3 = new Unique("Aul's Uprising", 0, temp, R.drawable.aulsuprisingthree);
            Unique AulUprising4 = new Unique("Aul's Uprising", 0, temp, R.drawable.aulsuprisingfour);
            Unique BiscosCollar = new Unique("Bisco's Collar", 0, temp, R.drawable.biscocollar);
            Unique BlightwellClutch = new Unique("Blightwell Clutching Talisman", 0, temp, R.drawable.blightwell);
            Unique BloodCorruption = new Unique("Blood of Corruption", 0, temp, R.drawable.bloodofcor);
            Unique Bloodgrip = new Unique("Bloodgrip", 0, temp, R.drawable.bloodgrip);
            Unique Carnage = new Unique("Carnage Heart", 0, temp, R.drawable.carnage);
            Unique Choir = new Unique("Choir of the Storm", 0, temp, R.drawable.choir);
            Unique DarSal = new Unique("Daresso's Salute", 0, temp, R.drawable.daressosolu);
            Unique Extractor = new Unique("Extractor Mentis", 0, temp, R.drawable.extractor);
            Unique EyeChay = new Unique("Eye of Chayula", 0, temp, R.drawable.eyechay);
            Unique EyeInnoc = new Unique("Eye of Innocence", 0, temp, R.drawable.eyeinoc);
            Unique EyeGreat = new Unique("Eyes of the Greatwolf", 0, temp, R.drawable.eyegreatwolf);
            Unique Gloom = new Unique("Gloomfang", 0, temp, R.drawable.gloomfang);
            Unique Hinekora = new Unique("Hinekora's Sight", 0, temp, R.drawable.hinekora);
            Unique Impress1 = new Unique("Impresence (Chaos)", 0, temp, R.drawable.impressone);
            Unique Impress2 = new Unique("Impresence (Lightning)", 0, temp, R.drawable.impresstwo);
            Unique Impress3 = new Unique("Impresence (Physical)", 0, temp, R.drawable.impressthree);
            Unique Impress4 = new Unique("Impresence (Cold)", 0, temp, R.drawable.impressfour);
            Unique Impress5 = new Unique("Impresence (Fire)", 0, temp, R.drawable.impressfive);
            Unique KaruiCharge = new Unique("Karui Charge", 0, temp, R.drawable.karuich);
            Unique KaruiWard = new Unique("Karui Ward", 0, temp, R.drawable.karuiward);
            Unique MaligarosCruelty = new Unique("Maligaro's Cruelty", 0, temp, R.drawable.malicru);
            Unique MarylenesFallacy = new Unique("Marylene's Fallacy", 0, temp, R.drawable.maryl);
            Unique NaturalHierarchy = new Unique("Natural Hierarchy", 0, temp, R.drawable.naturalh);
            Unique NgamahuTiki = new Unique("Ngamahu Tiki", 0, temp, R.drawable.ngamahu);
            Unique NightsHold = new Unique("Night's Hold", 0, temp, R.drawable.nightshold);
            Unique PerquilsToe = new Unique("Perquil's Toe", 0, temp, R.drawable.perqtoe);
            Unique PresenceofChayula = new Unique("Presence of Chayula", 0, temp, R.drawable.preschay);
            Unique RashkaldorsPatience = new Unique("Rashkaldor's Patience", 0, temp, R.drawable.rashkal);
            Unique RigwaldsCurse = new Unique("Rigwald's Curse", 0, temp, R.drawable.riwaldscurse);
            Unique SacrificialHeart = new Unique("Sacrificial Heart", 0, temp, R.drawable.sacheart);
            Unique ShapersSeed = new Unique("Shaper's Seed", 0, temp, R.drawable.shapeseed);
            Unique Sidhebreath = new Unique("Sidhebreath", 0, temp, R.drawable.sidebreath);
            Unique StarofWraeclast = new Unique("Star of Wraeclast", 0, temp, R.drawable.starofw);
            Unique StoneofLazhwar = new Unique("Stone of Lazhwar", 0, temp, R.drawable.stoneofl);
            Unique TearofPurity = new Unique("Tear of Purity", 0, temp, R.drawable.tearofpur);
            Unique TheAnvil = new Unique("The Anvil", 0, temp, R.drawable.anvil);
            Unique TheAscetic = new Unique("The Ascetic", 0, temp, R.drawable.theascetic);
            Unique TheAylardex = new Unique("The Aylardex", 0, temp, R.drawable.theaylar);
            Unique TheEffigon = new Unique("The Effigon", 0, temp, R.drawable.theeffig);
            Unique TheHalcyon = new Unique("The Halcyon", 0, temp, R.drawable.thehal);
            Unique TheIgnomon = new Unique("The Ignomon", 0, temp, R.drawable.theign);
            Unique ThePandemonius = new Unique("The Pandemonius", 0, temp, R.drawable.theperand);
            Unique ThePrimordialChain = new Unique("The Primordial Chain", 0, temp, R.drawable.theprimo);
            Unique UngilsHarmony = new Unique("Ungil's Harmony", 0, temp, R.drawable.ungilsharm);
            Unique VictariosAcuity = new Unique("Victario's Acuity", 0, temp, R.drawable.victaracu);
            Unique VollsDevotion = new Unique("Voll's Devotion", 0, temp, R.drawable.vollsdevo);
            Unique WarpedTimepiece = new Unique("Warped Timepiece", 0, temp, R.drawable.warpedtime);
            Unique Winterheart = new Unique("Winterheart", 0, temp, R.drawable.winterheart);
            Unique XophsBlood = new Unique("Xoph's Blood", 0, temp, R.drawable.xophblood);
            Unique XophsHeart = new Unique("Xoph's Heart", 0, temp, R.drawable.xophheart);
            Unique YokeofSuffering = new Unique("Yoke of Suffering", 0, temp, R.drawable.yokesuff);
            Unique ZerphisHeart = new Unique("Zerphi's Heart", 0, temp, R.drawable.zephriheart);

            //Belts - code 1
            Unique AscentFromFlesh = new Unique("Ascent From Flesh", 1, temp, R.drawable.acentfrom);
            Unique Auxium = new Unique("Auxium", 1, temp, R.drawable.auxium);
            Unique BatedBreath = new Unique("Bated Breath", 1, temp, R.drawable.batedbreath);
            Unique BeltoftheDeceiver = new Unique("Belt of the Deceiver", 1, temp, R.drawable.beltdeci);
            Unique BiscosLeash = new Unique("Bisco's Leash", 1, temp, R.drawable.biscoleesh);
            Unique CowardsChains = new Unique("Coward's Chains", 1, temp, R.drawable.cowardchain);
            Unique CowardsLegacy = new Unique("Coward's Legacy", 1, temp, R.drawable.cowardsleg);
            Unique CyclopeanCoil = new Unique("Cyclopean Coil", 1, temp, R.drawable.cyclopeancoil);
            Unique DarknessEnthroned = new Unique("Darkness Enthroned", 1, temp, R.drawable.darcknessen);
            Unique DoryanisInvitation1 = new Unique("Doryani's Invitation (Cold Damage)", 1, temp, R.drawable.doryinvone);
            Unique DoryanisInvitation2 = new Unique("Doryani's Invitation (Fire Damage)", 1, temp, R.drawable.doryinvtwo);
            Unique DoryanisInvitation3 = new Unique("Doryani's Invitation (Physical Damage)", 1, temp, R.drawable.doryinvthree);
            Unique DoryanisInvitation4 = new Unique("Doryani's Invitation (Lightning Damage)", 1, temp, R.drawable.doryinvfour);
            Unique DyadianDawn = new Unique("Dyadian Dawn", 1, temp, R.drawable.dyadiandawn);
            Unique Faminebind = new Unique("Faminebind", 1, temp, R.drawable.faminbind);
            Unique Feastbind = new Unique("Feastbind", 1, temp, R.drawable.feastbind);
            Unique Gluttony = new Unique("Gluttony", 1, temp, R.drawable.gluttony);
            Unique Headhunter = new Unique("Headhunter", 1, temp, R.drawable.headhunter);
            Unique ImmortalFlesh = new Unique("Immortal Flesh", 1, temp, R.drawable.immortalflesh);
            Unique MaligarosRestraint = new Unique("Maligaro's Restraint", 1, temp, R.drawable.malirest);
            Unique MeginordsGirdle = new Unique("Meginord's Girdle", 1, temp, R.drawable.meginords);
            Unique PerandusBlazon = new Unique("Perandus Blazon", 1, temp, R.drawable.perandusblaz);
            Unique Perseverance = new Unique("Perseverance", 1, temp, R.drawable.perserverance);
            Unique Prismweave = new Unique("Prismweave", 1, temp, R.drawable.prismweave);
            Unique RyslathasCoil = new Unique("Ryslatha's Coil", 1, temp, R.drawable.ryslath);
            Unique SoulTether = new Unique("Soul Tether", 1, temp, R.drawable.soultether);
            Unique Soulthirst = new Unique("Soulthirst", 1, temp, R.drawable.soulthirst);
            Unique StringofServitude = new Unique("String of Servitude", 1, temp, R.drawable.stringofserv);
            Unique Sunblast = new Unique("Sunblast", 1, temp, R.drawable.sunblast);
            Unique TheFlowUntethered = new Unique("The Flow Untethered", 1, temp, R.drawable.theflow);
            Unique TheMagnate = new Unique("The Magnate", 1, temp, R.drawable.themagnate);
            Unique TheNomad = new Unique("The Nomad", 1, temp, R.drawable.thenomad);
            Unique TheRetch = new Unique("The Retch", 1, temp, R.drawable.theretch);
            Unique TheTactician = new Unique("The Tactician", 1, temp, R.drawable.thetactician);
            Unique UmbilicusImmortalis = new Unique("Umbilicus Immortalis", 1, temp, R.drawable.umbilicious);
            Unique WurmsMolt = new Unique("Wurm's Molt", 1, temp, R.drawable.wurmsmolt);

//Rings - code 2
            Unique AhkelisMeadow = new Unique("Ahkeli's Meadow", 2, temp, R.drawable.ahkelimeadow);
            Unique AhkelisMountain = new Unique("Ahkeli's Mountain", 2, temp, R.drawable.ahkelimountain);
            Unique AhkelisValley = new Unique("Ahkeli's Valley", 2, temp, R.drawable.ahkelivalley);
            Unique Andvarius = new Unique("Andvarius", 2, temp, R.drawable.andv);
            Unique AnglersPlait = new Unique("Angler's Plait", 2, temp, R.drawable.anglerspl);
            Unique BereksGrip = new Unique("Berek's Grip", 2, temp, R.drawable.bereksgrip);
            Unique BereksPass = new Unique("Berek's Pass", 2, temp, R.drawable.berekspass);
//Berek's Respite
            Unique Blackheart = new Unique("Blackheart", 2, temp, R.drawable.blackheart);
            Unique Bloodboil = new Unique("Bloodboil", 2, temp, R.drawable.bloodboil);
            Unique BrinerotMark = new Unique("Brinerot Mark", 2, temp, R.drawable.brinenotmark);
//Call of the Brotherhood
            Unique DeathRush = new Unique("Death Rush", 2, temp, R.drawable.deathrush);
            Unique DoedresDamning = new Unique("Doedre's Damning", 2, temp, R.drawable.doesdresdamning);
            Unique DreamFragments = new Unique("Dream Fragments", 2, temp, R.drawable.dreamfragments);
            Unique Emberwake = new Unique("Emberwake", 2, temp, R.drawable.emberwake);
            Unique EssenceWorm = new Unique("Essence Worm", 2, temp, R.drawable.essenceworm);
            Unique GiftsfromAbove = new Unique("Gifts from Above", 2, temp, R.drawable.giftssfromabove);
            Unique HeartboundLoop = new Unique("Heartbound Loop", 2, temp, R.drawable.heartboundloop);
            Unique KaomsSign = new Unique("Kaom's Sign", 2, temp, R.drawable.kaomssign);
            Unique KaomsWay = new Unique("Kaom's Way", 2, temp, R.drawable.kaomsway);
            Unique Kikazaru = new Unique("Kikazaru", 2, temp, R.drawable.kikazaru);
            Unique LeHeupofAll = new Unique("Le Heup of All", 2, temp, R.drawable.leheup);
            Unique LorisLantern = new Unique("Lori's Lantern", 2, temp, R.drawable.lorislantern);
            Unique MalachaisArtifice = new Unique("Malachai's Artifice", 2, temp, R.drawable.malachaisartifice);
            Unique MarkofSubmission = new Unique("Mark of Submission", 2, temp, R.drawable.markofsubmission);
            Unique MarkoftheElder = new Unique("Mark of the Elder", 2, temp, R.drawable.markoftheelder);
            Unique MarkoftheShaper = new Unique("Mark of the Shaper", 2, temp, R.drawable.markoftheshaper);
            Unique MingsHeart = new Unique("Ming's Heart", 2, temp, R.drawable.mingsheart);
            Unique MokousEmbrace = new Unique("Mokou's Embrace", 2, temp, R.drawable.mokousembrace);
            Unique MutewindSeal = new Unique("Mutewind Seal", 2, temp, R.drawable.mutewindseal);
            Unique NgamahusSign = new Unique("Ngamahu's Sign", 2, temp, R.drawable.ngamahussign);
            Unique PerandusSignet = new Unique("Perandus Signet", 2, temp, R.drawable.peransussignet);
            Unique Praxis = new Unique("Praxis", 2, temp, R.drawable.praxis);
            Unique PrecursorsEmblem1 = new Unique("Precursor's Emblem (Endurance, Frenzy and Power Charge)", 2, temp, R.drawable.percusersemblem);
            Unique PrecursorsEmblem2 = new Unique("Precursor's Emblem (Endurance Charge)", 2, temp, R.drawable.precurs2);
            Unique PrecursorsEmblem3 = new Unique("Precursor's Emblem (Frenzy Charge)", 2, temp, R.drawable.precurs3);
            Unique PrecursorsEmblem4 = new Unique("Precursor's Emblem (Power Charge)", 2, temp, R.drawable.precurs4);
            Unique PrecursorsEmblem5 = new Unique("Precursor's Emblem (Frenzy and Power Charge)", 2, temp, R.drawable.precurs5);
            Unique PrecursorsEmblem6 = new Unique("Precursor's Emblem (Endurance and Frenzy Charge)", 2, temp, R.drawable.precurs6);
            Unique PrecursorsEmblem7 = new Unique("Precursor's Emblem (Endurance and Power Charge)", 2, temp, R.drawable.precurs7);
            Unique PutembosMeadow = new Unique("Putembo's Meadow", 2, temp, R.drawable.putembosmeadow);
            Unique PutembosMountain = new Unique("Putembo's Mountain", 2, temp, R.drawable.putembosmountain);
            Unique PutembosValley = new Unique("Putembo's Valley", 2, temp, R.drawable.putembosvalley);
            Unique Pyre = new Unique("Pyre", 2, temp, R.drawable.pyre);
            Unique RedbladeBand = new Unique("Redblade Band", 2, temp, R.drawable.redbladeband);
            Unique RigwaldsCrest = new Unique("Rigwald's Crest", 2, temp, R.drawable.rigwaldscrest);
            Unique RomirasBanquet = new Unique("Romira's Banquet", 2, temp, R.drawable.romirasbanquet);
            Unique ShavronnesRevelation = new Unique("Shavronne's Revelation", 2, temp, R.drawable.shavronnesrevelation);
            Unique SibylsLament = new Unique("Sibyl's Lament", 2, temp, R.drawable.sibylslament);
            Unique Snakepit = new Unique("Snakepit", 2, temp, R.drawable.snakepit);
            Unique Stormfire = new Unique("Stormfire", 2, temp, R.drawable.stormfire);
            Unique TasaliosSign = new Unique("Tasalio's Sign", 2, temp, R.drawable.tasaliossign);
            Unique TheHungryLoop = new Unique("The Hungry Loop", 2, temp, R.drawable.thehungryloop);
            Unique ThePariah = new Unique("The Pariah", 2, temp, R.drawable.thepariah);
            Unique TheTaming = new Unique("The Taming", 2, temp, R.drawable.thetaming);
            Unique TheWardensBrand = new Unique("The Warden's Brand", 2, temp, R.drawable.thewardensband);
            Unique ThiefsTorment = new Unique("Thief's Torment", 2, temp, R.drawable.thiefstorment);
            Unique Timeclasp = new Unique("Timeclasp", 2, temp, R.drawable.timeclasp);
            Unique Timetwist = new Unique("Timetwist", 2, temp, R.drawable.timetwist);
            Unique UzazasMeadow = new Unique("Uzaza's Meadow", 2, temp, R.drawable.uzazusmeadow);
            Unique UzazasMountain = new Unique("Uzaza's Mountain", 2, temp, R.drawable.uzazusmountain);
            Unique UzazasValley = new Unique("Uzaza's Valley", 2, temp, R.drawable.uzazusvalley);
            Unique ValakosSign = new Unique("Valako's Sign", 2, temp, R.drawable.valakossign);
            Unique Valyrium = new Unique("Valyrium", 2, temp, R.drawable.valyrium);
            Unique VentorsGamble = new Unique("Ventor's Gamble", 2, temp, R.drawable.ventorsgamble);
            Unique Voideye = new Unique("Voideye", 2, temp, R.drawable.voideye);
            Unique Voidheart = new Unique("Voidheart", 2, temp, R.drawable.voidheart);
            Unique Winterweave = new Unique("Winterweave", 2, temp, R.drawable.winterweave);

//Quivers - code 3
            Unique AsphyxiasWrath = new Unique("Asphyxia's Wrath", 3, temp, R.drawable.asphyxiaswrath);
            Unique Blackgleam = new Unique("Blackgleam", 3, temp, R.drawable.blackgleam);
            Unique Cragfall = new Unique("Cragfall", 3, temp, R.drawable.cragfall);
            Unique Craghead = new Unique("Craghead", 3, temp, R.drawable.craghead);
            Unique Drillneck = new Unique("Drillneck", 3, temp, R.drawable.drillneck);
            Unique HyrrisBite = new Unique("Hyrri's Bite", 3, temp, R.drawable.hyrrisbite);
            Unique HyrrisDemise = new Unique("Hyrri's Demise", 3, temp, R.drawable.hyrrisdemise);
            Unique MaloneysNightfall = new Unique("Maloney's Nightfall", 3, temp, R.drawable.malonysnightfall);
            Unique Rearguard = new Unique("Rearguard", 3, temp, R.drawable.reargaurd);
            Unique RigwaldsQuills = new Unique("Rigwald's Quills", 3, temp, R.drawable.rigwaldsquills);
            Unique SaemusGift = new Unique("Saemus' Gift", 3, temp, R.drawable.saemusgift);
            Unique Skirmish = new Unique("Skirmish", 3, temp, R.drawable.sirmish);
            Unique SoulStrike = new Unique("Soul Strike", 3, temp, R.drawable.soulstrike);
            Unique TheFracturingSpinner = new Unique("The Fracturing Spinner", 3, temp, R.drawable.thefracturedspinner);
            Unique TheSignalFire = new Unique("The Signal Fire", 3, temp, R.drawable.thesignalfire);
            Unique Voidfletcher = new Unique("Voidfletcher", 3, temp, R.drawable.voidfletcher);

//Body Armour - code 4
            Unique Bramblejack = new Unique("Bramblejack", 4, temp, R.drawable.bramblejack);
            Unique CraiceannsCarapace = new Unique("Craiceann's Carapace", 4, temp, R.drawable.craiceannscarapace);
            Unique DeathsOath = new Unique("Death's Oath", 4, temp, R.drawable.deathsoath);
            Unique GreedsEmbrace = new Unique("Greed's Embrace", 4, temp, R.drawable.greedsembrace);
            Unique IronHeart = new Unique("Iron Heart", 4, temp, R.drawable.ironheart);
            Unique KaomsHeart = new Unique("Kaom's Heart", 4, temp, R.drawable.kaomsheart);
            Unique LioneyesVision = new Unique("Lioneye's Vision", 4, temp, R.drawable.lioneyesvision);
            Unique SolarisLorica = new Unique("Solaris Lorica", 4, temp, R.drawable.solarislorica);
            Unique TheBrassDome = new Unique("The Brass Dome", 4, temp, R.drawable.thebrassdome);
            Unique TheIronFortress = new Unique("The Iron Fortress", 4, temp, R.drawable.theironfortress);
            Unique WallofBrambles = new Unique("Wall of Brambles", 4, temp, R.drawable.wallofbrambles);

            Unique Ashrend = new Unique("Ashrend", 4, temp, R.drawable.ashrend);
            Unique Briskwrap = new Unique("Briskwrap", 4, temp, R.drawable.briskwrap);
            Unique BronnsLithe = new Unique("Bronn's Lithe", 4, temp, R.drawable.brommslithe);
            Unique CosprisWill = new Unique("Cospri's Will", 4, temp, R.drawable.cospriswill);
            Unique FoxsFortune = new Unique("Fox's Fortune", 4, temp, R.drawable.foxsfourtune);
    Unique Foxshade = new Unique("Foxshade", 4, temp, R.drawable.foxshade);
    Unique HyrrisIre = new Unique("Hyrri's Ire", 4, temp, R.drawable.hyrrisire);
    Unique Kintsugi = new Unique("Kintsugi", 4, temp, R.drawable.kitsugi);
    Unique QueenoftheForest = new Unique("Queen of the Forest", 4, temp, R.drawable.queenoftheforest);
    Unique ThePerfectForm = new Unique("The Perfect Form", 4, temp, R.drawable.theperfectform);
    Unique TheRatCage = new Unique("The Rat Cage", 4, temp, R.drawable.theratcage);
    Unique TheSnowblindGrace = new Unique("The Snowblind Grace", 4, temp, R.drawable.thesnowblindgrace);
    Unique Wildwrap = new Unique("Wildwrap", 4, temp, R.drawable.wildwrap);
    Unique YrielsFostering1 = new Unique("Yriel's Fostering (Rhoa)", 4, temp, R.drawable.yrielsfostering);
    Unique YrielsFostering2 = new Unique("Yriel's Fostering (Snake)", 4, temp, R.drawable.yrielsfostering2);
    Unique YrielsFostering3 = new Unique("Yriel's Fostering (Ursa)", 4, temp, R.drawable.yrielsfostering3);

    Unique CloakofFlame = new Unique("Cloak of Flame", 4, temp, R.drawable.cloakofflame);
    Unique CloakofTawmrIsley = new Unique("Cloak of Tawm'r Isley", 4, temp, R.drawable.cloakoftawmrisley);
    Unique DiallasMalefaction = new Unique("Dialla's Malefaction", 4, temp, R.drawable.diallasmalefaction);
    Unique DoedresSkin = new Unique("Doedre's Skin", 4, temp, R.drawable.doedresskin);
    Unique FenumusShroud = new Unique("Fenumus' Shroud", 4, temp, R.drawable.fenumusshroud);
    Unique InfernalMantle = new Unique("Infernal Mantle", 4, temp, R.drawable.infernalmantle);
    Unique ShavronnesWrappings = new Unique("Shavronne's Wrappings", 4, temp, R.drawable.shavronneswrappings);
    Unique SkinoftheLords = new Unique("Skin of the Lords", 4, temp, R.drawable.skinofthelords);
    Unique SkinoftheLoyal = new Unique("Skin of the Lords", 4, temp, R.drawable.skinoftheloyal);
    Unique SoulMantle = new Unique("Soul Mantle", 4, temp, R.drawable.soulmantle);
    Unique TabulaRasa = new Unique("Tabula Rasa", 4, temp, R.drawable.tabularosa);
    Unique TheBeastFurShawl = new Unique("The Beast Fur Shawl", 4, temp, R.drawable.thebeastofthefurshawl);
    Unique TheComingCalamity = new Unique("The Coming Calamity", 4, temp, R.drawable.thecomingcalamity);
    Unique TheCovenant = new Unique("The Covenant", 4, temp, R.drawable.thecovenant);
    Unique ThousandRibbons = new Unique("Thousand Ribbons", 4, temp, R.drawable.thousandribbons);
    Unique VisMortis = new Unique("Vis Mortis", 4, temp, R.drawable.vismortis);
    Unique ZahndethusCassock = new Unique("Zahndethus' Cassock", 4, temp, R.drawable.zahndethuscassock);

    Unique BellyoftheBeast = new Unique("Belly of the Beast", 4, temp, R.drawable.bellyofthebeast);
    Unique CherrubimsMaleficence = new Unique("Cherrubim's Maleficence", 4, temp, R.drawable.cherrubimsmaleficence);
    Unique DaressosDefiance = new Unique("Daresso's Defiance", 4, temp, R.drawable.daressosdefiance);
    Unique FarrulsFur = new Unique("Farrul's Fur", 4, temp, R.drawable.farrulsfur);
    Unique GruthkulsPelt = new Unique("Gruthkul's Pelt", 4, temp, R.drawable.gruthkulspelt);
    Unique LightningCoil = new Unique("Lightning Coil", 4, temp, R.drawable.lightiningcoil);
    Unique VipersScales = new Unique("Viper's Scales", 4, temp, R.drawable.vipersscales);

    Unique AmbusCharge = new Unique("Ambu's Charge", 4, temp, R.drawable.ambuscharge);
    Unique ChainsofCommand = new Unique("Chains of Command", 4, temp, R.drawable.chainsofcommand);
    Unique CrystalVault = new Unique("Crystal Vault", 4, temp, R.drawable.crystalvault);
    Unique GeofrisSanctuary = new Unique("Geofri's Sanctuary", 4, temp, R.drawable.geofrissanctuary);
    Unique Icetomb = new Unique("Icetomb", 4, temp, R.drawable.icetomb);
    Unique IncandescentHeart = new Unique("Incandescent Heart", 4, temp, R.drawable.incandescentheart);
    Unique Kingsguard = new Unique("Kingsguard", 4, temp, R.drawable.kingsguard);
    Unique LightbaneRaiment = new Unique("Lightbane Raiment", 4, temp, R.drawable.lightbaneraiment);
    Unique Loreweave = new Unique("Loreweave", 4, temp, R.drawable.loreweave);
    Unique VollsProtector = new Unique("Voll's Protector", 4, temp, R.drawable.vollsprotector);

    Unique Bloodbond = new Unique("Bloodbond", 4, temp, R.drawable.bloodbond);
    Unique CloakofDefiance = new Unique("Cloak of Defiance", 4, temp, R.drawable.cloakofdefiance);
    Unique VictariosInfluence = new Unique("Victario's Influence", 4, temp, R.drawable.victariosinfluence);
    Unique Dendrobate = new Unique("Dendrobate", 4, temp, R.drawable.dendrobate);
    Unique CarcassJack = new Unique("Carcass Jack", 4, temp, R.drawable.carcasejack);
    Unique SaqawalsNest = new Unique("Saqawal's Nest", 4, temp, R.drawable.saqawalsnest);
    Unique InpulsasBrokenHeart = new Unique("Inpulsa's Broken Heart", 4, temp, R.drawable.inpulsasbrokenheart);
    Unique Tinkerskin = new Unique("Tinkerskin", 4, temp, R.drawable.tinkerskin);
    Unique ShroudoftheLightless = new Unique("Shroud of the Lightless", 4, temp, R.drawable.shroudofthelightless);
    Unique TheRestlessWard = new Unique("The Restless Ward", 4, temp, R.drawable.therestlessward);

    Unique Shadowstitch = new Unique("Shadowstitch", 4, temp, R.drawable.shadowstitch);
    Unique AtzirisSplendourOne = new Unique("Atziri's Splendour (Armour and Energy Shield)", 4, temp, R.drawable.atzirissplendour);
    Unique AtzirisSplendourTwo = new Unique("Atziri's Splendour (Armour and Life)", 4, temp, R.drawable.atzirissplendourtwo);
    Unique AtzirisSplendourThree = new Unique("Atziri's Splendour (Armour, Energy Shield and Life)", 4, temp, R.drawable.atzirissplendourthree);
    Unique AtzirisSplendourFour = new Unique("Atziri's Splendour (Armour, Evasion and Energy Shield)", 4, temp, R.drawable.atzirissplendourfour);
    Unique AtzirisSplendourFive = new Unique("Atziri's Splendour (Armour, Evasion and Life)", 4, temp, R.drawable.atzirissplendourfive);
    Unique AtzirisSplendourSix = new Unique("Atziri's Splendour (Energy Shield)", 4, temp, R.drawable.atzirissplendoursix);
    Unique AtzirisSplendourSeven = new Unique("Atziri's Splendour (Evasion and Energy Shield)", 4, temp, R.drawable.atzirissplendourseven);
    Unique AtzirisSplendourEight = new Unique("Atziri's Splendour (Evasion and Life)", 4, temp, R.drawable.atzirissplendoureight);
    Unique AtzirisSplendourNine = new Unique("Atziri's Splendour (Evasion, Energy Shield and Life)", 4, temp, R.drawable.atzirissplendournine);

//Boots - code 5
    Unique CraiceannsTracks = new Unique("Craiceann's Tracks", 5, temp, R.drawable.craiceannstracks);
    Unique DoryanisDelusionOne = new Unique("Doryani's Delusion (Armour)", 5, temp, R.drawable.doryanisdelusion);
    Unique KaomsRoots = new Unique("Kaom's Roots", 5, temp, R.drawable.kaomsroots);
    Unique RedbladeTramplers = new Unique("Redblade Tramplers", 5, temp, R.drawable.redbladetramplers);
    Unique Stormcharger = new Unique("Stormcharger", 5, temp, R.drawable.stormcharger);
    Unique TheInfinitePursuit = new Unique("The Infinite Pursuit", 5, temp, R.drawable.theinfinitepursuit);
    Unique TheRedTrail = new Unique("The Red Trail", 5, temp, R.drawable.theredtrails);
    Unique Windscream = new Unique("Windscream", 5, temp, R.drawable.windscream);
    Unique Windshriek = new Unique("Windshriek", 5, temp, R.drawable.windshriek);

    Unique AbberathsHooves = new Unique("Abberath's Hooves", 5, temp, R.drawable.abberathshooves);
    Unique AtzirisStep = new Unique("Atziri's Step", 5, temp, R.drawable.atzirisstep);
    Unique Deerstalker = new Unique("Deerstalker", 5, temp, R.drawable.deerstalker);
    Unique DoryanisDelusionTwo = new Unique("Doryani's Delusion (Evasion)", 5, temp, R.drawable.doryanisdelusiontwo);
    Unique FarrulsChase = new Unique("Farrul's Chase", 5, temp, R.drawable.farrulschase);
    Unique GarukhansFlight = new Unique("Garukhan's Flight", 5, temp, R.drawable.garukhansflight);
    Unique Goldwyrm = new Unique("Goldwyrm", 5, temp, R.drawable.goldwyrm);
    Unique SevenLeagueStep = new Unique("Seven-League Step", 5, temp, R.drawable.sevenleaguestep);
    Unique SinTrek = new Unique("Sin Trek", 5, temp, R.drawable.sintrek);
    Unique TheBloodDance = new Unique("The Blood Dance", 5, temp, R.drawable.theblooddance);
    Unique ThreestepAssault = new Unique("Three-step Assault", 5, temp, R.drawable.threestepassault);
    Unique VictariosFlight = new Unique("Victario's Flight", 5, temp, R.drawable.victariosflight);

    Unique BonesofUllr = new Unique("Bones of Ullr", 5, temp, R.drawable.bonesofullr);
    Unique DoryanisDelusionthree = new Unique("Doryani's Delusion (Energy Shield)", 5, temp, R.drawable.doryanisdelusionthree);
    Unique Greedtrap = new Unique("Greedtrap", 5, temp, R.drawable.greedtrap);
    Unique InyasEpiphany = new Unique("Inya's Epiphany", 5, temp, R.drawable.inyasepiphany);
    Unique Rainbowstride = new Unique("Rainbowstride", 5, temp, R.drawable.rainbowstride);
    Unique ShavronnesGambit = new Unique("Shavronne's Gambit", 5, temp, R.drawable.shavronnesgambit);
    Unique ShavronnesPace = new Unique("Shavronne's Pace", 5, temp, R.drawable.shavronnespace);
    Unique Skyforth = new Unique("Skyforth", 5, temp, R.drawable.skyforth);
    Unique SteppanEard = new Unique("Steppan Eard", 5, temp, R.drawable.steppaneard);
    Unique Wanderlust = new Unique("Wanderlust", 5, temp, R.drawable.wanderlust);
    Unique Wondertrap = new Unique("Wondertrap", 5, temp, R.drawable.wondertrap);

    Unique DarkrayVectors = new Unique("Darkray Vectors", 5, temp, R.drawable.darkrayvectors);
    Unique Duskblight = new Unique("Duskblight", 5, temp, R.drawable.duskblight);
    Unique Dusktoe = new Unique("Dusktoe", 5, temp, R.drawable.dusktoe);
    Unique LioneyesPaws = new Unique("Lioneye's Paws", 5, temp, R.drawable.lioneyespaws);
    Unique MutewindWhispersteps = new Unique("Mutewind Whispersteps", 5, temp, R.drawable.mutewindwhispersteps);
    Unique SaqawalsTalons = new Unique("Saqawal's Talons", 5, temp, R.drawable.saqawalstalons);

    Unique AlberonsWarpath = new Unique("Alberon's Warpath", 5, temp, R.drawable.alberonswarpath);
    Unique DeathsDoor = new Unique("Death's Door", 5, temp, R.drawable.deathsdoor);
    Unique GangsMomentum = new Unique("Gang's Momentum", 5, temp, R.drawable.gangsmomentum);
    Unique RalakeshsImpatience = new Unique("Ralakesh's Impatience", 5, temp, R.drawable.ralakeshsimpatience);
    Unique WakeofDestruction = new Unique("Wake of Destruction", 5, temp, R.drawable.wakeofdestruction);

    Unique BrinerotWhalers = new Unique("Brinerot Whalers", 5, temp, R.drawable.brinerotwhalers);
    Unique BubonicTrailOne = new Unique("Bubonic Trail (1 Abyssal Socket)", 5, temp, R.drawable.bubonictrialone);
    Unique BubonicTrailTwo = new Unique("Bubonic Trail (2 Abyssal Sockets)", 5, temp, R.drawable.bubonictrailtwo);
    Unique DanceoftheOffered = new Unique("Dance of the Offered", 5, temp, R.drawable.danceoftheoffered);
    Unique FenumusSpinnerets = new Unique("Fenumus' Spinnerets", 5, temp, R.drawable.fenumusspinnerets);
    Unique NomicsStorm = new Unique("Nomic's Storm", 5, temp, R.drawable.nomicsstorm);
    Unique Omeyocan = new Unique("Omeyocan", 5, temp, R.drawable.omeyocan);
    Unique Sundance = new Unique("Sundance", 5, temp, R.drawable.sundance);
    Unique Sunspite = new Unique("Sunspite", 5, temp, R.drawable.sunspite);
    Unique Voidwalker = new Unique("Voidwalker", 5, temp, R.drawable.voidwalker);

    Unique DemigodsStride = new Unique("Demigod's Stride", 5, temp, R.drawable.demigodsstride);

    //Gloves - code 6
    Unique AtzirisAcuity = new Unique("Atziri's Acuity", 6, temp, R.drawable.atzirisacuity);
    Unique CraiceannsPincers = new Unique("Craiceann's Pincers", 6, temp, R.drawable.craiceannspincers);
    Unique DoryanisFist = new Unique("Doryani's Fist", 6, temp, R.drawable.doryanisfist);
    Unique EmpiresGrasp = new Unique("Empire's Grasp", 6, temp, R.drawable.empiresgrasp);
    Unique Giantsbane = new Unique("Giantsbane", 6, temp, R.drawable.giantsbane);
    Unique LochtonialCaress = new Unique("Lochtonial Caress", 6, temp, R.drawable.lochtonialcaress);
    Unique MeginordsVise = new Unique("Meginord's Vise", 6, temp, R.drawable.meginordsvise);
    Unique VerusosBatteringRams = new Unique("Veruso's Battering Rams", 6, temp, R.drawable.verusosbatteringrams);
    Unique WindsofChange = new Unique("Winds of Change", 6, temp, R.drawable.windsofchange);

    Unique Hrimburn = new Unique("Hrimburn", 6, temp, R.drawable.hrimburn);
    Unique Hrimsorrow = new Unique("Hrimsorrow", 6, temp, R.drawable.hrimsorrow);
    Unique MaligarosVirtuosity = new Unique("Maligaro's Virtuosity", 6, temp, R.drawable.maligarosvirtuosity);
    Unique Oskarm = new Unique("Oskarm", 6, temp, R.drawable.oskarm);

    Unique Allelopathy = new Unique("Allelopathy", 6, temp, R.drawable.allelopathy);
    Unique AsenathsGentleTouch = new Unique("Asenath's Gentle Touch", 6, temp, R.drawable.asenathsgentletouch);
    Unique DemonStitcher = new Unique("Demon Stitcher", 6, temp, R.drawable.demonstitcher);
    Unique DoedresMalevolence = new Unique("Doedre's Malevolence", 6, temp, R.drawable.doedresmalevolence);
    Unique DoedresTenure = new Unique("Doedre's Tenure", 6, temp, R.drawable.doedrestenure);
    Unique GripoftheCouncil = new Unique("Grip of the Council", 6, temp, R.drawable.gripofthecouncil);
    Unique KalisasGrace = new Unique("Kalisa's Grace", 6, temp, R.drawable.kalisasgrace);
    Unique SadimasTouch = new Unique("Sadima's Touch", 6, temp, R.drawable.sadimastouch);
    Unique Voidbringer = new Unique("Voidbringer", 6, temp, R.drawable.voidbringer);

    Unique Aurseize = new Unique("Aurseize", 6, temp, R.drawable.aueseize);
    Unique FarrulsPounce = new Unique("Farrul's Pounce", 6, temp, R.drawable.farrulspounce);
    Unique FleshandSpirit = new Unique("Flesh and Spirit", 6, temp, R.drawable.fleshandspirit);
    Unique Haemophilia = new Unique("Haemophilia", 6, temp, R.drawable.haemophilia);
    Unique Slitherpinch = new Unique("Slitherpinch", 6, temp, R.drawable.slitherpinch);
    Unique Surgebinders = new Unique("Surgebinders", 6, temp, R.drawable.surgebinders);
    Unique TombfistOne = new Unique("Tombfist (1 Abyssal Socket)", 6, temp, R.drawable.tombfistone);
    Unique TombfistTwo = new Unique("Tombfist (2 Abyssal Socket)", 6, temp, R.drawable.tombfisttwo);
    Unique VaalCaress = new Unique("Vaal Caress", 6, temp, R.drawable.vaalcaress);
    Unique Wyrmsign = new Unique("Wyrmsign", 6, temp, R.drawable.wrymsign);

    Unique CommandofthePit = new Unique("Command of the Pit (1 Abyssal Socket)", 6, temp, R.drawable.commandofthepit);
    Unique CommandofthePitTwo = new Unique("Command of the Pit (2 Abyssal Socket)", 6, temp, R.drawable.commandofthepittwo);
    Unique NullandVoid = new Unique("Null and Void", 6, temp, R.drawable.nullandvoid);
    Unique Repentance = new Unique("Repentance", 6, temp, R.drawable.repentance);
    Unique SaqawalsWinds = new Unique("Saqawal's Winds", 6, temp, R.drawable.saqawalswinds);
    Unique ShacklesoftheWretched = new Unique("Shackles of the Wretched", 6, temp, R.drawable.shackelsofthewretched);
    Unique ShapersTouch = new Unique("Shaper's Touch", 6, temp, R.drawable.shaperstouch);
    Unique Southbound = new Unique("Southbound", 6, temp, R.drawable.southbound);
    Unique VolkuursGuidanceOne = new Unique("Volkuur's Guidance (Lightning)", 6, temp, R.drawable.volkuursguidance);
    Unique VolkuursGuidanceTwo = new Unique("Volkuur's Guidance (Cold)", 6, temp, R.drawable.volkuursguidancetwo);
    Unique VolkuursGuidanceThree = new Unique("Volkuur's Guidance (Fire)", 6, temp, R.drawable.volkuursguidancethree);

    Unique ArchitectsHand = new Unique("Architect's Hand", 6, temp, R.drawable.architectshand);
    Unique BlasphemersGrasp = new Unique("Blasphemer's Grasp", 6, temp, R.drawable.blasphemersgrasp);
    Unique Facebreaker = new Unique("Facebreaker", 6, temp, R.drawable.facebreaker);
    Unique FenumusWeave = new Unique("Fenumus' Weave", 6, temp, R.drawable.fenumusweave);
    Unique MalachaisMark = new Unique("Malachai's Mark", 6, temp, R.drawable.malachaismark);
    Unique OndarsClasp = new Unique("Ondar's Clasp", 6, temp, R.drawable.ondarsclasp);
    Unique ShadowsandDust = new Unique("Shadows and Dust", 6, temp, R.drawable.shadowsanddust);
    Unique SlavedriversHand = new Unique("Slavedriver's Hand", 6, temp, R.drawable.slavedrivershand);
    Unique Snakebite = new Unique("Snakebite", 6, temp, R.drawable.snakebite);
    Unique TheEmbalmer = new Unique("The Embalmer", 6, temp, R.drawable.theembalmer);
    Unique Thunderfist = new Unique("Thunderfist", 6, temp, R.drawable.thunderfist);

    Unique DemigodsTouch = new Unique("Demigod's Touch", 6, temp, R.drawable.demigodstouch);

//Helmets - code 7
    Unique Abyssus = new Unique("Abyssus", 7, temp, R.drawable.abyssus);
    Unique EzomyteHold = new Unique("Ezomyte Hold", 7, temp, R.drawable.ezomyte);
    Unique EzomytePeak = new Unique("Ezomyte Peak", 7, temp, R.drawable.ezomytepeak);
    Unique HrimnorsResolve = new Unique("Hrimnor's Resolve", 7, temp, R.drawable.hrimnorsresolve);
    Unique TheBaron = new Unique("The Baron", 7, temp, R.drawable.thebaron);
    Unique TheFormlessFlame = new Unique("The Formless Flame", 7, temp, R.drawable.theformlessflame);
    Unique TheFormlessInferno = new Unique("The Formless Inferno", 7, temp, R.drawable.theformlessinferno);

    Unique AlphasHowl = new Unique("Alpha's Howl", 7, temp, R.drawable.alphashowl);
    Unique FairgravesTricorne = new Unique("Fairgraves' Tricorne", 7, temp, R.drawable.fairgravestricorne);
    Unique Frostferno = new Unique("Frostferno", 7, temp, R.drawable.frostferno);
    Unique Goldrim = new Unique("Goldrim", 7, temp, R.drawable.goldrim);
    Unique Heatshiver = new Unique("Heatshiver", 7, temp, R.drawable.heatshiver);
    Unique Obscurantis = new Unique("Obscurantis", 7, temp, R.drawable.obscurantis);
    Unique RatsNest = new Unique("Rat's Nest", 7, temp, R.drawable.ratsnest);
    Unique SaqawalsFlock = new Unique("Saqawal's Flock", 7, temp, R.drawable.saqawalsflock);
    Unique StarkonjasHead = new Unique("Starkonja's Head", 7, temp, R.drawable.starkonjashead);

    Unique AsenathsChant = new Unique("Asenath's Chant", 7, temp, R.drawable.asenathschant);
    Unique AsenathsMark = new Unique("Asenath's Mark", 7, temp, R.drawable.asenathsmark);
    Unique ChitusApex = new Unique("Chitus' Apex", 7, temp, R.drawable.chitusapex);
    Unique CrownofEyes = new Unique("Crown of Eyes", 7, temp, R.drawable.crownofeyes);
    Unique CrownofThorns = new Unique("Crown of Thorns", 7, temp, R.drawable.crownofthornes);
    Unique DoedresScorn = new Unique("Doedre's Scorn", 7, temp, R.drawable.doedresscorn);
    Unique EbersUnification = new Unique("Eber's Unification", 7, temp, R.drawable.ebersunification);
    Unique FenumusToxins = new Unique("Fenumus' Toxins", 7, temp, R.drawable.fenumustoxins);
    Unique HaleNegatorOne = new Unique("Hale Negator (1 Abyssal Socket)", 7, temp, R.drawable.halenegator);
    Unique HaleNegatorTwo = new Unique("Hale Negator (2 Abyssal Socket)", 7, temp, R.drawable.halenegatortwo);
    Unique Indigon = new Unique("Indigon", 7, temp, R.drawable.indigon);
    Unique MarkoftheRedCovenant = new Unique("Mark of the Red Covenant", 7, temp, R.drawable.markoftheredcovenant);
    Unique MartyrsCrown = new Unique("Martyr's Crown", 7, temp, R.drawable.martyrscrown);
    Unique RimeGaze = new Unique("Rime Gaze", 7, temp, R.drawable.rimegaze);
    Unique ScoldsBridle = new Unique("Scold's Bridle", 7, temp, R.drawable.scoldsbridle);
    Unique Wraithlord = new Unique("Wraithlord", 7, temp, R.drawable.wraithlord);
    Unique YlfebansTrickery = new Unique("Ylfeban's Trickery", 7, temp, R.drawable.ylfebanstrickery);

    Unique BlackSunCrest = new Unique("Black Sun Crest", 7, temp, R.drawable.blacksuncrest);
    Unique Deidbell = new Unique("Deidbell", 7, temp, R.drawable.deidbell);
    Unique Deidbellow = new Unique("Deidbellow", 7, temp, R.drawable.deidbellow);
    Unique DevotosDevotion = new Unique("Devoto's Devotion", 7, temp, R.drawable.devotosdevotion);
    Unique Skullhead = new Unique("Skullhead", 7, temp, R.drawable.skullhead);
    Unique TheBringerofRain = new Unique("The Bringer of Rain", 7, temp, R.drawable.thebringerofrain);
    Unique ThePeregrine = new Unique("The Peregrine", 7, temp, R.drawable.theperegrine);

    Unique AhnsContempt = new Unique("Ahn's Contempt", 7, temp, R.drawable.ahnscontempt);
    Unique CraiceannsChitin = new Unique("Craiceann's Chitin", 7, temp, R.drawable.craiceannschitin);
    Unique CrownoftheTyrant = new Unique("Crown of the Tyrant", 7, temp, R.drawable.crownofthetyrant);
    Unique GeofrisCrest = new Unique("Geofri's Crest", 7, temp, R.drawable.geofriscrest);
    Unique GeofrisLegacy = new Unique("Geofri's Legacy", 7, temp, R.drawable.geofrislegacy);
    Unique Honourhome = new Unique("Honourhome", 7, temp, R.drawable.honourhome);
    Unique KitavasThirst = new Unique("Kitava's Thirst", 7, temp, R.drawable.kitavasthirst);
    Unique LightpoacherOne = new Unique("Lightpoacher (1 Abyssal Socket)", 7, temp, R.drawable.lightpoacher);
    Unique LightpoacherTwo = new Unique("Lightpoacher (2 Abyssal Socket)", 7, temp, R.drawable.lightpoachertwo);
    Unique MalachaisVision = new Unique("Malachai's Vision", 7, temp, R.drawable.malachaisvision);
    Unique MaskoftheSpiritDrinker = new Unique("Mask of the Spirit Drinker", 7, temp, R.drawable.maskofthespiritdrinker);
    Unique MaskoftheStitchedDemon = new Unique("Mask of the Stitched Demon", 7, temp, R.drawable.maskofthestitcheddemon);
    Unique MemoryVault = new Unique("Memory Vault", 7, temp, R.drawable.memoryvault);
    Unique Mindspiral = new Unique("Mindspiral", 7, temp, R.drawable.mindspiral);
    Unique SpeakersWreath = new Unique("Speaker's Wreath", 7, temp, R.drawable.speakerswreath);
    Unique TheBrineCrown = new Unique("The Brine Crown", 7, temp, R.drawable.thebrinecrown);
    Unique TheBrokenCrown = new Unique("The Broken Crown", 7, temp, R.drawable.thebrokencrown);
    Unique VeiloftheNight = new Unique("Veil of the Night", 7, temp, R.drawable.veilofthenight);
    Unique VollsVision = new Unique("Voll's Vision", 7, temp, R.drawable.vollsvision);

    Unique CrownofthePaleKing = new Unique("Crown of the Pale King", 7, temp, R.drawable.crownofthepaleking);
    Unique CurtainCall = new Unique("Curtain Call", 7, temp, R.drawable.curtaincall);
    Unique FarrulsBite = new Unique("Farrul's Bite", 7, temp, R.drawable.farrulsbite);
    Unique GorgonsGaze = new Unique("Gorgon's Gaze", 7, temp, R.drawable.gorgonsgaze);
    Unique HereticsVeil = new Unique("Heretic's Veil", 7, temp, R.drawable.hereticsveil);
    Unique LeerCast = new Unique("Leer Cast", 7, temp, R.drawable.leercast);
    Unique MalachaisAwakening = new Unique("Malachai's Awakening", 7, temp, R.drawable.malachaisawakening);
    Unique MalachaisSimula = new Unique("Malachai's Simula", 7, temp, R.drawable.malachaissimula);
    Unique MindoftheCouncil = new Unique("Mind of the Council", 7, temp, R.drawable.mindofthecouncil);
    Unique TheGull = new Unique("The Gull", 7, temp, R.drawable.thegull);
    Unique TheTempestsBinding = new Unique("The Tempest's Binding", 7, temp, R.drawable.thetempestsbinding);
    Unique TheThreeDragons = new Unique("The Three Dragons", 7, temp, R.drawable.thethreedragons);
    Unique TheVertex = new Unique("The Vertex", 7, temp, R.drawable.thevertex);

    Unique DemigodsTriumph = new Unique("Demigod's Triumph", 7, temp, R.drawable.demigodstriumph);

    //Shields - code 8
    Unique AhnsHeritage = new Unique("Ahn's Heritage", 8, temp, R.drawable.ahnsheritage);
    Unique ChernobogsPillar = new Unique("Chernobog's Pillar", 8, temp, R.drawable.chernobogspillar);
    Unique LioneyesRemorse = new Unique("Lioneye's Remorse", 8, temp, R.drawable.lioneyesremorse);
    Unique Lycosidae = new Unique("Lycosidae", 8, temp, R.drawable.lycosidae);
    Unique MagnaEclipsis = new Unique("Magna Eclipsis", 8, temp, R.drawable.magnaeclipsis);
    Unique RedbladeBanner = new Unique("Redblade Banner", 8, temp, R.drawable.redbladebanner);
    Unique TheAnticipation = new Unique("The Anticipation", 8, temp, R.drawable.theanticipation);
    Unique TheSurrender = new Unique("The Surrender", 8, temp, R.drawable.thesurrenderer);
    Unique TituciusSpan = new Unique("Titucius' Span", 8, temp, R.drawable.tituciusspan);
    Unique TrolltimberSpire = new Unique("Trolltimber Spire", 8, temp, R.drawable.trolltimberspire);
    Unique TukohamasFortress = new Unique("Tukohama's Fortress", 8, temp, R.drawable.tukohamasfortress);

    Unique AtzirisMirror = new Unique("Atziri's Mirror", 8, temp, R.drawable.atzirismirror);
    Unique AtzirisReflection = new Unique("Atziri's Reflection", 8, temp, R.drawable.atzirisreflection);
    Unique ChaliceofHorrors = new Unique("Chalice of Horrors", 8, temp, R.drawable.chaliceofhorrors);
    Unique CrestofPerandus = new Unique("Crest of Perandus", 8, temp, R.drawable.crestoftheperandus);
    Unique GreatOldOnesWard = new Unique("Great Old One's Ward", 8, temp, R.drawable.greatoldonesward);
    Unique Kaltenhalt = new Unique("Kaltenhalt", 8, temp, R.drawable.kaltenhalt);
    Unique Kaltensoul = new Unique("Kaltensoul", 8, temp, R.drawable.kaltensoul);
    Unique MutewindPennant = new Unique("Mutewind Pennant", 8, temp, R.drawable.mutewindpennant);
    Unique ThirstforHorrors = new Unique("Thirst for Horrors", 8, temp, R.drawable.thirstforhorrors);
    Unique ThousandTeethTemu = new Unique("Thousand Teeth Temu", 8, temp, R.drawable.thousandteethtemu);

    Unique ApepsSlumber = new Unique("Apep's Slumber", 8, temp, R.drawable.apepsslumber);
    Unique ApepsSupremacy = new Unique("Apep's Supremacy", 8, temp, R.drawable.apepssupremacy);
    Unique BrinerotFlag = new Unique("Brinerot Flag", 8, temp, R.drawable.brinerotflag);
    Unique EshsMirror = new Unique("Esh's Mirror", 8, temp, R.drawable.eshsmirror);
    Unique EshsVisage = new Unique("Esh's Visage", 8, temp, R.drawable.eshsvisage);
    Unique KongmingsStratagem = new Unique("Kongming's Stratagem", 8, temp, R.drawable.kongmingsstratgem);
    Unique LightofLunaris = new Unique("Light of Lunaris", 8, temp, R.drawable.lightoflunaris);
    Unique MalachaisLoop = new Unique("Malachai's Loop", 8, temp, R.drawable.malachaisloop);
    Unique MatuaTupuna = new Unique("Matua Tupuna", 8, temp, R.drawable.matuatupuna);
    Unique RathpithGlobe = new Unique("Rathpith Globe", 8, temp, R.drawable.rathpithglobe);
    Unique SentarisAnswer = new Unique("Sentari's Answer", 8, temp, R.drawable.sentarisanswer);
    Unique TheEternalApple = new Unique("The Eternal Apple", 8, temp, R.drawable.theeternalapple);

    Unique DaressosCourage = new Unique("Daresso's Courage", 8, temp, R.drawable.daressoscourage);
    Unique TheDeepOnesHide = new Unique("The Deep One's Hide", 8, temp, R.drawable.thedeeponeshide);
    Unique VixLunaris = new Unique("Vix Lunaris", 8, temp, R.drawable.vixlunaris);
    Unique WheeloftheStormsail = new Unique("Wheel of the Stormsail", 8, temp, R.drawable.wheelofthestormsail);

    Unique AegisAurora = new Unique("Aegis Aurora", 8, temp, R.drawable.aegisaurora);
    Unique BrokenFaith = new Unique("Broken Faith", 8, temp, R.drawable.brokenfaith);
    Unique InvictusSolaris = new Unique("Invictus Solaris", 8, temp, R.drawable.invictussolaris);
    Unique PrismGuardian = new Unique("Prism Guardian", 8, temp, R.drawable.prismgaurdian);
    Unique RiseofthePhoenix = new Unique("Rise of the Phoenix", 8, temp, R.drawable.riseofthephoenix);
    Unique SaffellsFrame = new Unique("Saffell's Frame", 8, temp, R.drawable.saffellsframe);
    Unique Springleaf = new Unique("Springleaf", 8, temp, R.drawable.springleaf);
    Unique TheOak = new Unique("The Oak", 8, temp, R.drawable.theoak);
    Unique TheUnshatteredWill = new Unique("The Unshattered Will", 8, temp, R.drawable.theunshatteredwill);
    Unique UnyieldingFlame = new Unique("Unyielding Flame", 8, temp, R.drawable.unyieldingflame);
    Unique VictariosCharity = new Unique("Victario's Charity", 8, temp, R.drawable.victarioscharity);

    Unique Glitterdisc = new Unique("Glitterdisc", 8, temp, R.drawable.glitterdisk);
    Unique JawsofAgony = new Unique("Jaws of Agony", 8, temp, R.drawable.jawsofagony);
    Unique LepersAlms = new Unique("Leper's Alms", 8, temp, R.drawable.lepersalms);
    Unique MaligarosLens = new Unique("Maligaro's Lens", 8, temp, R.drawable.maligaroslens);
    Unique ZeelsAmplifier = new Unique("Zeel's Amplifier", 8, temp, R.drawable.zeelsamplifier);


























































































































































































































































































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
    allUniques.add(Blackheart);
    allUniques.add(Bloodboil);
    allUniques.add(BrinerotMark);
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















    tempList = new ArrayList<>();
    tempList = (ArrayList<Unique>) allUniques.clone();
    String[] names = new String[allUniques.size()];
    for(int i = 0; i< allUniques.size(); i++){
        names[i] = allUniques.get(i).getName();
    }
    search_adapter = new ArrayAdapter<String>(this,android.R.layout.select_dialog_item, names);
    search_bar.setThreshold(3);
    search_bar.setAdapter(search_adapter);


}
}

