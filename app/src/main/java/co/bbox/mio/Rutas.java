package co.bbox.mio;

import android.content.ContentProvider;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import java.io.InputStream;
import java.net.ContentHandler;
import java.util.ArrayList;

/**
 * Created by hmbe on 10/05/2015.
 */
public class Rutas {

    private ArrayList<ParadasMio> T31;
    private ArrayList<ParadasMio> T47;

    public Rutas(){
        T31 = new ArrayList<ParadasMio>();
        initT31();
        T47 = new ArrayList<ParadasMio>();
        initT47();
    }

    private void initT47() {
        T47.add(new ParadasMio("CAPRI",3.38795695349308,  -76.5449883163955));
        T47.add(new ParadasMio("CALDAS",3.39401659279584,  -76.5459972419974));
        T47.add(new ParadasMio("REFUGIO",3.39861277628475,  -76.54650977859809));
        T47.add(new ParadasMio("PAMPALINDA",3.40377726014038,  -76.5468542348675));
        T47.add(new ParadasMio("PLAZA DE TOROS",3.40958233506524,  -76.5474894108108));
        T47.add(new ParadasMio("UNIDAD DEPORTIVA",3.41492829303904,  -76.54837045263621));
        T47.add(new ParadasMio("LIDO",3.41871945631514,  -76.548374742654));
        T47.add(new ParadasMio("TEQUENDAMA",3.4233818555796,  -76.5470481478424));
        T47.add(new ParadasMio("ESTADIO",3.431802795938561,  -76.5431741642292));
        T47.add(new ParadasMio("MANZANA DEL SABER",3.43489067250909,  -76.54099583876049));
        T47.add(new ParadasMio("SANTA LIBRADA",3.43975464363334,  -76.537058966723));
        T47.add(new ParadasMio("SAN BOSCO",3.44222168983151,  -76.5325616246673));
        T47.add(new ParadasMio("SAN PASCUAL",3.44260549824147,  -76.527396508869));
        T47.add(new ParadasMio("BELALCAZAR",3.44409815874867,  -76.5207278165045));
        T47.add(new ParadasMio("FLORESTA",3.44521141377815,  -76.5146061101468));
        T47.add(new ParadasMio("ATANACIO GIRARDOT",3.44476595957726,  -76.50830906902679));
        T47.add(new ParadasMio("CHAPINERO",3.44423939404206,  -76.5022544886063));
        T47.add(new ParadasMio("VILLA COLOMBIA",3.443804374789599,  -76.49887564301871));
        T47.add(new ParadasMio("TREBOL",3.44348135196042,  -76.49603170797231));
        T47.add(new ParadasMio("7 DE AGOSTO",3.44523464188041,  -76.4870411406343));
        T47.add(new ParadasMio("Terminal Andrés Sanín", 3.443676,  -76.482895));
        T47.add(new ParadasMio("Terminal Andrés Sanín", 3.443676,  -76.482895));
        T47.add(new ParadasMio("7 DE AGOSTO",3.44523464188041,  -76.4870411406343));
        T47.add(new ParadasMio("TREBOL",3.44348135196042,  -76.49603170797231));
        T47.add(new ParadasMio("VILLA COLOMBIA",3.443804374789599,  -76.49887564301871));
        T47.add(new ParadasMio("CHAPINERO",3.44423939404206,  -76.5022544886063));
        T47.add(new ParadasMio("ATANACIO GIRARDOT",3.44476595957726,  -76.50830906902679));
        T47.add(new ParadasMio("FLORESTA",3.44521141377815,  -76.5146061101468));
        T47.add(new ParadasMio("BELALCAZAR",3.44409815874867,  -76.5207278165045));
        T47.add(new ParadasMio("SAN PASCUAL",3.44260549824147,  -76.527396508869));
        T47.add(new ParadasMio("SAN BOSCO",3.44222168983151,  -76.5325616246673));
        T47.add(new ParadasMio("SANTA LIBRADA",3.43975464363334,  -76.537058966723));
        T47.add(new ParadasMio("MANZANA DEL SABER",3.43489067250909,  -76.54099583876049));
        T47.add(new ParadasMio("ESTADIO",3.431802795938561,  -76.5431741642292));
        T47.add(new ParadasMio("TEQUENDAMA",3.4233818555796,  -76.5470481478424));
        T47.add(new ParadasMio("LIDO",3.41871945631514,  -76.548374742654));
        T47.add(new ParadasMio("UNIDAD DEPORTIVA",3.41492829303904,  -76.54837045263621));
        T47.add(new ParadasMio("PLAZA DE TOROS",3.40958233506524,  -76.5474894108108));
        T47.add(new ParadasMio("PAMPALINDA",3.40377726014038,  -76.5468542348675));
        T47.add(new ParadasMio("REFUGIO",3.39861277628475,  -76.54650977859809));
        T47.add(new ParadasMio("CALDAS",3.39401659279584,  -76.5459972419974));
    }

