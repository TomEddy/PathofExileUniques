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
                tempList = allUniques;
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

                for(int i = 0; i< allUniques.size(); i++){
                    if(allUniques.get(i).getCatagory() != 0 ){
                        allUniques.remove(i);
                        i--;
                    }
                }
                display.setImageResource(allUniques.get(0).getImage_Resource());
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
    tempList = allUniques;
    String[] names = new String[allUniques.size()];
    for(int i = 0; i< allUniques.size(); i++){
        names[i] = allUniques.get(i).getName();
    }
    search_adapter = new ArrayAdapter<String>(this,android.R.layout.select_dialog_item, names);
    search_bar.setThreshold(3);
    search_bar.setAdapter(search_adapter);


}
}

