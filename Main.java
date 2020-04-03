public class Main {
    public static void main(String[] args)
    {
        Calc calc = new Calc();
        String result = "";
        while (true)
        {
            result = calc.request();
            System.out.println(result);
        }
    }
}
