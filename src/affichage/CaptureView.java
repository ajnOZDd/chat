package affichage;

import java.awt.Font;
import java.awt.event.* ;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;
import java.awt.Color ;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class CaptureView extends javax.swing.JDialog {
    
     String ipMachine;
     int portMachine;
     String clientName;
    JTextField ipField;
    JPanel jPanel1;
    JPanel jPanel2;
    JButton loginButton;
    JTextField nameField;
    JTextField portField;
    JLabel titleText;

    /*
      Creates new form CaptureView
     */
    public CaptureView(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setTitle("Login");
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing (WindowEvent e) {
                System.exit(0);
            }
        });
        pack();
        setLocationRelativeTo(null);
    }
    
    /**
     * Get introduced IP
     */
    public String GetIP() {
        return ipMachine;
    }
    /**
     * Get selected port
     */
    public int GetPort() {
        return portMachine;
    }
    /**
     * Get user's name
     */
    public String GetUsername() {
        return clientName;
    }

    /**
     * Set the title text of the window
     */
    public void SetTitleText(String text) {
        titleText.setText(text);
        this.repaint();
    }
    /**
     * Enable/disable the field IP
     * Server is not interested in entering an IP address
     */
    public void SetIpEnable(boolean ipStatus) {
        ipField.setEnabled(ipStatus);
        this.repaint();
    }
    /**
     * Set fields
     */
    public void SetIpField(String ipAddress) {
        ipField.setText(ipAddress);
    }
    public void SetPortField(int port) {
        portField.setText(Integer.toString(port));
    }
    
    
    private void initComponents() {

        titleText = new JLabel();
        jPanel1 = new JPanel();
        ipField = new JTextField();
        portField = new JTextField();
        jPanel2 = new JPanel();
        nameField = new JTextField();
        loginButton = new JButton();

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        titleText.setFont(new java.awt.Font("Noto Sans", 1, 24)); 
        titleText.setHorizontalAlignment(SwingConstants.CENTER);
        titleText.setText("Client login");

        jPanel1.setBorder(BorderFactory.createTitledBorder(null, "Connection", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION, new Font("Dialog", 0, 12), new java.awt.Color(120, 120, 120))); // NOI18N

        ipField.setText("IP Address");
        

        portField.setText("Port");

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);

        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ipField, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(portField, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(ipField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(portField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Client options", TitledBorder.CENTER, TitledBorder.DEFAULT_POSITION, new Font("Dialog", 0, 12), new Color(120, 120, 120))); // NOI18N

        nameField.setText("Name");

        loginButton.setText("Login");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(nameField, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(loginButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(nameField, GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(loginButton))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, GroupLayout.Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(titleText, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleText)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

    }

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {
        ipMachine = ipField.getText();
        portMachine = Integer.parseInt(portField.getText());
        clientName = nameField.getText();
        
        this.dispose();
    }

   
    public static void main(String args[]) {
       
    }

   
    

}
