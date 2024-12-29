package aplikasipenjualanbuku.utils;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.awt.print.*;
import java.awt.*;
import javax.swing.JTable;
import java.text.SimpleDateFormat;
import java.util.Date;


public class TransactionPrinter implements Printable {
    
private JTable table;
    private static final int MARGIN = 50;
    
    public TransactionPrinter(JTable table) {
        this.table = table;
    }

    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        if (pageIndex > 0) {
            return NO_SUCH_PAGE;
        }

        Graphics2D g2d = (Graphics2D) graphics;
        g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());

        // Set font for title
        g2d.setFont(new Font("Arial", Font.BOLD, 16));
        FontMetrics fm = g2d.getFontMetrics();
        
        // Calculate center position for title
        String title = "LAPORAN TRANSAKSI PENJUALAN BUKU";
        int titleWidth = fm.stringWidth(title);
        int centerX = ((int) pageFormat.getImageableWidth() - titleWidth) / 2;
        
        // Draw title
        g2d.drawString(title, centerX, 40);

        // Set font for table headers
        g2d.setFont(new Font("Arial", Font.BOLD, 12));
        fm = g2d.getFontMetrics();
        
        // Draw current date
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String date = "Tanggal Cetak: " + sdf.format(new Date());
        g2d.drawString(date, MARGIN, 60);

        // Calculate column widths
        int[] columnWidths = {80, 120, 120, 80, 120}; // Adjust for ID, Tanggal, ID Buku, Jumlah, Total Harga
        int startY = 100;
        int startX = MARGIN;

        // Draw table headers
        String[] headers = {"ID TRANS", "TANGGAL", "ID BUKU", "JUMLAH", "TOTAL HARGA"};
        int currentX = startX;
        for (int i = 0; i < headers.length; i++) {
            g2d.drawString(headers[i], currentX, startY);
            currentX += columnWidths[i];
        }

        // Draw horizontal line under headers
        g2d.drawLine(startX, startY + 5, currentX - 30, startY + 5);

        // Set font for table content
        g2d.setFont(new Font("Arial", Font.PLAIN, 12));
        
        // Draw table content
        int rowHeight = 20;
        int currentY = startY + 25;
        double totalPenjualan = 0;
        
        for (int row = 0; row < table.getRowCount(); row++) {
            currentX = startX;
            for (int col = 0; col < table.getColumnCount(); col++) {
                Object value = table.getValueAt(row, col);
                String text = value != null ? value.toString() : "";
                
                // Format currency for price column
                if (col == 4) { // Total Harga column
                    try {
                        double price = Double.parseDouble(text);
                        totalPenjualan += price;
                        text = String.format("Rp %.2f", price);
                    } catch (NumberFormatException e) {
                        // Keep original text if parsing fails
                    }
                }
                
                g2d.drawString(text, currentX, currentY);
                currentX += columnWidths[col];
            }
            currentY += rowHeight;
        }

        // Draw total line
        currentY += 10;
        g2d.drawLine(startX, currentY, currentX - 30, currentY);
        currentY += 20;
        
        // Draw total penjualan
        g2d.setFont(new Font("Arial", Font.BOLD, 12));
        String totalText = String.format("Total Penjualan: Rp %.2f", totalPenjualan);
        g2d.drawString(totalText, startX, currentY);

        // Draw page number
        String pageNumber = "Halaman 1";
        g2d.drawString(pageNumber, 
            ((int) pageFormat.getImageableWidth() - fm.stringWidth(pageNumber)) / 2,
            (int) pageFormat.getImageableHeight() - 20);

        return PAGE_EXISTS;
    }
}

