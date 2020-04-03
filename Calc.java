import java.util.Scanner;

import static java.lang.Integer.decode;
import static java.lang.Integer.parseInt;

public class Calc {

    private Scanner scan = new Scanner(System.in);

    private final char ARAB_FORMAT = 'A';
    private final char ROME_FORMAT = 'R';
    private int firstArg, secondArg;
    private char operation;
    private char format;

    public String request()
    {
        System.out.println("Введите выражение");
        String expres = scan.nextLine();
        String[] expres_mas = expres.split("(?!^)\\b");
        treatment(expres_mas);
        return calculate();
    }

    private void treatment(String[] expr){
        expr[0] = expr[0].trim();
        expr[1] = expr[1].trim();
        expr[2] = expr[2].trim();

        if ((expr.length == 3) && expr[1].matches("\\*|/|\\+|-"))
        {
            operation = expr[1].charAt(0);
            if (Roman.isRoman(expr[0]) && Roman.isRoman(expr[2])) {
                firstArg = Roman.romanToArabic(expr[0]);
                secondArg = Roman.romanToArabic(expr[2]);
                format = ROME_FORMAT;
            }else if (expr[0].matches("[1-9]|10")&& expr[2].matches("[1-9]|10")){
                firstArg = parseInt(expr[0]);
                secondArg = parseInt(expr[2]);
                format = ARAB_FORMAT;
            }else {
                throw new InputException("incorrect input");
            }
        } else {
            throw new InputException("incorrect input");
        }
    }

    private String calculate()
    {
        double result = 0;
        switch (operation)
        {
            case '+':
                result = firstArg+secondArg;
                break;
            case '-':
                result = firstArg-secondArg;
                break;
            case '*':
                result = firstArg*secondArg;
                break;
            case '/':
                result = (double) firstArg/secondArg;
                break;
        }
        if(format=='A'){
            return String.valueOf((int) result);
        } else {
            return String.valueOf((Roman.arabicToRoman((int) result)));
        }
    }
}
