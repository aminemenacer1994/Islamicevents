package com.example.amine.islamicevents;

import android.app.Activity;
import android.app.LauncherActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.graphics.drawable.VectorDrawableCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appinvite.AppInviteInvitation;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;
import java.util.List;


/**
 * Provides UI for the main screen.
 */
public class Main2Activity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    Spinner spinner;



    private String[] mPlanetTitles;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;

    DrawerLayout drawer;

  //  private Button buttonLogout;
    Button mOrder;
    TextView mItemSelected;
    String[] listItems;
    boolean[] checkedItems;
    ArrayList<Integer> mUserItems = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);



        // Adding Toolbar to Main screen
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();



        // Create Navigation drawer and inlfate layout
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        // Adding menu icon to Toolbar


        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            VectorDrawableCompat indicator
                    = VectorDrawableCompat.create(getResources(), R.drawable.ic_dehaze_black_24dp, getTheme());

        }




        // Set behavior of Navigation drawer
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    // This method will trigger on item Click of navigation menu
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        // Set item in checked state
                        menuItem.setChecked(true);

                        // TODO: handle navigation

                        // Closing drawer on item click
                        mDrawerLayout.closeDrawers();
                        return true;
                    }
                });




        // Adding menu icon to Toolbar
        final int[] ICONS = new int[]{
                R.drawable.ic_home_black_24dp,
                R.drawable.ic_account_circle_black_24dp,
                R.drawable.ic_star_black_24dp,
        };



        // Setting ViewPager for each Tabs
        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        // Set Tabs inside Toolbar
        TabLayout tabs = (TabLayout) findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);


        //Get reference to your Tablayout
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(ICONS[0]);
        tabLayout.getTabAt(1).setIcon(ICONS[1]);
        tabLayout.getTabAt(2).setIcon(ICONS[2]);

    }
    


    // Add Fragments to Tabs
    private void setupViewPager(ViewPager viewPager) {
        Adapter adapter = new Adapter(getSupportFragmentManager());
        adapter.addFragment(new TileContentFragment(), "Home");
        adapter.addFragment(new ProfilePageMainActivity(), "Profile");
        adapter.addFragment(new CardContentFragment(), "Favorites");

        viewPager.setAdapter(adapter);
    }


    @Override
    public boolean onNavigationItemSelected(MenuItem item) {


        return true;

    }


    static class Adapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public Adapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    public void alertDialogCountries(){

        listItems = getResources().getStringArray(R.array.List_of_countries);
        checkedItems = new boolean[listItems.length];

        AlertDialog.Builder mBuilder = new AlertDialog.Builder(Main2Activity.this);
        mBuilder.setIcon(R.mipmap.iicon);
        mBuilder.setTitle("Choose a country...").setSingleChoiceItems(listItems, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {

                switch (arg1) {

                    case 0:
                        selection = (String) listItems[arg1];
                        alertDialogCityEn();

                        break;

                    case 1:
                        selection = (String) listItems[arg1];
                        alertDialogCityCa();
                        break;

                    case 2:
                        selection = (String) listItems[arg1];
                        alertDialogCityUs();
                        break;

                }
            }
        });


        mBuilder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });


        AlertDialog mdialog = mBuilder.create();
        mdialog.show();
    }


    public void alertDialogCityCa() {

        listItems = getResources().getStringArray(R.array.List_of_cities_ca);
        checkedItems = new boolean[listItems.length];

        AlertDialog.Builder builder = new AlertDialog.Builder(Main2Activity.this);
        builder.setIcon(R.mipmap.iicon);
        builder.setTitle("Choose a City...").setSingleChoiceItems(listItems, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {

                switch (arg1) {

                    case 0:
                        selection = (String) listItems[arg1];
                        break;

                    case 1:
                        selection = (String) listItems[arg1];
                        break;

                    case 2:
                        selection = (String) listItems[arg1];
                        break;

                }
            }
        });

        builder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {

                Toast.makeText(getApplicationContext(), "City has been chosen!",
                        Toast.LENGTH_LONG).show();



            }
        });

        builder.setNegativeButton("Back", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                alertDialogCountries();
            }
        });

        builder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });


        AlertDialog mdialog = builder.create();
        mdialog.show();
    }


    public void alertDialogCityEn() {

        listItems = getResources().getStringArray(R.array.en_cities);
        checkedItems = new boolean[listItems.length];

        AlertDialog.Builder builder = new AlertDialog.Builder(Main2Activity.this);
        builder.setIcon(R.mipmap.iicon);
        builder.setTitle("Choose a City...").setSingleChoiceItems(listItems, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {

                switch (arg1) {

                    case 0:
                        selection = (String) listItems[arg1];
                        break;

                    case 1:
                        selection = (String) listItems[arg1];
                        break;

                    case 2:
                        selection = (String) listItems[arg1];
                        break;

                    case 3:
                        selection = (String) listItems[arg1];
                        break;

                    case 4:
                        selection = (String) listItems[arg1];
                        break;

                }
            }
        });

        builder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {

                Toast.makeText(getApplicationContext(), "City has been chosen!",
                        Toast.LENGTH_LONG).show();


            }
        });

        builder.setNegativeButton("Back", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                alertDialogCountries();
            }
        });

        builder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });


        AlertDialog mdialog = builder.create();
        mdialog.show();
    }


    public void alertDialogCityUs() {

        listItems = getResources().getStringArray(R.array.List_of_cities_us);
        checkedItems = new boolean[listItems.length];

        AlertDialog.Builder builder = new AlertDialog.Builder(Main2Activity.this);
        builder.setIcon(R.mipmap.iicon);
        builder.setTitle("Choose a City...").setSingleChoiceItems(listItems, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {

                switch (arg1) {

                    case 0:
                        selection = (String) listItems[arg1];
                        break;

                    case 1:
                        selection = (String) listItems[arg1];
                        break;

                    case 2:
                        selection = (String) listItems[arg1];
                        break;

                }
            }
        });

        builder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {

                Toast.makeText(getApplicationContext(), "City has been chosen!",
                        Toast.LENGTH_LONG).show();



            }
        });

        builder.setNegativeButton("Back", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                alertDialogCountries();
            }
        });

        builder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });


        AlertDialog mdialog = builder.create();
        mdialog.show();
    }






    String selection;
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {

            case R.id.search:


            case R.id.rate:

                Toast.makeText(getApplicationContext(), "Goes to play store !",
                        Toast.LENGTH_LONG).show();

                return true;


            case R.id.home:


                Intent intent = new Intent(Main2Activity.this, Main2Activity.class);
                Main2Activity.this.startActivity(intent);

            case R.id.feed:

                intent = new Intent(Main2Activity.this, FeedbackActivity.class);
                Main2Activity.this.startActivity(intent);


                return true;



            case R.id.filter:

                alertDialogCountries();

                return true;

            case R.id.share:


                return true;


            default:
                return super.onOptionsItemSelected(item);

        }

    }


}
