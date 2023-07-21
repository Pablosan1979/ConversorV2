package Ventanas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Datos extends JFrame {

    public JPanel panel;

    public Datos() {
        setSize(600, 400);// tamaño ventana
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(this);
        setTitle("Conversor de Datos");
        setResizable(false);
        setUndecorated(true);
        iniciarComponentes();

    }

    private void iniciarComponentes() {

        colocarPaneles();
        colocarElementos();
        colocarBotones();
        colocarListasDesplegables();
    }

    private void colocarPaneles() {

        panel = new JPanel();
        panel.setLayout(null);
        this.getContentPane().add(panel);
    }

    public void colocarElementos() {

        JLabel lblLogo = new JLabel();
        lblLogo.setBounds(225, 350, 100, 50);
        Image img = Toolkit.getDefaultToolkit().createImage(getClass().getResource("/Imagenes/Logo.jpg"));
        this.setIconImage(img);
        lblLogo.setIcon(new ImageIcon(img.getScaledInstance(lblLogo.getWidth(), lblLogo.getHeight(), Image.SCALE_SMOOTH)));
        panel.add(lblLogo);

        JLabel datos = new JLabel("Conversor de Datos", SwingConstants.CENTER);
        datos.setBounds(200, 5, 150, 30);
        datos.setFont(new Font("Anton", Font.PLAIN, 12));
        datos.setHorizontalAlignment(SwingConstants.CENTER); //se puede usar este 
        panel.add(datos);

        JLabel lblDatos = new JLabel("Introduzca el valor a convertir");
        lblDatos.setBounds(10, 50, 200, 30);
        lblDatos.setFont(new Font("Anton", Font.PLAIN, 12));
        panel.add(lblDatos);

        JTextField txtDatos = new JTextField();
        txtDatos.setBounds(220, 50, 200, 30);
        txtDatos.setOpaque(false);
        txtDatos.setFont(new Font("Anton", Font.PLAIN, 12));
        panel.add(txtDatos);

        JLabel lblDatos1 = new JLabel("Valor resultante de la conversion: ");
        lblDatos1.setBounds(10, 160, 200, 30);
        lblDatos1.setFont(new Font("Anton", Font.PLAIN, 12));
        panel.add(lblDatos1);

        JTextField txtDatos1 = new JTextField();
        txtDatos1.setBounds(220, 160, 200, 30);
        txtDatos1.setOpaque(true);
        txtDatos1.setEditable(false);
        txtDatos1.setFont(new Font("Anton", Font.PLAIN, 12));
        panel.add(txtDatos1);

        JLabel a = new JLabel("A", SwingConstants.CENTER);
        a.setBounds(100, 100, 150, 30);
        a.setFont(new Font("Anton", Font.PLAIN, 12));
        a.setHorizontalAlignment(SwingConstants.CENTER); //se puede usar este 
        panel.add(a);
    }

    private void colocarBotones() {

        JButton retorno = new JButton();
        retorno.setBounds(555, 355, 40, 40);
        retorno.setMnemonic('v');
        retorno.setCursor(new Cursor(Cursor.HAND_CURSOR));
        Image img = Toolkit.getDefaultToolkit().createImage(getClass().getResource("/Imagenes/regreso.png"));
        this.setIconImage(img);
        retorno.setIcon(new ImageIcon(img.getScaledInstance(retorno.getWidth(), retorno.getHeight(), Image.SCALE_SMOOTH)));
        this.setLocationRelativeTo(null);
        panel.add(retorno);

        ActionListener oyente;
        oyente = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Ventana newFrame = new Ventana();
                newFrame.setVisible(true);
            }
        };
        retorno.addActionListener(oyente);
                
        JButton salir = new JButton();
        salir.setBounds(5, 355, 40, 40);
        salir.setCursor(new Cursor(Cursor.HAND_CURSOR));
        salir.setMnemonic('s');
        Image img3 = Toolkit.getDefaultToolkit().createImage(getClass().getResource("/Imagenes/salida.png"));
        this.setIconImage(img3);
        salir.setIcon(new ImageIcon(img3.getScaledInstance(salir.getWidth(), salir.getHeight(), Image.SCALE_SMOOTH)));
        this.setLocationRelativeTo(null);
        panel.add(salir);
        
        ActionListener oyente3;
        oyente3 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
        };
        salir.addActionListener(oyente3);

        JButton igual = new JButton();
        igual.setBounds(450, 100, 40, 40);
        igual.setMnemonic('v');
        igual.setCursor(new Cursor(Cursor.HAND_CURSOR));
        Image img4 = Toolkit.getDefaultToolkit().createImage(getClass().getResource("/Imagenes/igual.png"));
        this.setIconImage(img4);
        igual.setIcon(new ImageIcon(img4.getScaledInstance(igual.getWidth(), igual.getHeight(), Image.SCALE_SMOOTH)));
        this.setLocationRelativeTo(null);
        panel.add(igual);
    }

    private void colocarListasDesplegables() {

        String[] listaDatos = {"kilobytes", "megabytes", "gigabytes"};
        JComboBox datos = new JComboBox(listaDatos);
        datos.setFont(new Font("Anton", Font.PLAIN, 12));
        datos.setBounds(10, 100, 100, 40);
        panel.add(datos);

        JComboBox datos1 = new JComboBox(listaDatos);
        datos1.setSelectedIndex(1);
        datos1.setFont(new Font("Anton", Font.PLAIN, 12));
        datos1.setBounds(250, 100, 100, 40);
        panel.add(datos1);
    }

    double convertirDatos(double cantidad, String datoOrigen, String datoDestino) {

        switch (datoOrigen) {

            case "kilobytes" -> {
                switch (datoDestino) {

                    case "kilobytes" -> {
                        return cantidad * 1;
                    }
                    case "megabytes" -> {
                        return cantidad * 0.90;
                    }
                    case "gigabytes" -> {
                        return cantidad * 0.77;
                    }                    
                }
            }
            case "megabytes" -> {
                switch (datoDestino) {

                    case "kilobytes" -> {
                        return cantidad * 1.11;
                    }
                    case "megabytes" -> {
                        return cantidad * 1;
                    }
                    case "gigabytes" -> {
                        return cantidad * 0.86;
                    }                    
                }
            }

            case "gigabytes" -> {
                switch (datoDestino) {

                    case "kilobytes" -> {
                        return cantidad * 1.30;
                    }
                    case "megabytes" -> {
                        return cantidad * 1.17;
                    }
                    case "gigabytes" -> {
                        return cantidad * 1;
                    }
                    
                }
            }           

        }

        return 0.0;
    }

}
