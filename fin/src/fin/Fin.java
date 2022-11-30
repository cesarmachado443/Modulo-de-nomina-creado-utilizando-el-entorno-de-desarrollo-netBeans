package fin;

import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;

/**
 *
 * @author CESW
 */
public class Fin { 
    
       public static void main(String[] args) throws IOException{
    
        Scanner entrada = new Scanner(System.in);
        //DEFINIMOS LAS VARIABLES A UTULIZAR
        int N,T_TRABAJADOR;
        double V_INICIAL=0;
    
           
        System.out.println("NUMERO DE EMPLEADOS :");// EN ESTE VECTOR SE GUARDA EL NUMERO DE EMPLEADOS 
        N = Integer.parseInt(entrada.nextLine());
                    
        String nombres [] = new String[N]; 
        String tipo [] = new String[N]; 
        String profesion[] = new String[N];
        int H_trabajadas_mes[] = new int[N];
        int salario_bruto [] = new int[N];
        int Horas_extras[]= new int [N];
        int total_Horas_mes[]= new int[N];
        int total_hora_extra [] =new int[N];
       
        /// DESCUENTO POR LEY  /////////////////////////////
            
        double salud[] = new double[N];
        double pencion [] = new double[N];
        double ARL []= new double[N];
        double Total_descuento []= new double[N];
        double total_a_pagar[] = new double[N];
        
       DecimalFormat convercion = new DecimalFormat("###.##"); //USAMOS ESTE METODO PARA ELIMINAR LA PARTE DECIMAL  DE LOS DATOS NUMERICOS. 
   
        for (int i = 0; i < N; i++) {
        System.out.println("");
        System.out.println("**************************EMPLEADO:"+(i+1)+("*******************************"));
        System.out.println("*********************************************************************");
        System.out.println("***********************TIPO DE EMPLEADO******************************");// TIPO DE EMPLEADOS
        System.out.println("*********************************************************************");
        System.out.println("1.ADMINISTRATIVO");// EMPLEADO ADMINISTRATIVO
        System.out.println("2.OPERATIVO ");// EMPLEADO OPERATIVO
        T_TRABAJADOR = Integer.parseInt(entrada.nextLine());
        /////////////REALIZAMOS LA COMPARACION PARA QUE EL PROGRAMA IDENTIFIQUE LOS CARGOS //////////////

        if (
                T_TRABAJADOR == 1 ) {
           
        tipo[i] = "ADMINISTRATIVO";// TIPO DE EMPLEADO
        profesion[i]= "AUXILIAR ADMI";// TIPO DE EMPLEADO
            
        System.out.println("***ADMINISTRATIVO********");  
        System.out.println("NOMBRE:  " );// INGRESE SU NOMBRE
         nombres[i]= entrada.nextLine().toLowerCase();//EN ESTA VARIABLE SE GUARDA EL NOMBRE DEL EMPLEADO
                  
        System.out.println("NUMERO DE HORAS TRABJADAS (MES):");// INGRESE LA CANTIDAD DE HORAS TRABAJADAS AL MES
         H_trabajadas_mes[i] = Integer.parseInt(entrada.nextLine());
        
        System.out.println("HORAS EXTRAS: ");// INGRESE HORAS EXTRAS
         Horas_extras[i] = Integer.parseInt(entrada.nextLine());
        
         
         total_Horas_mes[i]= H_trabajadas_mes[i] * 20000;// EL TOTAL DE HORAS TRABAJADAS ES, H.TRABAJDAS MES * 20000
         total_hora_extra[i]= Horas_extras [i] * 25000;// EL TOTAL DE HORAS EXTRAS ES, HORAS EXTRAS * 25000
           
        //CALCULAMOS EL SALARIO BRUTO
        
        salario_bruto [i] = (total_Horas_mes[i] + total_hora_extra[i]);// EL SALARIO BRUTO ES, TOTAL HORAS MES + TOTAL HORAS EXTRA
       
        //////////////// REALIZAMOS LAS OPERACIONES DE DESCUENTO SEGUN LOS APORTES ///////////////////////
        // Realizamos el calculo segun el porcentaje
        salud[i] = salario_bruto[i] * 0.04;  // EL DESCUENTO DE LA SALUD ES, SALARIO_BRUTO * 0.04
        pencion [i] =salario_bruto[i] * 0.04; // EL DESCUENTO DE LA PENSION ES, SALARIO_BRUTO * 0.04
        ARL[i] = salario_bruto[i] * 0.0522;// EL DESCUENTO DE LA ARL ES, SALARIO_BRUTO * 0.0522
        Total_descuento[i] = (salud[i] + pencion[i] + ARL[i]);// EL TOTAL DEL DESCUENTO ES, SALUD + PENSION + ARL
        total_a_pagar[i] = (salario_bruto[i] - Total_descuento[i]);//EL TOTAL A PAGAR ES, SALARIO_BRUTO - TOTAL DE DESCUENTO
            
        /////////////// TERMINAMOS LAS OPERACIONES DE DECUENTO SEGUN LOS APORTES /////////////////////////
                   
        System.out.println("*********************************************************************");
        System.out.println("*********************** VOLANTE DE PAGO *****************************");// ESTO ES EL VOLANTE A IMPRIMIR
        System.out.println("*********************************************************************");
        System.out.println("");
        System.out.println("NOMBRE : " +nombres[i]);// AQUI SE IMPRIME EL NOMBRE DEL EMPLEADO
        System.out.println("CARGO : " +tipo[i]);// AQUI SE IMPRIME EL CARGO DEL EMPLEADO
        System.out.println("TIPO  : " +profesion[i]);//AQUI SE IMPRIME EL EL TIPO DE EMPLEADO
        System.out.println("HORAS TRABAJADAS  (MES): " +H_trabajadas_mes[i]);// AQUI SE IMPRIME  LAS HORAS EXTRAS TRABAJADAS  
        System.out.println("SALARIO BRUTO : " +total_Horas_mes[i] );  // AQUI SE IMPRIME EL SALARIO BRUTO
        System.out.println("HORAS EXTRAS : " +Horas_extras[i]);// AQUI SE IMPRIME  LAS HORAS EXTRA
        System.out.println("TOTAL PAGO HORA EXTRA : " +total_hora_extra[i]);// AQUI SE IMPRIME EL TOTAL A PAGAR
        System.out.println("");
        System.out.println("*********************************************************************");
        System.out.println("*********************** DESCUENTOS DE LEY ***************************");// ESTO ES EL DESCUENTO TOTAL
        System.out.println("*********************************************************************");
        System.out.println("");
        System.out.println("SALUD 4% : " +  convercion.format(salud[i]));// AQUI SE IMPRIME EL PORSENTAJE DE LA SALUD
        System.out.println("PENSION 4% : "+ convercion.format(pencion[i]));// AQUI SE IMPRIME EL PORSENTAJE DE LA PENSION
        System.out.println("ARL 5% :"     + convercion.format(ARL[i]));// AQUI SE IMPRIME EL PORSENTAJE DE LA ARL
        System.out.println("TOTAL DESCUENTO : "+convercion.format (Total_descuento[i]));// AQUI SE IMPRIME EL TOTAL DEL DESCUENTO
        System.out.println("TOTAL A PAGAR: "+ convercion.format( total_a_pagar[i]));//AQUI SE IMPRIME EL TOTAL A PAGAR
        System.out.println("");
        System.out.println("*********************************************************************");
        System.out.println("******************** FIN DEL VOLANTE DE PAGO ************************");
        System.out.println("*********************************************************************");
    }
    else if (T_TRABAJADOR == 2) 
    {
      tipo[i]="OPERATIVO";// TIPO DE ELPLEADO
      System.out.println("********** OPERATIVOS *********"); // ESTO ES EL TIPO DE EMPLEADO
      System.out.println("PUESTO DEL  TRABAJADOR:");// ESTO ES EL MENU DE OFICIOS
      System.out.println("");
      
      System.out.println("1 CONDUCTOR ");// TIPO DE OFICIO
      System.out.println("2 OFICIOS VARIOS");// TIPO DE OFICIO
      System.out.println("3 VIGILANCIA");// TIPO DE OFICIO
      int operacion = Integer.parseInt(entrada.nextLine());
            
      System.out.println("");
      System.out.println("NOMBRE:  " );// NOMBRE DEL EMPLEADO
      nombres[i] = entrada.nextLine();// EN ESTA VARIABLE SE GUARDA EL NOMBRE DEL EMPLEADO
        
      switch (operacion) {
      case 1:         
       profesion[i] = "CONDUCTOR";// TIPO DE OFICIO         
       H_trabajadas_mes[i] = 160;// ESTA SON LAS HORAS TRABAJADAS  AL MES
       System.out.println("HORAS EXTRAS : NO ");// ESTA SON LAS HORAS EXTRAS 
       Horas_extras[i] = 0;
       //CALCULAMOS EL SALARIO BRUTO
       total_Horas_mes[i] = (H_trabajadas_mes[i]*40000);// EL SALARIO BRUTO ES, HORAS TRABAJADAS AL MES * 40000
       //calculamos la el salario por la base 40%
       salario_bruto[i] =(total_Horas_mes[i]);// EL SALARIO BRUTO ES TODAS LAS HORAS TRABAJDAS AL MES
       V_INICIAL = salario_bruto[i]*0.40; // base del 40%// EL VALOR INICIAL ES SALARIO_BRUTO * 0.40
            
       // REALIZAMOS LAS OPERACIONES DE DESCUENTO SEGUN LOS APORTES ///////////////////////
    
       salud[i] = V_INICIAL * 0.125;//PARA HALLAR LA SALUD ES VALOR INICIAL * 0.125       
       pencion[i] = V_INICIAL * 0.16;//PARA HALLAR LA PENSION ES VALOR INICIAL * 0.16
       ARL[i]= V_INICIAL * 0.0144;// PARA HALLAR LA ARLES, V_INICIAL * 0.0144
       Total_descuento[i]= salud[i] + pencion[i] +ARL[i];// EL TOTAL DEL DESCUENTO ES, SALUD + PENSION
       total_a_pagar[i] = salario_bruto[i] - Total_descuento[i];//EL TOTAL A PAGAR ES, SALARIO BRUTO - TOTAL DEL DESCUENTO 
            
       System.out.println("***********************");
       System.out.println("*** VOLANTE DE PAGO ***");// ESTO ES EL VOLANTE A IMPRIMIR
       System.out.println("***********************");
       System.out.println("NOMBRE : " +nombres[i]);// AQUI SE IMPRIME EL NOMBRE DEL EMPLEADO 
       System.out.println("CARGO : " +tipo[i]);//AQUI SE IMPRIME EL CARGO DEL EMPLEADO
       System.out.println("TIPO  : " +profesion[i]);//AQUI SE IMPRIME EL TIPO DE EMPLEADO
       System.out.println("HORAS TRABAJADAS (MES): " +H_trabajadas_mes[i]);//AQUI SE IMPRIME EL TOTAL DE HORAS TRABJADAS
       System.out.println("SALARIO BRUTO : " +total_Horas_mes[i]);//AQUI SE IMPRIME EL SALARIO TOTAL
       System.out.println("SALARIO POR BASE DE 40% : " +convercion.format( V_INICIAL));//AQUI SE IMPRIME EL SALARIO POR BASE
       System.out.println("HORAS EXTRAS : " + Horas_extras[i]);//AQUI SE IMPRIME LAS HORAS EXTRAS TRABAJDAS
       System.out.println("TOTAL PAGO HORA EXTRA : " + Horas_extras[i]);//AQUI SE IMPRIME EL TOTAL A PAGAR DE LAS HORAS TRABAJADAS
       System.out.println("");
       System.out.println("*****************************");
       System.out.println("**** DESCUENTOS DE LEY ****");//AQUI SE IMPRIME EL DESCUENTO DE LEY
       System.out.println("****************************");
       System.out.println("");
       System.out.println("SALUD 12.5% : " +convercion.format( salud[i]));//AQUI SE IMPRIME EL DESCUENTO DE LA SALUD
       System.out.println("PENSION 16%:"+convercion.format( pencion[i]));//AQUI SE IMPRIME EL DESCUENTO DE PENSION
       System.out.println("ARL 10% :"     +convercion.format( ARL[i]));//AQUI SE IMPRIME EL DESCUENTO DE LA ARL
       System.out.println("TOTAL DESCUENTO : "+convercion.format( Total_descuento[i]));//AQUI SE IMPRIME EL TOTAL DEL DESCUENTO
       System.out.println("TOTAL A PAGAR : "+convercion.format( total_a_pagar[i]));//AQUI SE IMPRIME EL TOTAL A PAGAR
       System.out.println("");
       System.out.println("*****************************");
       System.out.println("** FIN DEL VOLANTE DE PAGO **");
       System.out.println("*****************************");
    break;
    case 2:            
      profesion[i] = "OFICIOS VARIOS";// TIPO DE OFICIO
      System.out.println("2.OFICIOS VARIOS");// TIPO DE OFICIO
      H_trabajadas_mes[i] = 100;// TOTAL DE HORAS TRABAJADAS
      System.out.println("HORAS EXTRAS : NO ");//ESTAS SON LAS HORAS EXTRAS, EN ESTE CASO  NO TUVO HORAS EXTRAS
      Horas_extras[i] = 0;                 
      //CALCULAMOS EL SALARIO BRUTO
      total_Horas_mes[i] =(H_trabajadas_mes[i]*40000);//TOTAL DE LAS HORAS TRABAJADAS AL MES
      //calculamos la el salario por la base 40%
      salario_bruto[i] =(total_Horas_mes[i]);// EL SALARIO BRUTO ES EL TOTAL DE HORAS TRABAJDAS
      V_INICIAL = salario_bruto[i]*0.40;  // BASE DEL  40%
      
      //// REALIZAMOS LAS OPERACIONES DE DESCUENTO SEGUN LOS APORTES ///////////////////////
      
       salud[i] = V_INICIAL * 0.125;//DESCUENTO DE LA SALUD       
       pencion[i] = V_INICIAL * 0.16;// DESCUENTO DE PENSION
       ARL[i]= V_INICIAL * 0.00522;// DESCUENTO DE LA ARL
       Total_descuento[i]=(salud[i] + pencion[i] + ARL[i]);// EL TOTAL DEL DESCUENTO ES, SALUD + PENSION + ARL
       total_a_pagar[i] =  (salario_bruto[i] - Total_descuento[i]);//EL TOTAL A PAGAR ES, SALARIO BRUTO - EL TOTAL DE DESCUENTOS
                         
       System.out.println("***********************");
       System.out.println("*** VOLANTE DE PAGO ***");// ESTE ES EL VOLANTE DE PAGO A IMPRIMIR
       System.out.println("***********************");
       System.out.println("NOMBRE : " +nombres[i]);//AQUI SE IMPRIME EL NOMBRE DEL EMPLEADO
       System.out.println("CARGO : " +tipo[i]);//AQUI SE IMPRIME EL CARGO DEL EMPLEADO
       System.out.println("TIPO  : " +profesion[i]);//AQUI SE IMPRIME EL TIPO DEL EMPLEADO
       System.out.println("HORAS TRABAJADAS (MES): " +H_trabajadas_mes[i]);//AQUI SE IMPRIME LAS HORAS TOTALES GTRABAJADAS
       System.out.println("SALARIO BRUTO : " +total_Horas_mes[i]);//AQUI SE IMPRIME EL  SALARIO TOTAL
       System.out.println("SALARIO POR BASE DE 40% : " +convercion.format(V_INICIAL));//AQUI SE IMPRIME ELSALARIO BASE
       System.out.println("HORAS EXTRAS : " + Horas_extras[i]);//AQUI SE IMPRIME LAS HORAS EXTRAS TRABAJADAS
       System.out.println("TOTAL PAGO HORA EXTRA : " + Horas_extras[i]);//AQUI SE IMPRIME EL TOTAL A PAGAR DE LAS HORAS EXTRAS
       System.out.println("");
       System.out.println("*************************");
       System.out.println("*** DESCUENTOS DE LEY ***");//AQUI SE IMPRIME EL DESCUENTO POR LEY
       System.out.println("*************************");
       System.out.println("");
       System.out.println("SALUD 12% : " + convercion.format( salud[i]));//AQUI SE IMPRIME EL DESCUENTO DE SALUD
       System.out.println("PENSION 16%:"+convercion.format( pencion[i]));//AQUI SE IMPRIME EL DESCUENTO DE PENSION
       System.out.println("ARL 5% :"     +convercion.format(ARL[i]));//AQUI SE IMPRIME EL DESCUENTO DE LA ARL
       System.out.println("TOTAL DESCUENTO : "+convercion.format(Total_descuento[i]));//AQUI SE IMPRIME EL TOTAL DEL DESCUENTO
       System.out.println("TOTAL A PAGAR: "+convercion.format(total_a_pagar[i]));//AQUI SE IMPRIME  EL TOTAL A PAGAR
       System.out.println("");
       System.out.println("*****************************");
       System.out.println("** FIN DEL VOLANTE DE PAGO **");
       System.out.println("*****************************");
     break; 
     case 3:               
       profesion[i] ="VIGILANTE";// CARGO DEL EMPLEADO
       System.out.println("3.VIGILANTE");// CARGO DEL EMPLEADO                  
       H_trabajadas_mes[i] = 336;// HORAS TOTALES TRABJADAS
       System.out.println("HORAS EXTRAS : NO ");// NO TUVO HORAS EXTRAS
       Horas_extras[i] = 0;
           
       total_Horas_mes[i] = (H_trabajadas_mes[i]*40000); // TOTAL DE LAS HORAS TRABAJADAS AL MES
       salario_bruto[i] = (total_Horas_mes[i]);   //CALCULAMOS EL SALARIO POR LA BASE 40%
       V_INICIAL = salario_bruto[i] * 0.40;  // BASE DEL 40%               
       /// REALIZAMOS LAS OPERACIONES DE DESCUENTO SEGUN LOS APORTES ///////////////////////
       
        salud[i] = V_INICIAL * 0.125;// LA SALUD ES, VALOR INICIAL * 0.125       
       pencion[i] = V_INICIAL * 0.16;// PENSION ES, VALOR INICIAL * 0.16
        ARL[i]= V_INICIAL * 0.04350;// LA ARL ES, VALOR INICIAL * 0.04350
        Total_descuento[i]=(salud[i] + pencion[i] + ARL[i]);   // EL TOTAL DEL DESCUENTO ES,SALUD + PENSION  + ARL
        total_a_pagar[i] =(salario_bruto[i] - Total_descuento[i]);// EL TOTAL A PAGAR  ES, SALARIO BRUTO - TOTAL DE DESCUENTO
                         
        System.out.println("***********************");
        System.out.println("*** VOLANTE DE PAGO ***");// ESTE ES EL VOLANTE A IMPRIMIR DEL TRABAJADOR
        System.out.println("***********************");
        System.out.println("NOMBRE : " +nombres[i]);//AQUI SE IMPRIME EL NOMBRE DEL EMPLEADO
        System.out.println("CARGO : " +tipo[i]);//AQUI SE IMPRIME EL CARGO DEL EMPLEADO
        System.out.println("TIPO  : " +profesion[i]);//AQUI SE IMPRIME EL TIPO DE EMPLEADO
        System.out.println("HORAS TRABAJADAS (MES): " +H_trabajadas_mes[i]);//AQUI SE IMPRIME EL TOTAL DE HORAS TRABJADAS
        System.out.println("SALARIO BRUTO : " +total_Horas_mes[i]);//AQUI SE IMPRIME EL SALARIO TOTAL AL MES
        System.out.println("SALARIO POR BASE DE 40% : "+ convercion.format(V_INICIAL));//AQUI SE IMPRIME EL SALARIO BASE
        System.out.println("HORAS EXTRAS : " + Horas_extras[i]);//AQUI SE IMPRIME LAS HORAS EXTRAS LABORADAS
        System.out.println("TOTAL PAGO HORA EXTRA : " + Horas_extras[i]);//AQUI SE IMPRIME EL TOTAL A PAGAR DE HORAS EXTRAS
        System.out.println("");
        System.out.println("*************************");
        System.out.println("*** DESCUENTOS DE LEY ***");
        System.out.println("*************************");
        System.out.println("");
        System.out.println("SALUD 12% : " + convercion.format(salud[i]));//AQUI SE IMPRIME EL DESCUENTO SALUD
        System.out.println("PENSION 15%:"+ convercion.format(pencion[i]));//AQUI SE IMPRIME EL DESCUENTO DE LA PENSION
        System.out.println("ARL 5% :"     + convercion.format(ARL[i]));//AQUI SE IMPRIME EL DESCUENTO DE LA ARL
        System.out.println("TOTAL DESCUENTO : "+ convercion.format(Total_descuento[i]));//AQUI SE IMPRIME EL TOTAL DEL DESCUENTO
        System.out.println("TOTAL A PAGAR: "+ convercion.format(total_a_pagar[i]));//AQUI SE IMPRIME EL TOTAL A PAGAR
        System.out.println("");
        System.out.println("*****************************");
        System.out.println("** FIN DEL VOLANTE DE PAGO **");
        System.out.println("*****************************");
    break;
        default: 
        System.err.println("************");
        System.err.println("ERROR_ERROR_ERROR_ERROR_ERROR_ERROR_ERROR_ERROR_ERROR_ERROR_ERROR_ERROR_ERROR_ERROR_ERROR_ERROR_");
        System.err.println("****************************");
        System.err.println("***** OPCION INVALIDA*******");
        System.err.println("****************************");
      }
    }
    else
    {
        System.err.println("************");
        System.err.println("ERROR_ERROR_ERROR_ERROR_ERROR_ERROR_ERROR_ERROR_ERROR_ERROR_ERROR_ERROR_ERROR_ERROR_ERROR_ERROR_");
        System.err.println("****OPCION INVALIDA*******");
        System.err.println("************");
    }
 }
        //imprimimos  los Vectores por pantalla 
        System.out.println("Nombre           Tipo     Cargo          HT     Salario     HE      TPHE      Salud      Pension      ARL        Total a Pagar"); 
    for (int i = 0; i < N; i++) {               
         System.out.println(nombres[i]+ "\t"+tipo[i] +"\t"+profesion[i]+"\t  "+H_trabajadas_mes[i]+"\t"+total_Horas_mes[i]+"\t  "+Horas_extras[i]+"\t"+total_hora_extra[i]+"\t"+convercion.format(salud[i])+"\t"+ convercion.format(pencion[i])+"\t  "+convercion.format(ARL[i])+"\t    "+convercion.format(total_a_pagar[i]));             
    }
        // imprimo documento txt.
        FileWriter Fichero = new FileWriter("C://fichero.txt");//POR FAVOR AL UTILIZAR CAMBIAR RUTA PARA QUE FUNCIONE
         Fichero.write("Nombre           Tipo           Cargo             HT    Salario   HE    TPHE    Salud   Pension   ARL       Total a Pagar \n"); 
    for (int i = 0; i < N; i++) { 
        Fichero.write(nombres[i]+ "\t"+tipo[i] +"\t"+profesion[i]+"\t  "+H_trabajadas_mes[i]+"\t"+total_Horas_mes[i]+"\t  "+Horas_extras[i]+"\t"+total_hora_extra[i]+"\t"+convercion.format(salud[i])+"\t"+ convercion.format(pencion[i])+"\t  "+convercion.format(ARL[i])+"\t    "+convercion.format(total_a_pagar[i])+ "\n");             
   }
        Fichero.close();
    }
       
}
