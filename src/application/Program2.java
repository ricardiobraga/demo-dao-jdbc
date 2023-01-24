package application;

import java.util.ArrayList;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {
    public static void main(String[] args) {

        DepartmentDao departmentDao = DaoFactory.creatDepartmentDao();
        
        List<Department> list = new ArrayList<>();
        
        
        System.out.println("=== TEST 1: department findById ===");
        Department department = departmentDao.findById(2);
        System.out.println(department);
        

        System.out.println("\n=== TEST 3: seller findAll ===");       
        list = departmentDao.findAll();

        for (Department dep : list) {
            System.out.println(dep);
         }
    }
}
