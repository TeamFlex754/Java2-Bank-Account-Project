import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BankBalance implements ActionListener {

    private JFrame frame;

    private JPanel firstPanel;
    private JPanel secondPanel;
    private JPanel thirdPanel;
    private JPanel fourthPanel;
    private JPanel fifthPanel;

    private JLabel newAccountLabel;
    private JLabel depositLabel;
    private JLabel withdrawLabel;
    private JLabel finalBalanceLabel;

    private JTextField newAccountField;
    private JTextField depositField;
    private JTextField withdrawField;
    private JTextField finalBalanceField;

    private JButton submitButton;
    private JButton resetButton;

    private double balance;

    BankBalance() {
        frame = new JFrame("Bank Account");

        firstPanel = new JPanel();
        firstPanel.setLayout(new FlowLayout());
        newAccountLabel = new JLabel("Enter Starting Balance:");
        newAccountField = new JTextField("0", 10);
        newAccountField.setEditable(true);
        firstPanel.add(newAccountLabel);
        firstPanel.add(newAccountField);

        secondPanel = new JPanel();
        secondPanel.setLayout(new FlowLayout());
        depositLabel = new JLabel("Enter Deposit Amount:");
        depositField = new JTextField("0", 10);
        depositField.setEditable(true);
        secondPanel.add(depositLabel);
        secondPanel.add(depositField);

        thirdPanel = new JPanel();
        thirdPanel.setLayout(new FlowLayout());
        withdrawLabel = new JLabel("Enter Withdraw Amount:");
        withdrawField = new JTextField("0", 10);
        withdrawField.setEditable(true);
        thirdPanel.add(withdrawLabel);
        thirdPanel.add(withdrawField);

        fourthPanel = new JPanel();
        fourthPanel.setLayout(new FlowLayout());
        finalBalanceLabel = new JLabel("Final Balance:");
        finalBalanceField = new JTextField("0", 10);
        finalBalanceField.setEditable(false);
        fourthPanel.add(finalBalanceLabel);
        fourthPanel.add(finalBalanceField);

        fifthPanel = new JPanel();
        fifthPanel.setLayout(new FlowLayout());
        submitButton = new JButton("Submit");
        submitButton.addActionListener(this);
        resetButton = new JButton("Reset");
        resetButton.addActionListener(this);
        fifthPanel.add(submitButton);
        fifthPanel.add(resetButton);

        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        frame.add(firstPanel);
        frame.add(secondPanel);
        frame.add(thirdPanel);
        frame.add(fourthPanel);
        frame.add(fifthPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            String userInputStartingBalance;
            double startingBalance;
            String userDeposit;
            double deposit;
            String userWithdraw;
            double withdraw;

            userInputStartingBalance = newAccountField.getText();
            startingBalance = Double.parseDouble(userInputStartingBalance);

            userDeposit = depositField.getText();
            deposit = Double.parseDouble(userDeposit);

            userWithdraw = withdrawField.getText();
            withdraw = Double.parseDouble(userWithdraw);

            balance += startingBalance + deposit - withdraw;
            finalBalanceField.setText(Double.toString(balance));

            newAccountField.setText("0");
            depositField.setText("0");
            withdrawField.setText("0");
        } else if (e.getSource() == resetButton) {
            newAccountField.setText("0");
            depositField.setText("0");
            withdrawField.setText("0");
            finalBalanceField.setText("0");
            balance = 0;
        }
    }
}
