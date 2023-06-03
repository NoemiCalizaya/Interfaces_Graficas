package ventana;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


/*JFrame es una clase que representa una ventana o marco de nivel superior en una aplicación GUI en Java.
Se utiliza como el contenedor principal para la interfaz gráfica de usuario de una aplicación.

JPanel es una clase que representa un contenedor liviano dentro de un JFrame o cualquier otro contenedor 
en una aplicación GUI de Java.

JFrame es la ventana principal de una aplicación GUI, mientras que JPanel es un contenedor utilizado para 
organizar y distribuir componentes gráficos dentro de un JFrame o cualquier otro contenedor. JFrame proporciona 
los elementos de la ventana de la aplicación, mientras que JPanel proporciona el espacio donde se colocan y 
organizan los componentes gráficos.
*/
public class Ventana extends JFrame {
	//Atributos
	//Creamos el panel
	public JPanel panel;
	public JTextField cajaTexto1;
	public JTextField cajaTexto2;
	public JTextField cajaTexto3;
	JRadioButton radioBoton1;
	JRadioButton radioBoton2;
	
	public Ventana() {
					//ancho-alto
		this.setSize(600, 500);//Establecemos el tamano de la ventana
		this.setTitle("Ventana Operación Suma");//Establecemos el titulo de la ventana
		//setLocation(100, 100);
		//setBounds(100, 200, 600, 600);
		setLocationRelativeTo(null);//Establecemos la ventana al centro
		//this.getContentPane().setBackground(Color.CYAN);
		
		iniciarComponentes();
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	private void iniciarComponentes() {
		colocarPaneles();
		colocarEtiquetas();
		colocarCajasTexto();
		colocarBotones();
		colocarRadioBotones();
	}
	private void colocarPaneles() {
		//Instanciamos el Panel
		panel = new JPanel();
		panel.setLayout(null);//Desactivando el diseño por defecto de JPanel
		//panel.setBackground(Color.CYAN);//Establecemos el color del panel
							//formato RGB
		panel.setBackground(new Color(30, 150, 200));//Otra forma de establecemos el color del panel
		this.getContentPane().add(panel);//Agregamos el panel a la ventana
	}
	private void colocarEtiquetas() {
		//Etiqueta 1 - etiqueta tipo texto
		JLabel etiqueta = new JLabel();
		etiqueta.setText("OPERACIÓN SUMA");
							//x, y, ancho, alto
		etiqueta.setBounds(80,10,210,60);
		etiqueta.setOpaque(true);//Establecemos pintar el fondo de la etiqueta
		etiqueta.setBackground(Color.gray);//Cambiamos el color de fondo de la etiqueta
		etiqueta.setHorizontalAlignment(SwingConstants.CENTER);//Establecemos alineación horizontal del texto en el centro
		etiqueta.setForeground(Color.BLACK);//Establecemos color de la letra
						//tipo de letra /estilo de fuente 0 normal, 1 negrita, 2 cursiva, 3 negrita cursiva /tamaño de letra
		etiqueta.setFont(new Font("arial", 3, 20));
		panel.add(etiqueta);
		
		//Etiqueta 2 - etiqueta tipo imagen
		ImageIcon imagen = new ImageIcon("Java.jpg");
		JLabel etiqueta2 = new JLabel();
		etiqueta2.setBounds(300,120,200,200);
		etiqueta2.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH)));
		panel.add(etiqueta2);
		
		JLabel etiqueta3 = new JLabel();
		etiqueta3.setText("Número 1:");
							//x, y, ancho, alto
		etiqueta3.setBounds(80,100,300,20);
		panel.add(etiqueta3);
		
		JLabel etiqueta4 = new JLabel();
		etiqueta4.setText("Número 2:");
							//x, y, ancho, alto
		etiqueta4.setBounds(80,170,300,20);
		panel.add(etiqueta4);
	}
	
	private void colocarCajasTexto() {
		cajaTexto1 = new JTextField();
		cajaTexto1.setBounds(80,130,120,30);
		panel.add(cajaTexto1);
		
		cajaTexto2 = new JTextField();
		cajaTexto2.setBounds(80,200,120,30);
		panel.add(cajaTexto2);
		
		cajaTexto3 = new JTextField();
		cajaTexto3.setBounds(80,300,100,30);
		panel.add(cajaTexto3);
		
	}
	
	private void colocarBotones() {
		JButton button1 = new JButton();
		button1.setBounds(100,250,60,40);
		//button1.setText("MULTIPLICAR");
		button1.setForeground(Color.WHITE);
		button1.setOpaque(true);//Establecemos pintar el fondo de la etiqueta
		button1.setBackground(Color.DARK_GRAY);
		
		//Creamos la imagen con ImageIcon
		ImageIcon imagenb = new ImageIcon("C://Users//NOEMI//Pictures//suma.jpg");
		//Colocamos la imagen dentro del botón																											
																												//tipo de escalado - Un escalado suave
				//Vamos a redimensionar la imagen al tamaño del botón en setIcon();   							//para no perder calidad de pixeles
		button1.setIcon(new ImageIcon(imagenb.getImage().getScaledInstance(button1.getWidth(), button1.getHeight(), Image.SCALE_SMOOTH)));
		panel.add(button1);
		
		//Agregando Evento de tipo ActionListener
		/*Para implementar la Interfaz ActionListener se usará una clase anónima 
		 * Una clase anonima es una clase sin nombre que se utiliza para 
		 * proporcionar una implementación rápida y concisa de una interfaz 
		 * o una clase abstracta. Se utiliza cuando no se necesita crear una 
		 * clase completa solo para implementar una interfaz o una clase abstracta.*/
		ActionListener oyenteDeAccion = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent ae) {
				//String nombre = cajaTexto1.getText();
				int numero1;
				int numero2;
				try {
					numero1 = Integer.parseInt(cajaTexto1.getText());
					numero2 = Integer.parseInt(cajaTexto2.getText());
					cajaTexto3.setText(String.valueOf(numero1*numero2)+" "+radioBoton1.getActionCommand());
				}catch(Exception e){
					JOptionPane.showMessageDialog(null, "Las cajas de texto solo aceptan datos numéricos.");
				}
			}
		};
		
		button1.addActionListener(oyenteDeAccion);
	}
	
	private void colocarRadioBotones() {
		radioBoton1 = new JRadioButton("Java");
		radioBoton2 = new JRadioButton("Python");
		radioBoton1.setBounds(80, 340, 100, 40);
		radioBoton1.setSelected(true);
		radioBoton2.setBounds(200, 340, 100, 40);
		panel.add(radioBoton1);
		panel.add(radioBoton2);
		
		ButtonGroup grupo = new ButtonGroup();
		grupo.add(radioBoton1);
		grupo.add(radioBoton2);
	}
}
