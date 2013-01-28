package Gui;

import gnu.io.CommPortIdentifier;
import java.util.Enumeration;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Componets.Connection.ConnectButton;
import Componets.Connection.RefreshButton;
import Events.ICompleteConnectEventListener;
import Main.DataManager;

import javax.swing.JComboBox;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenu;

public class Connect
{

	private JPanel contentPane;
	public static javax.swing.event.EventListenerList listenerList = new javax.swing.event.EventListenerList();
	public Enumeration<CommPortIdentifier> portList;
	public Vector<String> comList;
	public ConnectButton connectButton;
	public JComboBox<String> comboBox;
	public RefreshButton refreshButton;
	private JLabel lblSerialConnection;
	public ConnectButton connectButtonSocket;
	private JMenuBar menuBar;
	private JMenu mnConnection;
	private JMenuItem mntmEmulator;
	public JFrame frame;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public Connect() {
		frame = new JFrame("Connect");
		
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(353, 191);
		
		menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		mnConnection = new JMenu("Connection");
		menuBar.add(mnConnection);
		
		mntmEmulator = new JMenuItem("Emulator");
		mntmEmulator.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AttemptingSocket attempting = null;
				String com = null;
				System.out.println("Emulator");
				new DataManager(com,2,attempting);
			}
		});
		mnConnection.add(mntmEmulator);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	
		comList = new Vector<String>();
		
		contentPane.setLayout(new FormLayout(new ColumnSpec[] {
				FormFactory.UNRELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.LABEL_COMPONENT_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormFactory.RELATED_GAP_COLSPEC,},
			new RowSpec[] {
				FormFactory.UNRELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				RowSpec.decode("max(23dlu;default)"),
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,
				FormFactory.DEFAULT_ROWSPEC,
				FormFactory.RELATED_GAP_ROWSPEC,}));
		
		lblSerialConnection = new JLabel("Serial Connection");
		lblSerialConnection.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblSerialConnection, "2, 2, 5, 1, center, default");
		
		JLabel lblSocketConnection = new JLabel("Socket Connection");
		lblSocketConnection.setFont(new Font("Tahoma", Font.BOLD, 14));
		contentPane.add(lblSocketConnection, "2, 6, 5, 1, center, default");
		
		JLabel lblSetToPort = new JLabel("Set to Port 2000 (AutoConnect) ");
		contentPane.add(lblSetToPort, "2, 8, 3, 1, center, default");
		comboBox = new JComboBox<String>();

		contentPane.add(comboBox, "2, 4, fill, center");
		
		refreshButton = new RefreshButton(this);
		contentPane.add(refreshButton, "4, 4, fill, center");
		refreshButton.setActionListener();
		
		connectButton = new ConnectButton(this);
		contentPane.add(connectButton, "6, 4, fill, center");
		connectButton.setSerialActionListener();
		
		
		connectButtonSocket = new ConnectButton(this);
		contentPane.add(connectButtonSocket, "6, 8, fill, center");
		connectButtonSocket.setSocketActionListener();
		
		frame.setContentPane(contentPane);
		frame.pack();
		frame.setVisible(true);
		getCom();
		
		
	}
	
	@SuppressWarnings("unchecked")
	public void getCom()
	{	 
		 portList = CommPortIdentifier.getPortIdentifiers();
		
		 boolean morePorts = true;
		 
		 
		 if(portList.hasMoreElements())
		 {
			 while(morePorts)
			 {
				 comList.add(portList.nextElement().getName());
				 if(!portList.hasMoreElements())
				 {
					 morePorts = false;
				 }
			 }
			 connectButton.setEnabled(true);
		 }
		 
		 if(comList.isEmpty())
		 {
			
			 comList.add("None Avalable");
			 connectButton.setEnabled(false);
		 }
		 
		 redrawCombox();
	}
	public void redrawCombox()
	{
		
		for(int i = 0; i < comList.size(); i++)
		{
			comboBox.addItem(comList.get(i));
		}
		frame.pack();
	}
	
	public static void addCompleteConnectEventListener (ICompleteConnectEventListener completeConnectEventListener)
	{
		listenerList.add(ICompleteConnectEventListener.class, completeConnectEventListener);
	}
	public static void removeCompleteConnectEventListener (ICompleteConnectEventListener completeConnectEventListener)
	{
		listenerList.remove(ICompleteConnectEventListener.class, completeConnectEventListener);
	}
}
