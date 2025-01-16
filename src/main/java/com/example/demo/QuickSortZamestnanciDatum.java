package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
@Component
public class QuickSortZamestnanciDatum {
    QuickSortZamestnanciDatum(){}
    private Repo repo;
    @Autowired
    QuickSortZamestnanciDatum(Repo repo){
        this.repo = repo;
    }

    public List<String> sortAll(){
        List<Integer> arr = new ArrayList<>();
        List<String> menoZor = new ArrayList<>();
        HashMap<Integer,String> rokMeno= new HashMap<>();
        try {
            Iterable<Zamestnanec> vsetky = repo.findAll();
            for (Zamestnanec z : vsetky) {
                Integer rokr = rok(z.getRodneCislo());
                Integer mes = mesiac(z.getRodneCislo());
                Integer den = VratDen(z.getRodneCislo());
                rokr *= 100;
                rokr += mes;
                rokr *= 100;
                rokr +=den;
                arr.add(rokr);
                rokMeno.put(rokr,z.getName());


            }
            quickSort(arr, 0, arr.size() - 1);
            for (Integer datum : arr) {
                if(rokMeno.containsKey(datum)){menoZor.add(rokMeno.get(datum));}
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return  menoZor;
    }
    private int rok(String rodcis) {
        String trimmedRodcis = rodcis.trim();

        char[] pom = new char[2];
        int int_pom;

        pom[0] = trimmedRodcis.charAt(0);
        pom[1] = trimmedRodcis.charAt(1);
        String pomII = new String(pom);

        try {
            int_pom = Integer.parseInt(pomII);
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return -1;
        }

        if (int_pom < 15) {
            return int_pom + 2000; // 2000 - 2014
        } else {
            return int_pom + 1900; // 1915 - 1999
        }
    }
    private int mesiac(String rodcis) {

        rodcis = rodcis.trim();

        char[] pom = new char[2];
        pom[0] = rodcis.charAt(2);
        pom[1] = rodcis.charAt(3);

        try {
            int year = Integer.parseInt(new String(pom));
            if (VratPohlavie(rodcis) == 0) {
                return year - 50;
            } else {
                return year;
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return -1;
        }
    }
    private int VratPohlavie(String rodcis) {
        rodcis = rodcis.trim();

        char[] pom = new char[2];
        pom[0] = rodcis.charAt(2);
        pom[1] = rodcis.charAt(3);

        try {
            int year = Integer.parseInt(new String(pom));
            return (year > 50) ? 0 : 1;
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return -1;
        }
    }

    private int VratDen(String rodcis){
        char[] pom = new char[3];
        pom[0] = rodcis.charAt(4);
        pom[1] = rodcis.charAt(5);
        pom[2] = '\0';
        String pomString = new String(pom).trim();
        return Integer.parseInt(pomString);
    }

    /*xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxQuickSortxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx*/
    public static void quickSort(List<Integer> arr, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(arr, low, high);
            quickSort(arr, low, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, high);
        }
    }

    public static int partition(List<Integer> arr, int low, int high) {
        int pivot = arr.get(high);
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr.get(j) < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    public static void swap(List<Integer> arr, int i, int j) {
        int temp = arr.get(i);
        arr.set(i, arr.get(j));
        arr.set(j, temp);
    }



}
