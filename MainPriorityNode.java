/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mainprioritynode;
import java.util.Scanner;
/**
 *
 * @author Arturo González
 */
public class MainPriorityNode {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        PriorityQueue pq = new PriorityQueue(10);
        
        while (true) {
            System.out.println("\n=== MENU ===");
            System.out.println("1) push (agregar)");
            System.out.println("2) pop (eliminar con mayor prioridad)");
            System.out.println("3) show (mostrar contenido)");
            System.out.println("4) peek (ver siguiente sin eliminar)");
            System.out.println("5) salir");
            System.out.print("Elige una opción: ");
            
            String opStr = sc.nextLine().trim();
            int op;
            try { op = Integer.parseInt(opStr); } 
            catch (Exception e) { System.out.println("Opción inválida."); continue; }
            
            switch (op) {
                case 1:
                    System.out.print("Valor (String): ");
                    String value = sc.nextLine();
                    System.out.print("Prioridad (entero; menor = mayor prioridad): ");
                    String priStr = sc.nextLine().trim();
                    int pri;
                    try { pri = Integer.parseInt(priStr); }
                    catch (Exception e) { System.out.println("Prioridad inválida."); break; }
                    pq.push(pri, value);
                    System.out.println("Elemento insertado.");
                    break;
                case 2:
                    String removed = pq.pop();
                    if (removed == null) System.out.println("La cola está vacía.");
                    else System.out.println("Se eliminó: " + removed);
                    break;
                case 3:
                    pq.show();
                    break;
                case 4:
                    String top = pq.peek();
                    if (top == null) System.out.println("La cola está vacía.");
                    else System.out.println("Siguiente en salir: " + top);
                    break;
                case 5:
                    System.out.println("¡Hasta luego!");
                    sc.close();
                    return;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }
}
        
    
   

