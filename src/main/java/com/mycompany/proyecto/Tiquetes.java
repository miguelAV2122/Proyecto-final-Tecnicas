   
package com.mycompany.proyecto;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class Tiquetes {
    CineXD cineXD = new CineXD();
    Clientes2 espacios[][] = new Clientes2[12][15];
    
    public Tiquetes() {
        for (int F = 0; F < 12; F++) {
            for (int A = 0; A < 15; A++) {
                espacios[F][A] = new Clientes2();  
            } 
        }
    }
    
    public void Compra(){
      
    /*int input = JOptionPane.showConfirmDialog(null, "Ingrese");
    if(input == 1){
        CineXD.Inicio();
    }else if(input == 2){
        CineXD.Inicio();
    }else{
    
    }*/ 
    String nombre,correo;
    int formato;
    int pelicula;
    int fila = 0;
    int asiento = 0;
    int edad = 18;
    int telefono = 0;
    int cedula = 0;
    int CTiquetes = 0;
    boolean bandera = false;
                
    nombre = JOptionPane.showInputDialog("Ingrese su nombre");
    
    do{
       try{
       edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese su edad")); 
       bandera = false;
       }catch(NumberFormatException e){
        JOptionPane.showMessageDialog(null,"Por favor ingresar una edad valida","ERROR",JOptionPane.ERROR_MESSAGE);
        bandera = true;
       } 
    }while(bandera);
    
    if (edad < 18){
      JOptionPane.showMessageDialog(null, nombre + " no puede comprar tiquetes ya que es menor de edad son " +
              (18-edad) + " año(s) que le falta para poder comprar tiquetes");
    }else{
          
          do{
            String patron = ("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,}$)");
            correo = JOptionPane.showInputDialog("Ingrese su correo"); 
            Pattern validar = Pattern.compile(patron);
            Matcher matcher = validar.matcher(correo);
            if(matcher.find()){
                bandera = false;
            }else{
                JOptionPane.showMessageDialog(null,"POr favor ingresar un correo valido","ERROR",JOptionPane.ERROR_MESSAGE);
                bandera = true;
            }
            
          }while(bandera);
          
          do{
            try{
               telefono = Integer.parseInt(JOptionPane.showInputDialog("Ingrese su teléfono")); 
               bandera = false;
            }catch(NumberFormatException e){
               JOptionPane.showMessageDialog(null,"Por favor ingresar un teléfono válido","ERROR",JOptionPane.ERROR_MESSAGE);
               bandera = true;
            }  
          }while(bandera);
          
          do{
            try{
               cedula = Integer.parseInt(JOptionPane.showInputDialog("Ingrese su cédula"));
               bandera = false;
            }catch(NumberFormatException e){
               JOptionPane.showMessageDialog(null,"Por favor ingresar un número de cédula valido","ERROR",JOptionPane.ERROR_MESSAGE);
               bandera = true;
            }  
          }while(bandera);
          
          String []peliculas = {"Monster Inc","Venom","Spider-Man\n","X-Men","DeadPool","Los Increibles"};
          pelicula= JOptionPane.showOptionDialog(null, "Selecciona una película","Cartelera",0,JOptionPane.QUESTION_MESSAGE,
                  null,peliculas,"Monster Inc");
          /*pelicula = JOptionPane.showInputDialog(null, "Seleccione una pelicula","Peliculas",
          JOptionPane.PLAIN_MESSAGE,null,new Object[] {"Seleccione","Monster Inc","Venom","Spider-Man","X-Men","DeadPool","Los Increibles"},
                  "Seleccione").toString(); */
          do{
            try{
               CTiquetes = Integer.parseInt(JOptionPane.showInputDialog("¿Cuantos tiquetes desea comprar?"));
               bandera = false;
            }catch(NumberFormatException e){
               JOptionPane.showMessageDialog(null,"Por favor ingresar una cantidad valida","ERROR",JOptionPane.ERROR_MESSAGE);
               bandera = true;
            }  
          }while(bandera);

          for(int i = 0 ; i < CTiquetes ; i++){
              do{
                try{
                    boolean valor = true;
                    while(valor){
                       fila = Integer.parseInt(JOptionPane.showInputDialog("Seleccione la fila en donde desea sentarse(1....12)"));
                       if(fila < 1 || fila > 12){
                       JOptionPane.showMessageDialog(null,"Por favor ingrese un número entre 1 y 12","ERROR",JOptionPane.ERROR_MESSAGE); 
                       }else{
                        valor = false;   
                        bandera = false;  
                       }                            
                    } 
                }catch(NumberFormatException e){
                   JOptionPane.showMessageDialog(null,"La fila seleccionada no existe","ERROR",JOptionPane.ERROR_MESSAGE);
                   bandera = true;
                }  
              }while(bandera);
              
              do{
                try{
                   boolean valor = true;
                   while(valor){
                       asiento = Integer.parseInt(JOptionPane.showInputDialog("Seleccione el asiento donde desea sentarse(1....15)"));
                       if(asiento < 1 || asiento > 15){
                       JOptionPane.showMessageDialog(null,"Por favor ingrese un número entre 1 y 15","ERROR",JOptionPane.ERROR_MESSAGE); 
                       }else{
                           valor = false;   
                           bandera = false;  
                       }
                    }   
                   
                }catch(NumberFormatException e){
                   JOptionPane.showMessageDialog(null,"El asiento seleccionado no existe","ERROR",JOptionPane.ERROR_MESSAGE);
                   bandera = true;
                }  
              }while(bandera);

              if (espacios[asiento-1][fila-1].condicion == Condicion.disponible) {
                  espacios[asiento-1][fila-1].nombre = nombre;
                  espacios[asiento-1][fila-1].correo = correo;
                  espacios[asiento-1][fila-1].telefono = telefono;
                  espacios[asiento-1][fila-1].cedula = cedula;
                  espacios[asiento-1][fila-1].edad = edad;
                  espacios[asiento-1][fila-1].pagoT = 2500;         
                  espacios[asiento-1][fila-1].condicion = Condicion.ocupado;

                  JOptionPane.showMessageDialog(null, "El espacio ha sido vendido, debe pagar 2500");            
              } else {
                  JOptionPane.showMessageDialog(null, "El espacio ya se encuentra ocupado");
                  i--;
              }  
          }

          String [] formatos = {"2D","3D","4D"};
          formato= JOptionPane.showOptionDialog(null, "Selecciona el formato","Formato",0,JOptionPane.QUESTION_MESSAGE,
                  null,formatos,"2D");
          /*Formato = JOptionPane.showInputDialog(null, "Seleccione un Formato","Formato",
          JOptionPane.PLAIN_MESSAGE,null,new Object[] {"Seleccione","2D","3D","4D"},
                  "Seleccione").toString();*/
              double totalt =(2500*CTiquetes) ;
              double iva =((2500*CTiquetes)*0.13) ;
              double totaliva =totalt + iva ;

          JOptionPane.showMessageDialog(null, "Total a pagar por " + CTiquetes + " tiquetes = " 
                  + totaliva + " colones" + "\n(Iva Incluido)" );

          int input2 = JOptionPane.showConfirmDialog(null, "¿Desea confirmar la compra?");
          switch (input2) {
            case 1:
                CineXD.Inicio();
                break;
            case 2:
                CineXD.Inicio();
                break; 
            default:
                JOptionPane.showMessageDialog(null, "*****Recibo de Compra*****\n"
                    + "\nEstimado(a) " + nombre
                    + "\nCédula: " + cedula
                    + "\nCorreo: " + correo
                    +"\n----------------------------------------------"
                    + "\n#Tiquete(s): " +CTiquetes 
                    + "\nPelícula: " + peliculas[pelicula] + " en formato " +formatos[formato]
                    +"\n----------------------------------------------"
                    + "\nSub Total: " + totalt + " colones"
                    + "\nTotal iva: " + iva + " colones"
                    +"\nTotal a pagar: " + totaliva + " colones"
                    +"\n\n*****Que disfrute la película*****");
                break;
        } 
    }
    }            
}
