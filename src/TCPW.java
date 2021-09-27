import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class TCPW extends JFrame {

    private static final long serialVersionUID = 1L;

    JTextArea textArea = new JTextArea();
    JTextField textField = new JTextField();
    JButton btnSend = new JButton("Send");
    private Socket s;
    DataInputStream dis;
    DataOutputStream dos;
    public TCPW(String title, Socket s) {
        setTitle(title);
        this.s =s;
        this.setupSock();
        this.prepareFrame();

    }
    private void setupSock()
    {
        try{
            dis = new DataInputStream(s.getInputStream());
            dos = new DataOutputStream(s.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void prepareFrame() {
        Container content = getContentPane();

        Box south = Box.createHorizontalBox();
        south.add(textField);
        south.add(btnSend);

        JScrollPane scrollPane = new JScrollPane(textArea);
        content.add(scrollPane, "Center");
        content.add(south, "South");

        setBounds(100, 100, 300, 300);
        setResizable(false);
        addWindowListener(new WindowHandler());
        btnSend.addActionListener(new SendHandler());

    }



    class WindowHandler extends WindowAdapter {
        public void windowClosing(WindowEvent e) {
           dispose();
        }
    }

    class SendHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String message = textField.getText();
            String appendedText = textArea.getText() + "\n" + "You:" + message;
            textArea.setText(appendedText);
            try
            {
                dos.writeUTF(message);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }

        }
    }


}


