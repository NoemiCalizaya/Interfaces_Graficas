import javax.swing.*;

public class VentanaConHilo extends JFrame {
    private JLabel etiqueta;
    private JButton boton;
    private boolean detener;

    public VentanaConHilo() {
        super("Formulario con Hilos");

        etiqueta = new JLabel("Esperando acción...");
        add(etiqueta);

        boton = new JButton("Iniciar Proceso");
        boton.addActionListener(e -> iniciarHilo());
        add(boton);

        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void iniciarHilo() {
        detener = false;
        boton.setEnabled(false);

        Thread hilo = new Thread(() -> {
            etiqueta.setText("Proceso en ejecución...");

            // Simulación de un proceso largo
            for (int i = 0; i < 10; i++) {
                if (detener) {
                    etiqueta.setText("Proceso detenido");
                    break;
                }

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }

            if (!detener) {
                etiqueta.setText("Proceso completado");
            }

            boton.setEnabled(true);
        });

        hilo.start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
        	VentanaConHilo formulario = new VentanaConHilo();
            formulario.setVisible(true);
        });
    }
}