    private void initT31() {
        T31.add(new ParadasMio("UNIVALLE", 3.37077428856125, -76.5367578041884));
        T31.add(new ParadasMio("BUITRERA", 3.37262876258088, -76.54024624286779));
        T31.add(new ParadasMio("MELENDEZ", 3.37709434798511, -76.5428460692729));
        T31.add(new ParadasMio("CAPRI", 3.38795695349308, -76.5449883163955));
        T31.add(new ParadasMio("CALDAS", 3.39401659279584, -76.5459972419974));
        T31.add(new ParadasMio("REFUGIO", 3.39861277628475, -76.54650977859809));
        T31.add(new ParadasMio("PAMPALINDA", 3.40377726014038, -76.5468542348675));
        T31.add(new ParadasMio("PLAZA DE TOROS", 3.40958233506524, -76.5474894108108));
        T31.add(new ParadasMio("UNIDAD DEPORTIVA", 3.41492829303904, -76.54837045263621));
        T31.add(new ParadasMio("LIDO", 3.41871945631514, -76.548374742654));
        T31.add(new ParadasMio("TEQUENDAMA", 3.4233818555796, -76.5470481478424));
        T31.add(new ParadasMio("ESTADIO", 3.431802795938561, -76.5431741642292));
        T31.add(new ParadasMio("MANZANA DEL SABER", 3.43489067250909, -76.54099583876049));
        T31.add(new ParadasMio("SANTA LIBRADA", 3.43975464363334, -76.537058966723));
        T31.add(new ParadasMio("SAN BOSCO", 3.44222168983151, -76.5325616246673));

        T31.add(new ParadasMio("SAN PASCUAL", 3.44260549824147, -76.527396508869));
        T31.add(new ParadasMio("SUCRE", 3.443472550432289, -76.526306577727));
        T31.add(new ParadasMio("PETECUY", 3.44898657047256, -76.52796712272369));
        T31.add(new ParadasMio("SAN PEDRO", 3.45434310944934, -76.5301501351538));
        T31.add(new ParadasMio("TORRE DE CALI", 3.45678873806534, -76.5302392220113));
        T31.add(new ParadasMio("SAN NICOLAS", 3.45852867823295, -76.52568980078109));
        T31.add(new ParadasMio("PILOTO", 3.46004404297968, -76.5225321455697));
        T31.add(new ParadasMio("FATIMA", 3.46285094798705, -76.51740387904771));
        T31.add(new ParadasMio("MANZANARES", 3.46618818350395, -76.5133312020867));
        T31.add(new ParadasMio("POPULAR", 3.46950131877958, -76.51081381344569));
        T31.add(new ParadasMio("SALOMIA", 3.47372798499137, -76.5067104642302));
        T31.add(new ParadasMio("FLORA INDUSTRIAL", 3.47823457936227, -76.5022346527039));
        T31.add(new ParadasMio("CHIMINANGOS", 3.48143405288254, -76.4982579940595));

        T31.add(new ParadasMio("FLORA INDUSTRIAL", 3.47823457936227, -76.5022346527039));
        T31.add(new ParadasMio("SALOMIA", 3.47372798499137, -76.5067104642302));
        T31.add(new ParadasMio("POPULAR", 3.46950131877958, -76.51081381344569));
        T31.add(new ParadasMio("MANZANARES", 3.46618818350395, -76.5133312020867));
        T31.add(new ParadasMio("FATIMA", 3.46285094798705, -76.51740387904771));

        T31.add(new ParadasMio("RIO CALI", 3.46042576578899, -76.5252142047196));

        T31.add(new ParadasMio("TORRE DE CALI", 3.45678873806534, -76.5302392220113));

        T31.add(new ParadasMio("ERMITA", 3.45333507350132, -76.53162400177921));
        T31.add(new ParadasMio("CENTRO", 3.44836264398911, -76.5301188719535));
        T31.add(new ParadasMio("FRAY DAMIAN", 3.4435703997969, -76.52885848603231));

        T31.add(new ParadasMio("SAN BOSCO", 3.44222168983151, -76.5325616246673));
        T31.add(new ParadasMio("SANTA LIBRADA", 3.43975464363334, -76.537058966723));
        T31.add(new ParadasMio("MANZANA DEL SABER", 3.43489067250909, -76.54099583876049));
        T31.add(new ParadasMio("ESTADIO", 3.431802795938561, -76.5431741642292));
        T31.add(new ParadasMio("TEQUENDAMA", 3.4233818555796, -76.5470481478424));
        T31.add(new ParadasMio("LIDO", 3.41871945631514, -76.548374742654));
        T31.add(new ParadasMio("UNIDAD DEPORTIVA", 3.41492829303904, -76.54837045263621));
        T31.add(new ParadasMio("PLAZA DE TOROS", 3.40958233506524, -76.5474894108108));
        T31.add(new ParadasMio("PAMPALINDA", 3.40377726014038, -76.5468542348675));
        T31.add(new ParadasMio("REFUGIO", 3.39861277628475, -76.54650977859809));
        T31.add(new ParadasMio("CALDAS", 3.39401659279584, -76.5459972419974));
        T31.add(new ParadasMio("CAPRI", 3.38795695349308, -76.5449883163955));
        T31.add(new ParadasMio("MELENDEZ", 3.37709434798511, -76.5428460692729));
        T31.add(new ParadasMio("BUITRERA", 3.37262876258088, -76.54024624286779));
        //T31.add(new ParadasMio("UNIVALLE", 3.37077428856125, -76.5367578041884));
    }

    public ArrayList<ParadasMio> getT31() {
        return T31;
    }

    public PolygonOptions rutaT31 (){
        PolygonOptions poly = new PolygonOptions();
        for (int i = 0; i < T31.size(); i++) {
            poly.add(T31.get(i).getPosition());
        }
        return poly;
    }

    public ArrayList<ParadasMio> getT47() {
        return T47;
    }

    public PolygonOptions rutaT47 (){
        PolygonOptions poly = new PolygonOptions();
        for (int i = 0; i < T47.size(); i++) {
            poly.add(T47.get(i).getPosition());
        }
        return poly;
    }

}
