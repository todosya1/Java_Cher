package _4_Mahsanit;
import unit4.collectionsLib.Stack;
/*
2. Опишите операции, которые привели к появлению следующего стека:
а. ABCDE (E на вершине стека) ------> ABE б. ABCG (G на вершине стека) ------> BG
3. Опишите последовательность операций, которая приведет к перевороту элементов в стеке.
 */

public class Mahsanit_d2 {
    public static void main(String[] args) {
        // Задача 2а: ABCDE -> ABE
        System.out.println("Задача 2а: ABCDE -> ABE");
        Stack<Character> stack1 = new Stack<>();
        // Создаем начальный стек ABCDE
        stack1.push('A');
        stack1.push('B');
        stack1.push('C');
        stack1.push('D');
        stack1.push('E');
        System.out.println("Начальный стек ABCDE:");
        printStack(stack1);

        // Преобразуем в ABE
        stack1.pop();  // удаляем E
        stack1.pop();  // удаляем D
        stack1.pop();  // удаляем C
        stack1.push('E');  // добавляем E
        System.out.println("После преобразования в ABE:");
        printStack(stack1);

        // Задача 2б: ABCG -> BG
        System.out.println("\nЗадача 2б: ABCG -> BG");
        Stack<Character> stack2 = new Stack<>();
        // Создаем начальный стек ABCG
        stack2.push('A');
        stack2.push('B');
        stack2.push('C');
        stack2.push('G');
        System.out.println("Начальный стек ABCG:");
        printStack(stack2);

        // Преобразуем в BG
        stack2.pop();  // удаляем G
        stack2.pop();  // удаляем C
        stack2.pop();  // удаляем B
        stack2.pop();  // удаляем A
        stack2.push('B');  // добавляем B
        stack2.push('G');  // добавляем G
        System.out.println("После преобразования в BG:");
        printStack(stack2);

        // Задача 3: Переворот стека
        System.out.println("\nЗадача 3: Переворот стека");
        Stack<Character> stack3 = new Stack<>();
        stack3.push('A');
        stack3.push('B');
        stack3.push('C');
        stack3.push('D');
        System.out.println("Начальный стек ABCD:");
        printStack(stack3);

        // Присваиваем результат переворота
        stack3 = reverseStack(stack3);
        
        System.out.println("Стек после переворота DCBA:");
        printStack(stack3);
    }

    public static void printStack(Stack<Character> stack) {
        // Создаем временный стек для хранения элементов
        Stack<Character> tempStack = new Stack<Character>();

        System.out.println("Содержимое стека (сверху вниз):");

        // Перекладываем и печатаем элементы
        while (!stack.isEmpty()) {
            Character element = stack.pop();
            System.out.println(element);
            tempStack.push(element);
        }

        // Возвращаем элементы обратно
        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }
    }

    // Упрощенный метод для переворота стека
    public static Stack<Character> reverseStack(Stack<Character> stack) {
        Stack<Character> tempStack = new Stack<>();

        // Просто перекладываем все элементы во временный стек
        while (!stack.isEmpty()) {
            tempStack.push(stack.pop());
        }
        
        // Возвращаем перевернутый стек
        return tempStack;
    }
}
