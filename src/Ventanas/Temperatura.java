package Ventanas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Temperatura extends JFrame {

    public JPanel panel;

    public Temperatura() {
        setSize(600, 400);// tamaño ventana
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(this);
        setTitle("Conversor de Temperatura");
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

        JLabel temperatura = new JLabel("Conversor de Temperatura", SwingConstants.CENTER);
        temperatura.setBounds(200, 5, 150, 30);
        temperatura.setFont(new Font("Anton", Font.PLAIN, 12));
        temperatura.setHorizontalAlignment(SwingConstants.CENTER); //se puede usar este 
        panel.add(temperatura);
        
        JLabel lblTemperatura = new JLabel("Introduzca el valor a convertir");
        lblTemperatura.setBounds(10,50,200,30);
        lblTemperatura.setFont(new Font("Anton", Font.PLAIN, 12));
        panel.add(lblTemperatura);
        
        JTextField txtTemperatura = new JTextField();
        txtTemperatura.setBounds(220,50, 200, 30);
        txtTemperatura.setOpaque(false);
        txtTemperatura.setFont(new Font("Anton", Font.PLAIN, 12));
        panel.add(txtTemperatura);
        
        JLabel lblTemperatura1 = new JLabel("Valor resultante de la conversion: ");
        lblTemperatura1.setBounds(10,160,200,30);
        lblTemperatura1.setFont(new Font("Anton", Font.PLAIN, 12));
        panel.add(lblTemperatura1);
        
        JTextField txtTemperatura1 = new JTextField();
        txtTemperatura1.setBounds(220,160, 200, 30);
        txtTemperatura1.setOpaque(false);
        txtTemperatura1.setEditable(false);
        txtTemperatura1.setFont(new Font("Anton", Font.PLAIN, 12));
        panel.add(txtTemperatura1);
        
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
        retorno.addActionListener(oyente );
        
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
        oyente3 = (ActionEvent ae) -> {
            System.exit(0);
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

    private void colocarListasDesplegables(){
    
    String[] listaTemperatura = {"Celsius","Fahrenheit","Kelvin"};
    JComboBox temperatura = new JComboBox(listaTemperatura);
    temperatura.setFont(new Font("Anton", Font.PLAIN, 12));
    temperatura.setBounds(10, 100, 100, 40);
    panel.add(temperatura);
    
    JComboBox temperatura1 = new JComboBox(listaTemperatura);
    temperatura1.setSelectedIndex(1);
    temperatura1.setFont(new Font("Anton", Font.PLAIN, 12));
    temperatura1.setBounds(250, 100, 100, 40);
    panel.add(temperatura1);
    }
    
        double convertirTemperatura(double cantidad, String temperaturaOrigen, String temperaturaDestino) {

        switch (temperaturaOrigen) {


            case "Celsius" -> {
                switch (temperaturaDestino) {


                    case "Celsius" -> {
                        return cantidad * 1;
                    }
                    case "Fahrenheit" -> {
                        return cantidad * 0.90;
                    }
                    case "Kelvin" -> {
                        return cantidad * 0.77;
                    }                    
                }
            }
            case "Fahrenheit" -> {
                switch (temperaturaDestino) {


                    case "Celsius" -> {
                        return cantidad * 1.11;
                    }
                    case "Fahrenheit" -> {
                        return cantidad * 1;
                    }
                    case "Kelvin" -> {
                        return cantidad * 0.86;
                    }                    
                }
            }

            case "Kelvin" -> {
                switch (temperaturaDestino) {


                    case "Celsius" -> {
                        return cantidad * 1.30;
                    }
                    case "Fahrenheit" -> {
                        return cantidad * 1.17;
                    }
                    case "Kelvin" -> {
                        return cantidad * 1;
                    }
                    
                }
            }           
           

        }

        return 0.0;
    }

}
