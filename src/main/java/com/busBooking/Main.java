package com.busBooking;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import org.hibernate.query.NativeQuery;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");
        EntityManager em = emf.createEntityManager();

        Thread.sleep(1000);
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter source : ");
        String start = sc.nextLine();
        drawLine();

        System.out.print("Enter destination : ");
        String end = sc.nextLine();
        drawLine();

        System.out.print("Enter Date('/' seperated) : ");
        String Date = sc.nextLine();
        drawLine();

        em.getTransaction().begin();

        Query q = em.createQuery("from BusTravelData Data where startLoc = :a and endLoc = :b");
        q.setParameter("a", start);
        q.setParameter("b", end);

        List<BusTravelData> data = (List<BusTravelData>) q.getResultList();

        int i=1;
        for(BusTravelData d : data){
            System.out.println(i+" "+d.getStartLoc() + " -> " + d.getEndLoc() +" // "+
                    d.getStartTime()+" -("+d.getDuration()+ " hrs)-> "+d.getEndTime()+" // "+
                    d.getBusType()+" Rs."+d.getPrice()+
                    " // Seats Avl : "+d.getAvlSeats()+"/"+d.getTotalSeats()+" // "+
                    d.getBusData().getBusName());
            i++;
        }

        System.out.print("Do you want to continue? (y/n) : ");

        char ch = sc.next().charAt(0);
        if(ch == 'y'){
            System.out.print("enter bus S.NO : ");
            int a = sc.nextInt();
            BusTravelData d = data.get(a-1);
            d.setAvlSeats(d.getAvlSeats()-1);
            System.out.println("Seated reserved !!");
            System.out.println("Your journey is on "+Date+" "+d.getStartTime()+" from "+d.getStartLoc()+" to "+d.getEndLoc());
            System.out.println("Have a happy journey");
            System.out.println("Thank you for booking with us");
        }
        else{
            System.out.println("Invalid input");
            System.out.println("terminating");
            return;
        }
        em.getTransaction().commit();
    }

    public static void drawLine(){
        System.out.println("-------------------------");
    }
}