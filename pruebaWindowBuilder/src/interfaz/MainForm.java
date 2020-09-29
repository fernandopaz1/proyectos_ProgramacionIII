package interfaz;

import java.awt.EventQueue;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseWheelListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

public class MainForm {

	private JFrame frame;
	private JTextField inputNombre;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainForm window = new MainForm();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}); 
	}

	/**
	 * Create the application.
	 */
	public MainForm() {
         /*
          *    //here you can put the selected theme class name in JTattoo
            	try {
					UIManager.setLookAndFeel("com.jtattoo.plaf.texture.TextureLookAndFeel");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (UnsupportedLookAndFeelException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		*/
		
		try {
			//Podemos usar mas looksAndFeel siempre instalando el .jar correspondiente
			//Esos lookAndFeel deben ser soportados por swing
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
			//UIManager.setLookAndFeel("com.jtattoo.plaf.smart.SmartLookAndFeel");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblIntrodNombre = new JLabel("Introduzca Nombre");
		lblIntrodNombre.setBounds(30, 7, 202, 28);
		frame.getContentPane().add(lblIntrodNombre);
		
		inputNombre = new JTextField();
		inputNombre.setBounds(268, 12, 126, 28);
		frame.getContentPane().add(inputNombre);
		inputNombre.setColumns(10);
		
		
		JLabel labelSaludo = new JLabel("");
		labelSaludo.setBounds(140, 213, 126, 15);
		frame.getContentPane().add(labelSaludo);
		

		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				btnGuardar.setBackground(null);
			}
		});
		btnGuardar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				if(inputNombre.getText().length()>2) {
					btnGuardar.setBackground(new Color(0,255,51));
				}else {
					btnGuardar.setBackground(new Color(255,51,51));
				}
			}
			
		});
		
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					String nombre = inputNombre.getText(); 
					labelSaludo.setText("Hola "+ nombre);
			}
		});
		btnGuardar.setBounds(140, 86, 117, 25);
		frame.getContentPane().add(btnGuardar);
	}
}
