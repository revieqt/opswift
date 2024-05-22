package reciept;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.print.*;

public class ReceiptPrinter implements Printable {

    private DefaultTableModel model;
    private String grandTotal;
    private double payment;
    private double change;

    public ReceiptPrinter(DefaultTableModel model, String grandTotal, double payment, double change) {
        this.model = model;
        this.grandTotal = grandTotal;
        this.payment = payment;
        this.change = change;
    }

    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        if (pageIndex > 0) {
            return NO_SUCH_PAGE;
        }

        Graphics2D g2d = (Graphics2D) graphics;
        g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());

        int y = 20; // Adjust the starting y position

        Font font = new Font("Times New Roman", Font.PLAIN, 8); // Adjust font and size

        g2d.setFont(font);

        g2d.drawString("Your Store Name", 10, y);
        y += 10; // Adjust vertical spacing
        g2d.drawString("--------------------------------", 10, y);
        y += 10;

        FontMetrics fm = g2d.getFontMetrics(font);

        for (int i = 0; i < model.getRowCount(); i++) {
            String name = (String) model.getValueAt(i, 1);
            double price = (double) model.getValueAt(i, 2);
            int quantity = (int) model.getValueAt(i, 3);
            double total = (double) model.getValueAt(i, 4);

            int startX = 10;
            int maxWidth = (int) pageFormat.getImageableWidth() - 10;

            // Wrap the text if it's too wide
            int lineHeight = fm.getHeight();
            int lineWidth = 0;
            StringBuilder line = new StringBuilder();

            for (char c : name.toCharArray()) {
                int charWidth = fm.charWidth(c);
                if (lineWidth + charWidth > maxWidth) {
                    g2d.drawString(line.toString(), startX, y);
                    y += lineHeight;
                    lineWidth = 0;
                    line = new StringBuilder();
                }
                line.append(c);
                lineWidth += charWidth;
            }
            if (line.length() > 0) {
                g2d.drawString(line.toString(), startX, y);
                y += lineHeight;
            }

            g2d.drawString("Price: " + price, 10, y);
            g2d.drawString("Qty: " + quantity, 50, y); // Adjust positions
            g2d.drawString("Total: " + total, 80, y); // Adjust positions
            y += 10; // Adjust vertical spacing
        }

        // Print transaction total
        g2d.drawString("Total: " + grandTotal, 10, y);
        y += 10; // Adjust vertical spacing

        // Print payment and change
        g2d.drawString("Payment: " + payment, 10, y);
        y += 10; // Adjust vertical spacing
        g2d.drawString("Change: " + change, 10, y);
        y += 10; // Adjust vertical spacing

        return PAGE_EXISTS;
    }

    public void printReceipt() {
        PrinterJob job = PrinterJob.getPrinterJob();
        PageFormat pageFormat = job.defaultPage();
        Paper paper = pageFormat.getPaper();
        paper.setSize(158.0, 1000.0); // Adjust paper size to 58mm width
        pageFormat.setPaper(paper);
        job.setPrintable(this, pageFormat);
        try {
            job.print();
        } catch (PrinterException e) {
            e.printStackTrace();
        }
    }
}