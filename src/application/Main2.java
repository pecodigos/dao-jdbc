package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

import java.util.List;
import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        System.out.println("===== TEST 1: department findById =====");
        Department department = departmentDao.findById(2);
        System.out.println(department);

        System.out.println("\n===== TEST 2: department findAll =====");
        List<Department> list = departmentDao.findAll();
        for (Department dep : list) {
            System.out.println(dep);
        }

        System.out.println("\n===== TEST 3: department insert =====");
        Department newDepartment = new Department(null, "Music");
        departmentDao.insert(newDepartment);
        System.out.println("Inserted! New id = " + newDepartment.getId());

        System.out.println("\n===== TEST 4: department update =====");
        department = departmentDao.findById(6);
        department.setName("Linux");
        departmentDao.update(department);
        System.out.println("Update completed.");

        System.out.println("\n===== TEST 5: department delete =====");
        System.out.print("Enter ID for DELETE test: ");
        int id = sc.nextInt();
        departmentDao.deleteById(id);
        System.out.println("Delete completed.");

        sc.close();
    }
}
