package co.bbox.mio;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.Xml;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.widget.DrawerLayout;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.android.clustering.ClusterManager;
import com.google.maps.android.clustering.view.DefaultClusterRenderer;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;


public class MapActivity extends ActionBarActivity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks {

    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;

    /**
     * Used to store the last screen title. For use in {@link #restoreActionBar()}.
     */
    private CharSequence mTitle;

    private GoogleMap mMap;

    private static LatLng CALI = new LatLng(3.4525, -76.5358);

    private ClusterManager<ParadasMio> mClusterManager;

    private Marker bus;

    private Rutas baseRutas;

    private Random rand = new Random();

    private ArrayList<ParadasMio> currentRoute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);
        mTitle = getTitle();
        baseRutas = new Rutas();
        setUpMapIfNeeded();

        currentRoute = baseRutas.getT31();

        Marker mio = mMap.addMarker(new MarkerOptions()
                .position(currentRoute.get(15).getPosition())
                .draggable(true));
        mio.setIcon(BitmapDescriptorFactory.fromResource(R.drawable.smallblue));
        MarkerAnimation.animateMarkerToICS(mio, 16, currentRoute, new LatLngInterpolator.Linear());

        Marker mio2 = mMap.addMarker(new MarkerOptions()
                .position(currentRoute.get(48).getPosition())
                .draggable(true));
        mio2.setIcon(BitmapDescriptorFactory.fromResource(R.drawable.smallblue));
        MarkerAnimation.animateMarkerToICS(mio2,49,currentRoute, new LatLngInterpolator.Linear());

        Marker mio3 = mMap.addMarker(new MarkerOptions()
                .position(currentRoute.get(0).getPosition())
                .draggable(true));
        mio3.setIcon(BitmapDescriptorFactory.fromResource(R.drawable.smallblue));
        MarkerAnimation.animateMarkerToICS(mio3,1,currentRoute, new LatLngInterpolator.Linear());
    }

    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                  .getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                setUpMap();
            }
        }
    }

    /**
     * This is where we can add markers or lines, add listeners or move the camera. In this case, we
     * just add a marker near Africa.
     * <p/>
     * This should only be called once and when we are sure that {@link #mMap} is not null.
     */
    private void setUpMap() {
        mMap.setBuildingsEnabled(true);
        mMap.setTrafficEnabled(true);
        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(CALI)       // Sets the center of the map to Mountain View
                .zoom(13)           // Sets the zoom to the whole city
                .bearing(270)       // Sets the orientation of the camera to west
                .tilt(30)           // Sets the tilt of the camera to 30 degrees
                .build();           // Creates a CameraPosition from the builder
        mMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));

        setUpClusterer();

    }

    private void setUpClusterer() {

        mClusterManager = new ClusterManager<ParadasMio>(this, mMap);

        mMap.setOnCameraChangeListener(mClusterManager);
        mMap.setOnMarkerClickListener(mClusterManager);
        MioRender maprender = new MioRender(this.getApplicationContext(), mMap, mClusterManager);
        mClusterManager.setRenderer(maprender);

        addItems();
    }

    public void addRandomBus(){
        int randomNum = rand.nextInt(currentRoute.size()-1);
        Marker mio = mMap.addMarker(new MarkerOptions()
                .position(currentRoute.get(randomNum).getPosition())
                .draggable(true));
        mio.setIcon(BitmapDescriptorFactory.fromResource(R.drawable.smallblue));
        MarkerAnimation.animateMarkerToICS(mio, randomNum + 1, currentRoute, new LatLngInterpolator.Linear());
    }
    private void addItems() {

        for (int i = 0; i < baseRutas.getT31().size(); i++) {
            mClusterManager.addItem(baseRutas.getT31().get(i));
        }

        mMap.addPolygon(baseRutas.rutaT31());

        for (int i = 0; i < baseRutas.getT47().size(); i++) {
            mClusterManager.addItem(baseRutas.getT47().get(i));
        }
        mMap.addPolygon(baseRutas.rutaT47());
    }


    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        // update the main content by replacing fragments
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.map, PlaceholderFragment.newInstance(position + 1))
                .commit();
    }


    public void onSectionAttached(int number) {
        switch (number) {
            case 1:
                mTitle = getString(R.string.title_section1);
                //settitl
                setCurrentT31();
                break;
            case 2:
                mTitle = getString(R.string.title_section2);
                setCurrentT47();
                break;
            case 3:
                mTitle = getString(R.string.title_section3);
                break;
        }
    }

    public void restoreActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            getMenuInflater().inflate(R.menu.map, menu);
            restoreActionBar();
            return true;
        }
        return super.onCreateOptionsMenu(menu);
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

    public void setCurrentT31() {
        currentRoute = baseRutas.getT31();
    }

    public void setCurrentT47() {
        currentRoute = baseRutas.getT47();
    }


    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        private static final String ARG_SECTION_NUMBER = "section_number";

        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_map, container, false);
            return rootView;
        }

        @Override
        public void onAttach(Activity activity) {
            super.onAttach(activity);
            ((MapActivity) activity).onSectionAttached(
                    getArguments().getInt(ARG_SECTION_NUMBER));
        }
    }

}