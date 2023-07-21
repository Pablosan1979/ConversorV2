package Ventanas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Monedas extends JFrame {

    public JPanel panel;

    public Monedas() {
        setSize(600, 400);// tamaño ventana
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(this);
        setTitle("Conversor de Monedas");
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

        JLabel monedas = new JLabel("Conversor de Monedas", SwingConstants.CENTER);
        monedas.setBounds(200, 5, 150, 30);
        monedas.setFont(new Font("Anton", Font.PLAIN, 12));
        monedas.setHorizontalAlignment(SwingConstants.CENTER); //se puede usar este 
        panel.add(monedas);

        JLabel lblMoneda = new JLabel("Introduzca el valor a convertir");
        lblMoneda.setBounds(10, 50, 200, 30);
        lblMoneda.setFont(new Font("Anton", Font.PLAIN, 12));
        panel.add(lblMoneda);

        JTextField txtMoneda = new JTextField();
        txtMoneda.setBounds(220, 50, 200, 30);
        txtMoneda.setOpaque(false);
        txtMoneda.setFont(new Font("Anton", Font.PLAIN, 12));
        panel.add(txtMoneda);

        JLabel lblMoneda1 = new JLabel("Valor resultante de la conversion: ");
        lblMoneda1.setBounds(10, 160, 200, 30);
        lblMoneda1.setFont(new Font("Anton", Font.PLAIN, 12));
        panel.add(lblMoneda1);

        JTextField txtMoneda1 = new JTextField();
        txtMoneda1.setBounds(220, 160, 200, 30);
        txtMoneda1.setFont(new Font("Anton", Font.PLAIN, 12));
        txtMoneda1.setOpaque(true);
        txtMoneda1.setEditable(false);
        panel.add(txtMoneda1);

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
        igual.setCursor(new Cursor(Cursor.HAND_CURSOR));
        igual.setMnemonic('v');
        Image img4 = Toolkit.getDefaultToolkit().createImage(getClass().getResource("/Imagenes/igual.png"));
        this.setIconImage(img4);
        igual.setIcon(new ImageIcon(img4.getScaledInstance(igual.getWidth(), igual.getHeight(), Image.SCALE_SMOOTH)));
        this.setLocationRelativeTo(null);
        panel.add(igual);

        ActionListener oyente4;
        oyente4 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

            }
        };
        igual.addActionListener(oyente4);

    }

    private void colocarListasDesplegables() {

        String[] listaMonedas = {"Dolares", "Euros", "Libras Esterlinas", "Pesos COP", "Won Surcoreano", "Yen Japones"};
        JComboBox monedas = new JComboBox(listaMonedas);
        monedas.setFont(new Font("Anton", Font.PLAIN, 12));
        monedas.setBounds(10, 100, 100, 40);
        panel.add(monedas);

        JComboBox monedas1 = new JComboBox(listaMonedas);
        monedas1.setSelectedIndex(1);
        monedas1.setFont(new Font("Anton", Font.PLAIN, 12));
        monedas1.setBounds(250, 100, 100, 40);
        panel.add(monedas1);
    }

    double convertirMonedas(double cantidad, String monedaOrigen, String monedaDestino) {

        switch (monedaOrigen) {
            case "Dólares" -> {
                switch (monedaDestino) {
                    case "Dolares" -> {
                        return cantidad * 1;
                    }
                    case "Euros" -> {
                        return cantidad * 0.90;
                    }
                    case "Libras Esterlinas" -> {
                        return cantidad * 0.77;
                    }
                    case "Pesos" -> {
                        return cantidad * 4141;
                    }
                    case "Won" -> {
                        return cantidad * 1273.36;
                    }
                    case "Yenes" -> {
                        return cantidad * 138.47;
                    }
                }
            }
            case "Euros" -> {
                switch (monedaDestino) {
                    case "Dolares" -> {
                        return cantidad * 1.11;
                    }
                    case "Euros" -> {
                        return cantidad * 1;
                    }
                    case "Libras Esterlinas" -> {
                        return cantidad * 0.86;
                    }
                    case "Pesos" -> {
                        return cantidad * 4609.37;
                    }
                    case "Won" -> {
                        return cantidad * 1419.11;
                    }
                    case "Yenes" -> {
                        return cantidad * 154.22;
                    }
                }
            }

            case "Libras Esterlinas" -> {
                switch (monedaDestino) {
                    case "Dolares" -> {
                        return cantidad * 1.30;
                    }
                    case "Euros" -> {
                        return cantidad * 1.17;
                    }
                    case "Libras Esterlinas" -> {
                        return cantidad * 1;
                    }
                    case "Pesos" -> {
                        return cantidad * 5378.68;
                    }
                    case "Won" -> {
                        return cantidad * 1655.68;
                    }
                    case "Yenes" -> {
                        return cantidad * 179.95;
                    }
                }
            }

            case "Pesos" -> {
                switch (monedaDestino) {
                    case "Dolares" -> {
                        return cantidad * 0.00024;
                    }
                    case "Euros" -> {
                        return cantidad * 0.00022;
                    }
                    case "Libras Esterlinas" -> {
                        return cantidad * 0.00019;
                    }
                    case "Pesos" -> {
                        return cantidad * 1;
                    }
                    case "Won" -> {
                        return cantidad * 0.31;
                    }
                    case "Yenes" -> {
                        return cantidad * 0.033;
                    }
                }
            }

            case "Won" -> {
                switch (monedaDestino) {
                    case "Dolares" -> {
                        return cantidad * 0.00078;
                    }
                    case "Euros" -> {
                        return cantidad * 0.00070;
                    }
                    case "Libras Esterlinas" -> {
                        return cantidad * 0.00060;
                    }
                    case "Pesos" -> {
                        return cantidad * 3.25;
                    }
                    case "Won" -> {
                        return cantidad * 1;
                    }
                    case "Yenes" -> {
                        return cantidad * 0.11;
                    }
                }
            }
            case "Yenes" -> {
                switch (monedaDestino) {
                    case "Dolares" -> {
                        return cantidad * 0.0072;
                    }
                    case "Euros" -> {
                        return cantidad * 0.0065;
                    }
                    case "Libras Esterlinas" -> {
                        return cantidad * 0.0056;
                    }
                    case "Pesos" -> {
                        return cantidad * 29.89;
                    }
                    case "Won" -> {
                        return cantidad * 9.20;
                    }
                    case "Yenes" -> {
                        return cantidad * 1;
                    }
                }
            }
        }

        return 0.0;
    }
}
