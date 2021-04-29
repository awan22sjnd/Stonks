package Windows;

import Main.Stonks;
import Main.UserInterface;
import org.apache.hc.core5.http.ParseException;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class MainWindow {
    public JPanel mainPanel;
    private JPanel infoPanel;
    private JPanel chartPanel;
    private JPanel graphPanel;
    private JPanel tablePanel;
    private JPanel pricingPanel;
    private JPanel searchPanel;
    private JButton tickerSearchButton;
    private JTextField tickerField;
    private JLabel tickerLabel;
    private JLabel priceLabel;
    private Stonks stonk;

    public MainWindow(UserInterface userInterface) {
        stonk = userInterface.getWrapper();
        tickerSearchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    stonk.getData(tickerField.getText());
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                } catch (ParseException parseException) {
                    parseException.printStackTrace();
                } catch (org.json.simple.parser.ParseException parseException) {
                    parseException.printStackTrace();
                }
                tickerLabel.setText(stonk.getTicker());
                priceLabel.setText(stonk.getPrice());
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("MainWindow");
        Stonks stonk = new Stonks();
        frame.setContentPane(stonk.returnUI().mainWindow.mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
