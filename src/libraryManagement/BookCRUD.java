package libraryManagement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BookCRUD {

    // adding a book
    public static void addBook(Book book) {
        String sql = "INSERT INTO books (title, author, year) VALUES (?, ?, ?)";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, book.getTitle());
            pstmt.setString(2, book.getAuthor());
            pstmt.setInt(3, book.getYear());
            
            int rows = pstmt.executeUpdate();
            System.out.println(rows + " book added");
            
        } catch (SQLException e) {
            System.err.println("Error adding book: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Reading all the books
    public static void readBooks() {
        String sql = "SELECT * FROM books";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            
            System.out.println("All books in the library:");
            boolean hasBooks = false;
            while (rs.next()) {
                hasBooks = true;
                System.out.println(
                    rs.getInt("id") + " | " +
                    rs.getString("title") + " | " +
                    rs.getString("author") + " | " +
                    rs.getInt("year")
                );
            }
            
            if (!hasBooks) {
                System.out.println("No books found in the library.");
            }
            
        } catch (SQLException e) {
            System.err.println("Error reading books: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Reading one book using id
    public static void readBookById(int id) {
        String sql = "SELECT * FROM books WHERE id = ?";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    System.out.println(
                        rs.getInt("id") + " | " +
                        rs.getString("title") + " | " +
                        rs.getString("author") + " | " +
                        rs.getInt("year")
                    );
                } else {
                    System.out.println("No book found with ID " + id);
                }
            }
            
        } catch (SQLException e) {
            System.err.println("Error reading book by ID: " + e.getMessage());
            e.printStackTrace();
        }
    }

    //Update book
    public static void updateBook(int id, String newTitle, String newAuthor, int newYear) {
        String sql = "UPDATE books SET title = ?, author = ?, year = ? WHERE id = ?";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, newTitle);
            pstmt.setString(2, newAuthor);
            pstmt.setInt(3, newYear);
            pstmt.setInt(4, id);
            
            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Book updated successfully!");
            } else {
                System.out.println("No book found with ID " + id);
            }
        } catch (SQLException e) {
            System.err.println("Error updating book: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Delete book
    public static void deleteBook(int id) {
        String sql = "DELETE FROM books WHERE id = ?";
        
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, id);
            
            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Book deleted successfully!");
            } else {
                System.out.println("No book found with ID " + id);
            }
        } catch (SQLException e) {
            System.err.println("Error deleting book: " + e.getMessage());
            e.printStackTrace();
        }
    }
}







