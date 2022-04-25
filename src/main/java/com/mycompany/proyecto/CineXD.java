package com.mycompany.proyecto;
 
import javax.swing.JOptionPane;

public class CineXD {
   
    public static void main(String[] args) {
        Inicio();
    }  
    public static void Inicio() { //1 para Tiquetes. 2 para salir
        Tiquetes tiquetes = new Tiquetes();
        //Tiquetes compra = new Tiquetes();
        int opcion = 0;
        int salir = 2;
        
        int si = JOptionPane.showConfirmDialog(null, "CineXD es un cine para todo público!");
        switch (si) {
            case 1:
                break;
            case 2:
                break;
            default:
                do {
                        try{  
                           opcion = Integer.parseInt(JOptionPane.showInputDialog("1. Comprar Tiquetes"
                            + "\n2. Salir"));
                        }catch(NumberFormatException e){
                        }
                        switch (opcion) {
                                case 1:
                                tiquetes.Compra();
                                break;
                                case 2:
                                JOptionPane.showMessageDialog(null,"Gracias por utilizar nuestro servicio!!");
                                break;
                                default:
                                JOptionPane.showMessageDialog(null,"Debe ingresar una opción valida","ERROR",JOptionPane.ERROR_MESSAGE);
                                }
                        
                }while (opcion != salir);
                break;
        }
    
    }
}