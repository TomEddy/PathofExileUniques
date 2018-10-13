package pathofexileuniques.eddytom.com.pathofexileuniques;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button all,cat,search,myUniq,amulets,belts;
    private ImageView display;
    private int counter;
    private ArrayList<Unique> allUniques;


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
                amulets.setVisibility(View.GONE);
                belts.setVisibility(View.GONE);
                counter = 0;
                setUp();
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
        amulets = findViewById(R.id.amulet_but);
        belts = findViewById(R.id.belt_but);
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
            }
        });

        amulets.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                amulets.setVisibility(View.GONE);
                belts.setVisibility(View.GONE);

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

                for(int i = 0; i< allUniques.size(); i++){
                    if(allUniques.get(i).getCatagory() != 1 ){
                        allUniques.remove(i);
                        i--;
                    }
                }
                display.setImageResource(allUniques.get(0).getImage_Resource());
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
                    display.setImageResource(allUniques.get(counter).getImage_Resource());
                }else {
                    Toast.makeText(MainActivity.this, "Beginning of List", Toast.LENGTH_SHORT).show();
                }
            }
            public void onSwipeLeft() {
                if(counter < allUniques.size()) {
                    counter++;
                    display.setImageResource(allUniques.get(counter).getImage_Resource());
                }else{
                    Toast.makeText(MainActivity.this, "End of List", Toast.LENGTH_SHORT).show();
                }
                }
            public void onSwipeBottom() {
                Toast.makeText(MainActivity.this, "bottom", Toast.LENGTH_SHORT).show();
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
    Unique Aruku = new Unique("Aruku Tiki",0,temp,R.drawable.arakutiki);
    temp.clear();
    temp.add("All Attributes");
    Unique Astra = new Unique("Astramentis",0,temp,R.drawable.astramentis);
    Unique AtziriFoi = new Unique("Atziri's Foible",0,temp,R.drawable.atzirifoible);
    Unique AulUprising = new Unique("Aul's Uprising",0,temp,R.drawable.aulsuprising);
    Unique AulUprising2 = new Unique("Aul's Uprising",0,temp,R.drawable.aulsuprisingtwo);
    Unique AulUprising3 = new Unique("Aul's Uprising",0,temp,R.drawable.aulsuprisingthree);
    Unique AulUprising4 = new Unique("Aul's Uprising",0,temp,R.drawable.aulsuprisingfour);
    Unique BiscosCollar = new Unique("Bisco's Collar",0,temp,R.drawable.biscocollar);
    Unique BlightwellClutch = new Unique("Blightwell Clutching Talisman",0,temp,R.drawable.blightwell);
    Unique BloodCorruption = new Unique("Blood of Corruption",0,temp,R.drawable.bloodofcor);
    Unique Bloodgrip = new Unique("Bloodgrip",0,temp,R.drawable.bloodgrip);
    Unique Carnage = new Unique("Carnage Heart",0,temp,R.drawable.carnage);
    Unique Choir = new Unique("Choir of the Storm",0,temp,R.drawable.choir);
    Unique DarSal = new Unique("Daresso's Salute",0,temp,R.drawable.daressosolu);
    Unique Extractor = new Unique("Extractor Mentis",0,temp,R.drawable.extractor);
    Unique EyeChay = new Unique("Eye of Chayula",0,temp,R.drawable.eyechay);
    Unique EyeInnoc = new Unique("Eye of Innocence",0,temp,R.drawable.eyeinoc);
    Unique EyeGreat = new Unique("Eyes of the Greatwolf",0,temp,R.drawable.eyegreatwolf);
    Unique Gloom = new Unique("Gloomfang",0,temp,R.drawable.gloomfang);
    Unique Hinekora = new Unique("Hinekora's Sight",0,temp,R.drawable.hinekora);
    Unique Impress1 = new Unique("Impresence (Chaos)",0,temp,R.drawable.impressone);
    Unique Impress2 = new Unique("Impresence (Lightning)",0,temp,R.drawable.impresstwo);
    Unique Impress3 = new Unique("Impresence (Physical)",0,temp,R.drawable.impressthree);
    Unique Impress4 = new Unique("Impresence (Cold)",0,temp,R.drawable.impressfour);
    Unique Impress5 = new Unique("Impresence (Fire)",0,temp,R.drawable.impressfive);
    Unique KaruiCharge = new Unique("Karui Charge",0,temp,R.drawable.karuich);
    Unique KaruiWard = new Unique("Karui Ward",0,temp,R.drawable.karuiward);
    Unique MaligarosCruelty = new Unique("Maligaro's Cruelty",0,temp,R.drawable.malicru);
    Unique MarylenesFallacy = new Unique("Marylene's Fallacy",0,temp,R.drawable.maryl);
    Unique NaturalHierarchy = new Unique("Natural Hierarchy",0,temp,R.drawable.naturalh);
    Unique NgamahuTiki = new Unique("Ngamahu Tiki",0,temp,R.drawable.ngamahu);
    Unique NightsHold = new Unique("Night's Hold",0,temp,R.drawable.nightshold);
    Unique PerquilsToe = new Unique("Perquil's Toe",0,temp,R.drawable.perqtoe);
    Unique PresenceofChayula = new Unique("Presence of Chayula",0,temp,R.drawable.preschay);
    Unique RashkaldorsPatience = new Unique("Rashkaldor's Patience",0,temp,R.drawable.rashkal);
    Unique RigwaldsCurse = new Unique("Rigwald's Curse",0,temp,R.drawable.riwaldscurse);
    Unique SacrificialHeart = new Unique("Sacrificial Heart",0,temp,R.drawable.sacheart);
    Unique ShapersSeed = new Unique("Shaper's Seed",0,temp,R.drawable.shapeseed);
    Unique Sidhebreath = new Unique("Sidhebreath",0,temp,R.drawable.sidebreath);
    Unique StarofWraeclast = new Unique("Star of Wraeclast",0,temp,R.drawable.starofw);
    Unique StoneofLazhwar = new Unique("Stone of Lazhwar",0,temp,R.drawable.stoneofl);
    Unique TearofPurity = new Unique("Tear of Purity",0,temp,R.drawable.tearofpur);
    Unique TheAnvil = new Unique("The Anvil",0,temp,R.drawable.anvil);
    Unique TheAscetic = new Unique("The Ascetic",0,temp,R.drawable.theascetic);
    Unique TheAylardex = new Unique("The Aylardex",0,temp,R.drawable.theaylar);
    Unique TheEffigon = new Unique("The Effigon",0,temp,R.drawable.theeffig);
    Unique TheHalcyon = new Unique("The Halcyon",0,temp,R.drawable.thehal);
    Unique TheIgnomon = new Unique("The Ignomon",0,temp,R.drawable.theign);
    Unique ThePandemonius = new Unique("The Pandemonius",0,temp,R.drawable.theperand);
    Unique ThePrimordialChain = new Unique("The Primordial Chain",0,temp,R.drawable.theprimo);
    Unique UngilsHarmony = new Unique("Ungil's Harmony",0,temp,R.drawable.ungilsharm);
    Unique VictariosAcuity = new Unique("Victario's Acuity",0,temp,R.drawable.victaracu);
    Unique VollsDevotion = new Unique("Voll's Devotion",0,temp,R.drawable.vollsdevo);
    Unique WarpedTimepiece = new Unique("Warped Timepiece",0,temp,R.drawable.warpedtime);
    Unique Winterheart = new Unique("Winterheart",0,temp,R.drawable.winterheart);
    Unique XophsBlood = new Unique("Xoph's Blood",0,temp,R.drawable.xophblood);
    Unique XophsHeart = new Unique("Xoph's Heart",0,temp,R.drawable.xophheart);
    Unique YokeofSuffering = new Unique("Yoke of Suffering",0,temp,R.drawable.yokesuff);
    Unique ZerphisHeart = new Unique("Zerphi's Heart",0,temp,R.drawable.zephriheart);

    //Belts - code 1
    Unique AscentFromFlesh = new Unique("Ascent From Flesh",1,temp,R.drawable.acentfrom);
    Unique Auxium = new Unique("Auxium",1,temp,R.drawable.auxium);
    Unique BatedBreath = new Unique("Bated Breath",1,temp,R.drawable.batedbreath);
    Unique BeltoftheDeceiver = new Unique("Belt of the Deceiver",1,temp,R.drawable.beltdeci);
    Unique BiscosLeash = new Unique("Bisco's Leash",1,temp,R.drawable.biscoleesh);
    Unique CowardsChains = new Unique("Coward's Chains",1,temp,R.drawable.cowardchain);
    Unique CowardsLegacy = new Unique("Coward's Legacy",1,temp,R.drawable.cowardsleg);
    Unique CyclopeanCoil = new Unique("Cyclopean Coil",1,temp,R.drawable.cyclopeancoil);
    Unique DarknessEnthroned = new Unique("Darkness Enthroned",1,temp,R.drawable.darcknessen);
    Unique DoryanisInvitation1 = new Unique("Doryani's Invitation (Cold Damage)",1,temp,R.drawable.doryinvone);
    Unique DoryanisInvitation2 = new Unique("Doryani's Invitation (Fire Damage)",1,temp,R.drawable.doryinvtwo);
    Unique DoryanisInvitation3 = new Unique("Doryani's Invitation (Physical Damage)",1,temp,R.drawable.doryinvthree);
    Unique DoryanisInvitation4 = new Unique("Doryani's Invitation (Lightning Damage)",1,temp,R.drawable.doryinvfour);
    Unique DyadianDawn = new Unique("Dyadian Dawn",1,temp,R.drawable.dyadiandawn);
    Unique Faminebind = new Unique("Faminebind",1,temp,R.drawable.faminbind);
    Unique Feastbind = new Unique("Feastbind",1,temp,R.drawable.feastbind);
    Unique Gluttony = new Unique("Gluttony",1,temp,R.drawable.gluttony);
    Unique Headhunter = new Unique("Headhunter",1,temp,R.drawable.headhunter);
    Unique ImmortalFlesh = new Unique("Immortal Flesh",1,temp,R.drawable.immortalflesh);
    Unique MaligarosRestraint = new Unique("Maligaro's Restraint",1,temp,R.drawable.malirest);
    Unique MeginordsGirdle = new Unique("Meginord's Girdle",1,temp,R.drawable.meginords);
    Unique PerandusBlazon = new Unique("Perandus Blazon",1,temp,R.drawable.perandusblaz);
    Unique Perseverance = new Unique("Perseverance",1,temp,R.drawable.perserverance);
    Unique Prismweave = new Unique("Prismweave",1,temp,R.drawable.prismweave);
    Unique RyslathasCoil = new Unique("Ryslatha's Coil",1,temp,R.drawable.ryslath);
    Unique SoulTether = new Unique("Soul Tether",1,temp,R.drawable.soultether);
    Unique Soulthirst = new Unique("Soulthirst",1,temp,R.drawable.soulthirst);
    Unique StringofServitude = new Unique("String of Servitude",1,temp,R.drawable.stringofserv);
    Unique Sunblast = new Unique("Sunblast",1,temp,R.drawable.sunblast);
    Unique TheFlowUntethered = new Unique("The Flow Untethered",1,temp,R.drawable.theflow);
    Unique TheMagnate = new Unique("The Magnate",1,temp,R.drawable.themagnate);
    Unique TheNomad = new Unique("The Nomad",1,temp,R.drawable.thenomad);
    Unique TheRetch = new Unique("The Retch",1,temp,R.drawable.theretch);
    Unique TheTactician = new Unique("The Tactician",1,temp,R.drawable.thetactician);
    Unique UmbilicusImmortalis = new Unique("Umbilicus Immortalis",1,temp,R.drawable.umbilicious);
    Unique WurmsMolt = new Unique("Wurm's Molt",1,temp,R.drawable.wurmsmolt);

//Rings - code 2
    Unique AhkelisMeadow = new Unique("Ahkeli's Meadow",2,temp,R.drawable.ahkelimeadow);
    Unique AhkelisMountain = new Unique("Ahkeli's Mountain",2,temp,R.drawable.ahkelimountain);
    Unique AhkelisValley = new Unique("Ahkeli's Valley",2,temp,R.drawable.ahkelivalley);
    Unique Andvarius = new Unique("Andvarius",2,temp,R.drawable.andv);
    Unique AnglersPlait = new Unique("Angler's Plait",2,temp,R.drawable.anglerspl);
    //Bereks Pass
    //Bereks Respite
    Unique Blackheart = new Unique("Blackheart",2,temp,R.drawable.blackheart);
    Unique Bloodboil = new Unique("Bloodboil",2,temp,R.drawable.bloodboil);
    Unique BrinerotMark = new Unique("Brinerot Mark",2,temp,R.drawable.brinenotmark);
//Call of the Brotherhood
    Unique DeathRush = new Unique("Death Rush",2,temp,R.drawable.deathrush);
    Unique DoedresDamning = new Unique("Doedre's Damning",2,temp,R.drawable.doesdresdamning);
    Unique DreamFragments = new Unique("Dream Fragments",2,temp,R.drawable.dreamfragments);
    Unique Emberwake = new Unique("Emberwake",2,temp,R.drawable.emberwake);
    Unique EssenceWorm = new Unique("Essence Worm",2,temp,R.drawable.essenceworm);
    Unique GiftsfromAbove = new Unique("Gifts from Above",2,temp,R.drawable.giftssfromabove);
    Unique HeartboundLoop = new Unique("Heartbound Loop",2,temp,R.drawable.heartboundloop);
    Unique KaomsSign = new Unique("Kaom's Sign",2,temp,R.drawable.kaomssign);
    Unique KaomsWay = new Unique("Kaom's Way",2,temp,R.drawable.kaomsway);
    Unique Kikazaru = new Unique("Kikazaru",2,temp,R.drawable.kikazaru);
    Unique LeHeupofAll = new Unique("Le Heup of All",2,temp,R.drawable.leheup);
    Unique LorisLantern = new Unique("Lori's Lantern",2,temp,R.drawable.lorislantern);
    Unique MalachaisArtifice = new Unique("Malachai's Artifice",2,temp,R.drawable.malachaisartifice);
    Unique MarkofSubmission = new Unique("Mark of Submission",2,temp,R.drawable.markofsubmission);
    Unique MarkoftheElder = new Unique("Mark of the Elder",2,temp,R.drawable.markoftheelder);
    Unique MarkoftheShaper = new Unique("Mark of the Shaper",2,temp,R.drawable.markoftheshaper);
    Unique MingsHeart = new Unique("Ming's Heart",2,temp,R.drawable.mingsheart);
    Unique MokousEmbrace = new Unique("Mokou's Embrace",2,temp,R.drawable.mokousembrace);
    Unique MutewindSeal = new Unique("Mutewind Seal",2,temp,R.drawable.mutewindseal);
    Unique NgamahusSign = new Unique("Ngamahu's Sign",2,temp,R.drawable.ngamahussign);
    Unique PerandusSignet = new Unique("Perandus Signet",2,temp,R.drawable.peransussignet);
    Unique Praxis = new Unique("Praxis",2,temp,R.drawable.praxis);
    Unique PrecursorsEmblem1 = new Unique("Precursor's Emblem (Endurance, Frenzy and Power Charge)",2,temp,R.drawable.percusersemblem);
    //Prec2 -6
    //Putembos 123
    Unique Pyre = new Unique("Pyre",2,temp,R.drawable.pyre);
    Unique RedbladeBand = new Unique("Redblade Band",2,temp,R.drawable.redbladeband);
    //Regwald
    Unique RomirasBanquet = new Unique("Romira's Banquet",2,temp,R.drawable.romirasbanquet);
    Unique ShavronnesRevelation = new Unique("Shavronne's Revelation",2,temp,R.drawable.shavronnesrevelation);
    Unique SibylsLament = new Unique("Sibyl's Lament",2,temp,R.drawable.sibylslament);
    Unique Snakepit = new Unique("Snakepit",2,temp,R.drawable.snakepit);
    Unique Stormfire = new Unique("Stormfire",2,temp,R.drawable.stormfire);
    Unique TasaliosSign = new Unique("Tasalio's Sign",2,temp,R.drawable.tasaliossign);
    Unique TheHungryLoop = new Unique("The Hungry Loop",2,temp,R.drawable.thehungryloop);
    Unique ThePariah = new Unique("The Pariah",2,temp,R.drawable.thepariah);
    //The tamin
    Unique TheWardensBrand = new Unique("The Warden's Brand",2,temp,R.drawable.thewardensband);
    Unique ThiefsTorment = new Unique("Thief's Torment",2,temp,R.drawable.thiefstorment);
    Unique Timeclasp = new Unique("Timeclasp",2,temp,R.drawable.timeclasp);
    //Uzaza's
    //Valakos
    //The rest



















































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
}
}

