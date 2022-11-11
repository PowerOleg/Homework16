import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        MagicBox<Integer> magicBoxInt = new MagicBox<Integer>(3);
        MagicBox<String> magicBoxString = new MagicBox<>(4);
        MagicBox<Boolean> magicBoxBool = new MagicBox<>(3);

        System.out.println(magicBoxInt.add(1));
        magicBoxInt.add(5);
        magicBoxInt.add(10);
        magicBoxInt.add(200);
        System.out.println(magicBoxInt.pick());
        System.out.println(magicBoxInt.pick());
        System.out.println();

        System.out.println(magicBoxString.add("1"));
        magicBoxString.add("Orange");
        magicBoxString.add("Purple");
        magicBoxString.add("Light green");
        System.out.println(magicBoxString.pick());
        System.out.println(magicBoxString.pick());
        System.out.println();

        System.out.println(magicBoxBool.add(false));
        magicBoxBool.add(true);
        System.out.println(magicBoxBool.pick());
        System.out.println(magicBoxBool.pick());
        System.out.println();
    }
}
