package model;

import javax.swing.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int opcion = Integer.parseInt(JOptionPane.showInputDialog(
                        "Bienvenido\n"+
                        "1. si desea iniciar sesion\n" +
                        "2. si desea registrarse"));

        if (opcion == 1) {
            Login lg = new Login();
            String usuario = JOptionPane.showInputDialog("Digite su usuario.");
            String contraseña = JOptionPane.showInputDialog("Digite su contraseña.");

            if (lg.verifyCredentials(usuario, contraseña)) {
                JOptionPane.showMessageDialog(null,"Acceso exitoso.");
            } else {
                JOptionPane.showMessageDialog(null,"Verifique los datos ingresados.");
            }

        }
    }
}
