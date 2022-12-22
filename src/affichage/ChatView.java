
package affichage;

import chat.Client;
import chat.Message;
import chat.Server;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.* ;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;


public class ChatView extends JFrame {

     Client client;
     Server server;
     int mode;
     JLabel chatroomTitle;
     JScrollPane jScrollPane1;
     JButton logoutButton;
     JTextField messageField;
     JTextArea messagePanel;
     JButton sendButton;
    
    /*
      Creates new form ChatView
     */
    public ChatView() {
        initComponents();
        this.setTitle("Chatroom");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack () ;
        messagePanel.setLayout(new BoxLayout(messagePanel, BoxLayout.Y_AXIS));
        mode = 0;
    }
    
    /*
      Set the users name that is displayed at the title
     */
    public void SetUsername(String username) {
        chatroomTitle.setText("Chatroom: " + username);
        this.repaint();
    }
    /* 
      Set client class
     */
    public void SetClient(Client client) {
        mode = 1;
        this.client = client;
    }
    /*
     Set server class
     */
    public void SetServer(Server srv) {
        mode = 2;
        server = srv;
    }
    
    /*
      Add a message sent from this host
     */
    public void AddClientMessage(String msg) {
        if (mode == 1) {
            Message message = new Message(client.getUsername(), msg);
            String msgAdd = "" + message.getTime() + " " + message.getUsername() + ":" + message.getText();
            messagePanel.append(msgAdd + "\n");
        } else {
            Message message = new Message(server.getUsername(), msg);
            String msgAdd = "" + message.getTime() + " " + message.getUsername() + ":" + message.getText();
            messagePanel.append(msgAdd + "\n");
        }
    }
    
    
    public void AddMessage(String msg) {
        if (mode == 1) {
            Message message = new Message("Partner", msg);
            String msgAdd = "" + message.getTime() + " " + message.getUsername() + ":" + message.getText();
            messagePanel.append(msgAdd + "\n");
        } else {
            Message message = new Message("Partner", msg);
            String msgAdd = "" + message.getTime() + " " + message.getUsername() + ":" + message.getText();
            messagePanel.append(msgAdd + "\n");
        }
    }
    
    
    private void initComponents() {

        messageField = new JTextField();
        sendButton = new JButton();
        chatroomTitle = new JLabel();
        logoutButton = new JButton();
        jScrollPane1 = new JScrollPane();
        messagePanel = new JTextArea();

        sendButton.setText("Send");
        sendButton.addActionListener(new ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendButtonActionPerformed(evt);
            }
        });

        chatroomTitle.setFont(new Font("Noto Sans", 0, 36)); 
        chatroomTitle.setForeground(new Color(120, 120, 120));
        chatroomTitle.setText("Chatroom: David");

        logoutButton.setText("Logout");
        logoutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });

        messagePanel.setEditable(false);
        messagePanel.setColumns(20);
        messagePanel.setLineWrap(true);
        messagePanel.setRows(5);
        messagePanel.setWrapStyleWord(true);
        jScrollPane1.setViewportView(messagePanel);

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        /*
         generate all horizontal panel
         */
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(messageField)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sendButton, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(chatroomTitle)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 206, Short.MAX_VALUE)
                        .addComponent(logoutButton, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        /*
         generate all vertical panel
         */
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(layout.createSequentialGroup().addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                    .addComponent(chatroomTitle, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(logoutButton, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(messageField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addComponent(sendButton))
                .addContainerGap())
        );

    }

    private void logoutButtonActionPerformed(ActionEvent evt) {
        if(mode == 1) {
            client.CloseConnection();
        } else {
            server.CloseConnection();
        }
        this.dispose();
        System.exit(0);
    }

    

    private void sendButtonActionPerformed(ActionEvent evt) {//GEN-FIRST:event_sendButtonActionPerformed
        String msg = messageField.getText();
        if (mode == 1) client.SendMessage(msg);
        else server.SendMessage(msg);
        AddClientMessage(msg);
        messageField.setText("");
    }

   

    
   
    
}
