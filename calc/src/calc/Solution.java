package calc;

import java.util.Scanner;

public class Solution {
static Scanner scanner = new Scanner(System.in);
public static String romPat = "IVX";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	System.out.println("Введите выражение вида '1 + 1' или 'I + I'");
	String first = scanner.next();
    char operation = scanner.next().charAt(0);
    String second = scanner.next();
    int num1 = 0, num2 = 0;
    	if (romPat.indexOf(first.charAt(0)) != -1 && romPat.indexOf(second.charAt(0)) == -1 || romPat.indexOf(second.charAt(0)) != -1 && romPat.indexOf(first.charAt(0)) == -1 )
    		System.out.print("Введите корректные данные"); else {
    		if (romPat.indexOf(first.charAt(0)) != -1 ) {num1 = romanToArabic(first);}
    			else {num1 = Integer.parseInt(first);}
    		if (romPat.indexOf(second.charAt(0)) != -1 ) {num2 = romanToArabic(second);}
    			else {num2 = Integer.parseInt(second);} 
        	if (num1 < 0 || num1 > 10 || num2 < 0 || num2 > 10) { 
        		System.out.println("Ошибка! Введите число от 0 до 10.");}
        	else 
        		if (romPat.indexOf(first.charAt(0)) != -1 && romPat.indexOf(second.charAt(0)) != -1)
        		System.out.println("Результат операции: "+arabToRoman(calc(num1,num2,operation)));
        		else 
        		 System.out.println("Результат операции: "+calc(num1,num2,operation));}}

    private static int calc(int num1, int num2, char operation){
        int result;
        switch (operation){
            case '+':
                result = num1+num2;
                break;
            case '-':
                result = num1-num2;
                break;
            case '*':
                result = num1*num2;
                break;
            case '/':
                result = num1/num2;
                break;
            default:
                System.out.println("Операция не распознана. Повторите ввод.");
                result = calc(num1, num2, operation); //рекурсия
        }
        return result;
    }

    private static String arabToRoman(int num) {
    	String c[] = {"", "C"};
        String x[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String i[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        String hundereds = c[(num % 1000) / 100];
        String tens = x[(num % 100) / 10];
        String ones = i[num % 10];
        return hundereds+tens+ones;
    }
    
    private static int value(char r) {
        if (r == 'I')
            return 1;
        if (r == 'V')
            return 5;
        if (r == 'X')
            return 10;
        if (r == 'L')
            return 50;
        if (r == 'C')
            return 100;
        return -1;
    }
    
    private static int romanToArabic(String str) {
        int res = 0;
        for (int i = 0; i < str.length(); i++) {
            int s1 = value(str.charAt(i));
            if (i + 1 < str.length()) {
                int s2 = value(str.charAt(i + 1));
                if (s1 >= s2) {
                    res = res + s1;
                } else {
                    res = res + s2 - s1;
                    i++;
                }
            } else {
                res = res + s1;
                i++;
            }
        }
        return res;
    }
    
}
