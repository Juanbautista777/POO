public class TallerVariables {

    public static void main (String[] args){

double d1 = 42.0;

double d2 = 58.5;

double d3 = 37.2;

double t1= 0.9;

double t2= 1.4;

double t3= 0.8;

double l1= 5.1;

double l2= 6.9;

double l3= 4.3;

double preciolitro = 1.35;

double masaCargaKg = 1200;

double largo = 2.0;

double ancho = 1.2;

double alto= 1.1;

double p1 = 2.5;

double p2 = 3.0;

double p3 = 2.0;

double deprecporKm = 0.08;

double volCamionm3 = 10.0;

double fco2= 2.68;

double galporlitro = 0.264172;

double vmin = 30;

double vmax = 90;

double va = 40;

double vb = 80;

double ca = 0.05;

double cb = 0.09;

double a = -0.0008;

double b = 0.08;

double c = 4.0;


System.out.println("\"********* 1) Datos base del viaje declarados:  *********");

System.out.println("d1:" + d1 );

System.out.println("d2:" + d2 );

System.out.println("d3:" + d3 );

System.out.println("t1:" + t1 );

System.out.println("t2:" + t2 );

System.out.println("t3:" + t3 );

System.out.println("l1:" + l1 );

System.out.println("l2:" + l2 );

System.out.println("l3:" + l3 );

System.out.println("precioxlitro:" + preciolitro );

System.out.println("masaCargaKg:" + masaCargaKg );

System.out.println("largo:" + largo );

System.out.println("ancho:" + ancho);

System.out.println("alto:" + alto );

System.out.println("p1:" + p1 );

System.out.println("p2:" + p2 );

System.out.println("p3:" + p3 );

System.out.println("deprecporKm:" + deprecporKm );

System.out.println("volcamionm3:" + volCamionm3 );

System.out.println("fco2:" + fco2 );

System.out.println("galporlitro :" + galporlitro );

System.out.println("Velocidad minima:" + vmin );

System.out.println("Velocidad maxima:" + vmax );

System.out.println("Va:" + va );

System.out.println("vb:" + vb );

System.out.println("ca:" + ca );

System.out.println("cb:" + cb );

System.out.println("a:" + a );

System.out.println("b:" + b );

System.out.println("c:" + c );

System.out.println("\"********* 2) Velocidades y rendimiento*********");

double V1 = d1 / t1 ;

double V2 = d2 / t2 ; 

double V3 = d3 / t3 ; 

double VPROM =  (d1 * V1 + d2 * V2 + d3 * V3) / (d1 + d2 + d3) ;

double kml1 = d1 / l1;

double kml2 = d2 / l2;

double kml3 = d3 / l3;

double kmltotal= (d1 + d2 + d3) /  ( l1 + l2 + l3 ) ;

System.out.println("V1:) " + V1);

System.out.println("V2:) " + V2);

System.out.println("V3:) " + V3);

System.out.println("VProm:) " + VPROM);

System.out.println("*********  B) Rendimiento por tramo y total*********");

System.out.println("kml1:) " + kml1);

System.out.println("kml2:) " + kml2);

System.out.println("kml3:) " + kml3);

System.out.println("kmltotal:) " + kmltotal); 


System.out.println("********* 3) Costos directos:  ********* ");

double CostoComb = (l1 + l2 + l3) * preciolitro ;

double deprec = (d1 + d2 + d3) * deprecporKm ;

double peajes = p1 + p2 + p3 ;

double CostoDirecto = CostoComb + deprec + peajes;

double CostoxKm = CostoDirecto / (d1 + d2 + d3);

System.out.println("CostoComb:) " + CostoComb);

System.out.println("deprec:) " + deprec);

System.out.println("peajes:) " + peajes);

System.out.println("CostoDirecto:) " + CostoDirecto); 

System.out.println("CostoPorKm:) " + CostoxKm); 

System.out.println("********* 4) VOLOUMEN DENSIDAD Y OCUPACION:  ********* ");

double VOLOUMENM3 = largo * ancho * alto ;

double DENSIDAD = masaCargaKg / VOLOUMENM3 ;

double OCUPACION = VOLOUMENM3 / volCamionm3 ; 

System.out.println("VolumenM3:) " + VOLOUMENM3);

System.out.println("Densidad) " + DENSIDAD);

System.out.println("Ocupacion) " + OCUPACION);

System.out.println("********* 5) EMISIONES DE CO2:  ********* ");

double co2total = (l1 + l2 + l3) * fco2;

double co2xKm = co2total / (d1 + d2 + d3);

System.out.println("CO2TOTAL:) " + co2total);

System.out.println("CO2XKM) " + co2xKm);

System.out.println("********* 6) Conversiones y normalización:  ********* ");

double Vmsprom = VPROM * (1000 / 3600);

double galtotal = (l1 + l2 + l3) * galporlitro;

double VNORM = (VPROM - vmin) / (vmax - vmin);


System.out.println("VMSPROM:) " + Vmsprom);

System.out.println("GALTOTAL) " + galtotal);

System.out.println("VNORM:) " + VNORM);

}

}