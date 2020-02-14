/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.arep.app;

import java.util.List;

/**
 *
 * @author sarah.vieda
 */

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Ordena {
    

    public static void mergeSort(int[] lista, int n){
        if(n<2){
            return;
        }
        int media = n/2;
        int [] l= new int [media];
        int [] r= new int [n-media];
        for(int i=0; i<media;i++){
          l[i]=lista[i];
        }
        for(int j=media;j<n;j++){
           r[j-media]=lista[j];
        }
        mergeSort(l,media);
        mergeSort(r,n-media);
        merge(lista,l,r,media,n-media);
    }
    
    public static void merge(int[]lista,int[]l,int[]r,int left, int right){
        int i=0,j=0,k=0;
        while(i<left && j<right){
            if (l[i] <= r[j]){
                lista[k++]=r[j++];
            }
            else{
                lista[k++]=l[i++];
            }
        }
        while(i<left){
            lista[k++]=l[i++];
        }
        while(j<right){
            lista[k++]=r[j++];
        }
    }
    
    public static int retornaSuma(int[]lista){
        int sumatoria=0;
        for (int i=0;i<lista.length;i++){
            sumatoria+=lista[i];
        }
        return sumatoria;
    }
    
    
    
}
