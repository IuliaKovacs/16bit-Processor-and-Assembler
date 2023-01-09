//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//



import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Calculator implements ActionListener {
    double number;
    double answer;
    int number1;
    int answer1;
    int calculation;
    JFrame frame;
    JLabel label = new JLabel();
    JTextField textField = new JTextField();
    JRadioButton onRadioButton = new JRadioButton("on");
    JRadioButton offRadioButton = new JRadioButton("off");
    JButton buttonZero = new JButton("0");
    JButton buttonOne = new JButton("1");
    JButton buttonTwo = new JButton("2");
    JButton buttonThree = new JButton("3");
    JButton buttonFour = new JButton("4");
    JButton buttonFive = new JButton("5");
    JButton buttonSix = new JButton("6");
    JButton buttonSeven = new JButton("7");
    JButton buttonEight = new JButton("8");
    JButton buttonNine = new JButton("9");
    JButton buttonDot = new JButton(".");
    JButton buttonClear = new JButton("C");
    JButton buttonDelete = new JButton("DEL");
    JButton buttonEqual = new JButton("=");
    JButton buttonMul = new JButton("x");
    JButton buttonDiv = new JButton("/");
    JButton buttonPlus = new JButton("+");
    JButton buttonMinus = new JButton("-");
    JButton buttonFib1 = new JButton("fib");
    JButton buttonFact = new JButton("!");
    JButton buttonPower = new JButton("2ᵃ");
    JButton buttonTen = new JButton("10ᵃ");
    JButton buttonPow = new JButton("xᵃ");
    JButton buttonSquare = new JButton("x²");

    Calculator() {
        this.prepareGUI();
        this.addComponents();
        this.addActionEvent();
    }

    public void prepareGUI() {
        this.frame = new JFrame();
        this.frame.setTitle("Calculator");
        this.frame.setSize(400, 500);
        this.frame.getContentPane().setLayout((LayoutManager)null);
        this.frame.getContentPane().setBackground(Color.black);
        this.frame.setResizable(false);
        this.frame.setLocationRelativeTo((Component)null);
        this.frame.setVisible(true);
        this.frame.setDefaultCloseOperation(3);
    }

    public void addComponents() {
        this.label.setBounds(250, 0, 50, 50);
        this.label.setForeground(Color.white);
        this.frame.add(this.label);
        this.textField.setBounds(10, 40, 350, 40);
        this.textField.setFont(new Font("Arial", 1, 15));
        this.textField.setEditable(false);
        this.textField.setHorizontalAlignment(4);
        this.frame.add(this.textField);
        this.onRadioButton.setBounds(30, 95, 60, 40);
        this.onRadioButton.setSelected(true);
        this.onRadioButton.setFont(new Font("Arial", 1, 20));
        this.onRadioButton.setBackground(Color.black);
        this.onRadioButton.setForeground(Color.white);
        this.frame.add(this.onRadioButton);
        this.offRadioButton.setBounds(30, 150, 60, 40);
        this.offRadioButton.setSelected(false);
        this.offRadioButton.setFont(new Font("Arial", 1, 20));
        this.offRadioButton.setBackground(Color.black);
        this.offRadioButton.setForeground(Color.white);
        this.frame.add(this.offRadioButton);
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(this.onRadioButton);
        buttonGroup.add(this.offRadioButton);
        this.buttonSeven.setBounds(10, 230, 60, 40);
        this.buttonSeven.setFont(new Font("Arial", 1, 15));
        this.buttonSeven.setBackground(new Color(255, 182, 193));
        this.frame.add(this.buttonSeven);
        this.buttonEight.setBounds(80, 230, 60, 40);
        this.buttonEight.setFont(new Font("Arial", 1, 15));
        this.buttonEight.setBackground(new Color(255, 182, 193));
        this.frame.add(this.buttonEight);
        this.buttonNine.setBounds(150, 230, 60, 40);
        this.buttonNine.setFont(new Font("Arial", 1, 15));
        this.buttonNine.setBackground(new Color(255, 182, 193));
        this.frame.add(this.buttonNine);
        this.buttonFour.setBounds(10, 290, 60, 40);
        this.buttonFour.setFont(new Font("Arial", 1, 15));
        this.buttonFour.setBackground(new Color(255, 182, 193));
        this.frame.add(this.buttonFour);
        this.buttonFive.setBounds(80, 290, 60, 40);
        this.buttonFive.setFont(new Font("Arial", 1, 15));
        this.buttonFive.setBackground(new Color(255, 182, 193));
        this.frame.add(this.buttonFive);
        this.buttonSix.setBounds(150, 290, 60, 40);
        this.buttonSix.setFont(new Font("Arial", 1, 15));
        this.buttonSix.setBackground(new Color(255, 182, 193));
        this.frame.add(this.buttonSix);
        this.buttonOne.setBounds(10, 350, 60, 40);
        this.buttonOne.setFont(new Font("Arial", 1, 15));
        this.buttonOne.setBackground(new Color(255, 182, 193));
        this.frame.add(this.buttonOne);
        this.buttonTwo.setBounds(80, 350, 60, 40);
        this.buttonTwo.setFont(new Font("Arial", 1, 15));
        this.buttonTwo.setBackground(new Color(255, 182, 193));
        this.frame.add(this.buttonTwo);
        this.buttonThree.setBounds(150, 350, 60, 40);
        this.buttonThree.setFont(new Font("Arial", 1, 15));
        this.buttonThree.setBackground(new Color(255, 182, 193));
        this.frame.add(this.buttonThree);
        this.buttonDot.setBounds(150, 410, 60, 40);
        this.buttonDot.setFont(new Font("Arial", 1, 15));
        this.frame.add(this.buttonDot);
        this.buttonZero.setBounds(10, 410, 130, 40);
        this.buttonZero.setFont(new Font("Arial", 1, 15));
        this.buttonZero.setBackground(new Color(255, 182, 193));
        this.frame.add(this.buttonZero);
        this.buttonEqual.setBounds(290, 350, 60, 100);
        this.buttonEqual.setFont(new Font("Arial", 1, 15));
        this.buttonEqual.setBackground(new Color(239, 188, 2));
        this.frame.add(this.buttonEqual);
        this.buttonDiv.setBounds(290, 110, 60, 40);
        this.buttonDiv.setFont(new Font("Arial", 1, 15));
        this.buttonDiv.setBackground(new Color(239, 188, 2));
        this.frame.add(this.buttonDiv);
        this.buttonMul.setBounds(290, 230, 60, 40);
        this.buttonMul.setFont(new Font("Arial", 1, 15));
        this.buttonMul.setBackground(new Color(239, 188, 2));
        this.frame.add(this.buttonMul);
        this.buttonMinus.setBounds(290, 170, 60, 40);
        this.buttonMinus.setFont(new Font("Arial", 1, 15));
        this.buttonMinus.setBackground(new Color(239, 188, 2));
        this.frame.add(this.buttonMinus);
        this.buttonPlus.setBounds(290, 290, 60, 40);
        this.buttonPlus.setFont(new Font("Arial", 1, 15));
        this.buttonPlus.setBackground(new Color(239, 188, 2));
        this.frame.add(this.buttonPlus);
        this.buttonDelete.setBounds(220, 110, 60, 40);
        this.buttonDelete.setFont(new Font("Arial", 1, 12));
        this.buttonDelete.setBackground(Color.red);
        this.buttonDelete.setForeground(Color.white);
        this.frame.add(this.buttonDelete);
        this.buttonClear.setBounds(150, 110, 60, 40);
        this.buttonClear.setFont(new Font("Arial", 1, 12));
        this.buttonClear.setBackground(Color.red);
        this.buttonClear.setForeground(Color.white);
        this.frame.add(this.buttonClear);
        this.buttonFib1.setBounds(220, 170, 60, 40);
        this.buttonFib1.setFont(new Font("Arial", 1, 15));
        this.frame.add(this.buttonFib1);
        this.buttonFact.setBounds(220, 230, 60, 40);
        this.buttonFact.setFont(new Font("Arial", 1, 20));
        this.frame.add(this.buttonFact);
        this.buttonPower.setBounds(220, 290, 60, 40);
        this.buttonPower.setFont(new Font("Arial", 1, 15));
        this.frame.add(this.buttonPower);
        this.buttonTen.setBounds(220, 350, 60, 40);
        this.buttonTen.setFont(new Font("Arial", 1, 15));
        this.frame.add(this.buttonTen);
        this.buttonPow.setBounds(220, 410, 60, 40);
        this.buttonPow.setFont(new Font("Arial", 1, 15));
        this.frame.add(this.buttonPow);
        this.buttonSquare.setBounds(150, 170, 60, 40);
        this.buttonSquare.setFont(new Font("Arial", 1, 12));
        this.frame.add(this.buttonSquare);
    }

    public int findIndex(int n) {
        if (n <= 1) {
            return n;
        } else {
            int a = 0;
            int b = 1;
            int c = 1;

            int res;
            for(res = 1; c < n; b = c) {
                c = a + b;
                ++res;
                a = b;
            }

            return res;
        }
    }

    public int factorial(int n) {
        return n == 0 ? 1 : n * this.factorial(n - 1);
    }

    public static double power(double a, int b) {
        double power = 1.0;

        for(int c = 0; c < b; ++c) {
            power *= a;
        }

        return power;
    }

    public void addActionEvent() {
        this.onRadioButton.addActionListener(this);
        this.offRadioButton.addActionListener(this);
        this.buttonClear.addActionListener(this);
        this.buttonDelete.addActionListener(this);
        this.buttonDiv.addActionListener(this);
        this.buttonMinus.addActionListener(this);
        this.buttonSeven.addActionListener(this);
        this.buttonEight.addActionListener(this);
        this.buttonNine.addActionListener(this);
        this.buttonMul.addActionListener(this);
        this.buttonFour.addActionListener(this);
        this.buttonFive.addActionListener(this);
        this.buttonSix.addActionListener(this);
        this.buttonPlus.addActionListener(this);
        this.buttonOne.addActionListener(this);
        this.buttonTwo.addActionListener(this);
        this.buttonThree.addActionListener(this);
        this.buttonEqual.addActionListener(this);
        this.buttonZero.addActionListener(this);
        this.buttonDot.addActionListener(this);
        this.buttonFib1.addActionListener(this);
        this.buttonFact.addActionListener(this);
        this.buttonPower.addActionListener(this);
        this.buttonTen.addActionListener(this);
        this.buttonPow.addActionListener(this);
        this.buttonSquare.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        String number1send;
        String number2send;

        Object source = e.getSource();
        if (source == this.onRadioButton) {
            this.enable();
        } else if (source == this.offRadioButton) {
            this.disable();
        } else if (source == this.buttonClear) {
            this.label.setText("");
            this.textField.setText("");
        } else {
            int number2;
            if (source == this.buttonDelete) {
                int length = this.textField.getText().length();
                number2 = length - 1;
                if (length > 0) {
                    StringBuilder back = new StringBuilder(this.textField.getText());
                    back.deleteCharAt(number2);
                    this.textField.setText(back.toString());
                }

                if (this.textField.getText().endsWith("")) {
                    this.label.setText("");
                }
            } else if (source == this.buttonZero) {
                if (this.textField.getText().equals("0")) {
                    return;
                }

                this.textField.setText(this.textField.getText() + "0");
            } else if (source == this.buttonOne) {
                this.textField.setText(this.textField.getText() + "1");
            } else if (source == this.buttonTwo) {
                this.textField.setText(this.textField.getText() + "2");
            } else if (source == this.buttonThree) {
                this.textField.setText(this.textField.getText() + "3");
            } else if (source == this.buttonFour) {
                this.textField.setText(this.textField.getText() + "4");
            } else if (source == this.buttonFive) {
                this.textField.setText(this.textField.getText() + "5");
            } else if (source == this.buttonSix) {
                this.textField.setText(this.textField.getText() + "6");
            } else if (source == this.buttonSeven) {
                this.textField.setText(this.textField.getText() + "7");
            } else if (source == this.buttonEight) {
                this.textField.setText(this.textField.getText() + "8");
            } else if (source == this.buttonNine) {
                this.textField.setText(this.textField.getText() + "9");
            } else if (source == this.buttonDot) {
                if (this.textField.getText().contains(".")) {
                    return;
                }

                this.textField.setText(this.textField.getText() + ".");
            } else {
                String str;
                if (source == this.buttonPlus) {
                    str = this.textField.getText();
                    this.number = Double.parseDouble(this.textField.getText());
                    this.textField.setText("");
                    this.label.setText(str + "+");
                    this.calculation = 1;
                } else if (source == this.buttonMinus) {
                    str = this.textField.getText();
                    this.number = Double.parseDouble(this.textField.getText());
                    this.textField.setText("");
                    this.label.setText(str + "-");
                    this.calculation = 2;
                } else if (source == this.buttonMul) {
                    str = this.textField.getText();
                    this.number = Double.parseDouble(this.textField.getText());
                    this.textField.setText("");
                    this.label.setText(str + "X");
                    this.calculation = 3;
                } else if (source == this.buttonPow) {
                    str = this.textField.getText();
                    this.number = Integer.parseInt(this.textField.getText());
                    this.textField.setText("");
                    this.label.setText(str + "^");
                    this.calculation = 4;
                } else if (source == this.buttonDiv) {
                    str = this.textField.getText();
                    this.number = Double.parseDouble(this.textField.getText());
                    this.textField.setText("");
                    this.label.setText(str + "/");
                    this.calculation = 5;
                } else if (source == this.buttonEqual) {
                    switch (this.calculation) {
                        case 1:
                            this.answer = this.number + Double.parseDouble(this.textField.getText());
                             number1send = String.valueOf((int)(this.number));
                             number2send = String.valueOf(Integer.parseInt(this.textField.getText()));
                            AssemblyGenerator.twoNumberOperation("src\\plus.txt", "adunare", "@A", number1send, "@B", number2send );
                            Assembler.assembleGeneratedAssembly("adunare.asm");

                            if (Double.toString(this.answer).endsWith(".0")) {
                                this.textField.setText(Double.toString(this.answer).replace(".0", ""));
                            } else {
                                this.textField.setText(Double.toString(this.answer));
                            }

                            this.label.setText("");
                            break;
                        case 2:
                            this.answer = this.number - Double.parseDouble(this.textField.getText());
                            number1send = String.valueOf((int)(this.number));
                            number2send = String.valueOf(Integer.parseInt(this.textField.getText()));
                            AssemblyGenerator.twoNumberOperation("src\\minus.txt", "scadere", "@A", number1send, "@B", number2send );if (Double.toString(this.answer).endsWith(".0")) {
                                this.textField.setText(Double.toString(this.answer).replace(".0", ""));
                            } else {
                                this.textField.setText(Double.toString(this.answer));
                            }

                            this.label.setText("");
                            break;
                        case 3:
                            this.answer = this.number * Double.parseDouble(this.textField.getText());
                            number1send = String.valueOf((int)(this.number));
                            number2send = String.valueOf(Integer.parseInt(this.textField.getText()));
                            AssemblyGenerator.twoNumberOperation("src\\inmultire.txt", "inmultire", "@A", number1send, "@B", number2send );
                            if (Double.toString(this.answer).endsWith(".0")) {
                                this.textField.setText(Double.toString(this.answer).replace(".0", ""));
                            } else {
                                this.textField.setText(Double.toString(this.answer));
                            }

                            this.label.setText("");
                            break;
                        case 4:
                            this.answer = power(this.number, Integer.parseInt(this.textField.getText()));
                            number1send = String.valueOf((int)(this.number));
                            number2send = String.valueOf(Integer.parseInt(this.textField.getText()));
                            AssemblyGenerator.twoNumberOperation("src\\putere.txt", "putere", "@A", number1send, "@B", number2send );
                            if (Double.toString(this.answer).endsWith(".0")) {
                                this.textField.setText(Double.toString(this.answer).replace(".0", ""));
                            } else {
                                this.textField.setText(Double.toString(this.answer));
                            }

                            this.label.setText("");
                            break;
                        case 5:
                            this.answer = this.number / Double.parseDouble(this.textField.getText());
                            number1send = String.valueOf((int)(this.number));
                            number2send = String.valueOf(Integer.parseInt(this.textField.getText()));
                            AssemblyGenerator.twoNumberOperation("src\\impartire.txt", "impartire", "@A", number1send, "@B", number2send );
                            if (Double.toString(this.answer).endsWith(".0")) {
                                this.textField.setText(Double.toString(this.answer).replace(".0", ""));
                            } else {
                                this.textField.setText(Double.toString(this.answer));
                            }

                            this.label.setText("");
                    }
                } else {
                    int rez;
                    if (source == this.buttonFib1) {
                        str = this.textField.getText();
                        number2 = Integer.parseInt(this.textField.getText());
                        number1send = String.valueOf(Integer.parseInt(this.textField.getText()));
                        AssemblyGenerator.oneNumberOperation("src\\aux.txt", "fibonaci1", "@A", number1send);
                        rez = this.findIndex(number2);
                        this.textField.setText(Integer.toString(rez));
                    } else if (source == this.buttonFact) {
                        str = this.textField.getText();
                        number2 = Integer.parseInt(this.textField.getText());
                        number1send = String.valueOf(Integer.parseInt(this.textField.getText()));
                        AssemblyGenerator.oneNumberOperation("src\\aux.txt", "factorial", "@A", number1send);
                        rez = this.factorial(number2);
                        this.textField.setText(Integer.toString(rez));
                    } else {
                        double rez2;
                        if (source == this.buttonPower) {
                            str = this.textField.getText();
                            number2 = Integer.parseInt(this.textField.getText());
                            number1send = String.valueOf(Integer.parseInt(this.textField.getText()));
                            AssemblyGenerator.oneNumberOperation("src\\putere2.txt", "putere2", "@A", number1send);
                            rez2 = power(2.0, number2);
                            this.textField.setText(Double.toString(rez2));
                        } else if (source == this.buttonTen) {
                            str = this.textField.getText();
                            number2 = Integer.parseInt(this.textField.getText());
                            number1send = String.valueOf(Integer.parseInt(this.textField.getText()));
                            AssemblyGenerator.oneNumberOperation("src\\putere10.txt", "putere10", "@A", number1send);
                            rez2 = power(10.0, number2);
                            this.textField.setText(Double.toString(rez2));
                        } else if (source == this.buttonSquare) {
                            str = this.textField.getText();
                            number2 = Integer.parseInt(this.textField.getText());
                            number1send = String.valueOf(Integer.parseInt(this.textField.getText()));
                            AssemblyGenerator.twoNumberOperation("src\\inmultire.txt", "patrat", "@A", number1send, "@B", number1send);
                            rez2 = power((double)number2, 2);
                            this.textField.setText(Double.toString(rez2));
                        }
                    }
                }
            }
        }

    }

    public void enable() {
        this.onRadioButton.setEnabled(false);
        this.offRadioButton.setEnabled(true);
        this.textField.setEnabled(true);
        this.label.setEnabled(true);
        this.buttonClear.setEnabled(true);
        this.buttonDelete.setEnabled(true);
        this.buttonDiv.setEnabled(true);
        this.buttonMinus.setEnabled(true);
        this.buttonSeven.setEnabled(true);
        this.buttonEight.setEnabled(true);
        this.buttonNine.setEnabled(true);
        this.buttonMul.setEnabled(true);
        this.buttonFour.setEnabled(true);
        this.buttonFive.setEnabled(true);
        this.buttonSix.setEnabled(true);
        this.buttonPlus.setEnabled(true);
        this.buttonOne.setEnabled(true);
        this.buttonTwo.setEnabled(true);
        this.buttonThree.setEnabled(true);
        this.buttonEqual.setEnabled(true);
        this.buttonZero.setEnabled(true);
        this.buttonDot.setEnabled(true);
        this.buttonFib1.setEnabled(true);
        this.buttonFact.setEnabled(true);
        this.buttonPower.setEnabled(true);
        this.buttonTen.setEnabled(true);
        this.buttonPow.setEnabled(true);
        this.buttonSquare.setEnabled(true);
    }

    public void disable() {
        this.onRadioButton.setEnabled(true);
        this.offRadioButton.setEnabled(false);
        this.textField.setText("");
        this.label.setText(" ");
        this.buttonClear.setEnabled(false);
        this.buttonDelete.setEnabled(false);
        this.buttonDiv.setEnabled(false);
        this.buttonMinus.setEnabled(false);
        this.buttonSeven.setEnabled(false);
        this.buttonEight.setEnabled(false);
        this.buttonNine.setEnabled(false);
        this.buttonMul.setEnabled(false);
        this.buttonFour.setEnabled(false);
        this.buttonFive.setEnabled(false);
        this.buttonSix.setEnabled(false);
        this.buttonPlus.setEnabled(false);
        this.buttonOne.setEnabled(false);
        this.buttonTwo.setEnabled(false);
        this.buttonThree.setEnabled(false);
        this.buttonEqual.setEnabled(false);
        this.buttonZero.setEnabled(false);
        this.buttonDot.setEnabled(false);
        this.buttonFib1.setEnabled(false);
        this.buttonFact.setEnabled(false);
        this.buttonPower.setEnabled(false);
        this.buttonTen.setEnabled(false);
        this.buttonPow.setEnabled(false);
        this.buttonSquare.setEnabled(false);
    }
}
