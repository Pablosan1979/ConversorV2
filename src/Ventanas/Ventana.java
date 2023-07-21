package Ventanas;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Ventana extends JFrame {

    public JPanel panel;

    public Ventana() {
        setSize(600, 400);// tamaño ventana
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(this);
        setTitle("Conversor de Unidades");
        setFont(new Font("Anton", Font.PLAIN, 12));
        Image img = Toolkit.getDefaultToolkit().createImage(getClass().getResource("/Imagenes/Logo.jpg"));
        this.setIconImage(img);//        
        setResizable(false);
        iniciarComponentes(); // llamado componente panel
        setUndecorated(true);
    }

    private void iniciarComponentes() {

        colocarPaneles();
        colocarElementos();
        colocarBotones();
    }

    private void colocarPaneles() {

        panel = new JPanel();
        panel.setLayout(null);
        this.getContentPane().add(panel);
    }

    private void colocarElementos() {

        JLabel lblLogo = new JLabel();
        lblLogo.setBounds(225, 350, 100, 50);
        Image img = Toolkit.getDefaultToolkit().createImage(getClass().getResource("/Imagenes/Logo.jpg"));
        this.setIconImage(img);
        lblLogo.setIcon(new ImageIcon(img.getScaledInstance(lblLogo.getWidth(), lblLogo.getHeight(), Image.SCALE_SMOOTH)));
        panel.add(lblLogo);

        JLabel conversor = new JLabel("Conversor de Unidades");
        conversor.setBounds(200, 10, 200, 100);
        conversor.setFont(new Font("Anton", Font.PLAIN, 20));
        conversor.setHorizontalAlignment(SwingConstants.CENTER); //se puede usar este 
        panel.add(conversor);

        JLabel monedas = new JLabel("Conversor de Monedas", SwingConstants.CENTER); //otra forma de alinear el texto.
        monedas.setBounds(15, 100, 140, 30);
        monedas.setFont(new Font("Anton", Font.PLAIN, 15));
        panel.add(monedas);

        JLabel datos = new JLabel("Conversor de Datos", SwingConstants.CENTER);//otra forma de alinear el texto.
        datos.setFont(new Font("Anton", Font.PLAIN, 15));
        datos.setBounds(220, 100, 120, 30);
        panel.add(datos);

        JLabel temperatura = new JLabel("Conversor de Temperatura", SwingConstants.CENTER);//otra forma de alinear el texto.
        temperatura.setFont(new Font("Anton", Font.PLAIN, 15));
        temperatura.setBounds(405, 100, 160, 30);
        panel.add(temperatura);
    }

    private void colocarBotones() {

        JButton moneda = new JButton();
        moneda.setBounds(15, 150, 150, 100);
        moneda.setMnemonic('m');
        moneda.setCursor(new Cursor(Cursor.HAND_CURSOR));
        Image img = Toolkit.getDefaultToolkit().createImage(getClass().getResource("/Imagenes/intercambio.png"));
        this.setIconImage(img);
        moneda.setIcon(new ImageIcon(img.getScaledInstance(moneda.getWidth(), moneda.getHeight(), Image.SCALE_SMOOTH)));
        this.setLocationRelativeTo(null);
        panel.add(moneda);
        this.dispose();

        ActionListener oyente;
        oyente = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Monedas newFrame = new Monedas();
                newFrame.setVisible(true);
                //this.dispose();
            }
        };
        moneda.addActionListener(oyente);

        JButton datos = new JButton();
        datos.setBounds(210, 150, 150, 100);
        datos.setMnemonic('d');
        datos.setCursor(new Cursor(Cursor.HAND_CURSOR));
        Image img1 = Toolkit.getDefaultToolkit().createImage(getClass().getResource("/Imagenes/unidad.png"));
        this.setIconImage(img1);
        datos.setIcon(new ImageIcon(img1.getScaledInstance(datos.getWidth(), datos.getHeight(), Image.SCALE_SMOOTH)));
        this.setLocationRelativeTo(null);
        panel.add(datos);
        this.dispose();
        
        ActionListener oyente1;
        oyente1 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Datos newFrame = new Datos();
                newFrame.setVisible(true);
                //this.dispose();
            }
        };
        datos.addActionListener(oyente1);

        JButton temperatura = new JButton();
        temperatura.setBounds(410, 150, 150, 100);
        temperatura.setCursor(new Cursor(Cursor.HAND_CURSOR));
        temperatura.setMnemonic('t');
        Image img2 = Toolkit.getDefaultToolkit().createImage(getClass().getResource("/Imagenes/termometro.png"));
        this.setIconImage(img2);
        temperatura.setIcon(new ImageIcon(img2.getScaledInstance(temperatura.getWidth(), temperatura.getHeight(), Image.SCALE_SMOOTH)));
        this.setLocationRelativeTo(null);
        panel.add(temperatura);
        

        ActionListener oyente2;
        oyente2 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Temperatura newFrame = new Temperatura();
                newFrame.setVisible(true);                
            }
        };
        temperatura.addActionListener(oyente2);
        
        JButton salir = new JButton();
        salir.setBounds(555, 355, 40, 40);
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

    }
}
