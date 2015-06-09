package co.bbox.mio;

import android.content.Context;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.maps.android.clustering.Cluster;
import com.google.maps.android.clustering.ClusterManager;
import com.google.maps.android.clustering.view.DefaultClusterRenderer;

/**
 * Created by hmbe on 20/05/2015.
 */
public class MioRender extends DefaultClusterRenderer<ParadasMio> {

    public MioRender(Context context, GoogleMap map,
                           ClusterManager<ParadasMio> clusterManager) {
        super(context, map, clusterManager);
    }

    @Override
    protected void onBeforeClusterItemRendered(ParadasMio item, MarkerOptions markerOptions) {
        markerOptions.icon(item.getIcon());
        //markerOptions.snippet(item.getSnippet());
        //markerOptions.title(item.getTitle());
        super.onBeforeClusterItemRendered(item, markerOptions);
    }

    @Override
    protected boolean shouldRenderAsCluster(Cluster<ParadasMio> cluster) {
        return cluster.getSize() > 10;
    }
}
