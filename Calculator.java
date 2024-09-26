import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Calculator implements ActionListener {
    JFrame jf;
    JLabel displayLabel;
    boolean operatorClicked=false;
    String oldValue;
    String operator;

    JButton sevenButton,clearButton,
    eightButton,nineButton,fourButton,
    fiveButton, sixButton, oneButton,
    twoButton, threeButton, zeroButton,
    dotButton, equalButton, divButton,
    multiButton, minusButton,plusButton;

    Calculator()
    {
        jf=new JFrame("Calculator");
        jf.setLayout(null);
        jf.setSize(550,600);
        jf.setLocation(300, 150);

        displayLabel=new JLabel();
        displayLabel.setBounds(30, 50, 440, 40);
        displayLabel.setBackground(Color.GRAY);
        displayLabel.setOpaque(true);
        displayLabel.setHorizontalAlignment(SwingConstants.RIGHT);
        displayLabel.setForeground(Color.white);
        jf.add(displayLabel);

        sevenButton=new JButton("7");
        sevenButton.setBounds(30,130,80,80);
        sevenButton.addActionListener(this);
        jf.add(sevenButton);

        eightButton=new JButton("8");
        eightButton.setBounds(130, 130, 80, 80);
        eightButton.addActionListener(this);
        jf.add(eightButton);

        nineButton=new JButton("9");
        nineButton.setBounds(230, 130, 80, 80);
        nineButton.addActionListener(this);
        jf.add(nineButton);

        fourButton=new JButton("4");
        fourButton.setBounds(30,230,80,80);
        fourButton.addActionListener(this);
        jf.add(fourButton);

        fiveButton=new JButton("5");
        fiveButton.setBounds(130, 230, 80, 80);
        fiveButton.addActionListener(this);
        jf.add(fiveButton);

        sixButton=new JButton("6");
        sixButton.setBounds(230, 230, 80, 80);
        sixButton.addActionListener(this);
        jf.add(sixButton);

        oneButton=new JButton("1");
        oneButton.setBounds(30,330,80,80);
        oneButton.addActionListener(this);
        jf.add(oneButton);

        twoButton=new JButton("2");
        twoButton.setBounds(130, 330, 80, 80);
        twoButton.addActionListener(this);
        jf.add(twoButton);

        threeButton=new JButton("3");
        threeButton.setBounds(230, 330, 80, 80);
        threeButton.addActionListener(this);
        jf.add(threeButton);

        zeroButton=new JButton("0");
        zeroButton.setBounds(30,430,80,80);
        zeroButton.addActionListener(this);
        jf.add(zeroButton);

        dotButton=new JButton(".");
        dotButton.setBounds(130, 430, 80, 80);
        dotButton.addActionListener(this);
        jf.add(dotButton);

        equalButton=new JButton("=");
        equalButton.setBounds(230, 430, 80, 80);
        equalButton.addActionListener(this);
        jf.add(equalButton);

        divButton=new JButton("/");
        divButton.setBounds(330, 130, 80, 80);
        divButton.addActionListener(this);
        jf.add(divButton);

        multiButton=new JButton("x");
        multiButton.setBounds(330, 230, 80, 80);
        multiButton.addActionListener(this);
        jf.add(multiButton);

        minusButton=new JButton("-");
        minusButton.setBounds(330, 330, 80, 80);
        minusButton.addActionListener(this);
        jf.add(minusButton);

        plusButton=new JButton("+");
        plusButton.setBounds(330, 430, 80, 80);
        plusButton.addActionListener(this);
        jf.add(plusButton);

        clearButton=new JButton("Clear");
        clearButton.setBounds(430, 430, 80, 80);
        clearButton.addActionListener(this);
        jf.add(clearButton);

        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Calculator();
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==sevenButton)
        {
            appendNumber("7");
        }
        else if(e.getSource()==eightButton)
        {
            appendNumber("8");
        }
        else if(e.getSource()==nineButton)
        {
            appendNumber("9");
        }
        else if(e.getSource()==fourButton)
        {
            appendNumber("4");
        }
        else if(e.getSource()==fiveButton)
        {
            appendNumber("5");
        }
        else if(e.getSource()==sixButton)
        {
            appendNumber("6");
        }
        else if(e.getSource()==oneButton)
        {
            appendNumber("1");
        }
        else if(e.getSource()==twoButton)
        {
            appendNumber("2");
        }
        else if(e.getSource()==threeButton)
        {
            appendNumber("3");
        }
        else if(e.getSource()==zeroButton)
        {
            appendNumber("0");
        }
        else if(e.getSource()==dotButton)
        {
            appendNumber(".");
        }
        else if (e.getSource() == plusButton) {
            setOperator("+");
        } else if (e.getSource() == minusButton) {
            setOperator("-");
        } else if (e.getSource() == multiButton) {
            setOperator("x");
        } else if (e.getSource() == divButton) {
            setOperator("/");
        } else if (e.getSource() == equalButton) {
            calculate();
        } else if (e.getSource() == clearButton) {
            displayLabel.setText("");
        }
    }

    private void appendNumber(String num)
    {
        if(operatorClicked)
        {
            displayLabel.setText(num);
            operatorClicked=false;
        }
        else{
            displayLabel.setText(displayLabel.getText()+num);
        }
    }

    private void setOperator(String op) {
        operatorClicked = true;
        oldValue = displayLabel.getText();
        operator = op;
    }

    private void calculate() {
        String newValue = displayLabel.getText();
        float oldValueF = Float.parseFloat(oldValue);
        float newValueF = Float.parseFloat(newValue);
        float result = 0;

        switch (operator) {
            case "+":
                result = oldValueF + newValueF;
                break;
            case "-":
                result = oldValueF - newValueF;
                break;
            case "x":
                result = oldValueF * newValueF;
                break;
            case "/":
                result = oldValueF / newValueF;
                break;
        }
        displayLabel.setText(result + "");
    }
}
