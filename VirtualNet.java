/*
 * Author: Yan Zhen Lin 
 *
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package virtualnet;

/**
 *
 * @author Yan
 */

import java.util.Scanner;
import java.io.*;
import java.io.File;

public class VirtualNet {
    
    private static Scanner scanner = new Scanner(System.in);
    private static LinkedList list;
    private static queue queResult;
    public static queue.Node queNode;
    private static File tempFile;
    public static queue que;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //list = new LinkedList();
        
        /*que = new queue();
        
        File f1, f2, f3, f4;
        f1 = new File("f1.txt");
        f2 = new File("f2.txt");
        f3 = new File("f3.txt");
        f4 = new File("f4.txt");
        */
        //System.out.println(f1.getAbsoluteFile());
        /*
        System.out.println(que.getSize());
        //que.enque("john");
        que.enque(f1);
        System.out.println(que.getSize());
        //que.enque("Jan");
        que.enque(f2);
        System.out.println(que.getSize());
        //que.enque("June");
        que.enque(f3);
        System.out.println(que.getSize());
        //que.enque("Juli");
        que.enque(f4);
        System.out.println(que.getSize());*/
        
        /*
        System.out.println(que.deque().getData());
        System.out.println(que.getSize());
        System.out.println(que.deque().getData());
        System.out.println(que.getSize());
        System.out.println(que.deque().getData());
        System.out.println(que.getSize());
        System.out.println(que.deque().getData());
        System.out.println(que.getSize());*/
        
        
        
        /*while(!que.isEmpty()){
            queNode = que.deque();
            System.out.println(que.getSize());
            Object obj = queNode.getData();
            System.out.println(obj.getClass());
            
        }*/
        
        NewThread sender = new NewThread("Sally");
        recieverThread reciever = new recieverThread("Tommy", Thread.currentThread());;
        if(sender.getThread().isAlive()){ 
            try{
                Thread.sleep(2000);
            }catch(Exception E){}
            //queResult = sender.getQue();
        }
        queResult = sender.getQue();
        while(!queResult.isEmpty()){
            queNode = queResult.deque();
            //System.out.println(queResult.getSize());
            //Object obj = queNode.getData();
            //System.out.println(queNode.getData());
            reciever.setQue(queNode);
            try{
                Thread.sleep(2500);
            }catch(Exception e){
            }
            //System.out.println(obj.getClass()); 
            //tempFile = obj;
            
        }        
        
        /*while(prompt()){
            prompt();
        }*/
        
        /*list.printList();
        System.out.println(list.getSize());*/
    }
    
    public static boolean prompt(){
        boolean ret = true;
        System.out.println("would you like to enter more Items, y/n");
        String choice = scanner.nextLine();
        if(choice.contains("y")){
            ret = true;
            System.out.println("enter a String: ");
            String data = scanner.nextLine();
            System.out.println("please enter the position to insert");
            int position = scanner.nextInt();    
            list.insert(data, position);
        }
        else
            ret = false;
        return ret;
    }
    
}