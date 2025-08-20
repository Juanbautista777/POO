public class TallerVariablesCasoB {

    public static void main (String[] args){

double d1 = 35.0;

double d2 = 72.0;

double d3 = 53.0;

double t1= 0.7;

double t2= 1.6;

double t3= 1.1;

double l1= 4.4;

double l2= 9.0;

double l3= 6.2;

double preciolitro = 1.42;

double masaCargaKg = 1450;

double largo = 2.2;

double ancho = 1.3;

double alto= 1.0;

double p1 = 3.2;

double p2 = 3.8;

double p3 = 2.7;

double deprecporKm = 0.085;

double volCamionm3 = 12.0;

double fco2= 2.64;

double galporlitro = 0.264172;

double vmin = 30;

double vmax = 90;

double va = 40;

double vb = 80;

double ca = 0.05;

double cb = 0.09;

double a = -0.0009;

double b = 0.09;

double c = 3.8;

System.out.println("\"********* CASO A: *********");


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

System.out.println("********* 7) Promedios y dispersión:  ********* ");

double VMEDIA = (V1 + V2 + V3) / 3 ;

double O = Math.sqrt((Math.pow(V1 - VMEDIA, 2) + Math.pow(V2 - VMEDIA, 2) + Math.pow(V3 - VMEDIA, 2)) / 3);

double VPOUNDT = (t1 * V1 + t2 * V2 + t3 * V3)/(t1 + t2 + t3);

System.out.println("VMEDIA:) " + VMEDIA);

System.out.println("O:) " + O);

System.out.println("VPOUNDT:) " + VPOUNDT);

System.out.println("********* 8)  Interpolación lineal (mantenimiento):  ********* ");

double CVPROM = ca + (cb - ca) * (VPROM - va) / (vb - va) ; 

double CostoMant = CVPROM * ( d1 + d2 + d3);

System.out.println("CVPROM:) " + CVPROM);

System.out.println("COSTO MANT:) " + CostoMant);

System.out.println("********* 9)   Modelo polinómico de rendimiento:  ********* ");

double kmlv = a * Math.pow(v, 2) ;// de donde rayos sale v ? 

double kmlModelo = kml(VPROM) ; //TAMPOCO SE DE DONDE SALE? 

double LitrosModelo = (d1+ d2+ d3) / kmlModelo ; 

System.out.println("KMLV:) " + kmlv);

System.out.println("KMLMODELO:) " + kmlModelo);

System.out.println("LITROSMODELO:) " + LitrosModelo);

System.out.println("********* 10)    Índice de eficiencia (score):  ********* ");

double w1 + w2 + w3 + w4 = 1 ;

double score = w1 * 1 / CostoxKm + w2 * kmltotal + w3 * 1 / co2xKm + w4 * 1 / (1 +  O);








}

}