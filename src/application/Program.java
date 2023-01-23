package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.dao.impl.SellerDaoJDBC;
import model.entities.Department;
import model.entities.Seller;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

       DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
       SellerDao sellerDao = DaoFactory.creatSellerDao();

       System.out.println("=== TEST 1: seller findById ===");
       Seller seller = sellerDao.findById(3);
       System.out.println(seller);
       
       System.out.println("\n=== TEST 2: seller findByDepartment ===");
       Department department = new Department(2, null);
       List<Seller> list = sellerDao.findByDepartment(department);

       for (Seller obj : list) {
        System.out.println(obj);
       }

       System.out.println("\n=== TEST 3: seller findAll ===");       
       list = sellerDao.findAll();
       
       for (Seller obj : list) {
           System.out.println(obj);
        }
        System.out.println("\n=== TEST 4: seller insert ===");  
        Seller newSeller    = new Seller(null, "Greg", "greg@gmail.com", LocalDate.parse("28/01/1987", fmt), 4000.0, department);
        sellerDao.insert(newSeller);
        System.out.println("Inserted, new seller = " + newSeller.getId());
        
        System.out.println("\n=== TEST 5: seller update ==="); 
        seller = sellerDao.findById(1);
        seller.setName("Maria Wayne");
        sellerDao.update(seller);
        System.out.println("Update Completed");
        
        System.out.println("\n=== TEST 6: seller delete ==="); 
        System.out.print("Enter id for delete test: ");
        int id = sc.nextInt();
        sellerDao.deleteById(id);
        System.out.println("Delete completed");
        sc.close();

    }
}
