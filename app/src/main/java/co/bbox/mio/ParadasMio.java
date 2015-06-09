package co.bbox.mio;

import com.google.android.gms.maps.model.BitmapDescriptor;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.clustering.ClusterItem;

/**
 * Created by hmbe on 20/05/2015.
 */
public class ParadasMio implements ClusterItem{
    private final LatLng mPosition;
    private String name;

    public ParadasMio(String name,double lat, double lng) {
        mPosition = new LatLng(lat, lng);
        this.name = name;
    }
    public ParadasMio(LatLng newPost) {
        mPosition = newPost;
    }

    @Override
    public LatLng getPosition() {
        return mPosition;
    }

    public BitmapDescriptor getIcon() {
        return BitmapDescriptorFactory.fromResource(R.drawable.stopsmall);
    }
}
