import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class project {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Food Menu");
            JPanel panel = new JPanel(new GridLayout(0, 1));

            frame.getContentPane().add(panel);

            frame.getContentPane().setBackground(Color.black);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            frame.setLayout(new FlowLayout());

            ImageIcon imageIcon1 = new ImageIcon("D:\\flatlay-iron-skillet-with-meat-and-other-food.jpg");
            Image image1 = imageIcon1.getImage().getScaledInstance(250, 300, Image.SCALE_SMOOTH);
            ImageIcon scaledImageIcon1 = new ImageIcon(image1);
            JLabel imageLabel1 = new JLabel(scaledImageIcon1);
            frame.add(imageLabel1);

            // Create checkboxes for food items
            JCheckBox burgerCheckbox = new JCheckBox("Burger");
            JLabel burgerPriceLabel = new JLabel("Price: Rs. 80.00");
            panel.add(burgerCheckbox);
            panel.add(burgerPriceLabel);

            JCheckBox pizzaCheckbox = new JCheckBox("Pizza");
            JLabel pizzaPriceLabel = new JLabel("Price: Rs. 180.00");
            panel.add(pizzaCheckbox);
            panel.add(pizzaPriceLabel);

            JCheckBox icecreamCheckbox = new JCheckBox("Vanilla Ice Cream");
            JLabel icecreamPriceLabel = new JLabel("Price: Rs. 50.00");
            panel.add(icecreamCheckbox);
            panel.add(icecreamPriceLabel);

            JCheckBox pastaCheckbox = new JCheckBox("Pasta");
            JLabel pastaPriceLabel = new JLabel("Price: Rs. 100.00");
            panel.add(pastaCheckbox);
            panel.add(pastaPriceLabel);

            JCheckBox coffeeCheckbox = new JCheckBox("Coffee");
            JLabel coffeePriceLabel = new JLabel("Price: Rs. 90.00");
            panel.add(coffeeCheckbox);
            panel.add(coffeePriceLabel);

            JCheckBox saladCheckbox = new JCheckBox("Salad");
            JLabel saladPriceLabel = new JLabel("Price: Rs. 60.00");
            panel.add(saladCheckbox);
            panel.add(saladPriceLabel);

            // Create a button to generate the bill
            JButton generateBillButton = new JButton("Generate Bill");

            // Add action listener to the button
            generateBillButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Generate the bill and display it in a new frame
                    JFrame billFrame = new JFrame("Bill");
                    billFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    billFrame.setLayout(new FlowLayout());

                    // Calculate the total based on selected items
                    double total = 0.0;
                    if (burgerCheckbox.isSelected()) {
                        total += 80.00; // Add burger price
                    }
                    if (pizzaCheckbox.isSelected()) {
                        total += 180.00; // Add pizza price
                    }
                    if (coffeeCheckbox.isSelected()) {
                        total += 90.00;
                    }
                    if (pastaCheckbox.isSelected()) {
                        total += 100.00;
                    }
                    if (saladCheckbox.isSelected()) {
                        total += 60.00; // Add salad price
                    }
                    if (icecreamCheckbox.isSelected()) {
                        total += 50.00;
                    }

                    // Display the total in a label
                    JLabel totalLabel = new JLabel("Total: Rs. " + total);
                    billFrame.add(totalLabel);

                    // Load and set size for the image
                    ImageIcon imageIcon = new ImageIcon("D:\\bc25de1bfe3464f92ed45a7f3f58b200.jpg");
                    Image image = imageIcon.getImage().getScaledInstance(400, 400, Image.SCALE_SMOOTH); // Adjust the width and height as needed
                    ImageIcon scaledImageIcon = new ImageIcon(image);
                    JLabel imageLabel = new JLabel(scaledImageIcon);
                    billFrame.add(imageLabel);

                    // Set size and make the frame visible
                    billFrame.setSize(450, 500);
                    billFrame.getContentPane().setBackground(Color.PINK);
                    billFrame.setVisible(true);
                }
            });

            // Add the button to the frame
            panel.add(generateBillButton);

            // Set size and make the frame visible
            frame.setSize(400, 400);
            frame.setVisible(true);
        });
    }
}