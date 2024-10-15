package 구현.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("클래스 이름: ");
        String className = scanner.nextLine(); // 구현.reflection.Greeting
        System.out.print("메서드 이름: ");
        String methodName = scanner.nextLine();// sayHello
        System.out.print("인자 값: ");
        String argument = scanner.nextLine(); // you want
        try {
            Class<?> aClass = Class.forName(className);
            Method sayHello = aClass.getMethod(methodName, String.class);
            Object world = sayHello.invoke(aClass.getDeclaredConstructor().newInstance(), argument);
            System.out.println(world.toString());
        } catch (ClassNotFoundException e) {
            System.out.println("클래스를 찾을 수 없습니다: " + e.getMessage());
        } catch (NoSuchMethodException e) {
            System.out.println("메서드를 찾을 수 없습니다: " + e.getMessage());
        } catch (InvocationTargetException e) {
            System.out.println("메서드 호출 중 예외 발생: " + e.getTargetException());
        } catch (IllegalAccessException | InstantiationException e) {
            System.out.println("인스턴스 생성 중 예외 발생: " + e.getMessage());
        }
    }
}

class Greeting {
    public Greeting() {
    }

    public String sayHello(String name) {
        return "Hello, " + name + "!";
    }
}
