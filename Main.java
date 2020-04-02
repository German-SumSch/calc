public class Main {
    public static void main(String[] args)
    {
        while (true)
        {
            Calc calc = new Calc();
            String result = calc.request();
            System.out.println(result);
        }
    }
}
