package model;

import javax.swing.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int option = Integer.parseInt(JOptionPane.showInputDialog(
                        "Bienvenido\n"+
                        "1. si desea iniciar sesion\n" +
                        "2. si desea registrarse"));

        if (option == 1) {
            Login lg = new Login();
            String usuario = JOptionPane.showInputDialog("Digite su usuario.");
            String contraseña = JOptionPane.showInputDialog("Digite su contraseña.");

            if (lg.verifyCredentials(usuario, contraseña)) {
                JOptionPane.showMessageDialog(null,"Acceso exitoso.");
            } else {
                JOptionPane.showMessageDialog(null,"Verifique los datos ingresados.");
            }

        }else if(option == 2){
            String name = JOptionPane.showInputDialog("Digite su nombre");
            String lastName = JOptionPane.showInputDialog("Digite su apellido.");
            int age = Integer.parseInt(JOptionPane.showInputDialog("Digite su edad."));
            Gender gender = Gender.valueOf(JOptionPane.showInputDialog("Digite su genero."));
            String document = JOptionPane.showInputDialog("Digite su numero de documento.");
            String user = JOptionPane.showInputDialog("Digite su usuario.");
            String password = JOptionPane.showInputDialog("Digite su clave.");
            String mail = JOptionPane.showInputDialog("Digite su correo.");
            Register register = new Register();
            if(register.validateUserByUser(user)){
                System.out.println("El usuario ya existe");
            }else if(register.validateUserByDocument(document)){
                System.out.println("El documento ya esta registrado");
            }else{
                register.registerUser(document,user,password,mail,gender,name,lastName,age);
                System.out.println("Se registro con exito");
            }
        }
    }
}
